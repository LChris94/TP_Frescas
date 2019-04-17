package ChrisTP.Clases;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Enfrentamiento {
    private Humano humano1;
    private Humano humano2;
    private Integer cantidad_maxima_frescas;

    public Enfrentamiento(Humano humano1, Humano humano2, Integer cantidad_maxima_frescas) throws InterruptedException {
        this.setHumano1(humano1);
        this.setHumano2(humano2);
        this.setCantidad_maxima_frescas(cantidad_maxima_frescas);
    }


    public Humano getHumano1() {
        return humano1;
    }

    public void setHumano1(Humano humano) {
        this.humano1 = humano;
    }

    public Humano getHumano2() {
        return humano2;
    }

    public void setHumano2(Humano humano) {
        this.humano2 = humano;
    }

    public Integer getCantidad_maxima_frescas() {
        return cantidad_maxima_frescas;
    }

    public void setCantidad_maxima_frescas(Integer cantidad_maxima_frescas) {
        this.cantidad_maxima_frescas = cantidad_maxima_frescas;
    }

    public Humano Batalla() throws InterruptedException {

        int numero_ronda = 1;
        boolean ganador = false;




        System.out.println("ENFRENTAMIENTO -- "+getRaza(humano1)+": "+humano1.getNombre()+ " VS "+getRaza(humano2)+": "+humano2.getNombre());
        TimeUnit.SECONDS.sleep(1);

        while (!ganador && numero_ronda<=cantidad_maxima_frescas) {

            System.out.println(String.format("Numero de Ronda %d", numero_ronda));
            TimeUnit.SECONDS.sleep(2);

            int valor_humano1 = 0;
            int valor_humano2 = 0;

            if(humano1 instanceof Vikingo)
            {
                valor_humano1 = ((Vikingo)humano1).beberViking();
            }
            if(humano1 instanceof Espartano)
            {
                valor_humano1 = ((Espartano)humano1).beberEspartano();
            }
            if(humano2 instanceof Espartano)
            {
                valor_humano2 = ((Espartano)humano2).beberEspartano();
            }
            if(humano2 instanceof Boss)
            {
                valor_humano2 = ((Boss)humano2).beberViking();
            }




            System.out.println("Cantidad de Bebida en cuerpo: "+getRaza(humano1)+": "+humano1.getCantidad_cerveza()+" - "+getRaza(humano2)+": "+humano2.getCantidad_cerveza());

            if(valor_humano1 == 3 && valor_humano2 != 3 && humano1.getCantidad_cerveza()>10)
            {
                System.out.println("El "+getRaza(humano1)+" debe ir al baño");
                TimeUnit.SECONDS.sleep(1);
                //Debe Orinar
                int valor_orina = humano1.getOrinar().ir_baño();
                humano1.setCantidad_cerveza(humano1.getCantidad_cerveza()-15);
                if(valor_orina == 4)
                {
                    System.out.println("El "+getRaza(humano2)+" gano, el "+getRaza(humano1)+" se orino.");
                    TimeUnit.SECONDS.sleep(1);
                    ganador = true;
                    return (Humano)humano2;
                }
                System.out.println("Cantidad de Bebida en cuerpo: "+getRaza(humano1)+": "+humano1.getCantidad_cerveza()+" - "+getRaza(humano2)+": "+humano2.getCantidad_cerveza());

            }

            if(valor_humano1 == 5 && valor_humano2 != 5 && humano2.getCantidad_cerveza()>6)
            {
                System.out.println("El "+getRaza(humano2)+" debe ir al baño");
                TimeUnit.SECONDS.sleep(1);
                humano2.setCantidad_cerveza(humano2.getCantidad_cerveza()-3);
                //Debe Orinar
                int valor_orina = humano2.getOrinar().ir_baño();
                if(valor_orina == 3)
                {
                    System.out.println("El "+getRaza(humano1)+" gano, el "+getRaza(humano2)+" se orino.");
                    TimeUnit.SECONDS.sleep(1);
                    ganador = true;
                    return (Humano)humano1;
                }
                System.out.println("Cantidad de Bebida en cuerpo: "+getRaza(humano1)+": "+humano1.getCantidad_cerveza()+" - "+getRaza(humano1)+": "+humano2.getCantidad_cerveza());


            }
            numero_ronda ++;
        }
        if(humano1.getCantidad_cerveza() > humano2.getCantidad_cerveza())
        {
            System.out.println("El "+getRaza(humano1)+" gano");
            TimeUnit.SECONDS.sleep(1);
            ganador = true;
            return (Humano)humano1;
        }
        else if(humano1.getCantidad_cerveza() < humano2.getCantidad_cerveza())
        {
            System.out.println("El "+getRaza(humano2)+" gano");
            TimeUnit.SECONDS.sleep(1);
            ganador = true;
            return (Humano)humano2;
        }
        else {//Si son iguales van a sorteo 0-Vikingo 1-Espartano
            Random rand = new Random();
            int numero = rand.nextInt(2);
            switch (numero)
            {
                case 0:
                    return (Humano)humano1;
                case 1:
                    return (Humano)humano2;
                default:
                    return null;

            }

        }


    }

    public String getRaza(Humano h)
    {
        if(h instanceof Vikingo)
        {
            return "Vikingo";
        }
        else if(h instanceof Espartano)
        {
            return "Espartano";
        }
        else if(h instanceof Boss)
        {
            return "Dueño Taberna";
        }
        else
        {
            return "Indefinido";
        }

    }
}
