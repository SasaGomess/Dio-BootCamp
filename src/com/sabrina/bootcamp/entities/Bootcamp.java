package com.sabrina.bootcamp.entities;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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

    public void listarTodosDesenvolvedoresInscritosNoBootcamp() {
        checkIfItIsNull();
        desenvolvedores.stream().collect(Collectors.groupingBy(Desenvolvedores::getNome, Collectors.summingInt(c -> c.getConteudosIncritos().size()))).forEach((s1, s2) -> System.out.println(s1 + " qtd_cursos_em_andamento: " + s2));
    }
    public List<String> listarTodosConteudos() {
        checkIfItIsNull();
        List<String> conteudosTitulo = new ArrayList<>();
        for (Conteudos c: conteudos){
            if (c instanceof Cursos){
                conteudosTitulo.add(((Cursos)c).getTitulo());
            } else if (c instanceof Mentorias) {
                conteudosTitulo.add((((Mentorias) c).getTitulo()));
            }
        }
        return conteudosTitulo;
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
