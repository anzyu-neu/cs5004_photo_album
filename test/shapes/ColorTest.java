package shapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for color class.
 */
public class ColorTest {
  private Color color;

  /**
   * Prepares color instance for testing.
   */
  @Before
  public void setUp() {
    this.color = new Color(1.0, 0, 2);
  }

  /**
   * Tests getting the individual components of the color.
   */
  @Test
  public void testGetters() {
    assertEquals(1.0, this.color.getRed(), 0.001);
    assertEquals(0.0, this.color.getGreen(), 0.001);
    assertEquals(2.0, this.color.getBlue(), 0.001);
  }

  /**
   * Tests setting new values for the color.
   */
  @Test
  public void testSetters() {
    this.color.setRed(2);
    this.color.setGreen(3);
    this.color.setBlue(4);
    assertEquals(2.0, this.color.getRed(), 0.001);
    assertEquals(3.0, this.color.getGreen(), 0.001);
    assertEquals(4.0, this.color.getBlue(), 0.001);
  }

  /**
   * Tests proper string representation of the color.
   */
  @Test
  public void testToString() {
    String color = "(1.0,0.0,2.0)";
    assertEquals(color, this.color.toString());
  }

}