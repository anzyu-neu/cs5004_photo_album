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
  private Circle circle;
  private Triangle triangle;
  private Point2D p1;

  /**
   * Prepares instances for testing.
   */
  @Before
  public void setUp() {
    this.p1 = new Point2D(0, 0);
    this.rectangle = new Rectangle(10, 20, this.p1,
            new Color(0, 0, 0), "r");
    this.oval = new Oval(100, 200, this.p1, new Color(1, 1, 1), "o");
    this.square = new Square(15, this.p1, new Color(2, 2, 2), "s");
    this.circle = new Circle(2, this.p1, new Color(3, 3, 3), "c");
    this.triangle = new Triangle(10, 5, this.p1, new Color(4, 4, 4), "t");
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
