package project;

import test.testClass;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;

/**
 * Created by Imran on 2015-01-25.
 */
public class phase1Rewind extends JFrame {
    static JSlider slider;
    static JPanel panel;
    static JPanel panel2;
    static JTextField valueAdjust;
    static JPanel panel3;
    static JPanel panel4;
    static JButton textFieldUsedtobePanel5;
    static JTextField textFieldUsedtobePanel6;
    static JLabel label7;
    static JLabel label8;
    static JButton button1;
    static JTextField remainingAlloc;
    static JButton button3;
    static JButton button4;
    static JPanel buttonPanel;

    static JFormattedTextField sliderNumba;

    private static int valueOfSlider;

    static testClass test;
    static parameters params;

    private static List<JSlider> sliders;

    private static JTextField textField;
    private static JTextField textField2;
    private static JTextField textField3;
    private static JTextField textField4;
    private static JTextField textField5;

    //extra panel
    private static JTextField extraSecur;

    private static JTextField textField6;
    private static JTextField textField7;
    private static JLabel LabelThatUsedtobeTextField8;
    private static JLabel leftoverMoney;



    static JLabel empty1;
    static JLabel empty2;
    static JLabel empty3;
    static JLabel empty4;

    private static ChangeListener changelistener;
    private static ChangeListener changelistener2;
    private static ChangeListener changelistener3;
    private static ChangeListener changeListener5;
    private static ActionListener Actionlistener4;
    private static ActionListener actionListener5;
    private static ActionListener action;

    boolean resetPressed;

    private static boolean check;
    private static boolean check2;
    private static boolean check3;
    private static boolean check4;
    private static boolean check5;
    private static boolean check6;
    private static boolean check7;
    private static boolean checkExtra;


    private int v1;
    private int v2;
    private int v3;
    private int v4;
    private int v5;
    private int v6;



    private double v11;
    private double v22;
    private double v33;
    private double v44;
    private double v55;
    private double v66;


    static int curSysProp;

    static int total;

    static int allocation = 0;



    static boolean redirect;

    static JSlider s1;
    static int s1Price;
    static JSlider s2;
    static int s2Price;
    static JSlider s3;
    static int s3Price;
    static JSlider s4;
    static int s4Price;
    static JSlider s5;
    static int s5Price;
    static JSlider s6;
    static int s6Price;


    static Border raisedBorder;
    static Border loweredBorder;

    static List<Share> anotherShareList;

    static int remainingMoney;

    //file stuffz

    String filename = "heuristic-output.csv";
    String filename1 = "Phase1priceSet1.csv";
    String filename2 = "Phase1priceSet2.csv";
    String filename3 = "Phase1priceSet3.csv";
    String filename4 = "Phase1priceSet4.csv";
    String filename6 = "Phase1priceSet6.csv";
    String filename7 = "Phase1priceSet7.csv";
    String filename8 = "Phase1priceSet8.csv";
    String filename9 = "Phase1priceSet9.csv";
    String filename10 = "Phase1priceSet10.csv";
    String filename5 = "Phase1priceSet5.csv";
    String directory;
    String adminDirectory;

    //Note: everything called filename is stored in directory, everything else is stored in adminDirectory


    File file;
    File file1;
    File file2;
    File file3;
    File file4;
    File file5;
    File file6;
    File file7;
    File file8;
    File file9;
    File file10;

    FileWriter filer;
    FileWriter filer1;
    FileWriter filer2;
    FileWriter filer3;
    FileWriter filer4;
    FileWriter filer5;
    FileWriter filer6;
    FileWriter filer7;
    FileWriter filer8;
    FileWriter filer9;
    FileWriter filer10;

    private double d1;
    private double d2;
    private double d3;
    private double d4;
    private double d5;
    private double d6;

    private int m1;
    private int m2;
    private int m3;
    private int m4;
    private int m5;
    private int m6;




    //backend stuffz


    allocation alloc;
    parameters param;
    incomeRequired income;

    static Integer value;
    static Double value2;
    static Double pBar;
    static Double mBar;
    static Double r;
    static Double nOfr;
    static int minimumShare;


    static boolean checkNew;

    private static int n;
    static int count;


    static List<Share> shareList;

    public phase1Rewind(final List<List<Share>> allocations, final List<Share> shares, final List<Integer> cur, final int myshare, final double ratio, final List<List<Share>> tunnel, final boolean stg3, boolean charge) {
        if(cur.size() > 1){
            curSysProp = cur.get(1);
        }



        redirect = false;
        test = new testClass(curSysProp);
        setLayout(new BorderLayout());
        setTitle("Stage 1 via Stage 4" + ": Round " + test.getCurrent());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height - 45);
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        raisedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
        loweredBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);


        checkNew = false;

        shareList = shares;

        directoryStore dirStore = new directoryStore();
        directory = dirStore.getDirectory();
        adminDirectory = dirStore.getAdminDirectory();

        total = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("maxMoney" + test.getCurrent()));
        n = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("securityAmount" + test.getCurrent()));

        int size = shares.size();
        panel2 = new JPanel();

        allocation = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + test.getCurrent())) * 100;
        remainingMoney = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + test.getCurrent())) * 100;

        panel2.setLayout(new BorderLayout(5, 10));

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, shares.size()));
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setBorder(new TitledBorder("Token Allocations"));

        panel3 = new JPanel();

        panel3.setLayout(new GridLayout(0, shares.size()));
        //panel3.setPreferredSize(new Dimension(50, 100));
        panel3.setBorder(new TitledBorder("Round: " + curSysProp + " |" + " Totals"));

        textField = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        extraSecur = new JTextField();

        textField.setEditable(false);
        textField2.setEditable(false);
        textField3.setEditable(false);
        textField4.setEditable(false);
        textField5.setEditable(false);
        textField6.setEditable(false);
        extraSecur.setEditable(false);



        //backend stuffz


        param = new parameters();
        alloc = new allocation(param, new incomeRequired(2));

        shareList = param.getSecurityListWithEmptyIncomeSharesStage2Prices();

//    for (int i = 0 ; i < shareList.size(); i ++ ){
//      System.out.println("This is price of new")
//    }



        button3 = new JButton("Reset Allocations");


        Actionlistener4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                panel.removeAll();
                for (int i = 0; i < shareList.size(); i++) {
                    JSlider jSlider = formatSlider2(shareList.get(i).getPrice(), shareList.get(i).getSecurityNumber());
                    BoundedRangeModel model = jSlider.getModel();
                    if (i == 0){
                        model.setRangeProperties(v1, 100000- (10000000 / shareList.get(i).getPrice()),0,100000,false);
                    }
                    if (i == 1){
                        model.setRangeProperties(v2,0,0,100000,false);
                    }
                    if (i == 2){
                        model.setRangeProperties(v3,0,0,100000,false);
                    }
                    if (i == 3){
                        model.setRangeProperties(v4,0,0,100000,false);
                    }
                    if (i == 4){
                        model.setRangeProperties(v5,0,0,100000,false);
                    }
                    if (i == 5){
                        model.setRangeProperties(v6,0,0,100000,false);
                    }

                    addShare(jSlider, shareList.get(i).getPrice());
                    if(i !=  0){
                        jSlider.setEnabled(false);
                    }
                }
                m1 =v1;
                m2 =v2;
                m3 =v3;
                m4 =v4;
                m5 =v5;
                m6 =v6;
                v1=   10000000 / shareList.get(0).getPrice();
                v2=0;
                v3=0;
                v4=0;
                v5=0;
                v6 = 0;
                v11= 0;
                v22=0;
                v33=0;
                v44=0;
                v55=0;
                v66=0;
                resetPressed = true;
                check7 = false;
                textField.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                extraSecur.setText("");
                remainingMoney = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + test.getCurrent())) * 100;
                textField7.setText(Integer.toString(allocation / 100000));
                remainingAlloc.setText("");
                valueAdjust.setText("# of tokens = ");
                panel.revalidate();
                panel.repaint();
            }
        };



        button3.addActionListener(Actionlistener4);
        button3.setBorder(new TitledBorder("Reset"));



        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumIntegerDigits(1);
        sliderNumba = new JFormattedTextField(format);

        remainingAlloc = new JTextField();
        remainingAlloc.setEditable(false);
        remainingAlloc.setBorder(new TitledBorder(raisedBorder, "Cost of tokens in currently selected account"));
        remainingAlloc.setFont(new Font("Calibri", Font.BOLD, 15));


        LabelThatUsedtobeTextField8 = new JLabel("Remaining Money");
        LabelThatUsedtobeTextField8.setBorder(raisedBorder);
        LabelThatUsedtobeTextField8.setFont(new Font("Calibri", Font.BOLD, 15));

        valueAdjust = new JTextField();
        valueAdjust.setBorder(raisedBorder);
        valueAdjust.setFont(new Font("Calibri", Font.BOLD, 15));
        valueAdjust.setText("# of tokens = ");
        valueAdjust.setEditable(false);


        textField7 = new JTextField();
        textField7.setPreferredSize(new Dimension(30, 25));
        textField7.setText(Integer.toString(allocation / 100000));
        textField7.setEditable(false);
        textField7.setBorder(new TitledBorder(loweredBorder, "Remaining Money"));
        textField7.setFont(new Font("Calibri", Font.BOLD, 15));

        label7 = new JLabel("Currently Allocated");
        label7.setBorder(raisedBorder);
        label7.setFont(new Font("Calibri", Font.BOLD, 15));




        textFieldUsedtobePanel6 = new JTextField();
        textFieldUsedtobePanel6.setText(Integer.toString(allocation / 100000));
        textFieldUsedtobePanel6.setBorder(new TitledBorder(loweredBorder, "Total Money"));
        textFieldUsedtobePanel6.setFont(new Font("Calibri", Font.BOLD, 15));
        textFieldUsedtobePanel6.setEditable(false);

        label8 = new JLabel("Total Money");
        label8.setBorder(raisedBorder);
        label8.setFont(new Font("Calibri", Font.BOLD, 15));

        empty1 = new JLabel();
        empty2 = new JLabel("You must buy tokens in order from left to right, starting from Account 1.");
        empty3 = new JLabel();



        button1 = new JButton("Submit");
        button1.setToolTipText("Click to submit input selection");
        button1.setBorder(new TitledBorder("Move on"));


        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,1, 5, 5));
        buttonPanel.add(button3);
        buttonPanel.add(button1);


        textFieldUsedtobePanel5 = new JButton("Tokens for sure");
        textFieldUsedtobePanel5.setVisible(true);
        textFieldUsedtobePanel5.setBorder(new TitledBorder(raisedBorder, "Click to buy an equal number of tokens in each account"));
        textFieldUsedtobePanel5.setFont(new Font("Calibri", Font.BOLD, 15));

        panel4 = new JPanel(new GridLayout(2,2,5,5));

        panel4.setBorder(new TitledBorder(raisedBorder, "Token Allocation"));
        //add 3 things

        panel4.add(valueAdjust);
        panel4.add(empty2);
        panel4.add(textFieldUsedtobePanel5);
        panel4.add(textFieldUsedtobePanel6);
        panel4.add(remainingAlloc);
        panel4.add(textField7);


        if (size >= 1) {
            panel3.add(textField);

        }
        if (size >= 2) {
            panel3.add(textField2);
        }
        if (size >= 3) {
            panel3.add(textField3);
        }
        if (size >= 4) {
            panel3.add(textField4);

        }
        if (size >= 5) {
            panel3.add(textField5);
        }
        if(size>=6){
            panel3.add(extraSecur);
        }

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT
        );

        splitPane.setTopComponent(panel);
        splitPane.setBottomComponent(panel4);
        splitPane.setResizeWeight(1);


        sliders = new ArrayList<JSlider>();


        //you can change the first SOUTH -> NORTH && the first CENTER -> SOUTH to get a different spacing/sizing

        panel2.add(splitPane, BorderLayout.CENTER);
        panel2.add(panel3, BorderLayout.NORTH);
        panel2.add(buttonPanel, BorderLayout.SOUTH);
        add(panel2, BorderLayout.CENTER);


        check = false;
        check2 = false;
        check3 = false;
        check4 = false;
        check5 = false;
        check6 = false;
        check7 = false;
        checkExtra = false;



        actionListener5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if (source == textFieldUsedtobePanel5) {
                    panel.removeAll();
                    int totalMoney = allocation;

                    //CHANGE HERE WHEN CHANGING SECURS
                    int numberOfAssets = 6;
                    int[] prices = new int[numberOfAssets];
                    for (int i = 0; i < shareList.size(); i++) {
                        prices[i] = shareList.get(i).getPrice();

                    }
                    double resullt = (equalAlgo(numberOfAssets, totalMoney, prices));
                    int resulllt = (int) resullt;
                    double result = (equalAlgo(numberOfAssets, totalMoney, prices))/1000;
                    System.out.println("rerere " + result);

                    boolean checker = false;
                    boolean checker2 = false;
                    int result3 = 0;
                    String data = Double.toString(result);

                    String splitter = data.substring(data.indexOf("."));



                    if (splitter.length() > 2) {
                        splitter = splitter.substring(0, 3);
                        checker = true;
                    }

                    data = data.substring(0, data.indexOf(".")) + splitter;

                    //case where 2 digit front and decimal back
                    String temp = data.substring(0, 4);
                    String cut = temp.substring(0, temp.indexOf("."));



                    if(cut.length() == 2){
                        double tempResult = Double.parseDouble(data);
                        tempResult = tempResult * 10;
                        String temp2 = Double.toString(tempResult);
                        temp2 = temp2.substring(0, 3);
                        result3 = Integer.parseInt(temp2);
                        checker2 = true;
                    }






                    double newResult = Double.parseDouble(data);
                    double oldResult = newResult;
                    String forTextField = Double.toString(oldResult);
                    newResult = newResult * 10;
                    String data2 = Double.toString(newResult);


                    if(checker) {
                        data2 = data2.substring(0, 2);
                    }
                    else {
                        data2 = data2.substring(0, 3);
                    }


                    int result2 = Integer.parseInt(data2);



                    for (int i = 0; i < shareList.size(); i++) {

                        JSlider jSlider = formatSlider(shareList.get(i).getPrice(), shareList.get(i).getSecurityNumber());
                        jSlider.setEnabled(false);
                        if (i == 0) {
                            jSlider.setEnabled(true);
                        }

                        BoundedRangeModel model = jSlider.getModel();

                        if(checker2){
                            model.setRangeProperties(resulllt, 0, 0, 100000, false);
                        } else {
                            model.setRangeProperties(resulllt, 0, 0, 100000, false);
                        }
                        addShare(jSlider, shareList.get(i).getPrice());
                        panel.repaint();
                        panel.revalidate();

                    }

                    double totalCost = 0;
                    for(int i = 0; i < shareList.size(); i ++){
                        if(checker2){
                            totalCost = totalCost + (shareList.get(i).getPrice() * newResult);
                        } else {
                            totalCost = totalCost + (shareList.get(i).getPrice() * newResult);
                        }
                    }

                    double finalCost = totalCost;
                    if(totalMoney - finalCost <= 0.5){
                        remainingMoney = 0;
                    }




                    String bata = (Double.toString((totalMoney - finalCost)));
                    String bplitter = bata.substring(bata.indexOf("."));
                    if(bplitter.length() > 2){
                        bplitter = bplitter.substring(0, 2);
                    }
                    bata = bata.substring(0, bata.indexOf(".")) + bplitter;

                    if(bata.equals("0.1")){
                        bata = "0.0";
                    }
                    textField7.setText("0.0");


                    if(checker2){
                        v1 = result3;
                        v2 = result3;
                        v3 = result3;
                        v4 = result3;
                        v5 = result3;
                        v6 = result3;


                        d1 = Double.parseDouble(forTextField);
                        d2 = Double.parseDouble(forTextField);
                        d3 = Double.parseDouble(forTextField);
                        d4 = Double.parseDouble(forTextField);
                        d5 = Double.parseDouble(forTextField);
                        d6 = Double.parseDouble(forTextField);
                        remainingMoney = 0;




                    } else {
                        v1 = result2;
                        v2 = result2;
                        v3 = result2;
                        v4 = result2;
                        v5 = result2;
                        v6 = result2;

                        d1 = Double.parseDouble(forTextField);
                        d2 = Double.parseDouble(forTextField);
                        d3 = Double.parseDouble(forTextField);
                        d4 = Double.parseDouble(forTextField);
                        d5 = Double.parseDouble(forTextField);
                        d6 = Double.parseDouble(forTextField);
                        remainingMoney = 0;


                    }


                    textField.setText("Tokens in account #"  + 1 + " = " + forTextField);
                    textField2.setText("Tokens in account #" + 2 + " = " + forTextField);
                    textField3.setText("Tokens in account #" + 3 + " = " + forTextField);
                    textField4.setText("Tokens in account #" + 4 + " = " + forTextField);
                    textField5.setText("Tokens in account #" + 5 + " = " + forTextField);
                    extraSecur.setText("Tokens in account #" + 6 + " = " + forTextField);


                    check = true;
                    check2 = true;
                    check3 = true;
                    check4 = true;
                    check5 = true;
                    check6 = true;
                    check7 = true;
                    checkExtra = true;



                }
            }

        };


        textFieldUsedtobePanel5.addActionListener(actionListener5);


        changelistener = new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                JSlider source = (JSlider) event.getSource();
                int allocation2 = Integer.parseInt(ResourceBundle.getBundle("resources/systemdata").getString("incomeHave" + test.getCurrent())) * 100;
                if (!source.getValueIsAdjusting()) {
                    int value = source.getValue();
                    int cost = 0;
                    int price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

                    Double valueD = Double.parseDouble(Integer.toString(source.getValue()));
                    String name = source.getName();

                    if (name.equals("1")) {
                        setSliders(source);
                        v1 = value;
                        System.out.println("v1 " + v1);
                        double equal = (double) source.getValue() / 1000;
                        textField.setText("Tokens in account #" + source.getName() + " = " + Double.toString(equal));

                        cost = v1 * price;  //remaining money bug is here
                        System.out.println("cost " + cost);
                        remainingMoney = remainingMoney - (cost);
                        System.out.println("remaining money " + remainingMoney);

                        Share share1 = new Share(shareList.get(Integer.parseInt(source.getName()) -1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
                        shareList.remove(0);
                        shareList.add(0, share1);
                        int temp = shareList.get(Integer.parseInt(name)).getPrice();
                        int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
                        JSlider s = formatSlider2(temp, temp2);
                        BoundedRangeModel model = s.getModel();



                        if (remainingMoney < temp) {
                            //value, extent (max-numinput),min, max
                            model.setRangeProperties(10000, 90000, 0, 100000, false);
                            v2=0;
                            v22 = remainingMoney*10/temp;
                            v22 = v22/ 10;
                            System.out.println("In if statement 1 secur 1 " + v11);
                        } else if ((remainingMoney / temp) > (v1)) {
                            model.setRangeProperties(v1,100000-(v1), 0, 100000, false);
                            System.out.println("In if statement 2 secur 1" );
                        } else {
                            model.setRangeProperties((remainingMoney/temp), 100000 - (remainingMoney / temp), 0, 100000, false);
                            System.out.println("In if statement 3 secur 1 ");
                        }

                        int tempForTextField = allocation2 - cost;
                        //look here

                        //     textFieldUsedtobePanel5.setText(Double.toString(equal * (cost/100)));
                        int tempForRemainingMoneyTextField = tempForTextField;
                        //         textField7.setText(Integer.toString(tempForRemainingMoneyTextField));

                        remainingAlloc.setText("Account #" + name + " = " + "");


                        panel.removeAll();
                        addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
                        addShare(s, temp);
                        if(resetPressed){
                            recreate2((Integer.parseInt(name)), 100 - v1);

                        }
                        else {
                            recreate((Integer.parseInt(name)), 100 - v1);

                        }

                        panel.revalidate();
                        panel.repaint();
                        s1 = source;
                        s1Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();
                        check = true;
                        check6 = true;


                        source.setEnabled(false);

                    }
                    if (name.equals("2")) {
                        v2 = value;
                        System.out.println("v2 " + v2);
                        double equal = (double) source.getValue() / 1000;
                        textField2.setText("Tokens in account #" + source.getName() + " = " + Double.toString(equal));
                        cost = v2 * price;
                        System.out.println("cost " + cost);
                        remainingMoney = remainingMoney -(cost);
                        System.out.println("remaining money " + remainingMoney);
                        Share share2 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
                        shareList.remove(1);
                        shareList.add(1, share2);
                        setSliders(source);

                        int temp = shareList.get(Integer.parseInt(name)-1).getPrice();
                        int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
                        JSlider s = formatSlider2(temp, temp2);
                        BoundedRangeModel model = s.getModel();
                        if(remainingMoney < temp){
                            //value, extent (max-numinput),min, max
                            model.setRangeProperties(0, allocation2 - 10, 0, 100000, false);
                            v3=0;
                            v33 = remainingMoney*10/temp;
                            v33 = v33/ 10;
                            System.out.println("In if statement 1 secur 2 " + v22);
                        }
                        else if(remainingMoney/temp > (v2)){
                            model.setRangeProperties(v2,100000-(v2), 0, 100000, false);
                            System.out.println("In if statement 2 secur 2");
                        }
                        else{
                            model.setRangeProperties((remainingMoney/temp), 100000 - (remainingMoney / temp), 0, 100000, false);
                            System.out.println("In if statement 3 secur 2");
                        }

                        double tempForTextField = Double.parseDouble(textField7.getText()) - cost;
                        //  double tempV = Double.parseDouble(textFieldUsedtobePanel5.getText()) + (equal * (cost/100));


                        // textFieldUsedtobePanel5.setText(Double.toString(tempV));
                        double tempForRemainingMoneyTextField = tempForTextField;
                        //                    textField7.setText(Integer.toString(tempForRemainingMoneyTextField));
                        remainingAlloc.setText("Account #" + name + " = " + "");

                        panel.removeAll();
                        addShare(s1, s1Price);
                        addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
                        addShare(s,temp);
                        if(resetPressed){
                            recreate2((Integer.parseInt(name)), 100 - v1 - v2);
                        }
                        else {
                            recreate((Integer.parseInt(name)), 100 - v1 - v2);
                        }

                        panel.revalidate();
                        panel.repaint();
                        s2 =source;
                        s2Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

                        check2 = true;
                        source.setEnabled(false);
                    }
                    if (name.equals("3")) {
                        v3 = value;
                        System.out.println("v3 " + v3);
                        double equal = (double) source.getValue() / 1000;
                        cost = v3 * price;
                        System.out.println("cost " + cost);
                        remainingMoney = remainingMoney -(cost);
                        System.out.println("remaining money " + remainingMoney);
                        textField3.setText("Tokens in account #" + source.getName() + " = " + Double.toString(equal));
                        Share share3 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
                        shareList.remove(2);
                        shareList.add(2, share3);
                        setSliders(source);
                        System.out.println(" v3 " + v3);
                        int temp = shareList.get(Integer.parseInt(name)).getPrice();
                        int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
                        JSlider s = formatSlider2(temp, temp2);
                        BoundedRangeModel model = s.getModel();

                        if(remainingMoney < temp){
                            //value, extent (max-numinput),min, maxSystem.out.println("1");
                            System.out.println("1");


                            model.setRangeProperties(0, allocation2 - 10, 0, 100000, false);
                            v4=0;
                            v44 = remainingMoney*10/temp;
                            v44 = v44/ 10;
                            System.out.println("In if statement 1 secur 3 " + v33);
                        }
                        else if(remainingMoney/temp > (v3)){
                            System.out.println("In if statement 2 secur 3");
                            model.setRangeProperties(v3,100000-(v3), 0, 100000, false);
                        }
                        else{
                            System.out.println("In if statement 3 secur 3");
                            model.setRangeProperties((remainingMoney/temp), 100000 - (remainingMoney / temp), 0, 100000, false);
                        }


                        double tempForTextField = Double.parseDouble(textField7.getText()) - cost;
                        //    double tempV = Double.parseDouble(textFieldUsedtobePanel5.getText()) + (equal * (cost/100));


                        //   textFieldUsedtobePanel5.setText(Double.toString(tempV));
                        double tempForRemainingMoneyTextField = tempForTextField;
                        //                    textField7.setText(Integer.toString(tempForRemainingMoneyTextField));
                        remainingAlloc.setText("Account #" + name + " = " + "");
                        panel.removeAll();
                        addShare(s1, s1Price);
                        addShare(s2, s2Price);
                        addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
                        addShare(s,temp);
                        if(resetPressed){
                            recreate2((Integer.parseInt(name)), 100 - v1 - v2 - v3);
                        }
                        else {
                            recreate((Integer.parseInt(name)), 100 - v1 - v2 - v3);
                        }

                        panel.revalidate();
                        panel.repaint();
                        s3 =source;
                        s3Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

                        check3 = true;
                        source.setEnabled(false);
                    }
                    if (name.equals("4")) {
                        v4 = value;
                        System.out.println(" v4 " + v4);

                        double equal = (double) source.getValue() / 1000;

                        cost = v4 * price;
                        System.out.println(" cost " + cost);
                        remainingMoney = remainingMoney -(cost);
                        System.out.println(" RM " + remainingMoney);
                        textField4.setText("Tokens in account #" + source.getName() + " = " + Double.toString(equal));
                        Share share4 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
                        shareList.remove(3);
                        shareList.add(3, share4);
                        setSliders(source);

                        int temp = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();
                        int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
                        JSlider s = formatSlider2(temp, temp2);
                        BoundedRangeModel model = s.getModel();

                        System.out.println(" v4 " + value + " RM " + remainingMoney + " temp " + temp + " price " + price);


                        if(remainingMoney < temp){
                            //value, extent (max-numinput),min, max
                            model.setRangeProperties(0, allocation2 - 10, 0, 100000, false);
                            v5=0;
                            v55 = remainingMoney*10/temp;
                            v55 = v55/ 10;
                            System.out.println("better be here" + v22);
                        }
                        else if(remainingMoney/temp > (v4)){
                            model.setRangeProperties(v4,100000-(v4), 0, 100000, false);
                            System.out.println("2");
                        }
                        else{
                            model.setRangeProperties((remainingMoney / temp), 100000 - (remainingMoney / temp), 0, 100000, false);

                        }

                        double tempForTextField = Double.parseDouble(textField7.getText()) - cost;
                        //       double tempV = Double.parseDouble(textFieldUsedtobePanel5.getText()) + (equal *(cost/100));



                        //    textFieldUsedtobePanel5.setText(Double.toString(tempV));
                        double tempForRemainingMoneyTextField = tempForTextField;
                        //                     textField7.setText(Integer.toString(tempForRemainingMoneyTextField));
                        remainingAlloc.setText("Account #" + name + " = " + "");

                        panel.removeAll();
                        addShare(s1, s1Price);
                        addShare(s2, s2Price);
                        addShare(s3, s3Price);
                        addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
                        addShare(s,temp);
                        if(resetPressed){
                            recreate2((Integer.parseInt(name)), 100 - v1 - v2 - v3 - v4);
                        }
                        else {
                            recreate((Integer.parseInt(name)), 100 - v1 - v2 - v3 - v4);
                        }

                        panel.revalidate();
                        panel.repaint();
                        s4 =source;
                        s4Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

                        check4 = true;
                        source.setEnabled(false);
                    }
                    if (name.equals("5")) {
                        v5 = value;
                        double equal = (double) source.getValue() / 1000;
                        cost = v5 * price;
                        remainingMoney = remainingMoney -(cost);
                        textField5.setText("Tokens in account #" + source.getName() + " = " + Double.toString(equal));
                        Share share5 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
                        shareList.remove(4);
                        shareList.add(4, share5);
                        setSliders(source);

                        int temp = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();
                        int temp2 = shareList.get(Integer.parseInt(name)).getSecurityNumber();
                        JSlider s = formatSlider2(temp, temp2);
                        BoundedRangeModel model = s.getModel();

                        if(remainingMoney < temp){
                            //value, extent (max-numinput),min, max
                            model.setRangeProperties(0, allocation2 - 10, 0, 100000, false);
                            v6=0;
                            v66 = remainingMoney*10/temp;
                            v66 = v66/ 10;

                        }
                        else if(remainingMoney/temp > (v5)){
                            model.setRangeProperties(v5,100000-(v5), 0, 100000, false);
                        }
                        else{
                            model.setRangeProperties((remainingMoney/temp), 100000 - (remainingMoney / temp), 0, 100000, false);
                        }

                        double tempForTextField = Double.parseDouble(textField7.getText()) - cost;
                        //       double tempV = Double.parseDouble(textFieldUsedtobePanel5.getText()) + (equal *(cost/100));



                        //    textFieldUsedtobePanel5.setText(Double.toString(tempV));
                        double tempForRemainingMoneyTextField = tempForTextField;
                        //                     textField7.setText(Integer.toString(tempForRemainingMoneyTextField));
                        remainingAlloc.setText("Account #" + name + " = " + "");

                        panel.removeAll();
                        addShare(s1, s1Price);
                        addShare(s2, s2Price);
                        addShare(s3, s3Price);
                        addShare(s4, s4Price);
                        addShare(source, shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());
                        addShare(s,temp);
                        if(resetPressed){
                            recreate2((Integer.parseInt(name)), 100 - v1 - v2 - v3 - v4 - v5);
                        }
                        else {
                            recreate((Integer.parseInt(name)), 100 - v1 - v2 - v3 - v4 - v5);
                        }

                        panel.revalidate();
                        panel.repaint();
                        s5 =source;
                        s5Price = shareList.get(Integer.parseInt(source.getName()) - 1).getPrice();

                        check5 = true;
                        source.setEnabled(false);
                    }

                    if (name.equals("6")) {
                        v6 = value;
                        double equal = (double) source.getValue() / 1000;
                        cost = v6 * price;
                        remainingMoney = remainingMoney -(cost);
                        extraSecur.setText("Tokens in account #" + source.getName() + " = " + Double.toString(equal));
                        Share share6 = new Share(shareList.get(Integer.parseInt(source.getName()) - 1).getPrice(), shareList.get(Integer.parseInt(source.getName()) - 1).getSecurityNumber(), valueD);
                        shareList.remove(5);
                        shareList.add(5, share6);
                        setSliders(source);

                        double tempForTextField = Double.parseDouble(textField7.getText()) - cost;
                        //      double tempV = Double.parseDouble(textFieldUsedtobePanel5.getText()) + (equal * (cost/100));

                        //     textFieldUsedtobePanel5.setText(Double.toString(tempV));
                        double tempForRemainingMoneyTextField = tempForTextField;
                        //                       textField7.setText(Integer.toString(tempForRemainingMoneyTextField));
                        remainingAlloc.setText("Account #" + name + " = " + "");
                        checkExtra = true;
                        source.setEnabled(false);

                        panel.revalidate();
                        panel.repaint();
                    }
                }

            }
        };


        changelistener2 = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (source.getValueIsAdjusting()){


                    double equal = (double) source.getValue()  / 1000;
                    double equal2 = (double) source.getValue();






                    valueAdjust.setText("# of tokens = " + Double.toString(equal));
                    double temp2 = ((equal*1000)  *   shareList.get(Integer.parseInt(source.getName()) - 1).getPrice());

                    double temp3 = ((remainingMoney) - temp2)/100000;
                    if(temp3 < 0){
                        temp3 = 0;
                    }
                    String data = Double.toString(temp3);
                    String splitter = data.substring(data.indexOf("."));

                    if(splitter.length() > 2){
                        splitter = splitter.substring(0, 3);
                    }

                    data = data.substring(0, data.indexOf(".")) + splitter;



                    String data2 = Double.toString(temp2/100000);
                    String splitter2 = data2.substring(data2.indexOf("."));

                    if(splitter2.length() > 2){
                        splitter2 = splitter2.substring(0, 3);
                    }


                    data2 = data2.substring(0, data2.indexOf(".")) + splitter2;
                    textField7.setText(data);

                    remainingAlloc.setText("Account #" + source.getName() + " = " + data2);

                }

            }
        };



        //File stuffz

        file = new File(directory, filename);


        action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(redirect){
                    remainingMoney = 0;
                    check6 = true;
                }


                //check if check allocations button is cleared, if it isnt cleared throw an error
                if (!check6) {
                    JOptionPane.showMessageDialog(null, "Please correct allocations", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (remainingMoney > 90) {
                    System.out.println("remains " + remainingMoney);
                    JOptionPane.showMessageDialog(null, "You did not use all your money. Please correct allocations", "Error", JOptionPane.ERROR_MESSAGE);

                    return;
                }

                int result = JOptionPane.showConfirmDialog(null,
                        "Confirm Choices?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (result != 0) {
                    return;
                }

                anotherShareList = new ArrayList<Share>(shareList.size());

                if (check7) {
                    if (shareList.size() == 1) {
                        Share share = new Share(shareList.get(0).getPrice(), 1, d1);
                        anotherShareList.add(share);


                    } }else {

                    if (shareList.size() == 1) {
                        Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1 / 10)));
                        anotherShareList.add(share);

                    }
                }



                if (check7) {
                    if (shareList.size() == 2) {
                        Share share = new Share(shareList.get(0).getPrice(), 1, d1);
                        anotherShareList.add(share);
                        Share share2 = new Share(shareList.get(1).getPrice(), 2, d2);
                        anotherShareList.add(share2);


                    }} else {

                    if (shareList.size() == 2) {
                        Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1 / 10)));
                        anotherShareList.add(share);
                        Share share2 = new Share(shareList.get(1).getPrice(), 2, Double.parseDouble(Integer.toString(v2 / 10)));
                        anotherShareList.add(share2);


                    }
                }



                if (check7) {
                    if (shareList.size() == 3) {
                        Share share = new Share(shareList.get(0).getPrice(), 1, d1);
                        anotherShareList.add(share);
                        Share share2 = new Share(shareList.get(1).getPrice(), 2, d2);
                        anotherShareList.add(share2);
                        Share share3 = new Share(shareList.get(2).getPrice(), 3, d3);
                        anotherShareList.add(share3);


                    }
                } else {

                    if (shareList.size() == 3) {
                        Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1 / 10)));
                        anotherShareList.add(share);
                        Share share2 = new Share(shareList.get(1).getPrice(), 2, Double.parseDouble(Integer.toString(v2 / 10)));
                        anotherShareList.add(share2);
                        Share share3 = new Share(shareList.get(2).getPrice(), 3, Double.parseDouble(Integer.toString(v3 / 10)));
                        anotherShareList.add(share3);

                    }
                }



                if (check7) {
                    if (shareList.size() == 4) {
                        Share share = new Share(shareList.get(0).getPrice(), 1, d1);
                        anotherShareList.add(share);
                        Share share2 = new Share(shareList.get(1).getPrice(), 2,d2);
                        anotherShareList.add(share2);
                        Share share3 = new Share(shareList.get(2).getPrice(), 3, d3);
                        anotherShareList.add(share3);
                        Share share4 = new Share(shareList.get(3).getPrice(), 4, d4);
                        anotherShareList.add(share4);


                    }
                } else {
                    if (shareList.size() == 4) {
                        Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1 / 10)));
                        anotherShareList.add(share);
                        Share share2 = new Share(shareList.get(1).getPrice(), 2, Double.parseDouble(Integer.toString(v2 / 10)));
                        anotherShareList.add(share2);
                        Share share3 = new Share(shareList.get(2).getPrice(), 3, Double.parseDouble(Integer.toString(v3 / 10)));
                        anotherShareList.add(share3);
                        Share share4 = new Share(shareList.get(3).getPrice(), 4, Double.parseDouble(Integer.toString(v4 / 10)));
                        anotherShareList.add(share4);


                    }
                }

                if(check7) {
                    if (shareList.size() == 5) {
                        Share share = new Share(shareList.get(0).getPrice(), 1, d1);
                        anotherShareList.add(share);
                        Share share2 = new Share(shareList.get(1).getPrice(), 2, d2);
                        anotherShareList.add(share2);
                        Share share3 = new Share(shareList.get(2).getPrice(), 3, d3);
                        anotherShareList.add(share3);
                        Share share4 = new Share(shareList.get(3).getPrice(), 4, d4);
                        anotherShareList.add(share4);
                        Share share5 = new Share(shareList.get(4).getPrice(), 5, d5);
                        anotherShareList.add(share5);


                    }
                } else {


                    if (shareList.size() == 5) {
                        Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1 / 10)));
                        anotherShareList.add(share);
                        Share share2 = new Share(shareList.get(1).getPrice(), 2, Double.parseDouble(Integer.toString(v2 / 10)));
                        anotherShareList.add(share2);
                        Share share3 = new Share(shareList.get(2).getPrice(), 3, Double.parseDouble(Integer.toString(v3 / 10)));
                        anotherShareList.add(share3);
                        Share share4 = new Share(shareList.get(3).getPrice(), 4, Double.parseDouble(Integer.toString(v4 / 10)));
                        anotherShareList.add(share4);
                        Share share5 = new Share(shareList.get(4).getPrice(), 5, Double.parseDouble(Integer.toString(v5 / 10)));
                        anotherShareList.add(share5);


                    }
                }    if(check7) {
                    if (shareList.size() == 6) {
                        Share share = new Share(shareList.get(0).getPrice(), 1, d1);
                        anotherShareList.add(share);
                        Share share2 = new Share(shareList.get(1).getPrice(), 2, d2);
                        anotherShareList.add(share2);
                        Share share3 = new Share(shareList.get(2).getPrice(), 3, d3);
                        anotherShareList.add(share3);
                        Share share4 = new Share(shareList.get(3).getPrice(), 4, d4);
                        anotherShareList.add(share4);
                        Share share5 = new Share(shareList.get(4).getPrice(), 5, d5);
                        anotherShareList.add(share5);
                        Share share6 = new Share(shareList.get(5).getPrice(), 6, d6);
                        anotherShareList.add(share6);


                    }
                } else {



                    if (shareList.size() == 6) {
                        Share share = new Share(shareList.get(0).getPrice(), 1, Double.parseDouble(Integer.toString(v1 / 10)));
                        anotherShareList.add(share);
                        Share share2 = new Share(shareList.get(1).getPrice(), 2, Double.parseDouble(Integer.toString(v2 / 10)));
                        anotherShareList.add(share2);
                        Share share3 = new Share(shareList.get(2).getPrice(), 3, Double.parseDouble(Integer.toString(v3 / 10)));
                        anotherShareList.add(share3);
                        Share share4 = new Share(shareList.get(3).getPrice(), 4, Double.parseDouble(Integer.toString(v4 / 10)));
                        anotherShareList.add(share4);
                        Share share5 = new Share(shareList.get(4).getPrice(), 5, Double.parseDouble(Integer.toString(v5 / 10)));
                        anotherShareList.add(share5);
                        Share share6 = new Share(shareList.get(5).getPrice(), 6, Double.parseDouble(Integer.toString(v6 / 10)));
                        anotherShareList.add(share6);


                    }
                }

                allocations.remove(curSysProp - 1);
                allocations.add(curSysProp - 1, anotherShareList);




                if (!file.exists()) {
                    file = new File(directory, filename);
                    fileCreator(file);
                }
                if (check) {
                    filer = createFileWriter(file);
                    formatFile(filer);
                    for (Share share : anotherShareList) {
                        writeToFile(filer, share);
                    }
                    closeFile(filer);


                    if (test.getCurrent() == 1) {


                        file1 = new File(adminDirectory, filename1);
                        fileCreator(file1);

                        if (!file1.exists()) {
                            file1 = new File(adminDirectory, filename1);
                            fileCreator(file1);
                        }

                        filer1 = createFileWriter(file1);

                        for (Share share : anotherShareList) {
                            writeToFile2(filer1, share);
                        }
                        closeFile(filer1);


                    } else if (test.getCurrent() == 2) {

                        file2 = new File(adminDirectory, filename2);
                        fileCreator(file2);

                        if (!file2.exists()) {
                            file2 = new File(adminDirectory, filename2);
                            fileCreator(file2);
                        }

                        filer2 = createFileWriter(file2);

                        for (Share share : anotherShareList) {
                            writeToFile2(filer2, share);
                        }
                        closeFile(filer2);


                    } else if (test.getCurrent() == 3) {

                        file3 = new File(adminDirectory, filename3);
                        fileCreator(file3);

                        if (!file3.exists()) {
                            file3 = new File(adminDirectory, filename3);
                            fileCreator(file3);
                        }

                        filer3 = createFileWriter(file3);

                        for (Share share : anotherShareList) {
                            writeToFile2(filer3, share);
                        }
                        closeFile(filer3);


                    } else if (test.getCurrent() == 4) {




                        file4 = new File(adminDirectory, filename4);
                        fileCreator(file4);

                        if (!file4.exists()) {
                            file4 = new File(adminDirectory, filename4);
                            fileCreator(file4);
                        }

                        filer4 = createFileWriter(file4);

                        for (Share share : anotherShareList) {
                            writeToFile2(filer4, share);
                        }
                        closeFile(filer4);

                    } else if (test.getCurrent() == 5) {


                        file5 = new File(adminDirectory, filename5);
                        fileCreator(file5);

                        if (!file5.exists()) {
                            file5 = new File(adminDirectory, filename5);
                            fileCreator(file5);
                        }

                        filer5 = createFileWriter(file5);

                        for (Share share : anotherShareList) {
                            writeToFile2(filer5, share);
                        }
                        closeFile(filer5);


                    } else if (test.getCurrent() == 6) {

                        file6 = new File(adminDirectory, filename6);
                        fileCreator(file6);

                        if (!file6.exists()) {
                            file6 = new File(adminDirectory, filename6);
                            fileCreator(file6);
                        }

                        filer6 = createFileWriter(file6);

                        for (Share share : anotherShareList) {
                            writeToFile2(filer6, share);
                        }
                        closeFile(filer6);


                    } else if (test.getCurrent() == 7) {

                        file7 = new File(adminDirectory, filename7);
                        fileCreator(file7);

                        if (!file7.exists()) {
                            file7 = new File(adminDirectory, filename7);
                            fileCreator(file7);
                        }

                        filer7 = createFileWriter(file7);

                        for (Share share : anotherShareList) {
                            writeToFile2(filer7, share);
                        }
                        closeFile(filer7);


                    } else if (test.getCurrent() == 8) {




                        file8 = new File(adminDirectory, filename8);
                        fileCreator(file8);

                        if (!file8.exists()) {
                            file4 = new File(adminDirectory, filename8);
                            fileCreator(file8);
                        }

                        filer8 = createFileWriter(file8);

                        for (Share share : anotherShareList) {
                            writeToFile2(filer8, share);
                        }
                        closeFile(filer8);

                    } else if (test.getCurrent() == 9) {




                        file9 = new File(adminDirectory, filename9);
                        fileCreator(file9);

                        if (!file9.exists()) {
                            file9 = new File(adminDirectory, filename9);
                            fileCreator(file9);
                        }

                        filer9 = createFileWriter(file9);

                        for (Share share : anotherShareList) {
                            writeToFile2(filer9, share);
                        }
                        closeFile(filer9);

                    }
                    else if (test.getCurrent() == 10) {

                        file10 = new File(adminDirectory, filename10);
                        fileCreator(file10);

                        if (!file10.exists()) {
                            file10 = new File(adminDirectory, filename10);
                            fileCreator(file10);
                        }

                        filer10 = createFileWriter(file10);

                        for (Share share : anotherShareList) {
                            writeToFile2(filer10, share);
                        }
                        closeFile(filer10);

                    }




                    phase1Rewind.this.setVisible(false);
                    phase1Rewind.this.dispose();
                    cur.remove(1);


                    if(cur.size() == 1) {

                        JOptionPane.showMessageDialog(null,  "You are finisihed the experiment!, You can view your final allocations in the next window", "Completed Stage 4",
                                JOptionPane.INFORMATION_MESSAGE);


                        finalPage fini = new finalPage(allocations, myshare , ratio, tunnel, stg3, true);
                        //  phases.setVisible(false);
                        fini.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        fini.setVisible(true);
                    }
                    else {


                        phase1Rewind phases = new phase1Rewind(allocations, anotherShareList, cur, myshare, ratio, tunnel, stg3, true);

                        phases.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        phases.setVisible(true);

                    }

                } else {
                    error(e);
                }

            }
        };


        button1.addActionListener(action);


        //create as many slider instances of the size of 'shares'
        for (int i = 0; i < shareList.size(); i++) {
            int priceofsecurity = shareList.get(i).getPrice();
            JSlider jSlider = formatSlider(shareList.get(i).getPrice(), shareList.get(i).getSecurityNumber());

            jSlider.setEnabled(false);
            if(i == 0){
                jSlider.setEnabled(true);
                BoundedRangeModel model = jSlider.getModel();
                v1 = 10000000 / shareList.get(i).getPrice();
                model.setRangeProperties(0, 100000- (10000000 / shareList.get(i).getPrice()), 0, 100000, false);
            }

            else {
                BoundedRangeModel model = jSlider.getModel();
                model.setRangeProperties(0, 0, 0, 100000, false);
            }
            addShare(jSlider, shareList.get(i).getPrice());
        }


    }


    public void addShare(JSlider slider, int price) {
        slider.addChangeListener(changelistener);
        slider.addChangeListener(changelistener2);
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(1,2,5,5));
        pan.add(slider);


        panel.add(pan);

    }

    public JSlider formatSlider(int price, int number) {
        JSlider slider = new JSlider(JSlider.VERTICAL);
        BoundedRangeModel model = slider.getModel();
        model.setRangeProperties(0,1,0,100000,false);
        slider.setName(Integer.toString(number));
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(2);
        slider.setPreferredSize(new Dimension(100, 350));
        double newPrice = Double.parseDouble(String.valueOf(price));
        slider.setBorder(new TitledBorder("Tokens in account " + Integer.toString(number) + " | Price = " + (newPrice/100)));
        slider.setPaintLabels(true);
        java.util.Hashtable<Integer, JLabel> labelTable = new java.util.Hashtable<Integer, JLabel>();
        labelTable.put(new Integer(100000), new JLabel("100"));
        labelTable.put(new Integer(80000), new JLabel("80"));
        labelTable.put(new Integer(60000), new JLabel("60"));
        labelTable.put(new Integer(40000), new JLabel("40"));
        labelTable.put(new Integer(20000), new JLabel("20"));
        labelTable.put(new Integer(0), new JLabel("0"));
        slider.setLabelTable(labelTable);

        // slider.add(new JLabel(Integer.toString(price)));
        return slider;

    }


    public JSlider formatSlider2(int price, int number) {
        JSlider slider = new JSlider(JSlider.VERTICAL);
        BoundedRangeModel model = slider.getModel();
        model.setRangeProperties(0,1,0,100000,false);
        slider.setName(Integer.toString(number));
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(2);
        slider.setPreferredSize(new Dimension(100, 350));
        double newPrice = Double.parseDouble(String.valueOf(price));
        slider.setBorder(new TitledBorder("Tokens in account " + Integer.toString(number) + " | Price = " + (newPrice/100)));
        slider.setPaintLabels(true);
        java.util.Hashtable<Integer, JLabel> labelTable = new java.util.Hashtable<Integer, JLabel>();
        labelTable.put(new Integer(100000), new JLabel("100"));
        labelTable.put(new Integer(80000), new JLabel("80"));
        labelTable.put(new Integer(60000), new JLabel("60"));
        labelTable.put(new Integer(40000), new JLabel("40"));
        labelTable.put(new Integer(20000), new JLabel("20"));
        labelTable.put(new Integer(0), new JLabel("0"));
        slider.setLabelTable(labelTable);

        // slider.add(new JLabel(Integer.toString(price)));
        return slider;

    }


    public int remainingIncome(int allocation, int value, int price) {
        float v = (float) value / 100;
        setTotal(allocation - v * price);
        return allocation - value * price;
    }


    public double equalAlgo(int numberOfAssets, int totalMoney, int[] prices){
        double sum = 0;

        for(int price: prices){
            sum = sum + price;


        }

        double averagePrice = sum / numberOfAssets;
        double itemTotal = totalMoney / averagePrice;
        double result = itemTotal / numberOfAssets;


        return result;
    }


    public void setTotal(float remains) {
        float temp = Math.round(remains);
        int r = (int) temp;
        total = r;
    }

    public int getTotal() {
        return total;
    }


    public void error(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Please complete allocations", "Error", JOptionPane.ERROR_MESSAGE);
    }


    public void setSliders(JSlider slid) {
        if(sliders.isEmpty()){
            sliders.add(slid);
            return;
        }
        if(sliders.contains(slid)){
            for(int i = 0; i < sliders.size(); i++){
                if((sliders.get(i).getName()) == slid.getName()){
                    sliders.remove(sliders.get(i));
                    sliders.add(i, slid);
                    System.out.println("value of replaceed slider " + sliders.get(i).getValue());
                    return;
                }
            }
        }
        else{
            sliders.add(slid);
            for(int i = sliders.size()-1; i > 0; i--){
                System.out.println("I'm outside if statement");
                if((Integer.parseInt(sliders.get(i).getName())) < (Integer.parseInt(sliders.get(i-1).getName()))){
                    System.out.println("this is before change " + sliders.get(i).getName() + " " + sliders.get(i-1).getName());
                    swapSliders(i, i-1);
                    System.out.println("this is after change " + sliders.get(i).getName() + " " + sliders.get(i-1).getName());
                }
            }
        }

    }

    public void swapSliders(int pos1, int pos2){
        JSlider tempSlid;
        JSlider tempSlid2;
        tempSlid = sliders.get(pos1);
        tempSlid2 = sliders.get(pos2);
        sliders.remove(sliders.get(pos1));
        sliders.add(pos1, tempSlid2);
        sliders.remove(sliders.get(pos2));
        sliders.add(pos2, tempSlid);
    }

    public List<JSlider> getSliders() {
        return sliders;
    }


    //make a file, make a directory to place the file
    //write the output to the file passed to it by the slider info

    public void fileCreator(File file) {
        try {
            if (file.createNewFile()) {
                System.out.println("check your desktop thats where dat file be");
            } else {
                System.out.println("you already have this file playa");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public FileWriter createFileWriter(File file) {
        try {
            FileWriter fileWrite = new FileWriter(file, true);
            //    System.out.println("here so this is good");
            return fileWrite;
        } catch (IOException e) {
            // System.out.println("here so were screwed");
            return null;
        }


    }


    public void formatFile(FileWriter filer) {
        test = new testClass(curSysProp);
        try {
            filer.write("\n" + "Stage 1 via Stage 4: Round " + test.getCurrent() + "\n");
        } catch (IOException e) {
            System.out.println("new file code failed");
        }


    }



    public void writeToFile(FileWriter filer, Share share) {
        try {
            filer.write("\n" + "Account number = " + share.getSecurityNumber() + " Account price = " + share.getPrice() +
                    " Account Allocation = " + share.getAllocation() + "\n");

        } catch (IOException e) {
            System.out.println("failed hurr");
        }

    }



    public void writeToFile2(FileWriter filer, Share share) {
        try {
            filer.write("\n" + "@" + "%" + share.getSecurityNumber() + "%" + "$" + share.getPrice() + "$" + "^" + share.getIncomeShare() + "^" +
                    "#" + share.getAllocation() + "#" + "*");

        } catch (IOException e) {
            System.out.println("failed hurr");
        }

    }


    public void closeFile(FileWriter filer){
        try {
            filer.flush();
            filer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void setMinVal(int x){
        minimumShare = x;
    }

    public int getMinVal(){
        return minimumShare;
    }




    public void recreate(int num, int limit){
        int t = shareList.size();
        for (int i = num + 1; i < t ; i++) {
            JSlider sl = formatSlider2(shareList.get(i).getPrice(), i + 1);
            sl.setEnabled(false);
            BoundedRangeModel model = sl.getModel();
            //value, extent, min max
            model.setRangeProperties(0,limit,0,100000,false);
            addShare(sl, shareList.get(i - 1).getPrice());
        }
    }
    public void recreate2(int num, int limit){
        int t = shareList.size();
        for (int i = num+1; i < t; i++) {

            JSlider sl = formatSlider2(shareList.get(i).getPrice(), i + 1);
            sl.setEnabled(false);
            BoundedRangeModel model = sl.getModel();
            //value, extent, min max
            if(i==2){
                model.setRangeProperties(m3,limit,0,100000,false);
            }
            if(i==3){
                model.setRangeProperties(m4,limit,0,100000,false);
            }
            if(i==4){
                model.setRangeProperties(m5,limit,0,100000,false);
            }
            if(i==5){
                model.setRangeProperties(m6,limit,0,100000,false);
            }
            addShare(sl, shareList.get(i -1).getPrice());
        }
    }




    public static void main(String[] args) throws Exception {
        params = new parameters();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                // openingPage open = new openingPage();
                //open.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                // open.setVisible(true);


                System.out.println("how many times have i been here?");
                testClass test = new testClass(1);
                //uncomment slider to run from stage2 and uncomment phase1 to run from phase1
                sliderInterface frame = new sliderInterface(params.getSecurityList(), test.getCurrent(), false, false, false, false, 0, 0.0);
                //phase1 frame = new phase1(params.getSecurityList(), test.getCurrent());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);

            }

        });
    }












}
