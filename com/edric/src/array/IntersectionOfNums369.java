package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. ��������Ľ���
 * �����������飬��дһ���������������ǵĽ�����
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums1 = [1,2,2,1], nums2 = [2,2]
 * �����[2]
 * ʾ�� 2��
 *
 * ���룺nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * �����[9,4]
 *
 *
 * ˵����
 * �������е�ÿ��Ԫ��һ����Ψһ�ġ�
 * ���ǿ��Բ�������������˳��
 */
public class IntersectionOfNums369 {

    /**
     * ����˼·��
     *      ��һ������浽set�����У�������һ���������ظ���ֵ
     *
     * ִ�н����
     *      ִ����ʱ��3 ms, ������ Java �ύ�л�����97.68%���û�
     *      �ڴ����ģ�39.7 MB, ������ Java �ύ�л�����91.59%���û�
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
