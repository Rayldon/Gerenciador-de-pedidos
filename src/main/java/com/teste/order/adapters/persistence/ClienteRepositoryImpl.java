package com.teste.order.adapters.persistence;

import com.teste.order.domain.model.Cliente;
import com.teste.order.domain.repository.ClienteRepository;
import com.teste.order.infrastructure.persistence.ClienteJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    @Autowired
    private ClienteJpaRepository repository;

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);
    }
}
