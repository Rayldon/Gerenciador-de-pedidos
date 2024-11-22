package com.teste.order.application.controllers;

import com.teste.order.domain.model.Produto;
import com.teste.order.domain.service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    final ProdutoService ProdutoService;

    public ProdutoController(ProdutoService ProdutoService) {
        this.ProdutoService = ProdutoService;
    }

    @GetMapping
    public List<Produto> listar() {
        return ProdutoService.listarProdutos();
    }
}
