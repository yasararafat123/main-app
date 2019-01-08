import java.util.ArrayList;
import java.util.Arrays;

public class Aggregation1 {

	public static void main(String[] args) {
		int numberOfAlternatives = 5;
		int numberOfUsers = 3;
		ArrayList<int[]> finalRanks = new ArrayList<int[]>();
		finalRanks.add(new int[] {3,4,5,1,2});
		finalRanks.add(new int[] {1,2,4,3,5});
		finalRanks.add(new int[] {2,1,5,3,4});
		for(int i=0;i<numberOfAlternatives; i++) {
			int[] alternativeFinalRanks = new int[numberOfUsers];
			int k =0;
			for(int[] userRank : finalRanks) {
				alternativeFinalRanks[k] = userRank[i];
				k++;
			}
			System.out.println(getMedian(alternativeFinalRanks));
		}

	}
	
	private static double getMedian(int[] numbers) {
		Arrays.sort(numbers);
		double median;
		if (numbers.length % 2 == 0) {
			median = ((double)numbers[numbers.length/2] + (double)numbers[numbers.length/2 - 1])/2;
		} else {
			median = (double) numbers[numbers.length/2];
		}
		return median;
	}

}
