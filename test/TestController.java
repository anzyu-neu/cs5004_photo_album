import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.StringReader;

import mvc.controller.InterpretFile;
import mvc.controller.PhotoAlbumControllerText;
import mvc.views.PhotoAlbumTextView;
import photoalbum.PhotoPage;
import photoalbum.Snapshot;

import static org.junit.Assert.assertEquals;

/**
 * JUnit testing for the controllers for graphical and text view.
 */
public class TestController {
  private PhotoPage page;
  private PhotoAlbumTextView view;
  private File file;

  /**
   * Prepares objects for testing.
   */
  @Before
  public void setUp() {
    this.page = PhotoPage.getPage();
    this.view = new PhotoAlbumTextView("Test View");
    this.file = new File("C:\\Users\\ayu92\\IdeaProjects\\cs5004_photo_album\\test_file");
  }

  /**
   * Tests file interpreter
   * @throws FileNotFoundException if file not found
   */
  @Test
  public void testFileReader() throws FileNotFoundException {
    PhotoAlbumControllerText controller = new PhotoAlbumControllerText
            (this.page, this.view, this.file);
    controller.processFile(this.file);

  }

  /**
   * Tests textual output.
   */
  @Test
  public void testGo() throws FileNotFoundException {
    this.page = PhotoPage.getPage();
    this.view = new PhotoAlbumTextView("Test View");
    this.file = new File("C:\\Users\\ayu92\\IdeaProjects\\cs5004_photo_album\\test_file");
    PhotoAlbumControllerText controller = new PhotoAlbumControllerText
            (this.page, this.view, this.file);
  }
}
