package figuren.model;

import java.awt.*;

/**
 * Verwaltet die Liste an Rechtecken
 * @author Lisa Vittori
 * @version 2019-11-25
 */
public class FigurenListe {
  private Rechteck[] rechtecke;
  
  /**
   * Erstellt eine neue FigurenListe ohne Rechtecke
   */
  public FigurenListe() {
    rechtecke = new Rechteck[0];
  }
  
  /**
   * Fügt der Zeichenumgebung ein neues Rechteck hinzu
   * @param r das neue Rechteck
   */
  public void addRechteck(Rechteck r) {
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
  
  /**
   * Gibt das zuletzt gespeicherte Rechteck zurück
   * @return der Texteintrag mit vorangestelltem Index des zuletzt gespeicherten Rechtecks
   */
  public String letzesRechteck() {
    return (rechtecke.length-1) + " " + rechtecke[rechtecke.length-1].toString();
  }
  
  /**
   * Zeichnet alle gespeicherten Rechtecke auf das übergebene
   * Graphics-Objekt
   * @param g der Zeichenkontext
   */
  public void draw(Graphics g) {
    for(int i = 0; i < rechtecke.length; i++) {
      if(rechtecke[i] != null) {
        rechtecke[i].draw(g);
      }
    }
  }
}
