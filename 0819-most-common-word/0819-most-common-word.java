class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
       
        HashSet<String> bannedSet = new HashSet<>();
        for(String bannedWord : banned) {
            bannedSet.add(bannedWord);
        }

        HashMap<String, Integer> map = new HashMap<>();
        String[] words = paragraph.toLowerCase().replaceAll("[^a-zA-Z]", " ").split("\\s+");

        for (String word : words) {
            if (!word.isEmpty() && !bannedSet.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        String result = "";
        int max = 0;
        for (String word : map.keySet()) {
            if (map.get(word) > max) {
                max = map.get(word);
                result = word;
            }
        }
        
        return result;
    }
}