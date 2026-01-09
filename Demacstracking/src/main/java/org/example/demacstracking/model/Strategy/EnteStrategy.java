package org.example.demacstracking.model.Strategy;

public class EnteStrategy implements RoleStrategy {


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
        return false;
    }

    @Override
    public boolean puoVisualizzareSegnalazioni() {
        return true;
    }
}
