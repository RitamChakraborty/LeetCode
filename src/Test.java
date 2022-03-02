import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println((int) 'I');
        System.out.println((int) ' ');
        System.out.println((int) 'L');
        System.out.println((int) 'O');
        System.out.println((int) 'V');
        System.out.println((int) 'E');
        System.out.println((int) 'U');
        System.out.println(Arrays.toString("❤️".getBytes(StandardCharsets.UTF_8)));
    }
}
