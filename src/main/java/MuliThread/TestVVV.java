package MuliThread;

import java.util.*;

import org.junit.Test;

public class TestVVV {

    public int findMaxLength(int[] nums) {
        int[] arr = new int[2 * nums.length + 1];
        /*....-2*/
        Arrays.fill(arr, -2);
        /*???*/
        arr[nums.length] = -1;

        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            /*0做衰减 ，1做增长*/
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode node = reConstruct(preOrder, inOrder);
//        printTree(node);
    }

    static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /*


        public static BinaryTreeNode reConstruct(int[] preOrder, int[] inOrder) {
            if (preOrder == null || inOrder == null || preOrder.length != inOrder.length)

                return null;
            return construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
        }

        static BinaryTreeNode construct(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie) {
            if (ps > pe)
                return null;

            int rootValue = preOrder[ps];
            int index = is;
            while (index < ie && inOrder[index] != rootValue) {
                index++;
            }
            System.out.println("当前各参数的数值为->ps:" + ps + " pe:" + pe + " is：" + is + " ie：" + ie + " index：" + index + " rootValue：" + rootValue);

            if (index > ie) {
                System.out.println("出错");
                return null;
            }
            BinaryTreeNode node = new BinaryTreeNode();
            node.value = rootValue;
            node.left = construct(preOrder, ps + 1, ps + index - is, inOrder, is, index - 1);
            node.right = construct(preOrder, ps + index - is + 1, pe, inOrder, index + 1, ie);
            return node;
        }
        */
    public static BinaryTreeNode reConstruct(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length || preOrder.length < 1)
            return null;
        return construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public static BinaryTreeNode construct(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie) {
        //开始位置大于结束位置说明已经处理到叶节点了
        if (ps > pe)
            return null;

        //前序遍历第一个数字为当前的根节点
        int value = preOrder[ps];
//            index为根节点在中序遍历序列中的索引

        int index = is;
        while (index <= ie && inOrder[index] != value) {
            index++;
        }
        System.out.println("当前各参数的数值为->ps:" + ps + " pe:" + pe + " is：" + is + " ie：" + ie + " index：" + index + " rootValue：" + value);
        if (index > ie) {
            throw new RuntimeException("invalid input" + index);
        }
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;
        node.left = construct(preOrder, ps + 1, ps + index - is, inOrder, is, index - 1);
        node.right = construct(preOrder, ps + index - is + 1, pe, inOrder, index + 1, ie);
        return node;
    }

    //中序遍历递归打印
    public static void printTree(BinaryTreeNode node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.value + " ");
            printTree(node.right);
        }
    }


    @Test
    public void TestBitOperation() {
        int postive = 7;
        int negative = -7;

        System.out.println(postive >> 1);
        System.out.println(postive << 1);
        System.out.println(postive >>> 1);
        /*除2的运算*/
        System.out.println(negative >> 1);
        System.out.println(negative << 1);
        System.out.println(negative >>> 1);
        System.out.println(Integer.MAX_VALUE);
        /*7     00000000000000...0111*/
        /*-7    11111111111111...1000*/
        System.out.println((postive &= 0x01) == 1);
        System.out.println((negative &= 0x01) == 1);


    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> re = new ArrayList();
            if (root == null)
                return re;
            TreeNode cur = root;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(cur);
            int count = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode curNode = queue.poll();
                    if (curNode == null)
                        continue;
                    if (curNode.left != null)
                        (queue).add(curNode.left);
                    if (curNode.right != null)
                        queue.add(curNode.right);
                    if ((count & 0x01) == 0)

                        list.add(curNode.val);
                    else
                        list.add(0,curNode.val);
                }
                re.add(list);
                count++;
            }
            return re;
        }

    }

    @Test
    public void testWiggle() {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
    }

    public void wiggleSort(int[] nums) {
        /*从左到右遍历， 以三个为窗口进行交换， */
        if (nums.length <= 0) {
        } else if (nums.length == 1) {
            System.out.println(nums[0]);
        } else {
            for (int i = 1; i < nums.length; i += 2) {
                swap(nums, i - 1, i + 1);
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int s, int e) {
        /*为安全起见，*/
        int center = s + 1;
        if (e < nums.length)
            realSwap(nums, center, e);
        realSwap(nums, center, s);
    }

    private void realSwap(int[] nums, int s, int e) {
        if (nums[s] < nums[e]) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;

        }
    }


}
