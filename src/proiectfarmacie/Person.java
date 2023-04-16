package proiectfarmacie;
import java.io.*;
public class Person implements Serializable
{private String nume, prenume;
Person(String n, String p)
 {nume=n;
  prenume=p;}
public String getNume()
 {return nume;}
public String getPrenume()
 {return prenume;}
}