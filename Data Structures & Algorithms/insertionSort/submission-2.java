// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    /***
    Insertion sort. Note: Modifies input to final sorted state. Returns all states in the sort.
    */
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        if (pairs.isEmpty()) {
            return List.of();
        }

        List<List<Pair>> results = new ArrayList<>();

        results.add(List.copyOf(pairs));

        for (int i = 1; i < pairs.size(); i++) {
            var sortMe = pairs.remove(i);

            boolean inserted = false;
            for (int j = 0; j < i; j++) {
                if (pairs.get(j).key > sortMe.key) {
                    pairs.add(j, sortMe);
                    inserted = true;
                    break;
                }
            }

            if (!inserted) {
                pairs.add(i, sortMe);
            }

            results.add(List.copyOf(pairs));
        }

        return results;
    }
}
