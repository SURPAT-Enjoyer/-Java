public enum Symbol {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10),
    XI(11),
    XII (12),
    XIII(13),
    XIV(14),
    XV(15),
    XVI(16),
    XVII(17),
    XVIII(18),
    XIX(19),
    XX(20);

    private final int value;

    Symbol(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean contains(String value) {

        for (Symbol s : Symbol.values()) {
            if (s.name().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static Symbol parse(String value) throws Exception {
        for (Symbol s : Symbol.values()) {
            if (s.name().equals(value)) {
                return s;
            }
        }
        throw new Exception("Неверный формат римского числа");
    }

    public static Symbol parse(int value) throws Exception {
        for (Symbol s : Symbol.values()) {
            if (s.getValue() == value) {
                return s;
            }
        }
        throw new Exception("Неверный формат римского числа");
    }
}
