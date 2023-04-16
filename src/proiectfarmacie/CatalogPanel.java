package proiectfarmacie;
import java.awt.event.*;
import javax.swing.*;
public class CatalogPanel extends JPanel implements ItemListener{
 private JComboBox listaP;
 private int indexProdus;
 private JTable tabel;
 private Catalog c;
 private int i;
public CatalogPanel(Catalog lista)
{super();
 c=lista;
 String[] elemente=lista.incarca();
 listaP=new JComboBox(elemente);
 listaP.addItemListener(this);}
public void itemStateChanged(ItemEvent e)
 {indexProdus=listaP.getSelectedIndex();}
public int getIndexProdus()
 {return indexProdus;}
public JComboBox getComboBox()
 {return listaP;}
public JTable getTabel()
{tabel=new JTable(c.getDimensiune()+1,6);
 tabel.setValueAt("Name",0,0);
 tabel.setValueAt("Composition",0,1);
 tabel.setValueAt("Indications",0,2);
 tabel.setValueAt("Warnings",0,3);
 tabel.setValueAt("Administration",0,4);
 tabel.setValueAt("Price",0,5);
 for(i=0;i<c.getDimensiune();i++)
 {ProductSpecification p=c.getNbr(i+1);
  tabel.setValueAt(p.getDenumire(), i+1, 0);
  tabel.setValueAt(p.getCompozitie(), i+1, 1);
  tabel.setValueAt(p.getIndicatii(), i+1, 2);
  tabel.setValueAt(p.getContraindicatii(), i+1, 3);
  tabel.setValueAt(p.getMod_administrare(), i+1, 4);
  tabel.setValueAt(p.getPret(), i+1, 5);}
 for(i=0;i<=5;i++)tabel.getColumnModel().getColumn(i).setPreferredWidth(100);
 return tabel;}
public JTable resetTabel1(String name)
{tabel=new JTable(c.getDimensiune()+1,6);
 int nr=0;
 tabel.setValueAt("Name",0,0);
 tabel.setValueAt("Composition",0,1);
 tabel.setValueAt("Indications",0,2);
 tabel.setValueAt("Warnings",0,3);
 tabel.setValueAt("Administration",0,4);
 tabel.setValueAt("Price",0,5);
 for(i=0;i<c.getDimensiune();i++)
  if(c.getNbr(i+1).getDenumire().equals(name))
  {tabel.setValueAt(c.getNbr(i+1).getDenumire(), nr+1, 0);
   tabel.setValueAt(c.getNbr(i+1).getCompozitie(), nr+1, 1);
   tabel.setValueAt(c.getNbr(i+1).getIndicatii(), nr+1, 2);
   tabel.setValueAt(c.getNbr(i+1).getContraindicatii(), nr+1, 3);
   tabel.setValueAt(c.getNbr(i+1).getMod_administrare(), nr+1, 4);
   tabel.setValueAt(c.getNbr(i+1).getPret(), nr+1, 5);
   nr++;}
 for(i=0;i<=5;i++)tabel.getColumnModel().getColumn(i).setPreferredWidth(100);
 return tabel;}
public JTable resetTabel2(String compozitie)
{tabel=new JTable(c.getDimensiune()+1,6);
 int nr=0;
 compozitie=compozitie.trim();
 String com[]=compozitie.split(";");
 tabel.setValueAt("Name",0,0);
 tabel.setValueAt("Composition",0,1);
 tabel.setValueAt("Indications",0,2);
 tabel.setValueAt("Warnings",0,3);
 tabel.setValueAt("Administration",0,4);
 tabel.setValueAt("Price",0,5);
 for(i=0;i<c.getDimensiune();i++)
 {int f=0,j,k;
  String ing[]=c.getNbr(i+1).getCompozitie().split(";");
  for(j=0;j<com.length;j++)
    for(k=0;k<ing.length;k++)
      if(ing[k].trim().equals(com[j].trim())==true){f++;break;}
  if(f==com.length)
  {tabel.setValueAt(c.getNbr(i+1).getDenumire(), nr+1, 0);
   tabel.setValueAt(c.getNbr(i+1).getCompozitie(), nr+1, 1);
   tabel.setValueAt(c.getNbr(i+1).getIndicatii(), nr+1, 2);
   tabel.setValueAt(c.getNbr(i+1).getContraindicatii(), nr+1, 3);
   tabel.setValueAt(c.getNbr(i+1).getMod_administrare(), nr+1, 4);
   tabel.setValueAt(c.getNbr(i+1).getPret(), nr+1, 5);
   nr++;}}
 for(i=0;i<=5;i++)tabel.getColumnModel().getColumn(i).setPreferredWidth(100);
 return tabel;}
public JTable resetTabel3(double p)
{tabel=new JTable(c.getDimensiune()+1,6);
 int nr=0;
 tabel.setValueAt("Name",0,0);
 tabel.setValueAt("Composition",0,1);
 tabel.setValueAt("Indications",0,2);
 tabel.setValueAt("Warnings",0,3);
 tabel.setValueAt("Administration",0,4);
 tabel.setValueAt("Price",0,5);
 for(i=0;i<c.getDimensiune();i++)
  if(c.getNbr(i+1).getPret()==p)
  {tabel.setValueAt(c.getNbr(i+1).getDenumire(), nr+1, 0);
   tabel.setValueAt(c.getNbr(i+1).getCompozitie(), nr+1, 1);
   tabel.setValueAt(c.getNbr(i+1).getIndicatii(), nr+1, 2);
   tabel.setValueAt(c.getNbr(i+1).getContraindicatii(), nr+1, 3);
   tabel.setValueAt(c.getNbr(i+1).getMod_administrare(), nr+1, 4);
   tabel.setValueAt(c.getNbr(i+1).getPret(), nr+1, 5);
   nr++;}
 for(i=0;i<=5;i++)tabel.getColumnModel().getColumn(i).setPreferredWidth(100);
 return tabel;}
public JTable resetTabel4(String ind)
{tabel=new JTable(c.getDimensiune()+1,6);
 int nr=0;
 tabel.setValueAt("Name",0,0);
 tabel.setValueAt("Composition",0,1);
 tabel.setValueAt("Indications",0,2);
 tabel.setValueAt("Warnings",0,3);
 tabel.setValueAt("Administration",0,4);
 tabel.setValueAt("Price",0,5);
 for(i=0;i<c.getDimensiune();i++)
  if(c.getNbr(i+1).getIndicatii().contains(ind))
  {tabel.setValueAt(c.getNbr(i+1).getDenumire(), nr+1, 0);
   tabel.setValueAt(c.getNbr(i+1).getCompozitie(), nr+1, 1);
   tabel.setValueAt(c.getNbr(i+1).getIndicatii(), nr+1, 2);
   tabel.setValueAt(c.getNbr(i+1).getContraindicatii(), nr+1, 3);
   tabel.setValueAt(c.getNbr(i+1).getMod_administrare(), nr+1, 4);
   tabel.setValueAt(c.getNbr(i+1).getPret(), nr+1, 5);
   nr++;}
 for(i=0;i<=5;i++)tabel.getColumnModel().getColumn(i).setPreferredWidth(100);
 return tabel;}
public JTable resetTabel5(String count)
{tabel=new JTable(c.getDimensiune()+1,6);
 int nr=0;
 tabel.setValueAt("Name",0,0);
 tabel.setValueAt("Composition",0,1);
 tabel.setValueAt("Indications",0,2);
 tabel.setValueAt("Warnings",0,3);
 tabel.setValueAt("Administration",0,4);
 tabel.setValueAt("Price",0,5);
 for(i=0;i<c.getDimensiune();i++)
  if(c.getNbr(i+1).getContraindicatii().contains(count))
  {tabel.setValueAt(c.getNbr(i+1).getDenumire(), nr+1, 0);
   tabel.setValueAt(c.getNbr(i+1).getCompozitie(), nr+1, 1);
   tabel.setValueAt(c.getNbr(i+1).getIndicatii(), nr+1, 2);
   tabel.setValueAt(c.getNbr(i+1).getContraindicatii(), nr+1, 3);
   tabel.setValueAt(c.getNbr(i+1).getMod_administrare(), nr+1, 4);
   tabel.setValueAt(c.getNbr(i+1).getPret(), nr+1, 5);
   nr++;}
 for(i=0;i<=5;i++)tabel.getColumnModel().getColumn(i).setPreferredWidth(100);
 return tabel;}
public JTable resetTabel6(String admin)
{tabel=new JTable(c.getDimensiune()+1,6);
 int nr=0;
 tabel.setValueAt("Name",0,0);
 tabel.setValueAt("Composition",0,1);
 tabel.setValueAt("Indications",0,2);
 tabel.setValueAt("Warnings",0,3);
 tabel.setValueAt("Administration",0,4);
 tabel.setValueAt("Price",0,5);
 for(i=0;i<c.getDimensiune();i++)
  if(c.getNbr(i+1).getMod_administrare().contains(admin))
  {tabel.setValueAt(c.getNbr(i+1).getDenumire(), nr+1, 0);
   tabel.setValueAt(c.getNbr(i+1).getCompozitie(), nr+1, 1);
   tabel.setValueAt(c.getNbr(i+1).getIndicatii(), nr+1, 2);
   tabel.setValueAt(c.getNbr(i+1).getContraindicatii(), nr+1, 3);
   tabel.setValueAt(c.getNbr(i+1).getMod_administrare(), nr+1, 4);
   tabel.setValueAt(c.getNbr(i+1).getPret(), nr+1, 5);
   nr++;}
 for(i=0;i<=5;i++)tabel.getColumnModel().getColumn(i).setPreferredWidth(100);
 return tabel;}
}