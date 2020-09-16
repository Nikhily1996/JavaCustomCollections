import java.util.HashMap;
import java.util.Scanner; 

public class PythegorenTriplet {  
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<Integer,Integer> inputValues=new HashMap<Integer,Integer>();
        boolean hasPythegorenTriplet=false;
        System.out.println("enter no of entries"); 
        int noOfEntries=sc.nextInt();
        int[] entries=new int[noOfEntries];
        for(int i=0;i <noOfEntries;i++){
            entries[i]=sc.nextInt();
            entries[i]=entries[i]*entries[i];
            inputValues.put(entries[i], 1);
        } 
        for(int i=0;i<noOfEntries;i++){
            for(int j=i+1;j<noOfEntries;j++){
                if(inputValues.containsKey(entries[i]+entries[j])){
                    hasPythegorenTriplet=true;
                    break;
                }
            }
            if(hasPythegorenTriplet){
                break;
            }
        }
        if(hasPythegorenTriplet){
            System.out.println("yes input contains pytheogoren triplet");
        }
        sc.close();
    }
}
