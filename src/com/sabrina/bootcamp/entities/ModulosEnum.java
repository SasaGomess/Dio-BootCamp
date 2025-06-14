package com.sabrina.bootcamp.entities;

public enum ModulosEnum {
    BANCO_DE_DADOS("Banco de Dados"),
    SPRING_BOOT("Spring Boot"),
    ORIENTACAO_OBJETOS("Orientação a Objetos"),
    DEVOPS("Devops"),
    CLOUD("Cloud");

    private String modulos;

    ModulosEnum(String modulos) {
        this.modulos = modulos;
    }

    public String getModulos() {
        return modulos;
    }

    public void setModulos(String modulos) {
        this.modulos = modulos;
    }
}
