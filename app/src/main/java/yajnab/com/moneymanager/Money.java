package yajnab.com.moneymanager;

import android.text.Editable;

import java.util.Date;

/**
 * Created by yajnab on 25/6/16.
 */
public class Money {
    private int id;
    private String purpose;
    private String type;
    private float amount;
    private String date;
    private float balance;

    public Money(int id, String purpose, String type, float amount, String date, float balance){
        this.id = id;
        this.purpose = purpose;
        this.type=type;
        this.amount=amount;
        this.date=date;
        this.balance = balance;
    }
    public Money(String purpose, String type, float amount, String date, float balance){
        //this.id = id;
        this.purpose = purpose;
        this.type=type;
        this.amount=amount;
        this.date=date;
        this.balance = balance;
    }

    public Money() {

    }

    //Set Functions
    public void setID(int id){
        this.id = id;
    }
    public void setPurpose(String purpose){
        this.purpose=purpose;
    }
    public void setType(String type){
        this.type=type;
    }
    public void setAmount(float amount){
        this.amount=amount;
    }
    public void setDate(String date){
        this.date=date;
    }
    public void setBalance(float balance){this.balance=balance;}
    //Get Functions
    public int getID(){
        return id;
    }
    public String getPurpose(){
        return purpose;
    }
    public String getType(){
        return type;
    }
    public float getAmount(){
        return amount;
    }
    public String getDate(){
        return date;
    }
    public float getBalance(){return balance;}
}
