package Product;
public class Categories{
   private String[] categories = {"Diary Products","Fruites and vagitale","Meat and Seafood","Bakery","Snacks","beverages","Frozen Foods","Rice,grais and pulses","canned and Packaged Foods","Personal Care","Household and Cleaning","Baby Product","Stationer","Other"};
    
    
    public void displayCategories(){
        for(int i=0;i<categories.length;i++){
            System.out.println("Category "+(i+1)+": "+categories[i]);

        }
    }
    
    public String getCategorie(int num){
        return categories[num-1];
        
    }





}