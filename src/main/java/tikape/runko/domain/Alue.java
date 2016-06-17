
package tikape.runko.domain;

public class Alue {
    
    private Integer id;
    private String alueen_nimi;

    public Alue(Integer id, String alueen_nimi) {
        this.id = id;
        this.alueen_nimi = alueen_nimi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlueen_nimi() {
        return alueen_nimi;
    }

    public void setAlueen_nimi(String alueen_nimi) {
        this.alueen_nimi = alueen_nimi;
    }
    
    
}
