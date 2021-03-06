package project;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ihabib on 1/30/2015.
 */
public class choicePage extends JFrame {

    String filename = "heuristic-output.csv";
    File file;
    FileWriter filer;

    static JTextField text1;
    static JTextField text2;
    static JTextField text3;
    static JTextField text4;
    static JTextField text5;

    static JTextArea area1;
    static JTextArea area2;
    static JTextArea area3;

    static JButton button1;
    static JButton button3;

    static JPanel leftpanel;
    static JPanel rightpanel;
    static JPanel bottompanel;

    static JSplitPane mainPanel;
    static JSplitPane bottomPanel;
    String instructions;
    String instructions2;
    String instructions3;


    double r;

    String directory;
    private String newline = "\n";

    static ActionListener buttons;


    List<List<Share>> bothStages;


    public choicePage(List<List<Share>> priceSets, List<List<Share>> priceSets2, final boolean chargeStage3, final boolean chargeStage4) {

        directoryStore  dirStore = new directoryStore();
        directory =  dirStore.getDirectory();

        bothStages = new ArrayList<List<Share>>();
        for (int i = 0; i < priceSets.size(); i++) {
            bothStages.add(priceSets.get(i));
        }

        for (int i = 0; i < priceSets2.size(); i++) {
            bothStages.add(priceSets2.get(i));
        }


        setLayout(new BorderLayout());
        setTitle("Selections");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height - 45);
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);


        instructions3 = "On this page the round that counts for payment and the account that pays on that round will be determined. Please raise your hand and an experimenter will approach you.";

        area3 = new JTextArea(instructions);
        area3.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        area3.setEditable(false);
        area3.setLineWrap(true);
        area3.setWrapStyleWord(true);


        leftpanel = new JPanel(new GridLayout(2, 1, 5, 5));

        instructions = "In the box below, please enter the round that counts for payment.";
        area1 = new JTextArea(instructions);
        area1.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        area1.setEditable(false);
        area1.setLineWrap(true);
        area1.setWrapStyleWord(true);

        text1 = new JTextField();
        text1.setBorder(new TitledBorder("Enter Round Here"));
        button1 = new JButton("Confirm");

        leftpanel.add(area1);
        leftpanel.add(text1);


        rightpanel = new JPanel(new GridLayout(2, 1, 5, 5));

        instructions2 = "In the box below, please enter the account that was selected.";
        area2 = new JTextArea(instructions2);
        area2.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 15));
        area2.setEditable(false);
        area2.setLineWrap(true);
        area2.setWrapStyleWord(true);

        text2 = new JTextField();
        text2.setBorder(new TitledBorder("Enter Account Here"));


        rightpanel.add(area2);
        rightpanel.add(text2);


        mainPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        mainPanel.setLeftComponent(leftpanel);
        mainPanel.setRightComponent(rightpanel);
        mainPanel.setResizeWeight(0.50);
        mainPanel.setBorder(new TitledBorder("Selections"));

        bottompanel = new JPanel(new GridLayout(4, 1, 5, 5));

        text3 = new JTextField();
        text3.setBorder(new TitledBorder("Allocation Amount Selected"));
        text3.setEditable(false);

        text4 = new JTextField();
        text4.setBorder(new TitledBorder("Charges from experiment, if any"));
        text4.setEditable(false);

        text5 = new JTextField();
        text5.setBorder(new TitledBorder("Total Payout"));
        text5.setEditable(false);

        bottompanel.add(button1);
        bottompanel.add(text3);
        bottompanel.add(text4);
        bottompanel.add(text5);

        bottomPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        bottomPanel.setTopComponent(mainPanel);
        bottomPanel.setBottomComponent(bottompanel);
        bottomPanel.setResizeWeight(0.60);

        button3 = new JButton("Exit");

        add(area3, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.CENTER);
        add(button3, BorderLayout.SOUTH);


        buttons = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if (source == button3) {
                    setVisible(false);
                    dispose();
                    Frame framer[] = Frame.getFrames();
                    Frame instrucs = new Frame();
                    for(Frame fr : framer){
                        if(fr.getTitle().equals("Instructions Window")){
                            instrucs = fr;
                        }
                    }
                    instrucs.dispose();

                }

                if (source == button1) {
                    int priceSet = Integer.parseInt(text1.getText()) - 1;
                    int asset = Integer.parseInt(text2.getText()) - 1;

                    List<Share> temp;
                    temp = bothStages.get(priceSet);

                    Share shr = temp.get(asset);
                    double result = shr.getAllocation();


                    String data2 = Double.toString(result);
                    String splitter2 = data2.substring(data2.indexOf("."));

                    if (splitter2.length() > 2) {
                        splitter2 = splitter2.substring(0, 3);
                    }

                    data2 = data2.substring(0, data2.indexOf(".")) + splitter2;

                    String cost = "";
                    if (chargeStage3) {
                        cost = cost + "1 token (Stage 3) ";
                        result = result - 1;
                        r = result;
                    }

                    if (chargeStage4) {
                        cost = cost + "+" + " 1 token (Stage 4)";
                        result = result - 1;
                        r = result;
                    }

                    r = result;
                    String data = Double.toString(result);
                    String splitter = data.substring(data.indexOf("."));

                    if (splitter.length() > 2) {
                        splitter = splitter.substring(0, 3);
                    }

                    data = data.substring(0, data.indexOf(".")) + splitter;

                    text3.setText(data2);


                    text4.setText(cost);
                    text5.setText(data);

                    text1.setEditable(false);
                    text2.setEditable(false);



                    file = new File(directory, filename);
                    if (!file.exists()) {
                        file = new File(directory, filename);
                        fileCreator(file);
                    }


                    filer = createFileWriter(file);

                    formatFile(filer);


                    if(chargeStage3) {
                        writeTotal(filer, 1, 1, 0, Double.parseDouble(text5.getText()));
                    } else if (chargeStage4) {

                        writeTotal(filer, 1, 0, 1, Double.parseDouble(text5.getText()));
                    } else  if(chargeStage3 && chargeStage4) {
                        writeTotal(filer, 2, 1, 1, Double.parseDouble(text5.getText()));

                    } else {
                        writeTotal(filer, 0, 0, 0, Double.parseDouble(text5.getText()));
                    }
                    closeFile(filer);



                }


            }


        };


        button3.addActionListener(buttons);
        button1.addActionListener(buttons);

        JOptionPane.showMessageDialog(null, "On this page the round that counts for payment and the account that pays on that round will be determined. Please raise your hand and an experimenter will approach you.");

        setVisible(true);


    }




    public void fileCreator(File file) {
        try {
            if (file.createNewFile()) {
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public FileWriter createFileWriter(File file) {
        try {
            FileWriter fileWrite = new FileWriter(file, true);
            return fileWrite;
        } catch (IOException e) {
            return null;
        }


    }


    public void formatFile(FileWriter filer) {

        try {
            filer.write("\n" + "Final Round Allocation "  + "\n");
        } catch (IOException e) {
        }


    }


    public void writeTotal(FileWriter filer, int stage, int stage3, int stage4, double total) {
        try {
            filer.write("\n" + "Total Payout before charges, if any  " + stage + " | " + "Charges from Stage 3: " + stage3 + " | " + " Charges for Stage 4: " + stage4 + " Total Payout = " + total + "\n");
        } catch (IOException e) {
            System.out.println("new file code failed");
        }


    }







    public void closeFile(FileWriter filer) {
        try {
            filer.flush();
            filer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

