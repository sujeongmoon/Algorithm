class Solution {
    public void reverseString(char[] s) {
        char[] clone = s.clone();
        for (int i = s.length-1, j = 0; i >= 0; i--, j++) {
            s[i] = clone[j];
        }

    }
}