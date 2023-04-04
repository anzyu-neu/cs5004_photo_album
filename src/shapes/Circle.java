package shapes;

/**
 * Represents a circle.
 */
public class Circle implements IShape {
  private double radius;
  private Point2D center;
  private Color color;
  private String name;

  /**
   * Creates a circle instance.
   * @param r radius
   * @param center center of circle
   * @param color color
   * @param name name/description
   */
  public Circle(double r, Point2D center, Color color, String name) {
    if (center == null) {
      throw new IllegalArgumentException("Circle must have a center.");
    }
    if (color == null) {
      throw new IllegalArgumentException("Please specify a color.");
    }
    if (r <= 0) {
      throw new IllegalArgumentException("Radius cannot be less than 0.");
    }
    if (name.equals(null) || name.equals("")) {
      throw new IllegalArgumentException("Provide a name/description for the rectangle.");
    }
    this.radius = r;
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
   * String description of the circle.
   * @return string of circle
   */
  @Override
  public String toString() {
    String name = "Name: " + this.name + "\n";
    String type = "Type: circle" + "\n";
    String dimensions = "Center: " + this.center.toString() + ", ";
    String width = "Radius: " + String.format("%.1f", this.radius) + ", ";
    String color = "Color: " + this.color.toString();

    return name + type + dimensions + width + color;
  }
}
