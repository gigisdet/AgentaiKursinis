package darbdavys;


import jade.util.leap.*;

/**
* Protege name: VisiSiulomiDarbai
* @author ontology bean generator
* @version 2019/05/18, 11:59:16
*/
public interface VisiSiulomiDarbaiIf extends jade.content.Concept {

   /**
   * Protege name: visiPasiulymai
   */
   public void addVisiPasiulymai(Darbo_Info_Daug elem);
   public boolean removeVisiPasiulymai(Darbo_Info_Daug elem);
   public void clearAllVisiPasiulymai();
   public Iterator getAllVisiPasiulymai();
   public List getVisiPasiulymai();
   public void setVisiPasiulymai(List l);

}
