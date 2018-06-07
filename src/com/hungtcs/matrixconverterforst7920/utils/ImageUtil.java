package com.hungtcs.matrixconverterforst7920.utils;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageUtil {
  
  /**
   * 二值化
   */
  public static BufferedImage toBinary(BufferedImage image) {
    int width = image.getWidth();
    int height = image.getHeight();
    BufferedImage binaryImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
    for(int y=0; y<height; y++) {
      for(int x=0; x<width; x++) {
        binaryImage.setRGB(x, y, image.getRGB(x, y));
      }
    }
    return binaryImage;
  }
  
  /**
   * 获得颜色序列
   */
  public static Color[] toColorArray(BufferedImage image) {
    int width = image.getWidth();
    int height = image.getHeight();
    Color[] colors = new Color[width * height];
    for(int y=0; y<height; y++) {
      for(int x=0; x<width; x++) {
        colors[x + y * width] = new Color(image.getRGB(x, y));
      }
    }
    return colors;
  }
  
  /**
   * 对图片调整尺寸
   */
  public static BufferedImage resize(BufferedImage image, int width, int height) {
    BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    newImage.getGraphics().drawImage(image.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
    return newImage;
  }
  
  /**
   * 颜色反转
   */
  public static BufferedImage colorInverse(BufferedImage image) {
    int width = image.getWidth();
    int height = image.getHeight();
    BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for (int y=0; y<height; y++) {
      for (int x=0; x<width; x++) {
        newImage.setRGB(x, y, (0xFFFFFF - image.getRGB(x, y)));
      }
    }
    return newImage; 
  }
  
}
