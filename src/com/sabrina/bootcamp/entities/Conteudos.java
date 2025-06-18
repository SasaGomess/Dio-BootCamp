package com.sabrina.bootcamp.entities;

public abstract class Conteudos {
    protected String titulo;
    protected String descricao;

    public Conteudos(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Conteudos() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    abstract double calcularXp();
}
