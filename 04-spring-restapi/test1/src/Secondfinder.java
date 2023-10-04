import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Secondfinder {
  public static void main(String[] args) {
    int[] a = {0, 1, 2, 1, 4, 4};
    int[] b = {1, 2, 0, 4, 5, 6};

    int a1 = secGet(7, a, b, 6);
    System.out.println(a1);
  }

  public static int secGet(int n, int a[], int b[], int m) {
    int ans = 0;
    List<Integer>[] graph = new ArrayList[n];
    HashMap<Integer, Integer> degree = new HashMap<>();

    // Initialize the ArrayLists in the graph array
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      graph[a[i]].add(b[i]);
      graph[b[i]].add(a[i]);
      degree.put(a[i], degree.getOrDefault(a[i], 0) + 1);
      degree.put(b[i], degree.getOrDefault(b[i], 0) + 1);
    }

    boolean right = true;
    while (right) {
      right = false;
      List<Integer> toRemove = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        if (degree.containsKey(i) && degree.get(i) <= 1) {
          right = true;
          toRemove.add(i);
        }
      }

      for (int i : toRemove) {
        for (int j : graph[i]) {
          degree.put(j, degree.get(j) - 1);
        }
        degree.remove(i);
      }

      if (right) {
        ans++;
      }
    }
    return ans;
  }
}
