public class ConvertBinaryTreeToDoubleLinkedList {
  /*  rigthmost child of the left subtree becomes left node of the parent
    leftmost child of the right subtree becomes right node of the parent
    for our demo lets consider below tree 
                     10
                   /    \
                  12      15
                 /  \    /  \
                25   30 36  
                       /  \
                       3   2
*/
    public static class Node{
        int value;
        Node left,right;
        Node(int data){
            value=data;
            left=null;
            right=null;
        }
    }
    public static Node BinaryTreeToDoubleLinkedList(Node head){
        // in order to avoid null pointer exception
      
        if(head==null)
            return head;
        if(head.left!=null){
            //initiating transformation of left subtree 
            //however it retruns only head.left at the end
            Node left=BinaryTreeToDoubleLinkedList(head.left);
            for(;left.right!=null;left=left.right);
           //left is the right most node of left subtree
            left.right=head;
            head.left=left;
        }
        if(head.right!=null){
              //initiating transformation of right subtree 
            //however it retruns only head.rigth at the end
            Node rigth=BinaryTreeToDoubleLinkedList(head.right);
            for(;rigth.left!=null;rigth=rigth.left);
            // rigth is the left most mode of the rigth subtree
            rigth.left=head;
            head.right=rigth;
        }
        

return head;
    }
    public static void display(Node DoubleLinkedList){
        System.out.println("Display called");
        Node left=DoubleLinkedList.left;
        for(;left.left!=null;left=left.left);
        for(;left.right!=null;left=left.right){
            System.out.println(left.value);
        }
        System.out.println(left.value);
    }
    public static void main(String[] args) {
       Node treeParent=new Node(10);
       treeParent.left=new Node(12);
       treeParent.right=new Node(15);
       treeParent.left.left=new Node(25);
       treeParent.left.right=new Node(30);
       treeParent.right.left=new Node(36);
       treeParent.right.left.left=new Node(3);
       treeParent.right.left.right=new Node(2);
       treeParent=BinaryTreeToDoubleLinkedList(treeParent);
       display(treeParent);
    }
}
