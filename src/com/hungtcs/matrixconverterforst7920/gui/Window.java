package com.hungtcs.matrixconverterforst7920.gui;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Window extends JFrame {
  private static final long serialVersionUID = 1L;
  public MainContent mainContent;
  
  static {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }
  }
  
  public Window() {
    this.mainContent = new MainContent(this);
  }
  
  public Window init() {
    this.setTitle("Picture To Matrix");
    this.setSize(1075, (int)(1075*0.618));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setResizable(true);
    this.setContentPane(this.mainContent);
    this.setVisible(true);
    return this;
  }
  
}
