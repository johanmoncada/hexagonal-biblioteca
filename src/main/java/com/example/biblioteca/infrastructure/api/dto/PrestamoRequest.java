package com.example.biblioteca.infrastructure.api.dto;

import jakarta.validation.constraints.NotBlank;

public class PrestamoRequest {

    @NotBlank
    private String usuarioId;

    @NotBlank
    private String isbn;

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
}
