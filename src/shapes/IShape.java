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
}
