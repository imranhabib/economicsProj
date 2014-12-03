package project;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.ArrayList;
import java.util.List;




/**
 * Created by Imran on 2014-11-29.
 */
public class sliderInterface extends JFrame {

  static JSlider slider;
  static JPanel panel;
  static JPanel panel2;
  static JLabel label;
  static JPanel panel3;
  static JPanel panel4;
  static JButton button1;

  private static JTextField textField;
  private static JTextField textField2;
  private static JTextField textField3;
  private static JTextField textField4;
  private static JTextField textField5;

  private static JTextArea textFieldA;
  private static JTextArea textField2B;
  private static JTextArea textField3C;
  private static JTextArea textField4D;
  private static JTextArea textField5E;

  private static ChangeListener changelistener;
  private static ActionListener action;

  private final Color blue = Color.BLUE;
  private final Color red = Color.RED;

  private static boolean check;


  static int total = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave"));
  static int allocation = 0;


    public sliderInterface(List<Share> shares) {
      setLayout(new BorderLayout());
      setTitle("Slider Interface");
      setSize(1000, 1000);

      int size = shares.size();
      panel2 = new JPanel();

      allocation = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave"));

      panel2.setLayout(new BorderLayout(5, 10));

      panel = new JPanel();
      panel.setLayout(new GridLayout(0, shares.size()));
      panel.setPreferredSize(new Dimension(500, 500));
      panel.setBorder(new TitledBorder("Securities"));
    // label = new JLabel("Securities");
     // panel.add(label);

      panel3 = new JPanel();

      panel3.setLayout(new GridLayout(0, shares.size()));
      //panel3.setPreferredSize(new Dimension(50, 100));
      panel3.setBorder(new TitledBorder("Income Share"));

      textField = new JTextField();
      textField2 = new JTextField();
      textField3 = new JTextField();
      textField4 = new JTextField();
      textField5 = new JTextField();

      textField.setEditable(false);
      textField2.setEditable(false);
      textField3.setEditable(false);
      textField4.setEditable(false);
      textField5.setEditable(false);

      /*
      textField.setForeground(blue);
      textField2.setForeground(red);
      textField3.setForeground(blue);
      textField4.setForeground(red);
      textField5.setForeground(blue);
      */

      textFieldA = new JTextArea();
      textField2B = new JTextArea();
      textField3C = new JTextArea();
      textField4D = new JTextArea();
      textField5E = new JTextArea();


      textFieldA.setEditable(false);
      textField2B.setEditable(false);
      textField3C.setEditable(false);
      textField4D.setEditable(false);
      textField5E.setEditable(false);

      panel4 = new JPanel();
      panel4.setLayout(new GridLayout(0, shares.size()));
      panel4.setBorder(new TitledBorder("Data"));

      if(size >= 1) {
        panel3.add(textField);
        panel4.add(textFieldA);

      }
      if(size >= 2) {
        panel3.add(textField2);
        panel4.add(textField2B);
      }
      if(size >= 3) {
        panel3.add(textField3);
        panel4.add(textField3C);
      }
      if(size >= 4) {
        panel3.add(textField4);
        panel4.add(textField4D);

      }
      if(size >= 5) {
        panel3.add(textField5);
        panel4.add(textField5E);
      }








      JSplitPane splitPane = new JSplitPane(
          JSplitPane.VERTICAL_SPLIT, panel, panel4
      );


      button1 = new JButton("Submit");
      button1.setToolTipText("Click to submit input selection");
      button1.setBorder(new TitledBorder("Move on"));







 //you can change the first SOUTH -> NORTH && the first CENTER -> SOUTH to get a different spacing/sizing

   panel2.add(splitPane, BorderLayout.CENTER );
     // panel2.add(panel, BorderLayout.CENTER);
      panel2.add(panel3, BorderLayout.NORTH);
      panel2.add(button1, BorderLayout.SOUTH);
      add(panel2, BorderLayout.CENTER);
      //add(panel3, BorderLayout.PAGE_START);

        check= false;

        changelistener = new ChangeListener()
        {
            public void stateChanged(ChangeEvent event)
            {
                JSlider source = (JSlider) event.getSource();

               if (!source.getValueIsAdjusting()) {
                 int value = source.getValue();

                 String name = source.getName();
                 if(name.equals("1")){
                   textField.setText("Security #" + source.getName() + " = " + value + "%");
                   textFieldA.setText("Remaining income share" + "\n" + "must be below " + value);
                   check = true;                                                                         //using getName to store the price of the security
                 }
                 if(name.equals("2")){
                   textField2.setText("Security #" + source.getName() + " = " + value +"%");
                     textField2B.setText("Remaining income share" + "\n" + "must be below " + value);
                   check = true;
                 }
                 if(name.equals("3")){
                   textField3.setText("Security #" + source.getName() + " = " + value+"%");
                     textField3C.setText("Remaining income share" + "\n" + "must be below " + value);
                   check = true;
                 }
                 if (name.equals("4")){
                   textField4.setText("Security #" + source.getName() + " = " + value+"%");
                     textField4D.setText("Remaining income share" + "\n" + "must be below " + value);
                   check = true;
                 }
                 if (name.equals("5")){
                   textField5.setText("Security #" + source.getName() + " = " + value+ "%");
                     textField5E.setText("Remaining income share" + "\n" + "must be below " + value);
                   check = true;
                 }
               }

            }
        };





      action = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if(check){
            confirmation(e);
          } else {
            error(e);
          }

        }
      };


      button1.addActionListener(action);



      //create as many slider instances of the size of 'shares'
            //call the addSlider method with the correct param taken from the share object
            for(int i = 0; i < shares.size(); i++){
                addShare(formatSlider(shares.get(i).getPrice(), shares.get(i).getSecurityNumber()), shares.get(i).getIncomeShare(), shares.get(i).getPrice());
            }


    }

    public void addShare (JSlider slider, float incomeShare, int price){
        slider.addChangeListener(changelistener);
        JPanel pan = new JPanel();
        pan.add(slider);
        pan.setToolTipText(Float.toString(incomeShare));
        pan.add(new JLabel("Price of security = " + price));
        panel.add(pan);

    }

    public JSlider formatSlider(int price, int number){
        JSlider slider = new JSlider(JSlider.VERTICAL);
        slider.setName(Integer.toString(price));
        slider.setMinimum(0);
        slider.setMaximum(100);
        slider.setValue(0);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPreferredSize(new Dimension(100, 400));
        slider.setBorder(new TitledBorder("Security " + Integer.toString(number)));
        slider.setPaintLabels(true);
        java.util.Hashtable<Integer,JLabel> labelTable = new java.util.Hashtable<Integer,JLabel>();
        labelTable.put(new Integer(100), new JLabel("1.0"));
        labelTable.put(new Integer(75), new JLabel("0.75"));
        labelTable.put(new Integer(50), new JLabel("0.50"));
        labelTable.put(new Integer(25), new JLabel("0.25"));
        labelTable.put(new Integer(0), new JLabel("0.0"));
        slider.setLabelTable( labelTable );

        //slider.add(new JLabel(Integer.toString(price)));
        return slider;

    }

    public int remainingIncome(int allocation,  int value, int price){

        float v = (float) value / 100;
      setTotal(allocation - v*price);
      return allocation - value*price;
    }


    public void setTotal (float remains){
        float temp = Math.round(remains);
        int r = (int) temp;
      total = r;
    }

    public int getTotal(){
      return total;
    }


    public void confirmation(ActionEvent action){
      JOptionPane.showConfirmDialog(null,
          "Confirm Allocations?", "There's no going back!", JOptionPane.YES_NO_OPTION);

    }


    public void error(ActionEvent e){
      JOptionPane.showMessageDialog(null, "Please complete allocations", "Error", JOptionPane.ERROR_MESSAGE);
    }


}
