package proiectfarmacie;
import javax.swing.*;
import java.awt.event.*;
public class MainWindow extends JFrame
{private JButton b1, b2, b3, b4;
 private ButtonsController cb;
 public MainWindow()
 {super("E-Medical Assistant App");
  JPanel p=new JPanel();
  cb=new ButtonsController();
  b1=new JButton("Information about the Pharmacy");
  p.add(b1);
  b1.addActionListener(cb);
  b2=new JButton("Medicine Sale");
  p.add(b2);
  b2.addActionListener(cb);
  b3=new JButton("Stock Administration");
  p.add(b3);
  b3.addActionListener(cb);
  b4=new JButton("Medicine Catalogue");
  p.add(b4);
  b4.addActionListener(cb);
  add(p);}
private class ButtonsController implements ActionListener
{private JFrame f, g, h, i;
 public void actionPerformed(ActionEvent e)
 {if (e.getSource()==b1)
  {if (f==null) f=new PharmacyInfoFrame();
   f.setVisible(true);}
  if (e.getSource()==b2)
  {g=new CommandFrame(Catalog.getInstanta());
   g.pack();
   g.setVisible(true);}
  if (e.getSource()==b3)
  {h=new StockFrame(Catalog.getInstanta());
   h.pack();
   h.setVisible(true);}
  if (e.getSource()==b4)
  {i=new MedicineFrame(Catalog.getInstanta());
   i.pack();
   i.setVisible(true);}
 }
}
public static void main(String[] args)
 {JFrame f=new MainWindow();
  f.setSize(500,100);
  f.setLocation(500,300);
  f.setVisible(true);
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
} 
