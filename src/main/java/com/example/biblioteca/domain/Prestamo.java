package com.example.biblioteca.domain;

import java.time.LocalDate;

public class Prestamo {
    private final String id;
    private final String usuarioId;
    private final String isbn;
    private final LocalDate fechaPrestamo;
    private final LocalDate fechaMaxDevolucion;
    private final EstadoPrestamo estado;

    public Prestamo(String id, String usuarioId, String isbn, LocalDate fechaPrestamo, LocalDate fechaMaxDevolucion, EstadoPrestamo estado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.isbn = isbn;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaMaxDevolucion = fechaMaxDevolucion;
        this.estado = estado;
    }

    public String getId() { return id; }
    public String getUsuarioId() { return usuarioId; }
    public String getIsbn() { return isbn; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public LocalDate getFechaMaxDevolucion() { return fechaMaxDevolucion; }
    public EstadoPrestamo getEstado() { return estado; }

    public Prestamo marcarVencido() {
        return new Prestamo(id, usuarioId, isbn, fechaPrestamo, fechaMaxDevolucion, EstadoPrestamo.VENCIDO);
    }

    public Prestamo cerrar() {
        return new Prestamo(id, usuarioId, isbn, fechaPrestamo, fechaMaxDevolucion, EstadoPrestamo.CERRADO);
    }
}
