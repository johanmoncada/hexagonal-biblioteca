package com.example.biblioteca.domain.repository;

import com.example.biblioteca.domain.entity.Prestamo;

import java.util.List;
import java.util.Optional;

public interface PrestamoRepository {
    Prestamo guardar(Prestamo prestamo);
    Optional<Prestamo> buscarPorId(String id);
    List<Prestamo> buscarPorUsuario(String usuarioId);
}
