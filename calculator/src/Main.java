import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private final static String EXPRESSION_REGEX = "(.*)(\\+|-|\\/|\\*)(.*)";
    public static void main(String[] args) throws Exception {
        Pattern pattern = Pattern.compile(EXPRESSION_REGEX);
        while (true) {
            Scanner sc = new Scanner(System.in);
            String inputString = sc.nextLine();
            Matcher matcher = pattern.matcher(inputString);
            if(matcher.matches()){
                String operandFirst = matcher.group(1).trim();
                String operandSecond = matcher.group(3).trim();
                String operator = matcher.group(2);
                if(Symbol.contains(operandFirst) && Symbol.contains(operandSecond)){
                    int answer = getAnswer(operator, Symbol.parse(operandFirst).getValue(), Symbol.parse(operandSecond).getValue());
                    System.out.println(Symbol.parse(answer));
                    continue;
                } else if(checkInt(operandFirst) && checkInt(operandSecond)) {
                    int answer = getAnswer(operator, Integer.parseInt(operandFirst), Integer.parseInt(operandSecond));
                    System.out.println(answer);
                    continue;
                } else {
                    throw new Exception("Используются одновременно разные системы счисления");
                }
            } else {
                throw new Exception("Неверный формат");
            }
        }
    }

    private static int getAnswer(String operator, int operandFirst, int operandSecond) {

        int answer = 0;
        if(operator.equals("+")){
            answer = operandFirst + operandSecond;
        }
        if(operator.equals("-")) {
            answer = operandFirst - operandSecond;
        }
        if(operator.equals("*")) {
            answer = operandFirst * operandSecond;
        }
        if(operator.equals("/")){
            answer = operandFirst / operandSecond;
        }
        return answer;
    }

    private static boolean checkInt(String value){
        return value.matches("\\d+");
    }
}