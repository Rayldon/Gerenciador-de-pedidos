package com.teste.order.domain.service;

import com.teste.order.application.dto.PedidoDTO;
import com.teste.order.domain.model.Cliente;
import com.teste.order.domain.model.Pedido;
import com.teste.order.domain.model.Produto;
import com.teste.order.domain.model.SituacaoPedido;
import com.teste.order.domain.repository.ClienteRepository;
import com.teste.order.domain.repository.PedidoRepository;
import com.teste.order.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos() {
        return pedidoRepository.buscarTodos();
    }

    public Pedido cadastrarPedido(PedidoDTO pedidoDTO) {
        Cliente cliente = clienteRepository.buscarPorId(pedidoDTO.getIdCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        Produto produto = produtoRepository.buscarPorId(pedidoDTO.getIdProduto())
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        pedido.setQuantidade(pedidoDTO.getQuantidade());
        pedido.setSituacao(SituacaoPedido.get(pedidoDTO.getIdSituacao()));
        pedido.setDataPedido(LocalDateTime.now());

        return pedidoRepository.salvar(pedido);
    }
}
