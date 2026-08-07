package com.practice.store.dtos.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoRequest {

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String nombre;

    @Min(value = 1, message = "El stock del producto debe ser mayor a 0")
    private Integer stock;

    @DecimalMin(value = "0.01", message = "El precio unitario del producto debe ser mayor a 0")
    private BigDecimal precioUnitario;

    @NotBlank(message = "El campo img no puede estar vacío")
    private String img;

    @NotBlank(message = "El SKU del producto no puede estar vacío")
    private String sku;
}
