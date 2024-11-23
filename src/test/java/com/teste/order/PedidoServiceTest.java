package com.teste.order;

import com.teste.order.application.dto.PedidoDTO;
import com.teste.order.domain.model.Cliente;
import com.teste.order.domain.model.Pedido;
import com.teste.order.domain.model.Produto;
import com.teste.order.domain.model.SituacaoPedido;
import com.teste.order.domain.repository.ClienteRepository;
import com.teste.order.domain.repository.PedidoRepository;
import com.teste.order.domain.repository.ProdutoRepository;
import com.teste.order.domain.service.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PedidoServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoService pedidoService;

    private PedidoDTO pedidoDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        pedidoDTO = new PedidoDTO();
        pedidoDTO.setIdCliente(1L);
        pedidoDTO.setIdProduto(1L);
        pedidoDTO.setQuantidade(2);
    }

    @Test
    void salvar_deveCriarPedidoComSucessoQuandoDadosValidos() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        Produto produto = new Produto();
        produto.setId(1L);

        when(clienteRepository.buscarPorId(pedidoDTO.getIdCliente())).thenReturn(Optional.of(cliente));
        when(produtoRepository.buscarPorId(pedidoDTO.getIdProduto())).thenReturn(Optional.of(produto));

        Pedido pedidoMock = new Pedido();
        when(pedidoRepository.salvar(any(Pedido.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Pedido pedidoSalvo = pedidoService.salvar(pedidoDTO);

        verify(clienteRepository, times(1)).buscarPorId(pedidoDTO.getIdCliente());
        verify(produtoRepository, times(1)).buscarPorId(pedidoDTO.getIdProduto());
        verify(pedidoRepository, times(1)).salvar(any(Pedido.class));

        assertNotNull(pedidoSalvo);
        assertEquals(cliente, pedidoSalvo.getCliente());
        assertEquals(produto, pedidoSalvo.getProduto());
        assertEquals(pedidoDTO.getQuantidade(), pedidoSalvo.getQuantidade());
        pedidoSalvo.gerarHash();
        assertNotNull(pedidoSalvo.getPedidoHash());
        assertEquals(SituacaoPedido.PENDENTE, pedidoSalvo.getSituacao());
    }

    @Test
    void salvar_deveLancarExcecaoQuandoClienteNaoEncontrado() {
        when(clienteRepository.buscarPorId(pedidoDTO.getIdCliente())).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pedidoService.salvar(pedidoDTO);
        });

        assertEquals("Cliente não encontrado", exception.getMessage());

        verify(clienteRepository, times(1)).buscarPorId(pedidoDTO.getIdCliente());
        verify(produtoRepository, never()).buscarPorId(anyLong());
        verify(pedidoRepository, never()).salvar(any(Pedido.class));
    }

    @Test
    void salvar_deveLancarExcecaoQuandoProdutoNaoEncontrado() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        when(clienteRepository.buscarPorId(pedidoDTO.getIdCliente())).thenReturn(Optional.of(cliente));

        when(produtoRepository.buscarPorId(pedidoDTO.getIdProduto())).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pedidoService.salvar(pedidoDTO);
        });

        assertEquals("Produto não encontrado", exception.getMessage());

        verify(clienteRepository, times(1)).buscarPorId(pedidoDTO.getIdCliente());
        verify(produtoRepository, times(1)).buscarPorId(pedidoDTO.getIdProduto());
        verify(pedidoRepository, never()).salvar(any(Pedido.class));
    }

    @Test
    void salvar_deveLancarExcecaoQuandoPedidoDuplicado() {
        when(pedidoRepository.verificarPedidoDuplicado(pedidoDTO.gerarHash())).thenReturn(true);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            pedidoService.salvar(pedidoDTO);
        });

        assertEquals("Pedido já existente!", exception.getMessage());
    }
}

