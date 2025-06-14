package com.sabrina.bootcamp.entities;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;


public class Desenvolvedores {
    private static int value = 1;
    private final BigDecimal id = BigDecimal.valueOf(value++);
    private String nome;
    private Set<Conteudos> conteudosIncritos = new LinkedHashSet<>();
    private Set<Conteudos> conteudosFinalizados = new LinkedHashSet<>();

    public Desenvolvedores(String nome) {
        this.nome = nome;
    }

    public Desenvolvedores() {
    }

    public void seIncreverNoBootCamp(Bootcamp bootcamp){
        this.conteudosIncritos.addAll(bootcamp.getConteudos());
        bootcamp.getDesenvolvedores().add(this);
    }

    public void progredir(){
        Optional<Conteudos> conteudos = this.conteudosIncritos.stream().findFirst();
        conteudos.ifPresent(value -> this.conteudosIncritos.remove(value));
        conteudos.ifPresent(value -> this.conteudosFinalizados.add(value));
    }

    public void listarCursosEmAndamento(){
        System.out.println("cursos do(a) ->> "+this.nome );
        conteudosIncritos.stream().filter(c -> c instanceof Cursos).map(p -> ((Cursos) p).getTitulo()).forEach(s -> System.out.println("Cursos = "+s));
    }

    public void listarMentoriasRealizadas(){
        System.out.println("mentorias do(a) ->> "+this.nome );
        conteudosIncritos.stream().filter(c -> c instanceof Mentorias ).forEach(s -> System.out.println("Mentoria = "+((Mentorias) s).getMentor() + " ->> " + ((Mentorias) s).getTitulo()));
    }

    public double calcularTotalXp(){
        return conteudosFinalizados.stream().mapToDouble(Conteudos::calcularXp).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudos> getConteudosIncritos() {
        return conteudosIncritos;
    }

    public void setConteudosIncritos(Set<Conteudos> conteudosIncritos) {
        this.conteudosIncritos = conteudosIncritos;
    }

    public Set<Conteudos> getConteudosFinalizados() {
        return conteudosFinalizados;
    }

    public void setConteudosFinalizados(Set<Conteudos> conteudosFinalizados) {
        this.conteudosFinalizados = conteudosFinalizados;
    }

    @Override
    public String toString() {
        return "Desenvolvedores{" +
                "nome='" + nome + '\'' +
                ", conteudosIncritos=" + conteudosIncritos +
                ", conteudosFinalizados=" + conteudosFinalizados +
                '}';
    }
}
