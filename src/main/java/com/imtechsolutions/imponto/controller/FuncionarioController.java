import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioDAO funcionarioDAO;

    @Autowired
    public FuncionarioController(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    @PostMapping
    public void inserirFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioDAO.inserirFuncionario(funcionario);
    }

    @GetMapping("/{id}")
    public Funcionario consultarFuncionario(@PathVariable Long id) {
        return funcionarioDAO.consultarFuncionario(id);
    }

    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        funcionario.setIdFuncionario(id);
        return funcionarioDAO.atualizarFuncionario(funcionario);
    }
}
