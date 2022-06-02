import java.sql.*;
import java.util.ArrayList;
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
        PreparedStatement stmt = null;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "UPDATE Candidato SET nome=? WHERE idCurso=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,C.getNome());
            stmt.setInt(2,C.getNumero());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void excluir(Candidato C) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "DELETE FROM Candidato WHERE numero=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,C.getNumero());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Candidato buscar(String nome) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Candidato C=null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "SELECT * FROM candidato WHERE nome=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Partido partido = new PartidoSQLiteDAO().buscar(rs.getInt("partido"));
                Cargo cargo = new CargoSQLiteDAO().buscar(rs.getInt("cargo"));
                C = new Candidato(rs.getInt(" numero"),
                        rs.getString("nome"),
                        partido,cargo);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return C;
    }

    @Override
    public List<Candidato> listar() {
        PreparedStatement stmt = null;
        Connection conn = null;
        List<Candidato> listaCandidatos =new ArrayList<>();
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            String sql = "SELECT * FROM candidato";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Partido partido = new PartidoSQLiteDAO().buscar(rs.getInt("partido"));
                Cargo cargo = new CargoSQLiteDAO().buscar(rs.getInt("cargo"));
                Candidato C = new Candidato(rs.getInt("numero"),
                        rs.getString("nome"),
                        partido,cargo);
                listaCandidatos.add(C);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCandidatos;
    }

}
