package me.deager4.imagemodifying;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * 
 * @author deager4
 * @since 01/04/13
 * @version 0.1.0 Beta
 */
public class image extends JPanel
{
  public static BufferedImage image;
  public static BufferedImage image2;
  Dimension size = new Dimension();

  public static void main(String[] args) throws IOException, NumberFormatException
  {
    Scanner input = new Scanner(System.in);
    System.out.println("please enter the filepath of the image:");
    String path = input.nextLine();
    image = ImageIO.read(new File(path));
    displayImage();

    boolean gotItWrong = true;
    while (gotItWrong)
    {
      Scanner choice1 = new Scanner(System.in);
      System.out.println("Commands:");
      System.out.println("Smooth");
      System.out.println("Sharpen");
      System.out.println("Contrast");
      System.out.println("Lighten");
      System.out.println("Darken");
      System.out.println("Noise Reduce");
      String choice = "";
      choice = choice1.nextLine();
      if ((!choice.equalsIgnoreCase("smooth")) && (!choice.equalsIgnoreCase("contrast")) && (!choice.equalsIgnoreCase("Lighten")) && (!choice.equalsIgnoreCase("Darken")) && (!choice.equalsIgnoreCase("sharpen")) && (!choice.equalsIgnoreCase("noise reduce")))
      {
        gotItWrong = true;
      }
      else if (choice.equalsIgnoreCase("smooth"))
      {
        boolean ok = true;
        long iterations = 0L;
        while (ok)
        {
          Scanner inputer = new Scanner(System.in);
          System.out.println("Please enter the number of times you wish to smooth the image:");
          if (!inputer.hasNextLong())
          {
            System.out.println("please enter a number!");
          }
          else
          {
            iterations = inputer.nextLong();
            ok = false;
          }
        }
        for (int counter = 0; counter < iterations; counter++)
        {
          image2 = image;
          for (int con = 1; con < image.getHeight(); con++)
          {
            for (int count = 1; count < image.getWidth(); count++)
            {
              if (con == 0)
              {
                if (count == 0)
                {
                  IMPixel mainPixel = new IMPixel(image2, count, con);
                  IMPixel rightPixel = new IMPixel(image2, count + 1, con);
                  IMPixel lowerPixel = new IMPixel(image2, count, con + 1);
                  int combinedRed = (mainPixel.getRed() + rightPixel.getRed() + lowerPixel.getRed()) / 3;
                  int combinedGreen = (mainPixel.getGreen() + rightPixel.getGreen() + lowerPixel.getGreen()) / 3;
                  int combinedBlue = (mainPixel.getBlue() + rightPixel.getBlue() + lowerPixel.getBlue()) / 3;
                  Color newColor = new Color(combinedRed, combinedGreen, combinedBlue);
                  image.setRGB(count, con, newColor.getRGB());
                }
                else if (count == image2.getWidth() - 1)
                {
                  IMPixel mainPixel = new IMPixel(image2, count, con);
                  IMPixel leftPixel = new IMPixel(image2, count - 1, con);
                  IMPixel lowerPixel = new IMPixel(image2, count, con + 1);
                  int combinedRed = (mainPixel.getRed() + leftPixel.getRed() + lowerPixel.getRed()) / 3;
                  int combinedGreen = (mainPixel.getGreen() + leftPixel.getGreen() + lowerPixel.getGreen()) / 3;
                  int combinedBlue = (mainPixel.getBlue() + leftPixel.getBlue() + lowerPixel.getBlue()) / 3;
                  Color newColor = new Color(combinedRed, combinedGreen, combinedBlue);
                  image.setRGB(count, con, newColor.getRGB());
                }
                else
                {
                  IMPixel mainPixel = new IMPixel(image2, count, con);
                  IMPixel leftPixel = new IMPixel(image2, count - 1, con);
                  IMPixel rightPixel = new IMPixel(image2, count + 1, con);
                  IMPixel lowerPixel = new IMPixel(image2, count, con + 1);
                  int combinedRed = (mainPixel.getRed() + leftPixel.getRed() + rightPixel.getRed() + lowerPixel.getRed()) / 4;
                  int combinedGreen = (mainPixel.getGreen() + leftPixel.getGreen() + rightPixel.getGreen() + lowerPixel.getGreen()) / 4;
                  int combinedBlue = (mainPixel.getBlue() + leftPixel.getBlue() + rightPixel.getBlue() + lowerPixel.getBlue()) / 4;
                  Color newColor = new Color(combinedRed, combinedGreen, combinedBlue);
                  image.setRGB(count, con, newColor.getRGB());
                }
              }
              else if (con == image2.getHeight() - 1)
              {
                if (count == 0)
                {
                  IMPixel mainPixel = new IMPixel(image2, count, con);
                  IMPixel rightPixel = new IMPixel(image2, count + 1, con);
                  IMPixel upperPixel = new IMPixel(image2, count, con - 1);
                  int combinedRed = (mainPixel.getRed() + rightPixel.getRed() + upperPixel.getRed()) / 3;
                  int combinedGreen = (mainPixel.getGreen() + rightPixel.getGreen() + upperPixel.getGreen()) / 3;
                  int combinedBlue = (mainPixel.getBlue() + rightPixel.getBlue() + upperPixel.getBlue()) / 3;
                  Color newColor = new Color(combinedRed, combinedGreen, combinedBlue);
                  image.setRGB(count, con, newColor.getRGB());
                }
                else if (count == image2.getWidth() - 1)
                {
                  IMPixel mainPixel = new IMPixel(image2, count, con);
                  IMPixel leftPixel = new IMPixel(image2, count - 1, con);
                  IMPixel upperPixel = new IMPixel(image2, count, con - 1);
                  int combinedRed = (mainPixel.getRed() + leftPixel.getRed() + upperPixel.getRed()) / 3;
                  int combinedGreen = (mainPixel.getGreen() + leftPixel.getGreen() + upperPixel.getGreen()) / 3;
                  int combinedBlue = (mainPixel.getBlue() + leftPixel.getBlue() + upperPixel.getBlue()) / 3;
                  Color newColor = new Color(combinedRed, combinedGreen, combinedBlue);
                  image.setRGB(count, con, newColor.getRGB());
                }
                else
                {
                  IMPixel mainPixel = new IMPixel(image2, count, con);
                  IMPixel leftPixel = new IMPixel(image2, count - 1, con);
                  IMPixel rightPixel = new IMPixel(image2, count + 1, con);
                  IMPixel upperPixel = new IMPixel(image2, count, con - 1);
                  int combinedRed = (mainPixel.getRed() + leftPixel.getRed() + rightPixel.getRed() + upperPixel.getRed()) / 4;
                  int combinedGreen = (mainPixel.getGreen() + leftPixel.getGreen() + rightPixel.getGreen() + upperPixel.getGreen()) / 4;
                  int combinedBlue = (mainPixel.getBlue() + leftPixel.getBlue() + rightPixel.getBlue() + upperPixel.getBlue()) / 4;
                  Color newColor = new Color(combinedRed, combinedGreen, combinedBlue);
                  image.setRGB(count, con, newColor.getRGB());
                }

              }
              else if (count == 0)
              {
                IMPixel mainPixel = new IMPixel(image2, count, con);
                IMPixel rightPixel = new IMPixel(image2, count + 1, con);
                IMPixel lowerPixel = new IMPixel(image2, count, con + 1);
                IMPixel upperPixel = new IMPixel(image2, count, con - 1);
                int combinedRed = (mainPixel.getRed() + rightPixel.getRed() + lowerPixel.getRed() + upperPixel.getRed()) / 4;
                int combinedGreen = (mainPixel.getGreen() + rightPixel.getGreen() + lowerPixel.getGreen() + upperPixel.getGreen()) / 4;
                int combinedBlue = (mainPixel.getBlue() + rightPixel.getBlue() + lowerPixel.getBlue() + upperPixel.getBlue()) / 4;
                Color newColor = new Color(combinedRed, combinedGreen, combinedBlue);
                image.setRGB(count, con, newColor.getRGB());
              }
              else if (count == image2.getWidth() - 1)
              {
                IMPixel mainPixel = new IMPixel(image2, count, con);
                IMPixel leftPixel = new IMPixel(image2, count - 1, con);
                IMPixel lowerPixel = new IMPixel(image2, count, con + 1);
                IMPixel upperPixel = new IMPixel(image2, count, con - 1);
                int combinedRed = (mainPixel.getRed() + leftPixel.getRed() + lowerPixel.getRed() + upperPixel.getRed()) / 4;
                int combinedGreen = (mainPixel.getGreen() + leftPixel.getGreen() + lowerPixel.getGreen() + upperPixel.getGreen()) / 4;
                int combinedBlue = (mainPixel.getBlue() + leftPixel.getBlue() + lowerPixel.getBlue() + upperPixel.getBlue()) / 4;
                Color newColor = new Color(combinedRed, combinedGreen, combinedBlue);
                image.setRGB(count, con, newColor.getRGB());
              }
              else
              {
                IMPixel mainPixel = new IMPixel(image2, count, con);
                IMPixel leftPixel = new IMPixel(image2, count - 1, con);
                IMPixel rightPixel = new IMPixel(image2, count + 1, con);
                IMPixel lowerPixel = new IMPixel(image2, count, con + 1);
                IMPixel upperPixel = new IMPixel(image2, count, con - 1);
                int combinedRed = (mainPixel.getRed() + leftPixel.getRed() + rightPixel.getRed() + lowerPixel.getRed() + upperPixel.getRed()) / 5;
                int combinedGreen = (mainPixel.getGreen() + leftPixel.getGreen() + rightPixel.getGreen() + lowerPixel.getGreen() + upperPixel.getGreen()) / 5;
                int combinedBlue = (mainPixel.getBlue() + leftPixel.getBlue() + rightPixel.getBlue() + lowerPixel.getBlue() + upperPixel.getBlue()) / 5;
                Color newColor = new Color(combinedRed, combinedGreen, combinedBlue);
                image.setRGB(count, con, newColor.getRGB());
              }
            }
          }

        }

      }
      else if (choice.equalsIgnoreCase("sharpen"))
      {
    	  
      }
      
      else if(choice.equalsIgnoreCase("contrast"))
      {
    	  double contrastRatio = 0.0;
    	  boolean heyyyyy = true; //I was running out of variable names...
    	  while(heyyyyy)
    	  {
	    	  Scanner contrastRatioScanner = new Scanner(System.in);
	    	  System.out.println("Please enter the constant you wish to adjust the contrast by:");
	    	  if(!contrastRatioScanner.hasNextDouble())
	    	  {
	    		  System.out.println("Please enter a double value!!!");
	    		  heyyyyy = true;
	    	  }
	    	  else
	    	  {
	    		  contrastRatio = contrastRatioScanner.nextDouble();
	    		  heyyyyy = false;
	    	  }
    	  }
	     for(int con = 0; con < image.getHeight(); con ++)
	     {
	    	 for(int count = 0; count < image.getWidth(); count ++)
	    	 {
	    		 IMPixel mainPixel = new IMPixel(image, count, con);
	    		 double contrastedRed = (double)mainPixel.getRed()*contrastRatio;
	    		 double contrastedGreen = (double)mainPixel.getGreen()*contrastRatio;
	    		 double contrastedBlue = (double)mainPixel.getBlue()*contrastRatio;
	    		 if(contrastedRed > 255)
	    		 {
	    			 contrastedRed = 255;
	    		 }
	    		 if(contrastedGreen > 255)
	    		 {
	    			 contrastedGreen = 255;
	    		 }
	    		 if(contrastedBlue > 255)
	    		 {
	    			 contrastedBlue = 255;
	    		 }
	    		 Color color = new Color((int)contrastedRed, (int)contrastedGreen, (int)contrastedBlue);
	    		 image.setRGB(count, con, color.getRGB());
	    	 }
	     }
      }
      
      else if(choice.equalsIgnoreCase("lighten"))
      {
    	  double lightenValue = 0.0;
    	  boolean cont = true;
    	  while(cont)
    	  {
    		  Scanner lightenValueScanner = new Scanner(System.in);
    		  System.out.println("please enter a value that you wish to lighten the image by:");
    		  if(!lightenValueScanner.hasNextDouble())
    		  {
    			  System.out.println("You need to enter a double!!!");
    			  cont = true;
    		  }
    		  else
    		  {
    			  lightenValue = lightenValueScanner.nextDouble();
    			  cont = false;
    		  }
    	  }
    	  for(int con = 0; con < image.getHeight(); con ++)
    	  {
    		  for(int count = 0; count < image.getWidth(); count++)
    		  {
    			  IMPixel mainPixel = new IMPixel(image, count, con);
    			  double lightenedRed = (double)mainPixel.getRed() + lightenValue;
    			  double lightenedGreen = (double)mainPixel.getGreen() + lightenValue;
    			  double lightenedBlue = (double)mainPixel.getBlue() + lightenValue;
    			  if(lightenedRed > 255)
    			  {
    				  lightenedRed = 255;
    			  }
    			  if(lightenedGreen > 255)
    			  {
    				  lightenedGreen = 255;
    			  }
    			  if(lightenedBlue > 255)
    			  {
    				  lightenedBlue = 255;
    			  }
    			  Color lightenedColor = new Color((int)lightenedRed, (int)lightenedGreen, (int)lightenedBlue);
    			  image.setRGB(count, con, lightenedColor.getRGB());
    		  }
    	  }
      }
      else if(choice.equalsIgnoreCase("darken"))
      {
    	  double darkenValue = 0.0;
    	  boolean cont = true;
    	  while(cont)
    	  {
    		  Scanner darkenValueScanner = new Scanner(System.in);
    		  System.out.println("please enter a value that you wish to lighten the image by:");
    		  if(!darkenValueScanner.hasNextDouble())
    		  {
    			  System.out.println("You need to enter a double!!!");
    			  cont = true;
    		  }
    		  else
    		  {
    			  darkenValue = darkenValueScanner.nextDouble();
    			  cont = false;
    		  }
    	  }
    	  for(int con = 0; con < image.getHeight(); con ++)
    	  {
    		  for(int count = 0; count < image.getWidth(); count++)
    		  {
    			  IMPixel mainPixel = new IMPixel(image, count, con);
    			  double darkenedRed = (double)mainPixel.getRed() - darkenValue;
    			  double darkenedGreen = (double)mainPixel.getGreen() - darkenValue;
    			  double darkenedBlue = (double)mainPixel.getBlue() - darkenValue;
    			  if(darkenedRed < 0)
    			  {
    				  darkenedRed = 0;
    			  }
    			  if(darkenedGreen < 0)
    			  {
    				  darkenedGreen = 0;
    			  }
    			  if(darkenedBlue < 0)
    			  {
    				  darkenedBlue = 0;
    			  }
    			  Color darkenedColor = new Color((int)darkenedRed, (int)darkenedGreen, (int)darkenedBlue);
    			  image.setRGB(count, con, darkenedColor.getRGB());
    		  }
    	  }
    	  
      }
    }
  }

  public image(BufferedImage image)
  {
    image = image;
    this.size.setSize(image.getWidth(), image.getHeight());
  }

  protected void paintComponent(Graphics g)
  {
    int x = (getWidth() - this.size.width) / 2;
    int y = (getHeight() - this.size.height) / 2;
    g.drawImage(image, x, y, this);
  }
  public Dimension getPreferredSize() {
    return this.size;
  }

  public static void displayImage()
  {
    image test = new image(image);
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(3);
    f.add(new JScrollPane(test));
    f.setSize(image.getWidth() + 90, image.getHeight() + 90);
    f.setLocation(200, 200);
    f.setVisible(true);
  }
}