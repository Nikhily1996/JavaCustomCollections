package SegmentTree;
import java.util.Scanner; 


public class SegmentTreeApp {
    public static void main(String[] args) {
        try{   Scanner sc=new Scanner(System.in);
        System.out.println("enter no of entries"); 
        int noOfEntries=sc.nextInt();
        int[] entries=new int[noOfEntries];
        for(int i=0;i <noOfEntries;i++){
            entries[i]=sc.nextInt();
        } 
        SegmentTree st=new SegmentTree(entries);
        System.out.println("do you want to update entries Y/N");
       String data= sc.next();
       int index,value;
            while(data.toUpperCase().equals("Y")){
                System.out.println("enter index and value");
                index=sc.nextInt();
                value=sc.nextInt();
               st.updateValueAt(index,value);
               System.out.println("do you want to update entries Y/N");
               data= sc.next();
            }
            System.out.println("enter query start and query end");
            int start=sc.nextInt();
            int end=sc.nextInt();
            System.out.println("your sum is  "+ st.getSum(start,end));
            st.Display();
        sc.close();}catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
