import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String message = "京东商城计算出\n" +
                "  实地考察你看上档次 \n" +
                "  手机电池叫顶层\n" +
                "     \n" +
                "    \n" +
                "   \n" +
                "  第六次上档次\n" +
                "  \n" +
                "  是单侧开始c\n" +
                "    \n" +
                "\t\n" +
                "\t斯柯达才开始";
        System.out.println(message);

        Pattern pattern = Pattern.compile("(\\s*\r?\n(\\s*\r?\n?)+)");

        Matcher matcher = pattern.matcher(message);
        String result = matcher.replaceAll("\r\n");
        System.out.println(result);


    }
}
