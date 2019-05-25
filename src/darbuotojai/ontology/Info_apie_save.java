package darbuotojai.ontology;


import darbuotojai.ontology.*;

/**
* Protege name: Info_apie_save
* @author ontology bean generator
* @version 2019/05/25, 18:41:34
*/
public class Info_apie_save implements Info_apie_saveIf {

  private static final long serialVersionUID = 48383569307505051L;

  private String _internalInstanceName = null;

  public Info_apie_save() {
    this._internalInstanceName = "";
  }

  public Info_apie_save(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: Vardas
   */
   private String vardas;
   public void setVardas(String value) { 
    this.vardas=value;
   }
   public String getVardas() {
     return this.vardas;
   }

   /**
   * Protege name: Pavarde
   */
   private String pavarde;
   public void setPavarde(String value) { 
    this.pavarde=value;
   }
   public String getPavarde() {
     return this.pavarde;
   }

   /**
   * Protege name: Stazas
   */
   private int stazas;
   public void setStazas(int value) { 
    this.stazas=value;
   }
   public int getStazas() {
     return this.stazas;
   }

   /**
   * Protege name: Miestas
   */
   private String miestas;
   public void setMiestas(String value) { 
    this.miestas=value;
   }
   public String getMiestas() {
     return this.miestas;
   }

   /**
   * Protege name: Ieskoma_darbo_pozicija
   */
   private String ieskoma_darbo_pozicija;
   public void setIeskoma_darbo_pozicija(String value) { 
    this.ieskoma_darbo_pozicija=value;
   }
   public String getIeskoma_darbo_pozicija() {
     return this.ieskoma_darbo_pozicija;
   }

   /**
   * Protege name: Atlyginimas
   */
   private int atlyginimas;
   public void setAtlyginimas(int value) { 
    this.atlyginimas=value;
   }
   public int getAtlyginimas() {
     return this.atlyginimas;
   }

}
