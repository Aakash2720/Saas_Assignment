import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment10 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read V and H
        String[] firstLine = br.readLine().trim().split("\\s+");
        int V = Integer.parseInt(firstLine[0]);
        int H = Integer.parseInt(firstLine[1]);

        // Read vertical segments
        int[][] vertseg = new int[V][3];
        for (int i = 0; i < V; i++) {
            String[] segment = br.readLine().trim().split("\\s+");
            vertseg[i][0] = Integer.parseInt(segment[0]);
            vertseg[i][1] = Integer.parseInt(segment[1]);
            vertseg[i][2] = Integer.parseInt(segment[2]);
        }

        // Read horizontal segments
        int[][] horiseg = new int[H][3];
        for (int i = 0; i < H; i++) {
            String[] segment = br.readLine().trim().split("\\s+");
            horiseg[i][0] = Integer.parseInt(segment[0]);
            horiseg[i][1] = Integer.parseInt(segment[1]);
            horiseg[i][2] = Integer.parseInt(segment[2]);
        }

        // Count intersections
        int count = 0;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < H; j++) {
                if (intersects(vertseg[i], horiseg[j])) {
                    count++;
                }
            }
        }

        // Print the count of intersections
        System.out.println(count);

        br.close();
    }

    private static boolean intersects(int[] vertical, int[] horizontal) {
        int x = vertical[0];
        int y1 = Math.min(vertical[1], vertical[2]);
        int y2 = Math.max(vertical[1], vertical[2]);

        int y = horizontal[0];
        int x1 = Math.min(horizontal[1], horizontal[2]);
        int x2 = Math.max(horizontal[1], horizontal[2]);

        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }
}
