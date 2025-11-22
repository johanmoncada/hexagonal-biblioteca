package com.example.biblioteca.infrastructure.notification;

import com.example.biblioteca.domain.Prestamo;
import com.example.biblioteca.domain.port.NotificacionBibliotecaPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ConsoleNotificacionBibliotecaAdapter implements NotificacionBibliotecaPort {

    private static final Logger log = LoggerFactory.getLogger(ConsoleNotificacionBibliotecaAdapter.class);

    @Override
    public void notificarPrestamo(Prestamo prestamo) {
        log.info("Notificación: préstamo creado {}", prestamo.getId());
    }

    @Override
    public void notificarVencimiento(Prestamo prestamo) {
        log.info("Notificación: préstamo vencido {}", prestamo.getId());
    }

    @Override
    public void notificarDevolucion(Prestamo prestamo) {
        log.info("Notificación: préstamo devuelto {}", prestamo.getId());
    }
}
