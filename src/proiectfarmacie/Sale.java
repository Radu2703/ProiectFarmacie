package proiectfarmacie;
import java.util.*;
public class Sale extends ArrayList<Product>
{private Person c;
 private boolean r;
 private double comp=0;
 public static int tva=10;
 private double total;
public Sale(Person c)
 {this.c=c;} 
public Person getClient()
 {return c;}
public boolean getPrescription()
 {return r;}
public double getCompensation()
 {return comp;}
public void setPrescription(boolean r)
 {this.r=r;}
public void setCompensation(double c)
 {this.comp=c;}
public void addArticol(String d, String compo, String i, String c, String m, double p, int q, boolean compe)
 {super.add(new Product(d,compo,i,c,m,p,q,compe));}
public double calculeazaTotal()
 {ListIterator<Product> li=listIterator();
  Product a;
  while(li.hasNext())
  {a=li.next();
   if(r==false||r==true&&a.getCompensare()==false)total+=a.calculeazaCost();
      else total=total+(a.calculeazaCost()-calculeazaCompensare(a.calculeazaCost(),comp));}
  return total+calculeazaTVA();}
public ArrayList<Product> getArticole()
 {return this;}
public double calculeazaTVA()
 {return total*tva/100.0;}
public double calculeazaCompensare(double p, double c)
 {return p*c/100.0;}
}
