package main.java.org.example.demacstracking.model.FactoryMethod;

import main.java.org.example.demacstracking.model.dto.strutture.Aula;
import main.java.org.example.demacstracking.model.dto.strutture.Struttura;

public class CreaAula extends StrutturaFactory {

    @Override
    public Struttura creaStruttura() {
        return new Aula();
    }

    @Override
    public boolean salva() {
        return false;
    }
}
