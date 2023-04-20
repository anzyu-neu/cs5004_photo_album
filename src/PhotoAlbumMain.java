import java.io.File;
import java.io.IOException;

import mvc.controller.PhotoAlbumControllerText;
import mvc.views.PhotoAlbumTextView;
import photoalbum.PhotoPage;

public class PhotoAlbumMain {
  /**
   * The main driver for the photo album graphical view application.
   */
  public static void main(String[] args) throws IOException {

    PhotoPage page = PhotoPage.getPage(); // model

    File file = new File(args[0]);
    PhotoAlbumTextView view = new PhotoAlbumTextView("CS5004 Photo Album Viewer"); // view
    PhotoAlbumControllerText controller = new PhotoAlbumControllerText(page, view, file);
    controller.go();


  }
}

