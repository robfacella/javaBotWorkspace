package Keyboard;

import java.awt.AWTException;

public class KeyClient 
{

	public static void main(String[] args) throws AWTException 
	{
		KeyBot jeff = new KeyBot();
		jeff.antiIdle();
	}

}
