import shapes.Color;
import shapes.Point2D;
import swing.PhotoAlbumSwingView;
import photoalbum.PhotoPage;

public class Main {
  public static void main(String[] args) {
    PhotoPage page1 = PhotoPage.getPage();
    page1.addShape(page1.create2ParameterShape("rectangle", 80, 424,
        new Point2D(100, 326), new Color(0, 0, 0), "B0"));

  }
}
