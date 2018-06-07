package com.hungtcs.matrixconverterforst7920.gui;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import com.hungtcs.matrixconverterforst7920.utils.ImageUtil;

public class MainContent extends JPanel {
  private static final long serialVersionUID = 1L;
  public Window window;
  public MatrixDisplayer matrixDisplayer;
  public Toolbar toolbar;
  private BufferedImage image;
  
  public MainContent(Window window) {
    this.window = window;

    this.toolbar = new Toolbar(this);
    this.matrixDisplayer = new MatrixDisplayer();

    this.setLayout(new BorderLayout());
    this.add(this.toolbar, BorderLayout.NORTH);
    this.add(this.matrixDisplayer, BorderLayout.CENTER);
  }

  public void setImage(BufferedImage image) {
    this.image = image;
    this.matrixDisplayer.setColorMatrix(ImageUtil.toColorArray(this.image));
    this.toolbar.buttonTransfor.setEnabled(true);
    this.toolbar.buttonColorInverse.setEnabled(true);
    this.toolbar.buttonGenerateCode.setEnabled(true);
  }
  
  public BufferedImage getImage() {
    return this.image;
  }
  
}
