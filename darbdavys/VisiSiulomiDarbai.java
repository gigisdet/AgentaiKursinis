package darbdavys;


import jade.util.leap.*;
import darbdavys.*;

/**
* Protege name: VisiSiulomiDarbai
* @author ontology bean generator
* @version 2019/05/18, 11:59:16
*/
public class VisiSiulomiDarbai implements VisiSiulomiDarbaiIf {

  private static final long serialVersionUID = 7030251501279179338L;

  private String _internalInstanceName = null;

  public VisiSiulomiDarbai() {
    this._internalInstanceName = "";
  }

  public VisiSiulomiDarbai(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: visiPasiulymai
   */
   private List visiPasiulymai = new ArrayList();
   public void addVisiPasiulymai(Darbo_Info_Daug elem) { 
     visiPasiulymai.add(elem);
   }
   public boolean removeVisiPasiulymai(Darbo_Info_Daug elem) {
     boolean result = visiPasiulymai.remove(elem);
     return result;
   }
   public void clearAllVisiPasiulymai() {
     visiPasiulymai.clear();
   }
   public Iterator getAllVisiPasiulymai() {return visiPasiulymai.iterator(); }
   public List getVisiPasiulymai() {return visiPasiulymai; }
   public void setVisiPasiulymai(List l) {visiPasiulymai = l; }

}
