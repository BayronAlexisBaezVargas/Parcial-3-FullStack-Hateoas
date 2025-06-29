package com.perfumeria.perfumeria_pedido.controller;
import com.perfumeria.perfumeria_pedido.model.pedido;
import com.perfumeria.perfumeria_pedido.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
    private final PedidoService Repo;
    private final PedidoService pedidoService;

    public PedidoController(PedidoService Repo, PedidoService pedidoService) {
        this.Repo=Repo;
        this.pedidoService = pedidoService;
    }
    @GetMapping
    public List<pedido> listar() {
        return Repo.listar();
    }
    @PostMapping
    public pedido guardar(@RequestBody pedido pedido) {
        return Repo.guardar(pedido);
    }
    @GetMapping("/{id}")
    public pedido buscar(@PathVariable long id) {
        return Repo.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id) {
        Repo.eliminar(id);
    }

    @PutMapping("/{idPedido}")
    public ResponseEntity<pedido> actualizar(@PathVariable long idPedido, @RequestBody pedido pedido){
        try {
            pedido ped = pedidoService.findById(Long.valueOf(idPedido));
            ped.setIdPedido(idPedido);
            ped.setIdCliente(pedido.getIdCliente());
            ped.setFechaPedido(pedido.getFechaPedido());
            ped.setEstadoPedido(pedido.getEstadoPedido());
            ped.setTotalPedido(pedido.getTotalPedido());

            pedidoService.save(ped);
            return ResponseEntity.ok(ped);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
