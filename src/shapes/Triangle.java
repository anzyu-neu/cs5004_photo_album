package shapes;

/**
 * Represents a triangle (right).
 */
public class Triangle implements IShape {
  private double base;
  private double height;
  private Point2D corner;
  private Color color;
  private String name;

  public Triangle(double base, double height, Point2D corner, Color color, String name) {
    if (corner == null) {
      throw new IllegalArgumentException("Triangle must have a starting corner.");
    }
    if (color == null) {
      throw new IllegalArgumentException("Please specify a color.");
    }
    if (base <= 0 || height <= 0) {
      throw new IllegalArgumentException("Base or height cannot be less than 0.");
    }
    if (name.equals(null) || name.equals("")) {
      throw new IllegalArgumentException("Provide a name/description for the rectangle.");
    }
    this.base = base;
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
   * @return color of shape.
   */
  @Override
  public Color getColor() {
    return this.color;
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
    String width = "Base: " + String.format("%.1f", this.base) + ", ";
    String height = "Height: " + String.format("%.1f", this.height) + ", ";
    String color = "Color: " + this.color.toString();

    return name + type + dimensions + width + height + color;
  }
}
