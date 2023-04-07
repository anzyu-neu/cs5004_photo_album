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
   * Changes the specified parameter to the new parameter.
   * @param parameter to be modified
   * @param value new value
   */
  void changeValue(String parameter, double value);

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
