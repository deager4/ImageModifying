package me.deager4.imagemodifying;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * 
 * This class constructs a IMPixel object, that 
 * @author deager4
 * @version 1.0
 * @since 12/10/12
 * 
 */
		
public class IMPixel
{
  private int red;
  private int blue;
  private int green;

  /**
   * The constructor of the IMPixel object
   * @param image The image you want to take the pixel from
   * @param x the x coordinate of the pixel
   * @param y the y coordinate of the pixel
   * @throws NumberFormatException (not really)...
   * @author deager4
   * 
   */
  
  //this is all just really obfuscating the concept, but w/e
  public IMPixel(BufferedImage image, int x, int y)
    throws NumberFormatException
  {
    String intermediary = Integer.toHexString(image.getRGB(x, y));
    intermediary = intermediary.substring(2, 8); //takes the substring that is needed for the color
    Color color = Color.decode("#" + intermediary); //puts the color in the correct format
    this.red = color.getRed(); 
    this.blue = color.getBlue();
    this.green = color.getGreen();
  }

  /**
   * The public getter for the Red value of the IMPixel
   * @return {@link IMPixel#red}
   * @author deager4
   */
  public int getRed()
  {
    return this.red;
  }

  /**
   * The public getter for the Blue value of the IMPixel
   * @return {@link IMPixel#blue}
   * @author deager4
   */
  public int getBlue()
  {
    return this.blue;
  }

  /**
   * The public getter for the Green value of the IMPixel
   * @return {@link IMPixel#green}
   * @author deager4
   */
  public int getGreen()
  {
    return this.green;
  }
  
  public int getGivenValue(String input)
  {
	  if(input.equalsIgnoreCase("red"))
	  {
		  return this.red;
	  }
	  else if(input.equalsIgnoreCase("green"))
	  {
		  return this.green;
	  }
	  else if(input.equalsIgnoreCase("blue"))
	  {
		  return this.blue;
	  }
	  else
	  {
		  System.out.println("internal Error #00001");
		  return 0000000;
	  }
  }
}