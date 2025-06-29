package com.perfumeria.perfumeria_pedido.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class pedido {
    //atributos.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    private Long idCliente;
    private LocalDateTime fechaPedido;
    private String estadoPedido;
    private int totalPedido;

}
