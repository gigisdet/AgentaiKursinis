package darbdavys;


import jade.util.leap.*;
import darbdavys.*;

/**
* Protege name: Paieska_pagal_darbdavi
* @author ontology bean generator
* @version 2019/05/18, 11:59:16
*/
public class Paieska_pagal_darbdavi implements Paieska_pagal_darbdaviIf {

  private static final long serialVersionUID = 7030251501279179338L;

  private String _internalInstanceName = null;

  public Paieska_pagal_darbdavi() {
    this._internalInstanceName = "";
  }

  public Paieska_pagal_darbdavi(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: PaieskaPagalDarbdaviDaug
   */
   private List paieskaPagalDarbdaviDaug = new ArrayList();
   public void addPaieskaPagalDarbdaviDaug(Imones_Info_Daug elem) { 
     paieskaPagalDarbdaviDaug.add(elem);
   }
   public boolean removePaieskaPagalDarbdaviDaug(Imones_Info_Daug elem) {
     boolean result = paieskaPagalDarbdaviDaug.remove(elem);
     return result;
   }
   public void clearAllPaieskaPagalDarbdaviDaug() {
     paieskaPagalDarbdaviDaug.clear();
   }
   public Iterator getAllPaieskaPagalDarbdaviDaug() {return paieskaPagalDarbdaviDaug.iterator(); }
   public List getPaieskaPagalDarbdaviDaug() {return paieskaPagalDarbdaviDaug; }
   public void setPaieskaPagalDarbdaviDaug(List l) {paieskaPagalDarbdaviDaug = l; }

}
