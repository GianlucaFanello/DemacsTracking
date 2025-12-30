package org.example.demacstracking.model.db.FactoryMethod;

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
