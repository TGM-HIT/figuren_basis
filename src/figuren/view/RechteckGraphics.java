package figuren.view;

import figuren.model.FigurenListe;

import javax.swing.*;
import java.awt.*;

/**
 * Dieses Panel zeichnet die Figuren.
 * @author Lisa Vittori
 * @version 2019-11-25
 */
public class RechteckGraphics extends JPanel {
  private FigurenListe figList;

  /**
   * Erzeugt eine neue Zeichenumgebung ohne Rechtecke
   */
  public RechteckGraphics(FigurenListe figList) {
    this.figList = figList;
  }

  
  /**
   * Wird aufgerufen, wenn der Zeichenkontext verändert wird.
   * @param g die Zeichenumgebung
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    figList.draw(g);
  }
}
