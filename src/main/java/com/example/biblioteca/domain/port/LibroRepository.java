package com.example.biblioteca.domain.port;

import com.example.biblioteca.domain.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroRepository {
    Optional<Libro> buscarPorIsbn(String isbn);
    Libro guardar(Libro libro);
}
