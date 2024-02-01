package nunus.sports.crud.services;

import nunus.sports.crud.models.Produto;
import nunus.sports.crud.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired(required = true)
    private ProdutoRepository produtoRepository;

    public List<Produto> obterTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Produto obterProdutoPorId(int id) {
        return produtoRepository.findById(id);
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void excluirProdutoporId(int id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizarProduto(int id, Produto produtoAtualizado) {
        Produto produtoExistente = produtoRepository.findById(id);

        if (produtoExistente != null) {
            produtoExistente.setNomeProduto(produtoAtualizado.getNomeProduto());
            produtoExistente.setCodProduto(produtoAtualizado.getCodProduto());
            produtoExistente.setDescricaoProduto(produtoAtualizado.getDescricaoProduto());
            produtoExistente.setPrecoProduto(produtoAtualizado.getPrecoProduto());

            return produtoRepository.save(produtoExistente);
        }
        return null;
    }

}
