package com.teste.order.adapters.persistence;

import com.teste.order.domain.model.Pedido;
import com.teste.order.domain.repository.PedidoRepository;
import com.teste.order.infrastructure.persistence.PedidoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {

    @Autowired
    private PedidoJpaRepository repository;

    @Override
    public List<Pedido> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Pedido> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Pedido salvar(Pedido pedido) {
        return repository.save(pedido);
    }

    @Override
    public void remover(Long idPedido) {
        repository.deleteById(idPedido);
    }
}
