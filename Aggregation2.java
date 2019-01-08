import java.util.ArrayList;
import java.util.Arrays;

public class Aggregation2 {
	public static void main(String[] args) {
		int numberOfCriteria = 5;
		int numberOfAlternatives = 5;
		int numberOfUsers = 3;
		int[][] medians = new int[numberOfCriteria][numberOfAlternatives];
		ArrayList<int[][]> usersTables = new ArrayList<>();
		int[][] user1Table = new int[numberOfCriteria][numberOfAlternatives];
		user1Table[0] = new int[] {3,3,2,1,1};
		user1Table[1] = new int[] {2,2,5,1,4};
		user1Table[2] = new int[] {1,2,2,3,3};
		user1Table[3] = new int[] {2,1,1,1,3};
		user1Table[4] = new int[] {3,1,1,2,3};
		
		int[][] user2Table = new int[numberOfCriteria][numberOfAlternatives];
		user2Table[0] = new int[] {2,3,3,1,3};
		user2Table[1] = new int[] {2,3,4,5,2};
		user2Table[2] = new int[] {3,2,2,1,2};
		user2Table[3] = new int[] {1,2,3,4,1};
		user2Table[4] = new int[] {2,2,1,2,1};
		
		int[][] user3Table = new int[numberOfCriteria][numberOfAlternatives];
		user3Table[0] = new int[] {1,2,1,2,2};
		user3Table[1] = new int[] {3,3,3,2,1};
		user3Table[2] = new int[] {2,1,3,4,5};
		user3Table[3] = new int[] {1,3,2,5,4};
		user3Table[4] = new int[] {1,2,2,3,4};
		
		usersTables.add(user1Table);
		usersTables.add(user2Table);
		usersTables.add(user3Table);
		
		for(int i=0;i<numberOfCriteria;i++) {
			for(int j=0;j<numberOfAlternatives;j++) {
				int[] cellRanks = new int[numberOfUsers];
				int k=0;
				for(int[][] userTable : usersTables) {
					cellRanks[k] = userTable[i][j];
					k++;
				}
				medians[i][j] = (int) getMedian(cellRanks);
			}
		}
		
		
		//printing median array
		System.out.println("Median array:");
		for(int i=0;i<numberOfCriteria;i++) {
			for(int j=0;j<numberOfAlternatives;j++) {
				System.out.print(medians[i][j] + " ");
			}
			System.out.println();
		}
		
		// get finalRank of the medians array
		MainNew mainNew = new MainNew();
		int[] userFinalRank = mainNew.getUserFinalRank(medians);
		System.out.println("Final Rank:");
		for(int i=0;i<userFinalRank.length;i++) {
			System.out.print(userFinalRank[i] + " ");
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
