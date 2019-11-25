package figuren.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import figuren.model.*;
import figuren.view.*;

public class FigurController implements ActionListener {
  private FigurPanel fp;
  private FigurenListe fl;
  
  public FigurController() {
    fl = new FigurenListe();
    fp = new FigurPanel(fl, this);
    new FigurFrame("Rechtecke", fp, 1000, 700);
    
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String ac = e.getActionCommand();
    switch(ac) {
    case "add":
      int x = fp.getXEingabe();
      int y = fp.getYEingabe();
      int b = fp.getBreite();
      int h = fp.getHoehe();
      if(x>=0 && y>=0 && b>=0 && h>=0) {
        Rechteck r = new Rechteck(x, y, b, h, fp.getFarbe());
        fl.addRechteck(r);
        fp.eintragHinzufuegen(fl.letzesRechteck());
        fp.repaint();
      }
      break;
    case "clear":
      fl.clear();
      fp.clear();
      fp.repaint();
    }   
  }
  
  public static void main(String[] args) {
    new FigurController();
  }

}
