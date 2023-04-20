package mvc.controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mvc.views.PhotoAlbumTextView;
import photoalbum.PhotoPage;
import shapes.Color;
import shapes.IShape;
import shapes.Point2D;

public class PhotoAlbumControllerText {
  private final PhotoPage page;
  private PhotoAlbumTextView view;
  File file;

  /**
   * Initiates a text view controller object.
   * @param page the model (photo page)
   * @param view text view (HTML with embedded SVG)
   * @param file input file
   * @throws FileNotFoundException
   */
  public PhotoAlbumControllerText(PhotoPage page, PhotoAlbumTextView view, File file)
          throws FileNotFoundException {
    this.page = page;
    this.view = view;
    this.file = file;
  }

  /**
   * Acquires the shapes history from the snapshot of the page.
   * @return list of shapes from snapshot history
   */
  public void getShapes() {
    List<String> keys = new ArrayList<>(page.getSnapShots().keySet());
    for (int i = 0; i < keys.size(); i++) {
      this.view.addSnapshot(page.getSnapShots().get(keys.get(i)));
      this.view.addShapes(page.getSnapShots().get(keys.get(i)).getPageShapes());
      this.view.paint();
    }
    this.view.footer();
  }

  /**
   * Starts the controller
   * @throws FileNotFoundException if data file does not exist
   */
  public void go() throws FileNotFoundException {
    processFile(file);
    getShapes();
  }

  /**
   * Processes data file line by line.
   * @param file data file with commands
   * @throws FileNotFoundException if file does not exist
   */
  public void processFile(File file) throws FileNotFoundException {
    String line;
    Scanner scanner;
    scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      List<String> commands = new ArrayList<>();
      line = scanner.nextLine();

      if (!line.startsWith("#") && line.length() > 0) { // if not a comment and not a blank line
        processCommands((line.trim().replaceAll("\\s{2,}", " ")));
      }
    }
  }

  /**
   * Processes the line command from file.
   * @param command string line
   */
  private void processCommands(String command) {
    String[] parameters = command.split(" ");
    int length = parameters.length;

    switch (parameters[0]) {
      case "shape": // couldn't think of a more elegant way of doing this
        if (parameters[2].equalsIgnoreCase("rectangle")
                || parameters[2].equalsIgnoreCase("oval")
                || parameters[2].equalsIgnoreCase("triangle")) { // all 2 parameter shapes

          String shapeDescription = parameters[1];
          String type = parameters[2];
          int param1 = Integer.parseInt(parameters[5]);
          int param2 = Integer.parseInt(parameters[6]);
          Point2D point = new Point2D(Integer.parseInt(parameters[3])
                  , Integer.parseInt(parameters[4]));
          Color color = new Color(Integer.parseInt(parameters[7]), Integer.parseInt(parameters[8]),
                  Integer.parseInt(parameters[9]));

          IShape shape = page
                  .create2ParameterShape(type, param1, param2, point, color, shapeDescription);
          page.addShape(shape);
        }
        if (parameters[2].equalsIgnoreCase("circle")
                || parameters[2].equalsIgnoreCase("square")) {

          String shapeDescription = parameters[1];
          String type = parameters[2];
          int param1 = Integer.parseInt(parameters[5]);
          Point2D point = new Point2D(Integer.parseInt(parameters[3])
                  , Integer.parseInt(parameters[4]));
          Color color = new Color(Integer.parseInt(parameters[6]), Integer.parseInt(parameters[7]),
                  Integer.parseInt(parameters[8]));

          IShape shape = page.create1ParameterShape(type, param1, point, color, shapeDescription);
          page.addShape(shape);
        }
        break;
      case "move":
        Point2D point = new Point2D(Integer.parseInt(parameters[2]),
                Integer.parseInt(parameters[3]));
        page.moveShape(parameters[1], point);
        break;
      case "resize":
        page.changeSize(parameters[1], Integer.parseInt(parameters[2]),
                Integer.parseInt(parameters[3]));
        break;
      case "color":
        Color color = new Color(Integer.parseInt(parameters[2]), Integer.parseInt(parameters[3]),
                Integer.parseInt(parameters[4]));
        page.changeColor(parameters[1], color);
        break;
      case "snapShot":
        String description = "";
        for (int i = 1; i < length; i++) {
          description = description + " " + parameters[i];
        }
        page.capture(description);
        break;
      case "snapshot":
        String des = "";
        for (int i = 1; i < length; i++) {
          des = des + " " + parameters[i];
        }
        page.capture(des);
        break;
    }
  }
}
