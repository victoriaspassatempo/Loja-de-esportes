package nunus.sports.crud.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nunus.sports.crud.models.Produto;
import nunus.sports.crud.repositories.ProdutoRepository;
import nunus.sports.crud.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(path = "/produtos")
@Api(value = "API Rest Produtos")
@CrossOrigin(value = "*") // posso determinar o dominio de acesso, nesse caso ele esta aceitando todos os dominios
public class ProdutoController {
    private final ProdutoService produtoService;
    private int codProduto;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    @ApiOperation(value="Retorna uma lista de Produtos") // É opcional, porém ajuda a reforçar o que o endpoint esta fazendo
    public List<Produto> obterTodosProdutos() {
        return produtoService.obterTodosProdutos();
    }

    @GetMapping("/{id}")
    public Produto obterProdutoPorId(@PathVariable int id) {
        return produtoService.obterProdutoPorId(id);
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public void excluirProdutoporId(@PathVariable int id) {
        produtoService.excluirProdutoporId(id);
    }

    @DeleteMapping("/{codProduto}")
    public void excluirProdutoporCodProduto(@PathVariable int codProduto) {
        this.codProduto = codProduto;
        produtoService.excluirProdutoporId(codProduto);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable int id, @RequestBody Produto produtoAtualizado) {
        return produtoService.atualizarProduto(id, produtoAtualizado);
    }

}
