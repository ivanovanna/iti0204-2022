package ee.ttu.algoritmid.subtreesum;

public class SubtreeSum {


        /**
         * Calculate sum of all right children for every node
         * @param rootNode root node of the tree. Use it to traverse the tree.
         * @return root node of the tree where for every node is computed sum of it's all right children
         */
        public Node calculateRightSums(Node rootNode) {
            long rightSum = 0;
            long leftSum = 0;

            /*This function calculates sum of all right leaf
            nodes in a binary tree and add right leaf node data to sum */
            if (rootNode.getRight() != null) {
                rightSum = calculateRightSums(rootNode.getRight()).getSumOfAllChildren()
                        + rootNode.getRight().getValue();
            }

           /* This function calculates sum of all left leaf
           nodes in a binary tree and add left leaf node data to sum */
            if (rootNode.getLeft() != null) {
                leftSum = calculateRightSums(rootNode.getLeft()).getSumOfAllChildren()
                        + rootNode.getLeft().getValue();
            }

            rootNode.setSumOfAllChildren(rightSum + leftSum);
            rootNode.setSumOfAllRight(rightSum);
            return rootNode;

        }
        public static void main(String[] args) throws Exception {
            /**
             *  Use this example to test your solution
             *                  Tree:
             *                   15
             *               /       \
             *             10         17
             *           /   \       /  \
             *         3     13     5    25
             */
            Node rootNode = new Node(15);
            Node a = new Node(10);
            Node b = new Node(17);
            Node c = new Node(3);
            Node d = new Node(13);
            Node e = new Node(5);
            Node f = new Node(25);

            rootNode.setLeft(a);
            rootNode.setRight(b);
            a.setLeft(c);
            a.setRight(d);
            b.setLeft(e);
            b.setRight(f);

            SubtreeSum solution = new SubtreeSum();
            solution.calculateRightSums(rootNode);

            if (rootNode.getSumOfAllRight() != 47 ||
                    a.getSumOfAllRight() != 13 ||
                    b.getSumOfAllRight() != 25 ||
                    c.getSumOfAllRight() != 0) {
                throw new Exception("There is a mistake in your solution.");
            }

            System.out.println("Your solution should be working fine in basic cases, try to push.");

        }

    }

