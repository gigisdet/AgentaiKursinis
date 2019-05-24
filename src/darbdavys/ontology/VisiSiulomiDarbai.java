package darbdavys.ontology;


import jade.util.leap.*;
import darbdavys.ontology.*;

/**
* Protege name: VisiSiulomiDarbai
* @author ontology bean generator
* @version 2019/05/18, 14:05:30
*/
public class VisiSiulomiDarbai implements VisiSiulomiDarbaiIf {

  private static final long serialVersionUID = -426450640416141021L;

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
   public void addVisiPasiulymai(Darbo_Info_line elem) { 
     visiPasiulymai.add(elem);
   }
   public boolean removeVisiPasiulymai(Darbo_Info_line elem) {
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
