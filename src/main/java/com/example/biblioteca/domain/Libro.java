package com.example.biblioteca.domain;

public class Libro {
    private final String isbn;
    private final String titulo;
    private final String autor;
    private final int ejemplaresTotales;
    private final int ejemplaresDisponibles;

    public Libro(String isbn, String titulo, String autor, int ejemplaresTotales, int ejemplaresDisponibles) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplaresTotales = ejemplaresTotales;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getEjemplaresTotales() { return ejemplaresTotales; }
    public int getEjemplaresDisponibles() { return ejemplaresDisponibles; }

    public Libro prestar() {
        if (ejemplaresDisponibles <= 0) {
            throw new IllegalStateException("No hay ejemplares disponibles");
        }
        return new Libro(isbn, titulo, autor, ejemplaresTotales, ejemplaresDisponibles - 1);
    }

    public Libro devolver() {
        if (ejemplaresDisponibles >= ejemplaresTotales) {
            return this;
        }
        return new Libro(isbn, titulo, autor, ejemplaresTotales, ejemplaresDisponibles + 1);
    }
}
