package darbdavys.ontology;


import darbdavys.ontology.*;

/**
* Protege name: SimplePranesimas
* @author ontology bean generator
* @version 2019/05/18, 19:35:04
*/
public class SimplePranesimas implements SimplePranesimasIf {

  private static final long serialVersionUID = 5663662221590769434L;

  private String _internalInstanceName = null;

  public SimplePranesimas() {
    this._internalInstanceName = "";
  }

  public SimplePranesimas(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: Pranesimas
   */
   private String pranesimas;
   public void setPranesimas(String value) { 
    this.pranesimas=value;
   }
   public String getPranesimas() {
     return this.pranesimas;
   }

}
