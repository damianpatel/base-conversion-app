
public class DecimalToBaseX {
    public static boolean isNegative = false;
    public static String algorithm(double dec, int base) {
        StringBuilder hexValue = new StringBuilder();
        StringBuilder nonHexValue = new StringBuilder();

        double decTemp = dec;
        double[] temp;
        int size = 0;

        System.out.println("decTemp: " + decTemp);
        while (decTemp != 0) {
            decTemp = (int) (decTemp / base);
            size++;
        }

        if (size < 1) {
            return "invalid";
        }
        System.out.println("Size: " + size);
        temp = new double[size];
        temp[size-1] = dec;

        for (int i = size-2; i >= 0; i--) {
            temp[i] = (dec /= base);
        }

        int[] converted = new int[size];
        String[] hex = new String[size];

        if (base < 10 || base > 36) {
            for (int i = 0; i < converted.length; i++) {
                converted[i] = (int) (temp[i] % base);
            }
        } else {
            for (int i = 0; i < hex.length; i++) {
                if ((int) temp[i] % base == 10) {
                    hex[i] = "A";
                } else if ((int) temp[i] % base == 11) {
                    hex[i] = "B";
                } else if ((int) temp[i] % base == 12) {
                    hex[i] = "C";
                } else if ((int) temp[i] % base == 13) {
                    hex[i] = "D";
                } else if ((int) temp[i] % base == 14) {
                    hex[i] = "E";
                } else if ((int) temp[i] % base == 15) {
                    hex[i] = "F";
                } else if ((int) temp[i] % base == 16) {
                    hex[i] = "G";
                } else if ((int) temp[i] % base == 17) {
                    hex[i] = "H";
                } else if ((int) temp[i] % base == 18) {
                    hex[i] = "I";
                } else if ((int) temp[i] % base == 19) {
                    hex[i] = "J";
                } else if ((int) temp[i] % base == 20) {
                    hex[i] = "K";
                } else if ((int) temp[i] % base == 21) {
                    hex[i] = "L";
                } else if ((int) temp[i] % base == 22) {
                    hex[i] = "M";
                } else if ((int) temp[i] % base == 23) {
                    hex[i] = "N";
                } else if ((int) temp[i] % base == 24) {
                    hex[i] = "O";
                } else if ((int) temp[i] % base == 25) {
                    hex[i] = "P";
                } else if ((int) temp[i] % base == 26) {
                    hex[i] = "Q";
                } else if ((int) temp[i] % base == 27) {
                    hex[i] = "R";
                } else if ((int) temp[i] % base == 28) {
                    hex[i] = "S";
                } else if ((int) temp[i] % base == 29) {
                    hex[i] = "T";
                } else if ((int) temp[i] % base == 30) {
                    hex[i] = "U";
                } else if ((int) temp[i] % base == 31) {
                    hex[i] = "V";
                } else if ((int) temp[i] % base == 32) {
                    hex[i] = "W";
                } else if ((int) temp[i] % base == 33) {
                    hex[i] = "X";
                } else if ((int) temp[i] % base == 34) {
                    hex[i] = "Y";
                } else if ((int) temp[i] % base == 35) {
                    hex[i] = "Z";
                } else {
                    hex[i] = String.valueOf((int) temp[i] % base);
                }
            }
        }

        if (base < 10 || base > 36) {
            // appends each element of array
            for (int value : converted) {
                nonHexValue.append(value).append(" ");
            }
            if (isNegative) {
                return "-" + nonHexValue.toString();
            } else {
                return nonHexValue.toString();
            }
        } else {
            // appends each element of array
            for (String value : hex) {
                hexValue.append(value).append(" ");
            }
            if (isNegative) {
                return "-" + hexValue.toString();
            } else {
                return hexValue.toString();
            }
        }
    }
}
