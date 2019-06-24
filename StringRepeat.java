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

