package com.teste.order.domain.repository;

import com.teste.order.domain.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {
    List<Pedido> buscarTodos();

    Optional<Pedido> buscarPorId(Long id);

    Pedido salvar(Pedido pedido);

    void remover(Long idPedido);
}
