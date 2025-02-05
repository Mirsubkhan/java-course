package Lessons;

import java.util.Arrays;
import java.util.HashSet;

public class Lesson53 {
	
	public static boolean isAnagram(String str1, String str2) {
		if(str1.length() == str2.length()) {
			str1 = sortString(str1);
			str2 = sortString(str2);
			
			if(str1.equals(str2)) {
				System.out.println("This is an anagram!");
				return true;
			}
			System.out.println("This is not an anagram!");
			return false;
		}
		System.out.println("This is not an anagram!");
		return false;
	}
	
	public static String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

	public static void main(String[] args) {
		System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("hello", "world")); 
        System.out.println(isAnagram("racecar", "carrace"));
        System.out.println(isAnagram("java", "jvaa"));
        System.out.println(isAnagram("java", "Python"));
	}

}
