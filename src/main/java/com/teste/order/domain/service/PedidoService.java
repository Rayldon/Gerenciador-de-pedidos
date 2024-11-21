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

    public Pedido salvar(PedidoDTO pedidoDTO) {
        Pedido pedido;

        Cliente cliente = clienteRepository.buscarPorId(pedidoDTO.getIdCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        Produto produto = produtoRepository.buscarPorId(pedidoDTO.getIdProduto())
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        if(pedidoDTO.getId() != null) {
            pedido = new PedidoBuilder()
                    .cliente(cliente)
                    .produto(produto)
                    .situacao(SituacaoPedido.get(pedidoDTO.getIdSituacao()))
                    .quantidade(pedidoDTO.getQuantidade())
                    .dataPedido(LocalDateTime.now())
                    .build();
        }else{
            pedido = pedidoRepository.buscarPorId(pedidoDTO.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
            pedido.setCliente(cliente);
            pedido.setProduto(produto);
            pedido.setQuantidade(pedidoDTO.getQuantidade());
        }

        return pedidoRepository.salvar(pedido);
    }

    public void remover(Long idPedido) {
        pedidoRepository.remover(idPedido);
    }
}
