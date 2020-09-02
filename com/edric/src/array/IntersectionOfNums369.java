package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 *
 * 说明：
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class IntersectionOfNums369 {

    /**
     * 解题思路：
     *      把一个数组存到set集合中；遍历另一个数组查出重复数值
     *
     * 执行结果：
     *      执行用时：3 ms, 在所有 Java 提交中击败了97.68%的用户
     *      内存消耗：39.7 MB, 在所有 Java 提交中击败了91.59%的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> intersectionSet = new HashSet<>();
        for (int j : nums2) {
            if (set.contains(j)) {
                intersectionSet.add(j);
            }
        }
        int[] result = new int[intersectionSet.size()];
        int l = 0;
        for (int i : intersectionSet) {
            result[l++] = i;
        }
        return result;
    }
}
