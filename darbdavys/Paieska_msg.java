package darbdavys;


import jade.util.leap.*;
import darbdavys.*;

/**
* Protege name: Paieska_msg
* @author ontology bean generator
* @version 2019/05/18, 11:59:16
*/
public class Paieska_msg implements Paieska_msgIf {

  private static final long serialVersionUID = 7030251501279179338L;

  private String _internalInstanceName = null;

  public Paieska_msg() {
    this._internalInstanceName = "";
  }

  public Paieska_msg(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: Darbuotojo_paieska_msg
   */
   private List darbuotojo_paieska_msg = new ArrayList();
   public void addDarbuotojo_paieska_msg(DarbuotojoPaieska_line elem) { 
     darbuotojo_paieska_msg.add(elem);
   }
   public boolean removeDarbuotojo_paieska_msg(DarbuotojoPaieska_line elem) {
     boolean result = darbuotojo_paieska_msg.remove(elem);
     return result;
   }
   public void clearAllDarbuotojo_paieska_msg() {
     darbuotojo_paieska_msg.clear();
   }
   public Iterator getAllDarbuotojo_paieska_msg() {return darbuotojo_paieska_msg.iterator(); }
   public List getDarbuotojo_paieska_msg() {return darbuotojo_paieska_msg; }
   public void setDarbuotojo_paieska_msg(List l) {darbuotojo_paieska_msg = l; }

}
