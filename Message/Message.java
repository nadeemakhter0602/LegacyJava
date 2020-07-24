import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
public class Message
{
  public static void main(String[] args) throws AWTException,IOException
  {
    Robot robot = new Robot();
    File ob = new File("Message.txt");
    ob.createNewFile();
    java.awt.Desktop.getDesktop().open(ob);
    robot.delay(2000);
    type("Type Your Message Here");
  }
  private static void type(String s) throws AWTException,IOException
  {
    Robot robot = new Robot();
    byte[] bytes = s.getBytes();
    for (byte b : bytes)
    {
      int code = b;
      if (code > 96 && code < 123) code = code - 32;
      else if (code > 64 && code < 91) robot.keyPress(KeyEvent.VK_SHIFT);
      robot.delay(500);
      robot.keyPress(code);
      robot.keyRelease(code);
      if (code > 64 && code < 91) robot.keyRelease(KeyEvent.VK_SHIFT);
    }
  }
}
