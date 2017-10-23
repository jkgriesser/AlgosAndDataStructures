public class ExcelOrdinal {
  
    public static void main (String[] args) {
        int ordinal = 27;
        if (ordinal < 27) {
            char c = (char) ('A' + (ordinal - 1));
            System.out.print(c);
        } else {
            int ordinalLow = (ordinal - 1) % 26;
            int ordinalHigh = (ordinal - 1) / 26;
            System.out.print((char) ('A' + (ordinalHigh - 1)));
            System.out.print((char) ('A' + ordinalLow));
        }
    }
}