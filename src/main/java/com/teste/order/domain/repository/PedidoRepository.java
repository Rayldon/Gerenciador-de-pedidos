package com.teste.order.domain.repository;

import com.teste.order.domain.model.Pedido;

import java.util.List;

public interface PedidoRepository {
    List<Pedido> buscarTodos();

    Pedido salvar(Pedido pedido);
}
