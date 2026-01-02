package org.example.demacstracking.model.FactoryMethod;

import org.example.demacstracking.model.dto.strutture.Aula;
import org.example.demacstracking.model.dto.strutture.Struttura;

public class CreaAula extends StrutturaFactory {

    @Override
    public Struttura creaStruttura() {
        return new Aula();
    }

}
