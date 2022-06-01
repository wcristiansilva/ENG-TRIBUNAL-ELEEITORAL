import java.sql.*;
import java.util.List;

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
        PreparedStatement stmt = null;
        Connection conn = null;
        Cargo Ca = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "SELECT * FROM Candidato WHERE numero=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,numero);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                Ca = new Cargo(rs.getInt("idCargo"), rs.getString("nome"));
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Ca;
    }

    @Override
    public List<Cargo> listar() {
        return null;
    }
}
