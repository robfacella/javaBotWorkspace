package Core;
//RSBot // Core // Mouse
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Random;


public class Mouse extends Robot
{
	private int mouseX;
	private int mouseY;
	
	//default constructor
	public Mouse() throws AWTException 
	{
		super();		
	}
	
	public void test ()
	{
		pause(7);
		
		antiIdle();

	}
	
	public void antiIdle()
	{
		getMouseCoordinates();
		moveTo((mouseX+1), (mouseY+1));
		//lClick();
		pause(5);
		getMouseCoordinates();
		moveTo((mouseX-1), (mouseY-1));
		//lClick();
		antiIdle();
	}
	
	public void pause(double seconds)
	{
		//convert milliseconds to seconds
		int time = (int)(seconds * 1000);
		//delay from Robot class operates in milliseconds
		delay(time);
	}
	public void lClick() //right click
	{
		mousePress(InputEvent.BUTTON1_DOWN_MASK);
		mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	public void rClick()
	{
		mousePress(InputEvent.BUTTON3_DOWN_MASK);
		mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
	}
	
	public void wheelClick()
	{
		mousePress(InputEvent.BUTTON2_DOWN_MASK);
		mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
	}
	public void lDrag(double timeSecs)
	{
		mousePress(InputEvent.BUTTON1_DOWN_MASK);
		pause(timeSecs);
		mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	public void rDrag(double timeSecs)
	{
		mousePress(InputEvent.BUTTON3_DOWN_MASK);
		pause(timeSecs);
		mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
	}
	
	public void moveTo(int x, int y)
	{
		mouseMove(x, y);
	}
	public void mouseTo(int x, int y)
	{
		getMouseCoordinates();
		
		if  ((x == mouseX) && (y == mouseY))
		{
			//ur already there and this method will end
		}
		else
		{
			if (binaryRandom() == 0)
			{
				if (x != mouseX)
					slideTowardX(x);
				if (y != mouseY)
					slideTowardY(y);
			}
			else
			{
				if (y != mouseY)
					slideTowardY(y);
				if (x != mouseX)
					slideTowardX(x);

			}
			mouseTo(x, y);
		}
	}
	
	public void slideTowardX(int x)
	{
		
		if (mouseX < x)
		{
			mouseX++;
			mouseMove(mouseX, mouseY);
		}
		else if (mouseX > x)
		{
			mouseX--;
			mouseMove(mouseX, mouseY);
		}
		//getMouseCoordinates();
	}
	
	public void slideTowardY(int y)
	{
		if (mouseY < y)
		{
			mouseY++;
			mouseMove(mouseX, mouseY);
		}
		else if (mouseY > y)
		{
			mouseY--;
			mouseMove(mouseX, mouseY);
		}
		//getMouseCoordinates();
	}
	
//////The Realistic(ish) mouse moving methods/////////////////////////////////////////////
	public void moveMouse(int x, int y, int maxOffset)
	{
		mouseTo(x + allowRandom(maxOffset), y + allowRandom(maxOffset));
	}
	public void moveMouse(int x, int y, int maxOffsetX, int maxOffsetY)
	{
		mouseTo(x + allowRandom(maxOffsetX), y + allowRandom(maxOffsetY));
	}
/////////////////////////////////////////////////////////////////////////////////////////	
	
	public void getMouseCoordinates()
	{
		Point a = (MouseInfo.getPointerInfo()).getLocation();
		mouseX = (int) a.getX();
		mouseY = (int) a.getY();
		
		System.out.println("X:  " + mouseX + "\nY:  " + mouseY + "\n");
	}
	
	
	public int allowRandom(int degree)
	{
		//degree as sent is the maximum degree by which a value should be offset from the center-point
		Random x = new Random();
		
		int sign = x.nextInt(2);
		//sign is 0 or 1, if 0 make degree negative if 1 keep it positive
		
		degree = x.nextInt(degree+1);
		//the offset is calculated between zero (inclusive) and the value of degree (exclusive) so one is added to make it include degree
		
		if (sign == 0)
			return (degree * -1);
		else
			return degree;
	}
	public int binaryRandom()
	{
		Random x = new Random();
		//returns 0 or 1
		return x.nextInt(2);
	}
}
