package photoalbumviewer;

import java.util.List;
import photoalbum.Snapshot;

/**
 * Interface to view the photo album page.
 */
public interface IPhotoAlbumViewer {

  /**
   * Takes in file and reads parameters for photo page setup.
   */
  void readFile();
  List<String> listSnapshots();
  Snapshot nextSnapshot();
  Snapshot previousSnapshot();
  Snapshot loadSnapshot();

}
