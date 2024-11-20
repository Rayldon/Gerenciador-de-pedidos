package com.teste.order.domain.service;

import com.teste.order.application.dto.PedidoDTO;
import com.teste.order.domain.model.Cliente;
import com.teste.order.domain.model.Pedido;
import com.teste.order.domain.model.PedidoBuilder;
import com.teste.order.domain.model.Produto;
import com.teste.order.domain.model.SituacaoPedido;
import com.teste.order.domain.repository.ClienteRepository;
import com.teste.order.domain.repository.PedidoRepository;
import com.teste.order.domain.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    private final ClienteRepository clienteRepository;

    private final ProdutoRepository produtoRepository;

    private final PedidoRepository pedidoRepository;

    public PedidoService(ClienteRepository clienteRepository, ProdutoRepository produtoRepository, PedidoRepository pedidoRepository) {
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.buscarTodos();
    }

    public Pedido cadastrarPedido(PedidoDTO pedidoDTO) {
        Cliente cliente = clienteRepository.buscarPorId(pedidoDTO.getIdCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        Produto produto = produtoRepository.buscarPorId(pedidoDTO.getIdProduto())
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        Pedido pedido = new PedidoBuilder()
                .cliente(cliente)
                .produto(produto)
                .situacao(SituacaoPedido.get(pedidoDTO.getIdSituacao()))
                .quantidade(3)
                .dataPedido(LocalDateTime.now())
                .build();

        return pedidoRepository.salvar(pedido);
    }
}
