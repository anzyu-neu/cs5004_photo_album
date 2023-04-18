package swing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import photoalbum.PhotoPage;
import shapes.Color;
import shapes.IShape;
import shapes.Point2D;

/**
 * Class to process command data file for photo album pages.
 */
public class InterpretFile {

  PhotoPage page = PhotoPage.getPage();
  public InterpretFile() {
  }
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
          int param1 = Integer.parseInt(parameters[3]);
          int param2 = Integer.parseInt(parameters[4]);
          Point2D point = new Point2D(Integer.parseInt(parameters[5])
              , Integer.parseInt(parameters[6]));
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
          int param1 = Integer.parseInt(parameters[3]);
          Point2D point = new Point2D(Integer.parseInt(parameters[4])
              , Integer.parseInt(parameters[5]));
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
        page.changeSize(parameters[1], Double.parseDouble(parameters[2]),
            Double.parseDouble(parameters[3]));
        break;
      case "snapShot":
        String description = "";
        for (int i = 1; i < length; i++) {
          description = description + parameters[i];
        }
        page.capture(description);
        break;
    }
  }
}
