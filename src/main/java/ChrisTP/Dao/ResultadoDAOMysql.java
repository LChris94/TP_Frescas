package ChrisTP.Dao;

import ChrisTP.Clases.Humano;
import ChrisTP.Clases.Humano_Ganador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ResultadoDAOMysql {
    private final String TABLE_NAME = "resultados_torneo";
    private static final ResultadoDAOMysql INSTANCE = new ResultadoDAOMysql();

    private ResultadoDAOMysql(){
        ConexionMySQL c = ConexionMySQL.getInstance();

        try {
            Statement statement = c.getConnection().createStatement();
            statement.executeUpdate("TRUNCATE TABLE " + TABLE_NAME);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultadoDAOMysql getInstance(){
        return INSTANCE;
    }


    public void crear(Humano_Ganador humano_ganador) throws SQLException{
        ConexionMySQL c = ConexionMySQL.getInstance();
        try {

            PreparedStatement preparedStatement = c.getConnection().prepareStatement(
                    "INSERT INTO " + TABLE_NAME + " (nombre_ganador, bebida_en_cuerpo, raza) VALUES (?,?,?)");
            preparedStatement.setString(1, humano_ganador.getNombre_ganador());
            preparedStatement.setInt(2,humano_ganador.getBebida_en_cuerpo());
            preparedStatement.setString(3,humano_ganador.getRaza());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Humano_Ganador> listar(){
        List<Humano_Ganador> resultados = new ArrayList<Humano_Ganador>();
        ConexionMySQL c = ConexionMySQL.getInstance();

        try {
            Statement statement = c.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME+" ORDER BY bebida_en_cuerpo desc");

            while(resultSet.next()){
                ((ArrayList) resultados).add(
                        new Humano_Ganador(resultSet.getString("nombre_ganador"),
                                resultSet.getInt("bebida_en_cuerpo"),resultSet.getString("raza"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultados;
    }


}
