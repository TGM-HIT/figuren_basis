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
    // TODO Auto-generated method stub
    
  }
  
  public static void main(String[] args) {
    new FigurController();
  }

}
