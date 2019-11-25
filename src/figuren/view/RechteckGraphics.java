package figuren.view;

import figuren.model.Rechteck;

import javax.swing.*;
import java.awt.*;

/**
 * Dieses Panel zeichnet die Figuren.
 * @author Lisa Vittori
 * @version 2019-11-25
 */
public class RechteckGraphics extends JPanel {
  private Rechteck[] rechtecke;

  /**
   * Erzeugt eine neue Zeichenumgebung ohne Rechtecke
   */
  public RechteckGraphics() {
    rechtecke = new Rechteck[0];
  }


  /**
   * Fügt der Zeichenumgebung ein neues Rechteck hinzu
   * @param r das neue Rechteck
   */
  public void addFigur(Rechteck r) {
    boolean save = false;
    for(int i = 0; i < rechtecke.length && !save; i++) {
      if(rechtecke[i] == null) {
        rechtecke[i] = r;
        save = true;
      }
    }
    if(!save) {
      Rechteck[] temp = new Rechteck[rechtecke.length+1];
      for(int i = 0; i < rechtecke.length; i++) {
        temp[i] = rechtecke[i];
      }
      temp[temp.length-1] = r;
      rechtecke = temp;
    }
  }

  /**
   * Wird aufgerufen, wenn der Zeichenkontext verändert wird.
   * @param g die Zeichenumgebung
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for(int i = 0; i < rechtecke.length; i++) {
      if(rechtecke[i] != null) {
        rechtecke[i].draw(g);
      }
    }
  }
  
  /**
   * Gibt die gespeicherten Rechtecke als String-Array zurück.
   * @return die gespeicherten Rechtecke
   */
  public String[] textListe() {
    String[] tl = new String[rechtecke.length];
    for(int i = 0; i < rechtecke.length; i++) {
      tl[i] = i + " " + rechtecke[i].toString();
    }
    return tl;
  }
}
