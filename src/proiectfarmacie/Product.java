package proiectfarmacie;
public class Product
{private ProductSpecification product;
 private int cantitate;
 private boolean comp;
public Product(String d, String compo, String i, String c, String m, double p, int q, boolean compe)
 {product=new ProductSpecification(d,compo,i,c,m,p);
  cantitate=q;
  this.comp=compe;}
public ProductSpecification getProdus()
 {return product;}
public int getCantitate()
 {return cantitate;}
public boolean getCompensare()
 {return comp;}
public double calculeazaCost()
 {return product.getPret()*cantitate;}
}