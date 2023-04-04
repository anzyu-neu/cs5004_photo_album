package shapes;

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
}
