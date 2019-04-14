package ChrisTP;

import ChrisTP.Clases.*;

import java.sql.SQLException;
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
        List<Vikingo> vikingos = new ArrayList<Vikingo>(Arrays.asList(
                new Vikingo("Juan",35,78, 1),
                new Vikingo("Alan",28,60, 1),
                new Vikingo("Fernando",54,97, 1)
        ));

        vikingos.sort(Comparator.comparingInt(Vikingo::getPeso));

        List<Espartano> espartanos = new ArrayList<Espartano>(Arrays.asList(
                new Espartano("Marcelo",48,67, 2),
                new Espartano("Damian",33,89, 2),
                new Espartano("Alex",29,72, 2)));

        espartanos.sort(Comparator.comparingInt(Espartano::getPeso));


        try {

            System.out.println("PRESENTACION DE VIKINGOS:");
            vikingos.stream().forEach(h -> System.out.println(h));
            TimeUnit.SECONDS.sleep(2);
            System.out.println("PRESENTACION DE ESPARTANOS:");
            espartanos.stream().forEach(h -> System.out.println(h));
            TimeUnit.SECONDS.sleep(2);


            Torneo torneo = new Torneo(vikingos,espartanos,3);
            torneo.comenzar();
            torneo.resultados();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
