package com.teste.order.domain.model;

import java.time.LocalDateTime;

public class PedidoBuilder {

    private Cliente cliente;
    private Produto produto;
    private SituacaoPedido situacao;
    private Integer quantidade;
    private LocalDateTime dataPedido;
    private String pedidoHash;

    public PedidoBuilder cliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public PedidoBuilder produto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public PedidoBuilder situacao(SituacaoPedido situacao) {
        this.situacao = situacao;
        return this;
    }

    public PedidoBuilder quantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public PedidoBuilder dataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
        return this;
    }

    public PedidoBuilder pedidHash(String pedidoHash) {
        this.pedidoHash = pedidoHash;
        return this;
    }

    public Pedido build() {
        Pedido pedido = new Pedido();
        pedido.setCliente(this.cliente);
        pedido.setProduto(this.produto);
        pedido.setSituacao(this.situacao);
        pedido.setQuantidade(this.quantidade);
        pedido.setDataPedido(this.dataPedido);
        pedido.setPedidoHash(this.pedidoHash);
        return pedido;
    }
}
