package main.java.org.example.demacstracking.model.FactoryMethod;

import main.java.org.example.demacstracking.model.dto.strutture.Distributore;
import main.java.org.example.demacstracking.model.dto.strutture.Struttura;

public class CreaDistributore extends StrutturaFactory{
    @Override
    public Struttura creaStruttura() {
        return new Distributore();
    }

    @Override
    public boolean salva() {
        return false;
    }
}
