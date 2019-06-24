package temp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Temp {

	static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int count = 0;
        for(int i = 0; i < ar.length; i++) {
            if(null == countMap.get(ar[i])) {
            	countMap.put(ar[i], 0);
            } else {
            	countMap.replace(ar[i], countMap.get(ar[i])+1);
            }
        }
        for(int i : countMap.values()) {
        	count += i%2;
        }
        return count;
    }
	
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
