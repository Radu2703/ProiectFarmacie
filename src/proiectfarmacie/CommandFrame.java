package proiectfarmacie;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class CommandFrame extends JFrame implements ActionListener
{private JPanel panel;
 private JLabel produsL,cantitateL;
 JComboBox listaP;
 JTextField cantitateT;
 JButton add, execute, erase;
 JRadioButton comp;
 private Bill bill;
 private Person c;
 private GridBagLayout gb;
 private GridBagConstraints gbc;
 private TabelPanel panelTabel;
 private JTable tabel;
 private ClientPanel cp;
 private int numar=0;
 private Catalog lista;
 private Sale sale;
public CommandFrame(Catalog cat)
{super("BlueClover Medicine Sale");
 lista=cat;
 cp=new ClientPanel(this);
 panel=new JPanel();
 gb=new GridBagLayout();
 panel.setLayout(gb);
 gbc=new GridBagConstraints();
 gbc.fill=GridBagConstraints.BOTH;
 gbc.anchor=GridBagConstraints.NORTH;
 produsL=new JLabel("Name  ");
 addComponent(produsL,0,0,1,1);
 cantitateL=new JLabel(" Quantity");
 addComponent(cantitateL,0,1,1,1);
 listaP=new CatalogPanel(cat).getComboBox();
 listaP.setSelectedIndex(-1);
 if (c==null||sale==null)listaP.setEnabled(false);
 addComponent(listaP,1,0,1,1);
 cantitateT=new JTextField(10);
 if (c==null||sale==null)cantitateT.setEnabled(false);
 addComponent(cantitateT,1,1,1,1);
 comp=new JRadioButton("Compensation?");
 comp.addActionListener(this);
 if (sale==null||sale.getPrescription()==false) comp.setEnabled(false);
 addComponent(comp,1,2,1,1);
 add=new JButton("Add");
 add.addActionListener(this);
 if (c==null) add.setEnabled(false);
 addComponent(add,1,3,1,1);
 execute=new JButton("Execute");
 execute.addActionListener(this);
 execute.setEnabled(false);
 addComponent(execute,1,5,1,1);
 erase=new JButton("Erase tabel");
 erase.addActionListener(this);
 erase.setEnabled(false);
 addComponent(erase,1,4,1,1);
 add(cp, BorderLayout.NORTH);
 add(panel);
 panelTabel=new TabelPanel(cat);
 tabel=panelTabel.getTabel();
 add(panelTabel, BorderLayout.SOUTH);
 setSize(450,430);
 this.setResizable(true);
 setLocation(500,200);
 addWindowListener(new WindowAdapter()
 {@Override
  public void windowClosing(WindowEvent e)
   {dispose();}});
}
private void addComponent(Component c, int linie,int col, int lat, int inal)
{gbc.gridx=col;
 gbc.gridy=linie;
 gbc.gridwidth=lat;
 gbc.gridheight=inal;
 gb.setConstraints(c,gbc);
 panel.add(c);}
public void actionPerformed(ActionEvent e)
{if (e.getSource()==add)
{sale=cp.getVanzare();
 if(sale!=null)
 {try
  {ProductSpecification p=lista.getProdus((String)listaP.getSelectedItem());    
   if(p!=null)
   {if(numar<lista.getDimensiune())
    {Integer.valueOf(cantitateT.getText());
     execute.setEnabled(true);execute.repaint();
     erase.setEnabled(true);erase.repaint();
     numar++;
     sale.addArticol(p.getDenumire(), p.getCompozitie(), p.getIndicatii(), p.getContraindicatii(),p.getMod_administrare(), p.getPret(), Integer.parseInt(cantitateT.getText()), comp.isSelected());
     tabel.setValueAt(""+numar, numar, 0);
     tabel.setValueAt(p.getDenumire(), numar, 1);
     tabel.setValueAt(cantitateT.getText(), numar, 2);
     tabel.setValueAt(String.valueOf(p.getPret()), numar, 3);
     if(sale.getPrescription()==true&&comp.isSelected()==true)tabel.setValueAt(String.valueOf(sale.getCompensation())+"%", numar, 4);
       else tabel.setValueAt("0%", numar, 4);
     panelTabel.repaint();
     cantitateT.setText("");}
    else{JOptionPane.showMessageDialog(this,"Error!\nYou've already added every type of medicine in the table!\nTo make changes, you'll need to erase table and start from scratch!", "Reminder", JOptionPane.WARNING_MESSAGE);}
    }
   else {JOptionPane.showMessageDialog(this,"Error!\nNo medicine is in stock or picked!", "Reminder", JOptionPane.WARNING_MESSAGE);}
   }
  catch(NumberFormatException nf)
   {JOptionPane.showMessageDialog(this,"Error!\nYou need to enter a number for quantity!", "Reminder", JOptionPane.WARNING_MESSAGE);
    cantitateT.setText("");}
  }
 }
else if(e.getSource()==erase)
 {if(numar>0){panelTabel.curata();numar=0;sale.removeAll(sale);erase.setEnabled(false);}
  else JOptionPane.showMessageDialog(this,"Error!\nThere is no medicine added in tabel!", "Reminder", JOptionPane.WARNING_MESSAGE);}
 else if (e.getSource()==execute)
 {bill=new Bill(sale);
  JFrame frame=new BillFrame(bill);
  frame.pack();
  frame.setLocation(400,0);
  frame.setVisible(true);
  listaP.setSelectedIndex(-1);
  comp.setSelected(false);
  comp.setEnabled(false);
  add.setEnabled(false);
  add.repaint();
  cp.curata();
  numar=0;
  panelTabel.curata();
  listaP.setEnabled(false);
  cantitateT.setText("");
  cantitateT.setEnabled(false);
  erase.setEnabled(false);
  erase.repaint();
  pack();
  execute.setEnabled(false);
  execute.repaint();}
}
}
