import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class CargoSQLiteDAO implements CargoDAO {

    @Override
    public void salvar(Cargo Ca) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "INSERT INTO Cargo values (?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,Ca.getIdCargo());
            stmt.setString(2,Ca.getCargo());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Cargo Ca) {

    }

    @Override
    public void excluir(Cargo Ca) {

    }

    @Override
    public Cargo buscar(int numero) {
        return null;
    }

    @Override
    public List<Cargo> listar() {
        return null;
    }
}
