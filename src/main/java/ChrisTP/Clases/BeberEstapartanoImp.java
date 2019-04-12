package ChrisTP.Clases;

import ChrisTP.Interfaces.Beber;

import java.util.Random;

public class BeberEstapartanoImp implements Beber {

    @Override
    public Integer tomar_fresca() {
        Random rand = new Random();
        return rand.nextInt(7);
    }
}
