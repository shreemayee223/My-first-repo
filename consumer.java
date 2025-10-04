package mypackage;

public class consumer {
     String consumerName ;
     int consumerID;
    private double units ;
    private double billAmount ;
     
    public consumer(String name,int id ,double units ,double billAmount){
        this.consumerName = name ;
        this.consumerID = id ;
        this.units = units ;
        this.billAmount = billAmount ; 
    }
    public String getConsumerName() {
        return consumerName ;
    }
    public int getConsumerID() {
        return consumerID ;
    }
    public double getUnits() {
        return units ;
    }
    public double getbillAmount() {
        return billAmount ;
    }
    
    public void displayBill() {
        System.out.println("\n---Electricity Bill---") ;
        System.out.println("ConsumerID :" + consumerID) ;
        System.out.println("ConsumerName : " +consumerName) ;
        System.out.println("UnitsConsumed : " + units) ;
        System.out.println("Total Bill : " + billAmount) ;
        System.out.println("--");
    }
}