package com.sabrina.bootcamp.services;

import com.sabrina.bootcamp.entities.Bootcamp;
import com.sabrina.bootcamp.entities.Desenvolvedores;
import com.sabrina.bootcamp.entities.utils.FilesGenerete;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Random;

public class GerandoCertificado extends FilesGenerete {


    public GerandoCertificado(String fileName) {
        super(fileName, "/certificado/desenvolvedor/");
    }
    public void writeContent(Bootcamp bootcamp, Desenvolvedores dev){
        Random random = new Random();
        Path path = Paths.get(actualDir + newDirectory + fileName);
        try (BufferedWriter bw = Files.newBufferedWriter(path, Charset.defaultCharset(), StandardOpenOption.CREATE)){
            bw.write("Certificamos que " + dev.getNome() );
            bw.newLine();
            bw.write("em " + LocalDate.now() + ", concluiu o bootcamp");
            bw.newLine();
            bw.write(bootcamp.getNome() + " " + bootcamp.getDescricao());
            bw.newLine();
            bw.write("com carga horaria de "+bootcamp.calcularCargaHoraria() + " horas");
            bw.newLine();
            bw.write("o total de XP obtido durante o bootCamp foi: " + dev.calcularTotalXp());
            bw.newLine();
            bw.write("com o total de " + dev.getConteudosFinalizados().size()+ " conteúdos finalizados");
            bw.newLine();
            bw.write("Código certificado:"+ random.nextInt(4));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
