/*
Lilah has a string, , of lowercase English letters that she repeated infinitely many times.
Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.

For example, if the string  and , the substring we consider is , the first  characters of her infinite string. There are  occurrences of a in the substring.

Function Description
Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences of a in the prefix of length  in the infinitely repeating string.
repeatedString has the following parameter(s):

s: a string to repeat
n: the number of characters to consider
Input Format

The first line contains a single string, . 
The second line contains an integer, .

Constraints

For  of the test cases, .
Output Format

Print a single integer denoting the number of letter a's in the first  letters of the infinite string created by repeating  infinitely many times.

Sample Input 0

aba
10
Sample Output 0

7
Explanation 0 
The first  letters of the infinite string are abaabaabaa. Because there are  a's, we print  on a new line.

Sample Input 1

a
1000000000000
Sample Output 1

1000000000000
Explanation 1 
Because all of the first  letters of the infinite string are a, we print  on a new line.

*/
package temp;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StringRepeat {
	// Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	long count = countChar(s, 'a', 0, n);
    	long rep = Math.round(Math.floor((double) n/ s.length()));
    	long mod = n%s.length();
    	return count*rep + countChar(s, 'a', 0, mod);
    }
    
    static int countChar(String s, char ch, int index, long lastIndex) {
    	if(index >= s.length()) return 0;
    	if(lastIndex != -1 && index >= lastIndex) return 0;
    	return s.indexOf(ch, index) != -1 && s.indexOf(ch, index) < lastIndex ?  1 + countChar(s, ch, s.indexOf(ch, index) + 1, lastIndex) : 0;
    }

    public static void main(String[] args) throws IOException {
        long result = repeatedString(args[0], Long.parseLong(args[1]));
        System.out.println(result);
    }
}

