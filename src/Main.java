import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(comparetor("0.1","1.1"));
        System.out.println(comparetor("1.1","0.1"));
        System.out.println(comparetor("1.1","1.1"));
        System.out.println(comparetor("1.1.1","1.1"));
        System.out.println(comparetor("1.1","1.1.1"));
        System.out.println(comparetor("1.1","1.1.0.0"));
    }

    public static int comparetor(String v1, String v2) {
        int[] intsV1 = Arrays.stream(v1.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] intsV2 = Arrays.stream(v2.split("\\.")).mapToInt(Integer::parseInt).toArray();

        int maxLen = Math.max(intsV1.length, intsV2.length);

        int result = 0;
        for (int i = 0; i < maxLen; i++) {

            int v1n = i >= intsV1.length ? 0:intsV1[i];
            int v2n = i >= intsV2.length ? 0:intsV2[i];

            if (v1n > v2n) {
                result = 1;
                break;
            } else if (v2n > v1n) {
                result = -1;
                break;
            }
        }

        return result;
    }
}