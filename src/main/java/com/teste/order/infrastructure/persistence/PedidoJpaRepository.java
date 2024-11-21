package com.teste.order.infrastructure.persistence;

import com.teste.order.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoJpaRepository extends JpaRepository<Pedido, Long> {

    boolean existsByPedidoHash(String pedidoHash);
}
