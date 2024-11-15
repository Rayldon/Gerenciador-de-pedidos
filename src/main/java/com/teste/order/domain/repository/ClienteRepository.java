package com.teste.order.domain.repository;

import com.teste.order.domain.model.Cliente;

import java.util.Optional;

public interface ClienteRepository {
    Optional<Cliente> buscarPorId(Long id);
}
