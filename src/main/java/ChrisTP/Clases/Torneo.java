package ChrisTP.Clases;

import ChrisTP.Dao.ResultadoDAOMysql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Torneo {
    private List<Vikingo> vikingos;
    private List<Espartano> espartanos;
    private Integer cantidad_competidores_x_equipo;
    private Integer cantidad_frescas_maximas;
    private Enfrentamiento enfrentamiento;

    public Torneo(List<Vikingo> vikingos, List<Espartano> espartanos, Integer cantidad_competidores_x_equipo) {
        this.vikingos = vikingos;
        this.espartanos = espartanos;
        this.cantidad_competidores_x_equipo = cantidad_competidores_x_equipo;
    }

    public void comenzar() throws InterruptedException, SQLException {
        if(vikingos.size()<=cantidad_competidores_x_equipo || espartanos.size()<=cantidad_competidores_x_equipo)
        {

            while (cantidad_competidores_x_equipo != 0)
            {
                enfrentamiento = new Enfrentamiento(vikingos.get(0), espartanos.get(0), 10);
                Humano ganador = enfrentamiento.Batalla();

                if (Objects.nonNull(ganador)) {
                    if (ganador instanceof Vikingo) {
                        Humano_Ganador resultado = new Humano_Ganador(ganador.getNombre(), ((Vikingo) ganador).getCantidad_cerveza(),"Vikingo");
                        resultado.guardar_ganador();
                    } else if (ganador instanceof Espartano) {
                        Humano_Ganador resultado = new Humano_Ganador(ganador.getNombre(), ((Espartano) ganador).getCantidad_cerveza(),"Espartano");
                        resultado.guardar_ganador();
                    }
                }

                vikingos.remove(0);
                espartanos.remove(0);
                cantidad_competidores_x_equipo--;
            }
        }
        else
        {
            System.out.println("Los equipos deben ser de "+cantidad_competidores_x_equipo+" competidores x equipo.");
        }
    }

    public void resultados()
    {
        List<Humano_Ganador> ganadores = ResultadoDAOMysql.getInstance().listar();
        System.out.println("==================================================================");
        System.out.println("============================GANADORES=============================");
        System.out.println("==================================================================");
        int index = 1;
        for (Humano_Ganador ganador: ganadores) {
        System.out.println(index++ +"º - Nombre: "+ganador.getNombre_ganador()+" - Bebida en cuerpo: "+ganador.getBebida_en_cuerpo()+" - Raza: "+ganador.getRaza());
        }
    }

    public List<Vikingo> getVikingos() {
        return vikingos;
    }

    public void setVikingos(List<Vikingo> vikingos) {
        this.vikingos = vikingos;
    }

    public List<Espartano> getEspartanos() {
        return espartanos;
    }

    public void setEspartanos(List<Espartano> espartanos) {
        this.espartanos = espartanos;
    }

    public Integer getCantidad_competidores_x_equipo() {
        return cantidad_competidores_x_equipo;
    }

    public void setCantidad_competidores_x_equipo(Integer cantidad_competidores_x_equipo) {
        this.cantidad_competidores_x_equipo = cantidad_competidores_x_equipo;
    }

    public Enfrentamiento getEnfrentamiento() {
        return enfrentamiento;
    }

    public void setEnfrentamiento(Enfrentamiento enfrentamiento) {
        this.enfrentamiento = enfrentamiento;
    }


    public Integer getCantidad_frescas_maximas() {
        return cantidad_frescas_maximas;
    }

    public void setCantidad_frescas_maximas(Integer cantidad_frescas_maximas) {
        this.cantidad_frescas_maximas = cantidad_frescas_maximas;
    }
}
