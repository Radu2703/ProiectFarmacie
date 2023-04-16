package proiectfarmacie;
import java.awt.*;
import javax.swing.*;
public class PharmacyInfoFrame extends JFrame
{public PharmacyInfoFrame()
 {super("BlueClover Pharmacy Information");
  JPanel p=new JPanel();
  Pharmacy m=new Pharmacy(new Person("Serbanescu", "Radu"));
  JLabel ta=new JLabel("Owners: "+m.getProprietari());
  JLabel ta1=new JLabel("Timetable: "+m.getOraD()+":00 - "+m.getOraI()+":00");
  JLabel ta2=new JLabel("Location: "+m.getLocation());
  p.setLayout(new GridLayout(3,1, 10,0));
  p.add(ta);
  p.add(ta1);
  p.add(ta2);
  add(p);
  setSize(500,150);
  setLocation(500,300);}
}
