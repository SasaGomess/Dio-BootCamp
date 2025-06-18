package com.sabrina.bootcamp.entities;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.time.Month.MAY;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.of(2025, MAY, 20);
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<Desenvolvedores> desenvolvedores = new HashSet<>();
    private Set<Conteudos> conteudos = new LinkedHashSet<>();

    public Bootcamp(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Bootcamp() {
    }

    public Set<Conteudos> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<Conteudos> conteudos) {
        this.conteudos = conteudos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void addConteudos(Conteudos conteudo){
        conteudos.add(conteudo);
    }

    public Set<Desenvolvedores> getDesenvolvedores() {
        return desenvolvedores;
    }

    private void checkIfItIsNull() {
        try {
            if (desenvolvedores.isEmpty() || conteudos.isEmpty()) {
                throw new IllegalStateException("A lista esta vazia ou o bootcamp ainda nao foi inicializado");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
    public String desenvolvedoresDoCurso(){
        return desenvolvedores.stream().map(Desenvolvedores::getNome).collect(Collectors.joining(", "));
    }
    public void DesenvolvedoresBootcampCursosEmAndamento() {
        checkIfItIsNull();
        desenvolvedores.stream().collect(Collectors.groupingBy(Desenvolvedores::getNome, Collectors.summingInt(c -> c.getConteudosIncritos().size()))).forEach((s1, s2) -> System.out.println(s1 + " qtd_cursos_em_andamento: " + s2));
    }

    public String listarTodosConteudos() {
        checkIfItIsNull();
        return conteudos.stream().map(Conteudos::getTitulo).collect(Collectors.joining(" "));
    }
    public String listandoMentores(){
        String stringMentores = conteudos
                .stream()
                .filter(c -> c instanceof Mentorias)
                .map(c -> ((Mentorias) c)
                        .getMentor())
                            .collect(Collectors.joining(", "));
        String stringMentorias =  conteudos
                .stream()
                .map(Conteudos::getTitulo)
                .collect(Collectors.joining(" - " ));
        return "Mentores ->> " +stringMentores + " - Mentorias ->> " + stringMentorias;
    }
    public int calcularCargaHoraria(){
        checkIfItIsNull();
        return conteudos.stream().mapToInt(c -> {
            int cargaDeHoras = 0;
            if (c instanceof Cursos){
               cargaDeHoras = ((Cursos) c).getCargaHoraria();
            } else if (c instanceof Mentorias) {
                cargaDeHoras = ((Mentorias) c).getDatas().getDayOfMonth();
            }
            return cargaDeHoras;
        }).sum();
    }
    public Optional<IntSummaryStatistics> situacaoAtualDesenvolvedores(String conteudo){
        checkIfItIsNull();
        if (conteudo.trim().equalsIgnoreCase("Conteudos finalizados")){
            return Optional.of(desenvolvedores.stream().collect(Collectors.summarizingInt(d -> d.getConteudosFinalizados().size())));
        }else if (conteudo.trim().equalsIgnoreCase("Conteudos inscritos")){
            return Optional.of(desenvolvedores.stream().collect(Collectors.summarizingInt(d -> d.getConteudosIncritos().size())));
        }else {
            return Optional.empty();
        }
    }
    public Optional<Desenvolvedores> verificandoSeFinalizado(){
        return desenvolvedores.stream().filter(s ->s.bootCampFinalizado().isPresent()).findFirst();
    }
    public String infoDesenvolvedoresCurso(){
        checkIfItIsNull();
        return desenvolvedores.stream().collect(Collectors.teeing(Collectors.maxBy(Comparator
                        .comparing(d -> d.getConteudosIncritos().size())),
                Collectors.maxBy(Comparator.comparing(d -> d.getConteudosFinalizados().size())),
                (d, t) -> {
                    String ini = d.map(Desenvolvedores::getNome).orElse("n/a");
                    String fin = t.map(Desenvolvedores::getNome).orElse("n/a");
                    int qtdInici = d.map(d2 -> d2.getConteudosIncritos().size()).orElse(0);
                    int qtdFin = t.map(d1 -> d1.getConteudosFinalizados().size()).orElse(0);

                    return "Desenvolvedores inscritos em mais cursos inscritos: " + ini + " = " +qtdInici + ", Desenvolvedores com mais cursos finalizados: " + fin+ " = " + qtdFin;
                }));
    }
    public void qtdCursosFinalizadosPorDesenvolvedor(){
        checkIfItIsNull();
        desenvolvedores.stream().collect(Collectors.groupingBy(Desenvolvedores::getNome, Collectors.summingInt(d -> d.getConteudosFinalizados().size()))).forEach((d, s) -> System.out.println(d +" qtd_cursos_finalizados ->> " + s));
    }
    @Override
    public String toString() {
        return "Bootcamp{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", desenvolvedores=" + desenvolvedores +
                ", conteudos=" + conteudos +
                '}';
    }
}
