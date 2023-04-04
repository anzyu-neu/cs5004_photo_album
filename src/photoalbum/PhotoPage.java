package photoalbum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import shapes.Circle;
import shapes.IShape;
import shapes.Oval;
import shapes.Point2D;
import shapes.Color;
import shapes.Rectangle;
import shapes.Square;
import shapes.Triangle;

/**
 * This class represents a page in the photo album.
 */
public class PhotoPage {
  private static PhotoPage page = null;
  private static Set<IShape> shapes = new HashSet<>();

  /**
   * This is the private default constructor for the photo page.
   */
  private PhotoPage() {};

  /**
   * This returns the page. If a page does not exist, it will create a new page.
   * @return page
   */
  public static PhotoPage getPage() {
    if (page == null) {
      page = new PhotoPage();
    }
    return page;
  }

  /**
   * This creates a shape that has 2 parameters.
   * @param type desired shape (rectangle, oval, triangle).
   * @param value1 width/X Radius/base respectively
   * @param value2 height/Y Radius/height respectively
   * @param point starting point
   * @param color color
   * @param name name/description
   * @return new shape if exists
   */
  public IShape create2ParameterShape(String type, double value1, double value2,
                                      Point2D point, Color color, String name) {
    if (type.equals("") || type.equals(null)) {
      throw new IllegalArgumentException("Shape type cannot be empty or null.");
    }
    if (point == null) {
      throw new IllegalArgumentException("Shape must have a starting point.");
    }
    if (color == null) {
      throw new IllegalArgumentException("Please specify a color.");
    }
    if (type.equalsIgnoreCase("rectangle")) {
      return new Rectangle(value1, value2, point, color, name);
    }
    if (type.equalsIgnoreCase("oval")) {
      return new Oval(value1, value2, point, color, name);
    }
    if (type.equalsIgnoreCase("triangle")) {
      return new Triangle(value1, value2, point, color, name);
    }
    return null;
  }

  /**
   * Creates a shape that has 1 parameter.
   * @param type desired shape (circle, square)
   * @param value radius/width respectively
   * @param point starting point
   * @param color color
   * @param name name/description
   * @return new shape if exists
   */
  public IShape create1ParameterShape(String type, double value, Point2D point,
                                      Color color, String name) {
    if (type.equals("") || type.equals(null)) {
      throw new IllegalArgumentException("Shape type cannot be empty or null.");
    }
    if (point == null) {
      throw new IllegalArgumentException("Shape must have a starting point.");
    }
    if (color == null) {
      throw new IllegalArgumentException("Please specify a color.");
    }
    if (type.equalsIgnoreCase("circle")) {
      return new Circle(value, point, color, name);
    }
    if (type.equalsIgnoreCase("square")) {
      return new Square(value, point, color, name);
    }
    return null;
  }

  /**
   * This gets all the shapes on the page.
   *
   * @return list of shapes
   */
  public List<IShape> getShapes() {
    return List.copyOf(shapes);
  }

  /**
   * This adds a shape to the page.
   *
   * @param shape new shape to be added on the page
   */
  public void addShape(IShape shape) {
    shapes.add(shape);
  }

  /**
   * Change the value of a shape's parameter
   * @param name shape's name/description
   * @param parameter parameter to be changed
   * @param value new value
   */
  public void changeSize(String name, String parameter, double value) {
    for (IShape each : shapes) {
      if (name.equalsIgnoreCase(each.getName())) {
        each.changeValue(parameter, value);
      }
    }
  }

  /**
   * This changes one of the RGB values to a new value if the shape exists.
   *
   * @param name shape to be modified
   * @param color RGB attribute to be modified
   * @param value new value
   */
  public void changeColor(String name, String color, double value) {
    for (IShape each: shapes) {
      if (name.equalsIgnoreCase(each.getName())) {
        if (color.equalsIgnoreCase("red")) {
          each.getColor().setRed(value);
        }
        if (color.equalsIgnoreCase("green")) {
          each.getColor().setGreen(value);
        }
        if (color.equalsIgnoreCase("blue")) {
          each.getColor().setBlue(value);
        }
      }
    }
  }
}
