package proiectfarmacie;
public class ProductSpecification implements Comparable<ProductSpecification>
{private String denumire;
 private String compozitie;
 private String indicatii;
 private String contraindicatii;
 private String mod_administrare;
 private double pretUnitar;
public ProductSpecification(String denumire, String compozitie, String indicatii, String contraindicatii, String mod_administrare, double pret)
{this.denumire=denumire;
 this.compozitie=compozitie;
 this.indicatii=indicatii;
 this.contraindicatii=contraindicatii;
 this.mod_administrare=mod_administrare;
 this.pretUnitar=pret;}
public String getDenumire()
 {return denumire;}
public String getCompozitie()
 {return compozitie;}
public String getIndicatii()
 {return indicatii;}
public String getContraindicatii()
 {return contraindicatii;}
public String getMod_administrare()
 {return mod_administrare;}
public double getPret()
 {return pretUnitar;}
public void setPret(double p)
 {pretUnitar=p;}
@Override
public String toString()
 {return "NAME: "+denumire+"\nCOMPOSITION: "+compozitie+"\nINDICATIONS: "+indicatii+"\nWARNINGS: "+contraindicatii+"\nADMINISTRATION: "+mod_administrare+"\nPRICE: "+pretUnitar+"\n";}
@Override
public int compareTo(ProductSpecification o)
{if (o==null) return -1000;
 return denumire.compareTo(o.getDenumire());}
}