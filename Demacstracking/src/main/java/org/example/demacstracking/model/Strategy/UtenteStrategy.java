package org.example.demacstracking.model.Strategy;

public class UtenteStrategy implements RoleStrategy {

    @Override
    public boolean puoCreare() {
        return false;
    }

    @Override
    public boolean puoModificare() {
        return false;
    }

    @Override
    public boolean puoEliminare() {
        return false;
    }

    @Override
    public boolean puoSegnalare() {
        return true;
    }
}
