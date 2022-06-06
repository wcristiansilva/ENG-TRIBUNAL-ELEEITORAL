import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartidoSQLiteDAO implements PartidoDAO {

    @Override
    public void salvar(Partido P) {
        String sql = "INSERT INTO Partido values (?,?)";
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setInt(1,P.getNumero());
            stmt.setString(2,P.getNome());
            stmt.setString(3,P.getSigla());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Partido P) {
        String sql = "UPDATE Partido SET nome=?, sigla=? WHERE numero=?";
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setString(1,P.getNome());
            stmt.setString(2,P.getSigla());
            stmt.setInt(3,P.getNumero());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Partido P) {
        String sql = "DELETE FROM Partido WHERE numero=?";
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setInt(1,P.getNumero());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Partido buscar(int numero) {
        String sql = "SELECT * FROM Partido WHERE numero=?";
        Partido P = null;
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setInt(1,numero);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                P = new Partido(rs.getInt("numero"), rs.getString("nome"), rs.getString("sigla"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return P;
    }

    @Override
    public List<Partido> listar() {
        String sql = "SELECT * FROM Partido";
        List<Partido> listapartidos =new ArrayList<>();
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Partido P = new Partido(rs.getInt("numero"), rs.getString("nome"), rs.getString("sigla"));
                listapartidos.add(P);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listapartidos;
    }
}
