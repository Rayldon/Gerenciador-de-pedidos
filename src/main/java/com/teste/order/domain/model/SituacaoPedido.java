package com.teste.order.domain.model;

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

    @Override
    public String toString() {
        return situacao;
    }
}
