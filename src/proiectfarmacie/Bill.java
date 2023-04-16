package proiectfarmacie;
import java.util.*;
import java.text.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Bill
{private static int id=1;
 private int numar;
 private Calendar data;
 LocalDateTime myDateObj;
 DateTimeFormatter myFormatObj;
 private Sale v;
 private Person c;
 private ArrayList<Product> articles;
public Bill(Sale v)
{numar=id++;
 data=Calendar.getInstance();
 myDateObj = LocalDateTime.now();
 myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
 this.v=v;
 c=v.getClient();
 articles=v.getArticole();}
@Override
public String toString()
{String sir="Bill: "+ numar+"\r\n";
 sir+="BlueClover Pharmacy\r\n";
 sir+="Location: Romania, Constanta, Street Rascoala 1907\r\n";
 sir+="Bill date: "+DateFormat.getDateInstance(DateFormat.LONG).format(data.getTime())+"\r\n";
 sir+="Bill time: "+myDateObj.format(myFormatObj)+"\r\n";
 sir+="------------------------------------------------------------------------------------------------------------------------------------------------------\r\n\r\n";
 sir+="Buyer: "+c.getNume()+" "+c.getPrenume() +"\r\n";
 if(v.getPrescription()==true)sir+="A prescription was used to buy medicine\r\n";
 sir+="------------------------------------------------------------------------------------------------------------------------------------------------------\r\n\r\n";
 sir+=String.format("%-25s","Name")+ String.format("%-25s", "Price/Unit")+String.format("%-20s","Quantity")+String.format("%-20s","Price/Article")+String.format("%-20s","Compensation")+String.format("%-20s","Total Price")+"\r\n";
 Iterator<Product> it=articles.iterator();
 Product el;
 double t=v.calculeazaTotal();
 double s=0;
 while(it.hasNext())
 {el=it.next();
  sir+=String.format("%-25s",el.getProdus().getDenumire())+String.format("%.2f",el.getProdus().getPret())+String.format("%-25s"," lei")+String.format("%-25d",el.getCantitate())+String.format("%.2f",el.calculeazaCost())+String.format("%-20s"," lei");
  if(v.getPrescription()==true&&el.getCompensare()==true)sir+=String.format("%.2f",v.getCompensation())+String.format("%-20s","%")+String.format("%.2f",el.getProdus().getPret()*el.getCantitate()-(el.getProdus().getPret()*el.getCantitate()*v.getCompensation()/100))+String.format("%-20s"," lei")+"\r\n";
        else sir+=String.format("%-25s","0%")+String.format("%.2f",el.getProdus().getPret()*el.getCantitate())+String.format("%-25s"," lei")+"\r\n";
  if(v.getPrescription()==true&&el.getCompensare()==true)s+=el.getProdus().getPret()*el.getCantitate()-(el.getProdus().getPret()*el.getCantitate()*v.getCompensation()/100);
        else s+=el.getProdus().getPret()*el.getCantitate();}
 sir+="------------------------------------------------------------------------------------------------------------------------------------------------------\r\n\r\n";
 sir+="Total before taxes\t"+String.format("%-5.2f",s)+" lei \r\n";
 sir+="Taxes = 10%\t\t"+String.format("%-5.2f",v.calculeazaTVA())+" lei \r\n";
 sir+="\r\n\r\nTOTAL OVERALL\t"+String.format("%-5.2f",t)+" lei \r\n";
 return sir;}
public int getNumar()
 {return numar;}
}
