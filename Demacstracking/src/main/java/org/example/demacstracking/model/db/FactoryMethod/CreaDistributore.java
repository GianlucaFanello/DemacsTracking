package org.example.demacstracking.model.db.FactoryMethod;

public class CreaDistributore extends StrutturaFactory{
    @Override
    public Struttura creaStruttura() {
        return Distributore();
    }

    @Override
    public boolean salva() {
        return false;
    }
}
