package darbdavys;


import jade.util.leap.*;
import darbdavys.*;

/**
* Protege name: Imones_Info
* @author ontology bean generator
* @version 2019/05/18, 11:59:16
*/
public class Imones_Info implements Imones_InfoIf {

  private static final long serialVersionUID = 7030251501279179338L;

  private String _internalInstanceName = null;

  public Imones_Info() {
    this._internalInstanceName = "";
  }

  public Imones_Info(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: Pavadinimas
   */
   private String pavadinimas;
   public void setPavadinimas(String value) { 
    this.pavadinimas=value;
   }
   public String getPavadinimas() {
     return this.pavadinimas;
   }

   /**
   * Protege name: Darbas
   */
   private List darbas = new ArrayList();
   public void addDarbas(Darbo_Info elem) { 
     darbas.add(elem);
   }
   public boolean removeDarbas(Darbo_Info elem) {
     boolean result = darbas.remove(elem);
     return result;
   }
   public void clearAllDarbas() {
     darbas.clear();
   }
   public Iterator getAllDarbas() {return darbas.iterator(); }
   public List getDarbas() {return darbas; }
   public void setDarbas(List l) {darbas = l; }

   /**
   * Protege name: GID
   */
   private int giD;
   public void setGID(int value) { 
    this.giD=value;
   }
   public int getGID() {
     return this.giD;
   }

   /**
   * Protege name: Vadovas
   */
   private String vadovas;
   public void setVadovas(String value) { 
    this.vadovas=value;
   }
   public String getVadovas() {
     return this.vadovas;
   }

}
