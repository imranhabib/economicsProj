package project;

import sun.text.IntHashtable;

import java.security.Security;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Imran on 2014-11-22.
 */

//this class will access the systemDefined variables at the highest level
// Uses a resourceBundle and a properties file

public class parameters {

    ResourceBundle bundle;

  public parameters(){
      bundle = ResourceBundle.getBundle("resources/systemdata");

  }

    public int getAllocation (){
        return Integer.parseInt(bundle.getString("incomeRequired"));

    }

    public int getNumberOfSecurities(){
        return Integer.parseInt(bundle.getString("securityAmount"));


    }

    public ArrayList<Integer> getSecurityPriceList(){
        String price = bundle.getString("securityPriceList");
        String[] priceList = price.split(",");
        ArrayList<Integer> prices = new ArrayList<Integer>();
        for(String str: priceList){
            prices.add(Integer.parseInt(str));
        }
        return prices;
    }

    public ArrayList<Integer> getIncomeShareList(){
        String price = bundle.getString("incomeShare");
        String[] priceList = price.split(",");
        ArrayList<Integer> shares = new ArrayList<Integer>();
        for(String str: priceList){
            shares.add(Integer.parseInt(str));
        }

        return shares;

    }
    public List<Share> getSecurityList(){
        ArrayList<Share> shares = new ArrayList<Share>();
        String security = bundle.getString("securityList");
        String[] securityNumber = security.split(",");
        ArrayList<Integer> securityPrices = getSecurityPriceList();
        //get income share
        ArrayList<Integer> incomeShareList = getIncomeShareList();
        for (int i=1; i <= securityNumber.length; i++) {
            int is = incomeShareList.get(i);
            int sp = securityPrices.get(i);
            Share share = new Share(sp, is, i);
            shares.add(share);
        }
        return shares;

    }

    public int getMeanPriceAmount(){
        String price = bundle.getString("securityPriceList");
        String[] priceList = price.split(",");
        List<Integer> prices = new ArrayList<Integer>();
        for(String str: priceList){
            prices.add(Integer.parseInt(str));
        }
        int sum = 0;
        int amount = prices.size();
        for(int num: prices){
            sum = sum + num;
        }
        return sum/amount;


    }

    public int getReservationRatio(){
        int r = Integer.parseInt(bundle.getString("reservationRatio"));
        return r;


    }


    //n(r) arg max pi/p1 <= r

    public int getArgMaxFormula(int r, int n, List<Integer> prices, List<Integer> securities){
        int argMax = 0;
        int p1 = 0;
        int pi = 0;
        int ratio = 0;
        int count = 0;
        for(int i = 0; i < (prices.size())-1; i++){
            p1 = prices.get(i);
            pi = prices.get(i + 1);
            ratio = pi/p1;
            if(ratio > r){
                argMax = p1;
                count = i;
                break;
            }
            if(ratio == r){
                argMax = pi;
                count = i + 1;
                break;
            }

        }

        return securities.get(count);


    }








}
