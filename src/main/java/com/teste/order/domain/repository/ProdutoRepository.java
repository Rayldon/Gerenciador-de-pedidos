package com.teste.order.domain.repository;

import com.teste.order.domain.model.Produto;

import java.util.Optional;

public interface ProdutoRepository {
    Optional<Produto> buscarPorId(Long id);
}
