package nunus.sports.crud.model;

import nunus.sports.crud.models.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTests {
    @Test
    public void criarProduto() {
        String nomeProduto = "Bola";
        int codProduto = 1;
        String descricaoProduto = "Bola de futebol";
        Double precoProduto = 29.99;

        Produto produto = new Produto(nomeProduto, codProduto, descricaoProduto, precoProduto);

        assertEquals(nomeProduto, produto.getNomeProduto());
        assertEquals(codProduto, produto.getCodProduto());
        assertEquals(descricaoProduto, produto.getDescricaoProduto());
        assertEquals(precoProduto, produto.getPrecoProduto());
    }

    @Test
    public void editarProduto() {
        Produto produto = new Produto("Camiseta", 2, "Camiseta Feminina",
                39.99);

        assertNotEquals(produto, new Produto("Camisa", 2, "Camiseta Feminina",
                39.99));

    }

    @Test
    public void atualizarProdutosIguais() {
        Produto produto1 = new Produto("Camiseta", 123, "Camiseta feminina",
                59.99);
        Produto produto2 = new Produto("Camiseta", 123, "Camiseta feminina",
                59.99);

        assertEquals(produto1.hashCode(), produto2.hashCode());

        produto2.setNomeProduto("Camisa");

        assertNotEquals(produto1.hashCode(), produto2.hashCode());
    }

    @Test
    public void criandoProdutoNaoNulo() {
        Produto produto = new Produto();
        produto.setNomeProduto("Camiseta");
        produto.setCodProduto(1);
        produto.setDescricaoProduto("Camiseta esportiva preta feminina");
        produto.setPrecoProduto(29.99);

        assertNotNull(produto);
    }
}
