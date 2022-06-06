import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CargoSQLiteDAO implements CargoDAO {

    @Override
    public void salvar(Cargo Ca) {
        String sql = "INSERT INTO Cargo values (?,?)";

        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, Ca.getIdCargo());
            stmt.setString(2, Ca.getCargo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Cargo Ca) {

        String sql = "UPDATE Cargo SET cargo=? WHERE idCargo=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,Ca.getCargo());
            stmt.setInt(2,Ca.getIdCargo());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Cargo Ca) {

        String sql = "DELETE FROM Cargo WHERE idCargo=?";
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setInt(1,Ca.getIdCargo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cargo buscar(int numero) {

        String sql = "SELECT * FROM Cargo WHERE numero=?";
        Cargo Ca = null;
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setInt(1,numero);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                Ca = new Cargo(rs.getInt("idCargo"), rs.getString("nome"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Ca;
    }

    @Override
    public List<Cargo> listar() {
        String sql = "SELECT * FROM Cargo";
        List<Cargo> listacargos =new ArrayList<>();
        try{PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cargo Ca = new Cargo(rs.getInt("idcargo"), rs.getString("nome"));
                listacargos.add(Ca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listacargos;
    }
}
