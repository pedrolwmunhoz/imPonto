import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class FuncionarioDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void inserirFuncionario(Funcionario funcionario) {
        entityManager.persist(funcionario);
    }

    public Funcionario consultarFuncionario(Long id) {
        return entityManager.find(Funcionario.class, id);
    }

    @Transactional
    public Funcionario atualizarFuncionario(Funcionario funcionario) {
        return entityManager.merge(funcionario);
    }
}
