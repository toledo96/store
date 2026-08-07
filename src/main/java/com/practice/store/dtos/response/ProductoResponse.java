package com.practice.store.dtos.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponse {
    private String nombre;
    private Integer stock;
    private BigDecimal precioUnitario;
}
