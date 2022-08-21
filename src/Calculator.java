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
    public static void Calculate(String str) {
        listString = createList(str);
        String substr = null;
        for (int i = 0; i < listString.size(); i++) {
            double result = 0;
            StringBuilder stringBuilder = new StringBuilder(str);
            if (listString.get(i).equals("(") && !listString.get(i+1).equals("-")) {
                int num1 = i;
                int num2 = 0;
                System.out.println(num1);
                for (int j = 0; j < listString.size(); j++) {
                    if (listString.get(j).equals(")")) {
                        num2 = j;
                        System.out.println(num2);
                        break;
                    }
                }
                if (listString.get(num1 + 2).equals("-")) {
                    result = Double.parseDouble(listString.get(num1 + 1)) - Double.parseDouble(listString.get(num2 - 1));
                    System.out.println(result);
                } else if (listString.get(num1 + 2).equals("+")) {
                    result = Double.parseDouble(listString.get(num1 + 1)) + Double.parseDouble(listString.get(num2 - 1));
                    System.out.println(result);
                }
                listString.removeAll(listString);

                int index = (str.indexOf("(") -1);
                if(num1 == 0 && result < 0){
                    str = stringBuilder.insert(num1, "-").toString();
                    System.out.println(stringBuilder);
                    result = Math.abs(result);
                } else if (num1 == 0 && result >= 0){
                    continue;
                } else if (str.charAt(num1-1) == '-' && result < 0){
                    stringBuilder.delete(index, index).setCharAt(index, '+');
                    str = stringBuilder.toString();
                    result = Math.abs(result);

                } else if (str.charAt(num1-1) == '+' && result < 0){
                    stringBuilder.delete(index, index+1);
                    str = stringBuilder.toString();
                }
                substr = str.substring(str.indexOf("("), str.indexOf(")") + 1);
                str = str.replace(substr, Double.toString(result));
                listString = createList(str);
                System.out.println(listString.get(i+1));
            }
        }
        while(listString.contains("*")){
            for (int i = 0; i < listString.size(); i++) {
                if (listString.get(i).equals("*")){
                    int index1 = i;
                    double a = Double.parseDouble(listString.get(index1-1));
                    System.out.println(a);
                    double b = Double.parseDouble(listString.get(index1+1));
                    System.out.println(b);
                    double result = Double.parseDouble(listString.get(index1-1)) * Double.parseDouble(listString.get(index1+1));
                    String resultString = Double.toString(result);
                    listString.remove(index1-1);
                    listString.remove(index1);
                    listString.remove(index1-1);
                    listString.add(index1-1, resultString);
                }
            }
        }
        while(listString.contains("/")){
            for (int i = 0; i < listString.size(); i++) {
                if (listString.get(i).equals("/")){
                    int index1 = i;
                    double a = Double.parseDouble(listString.get(index1-1));
                    System.out.println(a);
                    double b = Double.parseDouble(listString.get(index1+1));
                    System.out.println(b);
                    double result = Double.parseDouble(listString.get(index1-1)) / Double.parseDouble(listString.get(index1+1));
                    String resultString = Double.toString(result);
                    listString.remove(index1-1);
                    listString.remove(index1);
                    listString.remove(index1-1);
                    listString.add(index1-1, resultString);
                }
            }
        }
        while(listString.contains("-") ){
            for (int i = 0; i < listString.size(); i++) {
                int index1 = 0;
                if (listString.get(i).equals("-") && i != 0){
                    index1 = i;
                    double a = Double.parseDouble(listString.get(index1-1));
                    System.out.println(a);
                    double b = Double.parseDouble(listString.get(index1+1));
                    System.out.println(b);
                    double result = a - b;
                    String resultString = Double.toString(result);
                    listString.remove(index1-1);
                    listString.remove(index1);
                    listString.remove(index1-1);
                    listString.add(index1-1, resultString);
                    System.out.println(listString);
                    break;
                } else if (listString.get(i).equals("-") && i == 0){
                    double a = 0;
                    double b = Double.parseDouble(listString.get(1));
                    double result = a - b;
                    String resultString = Double.toString(result);
                    listString.remove(0);
                    listString.remove(0);
                    listString.add(0, resultString);
                    System.out.println(listString);
                }
            }
        }

    }

}



