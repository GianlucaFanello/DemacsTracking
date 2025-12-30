package org.example.demacstracking.model.db.FactoryMethod;

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
