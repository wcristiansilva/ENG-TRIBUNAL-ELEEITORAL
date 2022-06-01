import java.util.List;

public interface CandidatoDAO {
    void salvar(Candidato C);
    void atualizar(Candidato C);
    void excluir(Candidato C);
    Candidato buscar(int numero);
    List<Candidato> listar();
}
