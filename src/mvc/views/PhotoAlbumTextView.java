package mvc.views;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


import photoalbum.Snapshot;
import shapes.IShape;

/**
 * MVC application for HTML text view of photo album page.
 */
public class PhotoAlbumTextView {
  private List<IShape> shapesList = new ArrayList<>();
  private Snapshot snapshot;
  private String fileName = "";
  private static final int WIDTH = 600;
  private static final int HEIGHT = 700;

  /**
   * Textual view of the photo album page.
   * @param name name of HTML page
   */
  public PhotoAlbumTextView(String name) {
    if (name.equals(null) || name.equals("")) {
      throw new IllegalArgumentException("File name cannot be empty.");
    }
    this.fileName = name + ".html";
    StringBuilder html = new StringBuilder();
    html.append("<html>\n");
    html.append("<head>\n\t<title>" + "CS5004 Photo Album View"
            + "</title>\n</head>\n" + "<body>\n");
    String dimensions = "<svg width=\"" + WIDTH + "\" height=\"" + HEIGHT + "\">\n";
    html.append(dimensions);
    String output = html.toString();
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName));
      writer.write(output);
      writer.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  /**
   * Adds shapes to the list to be drawn
   * @param list IShapes list of shapes in snapshot.
   */
  public void addShapes(List<IShape> list) {
    this.shapesList = new ArrayList<>();
    for (IShape each : list) {
      this.shapesList.add(each);
    }
  }


  /**
   * Adds the snapshot ID as a header.
   */
  private void addSnapHeader() {
    StringBuilder html = new StringBuilder();
    html.append("<header> " + this.snapshot.getSnapID() + "\n" + this.snapshot.getDescription()
            + "\n </header>\n");
    String output = html.toString();
    writeToFile(output);
  }

  /**
   * "Paints" the shapes to HTML SVG format.
   */
  public void paint() {
    StringBuilder html = new StringBuilder();
    String shapes = shapesToSVG();
    addSnapHeader();
    html.append(shapes);
    String output = html.toString();
    writeToFile(output);
  }

  /**
   * Helper method to write to file.
   * @param output output to file.
   */
  private void writeToFile(String output) {
    try {
      Writer writer = new BufferedWriter(new OutputStreamWriter(
              new FileOutputStream(this.fileName, true)));
      writer.append(output);
      writer.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * This adds to the footer to the HTML file.
   */
  public void footer() {
    StringBuilder html = new StringBuilder();
    html.append("</body>\n" + "</html>\n");
    String output = html.toString();
    writeToFile(output);
  }

  /**
   * Converts the shapes list to SVG text for HTMl visualization.
   * @return string to be added to HTML page.
   */
  private String shapesToSVG() {
    String svg = "";

    for (IShape each : this.shapesList) {
      String color = each.getColor().toString();
      String x = String.valueOf(each.getLocation().getX());
      String y = String.valueOf(each.getLocation().getY());
      String param1 = String.valueOf(each.getParam1());
      String param2 = String.valueOf(each.getParam2());

      switch (each.getClass().getSimpleName()) {
        case "Rectangle":

          svg = svg + "\t<rect x=\"" + x + "\" y=\"" + y
                  + "\" width=\"" + param1 + "\" height=\"" + param2 + "\" "
                  + "fill=\"" + color + "\" />\n";
        case "Oval":
          svg = svg + "\t<ellipse x=\"" + x + "\" y=\"" + y + "\" "
                  + "width=\"" + param1 + "\" height= \"" + param2 + "\" "
                  + "fill=\"" + color + "\" />\n";
      }
    }

    return svg;
  }

  /**
   * Adds snapshot to the view to extract snapshot information.
   * @param snapshot snapshot
   */
  public void addSnapshot(Snapshot snapshot) {
    this.snapshot = snapshot;
  }
}


