package com.sabrina.bootcamp.services;

import com.sabrina.bootcamp.entities.Bootcamp;
import com.sabrina.bootcamp.entities.Desenvolvedores;
import com.sabrina.bootcamp.entities.utils.FilesGenerete;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class GerandoRelatorio extends FilesGenerete {

    public GerandoRelatorio(String fileName) {
        super(fileName, "/relatorio/bootcamp/");
    }

    public void writeContent(Bootcamp content){
        Path path = Paths.get(actualDir + newDirectory+ fileName);
        try (BufferedWriter bw = Files.newBufferedWriter(path, Charset.defaultCharset(), StandardOpenOption.CREATE)){
            bw.write(content.getNome() + " - " + content.getDataInicial() + ", até: " + content.getDataFinal());
            bw.newLine();
            bw.write(content.getDescricao());
            bw.newLine();
            bw.write("Desenvolvedores inscritos: "+ content.desenvolvedoresDoCurso());
            bw.newLine();
            bw.write("Conteudos: " + String.join(", ", content.listarTodosConteudos()));
            bw.newLine();
            bw.write(content.listandoMentores());
            bw.newLine();
            bw.write("Carga horaria total de todos os cursos e mentorias: "+content.calcularCargaHoraria() + "Hs");
            bw.newLine();
            bw.write(""+ content.situacaoAtualDesenvolvedores("Conteudos Finalizados").orElseGet(IntSummaryStatistics::new));
            bw.newLine();
            bw.write(content.infoDesenvolvedoresCurso());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
