package mvc.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopUpActionListener implements ActionListener  {
  /**
   * Invoked when an action occurs.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    e.getActionCommand();
  }
}
