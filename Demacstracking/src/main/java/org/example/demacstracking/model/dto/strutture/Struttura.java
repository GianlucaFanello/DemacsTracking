package main.java.org.example.demacstracking.model.dto.strutture;

public abstract class Struttura {
    public String ubicazione;
    public String cubo;

    public String getUbicazione() {
        return ubicazione;
    }

    public void setUbicazione(String ubicazione) {
        this.ubicazione = ubicazione;
    }

    public String getCubo() {
        return cubo;
    }

    public void setCubo(String cubo) {
        this.cubo = cubo;
    }
}
