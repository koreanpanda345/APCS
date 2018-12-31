package Main.pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
        ++count;
        System.out.println(count);
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {

        leftPixel = pixels[row][col];
        rightPixel = pixels[row]
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
    public void mirrorArms(){
      int mirrorPoint = 193;
      Pixel topPixel = null;
      Pixel bottomPixel = null;
      Pixel[][] pixels = this.getPixels2D();
      //left arm
        for(int row = 158; row < mirrorPoint; ++row){
            for(int col = 103; col < 170; ++col){
                topPixel = pixels[row][col];
                bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
        int mirrorPoint2 = 198;
        Pixel topPixel2 = null;
        Pixel bottomPixel2 = null;

        //right arm
        for(int row = 171; row < mirrorPoint2; ++row){
            for(int col = 239; col < 294; ++col){
                topPixel2 = pixels[row][col];
                bottomPixel2 = pixels[mirrorPoint2 - row + mirrorPoint2][col];
                bottomPixel2.setColor(topPixel2.getColor());
            }
        }
    }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  /**
   * @param fromPic the picture to copy from
   * @param startRow the starting value of the rows
   * @param startCol the starting value of the columns
   * @param endRow the ending value of the rows
   * @param endCol the ending value of the columns
   */
public void copy2(Picture fromPic, int startRow, int endRow, int startCol, int endCol){
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for(int fromRow = 0, toRow = startRow;
        fromRow < fromPixels.length && toRow < endRow;
        ++fromRow, ++toRow){
        for(int fromCol = 0, toCol = startCol;
        fromCol < fromPixels[0].length && toCol < endCol;
        ++fromCol, ++toCol){
            fromPixel = fromPixels[fromRow][fromCol];
            toPixel = toPixels[toRow][toCol];
            toPixel.setColor(fromPixel.getColor());
        }
    }
}

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("C:\\Users\\korea\\IdeaProjects\\ApCs\\src\\Main\\pixLab\\images\\flower1.jpg");
    Picture flower2 = new Picture("C:\\Users\\korea\\IdeaProjects\\ApCs\\src\\Main\\pixLab\\images\\flower2.jpg");
    //this.copy(flower1,0,0);
      this.copy2(flower1, 0, 100, 0, 100);
    //this.copy(flower2,100,0);
    //this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    //this.copy(flowerNoBlue,300,0);
      this.copy2(flowerNoBlue, 300, 350, 80, 500);
    //this.copy(flower1,400,0);
    //this.copy(flower2,500,0);
    //this.mirrorVertical();
    this.write("C:\\Users\\korea\\IdeaProjects\\ApCs\\src\\Main\\pixLab\\images\\collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  public void edgeDetection2(int edgeDist){
      Pixel currentPixel = null, testPixel = null;
      int testWidth = 3;
      int testHeight = 3;
      Pixel [][] pixels =this.getPixels2D();
      double[][] edgeAngle = new double[Math.round(pixels.length / testHeight)][Math.round(pixels[0].length / testWidth)];
      for(int row = 0; row < pixels.length - testHeight; row += testHeight){
          for(int col = 0; col< pixels[0].length - testWidth; col += testWidth){
              Pixel[][] currentPixels = this.getPixelCluster(pixels, row, col, testWidth, testHeight);
              double greatestDistance = -10;
              double greatestAngle = -1;

              for(double angle = 0; angle < Math.PI - 0.1; angle += Math.PI / 8){
                  ArrayList<Pixel> group1 = this.getPartialArray(currentPixels, angle, 0);
                  Color group1Color = this.getAverageColor(this.getPixelColors(group1));
                  ArrayList<Pixel> group2 = this.getPartialArray(currentPixels, angle, 1);
                  Color group2Color = this.getAverageColor(this.getPixelColors(group2));

                  double currentColorDistance = this.colorDistance(group1Color, group2Color);

                  if(currentColorDistance > greatestDistance){
                      greatestDistance = currentColorDistance;
                      greatestAngle = angle;
                  }
              }
          }
      }
  }
  public void mirrorVerticalRightToLeft(){
      Pixel[][] pixels = this.getPixels2D();
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int width = pixels[0].length;
      for (int row = 0; row < pixels.length; row++)
      {
          for (int col = 0; col < width / 2; col++)
          {
              leftPixel = pixels[row][col];
              rightPixel = pixels[row][width - 1 - col];
              rightPixel.setColor(leftPixel.getColor());
          }
      }
  }
  public void mirrorHorizontal(){
      Pixel[][] pixels = this.getPixels2D();
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int height = pixels[0].length;
      for (int row = 0; row < pixels.length; ++row)
      {
          for (int col = 0; col < height / 2; ++col)
          {
              leftPixel = pixels[row][col];
              rightPixel = pixels[col][height - 1 - row];
              rightPixel.setColor(leftPixel.getColor());
          }
      }
  }
  public double colorDistance(Color testColor1, Color testColor2){
   double redDistance = testColor2.getRed() - testColor1.getRed();
   double greenDistance = testColor2.getGreen() - testColor1.getGreen();
   double blueDistance = testColor2.getBlue() - testColor1.getBlue();
   double distance = Math.sqrt(redDistance * redDistance + greenDistance * greenDistance + blueDistance * blueDistance);
   return distance;
  }
  public Color getAverageColor(Color[] myColors){
      int totalRed = 0;
      int totalGreen = 0;
      int totalBlue = 0;

      int total = 0;

      for(Color currentColor : myColors){
          totalRed += currentColor.getRed();
          totalGreen += currentColor.getGreen();
          totalBlue += currentColor.getBlue();
          ++total;
      }
      return new Color(totalRed / total, totalGreen / total, totalBlue / total);
  }
  public Color[] getPixelColors(ArrayList<Pixel> pixels){
      Color[] myColors = new Color[pixels.size()];
      int count = 0;
      for(Pixel currentPixel : pixels) {
          myColors[count] = currentPixel.getColor();
          ++count;
      }
      return myColors;
  }
public Pixel[][] getPixelCluster(Pixel[][] pixels, int startRow, int startCol, int width, int height){
      Pixel[][] pixelCluster = new Pixel [height][width];
      if(pixels.length < startRow + height || pixels[0].length < startCol + width){
          return pixelCluster;
      }
      for(int row = startRow; row < startRow + height ; ++row){
          for(int col = startCol; col < startCol + width; ++col){
              pixelCluster[row - startRow][col - startCol] = pixels[row][col];
          }
      }
      return pixelCluster;
}
public ArrayList<Pixel> getPartialArray(Pixel[][] fullArray, double angle, int typeOf){
      int rows = fullArray.length, cols = fullArray[0].length;
      int centerRow = rows / 2, centerCol = cols / 2;
      int arrayLength = (rows * cols);
      ArrayList<Pixel> tempList = new ArrayList<Pixel>();
      double slope = Math.tan(angle);
      if(slope == 0) slope = 0.001;
      double newSlope = -1 / slope;

      for(int i = 0; i < arrayLength; ++i){
          int currentRow = i /cols, currentCol = i % cols;
          if(currentCol < (newSlope * (currentRow - centerRow) + centerCol)){
              if(typeOf == 1){
                  tempList.add(fullArray[currentRow][currentCol]);
              }
          }
      }
    return tempList;
}

  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
      Picture snowman = new Picture("C:\\Users\\korea\\IdeaProjects\\ApCs\\src\\Main\\pixLab\\images\\snowman.jpg");
      snowman.explore();
      snowman.mirrorArms();
      snowman.explore();
  }

} // this } is the end of class Picture, put all new methods before this
