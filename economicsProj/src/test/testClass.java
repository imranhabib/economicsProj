package test;

import project.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Imran on 2014-11-22.
 */
public class testClass {

    static parameters params;
    static incomeRequired income;
    static allocation allocation;
    static sliderInterface slider;
    static int current;


    public testClass(){
        current = getCurrent();
    }



    public testClass(int current){
        this.current = current;

    }





    public void incrementCurrent(){
        current = current++;
    }

    public int getCurrent(){
        return current;
    }





    public static void main (String[] args) throws Exception {
        params = new parameters();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                testClass test = new testClass(1);
                //uncomment slider to run from stage2 and uncomment phase1 to run from phase1
                //sliderInterface frame = new sliderInterface(params.getSecurityList(), test.getCurrent(), false, 0, 0.0);
                phase1 frame = new phase1(params.getSecurityList(), test.getCurrent());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }

        });








    }
}








