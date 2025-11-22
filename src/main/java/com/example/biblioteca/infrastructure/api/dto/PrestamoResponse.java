package com.example.biblioteca.infrastructure.api.dto;

import java.time.LocalDate;

public class PrestamoResponse {
    private String id;
    private String usuarioId;
    private String isbn;
    private LocalDate fechaPrestamo;
    private LocalDate fechaMaxDevolucion;
    private String estado;

    public PrestamoResponse(String id, String usuarioId, String isbn, LocalDate fechaPrestamo, LocalDate fechaMaxDevolucion, String estado) {
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
    public String getEstado() { return estado; }
}
