package br.com.faelpf.springbootapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.faelpf.springbootapi.model.Produto;
import br.com.faelpf.springbootapi.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto novoProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Optional<Produto> produtoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public Object deletaProduto(Produto produto) {
        produtoRepository.delete(produto);
        return null;
    }

    @Override
    public Produto alteraProduto(Long id, Produto produto) {
        return produtoRepository.save(produto);
    }
    
}
