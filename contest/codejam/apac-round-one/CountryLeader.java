import java.util.Scanner;

/**
 * @author yijiezhu
 * @since 10/4/16.
 */
public class CountryLeader {
    int T, N;
    public static void main(String[] args) {
        new CountryLeader().run();
    }
    void run() {
        Scanner scanner =
                new Scanner(CountryLeader.class.getResourceAsStream("/country_leader/A-large-practice.in"));
        T = Integer.parseInt(scanner.nextLine());
        for (int ti = 0; ti < T; ti++) {
            N = Integer.parseInt(scanner.nextLine());
            String leader = "";
            int val = 0;
            for (int ni = 0; ni < N; ni++) {
                int[] map = new int[128];
                int counter = 0;
                String name = scanner.nextLine();
                for (int nameI = 0; nameI < name.length(); nameI++) {
                    if (Character.isUpperCase(name.charAt(nameI))) {
                        if (map[name.charAt(nameI)]++ == 0) {
                            counter++;
                        }
                    }
                }
                if (counter > val ||
                        (counter == val && name.compareTo(leader) < 0)) {
                    leader = name;
                    val = counter;
                }
            }
            System.out.println("Case #" + (ti+1) + ": " + leader);
        }
    }
}
