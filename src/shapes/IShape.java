package shapes;

/**
 * This class represents the interface for shapes.
 */
public interface IShape {

  /**
   * Gets the name or description assigned to the shape.
   * @return name
   */
  String getName();

  /**
   * Get the set location point of the shape.
   * @return Point2D location
   */
  Point2D getLocation();

  /**
   * Gets the assigned color for the shape.
   * @return color of shape.
   */
  Color getColor();

  /**
   * Changes the parameters for 2 parameter shapes
   * @param value1 first dimension
   * @param value2 second dimension
   */
  void changeValue(double value1, double value2);

  /**
   * Changes the original name/description to a new one.
   * @param name1 original name/description
   * @param newName new name/description
   */
  void changeName(String name1, String newName);

  /**
   * Moves the shape to a new point.
   * @param point new location
   */
  void moveShape(Point2D point);
}
