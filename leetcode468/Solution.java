package leetcode.leetcode468;

class Solution {
    public String validIPAddress(String IP) {
        if(isIPv4(IP)){
            return "IPv4";
        }

        if(isIPv6(IP)){
            return "IPv6";
        }

        return "Neither";
    }

    private boolean isIPv4(String IP){
        String[] segs = IP.split("\\.");
        if(segs.length != 4){
            return false;
        }
        if (IP.charAt(IP.length() - 1) == '.') {
            return false;
        }
        for(String seg: segs){
            if(seg.length() > 3 || seg.length() == 0){
                return false;
            }
            if (seg.length() > 1 && seg.charAt(0) == '0') {
                return false;
            }
            int sum = 0;
            for(char c: seg.toCharArray()){
                if(!Character.isDigit(c)){
                    return false;
                }
                sum = sum*10+(c-'0');
            }
            if(sum>255){
                return false;
            }
        }
        return true;
    }

    private boolean isIPv6(String IP){
        String[] segs = IP.split(":");
        if (segs.length != 8) {
            return false;
        }
        if (IP.charAt(IP.length()-1) == ':'){
            return false;
        }
        for (String seg : segs) {
            if (seg.length() == 0||seg.length()>4) {
                return false;
            }
            for (char c : seg.toCharArray()) {
                if (Character.isDigit(c)) {
                    continue;
                }
                if (Character.isAlphabetic(c)) {
                    char lower = Character.toLowerCase(c);
                    if ('a' > lower || lower > 'f') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String r = s.validIPAddress("172.16.256.1");
        System.out.println(r);

        String r1 = s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
        System.out.println(r1);
    }
}
