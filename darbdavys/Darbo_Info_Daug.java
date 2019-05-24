package darbdavys;


import jade.util.leap.*;
import darbdavys.*;

/**
* Protege name: Darbo_Info_Daug
* @author ontology bean generator
* @version 2019/05/18, 11:59:16
*/
public class Darbo_Info_Daug implements Darbo_Info_DaugIf {

  private static final long serialVersionUID = 7030251501279179338L;

  private String _internalInstanceName = null;

  public Darbo_Info_Daug() {
    this._internalInstanceName = "";
  }

  public Darbo_Info_Daug(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: Darbo_Info_Vienetas
   */
   private List darbo_Info_Vienetas = new ArrayList();
   public void addDarbo_Info_Vienetas(Darbo_Info elem) { 
     darbo_Info_Vienetas.add(elem);
   }
   public boolean removeDarbo_Info_Vienetas(Darbo_Info elem) {
     boolean result = darbo_Info_Vienetas.remove(elem);
     return result;
   }
   public void clearAllDarbo_Info_Vienetas() {
     darbo_Info_Vienetas.clear();
   }
   public Iterator getAllDarbo_Info_Vienetas() {return darbo_Info_Vienetas.iterator(); }
   public List getDarbo_Info_Vienetas() {return darbo_Info_Vienetas; }
   public void setDarbo_Info_Vienetas(List l) {darbo_Info_Vienetas = l; }

}
