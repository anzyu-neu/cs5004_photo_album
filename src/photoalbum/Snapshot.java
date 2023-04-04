package photoalbum;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.Date;

import shapes.IShape;


public class Snapshot {
  private String snapShotID;
  private Timestamp timeStamp;
  private String description;
  private List<IShape> shapes;

  /**
   * This creates a snapshot instance to be stored in the photo album history.
   * @param description description of snapshot
   * @param shapes shapes on the page
   */
  public Snapshot(String description, List<IShape> shapes) {
    this.timeStamp = new Timestamp(System.currentTimeMillis());
    this.snapShotID = String.format("%.6f", this.timeStamp);
    this.description = description;
    this.shapes = shapes;
  }

  /**
   * Gets the ID of the snapshot.
   * @return snapshot ID
   */
  public String getSnapID() {
    return this.snapShotID;
  }

  /**
   * Gets the time stamp in a string format.
   * @return time stamp
   */
  public String getTimeStamp() {
    String s = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(this.timeStamp);
    return s;
  }

  /**
   * Gets the description of the snapshot.
   * @return description
   */
  public String getDescription() {
    return this.description;
  }


  /**
   * Provides the snapshot history of shapes in a string format.
   * @return string format of shapes.
   */
  public String getShapes() {
    boolean isFirst = true;
    String shapeList = "";
    for (IShape each : this.shapes) {
      if (isFirst) {
        shapeList = shapeList + each.toString();
        isFirst = false;
      }
      else {
        shapeList = "\n" + each.toString();
      }
    }
    return shapeList;
  }
}
