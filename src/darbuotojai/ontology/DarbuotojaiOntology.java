// file: DarbuotojaiOntology.java generated by ontology bean generator.  DO NOT EDIT, UNLESS YOU ARE REALLY SURE WHAT YOU ARE DOING!
package darbuotojai.ontology;

import jade.content.onto.*;
import jade.content.schema.*;

/** file: DarbuotojaiOntology.java
 * @author ontology bean generator
 * @version 2019/05/16, 13:10:48
 */
public class DarbuotojaiOntology extends jade.content.onto.Ontology  {

  private static final long serialVersionUID = -8452648015751330082L;

  //NAME
  public static final String ONTOLOGY_NAME = "Darbuotojai";
  // The singleton instance of this ontology
  private static Ontology theInstance = new DarbuotojaiOntology();
  public static Ontology getInstance() {
     return theInstance;
  }


   // VOCABULARY
    public static final String INFO_APIE_SAVE_MSG_INFO_APIE_SAVE_MESSAGE="Info_apie_save_message";
    public static final String INFO_APIE_SAVE_MSG="Info_apie_save_msg";
    public static final String INFO_APIE_SAVE_DAUG_INFO_APIE_SAVE_VIENETAS="Info_apie_save_vienetas";
    public static final String INFO_APIE_SAVE_DAUG="Info_apie_save_daug";
    public static final String INFO_APIE_SAVE_ATLYGINIMAS="Atlyginimas";
    public static final String INFO_APIE_SAVE_IESKOMA_DARBO_POZICIJA="Ieskoma_darbo_pozicija";
    public static final String INFO_APIE_SAVE_MIESTAS="Miestas";
    public static final String INFO_APIE_SAVE_STAZAS="Stazas";
    public static final String INFO_APIE_SAVE_PAVARDE="Pavarde";
    public static final String INFO_APIE_SAVE_VARDAS="Vardas";
    public static final String INFO_APIE_SAVE="Info_apie_save";

  /**
   * Constructor
  */
  private DarbuotojaiOntology(){ 
    super(ONTOLOGY_NAME, BasicOntology.getInstance());
    try { 

    // adding Concept(s)
    ConceptSchema info_apie_saveSchema = new ConceptSchema(INFO_APIE_SAVE);
    add(info_apie_saveSchema, darbuotojai.ontology.Info_apie_save.class);
    ConceptSchema info_apie_save_daugSchema = new ConceptSchema(INFO_APIE_SAVE_DAUG);
    add(info_apie_save_daugSchema, darbuotojai.ontology.Info_apie_save_daug.class);

    // adding AgentAction(s)

    // adding AID(s)

    // adding Predicate(s)
    PredicateSchema info_apie_save_msgSchema = new PredicateSchema(INFO_APIE_SAVE_MSG);
    add(info_apie_save_msgSchema, darbuotojai.ontology.Info_apie_save_msg.class);


    // adding fields
    info_apie_saveSchema.add(INFO_APIE_SAVE_VARDAS, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    info_apie_saveSchema.add(INFO_APIE_SAVE_PAVARDE, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    info_apie_saveSchema.add(INFO_APIE_SAVE_STAZAS, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.MANDATORY);
    info_apie_saveSchema.add(INFO_APIE_SAVE_MIESTAS, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    info_apie_saveSchema.add(INFO_APIE_SAVE_IESKOMA_DARBO_POZICIJA, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    info_apie_saveSchema.add(INFO_APIE_SAVE_ATLYGINIMAS, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.MANDATORY);
    info_apie_save_daugSchema.add(INFO_APIE_SAVE_DAUG_INFO_APIE_SAVE_VIENETAS, info_apie_saveSchema, 1, ObjectSchema.UNLIMITED);
    info_apie_save_msgSchema.add(INFO_APIE_SAVE_MSG_INFO_APIE_SAVE_MESSAGE, info_apie_save_daugSchema, 1, ObjectSchema.UNLIMITED);

    // adding name mappings

    // adding inheritance

   }catch (java.lang.Exception e) {e.printStackTrace();}
  }
}