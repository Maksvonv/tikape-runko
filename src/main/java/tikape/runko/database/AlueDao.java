package tikape.runko.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tikape.runko.domain.Alue;
import tikape.runko.domain.Avaus;

public class AlueDao implements Dao<Alue, Integer> {

    private Database database;

    public AlueDao(Database database) {
        this.database = database;
    }

    @Override
    public Alue findOne(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Alue WHERE id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Integer id = rs.getInt("id");
        String alueen_nimi = rs.getString("alueen_nimi");

        Alue o = new Alue(id, alueen_nimi);

        rs.close();
        stmt.close();
        connection.close();

        return o;
    }

    @Override
    public List<Alue> findAll() throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Alue");

        ResultSet rs = stmt.executeQuery();
        List<Alue> alue = new ArrayList<>();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String alueen_nimi = rs.getString("alueen_nimi");

            alue.add(new Alue(id, alueen_nimi));

        }
        rs.close();
        stmt.close();
        connection.close();

        return alue;
    }

    public List<Alue> viestien_maara() throws SQLException { //huonosti nimetty ja timestamp puuttuu

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("select alue.id, alue.alueen_nimi, count(viesti.id) as ketjujen_maara, MAX(viesti.aikaleima) AS viimeisin_viesti FROM Alue LEFT JOIN Avaus ON avaus.alue = alue.id LEFT JOIN  Viesti ON  viesti.avaus = avaus.id GROUP BY alue.id ORDER BY Alue.alueen_nimi ASC");
        //"SELECT Alue.alueen_nimi, COUNT(DISTINCT Avaus.id) AS ketjujen_maara, MAX(viesti.aikaleima) AS Uusin_viesti FROM Viesti, Avaus, Alue WHERE Avaus.alue = Alue.id AND Viesti.avaus = Avaus.id GROUP BY Alue.id"
        ResultSet rs = stmt.executeQuery();
        List<Alue> alue = new ArrayList<>();
        
     
        
        
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String alueen_nimi = rs.getString("alueen_nimi");
            Integer ketjujen_maara = rs.getInt("ketjujen_maara");
            String viimeisin_viesti = rs.getString("viimeisin_viesti");
            
            
          
            alue.add(new Alue(id, alueen_nimi, ketjujen_maara, viimeisin_viesti));
        }

        rs.close();
        stmt.close();
        connection.close();

        return alue;

    }

    public void lisaa(String alue) throws SQLException {
        Connection connection = database.getConnection();

        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Alue (alueen_nimi) VALUES (?)");

        stmt.setObject(1, alue);
   

        stmt.executeUpdate();

        stmt.close();
        connection.close();
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
