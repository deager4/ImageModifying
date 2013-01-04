package me.deager4.imagemodifying;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class IMPixel
{
  private int red;
  private int blue;
  private int green;

  public IMPixel(BufferedImage image, int x, int y)
    throws NumberFormatException
  {
    String intermediary = Integer.toHexString(image.getRGB(x, y));
    intermediary = intermediary.substring(2, 8);
    Color color = Color.decode("#" + intermediary);
    this.red = color.getRed();
    this.blue = color.getBlue();
    this.green = color.getGreen();
  }

  public int getRed()
  {
    return this.red;
  }

  public int getBlue()
  {
    return this.blue;
  }

  public int getGreen()
  {
    return this.green;
  }
}