package com.teste.order.domain.repository;

import com.teste.order.domain.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {
    List<Produto> buscarTodos();

    Optional<Produto> buscarPorId(Long id);
}
