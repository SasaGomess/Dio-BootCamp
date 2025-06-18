package com.sabrina.bootcamp.view;

import com.sabrina.bootcamp.entities.*;
import com.sabrina.bootcamp.entities.utils.FilesGenerete;
import com.sabrina.bootcamp.services.GerandoCertificado;
import com.sabrina.bootcamp.services.GerandoRelatorio;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) throws IOException {


        Bootcamp bootcamp1 = new Bootcamp("BootCamp TONNIE ", "Java and AI in Europe");
        System.out.println(bootcamp1.getNome() + " - " + bootcamp1.getDataInicial());
        Desenvolvedores dev = new Desenvolvedores("Maria Gomes");
        Desenvolvedores dev1 = new Desenvolvedores("Julia Marina");
        System.out.println();

        Cursos c1 = new Cursos("Principios da programação Java", "Orientação a Objetos", ModulosEnum.ORIENTACAO_OBJETOS, 40);
        Cursos c2 = new Cursos("Banco de dados SQL", "Banco de dados Relacionais", ModulosEnum.BANCO_DE_DADOS, 12);
        Cursos c3 = new Cursos("Banco de dados MongoDB", "Banco de dados NoSQL", ModulosEnum.BANCO_DE_DADOS, 4);
        Cursos c4 = new Cursos("Aplicações com Spring Boot", "Desenvolvimento de Apis Rest", ModulosEnum.SPRING_BOOT, 50);
        Cursos c5 = new Cursos("Design Patterns em Java", "Aplicando design Patterns", ModulosEnum.SPRING_BOOT, 50);
        Cursos c6 = new Cursos("Computação em Nuvem", "Serviços AWS ", ModulosEnum.CLOUD, 15);
        Cursos c7 = new Cursos("Processos com Devops", "Intrução ao Docker", ModulosEnum.DEVOPS, 9);
        Mentorias m1 = new Mentorias("Programação", "Mentoria para devs", "Rodrigo Sampaio", LocalDate.of(2025, Month.JUNE, 11));
        Mentorias m2 = new Mentorias("Devops", "Mentoria para devops", "Jaqueline Viera", LocalDate.of(2025, Month.MAY, 15));
        Mentorias m3 = new Mentorias("IA", "Mentoria engenheiros de prompt", "Joao Lacerda", LocalDate.of(2025, Month.JUNE, 12));
        Mentorias m4 = new Mentorias("Banco de dados", "Mentoria para DBAs", "Juliana Rodriguez", LocalDate.of(2025, Month.MAY, 1));

        bootcamp1.addConteudos(c1);
        bootcamp1.addConteudos(c2);
        bootcamp1.addConteudos(c3);
        bootcamp1.addConteudos(c4);
        bootcamp1.addConteudos(c5);
        bootcamp1.addConteudos(c6);
        bootcamp1.addConteudos(c7);


        bootcamp1.addConteudos(m1);
        bootcamp1.addConteudos(m2);
        bootcamp1.addConteudos(m3);
        bootcamp1.addConteudos(m4);

        dev.seIncreverNoBootCamp(bootcamp1);
        dev1.seIncreverNoBootCamp(bootcamp1);

        dev1.listarCursosEmAndamento();
        System.out.println();
        dev.listarCursosEmAndamento();

        dev.progredir();
        dev.progredir();
        System.out.println();
        dev.listarCursosEmAndamento();

        System.out.println();
        dev1.progredir();
        dev1.progredir();
        dev1.progredir();

        dev1.listarCursosEmAndamento();
        System.out.println();
        bootcamp1.DesenvolvedoresBootcampCursosEmAndamento();

        System.out.println("========================================");

        dev1.progredir();
        dev.progredir();
        dev.progredir();
        dev.progredir();
        System.out.println();
        bootcamp1.DesenvolvedoresBootcampCursosEmAndamento();
        System.out.println();

        System.out.println("Carga horaria total dos cursos e mentorias: "+bootcamp1.calcularCargaHoraria());
        System.out.println();

        dev.listarMentoriasRealizadas();
        System.out.println();
        dev1.listarMentoriasRealizadas();
        bootcamp1.qtdCursosFinalizadosPorDesenvolvedor();
        System.out.println();

        System.out.println(dev1.getNome() + ", Pontos XP: "+ dev1.calcularTotalXp());
        System.out.println(dev.getNome()+ ", Pontos XP: "+dev.calcularTotalXp());
        System.out.println();
        System.out.println(dev1);
        System.out.println(dev);
        bootcamp1.situacaoAtualDesenvolvedores("Conteudos finalizados").ifPresent(System.out::println);
        bootcamp1.situacaoAtualDesenvolvedores("Conteudos inscritos").ifPresent(System.out::println);
        System.out.println();
        dev1.progredir();
        dev1.progredir();
        dev1.progredir();
        dev1.progredir();
        dev1.progredir();
        dev1.progredir();
        dev1.progredir();
        dev1.progredir();
        double valorFinalizado = dev1.calcularTotalXp();

        System.out.println();

        bootcamp1.qtdCursosFinalizadosPorDesenvolvedor();
        bootcamp1.DesenvolvedoresBootcampCursosEmAndamento();

        System.out.println();
        System.out.println(bootcamp1.infoDesenvolvedoresCurso());
        dev.bootCampFinalizado().ifPresent(System.out::println);
        dev1.bootCampFinalizado().ifPresent(System.out::println);
        System.out.println("==============================");

        GerandoRelatorio gerandoRelatorio = new GerandoRelatorio("relatorio.txt");
        gerandoRelatorio.createDirectory();
        gerandoRelatorio.createFile();
        gerandoRelatorio.writeContent(bootcamp1);

        System.out.println("==============================");
        GerandoCertificado certificado = new GerandoCertificado("certificado.txt");
        certificado.createDirectory();
        certificado.createFile();

        if (bootcamp1.verificandoSeFinalizado().isPresent()){
            Desenvolvedores devEscrita = bootcamp1.verificandoSeFinalizado().get();
            System.out.println();
            System.out.println("Gerando certificado do desenvolvedor(a) "+ devEscrita.getNome() + "...");
            certificado.writeContent(bootcamp1, devEscrita);
        }
    }
}