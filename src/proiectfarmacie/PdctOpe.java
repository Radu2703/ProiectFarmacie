package proiectfarmacie;
import java.io.*;
import java.util.*;
public class PdctOpe implements ObjOpe
{private PrintWriter pw;
private BufferedReader br;
@Override
public void scrieObiect(Object o)
 {if (!(o instanceof ProductSpecification))
  {System.out.println("instanta invalida");}
  else
  {try
   {if (pw==null) pw=new PrintWriter(new FileWriter("Medicine.txt"));
    ProductSpecification p=(ProductSpecification)o;
    pw.println(p.getDenumire()+"_"+p.getCompozitie()+"_"+p.getIndicatii()+"_"+p.getContraindicatii()+"_"+p.getMod_administrare()+"_"+p.getPret());
    pw.flush();}
   catch(IOException io){io.printStackTrace();}
  }
 }
@Override
public Object citesteObiect(String cheie)
{ProductSpecification sp=null;
 try
 {if (br==null) br=new BufferedReader(new FileReader("Medicine.txt"));
  StringTokenizer st;
  String linie;
  while((linie=br.readLine())!=null)
  {st=new StringTokenizer(linie, "_");
   if(st.nextToken().equals(cheie))
   {sp=new ProductSpecification(cheie, st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), Double.parseDouble(st.nextToken()));
    break;}
  }
 }
 catch(IOException io){io.printStackTrace();}
 return sp;
}
public void inchide()
 {pw.close();}
}