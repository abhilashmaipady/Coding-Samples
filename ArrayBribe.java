/*
 It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! There are a number of people queued up, and each person wears a sticker indicating their initial position in the queue. Initial positions increment by  from  at the front of the line to  at the back.

Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap positions, they still wear the same sticker denoting their original places in line. One person can bribe at most two others. For example, if and  bribes , the queue will look like this: .

Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!

Function Description

Complete the function minimumBribes in the editor below. It must print an integer representing the minimum number of bribes necessary, or Too chaotic if the line configuration is not possible.

minimumBribes has the following parameter(s):

q: an array of integers
Input Format

The first line contains an integer , the number of test cases.

Each of the next  pairs of lines are as follows: 
- The first line contains an integer , the number of people in the queue 
- The second line has  space-separated integers describing the final state of the queue.

Constraints

Subtasks

For  score 
For  score 

Output Format

Print an integer denoting the minimum number of bribes needed to get the queue into its final state. Print Too chaotic if the state is invalid, i.e. it requires a person to have bribed more than  people.

Sample Input

2
5
2 1 5 3 4
5
2 5 1 3 4
Sample Output

3
Too chaotic

No person can bribe more than two people, so its not possible to achieve the input state.
 */


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
    	int index = 0;
    	while(!compareArray(p, q))
    	{
    		if(index >= q.length) { 
    			System.out.println("Too chaotic");
    			return;
    		}
    		int count = 0;
    		int pIndex = indexOf(p, q[index]);
    		while(q[pIndex] != p[pIndex]) {
    			if(p[pIndex] > p[pIndex - 1]) count++;
    			else count--;
    			swap(p, pIndex, --pIndex);
    		}
    		if(count > 2) { 
    			System.out.println("Too chaotic");
    			return;
    		}
    		bribe += count;
    		if(q[index] == p[index]) index++;
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
    static int indexOf(int[] arr, int element) {
    	for(int i = 0; i < arr.length; i++) 
    		if(arr[i] == element) return i;
    	return -1;
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
