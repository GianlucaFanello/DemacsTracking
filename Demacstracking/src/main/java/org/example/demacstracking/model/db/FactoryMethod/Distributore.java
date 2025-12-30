package org.example.demacstracking.model.db.FactoryMethod;

public class Distributore extends Struttura {
    public int id;
    public Distributore() {}
    public Distributore(int id,String ubicazione,  String cubo) {
        this.id = id;
        this.ubicazione = ubicazione;
        this.cubo = cubo;
    }

}
