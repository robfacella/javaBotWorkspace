
package CookieClicker;

import java.awt.AWTException;

public class Cookie extends Mouse
{
	public Cookie() throws AWTException 
	{
		super();
	}
	public void infiClick()
	{
		lClick();
		if (allowRandom(2) > 0)
			delay(10);
		else
			delay(25);
		infiClick();
	}
	public void xClick(int x)
	{
		for (int i = 0; i < x; i++)
			lClick();
	}
}
