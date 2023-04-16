package proiectfarmacie;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class EntriesFrame extends JFrame
{private JTextArea ta;
 private Catalog cat;
public EntriesFrame()
{super ("Medicine Catalogue");
 add(new JLabel("All of the medicine items"), BorderLayout.NORTH);
 ta=new JTextArea(100,1);
 cat=Catalog.getInstanta();
 ta.setText(cat.getCatalog());
 ta.setEnabled(true);
 add(ta);
 addWindowListener(new WindowAdapter()
  {@Override
   public void windowClosing(WindowEvent we)
   {EntriesFrame.this.dispose();}});
 }
}
