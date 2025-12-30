package org.example.demacstracking.model.db.FactoryMethod;

public class Segreteria extends Struttura {
    public int id;
    public Segreteria() {}
    public Segreteria(int id,String ubicazione,  String cubo) {
        this.id = id;
        this.ubicazione = ubicazione;
        this.cubo = cubo;
    }

}
