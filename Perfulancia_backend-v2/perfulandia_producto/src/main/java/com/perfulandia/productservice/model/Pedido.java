package com.perfulandia.productservice.model;

//DTO DATA TRANSFER OBJECT ; OBJETO DE TRANSFERENCIA DE DATOS.
//PARA SIMULAR LA RESPUESTA DESDE EL OTRO MICROSERVICIO
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    private Long idPedido;
    private Long idCliente;
    private LocalDateTime fechaPedido;
    private String estadoPedido;
    private int totalPedido;



}
