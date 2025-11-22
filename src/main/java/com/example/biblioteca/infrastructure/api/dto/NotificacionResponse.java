package com.example.biblioteca.infrastructure.api.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificacionResponse {
  private String estado;
  private String prestamoId;
}
