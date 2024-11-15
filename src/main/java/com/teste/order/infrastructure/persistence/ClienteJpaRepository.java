package com.teste.order.infrastructure.persistence;

import com.teste.order.domain.model.Cliente;
import com.teste.order.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<Cliente, Long> {
}
