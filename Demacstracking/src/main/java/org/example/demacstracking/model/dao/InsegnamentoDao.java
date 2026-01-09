package org.example.demacstracking.model.dao;

import org.example.demacstracking.model.db.DBManager;
import org.example.demacstracking.model.dto.Insegnamento;
import org.example.demacstracking.service.utenteService.VisualizzazioneCorrente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsegnamentoDao {

    public InsegnamentoDao() {}

    public boolean  inserisciInsegnamento(Insegnamento insegnamento) throws SQLException{
        String query = "INSERT INTO insegnamento (id,nome,cfu,descrizione,docente) VALUES (?,?,?,?,?) ";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query);
        ){
            stmt.setString(1, insegnamento.getId());
            stmt.setString(2, insegnamento.getNome());
            stmt.setInt(3, insegnamento.getCfu());
            stmt.setString(4, insegnamento.getDescrizione());
            stmt.setString(5, insegnamento.getDocente());

            return stmt.executeUpdate() > 0;
        }
    }

    public boolean modificaInsegnamento(Insegnamento insegnamento) throws SQLException{
        String query = "UPDATE insegnamento SET nome=?, cfu=?, descrizione=?, docente=? WHERE id=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ){
            stmt.setString(1, insegnamento.getNome());
            stmt.setInt(2, insegnamento.getCfu());
            stmt.setString(3, insegnamento.getDescrizione());
            stmt.setString(4, insegnamento.getDocente());
            stmt.setString(5, insegnamento.getId());

            return stmt.executeUpdate() > 0;
        }
    }

    public void eliminaInsegnamento(String id) throws SQLException{

        try (Connection connection = DBManager.getInstance().getConnection()) {
            String query = "DELETE FROM facolta_insegnamento WHERE insegnamento = ? AND facolta = ?";

            try (PreparedStatement ps = connection.prepareStatement(query)
            ) {
                ps.setString(1, id);
                ps.setString(2, VisualizzazioneCorrente.getInstance().getFacoltaCorrente().getNome());
                ps.executeUpdate();
            }

            String query1 = "DELETE FROM insegnamento WHERE id = ? AND NOT EXISTS (" +
                    "SELECT 1 FROM facolta_insegnamento WHERE insegnamento = ? )";

            // Cancella l'insegnamento solo se non ci sono più associazioni
            try (PreparedStatement ps = connection.prepareStatement(query1)
            ) {
                ps.setString(1, id);
                ps.setString(2, id);
                ps.executeUpdate();
            }
        }
    }

    public Insegnamento prendiInsegnamentoConId(Insegnamento insegnamento) throws SQLException{
        String  query = "SELECT cfu,descrizione,docente FROM insegnamento WHERE id=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)

        ) {
            stmt.setString(1, insegnamento.getId());

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String descrizione = rs.getString("descrizione");
                String docente = rs.getString("docente");
                int cfu = rs.getInt("cfu");

                insegnamento.setDescrizione(descrizione);
                insegnamento.setDocente(docente);
                insegnamento.setCfu(cfu);
            }
            return insegnamento;
        }
    }

    public List<Insegnamento> prendiAllInsegnamentoFacoltaPerAnno() throws SQLException{
        String query = "SELECT i.id,i.nome FROM insegnamento i " +
                "INNER JOIN facolta_insegnamento f ON i.id = f.insegnamento " +
                "WHERE f.facolta = ? AND f.anno = ?";
        List<Insegnamento> insegnamenti = new ArrayList<>();

        try (Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(query)
        ){
            stmt.setString(1, VisualizzazioneCorrente.getInstance().getFacoltaCorrente().getNome());
            stmt.setInt(2, VisualizzazioneCorrente.getInstance().getAnno());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String nome = rs.getString("nome");

                Insegnamento  insegnamento = new Insegnamento(id,nome);
                insegnamenti.add(insegnamento);
            }
            return insegnamenti;
        }
    }

    public boolean idPresente(String id) throws SQLException {
        String query = "SELECT 1 FROM insegnamento WHERE id=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query)
        ){
            stmt.setString(1, id);

            return stmt.executeQuery().next();
        }
    }

    public boolean associazionePresente(String id, String nome) throws SQLException{
        String query = "SELECT 1 FROM facolta_insegnamento WHERE insegnamento=? AND facolta=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query);
        ) {
            stmt.setString(1, id);
            stmt.setString(2, nome);

            return stmt.executeQuery().next();
        }
    }

    public boolean inserisciAssociazione(Insegnamento insegnamento, String anno, String facolta) throws SQLException {
        String query = "INSERT INTO facolta_insegnamento (facolta,insegnamento,anno) VALUES (?,?,?)";

        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)
        ){
            stmt.setString(1, facolta);
            stmt.setString(2, insegnamento.getId());
            stmt.setString(3, anno);

            return stmt.executeUpdate() > 0;
        }
    }

    public boolean modificaAssociazione(int anno) throws SQLException {
        String query = "UPDATE facolta_insegnamento SET anno = ? WHERE insegnamento=? AND facolta=?";

        try ( Connection connection = DBManager.getInstance().getConnection();
              PreparedStatement stmt = connection.prepareStatement(query);
        ) {
            stmt.setInt(1, anno);
            stmt.setString(2, VisualizzazioneCorrente.getInstance().getInsegnamentoCorrente().getId());
            stmt.setString(3, VisualizzazioneCorrente.getInstance().getFacoltaCorrente().getNome());


            System.out.println("Anno: " + anno +
                    " Insegnamento: " + VisualizzazioneCorrente.getInstance().getInsegnamentoCorrente().getNome() +
                    " Facoltà: " + VisualizzazioneCorrente.getInstance().getFacoltaCorrente().getNome());

            return stmt.executeUpdate() > 0;
        }
    }
}
