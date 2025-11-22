package com.example.biblioteca.infrastructure.repository;

import com.example.biblioteca.domain.Prestamo;
import com.example.biblioteca.domain.port.PrestamoRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class InMemoryPrestamoRepository implements PrestamoRepository {

    private final Map<String, Prestamo> data = new HashMap<>();

    @Override
    public Prestamo guardar(Prestamo prestamo) {
        data.put(prestamo.getId(), prestamo);
        return prestamo;
    }

    @Override
    public Optional<Prestamo> buscarPorId(String id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public List<Prestamo> buscarPorUsuario(String usuarioId) {
        return data.values().stream()
                .filter(p -> p.getUsuarioId().equals(usuarioId))
                .collect(Collectors.toList());
    }
}
