import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import mvc.controller.PhotoAlbumControllerText;
import mvc.controller.PhotoAlbumMVCControllerVisual;
import mvc.views.PhotoAlbumTextView;
import mvc.views.SwingView;
import photoalbum.PhotoPage;

public class Echo {
  public static void main (String[] args) throws IOException {
    boolean isWeb = false;
    boolean isGraph = false;
    String inputName = "";
    String outputName = "";
    int width = 1000;
    int height = 1000;

    PhotoPage page = PhotoPage.getPage(); // model

    for (int i = 0; i < args.length; i++){ // collect arguments and parse variables
      switch (args[i]) {
        case "-view":
          if (args[i + 1].equalsIgnoreCase("web")) {
            isWeb = true;
          }
          if (args[i + 1].equalsIgnoreCase("grapical")) {
            isGraph = true;
          }
          if (isGraph) {
            width = Integer.parseInt(args[i + 2]);
            height = Integer.parseInt(args[i + 3]);
            i = i + 2;
            break;
          }
          i++;
          break;
        case "-out":
          outputName = args[i + 1];
          i++;
          break;
        case "-in":
          inputName = args[i + 1];
          i++;
          break;
        case "-v":
          if (args[i + 1].equalsIgnoreCase("web")) {
            isWeb = true;
          }
          if (args[i + 1].equalsIgnoreCase("graphical")) {
            isGraph = true;
          }
          if (isGraph) {
            width = Integer.parseInt(args[i + 2]);
            height = Integer.parseInt(args[i + 3]);
            i = i + 2;
            break;
          }
          i++;
          break;

      }
    }

    File file = new File(inputName); // input file with data commands
    if (isGraph) { // graphical view
      SwingView view = new SwingView(outputName, width, height); // graph view

      // graph controller
      PhotoAlbumMVCControllerVisual controller = new PhotoAlbumMVCControllerVisual(page, view, file);
      controller.go();
    }
    if (isWeb) {
      PhotoAlbumTextView textView = new PhotoAlbumTextView(outputName); // text view

      // text controller
      PhotoAlbumControllerText controllerText = new PhotoAlbumControllerText(page, textView, file);
      controllerText.go();
    }

  }
}
