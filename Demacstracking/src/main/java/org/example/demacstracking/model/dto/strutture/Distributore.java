package org.example.demacstracking.model.dto.strutture;

public class Distributore extends Struttura {
    public int id;
    public Distributore() {}
    public Distributore(int id,String ubicazione,  String cubo) {
        this.id = id;
        this.ubicazione = ubicazione;
        this.cubo = cubo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
