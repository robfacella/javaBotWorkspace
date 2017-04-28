import java.awt.AWTException;

import CookieClicker.Cookie;
/**
 * 1/14/15
 */

/**
 * @author Rob
 *
 */
public class Client {

	/**
	 * @param args
	 * @throws AWTException 
	 */
	public static void main(String[] args) throws AWTException 
	{
		Cookie cat = new Cookie();
		cat.pause(7.0);
		cat.antiIdle();

	}

}
