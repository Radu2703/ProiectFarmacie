package proiectfarmacie;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class EntryFrame extends JFrame
{private JTextArea ta;
public EntryFrame(ProductSpecification p)
{super ("Medicine Item");
 add(new JLabel("Selected Medicine Item"), BorderLayout.NORTH);
 ta=new JTextArea(100,10);
 ta.setText(p.toString());
 ta.setEnabled(true);
 add(ta);
 addWindowListener(new WindowAdapter()
  {@Override
   public void windowClosing(WindowEvent we)
   {EntryFrame.this.dispose();}});
 }
}
