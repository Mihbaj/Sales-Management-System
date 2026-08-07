package Sales;
import java.util.ArrayList;
import Item.*;
import java.time.LocalDate;


public class Sales {
    private String saleId;
    private ArrayList<SaleItem> itemList; 
    private String paymentMethod;
    private String paymentStatus;
    private LocalDate date;

    public Sales(String saleId,String paymentMethod,String paymentStatus,LocalDate date,ArrayList<SaleItem> list){
        this.saleId = saleId;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.date = date;
        itemList = list;
    }
    /*public void setList(ArrayList<SaleItem> list){
        itemList = list;
    }*/

    public void displaySales(){
        System.out.println("Sale Id:"+saleId);
        System.out.println("Payment Method:"+paymentMethod);
        System.out.println("Payment Status:"+paymentStatus);
        System.out.println("Date:"+date);
    }
    @Override
    public String toString(){
        
        StringBuilder items = new StringBuilder();
        for(int i =0;i<itemList.size();i++){
            items.append(itemList.get(i).toFileString());

            if(i!=itemList.size()-1){
                items.append("|");
            }
        }
        return saleId+","+ paymentMethod +","+paymentStatus+","+date+","+items.toString();
    }
    public int getTreeId(){
        int number = Integer.parseInt(saleId.substring(2));
        return  number;
    
    }

    
}
