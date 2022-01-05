package br.com.faelpf.springbootapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.faelpf.springbootapi.exception.ApiRequestException;
import br.com.faelpf.springbootapi.model.Produto;
import br.com.faelpf.springbootapi.service.ProdutoService;

@RestController
public class ProdutoController {
    
    @Autowired
    private ProdutoService _produtoService;
    
    @GetMapping(value = "/produtos")
    public ResponseEntity<List<Produto>> todosProdutos() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(_produtoService.listarProdutos());
    }

    @RequestMapping(value = "/produtos")
    public ResponseEntity<Produto> novoProduto(@RequestBody Produto produto) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(_produtoService.novoProduto(produto));
    }

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<Optional<Produto>> produtoPorId(@PathVariable Long id) {

        Optional<Produto> produto = _produtoService.produtoPorId(id);

        if (produto.isPresent()) {
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(produto);
        }

        throw new ApiRequestException("Produto não encontrado!");
 
    }

    @DeleteMapping(value = "/produtos/{id}")
    public ResponseEntity<Object> deletaProduto(@PathVariable Long id) {

        Optional<Produto> produto = _produtoService.produtoPorId(id);

        if (produto.isPresent()) {
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(_produtoService.deletaProduto(produto.get()));
        }

        throw new ApiRequestException("Produto não encontrado!");

    }

    @PutMapping(value = "/produtos/{id}")
    public ResponseEntity<Produto> alteraProduto(@PathVariable Long id, @RequestBody Produto produtoNovo) {
        
        Optional<Produto> produtoAntigo = _produtoService.produtoPorId(id);

        if (produtoAntigo.isPresent()) {

            Produto produto = produtoAntigo.get();
            produto.setDescricao(produtoNovo.getDescricao());
            produto.setQuantidade(produtoNovo.getQuantidade());
            produto.setPreco(produtoNovo.getPreco());

            return ResponseEntity
                .status(HttpStatus.OK)
                .body(_produtoService.novoProduto(produto));

        } 
        
        throw new ApiRequestException("Produto não encontrado!");

    }

}
