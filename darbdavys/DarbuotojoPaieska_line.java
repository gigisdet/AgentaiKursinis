package darbdavys;


import darbdavys.*;

/**
* Protege name: DarbuotojoPaieska_line
* @author ontology bean generator
* @version 2019/05/18, 11:59:16
*/
public class DarbuotojoPaieska_line implements DarbuotojoPaieska_lineIf {

  private static final long serialVersionUID = 7030251501279179338L;

  private String _internalInstanceName = null;

  public DarbuotojoPaieska_line() {
    this._internalInstanceName = "";
  }

  public DarbuotojoPaieska_line(String instance_name) {
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
   * Protege name: Reikalingas_stazas
   */
   private int reikalingas_stazas;
   public void setReikalingas_stazas(int value) { 
    this.reikalingas_stazas=value;
   }
   public int getReikalingas_stazas() {
     return this.reikalingas_stazas;
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
