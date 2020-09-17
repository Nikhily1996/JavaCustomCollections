import java.util.Scanner; 

public class SprialMatrix {
    public static void spiralPrinting(int[][] matrix,int startRow,int endRow,
    int startCol,int endCol){
        while(startRow<endRow||startCol<endCol){
            for(int i=startCol;i<=endCol;i++){
                System.out.println(matrix[startRow][i]+" rigth");
            }
            startRow++;
            for(int i=startRow;i<=endRow;i++){
                System.out.println(matrix[i][endCol]+" down");
            }
            endCol--;
            for(int i=endCol;i>=startCol;i--){
                System.out.println(matrix[endRow][i]+" left");
            }
            endRow--;
            for(int i=endRow;i>startCol;i--){
                System.out.println(matrix[i][startCol]+" up");
            }
            startCol++;
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no of rows and coloums");
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int[][] matrix=new int[rows][cols];
        System.out.println("pease enter "+rows*cols+" numbers for matrix input");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        spiralPrinting(matrix,0,rows-1,0,cols-1);

    }
   
    
}
