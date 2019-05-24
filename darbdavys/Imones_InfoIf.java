package darbdavys;


import jade.util.leap.*;

/**
* Protege name: Imones_Info
* @author ontology bean generator
* @version 2019/05/18, 11:59:16
*/
public interface Imones_InfoIf extends jade.content.Concept {

   /**
   * Protege name: Pavadinimas
   */
   public void setPavadinimas(String value);
   public String getPavadinimas();

   /**
   * Protege name: Darbas
   */
   public void addDarbas(Darbo_Info elem);
   public boolean removeDarbas(Darbo_Info elem);
   public void clearAllDarbas();
   public Iterator getAllDarbas();
   public List getDarbas();
   public void setDarbas(List l);

   /**
   * Protege name: GID
   */
   public void setGID(int value);
   public int getGID();

   /**
   * Protege name: Vadovas
   */
   public void setVadovas(String value);
   public String getVadovas();

}
