package com.teste.order.infrastructure.persistence;

import com.teste.order.domain.model.Pedido;
import com.teste.order.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoJpaRepository extends JpaRepository<Produto, Long> {
}
