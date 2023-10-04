import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    long[] starts = {3, 2, 3};
    long d = 2;
    long result = getMaxDist(starts, d);
    System.out.println(result); // Output: 1
  }

  public static long getMaxDist(long[] starts, long d) {
    Arrays.sort(starts); // Sort the starting points in ascending order
    long maxDist = 0;

    for (int i = 1; i < starts.length; i++) {
      long currentDist = starts[i] - starts[i - 1] - 1;
      maxDist = Math.max(maxDist, currentDist);
    }

    // Consider the distance from the first range's start to 0 and from the last range's end to the end of the range
    maxDist = Math.max(maxDist, starts[0]);
    maxDist = Math.max(maxDist, d - starts[starts.length - 1]);

    return maxDist;
  }
}
