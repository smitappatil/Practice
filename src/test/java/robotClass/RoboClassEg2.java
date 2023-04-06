package robotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RoboClassEg2 {

	public static void main(String[] args) throws AWTException {

		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_8);
		robot.keyRelease(KeyEvent.VK_8);
		
		
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_COLON);
		robot.keyRelease(KeyEvent.VK_COLON);
		robot.keyRelease(KeyEvent.VK_SHIFT);

	}

}
