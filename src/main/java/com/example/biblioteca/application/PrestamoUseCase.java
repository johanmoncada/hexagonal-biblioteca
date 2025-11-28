package com.example.biblioteca.application;

import com.example.biblioteca.domain.entity.Libro;
import com.example.biblioteca.domain.entity.Prestamo;
import com.example.biblioteca.domain.service.GestionPrestamosService;

public class PrestamoUseCase {

    private final GestionPrestamosService service;

    public PrestamoUseCase(GestionPrestamosService service) {
        this.service = service;
    }

    public Prestamo prestar(String usuarioId, String isbn) {
        return service.prestar(usuarioId, isbn);
    }

    public Prestamo devolver(String prestamoId) {
        return service.devolver(prestamoId);
    }

    public Libro buscarPorIsbn(String isbn) {
      return service.buscarPorIsbn(isbn);
    }

  public void notificarVencimiento(String prestamoId) {
    service.notificarVencimiento(prestamoId);
  }
}
