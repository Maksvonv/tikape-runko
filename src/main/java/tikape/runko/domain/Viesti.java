
package tikape.runko.domain;

public class Viesti {
    
    private Integer id;
    private Integer avaus;
    //private timestamp 
    private String nimimerkki;
    private String viestin_sisalto; //ö?



public Viesti(Integer id, Integer avaus, String nimimerkki, String viestin_sisalto) {
        this.id = id;
        this.avaus = avaus;
        this.nimimerkki = nimimerkki;
        this.viestin_sisalto = viestin_sisalto;
    }

 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getAvaus() {
        return avaus;
    }

    public void setAvaus(Integer avaus) {
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

    public void setViestin_sisältö(String viestin_sisalto) {
        this.viestin_sisalto = viestin_sisalto;
    }

    
    
    
    



    
    

    
}
