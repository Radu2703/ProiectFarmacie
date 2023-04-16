package proiectfarmacie;
import java.util.*;
import java.io.*;
public class BillList
{private Properties tabel;
public BillList()
 {tabel=new Properties();}
public void adaugaFactura(Bill f)
 {tabel.put(String.valueOf(f.getNumar()),f.toString()+"|");}
public void descarca()
 {try
  {try (FileOutputStream out = new FileOutputStream("Archive.dat", true))
     {tabel.store(out,"|");}
   }
  catch (IOException io){}
 }
}
