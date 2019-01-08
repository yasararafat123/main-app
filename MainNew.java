import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainNew {
	static int numberOfCriteria = 5;
	static int numberOfAlternatives = 5;
	
	public static int[] getUserFinalRank(int[][] userTable) {
		int[] uniques = new int[numberOfAlternatives];
		int[] uniquesCriteria = new int[numberOfAlternatives];
		for(int i=0;i<numberOfCriteria;i++) {
			ArrayList<Integer> indexes = getUniqueElementsIndexes(userTable[i],uniques, numberOfAlternatives);
			for(Integer index : indexes) {
				uniques[index] = userTable[i][index];
				uniquesCriteria[index] = i;
				
			}
		}
		int rankCounter = 1;
		int[] finalRank = new int[numberOfAlternatives];
		for(int i=1;i<=numberOfAlternatives;i++) {
			Map<Integer, Integer> map = new HashMap<>();
			for(int j=0;j<uniques.length;j++) {
				if(i==uniques[j]) {
					map.put(uniquesCriteria[j], j);
				}
			}
			List<Integer> sortedCriteria=new ArrayList(map.keySet());
			Collections.sort(sortedCriteria);
			for(Integer c : sortedCriteria) {
				finalRank[map.get(c)] = rankCounter;
				rankCounter++;
			}
		}
		
		return finalRank;
	}

	public static void main(String[] args) {
		
		int[][] table = new int[numberOfCriteria][numberOfAlternatives];
		table[0] = new int[] {2,3,3,1,3};
		table[1] = new int[] {2,3,4,5,1};
		table[2] = new int[] {3,2,2,1,2};
		table[3] = new int[] {1,2,3,4,1};
		table[4] = new int[] {2,2,1,2,1};
		
		int[] userFinalRank = getUserFinalRank(table);
		for(int i=0;i<userFinalRank.length;i++) {
			System.out.print(userFinalRank[i] + " ");
		}
		
		
	}
	
	
	public static ArrayList<Integer> getUniqueElementsIndexes(int[] arr, int[] execlude,int numberOfAlternatives) {
		ArrayList<Integer> result = new ArrayList<>();
		Map<Integer, ArrayList<Integer>> alternativeIndexesMap = new HashMap<>();
		for(int i=1;i<=numberOfAlternatives;i++) {
			alternativeIndexesMap.put(i, new ArrayList<>());
		}
		for(int i=0;i<arr.length;i++) {
			if(execlude[i]==0) {
				alternativeIndexesMap.get(arr[i]).add(i);
			}
		}
		Iterator it = alternativeIndexesMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if(((ArrayList<Integer>)pair.getValue()).size() == 1) {
	        	result.add(((ArrayList<Integer>)pair.getValue()).get(0));
	        }
	        it.remove(); // avoids a ConcurrentModificationException
	    }
		return result;
	}
}
