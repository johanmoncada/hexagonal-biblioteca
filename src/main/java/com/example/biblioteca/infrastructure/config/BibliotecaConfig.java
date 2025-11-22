package com.example.biblioteca.infrastructure.config;

import com.example.biblioteca.application.PrestamoUseCase;
import com.example.biblioteca.domain.port.LibroRepository;
import com.example.biblioteca.domain.port.NotificacionBibliotecaPort;
import com.example.biblioteca.domain.port.PrestamoRepository;
import com.example.biblioteca.domain.service.GestionPrestamosService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BibliotecaConfig {

    @Bean
    public GestionPrestamosService gestionPrestamosService(LibroRepository libroRepository,
                                                           PrestamoRepository prestamoRepository,
                                                           NotificacionBibliotecaPort notificacionPort) {
        return new GestionPrestamosService(libroRepository, prestamoRepository, notificacionPort);
    }

    @Bean
    public PrestamoUseCase prestamoUseCase(GestionPrestamosService service) {
        return new PrestamoUseCase(service);
    }
}
