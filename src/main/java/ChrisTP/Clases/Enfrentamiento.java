package ChrisTP.Clases;

import java.util.concurrent.TimeUnit;

public class Enfrentamiento {
    private Vikingo vikingo;
    private Espartano espartano;
    private Integer cantidad_maxima_frescas;

    public Enfrentamiento(Vikingo vikingo, Espartano espartano, Integer cantidad_maxima_frescas) throws InterruptedException {
        this.setVikingo(vikingo);
        this.setEspartano(espartano);
        this.setCantidad_maxima_frescas(cantidad_maxima_frescas);
        Batalla(this.getVikingo(), this.getEspartano());
    }


    public Vikingo getVikingo() {
        return vikingo;
    }

    public void setVikingo(Vikingo vikingo) {
        this.vikingo = vikingo;
    }

    public Espartano getEspartano() {
        return espartano;
    }

    public void setEspartano(Espartano espartano) {
        this.espartano = espartano;
    }

    public Integer getCantidad_maxima_frescas() {
        return cantidad_maxima_frescas;
    }

    public void setCantidad_maxima_frescas(Integer cantidad_maxima_frescas) {
        this.cantidad_maxima_frescas = cantidad_maxima_frescas;
    }

    private Humano Batalla(Vikingo vikingo, Espartano espartano) throws InterruptedException {
        int numero_ronda = 1;
        boolean ganador = false;
        System.out.println("ENFRENTAMIENTO -- VIKINGO: "+vikingo.getNombre()+ " VS Espartano: "+espartano.getNombre());
        TimeUnit.SECONDS.sleep(1);
        while (!ganador && numero_ronda<=cantidad_maxima_frescas) {
            System.out.println(String.format("Numero de Ronda %d", numero_ronda));
            TimeUnit.SECONDS.sleep(2);
            int valor_vikingo = vikingo.beberViking();
            int valor_espartano = espartano.beberEspartano();
            vikingo.setCantidad_cerveza(vikingo.getCantidad_cerveza()+10);
            espartano.setCantidad_cerveza(espartano.getCantidad_cerveza()+6);
            System.out.println("Cantidad de Bebida en cuerpo: VIKINGO: "+vikingo.getCantidad_cerveza()+" - Espartano: "+espartano.getCantidad_cerveza());
            if(valor_vikingo == 3 && valor_espartano != 3 && vikingo.getCantidad_cerveza()>10)
            {
                System.out.println("El vikingo debe ir al baño");
                TimeUnit.SECONDS.sleep(1);
                //Debe Orinar
                int valor_orina = vikingo.getOrinar().ir_baño();
                vikingo.setCantidad_cerveza(vikingo.getCantidad_cerveza()-15);
                if(valor_orina == 4)
                {
                    System.out.println("El Espartano gano");
                    TimeUnit.SECONDS.sleep(1);
                    ganador = true;
                    return (Humano)espartano;
                }
                System.out.println("Cantidad de Bebida en cuerpo: VIKINGO: "+vikingo.getCantidad_cerveza()+" - Espartano: "+espartano.getCantidad_cerveza());

            }
            if(valor_espartano == 5 && valor_vikingo != 5 && espartano.getCantidad_cerveza()>6)
            {
                System.out.println("El espartano debe ir al baño");
                TimeUnit.SECONDS.sleep(1);
                espartano.setCantidad_cerveza(espartano.getCantidad_cerveza()-3);
                //Debe Orinar
                int valor_orina = espartano.getOrinar().ir_baño();
                if(valor_orina == 3)
                {
                    System.out.println("El vikingo gano");
                    TimeUnit.SECONDS.sleep(1);
                    ganador = true;
                    return (Humano)vikingo;
                }
                System.out.println("Cantidad de Bebida en cuerpo: VIKINGO: "+vikingo.getCantidad_cerveza()+" - Espartano: "+espartano.getCantidad_cerveza());


            }
            numero_ronda ++;
        }
        if(vikingo.getCantidad_cerveza() > espartano.getCantidad_cerveza())
        {
            System.out.println("El vikingo gano");
            TimeUnit.SECONDS.sleep(1);
            ganador = true;
            return (Humano)vikingo;
        }
        else if(vikingo.getCantidad_cerveza() < espartano.getCantidad_cerveza())
        {
            System.out.println("El Espartano gano");
            TimeUnit.SECONDS.sleep(1);
            ganador = true;
            return (Humano)espartano;
        }
        else {
            return null;
        }


    }
}
