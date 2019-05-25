package darbuotojai.ontology;


import jade.util.leap.*;
import darbuotojai.ontology.*;

/**
* Protege name: Info_apie_save_msg
* @author ontology bean generator
* @version 2019/05/25, 21:17:00
*/
public class Info_apie_save_msg implements Info_apie_save_msgIf {

  private static final long serialVersionUID = 3342814109957283285L;

  private String _internalInstanceName = null;

  public Info_apie_save_msg() {
    this._internalInstanceName = "";
  }

  public Info_apie_save_msg(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: Info_apie_save_message
   */
   private List info_apie_save_message = new ArrayList();
   public void addInfo_apie_save_message(Info_apie_save elem) { 
     info_apie_save_message.add(elem);
   }
   public boolean removeInfo_apie_save_message(Info_apie_save elem) {
     boolean result = info_apie_save_message.remove(elem);
     return result;
   }
   public void clearAllInfo_apie_save_message() {
     info_apie_save_message.clear();
   }
   public Iterator getAllInfo_apie_save_message() {return info_apie_save_message.iterator(); }
   public List getInfo_apie_save_message() {return info_apie_save_message; }
   public void setInfo_apie_save_message(List l) {info_apie_save_message = l; }

}
