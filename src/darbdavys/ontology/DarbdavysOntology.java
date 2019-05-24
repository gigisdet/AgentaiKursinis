// file: DarbdavysOntology.java generated by ontology bean generator.  DO NOT EDIT, UNLESS YOU ARE REALLY SURE WHAT YOU ARE DOING!
package darbdavys.ontology;

import jade.content.onto.*;
import jade.content.schema.*;

/** file: DarbdavysOntology.java
 * @author ontology bean generator
 * @version 2019/05/18, 19:35:04
 */
public class DarbdavysOntology extends jade.content.onto.Ontology  {

  private static final long serialVersionUID = 5663662221590769434L;

  //NAME
  public static final String ONTOLOGY_NAME = "Darbdavys";
  // The singleton instance of this ontology
  private static Ontology theInstance = new DarbdavysOntology();
  public static Ontology getInstance() {
     return theInstance;
  }


   // VOCABULARY
    public static final String SIMPLEPRANESIMAS_PRANESIMAS="Pranesimas";
    public static final String SIMPLEPRANESIMAS="SimplePranesimas";
    public static final String PAIESKA_PAGAL_DARBDAVI_PAIESKAPAGALDARBDAVIDAUG="PaieskaPagalDarbdaviDaug";
    public static final String PAIESKA_PAGAL_DARBDAVI="Paieska_pagal_darbdavi";
    public static final String PAIESKA_MSG_DARBUOTOJO_PAIESKA_MSG="Darbuotojo_paieska_msg";
    public static final String PAIESKA_MSG="Paieska_msg";
    public static final String IMONES_INFO_VADOVAS="Vadovas";
    public static final String IMONES_INFO_GID="GID";
    public static final String IMONES_INFO_DARBAI="Darbai";
    public static final String IMONES_INFO_PAVADINIMAS="Pavadinimas";
    public static final String IMONES_INFO="Imones_Info";
    public static final String DARBO_INFO_REIKALINGAS_STAZAS="Reikalingas_Stazas";
    public static final String DARBO_INFO_ATLYGINIMAS="Atlyginimas";
    public static final String DARBO_INFO_MIESTAS="Miestas";
    public static final String DARBO_INFO_ID="ID";
    public static final String DARBO_INFO_VALANDOS="Valandos";
    public static final String DARBO_INFO_POZICIJA="Pozicija";
    public static final String DARBO_INFO="Darbo_Info";
    public static final String DARBUOTOJOPAIESKA_LINE_ATLYGINIMAS="Atlyginimas";
    public static final String DARBUOTOJOPAIESKA_LINE_REIKALINGAS_STAZAS="Reikalingas_stazas";
    public static final String DARBUOTOJOPAIESKA_LINE_MIESTAS="Miestas";
    public static final String DARBUOTOJOPAIESKA_LINE_POZICIJA="Pozicija";
    public static final String DARBUOTOJOPAIESKA_LINE="DarbuotojoPaieska_line";

  /**
   * Constructor
  */
  private DarbdavysOntology(){ 
    super(ONTOLOGY_NAME, BasicOntology.getInstance());
    try { 

    // adding Concept(s)
    ConceptSchema darbuotojoPaieska_lineSchema = new ConceptSchema(DARBUOTOJOPAIESKA_LINE);
    add(darbuotojoPaieska_lineSchema, darbdavys.ontology.DarbuotojoPaieska_line.class);
    ConceptSchema darbo_InfoSchema = new ConceptSchema(DARBO_INFO);
    add(darbo_InfoSchema, darbdavys.ontology.Darbo_Info.class);
    ConceptSchema imones_InfoSchema = new ConceptSchema(IMONES_INFO);
    add(imones_InfoSchema, darbdavys.ontology.Imones_Info.class);

    // adding AgentAction(s)

    // adding AID(s)

    // adding Predicate(s)
    PredicateSchema paieska_msgSchema = new PredicateSchema(PAIESKA_MSG);
    add(paieska_msgSchema, darbdavys.ontology.Paieska_msg.class);
    PredicateSchema paieska_pagal_darbdaviSchema = new PredicateSchema(PAIESKA_PAGAL_DARBDAVI);
    add(paieska_pagal_darbdaviSchema, darbdavys.ontology.Paieska_pagal_darbdavi.class);
    PredicateSchema simplePranesimasSchema = new PredicateSchema(SIMPLEPRANESIMAS);
    add(simplePranesimasSchema, darbdavys.ontology.SimplePranesimas.class);


    // adding fields
    darbuotojoPaieska_lineSchema.add(DARBUOTOJOPAIESKA_LINE_POZICIJA, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    darbuotojoPaieska_lineSchema.add(DARBUOTOJOPAIESKA_LINE_MIESTAS, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    darbuotojoPaieska_lineSchema.add(DARBUOTOJOPAIESKA_LINE_REIKALINGAS_STAZAS, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.MANDATORY);
    darbuotojoPaieska_lineSchema.add(DARBUOTOJOPAIESKA_LINE_ATLYGINIMAS, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.MANDATORY);
    darbo_InfoSchema.add(DARBO_INFO_POZICIJA, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    darbo_InfoSchema.add(DARBO_INFO_VALANDOS, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.MANDATORY);
    darbo_InfoSchema.add(DARBO_INFO_ID, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.MANDATORY);
    darbo_InfoSchema.add(DARBO_INFO_MIESTAS, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    darbo_InfoSchema.add(DARBO_INFO_ATLYGINIMAS, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.MANDATORY);
    darbo_InfoSchema.add(DARBO_INFO_REIKALINGAS_STAZAS, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.MANDATORY);
    imones_InfoSchema.add(IMONES_INFO_PAVADINIMAS, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    imones_InfoSchema.add(IMONES_INFO_DARBAI, darbo_InfoSchema, 1, 10);
    imones_InfoSchema.add(IMONES_INFO_GID, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.MANDATORY);
    imones_InfoSchema.add(IMONES_INFO_VADOVAS, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    paieska_msgSchema.add(PAIESKA_MSG_DARBUOTOJO_PAIESKA_MSG, darbuotojoPaieska_lineSchema, 1, ObjectSchema.UNLIMITED);
    paieska_pagal_darbdaviSchema.add(PAIESKA_PAGAL_DARBDAVI_PAIESKAPAGALDARBDAVIDAUG, imones_InfoSchema, 1, ObjectSchema.UNLIMITED);
    simplePranesimasSchema.add(SIMPLEPRANESIMAS_PRANESIMAS, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);

    // adding name mappings

    // adding inheritance

   }catch (java.lang.Exception e) {e.printStackTrace();}
  }
}
