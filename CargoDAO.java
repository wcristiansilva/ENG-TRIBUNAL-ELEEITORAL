import java.util.List;

public interface CargoDAO {
    void salvar(Cargo Ca);
    void atualizar(Cargo Ca);
    void excluir(Cargo Ca);
    Cargo buscar(int numero);
    List<Cargo> listar();
}
