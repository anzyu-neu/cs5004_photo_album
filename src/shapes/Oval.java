package shapes;

import java.util.Objects;

/**
 * Represents an oval shape.
 */
public class Oval implements IShape {
  private double xRadius;
  private double yRadius;
  private Point2D center;
  private Color color;
  private String name;

  public Oval(double xLength, double yLength, Point2D center, Color color, String name) {
    if (center == null) {
      throw new IllegalArgumentException("Oval must have a center.");
    }
    if (color == null) {
      throw new IllegalArgumentException("Please specify a color.");
    }
    if (xLength <= 0 || yLength <= 0) {
      throw new IllegalArgumentException("X or Y radius cannot be less than 0.");
    }
    if (name.equals(null) || name.equals("")) {
      throw new IllegalArgumentException("Provide a name/description for the rectangle.");
    }
    this.xRadius = xLength;
    this.yRadius = yLength;
    this.center = center;
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
    return this.center;
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
   *
   * @param parameter to be modified
   * @param value     new value
   */
  @Override
  public void changeValue(String parameter, double value) {
    if (parameter.equals("") || parameter.equals(null)) {
      return;
    }
    if (parameter.equalsIgnoreCase("xradius")) {
      this.xRadius = value;
    }
    if (parameter.equalsIgnoreCase("yradius")) {
      this.yRadius = value;
    }
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
    this.center = point;
  }

  /**
   * String description of the oval.
   * @return string of oval
   */
  @Override
  public String toString() {
    String name = "Name: " + this.name + "\n";
    String type = "Type: oval" + "\n";
    String dimensions = "Center: " + this.center.toString() + ", ";
    String xRadius = "X radius: " + String.format("%.1f", this.xRadius) + ", ";
    String yRadius = "Y radius: " + String.format("%.1f", this.yRadius) + ", ";
    String color = "Color: " + this.color.toString();

    return name + type + dimensions + xRadius + yRadius + color;
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
    Oval o = (Oval) other; // down casting
    if ((this.xRadius == o.xRadius) && (this.yRadius == o.yRadius)
            && (this.center == o.center) && (this.color == o.color)) {
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
    return Objects.hash(this.xRadius, this.yRadius, this.center, this.color);
  }
}
