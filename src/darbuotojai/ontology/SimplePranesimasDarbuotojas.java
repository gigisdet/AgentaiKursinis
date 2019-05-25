package darbuotojai.ontology;


import darbuotojai.ontology.*;

/**
* Protege name: SimplePranesimasDarbuotojas
* @author ontology bean generator
* @version 2019/05/25, 21:17:00
*/
public class SimplePranesimasDarbuotojas implements SimplePranesimasDarbuotojasIf {

  private static final long serialVersionUID = 3342814109957283285L;

  private String _internalInstanceName = null;

  public SimplePranesimasDarbuotojas() {
    this._internalInstanceName = "";
  }

  public SimplePranesimasDarbuotojas(String instance_name) {
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
