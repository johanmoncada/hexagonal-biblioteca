package com.example.biblioteca.infrastructure.repository;

import com.example.biblioteca.domain.entity.Libro;
import com.example.biblioteca.domain.repository.LibroRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class InMemoryLibroRepository implements LibroRepository {

    private final Map<String, Libro> data = new HashMap<>();

    @PostConstruct
    public void init() {
        data.put("978-1", new Libro("978-1", "Arquitectura de Software Moderna", "Autor X", 3, 3));
        data.put("978-2", new Libro("978-2", "Microservicios Prácticos", "Autor Y", 2, 2));
    }

    @Override
    public Optional<Libro> buscarPorIsbn(String isbn) {
        return Optional.ofNullable(data.get(isbn));
    }

  @Override
    public Libro guardar(Libro libro) {
        data.put(libro.getIsbn(), libro);
        return libro;
    }
}
