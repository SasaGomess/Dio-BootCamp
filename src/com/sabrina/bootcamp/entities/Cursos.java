package com.sabrina.bootcamp.entities;

import java.util.DoubleSummaryStatistics;

public class Cursos extends Conteudos{

    private ModulosEnum modulosEnum;
    private int cargaHoraria;

    private static final double XP_CURSO = 20;

    public Cursos(String titulo, String descricao, ModulosEnum modulosEnum, int cargaHoraria) {
        super(titulo, descricao);
        this.modulosEnum = modulosEnum;
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularXp() {
        return XP_CURSO + 10;
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
