package SegmentTree;
class SegmentTree{
int[] segmentBinaryTree;
int[] orginalArray;
int size;
SegmentTree(int[] inputArray){
    orginalArray=inputArray;
segmentBinaryTree=new int[2*inputArray.length+1];
createSegmentTree(0,inputArray.length-1,0, inputArray);
}
public void Display(){
    for(int i=0;i<segmentBinaryTree.length;i++){
        System.out.println(segmentBinaryTree[i]+" ");
    }
}
void updateValueAt(int index,int value){
    int temp=orginalArray[index];
    int diff=value-temp;
    updateValue(0,orginalArray.length-1,index,diff,0);
}
void updateValue(int ss,int se,int index,int diff,int segmentIndex){
if(ss>index||se<index){
    return;
}else{
    int mid=(ss+se)/2;
    segmentBinaryTree[segmentIndex]=segmentBinaryTree[segmentIndex]+diff;
    if(ss!=se){
        updateValue(ss,mid,index,diff,(2*segmentIndex)+1);
    updateValue(mid+1,se,index,diff,(2*segmentIndex)+2);
    }
}
}
int getSum(int queryStart,int queryEnd){
if(queryStart<0||queryEnd>=orginalArray.length)
return 0;
return getSumUtil(queryStart,queryEnd,0,orginalArray.length-1,0);
}
int getSumUtil(int queryStart,int queryEnd,int segmentStart,int segmentEnd,int index){
    if(queryStart>segmentEnd||queryEnd<segmentStart){
        return 0;
    }
    if(queryStart <=segmentStart && segmentEnd<=queryEnd){
        return segmentBinaryTree[index];
    }
    int mid=(segmentStart+segmentEnd)/2;
    return getSumUtil(queryStart, queryEnd, segmentStart, mid, (index*2)+1)+
    getSumUtil(queryStart, queryEnd, mid+1, segmentEnd, (index*2)+2);
}

private int createSegmentTree(int ss,int se,int index,int[] inputArray){
//    when we left with only one node ,we are storing ss(segment start) value 
// of array since it will always be less than size of input array
        if(ss==se){
                segmentBinaryTree[index]=inputArray[ss];
            }else{
                int mid=(ss+se)/2;
                // (index*2)+1=left sub tress;
                // (index*2)+2=rigth sub tree;
                segmentBinaryTree[index]= createSegmentTree(ss,mid,(index*2)+1,inputArray)+
                createSegmentTree(mid+1,se,(index*2)+2,inputArray);
            }
            return segmentBinaryTree[index];
}

}