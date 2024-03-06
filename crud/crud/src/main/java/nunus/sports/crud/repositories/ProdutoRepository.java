package nunus.sports.crud.repositories;

import nunus.sports.crud.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Produto findById(int id);

}
