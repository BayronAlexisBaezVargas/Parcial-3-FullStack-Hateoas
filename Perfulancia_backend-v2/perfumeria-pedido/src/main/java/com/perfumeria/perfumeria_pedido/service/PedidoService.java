package com.perfumeria.perfumeria_pedido.service;

import com.perfumeria.perfumeria_pedido.model.pedido;
import com.perfumeria.perfumeria_pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PedidoService {


    private final PedidoRepository pedidoRepo;
    public PedidoService(PedidoRepository pedidoRepo) {
        this.pedidoRepo = pedidoRepo;
    }
//guardar
    public pedido guardar(pedido pedido) {
        return pedidoRepo.save(pedido);
    }
    //listar
    public List<pedido> listar() {
        return pedidoRepo.findAll();
    }
    //buscar por id
    public pedido buscarPorId(Long id) {
        return pedidoRepo.findById(id).orElse(null);
    }
    //eliminar
    public void eliminar(Long id) {
        pedidoRepo.deleteById(id);
    }

    public pedido findById(Long id) {
        return pedidoRepo.findById(id).orElse(null);
    }

    public pedido save(pedido pedido) {
        return pedidoRepo.save(pedido);
    }
}
