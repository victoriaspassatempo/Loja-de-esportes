package nunus.sports.crud.controller;

import nunus.sports.crud.controllers.ProdutoController;
import nunus.sports.crud.services.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class ProdutoControllerTests {

    @Mock
    private ProdutoService produtoService;

    @InjectMocks
    private ProdutoController produtoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        produtoController = new ProdutoController(produtoService);
    }

    @Test
    public void obterTodosProdutos() {
        produtoController.obterTodosProdutos();

        verify(produtoService).obterTodosProdutos();
    }

    @Test
    public void obterProdutoPorId() {
        int produtoId = 1;
        produtoController.obterProdutoPorId(produtoId);

        verify(produtoService).obterProdutoPorId(produtoId);
    }

    @Test
    public void salvarProduto() {
        produtoController.salvarProduto(null);

        verify(produtoService).salvarProduto(null);
    }

    @Test
    public void editarProduto() {
        int produtoId = 1;
        produtoController.atualizarProduto(produtoId, null);

        verify(produtoService).atualizarProduto(produtoId, null);
    }

    @Test
    public void deletarProdutoPorId() {
        int produtoId = 1;
        produtoController.excluirProdutoporId(produtoId);

        verify(produtoService).excluirProdutoPorId(produtoId);
    }
}

