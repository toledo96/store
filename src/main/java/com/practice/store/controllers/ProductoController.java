package com.practice.store.controllers;

import com.practice.store.dtos.request.ProductoRequest;
import com.practice.store.dtos.response.ProductoResponse;
import com.practice.store.services.impl.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoResponse> createProducto(@Valid @RequestBody ProductoRequest producto) {
        return ResponseEntity.ok(productoService.crearProducto(producto));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProductoResponse> updateProducto(@Valid @PathVariable Long id, @RequestBody ProductoRequest producto) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, producto));
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> getAllProductos() {
        return ResponseEntity.ok(productoService.getAllProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> getProductoById(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.getProductoById(id));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

}
