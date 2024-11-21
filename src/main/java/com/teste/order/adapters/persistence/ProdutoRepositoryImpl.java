package com.teste.order.adapters.persistence;

import com.teste.order.domain.model.Produto;
import com.teste.order.domain.repository.ProdutoRepository;
import com.teste.order.infrastructure.persistence.ProdutoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @Autowired
    private ProdutoJpaRepository repository;

    @Override
    public List<Produto> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }
}
