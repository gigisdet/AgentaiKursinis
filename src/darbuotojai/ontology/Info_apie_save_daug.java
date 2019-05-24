package darbuotojai.ontology;


import jade.util.leap.*;
import darbuotojai.ontology.*;

/**
* Protege name: Info_apie_save_daug
* @author ontology bean generator
* @version 2019/05/16, 13:10:48
*/
public class Info_apie_save_daug implements Info_apie_save_daugIf {

  private static final long serialVersionUID = -8452648015751330082L;

  private String _internalInstanceName = null;

  public Info_apie_save_daug() {
    this._internalInstanceName = "";
  }

  public Info_apie_save_daug(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: Info_apie_save_vienetas
   */
   private List info_apie_save_vienetas = new ArrayList();
   public void addInfo_apie_save_vienetas(Info_apie_save elem) { 
     info_apie_save_vienetas.add(elem);
   }
   public boolean removeInfo_apie_save_vienetas(Info_apie_save elem) {
     boolean result = info_apie_save_vienetas.remove(elem);
     return result;
   }
   public void clearAllInfo_apie_save_vienetas() {
     info_apie_save_vienetas.clear();
   }
   public Iterator getAllInfo_apie_save_vienetas() {return info_apie_save_vienetas.iterator(); }
   public List getInfo_apie_save_vienetas() {return info_apie_save_vienetas; }
   public void setInfo_apie_save_vienetas(List l) {info_apie_save_vienetas = l; }

}
