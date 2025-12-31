package org.example.demacstracking.model.FactoryMethod;

import org.example.demacstracking.model.dto.strutture.Segreteria;
import org.example.demacstracking.model.dto.strutture.Struttura;

public class CreaSegreteria extends StrutturaFactory{
    @Override
    public Struttura creaStruttura() {
        return new Segreteria();
    }

    @Override
    public boolean salva() {
        return false;
    }
}
