package com.example.biblioteca.domain.port;

import com.example.biblioteca.domain.Prestamo;

public interface NotificacionBibliotecaPort {
    void notificarPrestamo(Prestamo prestamo);
    void notificarVencimiento(Prestamo prestamo);
    void notificarDevolucion(Prestamo prestamo);
}
