package photoalbumviewer;

import java.io.File;
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
  private File file;
  private static int WIDTH;
  private static int HEIGHT;

  /**
   * Constructs the graphical view instance for rendering.
   * @param file name of file with page descriptions to create.
   * @param xMax width of canvas
   * @param yMax height of canvas
   */
  public PhotoAlbumGraphical(File file, int xMax, int yMax) {
    if (!file.exists()) {
      throw new IllegalArgumentException("File does not exist.");
    }
    this.page = PhotoPage.getPage();
    this.file = file;
    this.WIDTH = xMax;
    this.HEIGHT = yMax;
  }

  @Override
  public void readFile() {
    return;
  }

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
