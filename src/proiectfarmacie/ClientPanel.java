package proiectfarmacie;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ClientPanel extends JPanel implements ActionListener{
 private JLabel numeL,prenumeL,prescripL;
 private JTextField numeT,prenumeT,prescripT;
 private JButton submit;
 private JCheckBox reteta;
 private GridBagLayout gb;
 private GridBagConstraints gbc;
 private Person c;
 private Sale sale;
 private CommandFrame f;
public ClientPanel(CommandFrame f)
{super();
 this.f=f;
 gb=new GridBagLayout();
 gbc=new GridBagConstraints();
 gbc.fill=GridBagConstraints.HORIZONTAL;
 setLayout(gb);
 setPreferredSize(new Dimension(400,100));
 gbc.anchor=GridBagConstraints.EAST;
 numeL=new JLabel("Surname");
 addComponent(numeL,0,0,1,1);
 numeT=new JTextField(10);
 numeT.addActionListener(this);
 addComponent(numeT,0,1,1,1);
 prenumeL=new JLabel("Name");
 addComponent(prenumeL,1,0,1,1);
 prenumeT=new JTextField(10);
 prenumeT.addActionListener(this);
 addComponent(prenumeT,1,1,1,1);
 reteta=new JCheckBox("Prescription");
 reteta.addActionListener(this);
 addComponent(reteta,0,2,1,1);
 prescripL=new JLabel("   Compensation");
 addComponent(prescripL,1,2,1,1);
 prescripT=new JTextField(10);
 prescripT.setEnabled(false);
 prescripT.addActionListener(this);
 addComponent(prescripT,1,3,1,1);
 submit=new JButton("Submit");
 submit.addActionListener(this);
 addComponent(submit,2,2,1,1);}
public void addComponent(Component c, int linie,int coloana, int lat, int inaltime)
{gbc.gridx=coloana;
 gbc.gridy=linie;
 gbc.gridwidth=lat;
 gbc.gridheight=inaltime;
 gb.setConstraints(c,gbc);
 add(c);}
public Sale getVanzare()
 {return sale;}
public void actionPerformed(ActionEvent e)
{if(e.getSource()==numeT)prenumeT.requestFocus();
 if(e.getSource()==reteta)
 {prescripT.setEnabled(true);
  prescripT.requestFocus();}
 if (e.getSource()==submit)
 {if((numeT.getText().trim().length()>0&&prenumeT.getText().trim().length()>0)&&(reteta.isSelected()==false||(reteta.isSelected()&&prescripT.getText().trim().length()>0)))
  {c=new Person(numeT.getText().trim(),prenumeT.getText().trim());
   sale=new Sale(c);
   sale.setPrescription(reteta.isSelected());
   if(reteta.isSelected()&&prescripT.getText().trim().length()>0)
      try{sale.setCompensation(Double.parseDouble(prescripT.getText()));}
      catch(NumberFormatException nf)
      {JOptionPane.showMessageDialog(this,"Error!\nYou need to enter a real number for compensation!", "Reminder", JOptionPane.WARNING_MESSAGE);
       prescripT.setText("");}
   if((numeT.getText().trim().length()>0&&prenumeT.getText().trim().length()>0)&&(reteta.isSelected()==false||(reteta.isSelected()&&prescripT.getText().trim().length()>0)))
     {f.listaP.setEnabled(true);
      f.cantitateT.setEnabled(true);
      f.add.setEnabled(true);
      prescripT.setEnabled(false);
      if(reteta.isSelected()&&prescripT.getText().trim().length()>0){f.comp.setEnabled(true);f.comp.setSelected(true);}
      f.add.repaint();}
  }
 else if(numeT.getText().trim().length()==0||prenumeT.getText().trim().length()==0)
    {JOptionPane.showMessageDialog(this,"Error!\nYou need to fill the fields for name and surname!", "Reminder", JOptionPane.WARNING_MESSAGE);
     numeT.setText("");prenumeT.setText("");}
 else if(reteta.isSelected()&&prescripT.getText().trim().length()==0)
    {JOptionPane.showMessageDialog(this,"Error!\nYou need to enter the compensation for the prescription!", "Reminder", JOptionPane.WARNING_MESSAGE);
     prescripT.setText("");}
 }
}
public void curata()
{numeT.setText("");
 prenumeT.setText("");
 sale=null;
 prescripT.setText("");
 reteta.setSelected(false);}
}