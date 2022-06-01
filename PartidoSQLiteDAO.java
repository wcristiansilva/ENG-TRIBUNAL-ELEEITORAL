import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PartidoSQLiteDAO implements PartidoDAO {

    @Override
    public void salvar(Partido P) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "INSERT INTO Partido values (?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,P.getNumero());
            stmt.setString(2,P.getNome());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Partido P) {

    }

    @Override
    public void excluir(Partido P) {

    }

    @Override
    public Partido buscar(int numero) {
        return null;
    }

    @Override
    public List<Partido> listar() {
        return null;
    }
}
