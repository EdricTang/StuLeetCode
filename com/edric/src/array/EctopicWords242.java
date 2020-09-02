package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. ��Ч����ĸ��λ��
 * ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
 *
 * ʾ��1:
 *
 * ����: s = "anagram", t = "nagaram"
 * ���: true
 * ʾ�� 2:
 *
 * ����: s = "rat", t = "car"
 * ���: false
 * ˵��:
 * ����Լ����ַ���ֻ����Сд��ĸ��
 *
 * ����:
 * ��������ַ������� unicode �ַ���ô�죿���ܷ������Ľⷨ��Ӧ�����������
 *
 * @author THR
 */
public class EctopicWords242 {

    public static void main(String[] args) {

        //isAnagram("", "");
        System.out.println(isAnagram2("aavvccd", "aaccvvc"));
    }

    /**
     * ����˼·��
     *      ͳ���ַ����ĸ���
     *      �ȼӺ����ֻ֤����һ��count����
     *      ���ж��ַ��Ϸ��Ժͳ��Ƚ�ʡ��Դ
     * ִ�н����
     *      ִ����ʱ��2 ms, ������ Java �ύ�л�����99.89%���û�
     *      �ڴ����ģ�39.4 MB, ������ Java �ύ�л�����97.65%���û�
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (null == s || null == t || s.length() != t.length()) {
            return false;
        }
        char[] sCharArray =  s.toCharArray();
        char[] tCharArray =  t.toCharArray();
        int[] sDiffCount = new int[26];
        for (char sChar : sCharArray) {
            sDiffCount[(sChar - 'a')] ++;
        }
        for (char tChar : tCharArray) {
            sDiffCount[(tChar - 'a')] --;
        }
        for (int i : sDiffCount) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * hahahhahaha....
     * ִ����ʱ��23 ms, ������ Java �ύ�л�����10.31%���û�
     * �ڴ����ģ�40.9 MB, ������ Java �ύ�л�����5.09%���û�
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        if (null == s || null == t || s.length() != t.length()) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        char[] sCharArray =  s.toCharArray();
        char[] tCharArray =  t.toCharArray();
        Integer count;
        for (char sChar : sCharArray) {
            count = map.get(sChar);
            if (null == count) {
                map.put(sChar, 1);
            } else {
                map.put(sChar, count + 1);
            }
        }
        for (char tChar : tCharArray) {
            count = map.get(tChar);
            if (null == count || --count < 0) {
                return false;
            } else {
                map.put(tChar, count - 1);
            }
        }
        for (Integer i : map.values()) {
            if (i.intValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
