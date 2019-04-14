package ChrisTP.Clases;

public class Espartano extends Humano {
    private Integer ToleranciaExtra;
    private Integer cantidad_cerveza =0;

    public Espartano(String nombre, Integer edad, Integer peso, Integer ToleranciaExtra) {
        super(nombre, edad, peso, new OrinarEspartanoImp(), new BeberEstapartanoImp());
        setToleranciaExtra(ToleranciaExtra);
    }

    public Integer getToleranciaExtra() {
        return ToleranciaExtra;
    }

    public void setToleranciaExtra(Integer toleranciaExtra) {
        ToleranciaExtra = toleranciaExtra;
    }

    public Integer beberEspartano()
    {
        this.setCantidad_cerveza(this.getCantidad_cerveza()+6);
        return this.getBeber().tomar_fresca()+this.getToleranciaExtra();
    }

    @Override
    public String toString() {
        return "Nombre:'" + Nombre + '\'' +
                ", Edad:" + Edad +
                ", Peso:" + Peso;
    }

    public Integer getCantidad_cerveza() {
        return cantidad_cerveza;
    }

    public void setCantidad_cerveza(Integer cantidad_cerveza) {
        this.cantidad_cerveza = cantidad_cerveza;
    }
}
