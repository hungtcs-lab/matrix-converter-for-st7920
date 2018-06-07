package com.hungtcs.matrixconverterforst7920.gui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import com.hungtcs.matrixconverterforst7920.utils.ImageUtil;

public class Actions {

  public static void openImage(Window window) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new ImageFilter());
    int status = fileChooser.showOpenDialog(window);
    if(status != JFileChooser.APPROVE_OPTION) {
      return;
    }
    File file = fileChooser.getSelectedFile();
    try {
      BufferedImage image = ImageIO.read(file);
      if(image.getWidth() != 128 || image.getHeight() != 64) {
        int result = JOptionPane.showConfirmDialog(window.mainContent, "是否自动调整尺寸", "尺寸调整", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.CANCEL_OPTION) {
          return;
        }
        image = ImageUtil.resize(image, 128, 64);
      }
      window.mainContent.setImage(image);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public static void transforToBinary(Window window) {
    BufferedImage image = window.mainContent.getImage();
    if(image == null) {
      JOptionPane.showMessageDialog(window.mainContent, "请先选择图片", "提示", JOptionPane.WARNING_MESSAGE);
      return;
    }
    window.mainContent.setImage(ImageUtil.toBinary(image));
  }
  
  public static void colorInverse(Window window) {
    BufferedImage image = window.mainContent.getImage();
    if(image == null) {
      JOptionPane.showMessageDialog(window.mainContent, "请先选择图片", "提示", JOptionPane.WARNING_MESSAGE);
      return;
    }
    window.mainContent.setImage(ImageUtil.colorInverse(image));
  }
  
  public static void generateCode(Window window) {
    BufferedImage image = window.mainContent.getImage();
    if(image == null) {
      JOptionPane.showMessageDialog(window.mainContent, "请先选择图片", "提示", JOptionPane.WARNING_MESSAGE);
      return;
    }
    image = ImageUtil.toBinary(image);
    int width = image.getWidth();
    int height = image.getHeight();
    int[] binaryMatrix = new int[width * height];
    for(int y=0; y<height; y++) {
      for(int x=0; x<width; x++) {
        Color color =  new Color(image.getRGB(x, y));
        binaryMatrix[ x + y * width ] = color.getRed() == 0 ? 1 : 0;
        System.out.printf("%c ", color.getRed() == 0 ? '1' : ' ');
      }
      System.out.println();
    }
    new CodeDialog(window, binaryMatrix).setVisible(true);
    
  }
  
}

class ImageFilter extends FileFilter {

  @Override
  public String getDescription() {
    return "图片文件(*.jpg, *.jpeg, *.png)";
  }
  @Override
  public boolean accept(File f) {
    if(f.isDirectory()) {
      return true;
    }
    try {
      return ImageIO.read(f) != null;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }
  
}
