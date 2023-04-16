package proiectfarmacie;
public class Pharmacy
{private Person owner;
 private int oraD, oraI;
 private String city;
 private String country;
 private String street;
public Pharmacy(Person p)
{owner=p;
 oraD=9;
 oraI=21;
 country="Romania";
 city="Constanta";
 street="Street Rascoala 1907";} 
public void setOraD(int ora)
 {oraD=ora;}
public void setOraI(int ora)
 {oraI=ora;}
public void setProprietar(Person p)
 {owner=p;}
public int getOraD()
 {return oraD;}
public int getOraI()
 {return oraI;}
public String getLocation()
 {return country+", "+city+", "+street;}
public String getProprietari()
 {return owner.getNume()+" "+ owner.getPrenume();}
}
