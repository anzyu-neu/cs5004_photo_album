package photoalbum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import shapes.Color;
import shapes.IShape;
import shapes.Point2D;

import static org.junit.Assert.*;

/**
 * JUnit testing for the photo page.
 */
public class PhotoPageTest {

  private IShape shape1;
  private IShape shape2;
  private IShape shape3;
  private Point2D p1;
  private PhotoPage page1;
  private PhotoPage page2;


  /**
   * This prepares 2 pages in the photo album for testing.
   */
  @Before
  public void setUp() {
    page1 = PhotoPage.getPage();
    page2 = PhotoPage.getPage();
  }

  /**
   * Creates a shape that has 2 parameters on the page.
   */
  @Test
  public void create2ParameterShape() {
    this.shape1 = page1.create2ParameterShape("rectangle", 25, 100, new Point2D(100, 300),
            new Color(1, 0, 0), " red rectangle");
    page1.addShape(this.shape1);
    String rectangle = "Name: red rectangle\n" +
            "Type: rectangle\n" +
            "Min corner: (100.0,300.0), Width: 25.0, Height: 100.0, Color: (1.0,0.0,0.0)";
    assertEquals(rectangle, this.page1.toString());

    this.shape2 = page1.create2ParameterShape("oVaL", 60, 30,
            new Point2D(500, 100), new Color(0, 0, 1), "blue oval");
    page1.addShape(this.shape2);

    String oval = "\nName: blue oval\n" +
            "Type: oval\n" +
            "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (0.0,0.0,1.0)";

    assertEquals(rectangle + oval, this.page1.toString());
    this.shape3 = page1.create2ParameterShape("ellipse", 50, 20,
            new Point2D(100, 200), new Color(0, 1, 0), "ellipse");
    assertNull(this.shape3); // unable to create shape that does not exist
  }

  /**
   * Testing illegal arguments for creating 2 parameter shapes.
   */
  @Test (expected = IllegalArgumentException.class)
  public void illegal2ParamArgument() {
    this.shape3 = page1.create2ParameterShape("", 10, 20,
            new Point2D(10, 20), new Color(1, 1, 1), "rec"); // empty type

    this.shape3 = page1.create2ParameterShape(null, 10, 20,
            new Point2D(10, 20), new Color(1, 1, 1), "rec"); // null type

    this.shape3 = page1.create2ParameterShape("rectangle", 10, 20,
            null, new Color(1, 1, 1), "rec"); // null point

    this.shape3 = page1.create2ParameterShape("", 10, 20,
            new Point2D(10, 20), null, "rec"); // null color

    this.shape3 = page1.create2ParameterShape("", 10, 20,
            new Point2D(10, 20), new Color(1, 1, 1), ""); // empty name

    this.shape3 = page1.create2ParameterShape("", 10, 20,
            new Point2D(10, 20), new Color(1, 1, 1), null); // null name
  }

  /**
   * Tests creating and adding 1 parameter shapes to the page.
   */
  @Test
  public void create1ParameterShape() {
    this.shape3 = page2.create1ParameterShape("circle", 50,
            new Point2D(200, 100), new Color(1, 0, 0), "red circle");

    String circle = "Name: red circle\n" +
            "Type: circle\n" +
            "Center: (200.0,100.0), Radius: 50.0, Color: (1.0,0.0,0.0)";
    page2.addShape(this.shape3);
    assertEquals(circle, this.page2.toString());

    this.shape3 = page2.create1ParameterShape("equilateral triangle", 100,
            new Point2D(500, 500), new Color(0, 0, 0), "triangle");
    assertNull(this.shape3);
  }

  /**
   * Tests proper return of a list of all shapes on the page.
   */
  @Test
  public void getShapes() {
    this.shape1 = page1.create2ParameterShape("rectangle", 25, 100,
            new Point2D(100, 300),
            new Color(1, 0, 0), " red rectangle");
    page1.addShape(this.shape1);

    this.shape2 = page1.create2ParameterShape("oVaL", 60, 30,
            new Point2D(500, 100), new Color(0, 0, 1), "blue oval");
    page1.addShape(this.shape2);

    assertEquals(2, page1.getShapes().size());

    this.shape3 = page1.create1ParameterShape("sQuARE", 100, new Point2D(500, 500),
            new Color(1, 1, 1), "s");
    page1.addShape(this.shape3);
    assertEquals(3, page1.getShapes().size());
  }

  /**
   * Tests removing shapes from the page.
   */
  @Test
  public void removeShape() {
    this.shape1 = page1.create2ParameterShape("rectangle", 25, 100,
            new Point2D(100, 300),
            new Color(1, 0, 0), " red rectangle");
    page1.addShape(this.shape1);

    this.shape2 = page1.create2ParameterShape("oVaL", 60, 30,
            new Point2D(500, 100), new Color(0, 0, 1), "blue oval");
    page1.addShape(this.shape2);

    assertEquals(2, page1.getShapes().size()); // 2

    this.shape3 = page1.create1ParameterShape("sQuARE", 100, new Point2D(500, 500),
            new Color(1, 1, 1), "s");
    page1.addShape(this.shape3);
    assertEquals(3, page1.getShapes().size()); //3

    page1.removeShape(this.shape1);
    assertEquals(2, page1.getShapes().size()); //2

    page1.removeShape(this.shape2);
    assertEquals(1, page1.getShapes().size()); //1
  }

  /**
   * Tests changing size of the shape on the page.
   */
  @Test
  public void changeSize() {
    this.shape1 = page1.create2ParameterShape("rectangle", 25, 100,
            new Point2D(100, 300),
            new Color(1, 0, 0), "red rectangle");
    page1.addShape(this.shape1);

    this.shape3 = page1.create1ParameterShape("sQuARE", 100, new Point2D(500, 500),
            new Color(1, 1, 1), "s");
    page1.addShape(this.shape3);
    assertEquals(2, page1.getShapes().size());

    page1.changeSize("s", 200, 100);
    String newSquare = "Name: s\n" +
            "Type: square\n" +
            "Min corner: (500.0,500.0), Width: 200.0, Color: (1.0,1.0,1.0)";
    assertEquals(newSquare, page1.getShapes().get(0).toString());

    page1.changeSize("red rectangle", 125, 0);
    String newRec = "Name: red rectangle\n" +
            "Type: rectangle\n" +
            "Min corner: (100.0,300.0), Width: 125.0, Height: 100.0, Color: (1.0,0.0,0.0)";
    assertEquals(newRec, page1.getShapes().get(1).toString());

  }

  /**
   * Tests changing the color of various shapes on the page.
   */
  @Test
  public void changeColor() {
    this.shape1 = page1.create2ParameterShape("rectangle", 25, 100,
            new Point2D(100, 300),
            new Color(1, 0, 0), "red rectangle");
    page1.addShape(this.shape1);

    this.shape3 = page1.create1ParameterShape("sQuARE", 100, new Point2D(500, 500),
            new Color(1, 1, 1), "s");
    page1.addShape(this.shape3);
    assertEquals(2, page1.getShapes().size());

    page1.changeColor("red rectangle", "red", 0);
    page1.changeColor("red rectangle", "green", 1);

    assertEquals("(0.0,1.0,0.0)", page1.getShapes().get(1).getColor().toString());
  }

  /**
   * Tests changing the name of a shape if it exists.
   */
  @Test
  public void testChangeName() {
    this.shape1 = page1.create2ParameterShape("rectangle", 25, 100,
            new Point2D(100, 300),
            new Color(1, 0, 0), "red rectangle");
    page1.addShape(this.shape1);

    this.shape3 = page1.create1ParameterShape("sQuARE", 100, new Point2D(500, 500),
            new Color(1, 1, 1), "s");
    page1.addShape(this.shape3);
    assertEquals(2, page1.getShapes().size());

    page1.changeColor("red rectangle", "red", 0);
    page1.changeColor("red rectangle", "green", 1);

    page1.changeName("red rectangle", "green rectangle");
    assertEquals("green rectangle", page1.getShapes().get(1).getName());
  }

  /**
   * Tests moving the shapes on the page.
   */
  @Test
  public void testMoveShape() {
    this.shape1 = page1.create2ParameterShape("rectangle", 25, 100,
            new Point2D(100, 300),
            new Color(1, 0, 0), "red rectangle");
    page1.addShape(this.shape1);

    page1.moveShape("red rectangle", new Point2D(200, 500));
    assertEquals("(200.0,500.0)", page1.getShapes().get(0).getLocation().toString());
  }

  /**
   * Tests proper storage and output of snapshots.
   */
  @Test
  public void testSnapShot() {
    this.shape1 = page1.create2ParameterShape("rectangle", 50, 100,
            new Point2D(200, 200), new Color(1, 0, 0), "R");
    this.shape2 = page1.create2ParameterShape("OVAL", 60, 30,
            new Point2D(500, 100), new Color (0, 0, 1), "O");
    page1.addShape(this.shape1);
    page1.addShape(this.shape2);

    assertEquals(2, page1.getShapes().size());

    String s1 = "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)\n" +
            "\n" +
            "Name: O\n" +
            "Type: oval\n" +
            "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (0.0,0.0,1.0)";

    assertEquals(s1, page1.toString());

    String s2 = "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (100.0,300.0), Width: 25.0, Height: 100.0, Color: (0.0,1.0,0.0)\n" +
            "\n" +
            "Name: O\n" +
            "Type: oval\n" +
            "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (0.0,0.0,1.0)";
    page1.changeSize("r", 25, 0);
    page1.changeColor("r", "red", 0);
    page1.changeColor("r", "green", 1);
    page1.moveShape("r", new Point2D(100, 300));

    assertEquals(s2, page1.toString());

    System.out.println(page1.getSnapShots().size() + "\n");
    System.out.println(page1.printSnapShot());
  }
}