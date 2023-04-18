package shapes;

import java.util.Objects;

/**
 * This class represents rectangles.
 */
public class Rectangle implements IShape {
  private double width;
  private double height;
  private Point2D corner;
  private Color color;
  private String name;

  /**
   * Constructs a rectangle shape.
   * @param width width
   * @param height height
   * @param corner Point2D representing min corner of rectangle.
   * @param color desired color
   * @param name name or description
   */
  public Rectangle(double width, double height, Point2D corner, Color color, String name) {
    if (corner == null) {
      throw new IllegalArgumentException("Rectangle must have a starting corner.");
    }
    if (color == null) {
      throw new IllegalArgumentException("Please specify a color.");
    }
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width or height cannot be less than 0.");
    }
    if (name.equals(null) || name.equals("")) {
      throw new IllegalArgumentException("Provide a name/description for the rectangle.");
    }
    this.width = width;
    this.height = height;
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
   * @return color of shape in RGB format (0, 0, 0).
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
    this.height = value;
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
   * String description of the rectangle.
   * @return string of rectangle
   */
  @Override
  public String toString() {
    String name = "Name: " + this.name + "\n";
    String type = "Type: rectangle" + "\n";
    String dimensions = "Min corner: " + this.corner.toString() + ", ";
    String width = "Width: " + String.format("%.1f", this.width) + ", ";
    String height = "Height: " + String.format("%.1f", this.height) + ", ";
    String color = "Color: " + this.color.toString();

    return name + type + dimensions + width + height + color;
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
    Rectangle r = (Rectangle) other; // down casting
    if ((this.width == r.width) && (this.height == r.height)
            && (this.corner == r.corner) && (this.color == r.color)) {
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
    return Objects.hash(this.width, this.height, this.corner, this.color);
  }
}
