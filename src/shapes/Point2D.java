package shapes;

/**
 * This class represents a point in 2D space.
 * Each point represents the specified starting location for the desired shape.
 */
public class Point2D {
  private double x;
  private double y;

  /**
   * Constructs our 2D point.
   * @param x value on cartesian plane.
   * @param y value on cartesian plane.
   */
  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Returns the x coordinate of the point.
   * @return x coordinate
   */
  public double getX() {
    return this.x;
  }

  /**
   * Returns the y coordinate of the point.
   * @return y coordinate
   */
  public double getY() {
    return this.y;
  }

  /**
   * Sets the x coordinate to a new value.
   * @param value desired coordinate
   */
  public void setX(double value) {
    this.x = value;
  }

  /**
   * Sets the y coordinate to a new value.
   * @param value desired coordinate
   */
  public void setY(double value) {
    this.y = value;
  }

  /**
   * String representation of the point.
   * @return Point2D as string
   */
  @Override
  public String toString() {
    String x = String.format("%.1f", this.x);
    String y = String.format("%.1f", this.y);
    return "(" + x + "," + y + ")";
  }
}
