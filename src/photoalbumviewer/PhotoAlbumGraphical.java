package photoalbumviewer;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JButton;

import photoalbum.PhotoPage;
import photoalbum.Snapshot;

/**
 * This class represents the graphical (swing) view of the photo album page.
 */
public class PhotoAlbumGraphical implements IPhotoAlbumViewer {
  private PhotoPage page;


  @Override
  public List<String> listSnapshots() {
    return null;
  }

  @Override
  public Snapshot nextSnapshot() {
    return null;
  }

  @Override
  public Snapshot previousSnapshot() {
    return null;
  }

  @Override
  public Snapshot loadSnapshot() {
    return null;
  }
}
