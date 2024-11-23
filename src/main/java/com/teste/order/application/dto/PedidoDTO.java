package com.teste.order.application.dto;

import com.teste.order.domain.model.SituacaoPedido;
import org.springframework.util.DigestUtils;

import java.util.Objects;

public class PedidoDTO {

    private Long id;
    private Long idCliente;
    private Long idProduto;
    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String gerarHash() {
        String input = Integer.toString(this.hashCode());
        return DigestUtils.md5DigestAsHex(input.getBytes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, idProduto, quantidade, SituacaoPedido.PENDENTE.getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PedidoDTO that = (PedidoDTO) obj;
        return Objects.equals(idCliente, that.idCliente) &&
                Objects.equals(quantidade, that.quantidade) &&
                Objects.equals(idProduto, that.idProduto);
    }
}
