package darbdavys2.ontology;


import darbdavys2.ontology.*;

/**
* Protege name: Darbo_Info
* @author ontology bean generator
* @version 2019/05/18, 19:35:23
*/
public class Darbo_Info implements Darbo_InfoIf {

  private static final long serialVersionUID = -8790461207074255633L;

  private String _internalInstanceName = null;

  public Darbo_Info() {
    this._internalInstanceName = "";
  }

  public Darbo_Info(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: Pozicija
   */
   private String pozicija;
   public void setPozicija(String value) { 
    this.pozicija=value;
   }
   public String getPozicija() {
     return this.pozicija;
   }

   /**
   * Protege name: Valandos
   */
   private int valandos;
   public void setValandos(int value) { 
    this.valandos=value;
   }
   public int getValandos() {
     return this.valandos;
   }

   /**
   * Protege name: ID
   */
   private int iD;
   public void setID(int value) { 
    this.iD=value;
   }
   public int getID() {
     return this.iD;
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
   * Protege name: Atlyginimas
   */
   private int atlyginimas;
   public void setAtlyginimas(int value) { 
    this.atlyginimas=value;
   }
   public int getAtlyginimas() {
     return this.atlyginimas;
   }

   /**
   * Protege name: Reikalingas_Stazas
   */
   private int reikalingas_Stazas;
   public void setReikalingas_Stazas(int value) { 
    this.reikalingas_Stazas=value;
   }
   public int getReikalingas_Stazas() {
     return this.reikalingas_Stazas;
   }

}
