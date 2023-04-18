package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the close listener for the graphical window.
 */
public class MyCloseListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    System.exit(0);
  }
}
