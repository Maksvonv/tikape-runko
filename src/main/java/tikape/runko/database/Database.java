package tikape.runko.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private String databaseAddress;

    public Database(String databaseAddress) throws ClassNotFoundException {
        this.databaseAddress = databaseAddress;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }

    public void init() {
        List<String> lauseet = sqliteLauseet();

        // "try with resources" sulkee resurssin automaattisesti lopuksi
        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();

            // suoritetaan komennot
            for (String lause : lauseet) {
                System.out.println("Running command >> " + lause);
                st.executeUpdate(lause);
            }

        } catch (Throwable t) {
            // jos tietokantataulu on jo olemassa, ei komentoja suoriteta
            System.out.println("Error >> " + t.getMessage());
        }
    }

    private List<String> sqliteLauseet() {
        ArrayList<String> lista = new ArrayList<>();

        // tietokantataulujen luomiseen tarvittavat komennot suoritusjärjestyksessä
//        lista.add("CREATE TABLE Opiskelija (id integer PRIMARY KEY, nimi varchar(255));");
//        lista.add("INSERT INTO Opiskelija (nimi) VALUES ('Platon');");
//        lista.add("INSERT INTO Opiskelija (nimi) VALUES ('Aristoteles');");
//        lista.add("INSERT INTO Opiskelija (nimi) VALUES ('Homeros');");
        lista.add("CREATE TABLE Alue (id INTEGER PRIMARY KEY, alueen_nimi VARCHAR(50) NOT NULL);");
        lista.add("CREATE TABLE Avaus (id INTEGER PRIMARY KEY, alue INTEGER NOT NULL, avauksen_nimi VARCHAR(30) NOT NULL, FOREIGN KEY (alue) REFERENCES Avaus(id));");
        lista.add("CREATE TABLE Viesti (id INTEGER PRIMARY KEY, avaus INTEGER NOT NULL, aikaleima TIMESTAMP, nimimerkki VARCHAR(20) NOT NULL, viestin_sisalto VARCHAR(500) NOT NULL, FOREIGN KEY (avaus) REFERENCES Avaus(id));");
        

        lista.add("INSERT INTO Alue VALUES (1, 'maahanmuutto');");
        lista.add("INSERT INTO Alue VALUES (2, 'suomenkesä');");
        lista.add("INSERT INTO Alue VALUES (3, 'autokauppa');");
        lista.add("INSERT INTO Viesti VALUES (1,1, CURRENT_TIMESTAMP, 'tippat', 'yolo');");
        lista.add("INSERT INTO Viesti VALUES (2,2, CURRENT_TIMESTAMP, 'sairast', 'molo');");
        lista.add("INSERT INTO Viesti VALUES (3,3, CURRENT_TIMESTAMP, 'paperit', 'kolo');");
        lista.add("INSERT INTO Avaus VALUES (1,1, 'herranjestas');");
        lista.add("INSERT INTO Avaus VALUES (2,1, 'tietoja');");
        lista.add("INSERT INTO Avaus VALUES (3,2, 'keskustelua viljamista');");

        return lista;
    }
}
