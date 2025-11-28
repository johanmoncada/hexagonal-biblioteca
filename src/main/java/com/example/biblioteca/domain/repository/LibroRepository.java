package com.example.biblioteca.domain.repository;

import com.example.biblioteca.domain.entity.Libro;

import java.util.Optional;

public interface LibroRepository {
    Optional<Libro> buscarPorIsbn(String isbn);
    Libro guardar(Libro libro);
}
