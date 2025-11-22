package com.example.biblioteca.domain;

public class UsuarioBiblioteca {
    private final String id;
    private final String nombre;
    private final String tipo;

    public UsuarioBiblioteca(String id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
}
