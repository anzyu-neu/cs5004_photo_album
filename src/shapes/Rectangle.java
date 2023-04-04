package shapes;

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
}
