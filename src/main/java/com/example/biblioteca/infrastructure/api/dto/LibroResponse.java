package com.example.biblioteca.infrastructure.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LibroResponse {
  private String isbn;
  private String titulo;
  private String autor;
  private int ejemplaresTotales;
  private int ejemplaresDisponibles;
}
