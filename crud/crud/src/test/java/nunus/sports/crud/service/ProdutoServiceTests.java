package nunus.sports.crud.service;

import nunus.sports.crud.models.Produto;
import nunus.sports.crud.repositories.ProdutoRepository;
import nunus.sports.crud.services.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class ProdutoServiceTests {
    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @BeforeEach
    public void Setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void obterListaCorretaDeTodosOsProdutos() {
        List<Produto> produtosMock = new ArrayList<>();
        produtosMock.add(new Produto());
        produtosMock.add(new Produto());
        when(produtoRepository.findAll()).thenReturn(produtosMock);

        List<Produto> response = produtoService.obterTodosProdutos();

        assertEquals(produtosMock, response);
    }

    @Test
    public void obterProdutoCorretoPorID() {
        int produtoId = 1;
        Produto produtoMock = new Produto();
        when(produtoRepository.findById(produtoId)).thenReturn(produtoMock);

        Produto response = produtoService.obterProdutoPorId(produtoId);

        assertEquals(produtoMock, response);

    }

    @Test
    public void salvarProdutoCorreto() {
        Produto produtoMock = new Produto();
        when(produtoRepository.save(produtoMock)).thenReturn(produtoMock);

        Produto response = produtoService.salvarProduto(produtoMock);

        assertEquals(produtoMock, response);
    }

    @Test
    public void excluirProdutoPorIdProdutoEncontrado(){
        int produtoId = 1;
        Produto produtoMock = new Produto();
        when(produtoRepository.findById(produtoId)).thenReturn(produtoMock);

        produtoService.excluirProdutoPorId(produtoId);

        verify(produtoRepository, times(1)).deleteById(produtoId);
    }

    @Test
    public void excluirProdutoPorIdProdutoNaoEncontrado(){
        int produtoId = 1;
        Produto produtoMock = new Produto();
        when(produtoRepository.findById(produtoId)).thenReturn((null));

        produtoService.excluirProdutoPorId(produtoId);
        assertNotEquals(produtoMock, null);
    }

    @Test
    public void atualizarProdutoDeveRetornarProdutoAtualizado() {
        int idProduto = 1;
        Produto produtoAtualizado = new Produto();
        Produto produtoExistente = new Produto();
        when(produtoRepository.findById(idProduto)).thenReturn((produtoExistente));
        when(produtoRepository.save(produtoExistente)).thenReturn(produtoExistente);

        Produto response = produtoService.atualizarProduto(idProduto, produtoAtualizado);

        assertEquals(produtoAtualizado, response);
    }

    @Test
    public void atualizarProdutoNuloErrado() {
        int idProduto = 1;
        Produto produtoAtualizado = new Produto();
        when(produtoRepository.findById(idProduto)).thenReturn((null));

        Produto response = produtoService.atualizarProduto(idProduto, produtoAtualizado);

        assertNotEquals(produtoAtualizado, response);
    }
}
