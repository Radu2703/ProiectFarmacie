package proiectfarmacie;
import javax.swing.*;
import java.awt.*;
public class MedicineTable extends JPanel
{private GridBagLayout gb;
 private GridBagConstraints gbc;
 private JTable tabel;
 private Catalog c;
 private CatalogPanel cp;
public MedicineTable(Catalog c)
{this.c=c;
 int i;
 cp=new CatalogPanel(c);
 gb=new GridBagLayout();
 gbc=new GridBagConstraints();
 gbc.fill=GridBagConstraints.HORIZONTAL;
 gbc.anchor=GridBagConstraints.NORTH;
 setLayout(gb);
 setSize(new Dimension(1000,100));
 tabel=cp.getTabel();
 tabel.setSize(500, 200);
 addComponent(tabel,0,0,7,c.getDimensiune()+1);}
public void addComponent(Component c, int linie, int coloana, int lat, int inaltime)
{gbc.gridx=coloana;
 gbc.gridy=linie;
 gbc.gridwidth=lat;
 gbc.gridheight=inaltime;
 gb.setConstraints(c,gbc);
 add(c);}
public void setTabel()
{remove(tabel);
 tabel=cp.getTabel();
 add(tabel);}
public void resetTabel1(String name)
{remove(tabel);
 tabel=cp.resetTabel1(name);
 add(tabel);}
public void resetTabel2(String comp)
{remove(tabel);
 tabel=cp.resetTabel2(comp);
 add(tabel);}
public void resetTabel3(double p)
{remove(tabel);
 tabel=cp.resetTabel3(p);
 add(tabel);}
public void resetTabel4(String ind)
{remove(tabel);
 tabel=cp.resetTabel4(ind);
 add(tabel);}
public void resetTabel5(String contra)
{remove(tabel);
 tabel=cp.resetTabel5(contra);
 add(tabel);}
public void resetTabel6(String admin)
{remove(tabel);
 tabel=cp.resetTabel6(admin);
 add(tabel);}
}