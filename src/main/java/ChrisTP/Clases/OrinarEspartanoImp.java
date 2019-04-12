package ChrisTP.Clases;

import ChrisTP.Interfaces.Orinar;

import java.util.Random;

public class OrinarEspartanoImp implements Orinar {

    @Override
    public Integer ir_baño() {
        Random rand = new Random();
        return rand.nextInt(3);
    }
}
