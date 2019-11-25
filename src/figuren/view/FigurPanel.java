package figuren.view;

import figuren.controller.FigurController;
import figuren.model.FigurenListe;
import javax.swing.*;
import java.awt.*;

/**
 * Erzeugt das Layout für das Figuren-Zeichenprogramm
 * @author Lisa Vittori
 * @version 2019-11-25
 */
public class FigurPanel extends JPanel {
  private RechteckGraphics graphics;
  private JLabel[] lWerte;
  private JTextField[] tfWerte;
  private JList lRechtecke;
  private JComboBox cbFarben;
  private JButton bAdd, bClear;
  // um die Farben zu verwalten, static da diese für alle Panel-Objekte
  // ident sind, final damit sie nicht geändert werden können.
  private static final Color[] FARBEN = {Color.BLACK, Color.BLUE, Color.RED, 
      Color.GREEN, Color.YELLOW, Color.WHITE};
  private static final String[] FARBNAMEN = {"schwarz", "blau", "rot", 
      "grün", "gelb", "weiß"};

  /**
   * Erzeugt ein Layout, welches die Rechtecke darstellen kann und
   * entsprechende Komponenten beinhaltet, um die Daten für die Rechtecke
   * eingeben zu können.
   * @param figList das Model zur Verwaltung der Rechtecke
   * @param controller der Controller zur Ablaufsteuerung
   */
  public FigurPanel(FigurenListe figList, FigurController controller) {
    this.setLayout(new BorderLayout());

    graphics = new RechteckGraphics(figList);
    this.add(graphics);

    // Bereich für die Eingabe-Werte
    JPanel pWerte = new JPanel(new GridLayout(6, 2));
    lWerte = new JLabel[]{new JLabel("x"), new JLabel("y"), 
        new JLabel("Breite"), new JLabel("Höhe"), new JLabel("Farbe")};
    tfWerte = new JTextField[lWerte.length-1];
    int i;
    for(i = 0; i < tfWerte.length; i++) {
      tfWerte[i] = new JTextField();
      pWerte.add(lWerte[i]);
      pWerte.add(tfWerte[i]);
    }
    pWerte.add(lWerte[i]); // Beschriftung für die Farben
    // Warnung fürs erste ignorieren (außer ihr kennt euch mit Generics aus)
    cbFarben = new JComboBox(FARBNAMEN); 
    pWerte.add(cbFarben);
    bAdd = new JButton("Hinzufügen");
    bAdd.addActionListener(controller);
    pWerte.add(bAdd);
    bClear = new JButton("Zurücksetzen");
    bClear.addActionListener(controller);
    pWerte.add(bClear);


    // rechter Bereich
    JPanel pRechts = new JPanel(new BorderLayout());
    pRechts.add(pWerte, BorderLayout.PAGE_START);
    // Warnung fürs erste ignorieren (außer ihr kennt euch mit Generics aus)
    lRechtecke = new JList();
    pRechts.add(lRechtecke);
    this.add(pRechts, BorderLayout.LINE_END);
  }
}
