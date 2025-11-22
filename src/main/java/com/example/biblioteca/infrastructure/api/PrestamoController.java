package com.example.biblioteca.infrastructure.api;

import com.example.biblioteca.application.PrestamoUseCase;
import com.example.biblioteca.domain.Libro;
import com.example.biblioteca.domain.Prestamo;
import com.example.biblioteca.infrastructure.api.dto.LibroResponse;
import com.example.biblioteca.infrastructure.api.dto.NotificacionResponse;
import com.example.biblioteca.infrastructure.api.dto.PrestamoRequest;
import com.example.biblioteca.infrastructure.api.dto.PrestamoResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoUseCase useCase;

    public PrestamoController(PrestamoUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<PrestamoResponse> prestar(@Valid @RequestBody PrestamoRequest request) {
        Prestamo p = useCase.prestar(request.getUsuarioId(), request.getIsbn());
        return ResponseEntity.ok(new PrestamoResponse(
                p.getId(), p.getUsuarioId(), p.getIsbn(),
                p.getFechaPrestamo(), p.getFechaMaxDevolucion(), p.getEstado().name()
        ));
    }

    @PostMapping("/{id}/devolver")
    public ResponseEntity<PrestamoResponse> devolver(@PathVariable String id) {
        Prestamo p = useCase.devolver(id);
        return ResponseEntity.ok(new PrestamoResponse(
                p.getId(), p.getUsuarioId(), p.getIsbn(),
                p.getFechaPrestamo(), p.getFechaMaxDevolucion(), p.getEstado().name()
        ));
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<LibroResponse> buscarPorIsbn(@PathVariable String isbn) {
      Libro l = useCase.buscarPorIsbn(isbn);
      return ResponseEntity.ok(
          LibroResponse.builder()
              .isbn(l.getIsbn())
              .titulo(l.getTitulo())
              .autor(l.getAutor())
              .ejemplaresDisponibles(l.getEjemplaresDisponibles())
              .ejemplaresTotales(l.getEjemplaresTotales())
              .build()
      );
    }

    @GetMapping("/notificacion/{prestamoId}")
  public ResponseEntity<NotificacionResponse> notificarVencimiento(@PathVariable String prestamoId) {
      useCase.notificarVencimiento(prestamoId);
      return ResponseEntity.ok(NotificacionResponse.builder()
              .estado("Notificado")
              .prestamoId(prestamoId)
          .build());
    }
}
