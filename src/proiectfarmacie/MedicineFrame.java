package proiectfarmacie;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class MedicineFrame extends JFrame
{private MedicineController ec;
 private JComboBox listaP;
 private JTextField t1,t2,t3,t4,t5,t6,tp;
 private JTextField ta;
 private MedicineTable p;
 private JOptionPane pab;
 private JPanel q;
 private JLabel r,s;
 private JButton b1,b2,b3,b4,b5,b6,z,price,cataF,cataS;
 private CatalogPanel cp;
public MedicineFrame(Catalog cat)
{super("BlueClover Medicine Information");
 pack();
 cp=new CatalogPanel(cat);
 p=new MedicineTable(cat);
 q=new JPanel();
 r=new JLabel();
 s=new JLabel();
 setLayout(new GridLayout(4, 1, 1, 1));
 q.setLayout(new GridLayout(8, 3, 1, 1));
 r.setLayout(new GridLayout(1, 6, 1, 1));
 s.setLayout(new GridLayout(1, 2, 1, 1));
 ec=new MedicineController();
 q.add(new JLabel(" Enter medicine name "));
 t1=new JTextField(10);
 q.add(t1);
 b1=new JButton(" Search by name ");
 b1.addActionListener(ec);
 q.add(b1);
 q.add(new JLabel(" Enter medicine composition "));
 t2=new JTextField(10);
 q.add(t2);
 b2=new JButton(" Search by composition ");
 b2.addActionListener(ec);
 q.add(b2);
 q.add(new JLabel(" Enter medicine price "));
 t3=new JTextField(10);
 q.add(t3);
 b3=new JButton(" Search by price ");
 b3.addActionListener(ec);
 q.add(b3);
 q.add(new JLabel(" Enter medicine indications "));
 t4=new JTextField(10);
 q.add(t4);
 b4=new JButton(" Search by indications ");
 b4.addActionListener(ec);
 q.add(b4);
 q.add(new JLabel(" Enter medicine warnings "));
 t5=new JTextField(10);
 q.add(t5);
 b5=new JButton(" Search by warnings ");
 b5.addActionListener(ec);
 q.add(b5);
 q.add(new JLabel(" Enter medicine administration "));
 t6=new JTextField(10);
 q.add(t6);
 b6=new JButton(" Search by administration ");
 b6.addActionListener(ec);
 q.add(b6);
 z=new JButton(" Reset table ");
 z.addActionListener(ec);
 q.add(z);
 tp=new JTextField(10);
 ta=new JTextField(5);
 listaP=cp.getComboBox();
 r.add(listaP);
 listaP.addActionListener(ec);
 r.add(new JLabel(" Current price "));
 if(cat.getNbr(1)!=null)ta.setText(String.valueOf(cat.getNbr(1).getPret()));
 ta.setEnabled(false);
 r.add(ta);
 r.add(new JLabel(" New price "));
 r.add(tp);
 price=new JButton("Change price");
 price.addActionListener(ec);
 r.add(price);
 cataS=new JButton("Display selected item");
 cataS.addActionListener(ec);
 s.add(cataS);
 cataF=new JButton("Display entire catalogue");
 cataF.addActionListener(ec);
 s.add(cataF);
 setLocation(400,100);
 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 add(p);
 add(q);
 add(r); 
 add(s);
 setLocation(450, 0);
}
private class MedicineController implements ActionListener
{private  Catalog c;
 private JFrame f, s;
MedicineController(){c=Catalog.getInstanta();}
public void actionPerformed(ActionEvent e)
{if(e.getSource()==listaP)
 {ta.setText(String.valueOf(c.getNbr(cp.getIndexProdus()+1).getPret()));
  pack();}
 if(e.getSource()==price)
 {if(tp.getText().trim().length()<=0)
    JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the New price field! ", "Reminder", JOptionPane.WARNING_MESSAGE);
   else if(c.getNbr(1)==null)
          JOptionPane.showMessageDialog(pab,"Error!\nNo medicine is in stock or picked!", "Reminder", JOptionPane.WARNING_MESSAGE);
    else 
     {try
      {c.getNbr(cp.getIndexProdus()+1).setPret(Double.parseDouble(tp.getText().trim()));
       p.setTabel(); ta.setText(String.valueOf(c.getNbr(cp.getIndexProdus()+1).getPret()));
       c.descarca(); pack();}
      catch (NumberFormatException er)
      {JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the New price field with a real number!", "Reminder", JOptionPane.WARNING_MESSAGE);}
     }
 }
 if (e.getSource()==b1)
 {if(t1.getText().trim().length()<=0)
    JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the name field! ", "Reminder", JOptionPane.WARNING_MESSAGE);
  else{p.resetTabel1(t1.getText().trim());
       t1.setText("");
       pack();}
 }
 if (e.getSource()==b2)
 {if(t2.getText().trim().length()<=0)
    JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the composition field! ", "Reminder", JOptionPane.WARNING_MESSAGE);
  else{p.resetTabel2(t2.getText().trim());
       t2.setText("");
       pack();}
 }
 if (e.getSource()==b3)
 {if(t3.getText().trim().length()<=0)
    JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the price field! ", "Reminder", JOptionPane.WARNING_MESSAGE);
  else
  {try{p.resetTabel3(Double.parseDouble(t3.getText().trim()));
       t3.setText("");
       pack();}
   catch (NumberFormatException er)
   {JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the price field with a real number!", "Reminder", JOptionPane.WARNING_MESSAGE);
    t3.setText("");}
  }
 }
 if (e.getSource()==b4)
 {if(t4.getText().trim().length()<=0)
    JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the indications field! ", "Reminder", JOptionPane.WARNING_MESSAGE);
  else{p.resetTabel4(t4.getText().trim());
       t4.setText("");
       pack();}
 }
 if (e.getSource()==b5)
 {if(t5.getText().trim().length()<=0)
    JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the warnings field! ", "Reminder", JOptionPane.WARNING_MESSAGE);
  else{p.resetTabel5(t5.getText().trim());
       t5.setText("");
       pack();}
 }
 if (e.getSource()==b6)
 {if(t6.getText().trim().length()<=0)
    JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the administration field! ", "Reminder", JOptionPane.WARNING_MESSAGE);
  else{p.resetTabel6(t6.getText().trim());
       t6.setText("");
       pack();}
 }
 if(e.getSource()==z)
  {p.setTabel(); pack();}
 if(e.getSource()==cataF)
  {if(c.getNbr(1)==null)
     JOptionPane.showMessageDialog(pab,"Error!\nNo medicine is in stock or picked!", "Reminder", JOptionPane.WARNING_MESSAGE);
   else
   {f=new EntriesFrame();
    f.pack();
    f.setLocation(0, 0);
    f.setVisible(true);}
  }
 if(e.getSource()==cataS)
  {if(c.getNbr(1)==null)
     JOptionPane.showMessageDialog(pab,"Error!\nNo medicine is in stock or picked!", "Reminder", JOptionPane.WARNING_MESSAGE);
   else
   {s=new EntryFrame(c.getNbr(cp.getIndexProdus()+1));
    s.pack();
    s.setLocation(0, 0);
    s.setVisible(true);}
  }
 }
 }
}
