package darbuotojai.ontology;


import darbuotojai.ontology.*;

/**
* Protege name: Info_apie_save_daug
* @author ontology bean generator
* @version 2019/05/25, 21:17:00
*/
public class Info_apie_save_daug implements Info_apie_save_daugIf {

  private static final long serialVersionUID = 3342814109957283285L;

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
   private Info_apie_save info_apie_save_vienetas;
   public void setInfo_apie_save_vienetas(Info_apie_save value) { 
    this.info_apie_save_vienetas=value;
   }
   public Info_apie_save getInfo_apie_save_vienetas() {
     return this.info_apie_save_vienetas;
   }

}
