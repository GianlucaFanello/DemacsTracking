package org.example.demacstracking.model.FactoryMethod;

import org.example.demacstracking.model.dto.strutture.Distributore;
import org.example.demacstracking.model.dto.strutture.Struttura;

public class CreaDistributore extends StrutturaFactory{
    @Override
    public Struttura creaStruttura() {
        return new Distributore();
    }

}
