package com.hungtcs.matrixconverterforst7920.gui;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import com.hungtcs.matrixconverterforst7920.Main;

public class Toolbar extends JToolBar implements ActionListener {
  private static final long serialVersionUID = 1L;
  public MainContent mainContent;
  public JButton buttonOpenImage;
  public JButton buttonTransfor;
  public JButton buttonColorInverse;
  public JButton buttonGenerateCode;

  public Toolbar(MainContent mainContent) {
    this.mainContent = mainContent;
    
    this.setFloatable(false);

    this.buttonOpenImage = new JButton(new ImageIcon(Main.class.getClassLoader().getResource("icon_image.png")));
    this.buttonTransfor = new JButton(new ImageIcon(Main.class.getClassLoader().getResource("icon_transfor.png")));
    this.buttonColorInverse = new JButton(new ImageIcon(Main.class.getClassLoader().getResource("icon_invert_color.png")));
    this.buttonGenerateCode = new JButton(new ImageIcon(Main.class.getClassLoader().getResource("icon_code.png")));
    
    this.buttonTransfor.setEnabled(false);
    this.buttonColorInverse.setEnabled(false);
    this.buttonGenerateCode.setEnabled(false);
    
    
    this.buttonOpenImage.setToolTipText("打开图片");
    this.buttonTransfor.setToolTipText("转换到二进制格式");
    this.buttonColorInverse.setToolTipText("颜色反转");
    this.buttonGenerateCode.setToolTipText("生成代码");
    
    this.buttonOpenImage.setActionCommand("openImage");
    this.buttonTransfor.setActionCommand("transforToBinary");
    this.buttonColorInverse.setActionCommand("colorInverse");
    this.buttonGenerateCode.setActionCommand("generateCode");

    this.buttonOpenImage.addActionListener(this);
    this.buttonTransfor.addActionListener(this);
    this.buttonColorInverse.addActionListener(this);
    this.buttonGenerateCode.addActionListener(this);
    
    this.add(this.buttonOpenImage);
    this.addSeparator();
    this.add(this.buttonTransfor);
    this.add(this.buttonColorInverse);
    this.addSeparator();
    this.add(this.buttonGenerateCode);
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    try {
      Method method = Actions.class.getMethod(event.getActionCommand(), Window.class);
      method.invoke(Action.class , this.mainContent.window);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
  
}
