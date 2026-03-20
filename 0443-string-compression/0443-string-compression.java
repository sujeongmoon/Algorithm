class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;

        while (read < chars.length) {
            char curChar = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == curChar) {
                read++;
                count++;
            }

            chars[write++] = curChar;

            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}