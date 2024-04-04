package nunus.sports.crud.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_Produto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nomeProduto")
    private String nomeProduto;

    @Column(name = "codProduto")
    private int codProduto;

    @Column(name = "descricaoProduto")
    private String descricaoProduto;

    @Column(name = "precoProduto")
    private Double precoProduto;

    public Produto(String nomeProduto, int codProduto, String descricaoProduto, Double precoProduto) {
        super();
        this.nomeProduto = nomeProduto;
        this.codProduto = codProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoProduto = precoProduto;
    }

}
