package HashMap.hashMapCustomPackage;
import java.util.Scanner; 
public class HashMapCustomApp {
    public static void main(String[] args) {
           HashMapCustom<Integer, Integer> hashMapCustom = new HashMapCustom<Integer, Integer>();
           Scanner sc=new Scanner(System.in);
           System.out.println("enter no of entries");
           int n=sc.nextInt();
           Integer j,k;
           for(int i=0;i<n;i++){
              System.out.println("please provide the key and value");
              j=sc.nextInt();
              k=sc.nextInt();
              try{
               hashMapCustom.put(j,k);
              }catch(Exception e){
                 System.out.println(e.getMessage());
                
              }
             
           }
             
           System.out.print("Displaying : ");
           hashMapCustom.display();
           sc.close();
 
    }
 }
 