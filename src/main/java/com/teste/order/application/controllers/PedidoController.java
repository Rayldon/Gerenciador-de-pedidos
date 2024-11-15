package com.teste.order.application.controllers;

import com.teste.order.domain.model.Pedido;
import com.teste.order.domain.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
