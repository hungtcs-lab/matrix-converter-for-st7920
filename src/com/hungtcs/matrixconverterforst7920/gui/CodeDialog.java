package com.hungtcs.matrixconverterforst7920.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CodeDialog extends JDialog {
  private static final long serialVersionUID = 1L;
  public Window window;
  private int[] binaryMatrix;
  private Dimension size = new Dimension(620, 300);
  private JTextArea textArea;

  public CodeDialog(Window window, int[] binaryMatrix) {
    this.window = window;
    this.binaryMatrix = binaryMatrix;
    this.setup();
    this.toST7920Matrix();
  }
  
  private void setup() {
    this.setTitle("代码生成");
    this.setModal(true);
    this.setSize(size);
    this.setMinimumSize(size);
    this.setLocationRelativeTo(window);
    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    this.textArea = new JTextArea();
    this.textArea.setMargin(new Insets(10, 10, 10, 10));
    JScrollPane scrollPane = new JScrollPane(this.textArea);
    
    this.setLayout(new BorderLayout());
    
    this.add(scrollPane, BorderLayout.CENTER);
  }
  
  private void toST7920Matrix() {
    int byteSize = 8;
    Integer[] hexMatrix = new Integer[this.binaryMatrix.length / byteSize];
    for (int i = 0; i < hexMatrix.length; i++) {
      hexMatrix[i] = 0;
      for (int j = 0; j < byteSize; j++) {
        hexMatrix[i] <<= 1;
        if(this.binaryMatrix[i * byteSize + j] == 1) {
          hexMatrix[i] |= 1;
        } 
      }
    }

    String a = Arrays.asList(hexMatrix).stream()
        .map(Integer::toHexString)
        .map(str -> "0x" + str)
        .collect(Collectors.joining(", "));
    String code = String.format("int matrix[] = { %s }; ", a);
    this.textArea.setText(code);
  }

}
