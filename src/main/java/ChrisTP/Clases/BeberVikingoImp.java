package ChrisTP.Clases;

import ChrisTP.Interfaces.Beber;

import java.util.Random;

public class BeberVikingoImp implements Beber {

    @Override
    public Integer tomar_fresca() {
        Random rand = new Random();
        return rand.nextInt(4);
    }
}
