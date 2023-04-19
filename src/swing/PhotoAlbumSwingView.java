package swing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import photoalbum.PhotoPage;
import shapes.*;

/**
 * Swing graphical view of the photo album.
 */
public class PhotoAlbumSwingView extends JFrame {

  /**
   * The main driver for the photo album graphical view application.
   */
  public static void main(String[] args) throws IOException {

    PhotoPage page = PhotoPage.getPage(); // model
    SwingView view = new SwingView("CS5004 Photo Album Viewer"); // view
    File file = new File("C:\\Users\\User1\\IdeaProjects\\CS5004\\cs5004_photo_album\\demo_input.txt");
    PhotoAlbumMVCControllerVisual controller = new PhotoAlbumMVCControllerVisual(page, view, file);
    controller.go();
  }
}

/**
 * This class creates a graphic window of desired size and appropriate buttons.
 */
class SwingView extends JFrame {
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
   * @return next button
   */
  private JButton createNextButton() {
    JButton next = new JButton("Next ->");
    next.setActionCommand("Next");
    return next;
  }

  private JButton createListButton() {
    JButton list = new JButton("Select ^^");
    list.setActionCommand("List");
    return list;
  }

  private JButton createPreviousButton() {
    JButton prev = new JButton("Previous <-");
    prev.setActionCommand("Previous");
    return prev;
  }

  /**
   * Draws out components
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
   * @param listener action listener.
   */
  public void setActionListener(ActionListener listener) {
    next.addActionListener(listener);
    previous.addActionListener(listener);
    list.addActionListener(listener);
  }

  private void errorMessage() {
    JTextField message = new JTextField("Unable to perform action.");
    message.setEditable(false);
    this.add(message);
  }
}

/**
 * This represents the controller for the photo album graphical view application.
 */
class PhotoAlbumMVCControllerVisual implements ActionListener {
  private PhotoPage page;
  private SwingView view;
  private int count = 0;

  /**
   * Instantiates a controller object.
   * @param page the model (photo page)
   * @param view the view (swing view)
   */
  public PhotoAlbumMVCControllerVisual(PhotoPage page, SwingView view, File file)
      throws FileNotFoundException {
    this.page = page;
    this.view = view;
    this.view.setActionListener(this);
    InterpretFile interpreter = new InterpretFile();
    interpreter.processFile(file);
    getShapes();
  }

  /**
   * Runs the application.
   * @throws IOException if no file provided
   */
  public void go() throws IOException {
    this.view.setVisible(true);
  }

  /**
   * Creates the event for a given action
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    switch(e.getActionCommand()) {
      case "Next":
        this.count--;
        getShapes();
        this.view.repaint();
        break;
    }
  }

  /**
   * Acquires the shapes history from the snapshot of the page.
   * @return list of shapes from snapshot history
   */
  public void getShapes() {
    // TODO iterate through snapshots to acquire list
    List<String> keys = new ArrayList<>(page.getSnapShots().keySet());
    if (this.count >= 0 && this.count <= keys.size()) {
      view.addShapes(page.getSnapShots().get(keys.get(this.count)).getPageShapes());
    }
    else {

    }
  }
}
