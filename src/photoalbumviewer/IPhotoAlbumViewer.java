package photoalbumviewer;

import java.util.List;

import photoalbum.Snapshot;

/**
 * Interface to view the photo album page.
 */
public interface IPhotoAlbumViewer {
  List<String> listSnapshots();
  Snapshot nextSnapshot();
  Snapshot previousSnapshot();
  Snapshot loadSnapshot();
}
