
package tikape.runko.domain;


public class Avaus {
    
    private Integer id;
    private Integer alue;
    private String avauksen_otsikko;
    private String avauksen_sisalto; //ö?
    private String nimimerkki;

    public Avaus(Integer id, Integer alue, String avauksen_otsikko, String avauksen_sisalto, String nimimerkki) {
        this.id = id;
        this.alue = alue;
        this.avauksen_otsikko = avauksen_otsikko;
        this.avauksen_sisalto = avauksen_sisalto;
        this.nimimerkki = nimimerkki;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlue() {
        return alue;
    }

    public void setAlue(Integer alue) {
        this.alue = alue;
    }

    public String getAvauksen_otsikko() {
        return avauksen_otsikko;
    }

    public void setAvauksen_otsikko(String avauksen_otsikko) {
        this.avauksen_otsikko = avauksen_otsikko;
    }

    public String getAvauksen_sisalto() {
        return avauksen_sisalto;
    }

    public void setAvauksen_sisalto(String avauksen_sisalto) {
        this.avauksen_sisalto = avauksen_sisalto;
    }

    public String getNimimerkki() {
        return nimimerkki;
    }

    public void setNimimerkki(String nimimerkki) {
        this.nimimerkki = nimimerkki;
    }
    
    
    
    
    
    
}
