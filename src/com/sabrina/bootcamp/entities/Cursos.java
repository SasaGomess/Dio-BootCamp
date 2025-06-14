package com.sabrina.bootcamp.entities;

import java.util.DoubleSummaryStatistics;

public class Cursos implements Conteudos{
    private String titulo;
    private String descricao;
    private ModulosEnum modulosEnum;
    private int cargaHoraria;

    private static final double XP_CURSO = 20;

    public Cursos(String titulo, String descricao, ModulosEnum modulosEnum, int cargaHoraria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.modulosEnum = modulosEnum;
        this.cargaHoraria = cargaHoraria;
    }

    public Cursos() {

    }

    @Override
    public double calcularXp() {
        return XP_CURSO + 10;
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

    public ModulosEnum getModulosEnum() {
        return modulosEnum;
    }

    public void setModulosEnum(ModulosEnum modulosEnum) {
        this.modulosEnum = modulosEnum;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public String toString() {
        return "Cursos{" +
                "titulo= " + titulo +
                ", descricao= " + descricao  +
                ", modulosEnum=" + modulosEnum.getModulos() +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
