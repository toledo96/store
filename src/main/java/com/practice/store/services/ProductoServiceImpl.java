package com.practice.store.services;

import com.practice.store.dtos.request.ProductoRequest;
import com.practice.store.dtos.response.ProductoResponse;
import com.practice.store.entities.Producto;
import com.practice.store.exceptions.producto.ProductoNoEncontradoException;
import com.practice.store.repositories.ProductoRepository;
import com.practice.store.services.impl.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;

    @Override
    public ProductoResponse crearProducto(ProductoRequest productoRequest) {
        Producto producto = Producto.builder()
                .nombre(productoRequest.getNombre())
                .stock(productoRequest.getStock())
                .precioUnitario(productoRequest.getPrecioUnitario())
                .img(productoRequest.getImg())
                .sku(productoRequest.getSku())
                .build();

        productoRepository.save(producto);

        return ProductoResponse.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .stock(producto.getStock())
                .precioUnitario(producto.getPrecioUnitario())
                .img(producto.getImg())
                .sku(producto.getSku())
                .build();
    }

    @Override
    public ProductoResponse actualizarProducto(Long id, ProductoRequest productoRequest) {
        productoRepository.findById(id).orElseThrow(() -> new
                ProductoNoEncontradoException("Producto no encontrado con id: " + id));

        Producto producto = Producto.builder()
                .nombre(productoRequest.getNombre())
                .stock(productoRequest.getStock())
                .precioUnitario(productoRequest.getPrecioUnitario())
                .img(productoRequest.getImg())
                .sku(productoRequest.getSku())
                .build();

        productoRepository.save(producto);

        return ProductoResponse.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .stock(producto.getStock())
                .precioUnitario(producto.getPrecioUnitario())
                .img(producto.getImg())
                .sku(producto.getSku())
                .build();
    }

    @Override
    public ProductoResponse getProductoById(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new
                ProductoNoEncontradoException("Producto no encontrado con id: " + id));

        return ProductoResponse.builder()
                .nombre(producto.getNombre())
                .stock(producto.getStock())
                .precioUnitario(producto.getPrecioUnitario())
                .build();
    }

    @Override
    public List<ProductoResponse> getAllProductos() {
        return productoRepository.findAll().stream().map(producto -> ProductoResponse.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .stock(producto.getStock())
                .precioUnitario(producto.getPrecioUnitario())
                .img(producto.getImg())
                .sku(producto.getSku())
                .build()
        ).toList();
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.findById(id).orElseThrow(() -> new
                ProductoNoEncontradoException("Producto no encontrado con id: " + id));

        productoRepository.deleteById(id);
    }
}
