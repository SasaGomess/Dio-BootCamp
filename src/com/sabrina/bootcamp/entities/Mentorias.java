package com.sabrina.bootcamp.entities;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;

public class Mentorias implements Conteudos {
    private String titulo;
    private String descricao;
    private String mentor;
    private LocalDate datas;

    private static final double XP_MENTORIA = 10;

    public Mentorias(String titulo, String descricao, String mentor, LocalDate dataInicio) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.mentor = mentor;
        this.datas = dataInicio;
    }

    @Override
    public double calcularXp() {
        return XP_MENTORIA + 10;
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

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public LocalDate getDatas() {
        return datas;
    }

    public void setDatas(LocalDate datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "Mentorias{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", mentor='" + mentor + '\'' +
                ", datas=" + datas +
                '}';
    }
}
