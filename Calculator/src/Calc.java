import java.util.Scanner;
import java.util.*;
public class Calc {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println(calc(scanner.nextLine()));
    }

    public static String calc(String SourceString) throws Exception {

        int result = 0;
        int one_condition = 0;
        int Z1 = 0;
        //int Z2 = 0;
        String[] Roman_To_Arab = new String[3];


        String[] Roman_Numerals = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        String[] ArrayExpression = SourceString.split(" ");

        for (int i = 0; i < 10; i++) {
            if (Roman_Numerals[i].equals(ArrayExpression[0])) {
                Z1++;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (Roman_Numerals[i].equals(ArrayExpression[2])) {
                Z1++;
            }
        }

        if (Z1 == 1) {
            throw new Exception("Ошибка");
        }

        if (Z1 == 2) {
            switch (ArrayExpression[0]) {
                case "I":
                    Roman_To_Arab[0] = "1";
                    break;

                case "II":
                    Roman_To_Arab[0] = "2";

                    break;
                case "III":
                    Roman_To_Arab[0] = "3";
                    break;

                case "IV":
                    Roman_To_Arab[0] = "4";
                    break;

                case "V":
                    Roman_To_Arab[0] = "5";
                    break;

                case "VI":
                    Roman_To_Arab[0] = "6";

                    break;
                case "VII":
                    Roman_To_Arab[0] = "7";
                    break;

                case "VIII":
                    Roman_To_Arab[0] = "8";
                    break;

                case "IX":
                    Roman_To_Arab[0] = "9";
                    break;

                case "X":
                    Roman_To_Arab[0] = "10";
            }

            switch (ArrayExpression[2]) {
                case "I":
                    Roman_To_Arab[2] = "1";
                    break;

                case "II":
                    Roman_To_Arab[2] = "2";

                    break;
                case "III":
                    Roman_To_Arab[2] = "3";
                    break;

                case "IV":
                    Roman_To_Arab[2] = "4";
                    break;

                case "V":
                    Roman_To_Arab[2] = "5";
                    break;

                case "VI":
                    Roman_To_Arab[2] = "6";

                    break;
                case "VII":
                    Roman_To_Arab[2] = "7";
                    break;

                case "VIII":
                    Roman_To_Arab[2] = "8";
                    break;

                case "IX":
                    Roman_To_Arab[2] = "9";
                    break;

                case "X":
                    Roman_To_Arab[2] = "10";
            }
        }
            if (Z1 == 0) {
                one_condition = Integer.parseInt(ArrayExpression[0]) + Integer.parseInt(ArrayExpression[2]);
                if (one_condition <= 20) {
                    switch (ArrayExpression[1]) {
                        case "+":
                            result = Integer.parseInt(ArrayExpression[0]) + Integer.parseInt(ArrayExpression[2]);
                            return (String.valueOf(result));
                        case "/":
                            result = Integer.parseInt(ArrayExpression[0]) / Integer.parseInt(ArrayExpression[2]);
                            return (String.valueOf(result));
                        case "*":
                            result = Integer.parseInt(ArrayExpression[0]) * Integer.parseInt(ArrayExpression[2]);
                            return (String.valueOf(result));
                        case "-":
                            result = Integer.parseInt(ArrayExpression[0]) - Integer.parseInt(ArrayExpression[2]);
                            return (String.valueOf(result));
                    }
                }
            }

        if (Z1 == 2) {

            switch (ArrayExpression[1]) {
                case "+":
                    result = Integer.parseInt(Roman_To_Arab[0]) + Integer.parseInt(Roman_To_Arab[2]);
                    if (result < 1) {
                        throw new Exception("Ошибка");
                    }
                    return String.valueOf(result);
                case "/":
                    result = Integer.parseInt(Roman_To_Arab[0]) / Integer.parseInt(Roman_To_Arab[2]);
                    if (result < 1) {
                        throw new Exception("Ошибка");
                    }
                    return (intToRoman(result));
                case "*":
                    result = Integer.parseInt(Roman_To_Arab[0]) * Integer.parseInt(Roman_To_Arab[2]);
                    if (result < 1) {
                        throw new Exception("Ошибка");
                    }
                    return (intToRoman(result));
                case "-":
                    result = Integer.parseInt(Roman_To_Arab[0]) - Integer.parseInt(Roman_To_Arab[2]);
                    if (result < 1) {
                        throw new Exception("Ошибка");
                    }
                    return (intToRoman(result));
            }
            return ("Ошибка");
        }
        throw new Exception();
    }


    public static String intToRoman(int number) throws Exception {
        if (number > 100 || number <= 0) {
            throw new Exception("Ошибка");

        }
        StringBuilder result = new StringBuilder();
        for(Integer key : units.descendingKeySet()) {
            while (number >= key) {
                number -= key;
                result.append(units.get(key));
            }
        }
        return result.toString();
    }

    private static final NavigableMap<Integer, String> units;
    static {
        NavigableMap<Integer, String> initMap = new TreeMap<>();
        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(50, "L");
        initMap.put(40, "XL");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(1, "I");
        units = Collections.unmodifiableNavigableMap(initMap);
    }
 }
