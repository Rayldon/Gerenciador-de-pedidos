package com.teste.order.application.controllers;

import com.teste.order.application.dto.PedidoDTO;
import com.teste.order.domain.model.Pedido;
import com.teste.order.domain.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping
    public @ResponseBody List<Pedido> get() {
        return pedidoService.listarPedidos();
    }

    @PostMapping
    public ResponseEntity<Pedido> cadastrarPedido(@RequestBody PedidoDTO pedidoDTO) {
        Pedido pedidoCriado = pedidoService.cadastrarPedido(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoCriado);
    }
}
