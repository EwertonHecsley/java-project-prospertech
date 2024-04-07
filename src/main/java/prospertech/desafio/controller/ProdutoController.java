package prospertech.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prospertech.desafio.httpException.ProdutoNotFoundException;
import prospertech.desafio.model.Produto;
import prospertech.desafio.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/{id}")
    public Produto detalhar(@PathVariable Integer id){
       return produtoRepository.findById(id)
       .orElseThrow(()-> new ProdutoNotFoundException(id));
    }

    @GetMapping
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        Produto produto = produtoRepository.findById(id).orElseThrow(()-> new ProdutoNotFoundException(id));
        produtoRepository.delete(produto);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto){
        Produto novoProduto = produtoRepository.save(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Integer id, @RequestBody Produto dataProduto){
        Produto produto = produtoRepository.findById(id).orElseThrow(()-> new ProdutoNotFoundException(id));
        produto.setNome(dataProduto.getNome());
        produto.setPreco(dataProduto.getPreco());
        produto.setDescricao(dataProduto.getDescricao());
        Produto atualizadoProduto = produtoRepository.save(produto);

        return ResponseEntity.status(HttpStatus.OK).body(atualizadoProduto);
    }
}
