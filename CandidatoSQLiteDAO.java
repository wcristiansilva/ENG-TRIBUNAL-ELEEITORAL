import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidatoSQLiteDAO implements CandidatoDAO {

    @Override
    public void salvar(Candidato C) {
        String sql = "INSERT INTO Candidato values (?,?,?,?)";
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setInt(1,C.getNumero());
            stmt.setString(2,C.getNome());
            stmt.setInt(3,C.getPartido().getNumero());
            stmt.setInt(4,C.getCargo().getIdCargo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Candidato C) {
        String sql = "UPDATE Candidato SET nome=? WHERE numero=?";
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setString(1,C.getNome());
            stmt.setInt(2,C.getNumero());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void excluir(Candidato C) {
        String sql = "DELETE FROM Candidato WHERE numero=?";
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setInt(1,C.getNumero());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Candidato buscar(String nome) {
        String sql = "SELECT * FROM Candidato WHERE nome=?";
        Candidato C=null;
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Partido partido = new PartidoSQLiteDAO().buscar(rs.getInt("partido"));
                Cargo cargo = new CargoSQLiteDAO().buscar(rs.getInt("cargo"));
                C = new Candidato(rs.getInt(" numero"),
                        rs.getString("nome"),
                        partido,cargo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return C;
    }

    @Override
    public List<Candidato> listar() {
        String sql = "SELECT * FROM Candidato";
        List<Candidato> listaCandidatos =new ArrayList<>();
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Partido partido = new PartidoSQLiteDAO().buscar(rs.getInt("partido"));
                Cargo cargo = new CargoSQLiteDAO().buscar(rs.getInt("cargo"));
                Candidato C = new Candidato(rs.getInt("numero"),
                        rs.getString("nome"),
                        partido,cargo);
                listaCandidatos.add(C);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCandidatos;
    }

}
