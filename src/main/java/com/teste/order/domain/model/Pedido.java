package com.teste.order.domain.model;

import com.teste.order.application.dto.PedidoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade = 0;

    @Column(name = "data_pedido", nullable = false)
    private LocalDateTime dataPedido;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "id_situacao", nullable = false)
    private SituacaoPedido situacao;

    @Column(name = "pedido_hash", nullable = false, length = 35)
    private String pedidoHash;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getSituacao() {
        return situacao.toString();
    }

    public void setSituacao(SituacaoPedido situacao) {
        this.situacao = situacao;
    }

    public String getPedidoHash() {
        return pedidoHash;
    }

    public void setPedidoHash(String pedidoHash) {
        this.pedidoHash = pedidoHash;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente != null ? cliente.getId() : 0,
                produto != null ? produto.getId() : 0,
                quantidade,
                situacao != null ? situacao.getId() : 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pedido that = (Pedido) obj;
        return Objects.equals(cliente.getId(), that.cliente.getId()) &&
                Objects.equals(quantidade, that.quantidade) &&
                Objects.equals(situacao.getId(), that.situacao.getId()) &&
                Objects.equals(produto.getId(), that.produto.getId());
    }
}