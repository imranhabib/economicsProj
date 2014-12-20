package project;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

/**
 * Created by livin_4_the_game on 14-12-18.
 */
public class phase4 extends JFrame{

    static JFrame mainScreen;

    static JLabel title;
    static JLabel instructions;
    static JLabel changeAllocations;

    static Border raisedBorder;
    static Border loweredBorder;

    static JSplitPane split;
    static JSplitPane split2;
    static JSplitPane split3;

    static JPanel leftPanel;
    static JPanel rightPanel;
    static JPanel checkboxPanel;
    static JPanel buttonPanel;
    static JPanel bottomPanel;

    static JButton button1;
    static JButton button2;
    static JButton button3;
    static JButton button4;
    static JButton button5;
    static JButton button6;
    static JButton button7;
    static JButton button8;
    static JButton button9;
    static JButton button10;

    static JButton button1b;
    static JButton button2b;
    static JButton button3b;
    static JButton button4b;
    static JButton button5b;
    static JButton button6b;
    static JButton button7b;
    static JButton button8b;
    static JButton button9b;
    static JButton button10b;

    static JButton button11;
    static JButton button12;


    static JCheckBox checkBox1;
    static JCheckBox checkBox2;
    static JCheckBox checkBox3;
    static JCheckBox checkBox4;
    static JCheckBox checkBox5;
    static JCheckBox checkBox6;
    static JCheckBox checkBox7;
    static JCheckBox checkBox8;
    static JCheckBox checkBox9;
    static JCheckBox checkBox10;


  public phase4(){
      mainScreen = new JFrame();
      mainScreen.setLayout(new BorderLayout());
      mainScreen.setTitle("Stage 4");
      Dimension screenSize = new Dimension(600, 800);
      mainScreen.setBounds(0,0,1200,700);
      mainScreen.setLocationRelativeTo(null);

      raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
      loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);

      checkboxPanel = new JPanel(new GridLayout(10,2,10,10));
      checkboxPanel.setBorder(raisedBorder);
      rightPanel = new JPanel(new GridLayout(10, 2, 10, 10));
      rightPanel.setBorder(raisedBorder);
      split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, checkboxPanel, rightPanel);
      split2.setResizeWeight(0.09);

      leftPanel = new JPanel(new GridLayout(10, 2, 10 , 10));
      leftPanel.setBorder(raisedBorder);
      split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, split2);
      split.setResizeWeight(.5);

      checkBox1 = new JCheckBox();
      checkBox2 = new JCheckBox();
      checkBox3 = new JCheckBox();
      checkBox4 = new JCheckBox();
      checkBox5 = new JCheckBox();
      checkBox6 = new JCheckBox();
      checkBox7 = new JCheckBox();
      checkBox8 = new JCheckBox();
      checkBox9 = new JCheckBox();
      checkBox10 = new JCheckBox();

      button1 = new JButton("Click to see current allocations for price set 1");
      button2 = new JButton("Click to see current allocations for price set 2");
      button3 = new JButton("Click to see current allocations for price set 3");
      button4 = new JButton("Click to see current allocations for price set 4");
      button5 = new JButton("Click to see current allocations for price set 5");
      button6 = new JButton("Click to see current allocations for price set 6");
      button7 = new JButton("Click to see current allocations for price set 7");
      button8 = new JButton("Click to see current allocations for price set 8");
      button9 = new JButton("Click to see current allocations for price set 9");
      button10 = new JButton("Click to see current allocations for price set 10");

      button1b = new JButton("Click to see allocations for new price set 1");
      button2b = new JButton("Click to see allocations for new price set 2");
      button3b = new JButton("Click to see allocations for new price set 3");
      button4b = new JButton("Click to see allocations for new price set 4");
      button5b = new JButton("Click to see allocations for new price set 5");
      button6b = new JButton("Click to see allocations for new price set 6");
      button7b = new JButton("Click to see allocations for new price set 7");
      button8b = new JButton("Click to see allocations for new price set 8");
      button9b = new JButton("Click to see allocations for new price set 9");
      button10b = new JButton("Click to see allocations for new price set 10");

      leftPanel.add(button1);
      leftPanel.add(button2);
      leftPanel.add(button3);
      leftPanel.add(button4);
      leftPanel.add(button5);
      leftPanel.add(button6);
      leftPanel.add(button7);
      leftPanel.add(button8);
      leftPanel.add(button9);
      leftPanel.add(button10);

      rightPanel.add(button1b);
      rightPanel.add(button2b);
      rightPanel.add(button3b);
      rightPanel.add(button4b);
      rightPanel.add(button5b);
      rightPanel.add(button6b);
      rightPanel.add(button7b);
      rightPanel.add(button8b);
      rightPanel.add(button9b);
      rightPanel.add(button10b);

      checkboxPanel.add(checkBox1);
      checkboxPanel.add(checkBox2);
      checkboxPanel.add(checkBox3);
      checkboxPanel.add(checkBox4);
      checkboxPanel.add(checkBox5);
      checkboxPanel.add(checkBox6);
      checkboxPanel.add(checkBox7);
      checkboxPanel.add(checkBox8);
      checkboxPanel.add(checkBox9);
      checkboxPanel.add(checkBox10);

      button11 = new JButton("extra button");
      button12= new JButton("Submit");

      buttonPanel = new JPanel(new GridLayout(1, 0, 5, 5));
      buttonPanel.add(button11);
      buttonPanel.add(button12);

      instructions = new JLabel("Instructions");
      bottomPanel = new JPanel(new BorderLayout());
      bottomPanel.add(instructions, BorderLayout.NORTH);

      split3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, bottomPanel, split);
      split3.setResizeWeight(0.6);


      title = new JLabel("Stage 4");
      title.setFont(new Font("Calibri", Font.BOLD, 20));
      mainScreen.add(title, BorderLayout.NORTH);


      mainScreen.add(split3);
      mainScreen.add(buttonPanel, BorderLayout.SOUTH);

      mainScreen.setVisible(true);


  }

    public static void main(String[] args) throws Exception{
        phase4 p4 = new phase4();
    }



}

