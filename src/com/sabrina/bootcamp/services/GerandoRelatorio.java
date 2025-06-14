package com.sabrina.bootcamp.services;

import com.sabrina.bootcamp.entities.Bootcamp;
import com.sabrina.bootcamp.entities.Conteudos;
import com.sabrina.bootcamp.entities.Cursos;
import com.sabrina.bootcamp.entities.Desenvolvedores;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GerandoRelatorio {
    private final String actualDir = System.getProperty("user.dir");
    private String fileName;
    private final String newDirectory = "/relatorio/bootcamp/";

    public GerandoRelatorio( String fileName) {
        this.fileName = fileName;
    }

    public void createDirectory() throws IOException {
        File path = new File(actualDir + newDirectory);
        if (!path.exists() && !path.mkdirs()) throw new IOException();

        createFile();
    }
    public void createFile(){
        try (OutputStream outputStream = new FileOutputStream(actualDir + newDirectory + fileName)){
            System.out.printf("File created with sucess (%s)", actualDir + newDirectory + fileName);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void writeContente(Bootcamp content){
        Path path = Paths.get(actualDir + newDirectory+ fileName);
        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardOpenOption.CREATE)){
            bw.write(content.getNome());
            bw.newLine();
            bw.write(content.getDescricao());
            bw.newLine();
            String desenvolvedores = content.getDesenvolvedores().stream().map(Desenvolvedores::getNome).collect(Collectors.joining(", "));
            bw.write("Desenvolvedores inscritos: "+ desenvolvedores);
            bw.newLine();
            bw.write("Conteudos: " + String.join(", ", content.listarTodosConteudos()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
