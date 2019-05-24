package darbdavys.ontology;


import jade.util.leap.*;
import darbdavys.ontology.*;

/**
* Protege name: Imones_Info_Daug
* @author ontology bean generator
* @version 2019/05/18, 14:05:30
*/
public class Imones_Info_Daug implements Imones_Info_DaugIf {

  private static final long serialVersionUID = -426450640416141021L;

  private String _internalInstanceName = null;

  public Imones_Info_Daug() {
    this._internalInstanceName = "";
  }

  public Imones_Info_Daug(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: Imones_Info_Vienetas
   */
   private List imones_Info_Vienetas = new ArrayList();
   public void addImones_Info_Vienetas(Imones_Info elem) { 
     imones_Info_Vienetas.add(elem);
   }
   public boolean removeImones_Info_Vienetas(Imones_Info elem) {
     boolean result = imones_Info_Vienetas.remove(elem);
     return result;
   }
   public void clearAllImones_Info_Vienetas() {
     imones_Info_Vienetas.clear();
   }
   public Iterator getAllImones_Info_Vienetas() {return imones_Info_Vienetas.iterator(); }
   public List getImones_Info_Vienetas() {return imones_Info_Vienetas; }
   public void setImones_Info_Vienetas(List l) {imones_Info_Vienetas = l; }

}
