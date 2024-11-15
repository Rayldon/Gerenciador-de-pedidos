package com.teste.order.domain.model;

import java.util.Arrays;

public enum SituacaoPedido {
    PENDENTE(0, "Pendente"),
    CONFIRMADO(1, "Confirmado"),
    EM_PREPARACAO(2, "Em preparação"),
    ENVIADO(3, "Enviado"),
    ENTREGUE(4, "Entregue"),
    CANCELADO(5, "Cancelado");

    private final int id;
    private final String situacao;

    SituacaoPedido(int id, String situacao) {
        this.id = id;
        this.situacao = situacao;
    }

    public int getId() {
        return id;
    }

    public String getSituacao() {
        return situacao;
    }

    public static SituacaoPedido get(int id) {
        return Arrays.stream(SituacaoPedido.values())
                .filter(status -> status.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Situação com id " + id + " não encontrado."));
    }

    @Override
    public String toString() {
        return situacao;
    }
}
