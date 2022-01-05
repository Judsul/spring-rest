package br.com.faelpf.springbootapi.service;

import java.util.List;
import java.util.Optional;

import br.com.faelpf.springbootapi.model.Produto;

public interface ProdutoService {
    
    List<Produto> listarProdutos();
    Produto novoProduto(Produto produto);
    Optional<Produto> produtoPorId(Long id);
    Object deletaProduto(Produto produto);
    Produto alteraProduto(Long id, Produto produto);

}
