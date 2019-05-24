package darbdavys2.ontology;


import jade.util.leap.*;
import darbdavys2.ontology.*;

/**
* Protege name: Imones_Info
* @author ontology bean generator
* @version 2019/05/18, 19:35:23
*/
public class Imones_Info implements Imones_InfoIf {

  private static final long serialVersionUID = -8790461207074255633L;

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
   * Protege name: Darbai
   */
   private List darbai = new ArrayList();
   public void addDarbai(Darbo_Info elem) { 
     darbai.add(elem);
   }
   public boolean removeDarbai(Darbo_Info elem) {
     boolean result = darbai.remove(elem);
     return result;
   }
   public void clearAllDarbai() {
     darbai.clear();
   }
   public Iterator getAllDarbai() {return darbai.iterator(); }
   public List getDarbai() {return darbai; }
   public void setDarbai(List l) {darbai = l; }

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
