package swing;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JButton;
import photoalbum.PhotoPage;
import shapes.*;
import photoalbum.Snapshot;

/**
 * Swing graphical view of the photo album.
 */
public class PhotoAlbumSwingView extends JFrame {

  /**
   * The main driver for the photo album graphical view application.
   */
  public static void main(String[] args) throws IOException {
    PhotoPage page = PhotoPage.getPage(); // model
    SwingView view = new SwingView(); // view
    File file = new File("C:\\Users\\User1\\IdeaProjects\\CS5004\\cs5004_photo_album\\demo_input.txt");
    PhotoAlbumMVCControllerVisual controller = new PhotoAlbumMVCControllerVisual(page, view);
    controller.go();
  }
}

/**
 * This class creates a graphic window of desired size and appropriate buttons.
 */
class SwingView extends JFrame {
  private JButton quitButton;
  private JButton nextSnap;
  private JButton previousSnap;
  private JButton listSnaps;
  public static final int WIDTH = 700;
  public static final int HEIGHT = 600;
  private static final int BUTTON_SIZE_X = 100;
  private static final int BUTTON_SIZE_Y = 25;
  private static final int QUIT_X = 450;
  private static final int QUIT_Y = 525;

  /**
   * Creates the swing window for the graphical view.
   */
  public SwingView() {
    super();
    setLayout(null);
    setSize(WIDTH, HEIGHT);
    setTitle("CS5004 Shapes Photo Album Viewer");
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // ignore x on window
    createQuitButton();
  }

  /**
   * Adds quit button to window
   */
  private void createQuitButton() {
    //create quit button
    quitButton = new JButton("xx Quit xx");
    quitButton.setBounds(QUIT_X, QUIT_Y, BUTTON_SIZE_X, BUTTON_SIZE_Y);
    quitButton.addActionListener(new MyCloseListener());
    add(quitButton);
  }

  /**
   * Draws out components
   * @param g graphics instance
   */
  public void paint(Graphics g) {
    super.paint(g);

    g.setColor(Color.RED);
    g.drawRect(150, 200, 50, 100);
    g.drawString("Testing testing", 100, 200);

    // TODO create draw rec and draw oval functions. iterate through snapshot history list of shapes, call associated functions inside paint
  }

  /**
   * Sets the action listener for individual buttons.
   * Action listener will be the controller.
   * @param listener action listener.
   */
  public void setActionListener(ActionListener listener) {
    /*
    nextSnap.addActionListener(listener);
    previousSnap.addActionListener(listener);
    listSnaps.addActionListener(listener);

     */
  }
}

/**
 * This represents the controller for the photo album graphical view application.
 */
class PhotoAlbumMVCControllerVisual implements ActionListener {
  PhotoPage page;
  SwingView view;
  List<String> directions;

  /**
   * Instantiates a controller object.
   * @param page the model (photo page)
   * @param view the view (swing view)
   */
  public PhotoAlbumMVCControllerVisual(PhotoPage page, SwingView view)
      throws FileNotFoundException {
    this.page = page;
    this.view = view;
    this.view.setActionListener(this);
    InterpretFile interpreter = new InterpretFile();
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
    /*switch(e.getActionCommand()) {
      case "Next":

    }
     */
  }

  /**
   * Acquires the snapshot history for the page
   * @return linked hashmap with snapshot history
   */
  public Snapshot getSnapshotIDs() {
    // TODO iterate through snapshots to acquire list

    return null;
  }
}
