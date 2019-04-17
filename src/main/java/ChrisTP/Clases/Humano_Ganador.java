package ChrisTP.Clases;

import ChrisTP.Dao.ResultadoDAOMysql;

import java.sql.SQLException;

public class Humano_Ganador {
    private String nombre_ganador;
    private Integer bebida_en_cuerpo;
    private String raza;


    public Humano_Ganador(String nombre_ganador, Integer bebida_en_cuerpo, String raza) {
        this.nombre_ganador = nombre_ganador;
        this.bebida_en_cuerpo = bebida_en_cuerpo;
        this.raza = raza;
    }

    public String getNombre_ganador() {
        return nombre_ganador;
    }

    public void setNombre_ganador(String nombre_ganador) {
        this.nombre_ganador = nombre_ganador;
    }

    public Integer getBebida_en_cuerpo() {
        return bebida_en_cuerpo;
    }

    public void setBebida_en_cuerpo(Integer bebida_en_cuerpo) {
        this.bebida_en_cuerpo = bebida_en_cuerpo;
    }


    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void guardar_ganador() throws SQLException {
        ResultadoDAOMysql.getInstance().crear(this);
    }

}
