
public class DecimalToBaseX {

    public static String algorithm(int dec, int base) {
        StringBuilder hexValue = new StringBuilder();
        StringBuilder nonHexValue = new StringBuilder();

        if (base == 10) {
            System.out.println(dec);
        }

        int decTemp = dec;
        int[] temp;
        int size = 0;

        while (decTemp != 0) {
            decTemp /= base;
            size++;
        }

        if (size < 1) {
            return "invalid";
        }
        System.out.println(size);
        temp = new int[size];
        temp[size-1] = dec;

        for (int i = size-2; i >= 0; i--) {
            temp[i] = (dec /= base);
        }

        int[] converted = new int[size];
        String[] hex = new String[size];

        if (base < 10 || base > 36) {
            for (int i = 0; i < converted.length; i++) {
                converted[i] = temp[i] % base;
            }
        } else {
            for (int i = 0; i < hex.length; i++) {
                if (temp[i] % base == 10) {
                    hex[i] = "A";
                } else if (temp[i] % base == 11) {
                    hex[i] = "B";
                } else if (temp[i] % base == 12) {
                    hex[i] = "C";
                } else if (temp[i] % base == 13) {
                    hex[i] = "D";
                } else if (temp[i] % base == 14) {
                    hex[i] = "E";
                } else if (temp[i] % base == 15) {
                    hex[i] = "F";
                } else if (temp[i] % base == 16) {
                    hex[i] = "G";
                } else if (temp[i] % base == 17) {
                    hex[i] = "H";
                } else if (temp[i] % base == 18) {
                    hex[i] = "I";
                } else if (temp[i] % base == 19) {
                    hex[i] = "J";
                } else if (temp[i] % base == 20) {
                    hex[i] = "K";
                } else if (temp[i] % base == 21) {
                    hex[i] = "L";
                } else if (temp[i] % base == 22) {
                    hex[i] = "M";
                } else if (temp[i] % base == 23) {
                    hex[i] = "N";
                } else if (temp[i] % base == 24) {
                    hex[i] = "O";
                } else if (temp[i] % base == 25) {
                    hex[i] = "P";
                } else if (temp[i] % base == 26) {
                    hex[i] = "Q";
                } else if (temp[i] % base == 27) {
                    hex[i] = "R";
                } else if (temp[i] % base == 28) {
                    hex[i] = "S";
                } else if (temp[i] % base == 29) {
                    hex[i] = "T";
                } else if (temp[i] % base == 30) {
                    hex[i] = "U";
                } else if (temp[i] % base == 31) {
                    hex[i] = "V";
                } else if (temp[i] % base == 32) {
                    hex[i] = "W";
                } else if (temp[i] % base == 33) {
                    hex[i] = "X";
                } else if (temp[i] % base == 34) {
                    hex[i] = "Y";
                } else if (temp[i] % base == 35) {
                    hex[i] = "Z";
                } else {
                    hex[i] = String.valueOf(temp[i] % base);
                }
            }
        }

        if (base < 10 || base > 36) {
            for (int value : converted) { // prints out each element of array
                nonHexValue.append(value).append(" ");
            }
            return nonHexValue.toString();
        } else {
            for (String value : hex) { // prints out each element of array
                hexValue.append(value).append(" ");
            }
            return hexValue.toString();
        }
    }
}
