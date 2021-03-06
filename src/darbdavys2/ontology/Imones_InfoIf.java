package darbdavys2.ontology;


import jade.util.leap.*;

/**
* Protege name: Imones_Info
* @author ontology bean generator
* @version 2019/05/18, 19:35:23
*/
public interface Imones_InfoIf extends jade.content.Concept {

   /**
   * Protege name: Pavadinimas
   */
   public void setPavadinimas(String value);
   public String getPavadinimas();

   /**
   * Protege name: Darbai
   */
   public void addDarbai(Darbo_Info elem);
   public boolean removeDarbai(Darbo_Info elem);
   public void clearAllDarbai();
   public Iterator getAllDarbai();
   public List getDarbai();
   public void setDarbai(List l);

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
