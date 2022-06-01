import java.util.List;

public interface PartidoDAO {
    void salvar(Partido P);
    void atualizar(Partido P);
    void excluir(Partido P);
    Partido buscar(int numero);
    List<Partido> listar();
}
