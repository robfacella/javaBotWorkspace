import java.awt.AWTException;

import Mining.Clay;

public class Client {

	public static void main(String[] args) throws AWTException 
	{
		Clay jad = new Clay();

		jad.mouseTo(100, 100);
		jad.mouseTo(1000, 200);
		jad.mouseTo(1000, 700);
		jad.mouseTo(100, 600);
		jad.antiIdle();
		
		
	}

}
