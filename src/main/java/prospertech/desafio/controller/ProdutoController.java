package prospertech.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}
