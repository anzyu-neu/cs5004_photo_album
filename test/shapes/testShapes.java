package shapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for shapes.
 */
public class testShapes {
  private Rectangle rectangle;
  private Oval oval;
  private Square square;
  private Point2D p1;
  private Point2D p2;
  private Point2D p3;


  /**
   * Prepares instances for testing.
   */
  @Before
  public void setUp() {
    this.p1 = new Point2D(0, 0);
    this.p2 = new Point2D(1, 1);
    this.p3 = new Point2D(2, 3);
    this.rectangle = new Rectangle(10, 20, this.p1,
            new Color(0, 0, 0), "r");
  }

  /**
   * Tests rectangle creation and methods.
   */
  @Test
  public void testRectangle() {
    assertEquals("r", this.rectangle.getName());
    assertEquals(this.p1, this.rectangle.getLocation());
    Color color = new Color(0, 0, 0);
    assertEquals("(0.0,0.0,0.0)", this.rectangle.getColor().toString());
    String r = "Name: r\n" +
            "Type: rectangle\n" +
            "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (0.0,0.0,0.0)";
    assertEquals(r, this.rectangle.toString());
  }
}
