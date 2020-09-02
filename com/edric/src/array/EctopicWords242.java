package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author THR
 */
public class EctopicWords242 {

    public static void main(String[] args) {

        //isAnagram("", "");
        System.out.println(isAnagram2("aavvccd", "aaccvvc"));
    }

    /**
     * 解题思路：
     *      统计字符串的个数
     *      先加后减保证只创建一个count数组
     *      先判断字符合法性和长度节省资源
     * 执行结果：
     *      执行用时：2 ms, 在所有 Java 提交中击败了99.89%的用户
     *      内存消耗：39.4 MB, 在所有 Java 提交中击败了97.65%的用户
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
     * 执行用时：23 ms, 在所有 Java 提交中击败了10.31%的用户
     * 内存消耗：40.9 MB, 在所有 Java 提交中击败了5.09%的用户
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
