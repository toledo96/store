package com.practice.store.services.impl;

import com.practice.store.dtos.request.ProductoRequest;
import com.practice.store.dtos.response.ProductoResponse;

import java.util.List;

public interface ProductoService {

    ProductoResponse crearProducto(ProductoRequest productoRequest);

    ProductoResponse actualizarProducto(Long id,ProductoRequest productoRequest);

    ProductoResponse getProductoById(Long id);

    List<ProductoResponse> getAllProductos();

    void eliminarProducto(Long id);

}
