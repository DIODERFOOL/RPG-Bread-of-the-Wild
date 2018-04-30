import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class RenderHandler{
  private BufferedImage view;
  private int[]pixels;


  public RenderHandler(int width, int height){
    view =new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
    pixels = ((DataBufferInt)view.getRaster().getDataBuffer())getData();

    /*for(int heightI =0;heightI < height; heigthI++){
      int randomPixel =(int)(Math.random() * 0xFFFFFF);
      for (int widthI=0; widthI <width; widthI++){
        pixels[heightI*width +widthI]=randomPixel;
      }
    }*/
  }

  public void render(Graphics graphics){
    graphics.drawImage(view, 0, 0, view.getWidth(), view.getHeight(),null);

  }

  public void renderImage(BufferedImage image, int xPosition, int yPosition, int xZoom, int yZoom ){
      int [] imagePixels = ((DataBufferInt)image.getRaster().getDataBuffer())getData();
      for (int y=0; y< image.getWidth(); y++){
        for (int x=0; x<image.getWidth();x++){
          for (int yZoomPosition =0; yZoomPosition <yZoomPosition; yZoomPosition++){
            for (int xZoomPosition =0; xZoomPosition <xZoomPosition; xZoomPosition++){
              pixels[((x*xZoom) +xPosition +xZoomPosition) +((y*yZoom)+yPosition+ yZoomPosition) *view.getWidth()] = imagePixels[x+y* image.getWidth()];
            }
          }
        }
      }
  }

}
