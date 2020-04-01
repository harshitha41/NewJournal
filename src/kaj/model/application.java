package kaj.model;

import java.io.Serializable;

public class application implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

	
	
	private int id;
	private String refno;
	private String ptitle;
	private String jrname;
	private String doi;
	private String jcat;
	private String firstauthor;
	private String fauthor;
	private String seauthor;
	private String secondauthor;
	private String sauthor;
	private String thauthor;
	private String thirdauthor;
	private String tauthor;
	private String incentiveF;
	private String incentiveS;
	private String incentiveT;
	private String incentiveFT;
	private String totalincentive;
	private String otherauthor;
	
	public application() {
    }
 
    public application(int id) {
    	super();
        this.id = id;
    }
    
	
    public application(int id, String refno, String ptitle, String firstauthor)	{
    	super();
    	this.id = id;
    	this.refno = refno;
    	this.ptitle = ptitle;
    	this.firstauthor = firstauthor;
    }
 
    public application(int id, String refno, String ptitle, String jrname, String doi, String jcat, String firstauthor, String fauthor, String seauthor, String secondauthor, String sauthor, String thauthor, String thirdauthor, String tauthor, String incentiveF, String incentiveS, String incentiveT, String totalincentive, String otherauthor) {
    	super();
        this.id = id;
        this.refno = refno;
        this.ptitle = ptitle;
        this.jrname = jrname;
        this.doi = doi;
        this.jcat = jcat;
        this.firstauthor = firstauthor;
        this.fauthor = fauthor;
        this.seauthor = seauthor;
        this.secondauthor = secondauthor;
        this.sauthor = sauthor;
        this.thauthor = thauthor;
        this.thirdauthor = thirdauthor;
        this.tauthor = tauthor;
        this.incentiveF = incentiveF;
        this.incentiveS = incentiveS;
        this.incentiveT = incentiveT;
        this.otherauthor = otherauthor;
    }
     
 


	public application(int id, String refno, String ptitle, String jrname, String doi, String jcat,
			String firstauthor, String secondauthor, String thirdauthor) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.refno = refno;
		this.ptitle = ptitle;
		this.jrname = jrname;
		this.doi = doi;
		this.jcat = jcat;
		this.firstauthor = firstauthor;
		this.secondauthor = secondauthor;
		this.thirdauthor = thirdauthor;
	}

	public String getINCENTIVEFT() {
		return incentiveFT;
	}
	
	public void setINCENTIVEFT(String incentiveFT)	{
		this.incentiveFT = incentiveFT;
	}
	
	public void setTOTALINCENTIVE(String totalincentive) {
		this.totalincentive = totalincentive;
	}
	
	public String getTOTALINCENTIVE()	{
		return totalincentive;
	}
	
	public void setOTHERAUTHOR(String otherauthor)	{
		this.otherauthor = otherauthor;
	}
	
	public String getOTHERAUTHOR()	{
		return otherauthor;
	}
	
	public void setREFNO(String refno)	{
		this.refno = refno;
	}
	
	public String getREFNO()	{
		return refno;
	}
	
	public String getTHAUTHOR() {
		return thauthor;
	}
	public void setTHAUTHOR(String thauthor) {
		this.thauthor = thauthor;		
	}
	
	public String getSEAUTHOR() {
		return seauthor;
	}
	
	public void setSEAUTHOR(String seauthor) {
		this.seauthor = seauthor;
	}
	
	public String getINCENTIVEF() {
		return incentiveF;
	}
	
	public void setINCENTIVEF(String incentiveF) {
		this.incentiveF = incentiveF;
	}
	
	public String getINCENTIVES() {
		return incentiveS;
	}
	
	public void setINCENTIVES(String incentiveS) {
		this.incentiveS = incentiveS;
	}
	
	public String getINCENTIVET() {
		return incentiveT;
	}
	
	public void setINCENTIVET(String incentiveT) {
		this.incentiveT = incentiveT;
	}
	
	public String getFIRSTAUTHOR() {
		return firstauthor;
	}
	
	public void setFIRSTAUTHOR(String firstauthor)	{
		this.firstauthor = firstauthor;
	}
	
	public String getTHIRDAUTHOR() {
		return thirdauthor;
	}
	
	public void setTHIRDAUTHOR(String thirdauthor) {
		this.thirdauthor = thirdauthor;
	}
	
	public String getSECONDAUTHOR() {
		return secondauthor;
	}
	
	public void setSECONDAUTHOR(String secondauthor) {
		this.secondauthor = secondauthor;
	}
	public String getTAUTHOR() {
		return tauthor;
	}
	
	public void setTAUTHOR(String tauthor) {
		this.tauthor = tauthor;
	}
	
	public String getSAUTHOR() {
		return sauthor;
	}
	
	public void setSAUTHOR(String sauthor) {
		this.sauthor = sauthor;
	}
	
	public String getFAUTHOR() {
		return fauthor;
	}
	
	public void  setFAUTHOR(String fauthor) {
		this.fauthor = fauthor;
	}
	
	public String getTitle() {
		return ptitle;
	}
	
	public void setTitle(String ptitle) {
		this.ptitle = ptitle;
	}
	
	public String getjournal() {
		return jrname;
	}
	
	public void setjournal(String jrname) {
		this.jrname = jrname;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDOI() {
		return doi;
	}
	
	public void setDOI(String doi) {
		this.doi = doi;
	}
	
	public String getJCAT() {
		return jcat;
	}
	
	public void setJCAT(String jcat) {
		this.jcat = jcat;
	}
	
}
