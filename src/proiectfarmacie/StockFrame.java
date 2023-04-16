package proiectfarmacie;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StockFrame extends JFrame
{private int q=0;
 private JButton adauga, cancel;
 private JTextField tf1, tf2, tf3, tf4, tf5, tf6;
 private StockFrameController c;
 private JOptionPane pab;
 private Catalog cat;
 private CatalogPanel cp;
public StockFrame(Catalog cata)
{super("BlueClover Stock Administration");
 JPanel p=new JPanel();
 p.setLayout(new GridLayout(7, 2, 10, 10));
 p.add(new Label("Name"));
 tf1=new JTextField(10);
 p.add(tf1);
 p.add(new Label("Composition"));
 tf2=new JTextField(10);
 p.add(tf2);
 p.add(new Label("Indications"));
 tf3=new JTextField(10);
 p.add(tf3);
 p.add(new Label("Warnings"));
 tf4=new JTextField(10);
 p.add(tf4);
 p.add(new Label("Administration & consumption"));
 tf5=new JTextField(10);
 p.add(tf5);
 p.add(new Label("Price"));
 tf6=new JTextField(10);
 p.add(tf6);
 c=new StockFrameController();
 adauga=new JButton("Add to stock");
 adauga.addActionListener(c);
 p.add(adauga);
 cancel=new JButton("Cancel");
 cancel.addActionListener(c);
 p.add(cancel);
 add(p);
 cat=cata;
 cp=new CatalogPanel(cat);
 setLocation(600,200);
 addWindowListener(new WindowAdapter()
 {@Override
  public void windowClosing(WindowEvent e)
  {if(q==1)cat.descarca();
   dispose();}
 });
}
class StockFrameController implements ActionListener
{public void actionPerformed(ActionEvent e)
{String et=e.getActionCommand();
if (et.equals("Add to stock"))
{if(tf1.getText().trim().length()<=0||tf2.getText().trim().length()<=0||tf3.getText().trim().length()<=0||tf4.getText().trim().length()<=0||tf5.getText().trim().length()<=0||tf6.getText().trim().length()<=0)
    JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the fields! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(cat.getProdus(tf1.getText().trim())!=null)
        JOptionPane.showMessageDialog(pab,"Error!\nYou already entered a medicine with the same name!\nChange name or verify the catalogue to see if you already have the medicine in stock!", "Reminder", JOptionPane.WARNING_MESSAGE);
 else
 {try 
   {q=1;
    cat.add(new ProductSpecification(tf1.getText(),tf2.getText().trim(),tf3.getText(),tf4.getText(),tf5.getText(),Double.parseDouble(tf6.getText())));
    tf1.setText(null);
    tf2.setText(null);
    tf3.setText(null);
    tf4.setText(null);
    tf5.setText(null);
    tf6.setText(null);}
 catch (NumberFormatException er)
  {JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the price field with a real number!", "Reminder", JOptionPane.WARNING_MESSAGE);}
 }
}
 else
 {tf1.setText(null);
  tf2.setText(null);
  tf3.setText(null);
  tf4.setText(null);
  tf5.setText(null);
  tf6.setText(null);}
 }
 }
}