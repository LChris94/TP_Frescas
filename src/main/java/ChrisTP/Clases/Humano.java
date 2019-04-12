package ChrisTP.Clases;

import ChrisTP.Interfaces.Orinar;
import ChrisTP.Interfaces.Beber;

public class Humano {
    String Nombre;
    Integer Edad;
    Integer Peso;
    Orinar Orinar;
    Beber Beber;

    public Humano(String nombre, Integer edad, Integer peso, ChrisTP.Interfaces.Orinar orinar, ChrisTP.Interfaces.Beber beber) {
        Nombre = nombre;
        Edad = edad;
        Peso = peso;
        Orinar = orinar;
        Beber = beber;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer edad) {
        Edad = edad;
    }

    public Integer getPeso() {
        return Peso;
    }

    public void setPeso(Integer peso) {
        Peso = peso;
    }

    public ChrisTP.Interfaces.Orinar getOrinar() {
        return Orinar;
    }

    public void setOrinar(ChrisTP.Interfaces.Orinar orinar) {
        Orinar = orinar;
    }

    public ChrisTP.Interfaces.Beber getBeber() {
        return Beber;
    }

    public void setBeber(ChrisTP.Interfaces.Beber beber) {
        Beber = beber;
    }
}
