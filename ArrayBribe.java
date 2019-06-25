package temp;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayBribe {
	// Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
    	int bribe = 0;
    	int[] p = createArray(q.length);
    	int index = q.length - 1;
    	while(!compareArray(p, q))
    	{
    		if(index < 0) { 
    			System.out.println("Too chaotic");
    			return;
    		}
    		int count = 0;
    		int pIndex = index;
    		while(q[pIndex] != p[pIndex]) {
    			count++;
    			swap(p, pIndex, --pIndex);
    		}
    		if(count > 2) { 
    			System.out.println("Too chaotic");
    			return;
    		}
    		bribe += count;
    		if(q[index] == p[index]) index --;
    	}
//    	int index = q.length - 1;
//    	while(index > 0) {
//    		if(q[index] < q[index-1]) {
//    			int diff = q[index-1] - q[index];
//    			if(diff > 2 ) { 
//        			System.out.println("Too chaotic");
//        			return;
//        		}
//    			bribe += diff;
//    		}
//    		index--;
//    		
//    	}
//    	
    	System.out.println(bribe);

    }
    static void swap(int[] p, int m, int n) {
    	int temp = p[m];
    	p[m] = p[n];
    	p[n] = temp;
    }
    static boolean compareArray(int[] p, int[] q) {
    	for(int i = 0; i < p.length; i++) {
    		if(p[i]!=q[i]) return false;
    	}
    	return true;
    }
    
    static int[] createArray(int n) {
    	int[] arr = new int[n];
    	for(int i = 0; i < n; i++) {
    		arr[i] = i+1;
    	}
    	return arr;
    }

    
    public static void main(String[] args) {
        
        int count = 0;
        int t = Integer.parseInt(args[count++]);
        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(args[count++]);

            int[] q = new int[n];

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(args[count++]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }
    }
}
