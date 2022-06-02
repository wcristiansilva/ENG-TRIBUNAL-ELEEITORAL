import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartidoSQLiteDAO implements PartidoDAO {

    @Override
    public void salvar(Partido P) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "INSERT INTO Partido values (?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,P.getNumero());
            stmt.setString(2,P.getNome());
            stmt.setString(3,P.getSigla());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Partido P) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "UPDATE Partido SET nome=?, sigla=? WHERE numero=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,P.getNome());
            stmt.setString(2,P.getSigla());
            stmt.setInt(3,P.getNumero());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Partido P) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "DELETE FROM Partido WHERE numero=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,P.getNumero());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Partido buscar(int numero) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Partido P = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "SELECT * FROM Partido WHERE numero=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,numero);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                P = new Partido(rs.getInt("numero"), rs.getString("nome"), rs.getString("sigla"));
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return P;
    }

    @Override
    public List<Partido> listar() {
        PreparedStatement stmt = null;
        Connection conn = null;
        List<Partido> listapartidos =new ArrayList<>();
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "SELECT * FROM Partido";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Partido P = new Partido(rs.getInt("numero"), rs.getString("nome"), rs.getString("sigla"));
                listapartidos.add(P);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listapartidos;
    }
}
