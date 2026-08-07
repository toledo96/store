package com.practice.store.mapper;

import com.practice.store.dtos.request.ProductoRequest;
import com.practice.store.dtos.response.ProductoResponse;
import com.practice.store.entities.Producto;

public class ProductoMapper {

    public static Producto fromRequestDtoToEntity(ProductoRequest productoRequest){
        Producto producto = new Producto();
        producto.setNombre(productoRequest.getNombre());
        producto.setStock(productoRequest.getStock());
        producto.setPrecioUnitario(productoRequest.getPrecioUnitario());
        producto.setImg(productoRequest.getImg());
        producto.setSku(productoRequest.getSku());
        return producto;
    }


    public static ProductoResponse fromEntityToResponseDto(Producto producto){
        ProductoResponse productoResponse = new ProductoResponse();
        productoResponse.setNombre(producto.getNombre());
        productoResponse.setStock(producto.getStock());
        productoResponse.setPrecioUnitario(producto.getPrecioUnitario());
        return productoResponse;
    }

}
