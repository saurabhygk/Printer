package com.mapper.controller;

import java.util.*;
/**
 * Created by saurabh.yagnik on 2016/10/06.
 */
public class PrinterTest {
          /* Prints a receipt for Mega Store with discount etc. */


/* Instance Variables  */

    Vector items;
    Vector prices;
    Vector quantities;

    /*
        Program description.
    */
    public static void main(String args[]) throws Exception {
	/* Program statements go here. */
        PrinterTest myReceipt=new PrinterTest();

        System.out.println("Welcome to the Mega Store");
        myReceipt.receive();
        myReceipt.sort();
        myReceipt.print();
    }

    public PrinterTest(){
        items=new Vector();
        prices=new Vector();
        quantities=new Vector();
    }
    public void receive() throws Exception {
        String item=" ";
        Float price;
        Integer quantity;
        Scanner sc = new Scanner(System.in);
        while (!item.equals("")) {
            System.out.print("Please enter Item: ");
            item=sc.next();
            if(item.equals("N"))
                break;
            if (item.length() > 0) {
                this.items.addElement(item);
                System.out.print("Please enter price: ");
                price=sc.nextFloat();
                this.prices.addElement(price);
                System.out.print("Please enter quantity: ");
                quantity=sc.nextInt();
                this.quantities.addElement(quantity);
            }
        }
    }
    public void sort() {
        int i;
        int largeIndex;
        for (i=0; i< this.items.size(); i++) {
            largeIndex = this.getLargest(i);
            this.exchange(i, largeIndex);
        }
    }

    private int getLargest(int index){
        int		largestIndex;
        int		i;
        Float price1, price2;

        largestIndex = index;
        for (i = index + 1; i < this.prices.size(); i++){
            price1=(Float)this.prices.elementAt(i);
            price2=(Float)this.prices.elementAt(largestIndex);
            if (price1.floatValue() > price2.floatValue())
                largestIndex = i;
        }
        return largestIndex;
    }

    private void exchange(int a, int b) {
        Float		tempF;
        Integer		tempI;
        String		tempS;

        tempS = (String)this.items.elementAt(a);
        tempF = (Float)this.prices.elementAt(a);
        tempI = (Integer)this.quantities.elementAt(a);

        this.items.setElementAt((String)this.items.elementAt(b),a);
        this.items.setElementAt(tempS,b);

        this.prices.setElementAt((Float)this.prices.elementAt(b),a);
        this.prices.setElementAt(tempF,b);

        this.quantities.setElementAt((Integer)this.quantities.elementAt(b),a);
        this.quantities.setElementAt(tempI,b);

    }

    public void print() {
        Date today=new Date();
        String item=" ";
        Float price;
        final float discount=100.0f;
        Integer quantity;
        float itemtotal;
        float subTotal=0f;
        float tax;
        float theDiscount=0f;
        int i,j,maxSize;
/*printing the header of the receipt*/
        System.out.println("======================");
        System.out.println("     MEGA  STORE");
        System.out.print(today.getDate()+"/");
        System.out.print((today.getMonth()+1)+"/");
        System.out.print((today.getYear()+1900)+" ");
        System.out.print(today.getHours()+":");
        System.out.println(today.getMinutes());
        System.out.println("======================");

/*counting the size of the longest item*/
        item=(String)this.items.elementAt(0);
        maxSize=item.length();
        for (i=1;i<this.items.size();i++){
            item=(String)this.items.elementAt(i);
            if (maxSize<item.length()) {
                maxSize=item.length();
            }
        }
/*printing the lines with items*/
        for (i=0;i<this.items.size();i++){
            item=(String)this.items.elementAt(i);
            price=(Float)this.prices.elementAt(i);
            quantity=(Integer)this.quantities.elementAt(i);
            System.out.print(item);
	    	/*adding spaces to match the longest item*/
            for (j=item.length();j<maxSize;j++){
                System.out.print(" ");
            }
            System.out.print("  "+price+"  "+quantity+"  ");
            itemtotal=price.floatValue()*quantity.intValue();
            subTotal=subTotal+itemtotal;
            System.out.println(itemtotal);
        }
/*printing the footer of the receipt*/
        System.out.println("======================");
        tax=subTotal*0.07f;
        System.out.println("SubTotal= Rs."+subTotal);
        System.out.println("GST     = Rs."+tax);
        if (subTotal>=discount) {
            theDiscount=subTotal*0.05f;
            System.out.println("Discount= Rs."+theDiscount);
        }
        System.out.println("Total   = Rs."+(subTotal+tax-theDiscount));

        System.out.println("======================");

    }
}