package main.java.org.example.demacstracking.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.example.demacstracking.model.db.FactoryMethod.CreaAula;
import org.example.demacstracking.model.db.FactoryMethod.CreaDistributore;
import org.example.demacstracking.model.db.FactoryMethod.CreaSegreteria;
import org.example.demacstracking.model.db.FactoryMethod.StrutturaFactory;

public class CosaInserireController {
    public void tastoHome(MouseEvent mouseEvent) {
    }

    public void tastoInserisciAula(MouseEvent mouseEvent) {
        StrutturaFactory aulaFactory = new CreaAula();

    }

    public void tastoInserisciSegreteria(MouseEvent mouseEvent) {
        StrutturaFactory segreteriaFactory = new CreaSegreteria();
    }

    public void tastoInserisciDistributore(MouseEvent mouseEvent) {
        StrutturaFactory distributoreFactory = new CreaDistributore();
    }

    public void tastoIndietro(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.BACK_SPACE) {

        }

    }

    public void tastoLogOut(MouseEvent mouseEvent) {

    }
}
