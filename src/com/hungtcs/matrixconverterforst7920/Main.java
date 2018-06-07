package com.hungtcs.matrixconverterforst7920;

import com.hungtcs.matrixconverterforst7920.gui.Window;

public class Main {
  private Window mainWindow;
  
  public Main() {
    this.mainWindow = new Window();
  }
  
  public static void main(String[] args) {
    Main application = new Main();
    application.mainWindow.init().repaint();
  }
  
}
