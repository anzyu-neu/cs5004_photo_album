package shapes;

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
}
