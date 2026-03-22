package com.baozistore.controller;

import com.baozistore.model.Pedido;
import com.baozistore.repository.PedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidosRepository;

    public PedidoController(PedidoRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }

    @PostMapping
    public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido) {
        Pedido salvo = pedidosRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarTodos() {
        return ResponseEntity.ok(pedidosRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> consultarPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidosRepository.findById(id);
        return pedido.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @RequestBody Pedido dados) {
        return pedidosRepository.findById(id).map(pedido -> {
            pedido.setClienteId(dados.getClienteId());
            pedido.setProdutoId(dados.getProdutoId());
            pedido.setQuantidade(dados.getQuantidade());
            return ResponseEntity.ok(pedidosRepository.save(pedido));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id) {
        if (!pedidosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        pedidosRepository.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
