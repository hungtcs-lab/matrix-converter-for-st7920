package com.hungtcs.matrixconverterforst7920.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class MatrixDisplayer extends JPanel {
  private static final long serialVersionUID = 1L;
  private int pixelSize = 8;
  private int xCount = 128;
  private int yCount = 64;
  private Color lineColor = Color.GRAY;
  private Color[] colorMatrix = {};
  private int padding = 22;
  
  public MatrixDisplayer() {
    
  }
  

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    this.drawLines((Graphics2D)g);
    this.drawPixel((Graphics2D)g);
  }
  
  private void drawLines(Graphics2D g) {
    g.setColor(this.lineColor);
    for(int y=0; y<=yCount; y++) {
      g.drawLine(this.padding, y * this.pixelSize + this.padding, this.xCount * this.pixelSize + this.padding, y * this.pixelSize + this.padding);
    }
    for(int x=0; x<=xCount; x++) {
      g.drawLine(x * this.pixelSize + this.padding, this.padding, x * this.pixelSize + this.padding, this.yCount * this.pixelSize + this.padding);
    }
  }
  
  private void drawPixel(Graphics2D g) {
    for (int i = 0; i < Math.min(colorMatrix.length, xCount * yCount); i++) {
      g.setColor(this.colorMatrix[i]);
      g.fillRect(i % xCount * this.pixelSize + 1 + this.padding, i / xCount * pixelSize + 1 + this.padding, this.pixelSize - 1, this.pixelSize - 1);
    }
  }
  
  public void setPixelSize(int size) {
    this.pixelSize = size;
  }
  
  public void setColorMatrix(Color[] colors) {
    this.colorMatrix = colors;
    this.repaint();
  }

}
