package Core;

import java.awt.AWTException;

public class RSMouse extends Mouse
{

	public RSMouse() throws AWTException 
	{
		super();
		pause(5);
		//getMouseCoordinates();
		
	}
	
	
	public void moveMouse(int x, int y, int maxOffset)
	{
		mouseTo(x + allowRandom(maxOffset), y + allowRandom(maxOffset));
	}
	public void moveMouse(int x, int y, int maxOffsetX, int maxOffsetY)
	{
		mouseTo(x + allowRandom(maxOffsetX), y + allowRandom(maxOffsetY));
	}
	
	
	public void backPack()
	{
		moveMouse(974, 374, 5);
	}
	public void homeTele()
	{
		//X:  1049
		//Y:  148
	}
	public void equipment()
	{
		//X:  1007
		//Y:  371
	}
	public void login()
	{
		//userbox
		//X:  723
		//Y:  404
		
		//passbox
		//X:  739
		//Y:  479
		
		//loginbutton
		//X:  739
		//Y:  479
	}
}
