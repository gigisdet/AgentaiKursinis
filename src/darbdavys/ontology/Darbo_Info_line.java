package darbdavys.ontology;


import darbdavys.ontology.*;

/**
* Protege name: Darbo_Info_line
* @author ontology bean generator
* @version 2019/05/18, 14:05:30
*/
public class Darbo_Info_line implements Darbo_Info_lineIf {

  private static final long serialVersionUID = -426450640416141021L;

  private String _internalInstanceName = null;

  public Darbo_Info_line() {
    this._internalInstanceName = "";
  }

  public Darbo_Info_line(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: Darbo_Info_Vienetas
   */
   private Darbo_Info darbo_Info_Vienetas;
   public void setDarbo_Info_Vienetas(Darbo_Info value) { 
    this.darbo_Info_Vienetas=value;
   }
   public Darbo_Info getDarbo_Info_Vienetas() {
     return this.darbo_Info_Vienetas;
   }

}
