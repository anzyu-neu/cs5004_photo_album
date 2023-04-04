package shapes;

/**
 * This class represents colors in the RGB format.
 */
public class Color {
  private double red;
  private double green;
  private double blue;

  /**
   * This constructs the color in the RGB format.
   * @param r red value
   * @param g green value
   * @param b blue value
   */
  public Color(double r, double g, double b) {
    this.red = r;
    this.green = g;
    this.blue = b;
  }

  /**
   * Gets the red value of the color.
   * @return red value
   */
  public double getRed() {
    return this.red;
  }

  /**
   * Gets the green value of the color.
   * @return green value
   */
  public double getGreen() {
    return this.green;
  }

  /**
   * Gets the blue value of the color.
   * @return blue value
   */
  public double getBlue() {
    return this.blue;
  }

  /**
   * Sets a new red value.
   * @param value red value
   */
  public void setRed(double value) {
    this.red = value;
  }

  /**
   * Sets a new green value.
   * @param value green value
   */
  public void setGreen(double value) {
    this.green = value;
  }

  /**
   * Sets a new blue value.
   * @param value blue value
   */
  public void setBlue(double value) {
    this.blue = value;
  }

  /**
   * Provides the RGB color as a string.
   * @return RGB color as string.
   */
  @Override
  public String toString() {
    String red = String.format("%.1f", this.red);
    String green = String.format("%.1f", this.green);
    String blue = String.format("%.1f", this.blue);
    return "(" + red + "," + green + "," + blue + ")";
  }
}
