package ChrisTP;

import ChrisTP.Clases.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Vikingo> participantes_vikingos = new ArrayList<Vikingo>(Arrays.asList(
                new Vikingo("Juan",35,78, 1),
                new Vikingo("Alan",28,60, 1),
                new Vikingo("Fernando",54,97, 1)
        ));

        List<Espartano> participantes_espartanos = new ArrayList<Espartano>(Arrays.asList(
                new Espartano("Marcelo",48,67, 2),
                new Espartano("Damian",33,89, 2),
                new Espartano("Alex",29,72, 2)));


        List<Vikingo> vikingos = participantes_vikingos.stream()
                .sorted(Comparator.comparingInt(Vikingo::getPeso))
                .collect(Collectors.toList());

        List<Espartano> espartanos = participantes_espartanos.stream()
                .sorted(Comparator.comparingInt(Espartano::getPeso))
                .collect(Collectors.toList());

        try {
            Presentar_Equipos(vikingos, espartanos);
            Torneo torneo = new Torneo(vikingos,espartanos,3);
            torneo.comenzar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private static void Presentar_Equipos(List<Vikingo> lista_Vikingos, List<Espartano> lista_Espartanos) throws InterruptedException {
        System.out.println("PRESENTACION DE VIKINGOS:");
        for (Vikingo h: lista_Vikingos) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(h.toString());
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println("PRESENTACION DE ESPARTANOS:");
        for (Espartano h: lista_Espartanos) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(h.toString());
        }
        TimeUnit.SECONDS.sleep(1);
    }
}
