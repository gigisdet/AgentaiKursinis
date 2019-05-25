package darbuotojai.ontology;


import darbuotojai.ontology.*;

/**
* Protege name: SimplePranesimas
* @author ontology bean generator
* @version 2019/05/25, 18:24:54
*/
public class SimplePranesimas implements SimplePranesimasIf {

  private static final long serialVersionUID = -961240309207303912L;

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
   * Protege name: pranesimas
   */
   private String pranesimas;
   public void setPranesimas(String value) { 
    this.pranesimas=value;
   }
   public String getPranesimas() {
     return this.pranesimas;
   }

}
