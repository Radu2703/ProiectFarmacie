package proiectfarmacie;
import javax.swing.*;
import java.awt.*;
public class TabelPanel extends JPanel
{private GridBagLayout gb;
 private GridBagConstraints gbc;
 private JTable tabel;
 private Catalog c;
public TabelPanel(Catalog c)
{this.c=c;
 gb=new GridBagLayout();
 gbc=new GridBagConstraints();
 gbc.fill=GridBagConstraints.HORIZONTAL;
 gbc.anchor=GridBagConstraints.NORTH;
 setLayout(gb);
 setSize(new Dimension(425,100));
 tabel=new JTable(c.getDimensiune()+1,5);
 tabel.setEnabled(false);
 tabel.setValueAt("Number",0,0);
 tabel.setValueAt("Name",0,1);
 tabel.setValueAt("Quantity",0,2);
 tabel.setValueAt("Price/Unit",0,3);
 tabel.setValueAt("Compensation",0,4);
 for(int i=0;i<=4;i++)tabel.getColumnModel().getColumn(i).setPreferredWidth(100);
 addComponent(tabel,0,0,4,c.getDimensiune()+1);}
public void addComponent(Component c, int linie, int coloana, int lat, int inaltime)
 {gbc.gridx=coloana;
  gbc.gridy=linie;
  gbc.gridwidth=lat;
  gbc.gridheight=inaltime;
  gb.setConstraints(c,gbc);
  add(c);}
public JTable getTabel()
 {return tabel;}
public void curata()
 {for (int i=1; i<=c.getDimensiune(); i++)
   for (int j=0; j<=4; j++)
    tabel.setValueAt("",i,j);}
}