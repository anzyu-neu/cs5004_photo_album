package shapes;

import java.util.Objects;

/**
 * Represents a square.
 */
public class Square implements IShape {
  private double width;
  private Point2D corner;
  private Color color;
  private String name;

  public Square(double width, Point2D corner, Color color, String name) {
    if (corner == null) {
      throw new IllegalArgumentException("Square must have a starting corner.");
    }
    if (color == null) {
      throw new IllegalArgumentException("Please specify a color.");
    }
    if (width <= 0) {
      throw new IllegalArgumentException("Width cannot be less than 0.");
    }
    if (name.equals(null) || name.equals("")) {
      throw new IllegalArgumentException("Provide a name/description for the rectangle.");
    }
    this.width = width;
    this.corner = corner;
    this.color = color;
    this.name = name;
  }

  /**
   * Gets the name or description assigned to the shape.
   *
   * @return name
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Get the set location point of the shape.
   *
   * @return Point2D location
   */
  @Override
  public Point2D getLocation() {
    return this.corner;
  }

  /**
   * Gets the assigned color for the shape.
   *
   * @return color of shape.
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * Changes the specified parameter to the new parameter.
   * @param value first dimension
   * @param value2 second dimension
   */
  @Override
  public void changeValue(double value, double value2) {
    this.width = value;
  }

  /**
   * Changes the original name/description to a new one.
   *
   * @param name1   original name/description
   * @param newName new name/description
   */
  @Override
  public void changeName(String name1, String newName) {
    if (newName.equals("") || newName.equals(null)) {
      return;
    }
    if (name1.equalsIgnoreCase(this.name)) {
      this.name = newName;
    }
  }

  /**
   * Moves the shape to a new point.
   *
   * @param point new location
   */
  @Override
  public void moveShape(Point2D point) {
    if (point == null) {
      return;
    }
    this.corner = point;

  }

  /**
   * Gets the first parameter for the shape.
   * @return width/x-radius/base for rectangles/ovals/triangles
   */
  @Override
  public double getParam1() {
    return this.width;
  }

  /**
   * Gets the second parameter for the shape.
   * @return height/y-radius/height for rectangles/ovals/triangles
   */
  @Override
  public double getParam2() {
    return 0;
  }

  /**
   * Changes the color of the shape.
   * @param color new color
   */
  @Override
  public void changeColor(Color color) {
    this.color = color;
  }

  /**
   * String description of the square.
   * @return string of square
   */
  @Override
  public String toString() {
    String name = "Name: " + this.name + "\n";
    String type = "Type: square" + "\n";
    String dimensions = "Min corner: " + this.corner.toString() + ", ";
    String width = "Width: " + String.format("%.1f", this.width) + ", ";
    String color = "Color: " + this.color.toString();

    return name + type + dimensions + width + color;
  }

  /**
   * This determines whether another object is equal to this shape.
   * @param other object
   * @return boolean if objects are equal
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) { // identity check
      return true;
    }
    if (this.getClass() != other.getClass()) {
      return false;
    }
    Square s = (Square) other; // down casting
    if ((this.width == s.width) && (this.corner == s.corner) && (this.color == s.color)) {
      return true;
    }
    return false;
  }

  /**
   * hashcode override given override equals method.
   * @return hashcode for object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.width, this.corner, this.color);
  }
}
