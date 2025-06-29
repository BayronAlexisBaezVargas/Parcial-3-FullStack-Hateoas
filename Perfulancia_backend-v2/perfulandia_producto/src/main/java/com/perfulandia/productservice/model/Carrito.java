package com.perfulandia.productservice.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrito {
    private Long id;
    private int cantidad_productos;
    private double total;
    private String usuario;
}
