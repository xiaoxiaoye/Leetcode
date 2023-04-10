package leetcode.leetcode8;

class Solution {
    public int myAtoiComplex(String str) {
        str = str.trim();
        if ("".equals(str)) {
            return 0;
        }

        if ("+".equals(str) || "-".equals(str))
            return 0;

        int right = 0;
        if (!Character.isDigit(str.charAt(right)) && str.charAt(right) != '+' && str.charAt(right) != '-') {
            return 0;
        }
        right++;

        if (str.length() >= 2) {
            if (str.charAt(0) == '+' || str.charAt(0) == '-') {
                if (Character.isDigit(str.charAt(right))) {
                    right++;
                } else {
                    return 0;
                }
            } else {
                if (Character.isDigit(str.charAt(right))) {
                    right++;
                }
            }
        }

        while (right < str.length() && Character.isDigit(str.charAt(right))) {
            right++;
        }

        long res = 1;
        int sign = 1;
        int i = 1;
        if (str.charAt(0) == '-') {
            sign = -1;
            res = (str.charAt(1) - '0') * sign;
            i = 2;
        } else if (str.charAt(0) == '+') {
            res = str.charAt(1) - '0';
            i = 2;
        } else {
            res = str.charAt(0) - '0';
        }

        for (; i < right; i++) {
            if (sign == -1) {
                res = res * 10 - (str.charAt(i) - '0');
            } else {
                res = res * 10 + (str.charAt(i) - '0');
            }
            if (res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) res;
    }

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int i = 0;
        int flag = 1;
        if (str.charAt(0) == '-') {
            i++;
            flag = -1;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        int res = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            char ch = str.charAt(i);

            if (flag > 0 && res > Integer.MAX_VALUE / 10) {
                return Integer.MAX_VALUE;
            }else if (flag > 0 && res == Integer.MAX_VALUE / 10 && ch - '0' > Integer.MAX_VALUE % 10) {
                return Integer.MAX_VALUE;
            }else if (flag < 0 && -res < Integer.MIN_VALUE / 10) {
                return Integer.MIN_VALUE;
            }else if (flag < 0 && -res == Integer.MIN_VALUE / 10 && -(ch - '0') < Integer.MIN_VALUE % 10) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + (ch - '0');
        }

        return res * flag;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String param = "2147483648";
        int r = s.myAtoi(param);
        System.out.println(r == 2147483647);

        String param1 = "-3.12";
        int r1 = s.myAtoi(param1);
        System.out.println(r1 == -3);

        String param2 = "  -42";
        int r2 = s.myAtoi(param2);
        System.out.println(r2 == -42);

        String param3 = "4193 with words";
        int r3 = s.myAtoi(param3);
        System.out.println(r3 == 4193);

        String param4 = "words and 987";
        int r4 = s.myAtoi(param4);
        System.out.println(r4 == 0);

        String param5 = "-91283472332";
        int r5 = s.myAtoi(param5);
        System.out.println(r5 == Integer.MIN_VALUE);

        String param6 = "-+";
        int r6 = s.myAtoi(param6);
        System.out.println(r6 == 0);

        String param7 = "-1";
        int r7 = s.myAtoi(param7);
        System.out.println(r7 == -1);

        String param8 = "1";
        int r8 = s.myAtoi(param8);
        System.out.println(r8 == 1);
    }
}