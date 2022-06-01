import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CandidatoSQLiteDAO implements CandidatoDAO {

    @Override
    public void salvar(Candidato C) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "INSERT INTO Candidato values (?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,C.getNumero());
            stmt.setString(2,C.getNome());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Candidato C) {

    }

    @Override
    public void excluir(Candidato C) {

    }

    @Override
    public Candidato buscar(int numero) {
        return null;
    }

    @Override
    public List<Candidato> listar() {
        return null;
    }
}
