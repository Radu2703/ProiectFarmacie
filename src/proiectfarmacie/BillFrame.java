package proiectfarmacie;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.print.*;
public class BillFrame extends JFrame
{private JButton print, cancel,printF,arhivare;
 private JTextArea arie;
 private JPanel p;
 private BillFrameController c;
 private Bill bill;
 private BillList bills;
 private GridBagLayout gb;
 private GridBagConstraints gbc;
public BillFrame(Bill f)
{super("Pharmacy Bill");
 bill=f;
 gb=new GridBagLayout();
 gbc=new GridBagConstraints();
 gbc.fill=GridBagConstraints.HORIZONTAL;
 gbc.anchor=GridBagConstraints.NORTH;
 p=new JPanel();
 p.setLayout(gb);
 arie=new JTextArea(bill.toString(),50, 30);
 arie.setEditable(false);
 addComponent(arie,0,0,2,5);
 c=new BillFrameController();
 print=new JButton("Print");
 addComponent(print,0,6,1,1);
 print.addActionListener(c);
 printF=new JButton("PrintToFile");
 addComponent(printF,1,6,1,1);
 printF.addActionListener(c);
 arhivare=new JButton("Archive");
 addComponent(arhivare,2,6,1,1);
 arhivare.addActionListener(c);
 cancel=new JButton("Cancel");
 addComponent(cancel,3,6,1,1);
 cancel.addActionListener(c);
 add(p);
 bills=new BillList();
 addWindowListener(new WindowAdapter()
 {@Override
  public void windowClosing(WindowEvent e)
  {bills.descarca();
   dispose();}
 });
}
void addComponent(Component c, int linie,int col, int lat, int inal)
{gbc.gridx=col;
 gbc.gridy=linie;
 gbc.gridwidth=lat;
 gbc.gridheight=inal;
 gb.setConstraints(c,gbc);
 p.add(c);}
class BillFrameController implements ActionListener
{private PrintWriter out;
 @Override
 public void actionPerformed(ActionEvent e)
 {if (e.getSource()==print)
  {PrinterJob imprimanta=PrinterJob.getPrinterJob();
   Book bk=new Book();
   bk.append(new PanelContent(),imprimanta.defaultPage());
   imprimanta.setPageable(bk);
   if(imprimanta.printDialog())
   {try{imprimanta.print();}
    catch (PrinterException pe)
     {arie.append("Imprimanta nu exista");
      arie.repaint();}
    catch(ArrayIndexOutOfBoundsException ae)
    {System.out.println("Ce se printeaza???");}
   }
  }
 else if (e.getSource()==printF)
 {try
  {out=new PrintWriter(new FileOutputStream("Bills.dat"));
   out.write(bill.toString());
   out.flush();
   out.close();}
  catch(FileNotFoundException fe){}
  catch(IOException ioe){}
 }
  else if (e.getSource()==arhivare) bills.adaugaFactura(bill);
  else if (e.getSource()==cancel) setVisible(false);
 }
}
class PanelContent extends JPanel implements Printable
{private BufferedReader br;
 private String sir="";
 public int print(Graphics g, PageFormat pf,int pageIndex)
 throws PrinterException
 {g.setColor(Color.black);
 try
 {StringReader continut=new StringReader(arie.getText());
  br=new BufferedReader(continut);
  int i=0;
  while((sir=br.readLine())!=null)
  {if (sir.length()==0) sir=" ";
   g.drawString(sir,100,100+i);i+= 20;}
 }
 catch(IOException | IllegalArgumentException io){}
 return Printable.PAGE_EXISTS;
 }
}
}
