import java.util.LinkedList;
import java.util.List;

public class Calculator {
    public static List<String> listString = new LinkedList<>();

    public static List<String> createList(String str) {
        String operand = new String();
        str = str.trim().replaceAll("\\s", "");
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                listString.add(Character.toString(str.charAt(i)));
            } else {
                while (Character.isDigit(str.charAt(i)) || str.charAt(i) == '.') {
                    operand += str.charAt(i++);
                    if (i == str.length()) {
                        break;
                    }
                }
                listString.add(operand);
                operand = new String();
                i--;
            }
        }
        return listString;
    }
}



