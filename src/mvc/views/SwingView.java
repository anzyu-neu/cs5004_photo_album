package mvc.views;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import mvc.listeners.MyCloseListener;
import shapes.IShape;

/**
 * This class creates a graphic window of desired size and appropriate buttons.
 */
public class SwingView extends JFrame {
  private List<IShape> shapesList = new ArrayList<>();
  public static final int WIDTH = 600;
  public static final int HEIGHT = 700;
  private JButton quit;
  private JButton next;
  private JButton previous;
  private JButton list;

  /**
   * Creates the swing window for the graphical view.
   */
  public SwingView(String name) {
    super(name);
    setSize(WIDTH, HEIGHT);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // ignore x on window

    JPanel panel = new JPanel(new BorderLayout());
    panel.setBorder(new EmptyBorder(2, 3, 2, 3));
    JPanel layout = new JPanel(new GridBagLayout());
    layout.setBorder(new EmptyBorder(5, 5, 5, 5));
    JPanel buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.add(next = createNextButton());
    buttonPanel.add(previous = createPreviousButton());
    buttonPanel.add(list = createListButton());
    buttonPanel.add(quit = createQuitButton());
    layout.add(buttonPanel);
    panel.add(layout, BorderLayout.SOUTH);
    add(panel);
    setLocationByPlatform(true);
  }

  /**
   * Creates a quit button for the window
   */
  private JButton createQuitButton() {
    JButton quitButton = new JButton("xx Quit xx");
    quitButton.addActionListener(new MyCloseListener());
    return quitButton;
  }

  /**
   * Creates a next button with action command next.
   *
   * @return next button
   */
  private JButton createNextButton() {
    JButton next = new JButton("Next ->");
    next.setActionCommand("Next");
    return next;
  }

  /**
   * Create select button with action command list.
   *
   * @return list button
   */
  private JButton createListButton() {
    JButton list = new JButton("Select ^^");
    list.setActionCommand("List");
    return list;
  }

  /**
   * Create previous button with action command Previous.
   *
   * @return prev button
   */
  private JButton createPreviousButton() {
    JButton prev = new JButton("Previous <-");
    prev.setActionCommand("Previous");
    return prev;
  }

  /**
   * Draws out components
   *
   * @param g graphics instance
   */
  public void paint(Graphics g) {
    super.paint(g);

    for (IShape each : this.shapesList) {
      Color color = new Color(
              (int) each.getColor().getRed(), (int) each.getColor().getGreen(),
              (int) each.getColor().getBlue());
      switch (each.getClass().getSimpleName()) {
        case "Rectangle":
          g.setColor(color);
          g.fillRect((int) each.getLocation().getX(), (int) each.getLocation().getY(),
                  (int) each.getParam1(), (int) each.getParam2());
          break;
        case "Oval":
          g.setColor(color);
          g.fillOval((int) each.getLocation().getX(), (int) each.getLocation().getY(),
                  (int) each.getParam1(), (int) each.getParam2());
          break;
      }
    }
  }

  /**
   * Adds shapes to the list to be drawn
   * @param list IShapes list of shapes in snapshot.
   */
  public void addShapes(List<IShape> list) {
    for (IShape each : list) {
      this.shapesList.add(each);
      repaint();
    }
  }

  /**
   * Sets the action listener for individual buttons.
   * Action listener will be the controller.
   *
   * @param listener action listener.
   */
  public void setActionListener(ActionListener listener) {
    next.addActionListener(listener);
    previous.addActionListener(listener);
    list.addActionListener(listener);
  }
}
