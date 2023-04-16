package proiectfarmacie;
import java.util.*;
import java.io.*;
public class Catalog extends TreeSet<ProductSpecification>
{private static Catalog c;
 private PdctOpe osp;
 private BufferedReader br;
 private int dim=0;
private Catalog(){}
public static Catalog getInstanta()
 {if(c==null) c=new Catalog();
  return c;} 
public boolean add(ProductSpecification sp)
 {return super.add(sp);}
public ProductSpecification getProdus(String nume)
{Iterator<ProductSpecification> it=iterator();
 ProductSpecification sp;
 while(it.hasNext())
 {sp=it.next();
  if(sp.getDenumire().equals(nume)) return sp;}
 osp=new PdctOpe();
 sp=(ProductSpecification)osp.citesteObiect(nume);
 if(sp!=null) add(sp);
 return sp;}
public ProductSpecification getNbr(int i)
{Iterator<ProductSpecification> it=iterator();
 ProductSpecification sp=null;
 while(i!=0&&it.hasNext())
 {sp=it.next(); i--;}
 return sp;}
public String[] incarca()
{String[] rez=null;
 try
 {br=new BufferedReader(new FileReader("Medicine.txt"));
  dim=0;
  while(br.readLine()!=null) dim++;
  br.close();
  rez=new String[dim];
  osp=new PdctOpe();
  ProductSpecification sp;
  int i=0;
  br=new BufferedReader(new FileReader("Medicine.txt"));
  String line;
  while((line=br.readLine())!=null)
  {rez[i]=line.substring(0, line.indexOf("_"));
   sp=(ProductSpecification)osp.citesteObiect(rez[i]);
   add(sp);
   i++;}
 br.close();}
 catch(IOException io){io.printStackTrace();}
 return rez;}
public void descarca()
{osp=new PdctOpe();
 Iterator<ProductSpecification> it=iterator();
 while(it.hasNext()) osp.scrieObiect(it.next());
 osp.inchide();}
public int getDimensiune()
 {return Math.max(dim, size());}
public String getCatalog()
{String rez="";
 ProductSpecification sp;
 Iterator<ProductSpecification> it=iterator();
 while (it.hasNext()) {sp=it.next();rez+=sp.toString()+"\n";}
 return rez;}
}