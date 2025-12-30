package main.java.org.example.demacstracking.model.dto.strutture;

public class Segreteria extends Struttura {
    public int id;
    public Segreteria() {}
    public Segreteria(int id,String ubicazione,  String cubo) {
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
