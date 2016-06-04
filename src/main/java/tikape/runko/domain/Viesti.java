
package tikape.runko.domain;

public class Viesti {
    
    private Integer id;
    private String avaus;
    //private timestamp 
    private String nimimerkki;
    private String viestin_sisalto; //ö?
    private Integer vastaus_viestiin;



    public Viesti(Integer id, String avaus, String nimimerkki, String viestin_sisalto, Integer vastaus_viestiin) {
        this.id = id;
        this.avaus = avaus;
        this.nimimerkki = nimimerkki;
        this.viestin_sisalto = viestin_sisalto;
        this.vastaus_viestiin = vastaus_viestiin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getAvaus() {
        return avaus;
    }

    public void setAvaus(String avaus) {
        this.avaus = avaus;
    }

    public String getNimimerkki() {
        return nimimerkki;
    }

    public void setNimimerkki(String nimimerkki) {
        this.nimimerkki = nimimerkki;
    }

    public String getViestin_sisalto() {
        return viestin_sisalto;
    }

    public void setViestin_sisalto(String viestin_sisalto) {
        this.viestin_sisalto = viestin_sisalto;
    }

    public Integer getVastaus_viestiin() {
        return vastaus_viestiin;
    }

    public void setVastaus_viestiin(Integer vastaus_viestiin) {
        this.vastaus_viestiin = vastaus_viestiin;
    }
    
    
    
    



    
    

    
}
