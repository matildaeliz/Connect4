public class Tree {
    /**
     * root of tree
     */
    TreeNode root;

    /**
     * Constrructer for Tree
     */
    public Tree(TreeNode root){
        this.root = root;
    }

    /**
     * This method runs the selectNode to decide which column is best option
     * @param columnsrow
     * @return tmp
     */
    public  TreeNode selectColumn(int[] columnsrow){
       TreeNode tmp = root.selectNode(columnsrow);
        root = tmp;

        return tmp;
    }

    /**
     * This methods inserts empty childs of root
     * @param node
     */
    void insertchild(TreeNode node){


        while (true){

            if(root.getFirst() == null){
                root.first = node;
               break;
            } else if (root.getSecond() == null ) {
                root.second= node;
                break;
            } else if (root.getThird() == null) {
                root.third = node;
                break;
            } else if (root.getFourth() == null) {
                root.fourth = node;
                break;
            }else if(root.getFifth() == null){
                root.fifth = node;
                break;
            }else if(root.sixth == null){
                root.sixth = node;
                break;
            } else if (root.seventh == null) {
                root.seventh = node;
                break;
            }


        }
    }
}
