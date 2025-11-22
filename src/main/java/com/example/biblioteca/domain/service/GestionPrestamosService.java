package com.example.biblioteca.domain.service;

import com.example.biblioteca.domain.*;
import com.example.biblioteca.domain.port.LibroRepository;
import com.example.biblioteca.domain.port.NotificacionBibliotecaPort;
import com.example.biblioteca.domain.port.PrestamoRepository;

import java.time.LocalDate;
import java.util.UUID;

public class GestionPrestamosService {

    private final LibroRepository libroRepository;
    private final PrestamoRepository prestamoRepository;
    private final NotificacionBibliotecaPort notificacionPort;

    public GestionPrestamosService(LibroRepository libroRepository, PrestamoRepository prestamoRepository, NotificacionBibliotecaPort notificacionPort) {
        this.libroRepository = libroRepository;
        this.prestamoRepository = prestamoRepository;
        this.notificacionPort = notificacionPort;
    }

    public Prestamo prestar(String usuarioId, String isbn) {
        Libro libro = libroRepository.buscarPorIsbn(isbn)
                .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado"));
        Libro actualizado = libro.prestar();
        libroRepository.guardar(actualizado);

        Prestamo prestamo = new Prestamo(
                UUID.randomUUID().toString(),
                usuarioId,
                isbn,
                LocalDate.now(),
                LocalDate.now().plusDays(8),
                EstadoPrestamo.ACTIVO
        );

        Prestamo guardado = prestamoRepository.guardar(prestamo);
        notificacionPort.notificarPrestamo(guardado);
        return guardado;
    }

    public Prestamo devolver(String prestamoId) {
        Prestamo prestamo = prestamoRepository.buscarPorId(prestamoId)
                .orElseThrow(() -> new IllegalArgumentException("Préstamo no encontrado"));

        Prestamo cerrado = prestamo.cerrar();
        Prestamo guardado = prestamoRepository.guardar(cerrado);
        notificacionPort.notificarDevolucion(guardado);

        libroRepository.buscarPorIsbn(prestamo.getIsbn())
                .ifPresent(libro -> libroRepository.guardar(libro.devolver()));

        return guardado;
    }

    public Libro buscarPorIsbn(String isbn) {
      return libroRepository.buscarPorIsbn(isbn)
          .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado"));
    }

    public void notificarVencimiento(String prestamoId) {
      Prestamo prestamo = prestamoRepository.buscarPorId(prestamoId)
          .orElseThrow(() -> new IllegalArgumentException("Préstamo no encontrado"));
      notificacionPort.notificarVencimiento(prestamo);
    }
}
