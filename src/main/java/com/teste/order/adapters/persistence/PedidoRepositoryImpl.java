package com.teste.order.adapters.persistence;

import com.teste.order.domain.model.Pedido;
import com.teste.order.domain.repository.PedidoRepository;
import com.teste.order.infrastructure.persistence.PedidoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {

    @Autowired
    private PedidoJpaRepository repository;

    @Override
    public List<Pedido> buscarTodos() {
        return repository.findAll();
    }
}
