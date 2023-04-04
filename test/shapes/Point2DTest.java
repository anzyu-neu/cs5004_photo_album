package shapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

/**
 * JUnit testing for the Point2D class.
 */
public class Point2DTest {

  private Point2D p1;

  /**
   * Prepares point instances for testing.
   */
  @Before
  public void setUp() {
    this.p1 = new Point2D(200, 200);
  }

  /**
   * Tests proper acquirement of x coordinate.
   */
  @org.junit.Test
  public void getX() {
    assertEquals(200, this.p1.getX(), 0.001);
  }

  /**
   * Tests proper acquirement of y coordinate.
   */
  @org.junit.Test
  public void getY() {
    assertEquals(200, this.p1.getY(), 0.001);
  }

  /**
   * Tests proper setting of new x coordinate.
   */
  @org.junit.Test
  public void setX() {
    this.p1.setX(500);
    assertEquals(500, this.p1.getX(), 0.001);
  }

  /**
   * Tests proper setting of new y coordinate.
   */
  @org.junit.Test
  public void setY() {
    this.p1.setY(100);
    assertEquals(100, this.p1.getY(), 0.001);
  }

  /**
   * Tests proper string representation of the point.
   */
  @org.junit.Test
  public void testToString() {
    String point = "(500.0,100.0)";
  }
}