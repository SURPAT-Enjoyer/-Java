import java.util.*;

public enum Symbol {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100),
    CD(400),
    D(500),
    CM(900),
    M(1000);

    private final int value;

    Symbol(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean check(String value) {
        try {
            toArabic(value);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String toRoman(int value) throws Exception {
        if ((value <= 0) || (value > 4000)) {
            throw new Exception(value + " число не в диапазоне");
        }
        List<Symbol> romanNumerals = Arrays.asList(Symbol.values()) ;
        Collections.reverse(romanNumerals);
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while ((value > 0) && (i < romanNumerals.size())) {
            Symbol currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= value) {
                sb.append(currentSymbol.name());
                value -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static int toArabic(String input) throws Exception {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<Symbol> romanNumerals = Arrays.asList(Symbol.values()) ;
        Collections.reverse(romanNumerals);

        int i = 0;

        while ((!romanNumeral.isEmpty()) && (i < romanNumerals.size())) {
            Symbol symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (!romanNumeral.isEmpty()) {
            throw new Exception(input + " невозможно сконвертировать в римское число");
        }

        return result;
    }
}
