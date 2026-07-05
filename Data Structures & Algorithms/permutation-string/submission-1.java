class Solution {
   public boolean checkInclusion(String s1, String s2) {
        // Edge case: if s1 is longer than s2, return false immediately
        if (s1.length() > s2.length()) {
            return false;
        }

        // Create a frequency map for s1
        Map<Character, Integer> s1Map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

        // Create a frequency map for the sliding window of s2
        Map<Character, Integer> s2Map = new HashMap<>();
        int l = 0; // Left pointer

        // Initialize the window for the first len(s1) characters
        for (int r = 0; r < s1.length(); r++) {
            char ch = s2.charAt(r);
            s2Map.put(ch, s2Map.getOrDefault(ch, 0) + 1);
        }

        // Check if the first window is a valid permutation
        if (compareMaps(s1Map, s2Map)) {
            return true;
        }

        // Now slide the window across s2
        for (int r = s1.length(); r < s2.length(); r++) {
            // Add the new character in the window
            char newChar = s2.charAt(r);
            s2Map.put(newChar, s2Map.getOrDefault(newChar, 0) + 1);

            // Remove the character that is going out of the window
            char oldChar = s2.charAt(l);
            if (s2Map.get(oldChar) == 1) {
                s2Map.remove(oldChar);
            } else {
                s2Map.put(oldChar, s2Map.get(oldChar) - 1);
            }

            // Move the left pointer
            l++;

            // Compare the updated window map with s1's map
            if (compareMaps(s1Map, s2Map)) {
                return true;
            }
        }

        return false;
    }

    // Helper function to compare the two frequency maps
    private boolean compareMaps(Map<Character, Integer> s1Map, Map<Character, Integer> s2Map) {
        // If the sizes are different, the maps can't be equal
        if (s1Map.size() != s2Map.size()) {
            return false;
        }

        // Compare each character frequency
        for (char ch : s1Map.keySet()) {
            if (!s2Map.containsKey(ch) || !s2Map.get(ch).equals(s1Map.get(ch))) {
                return false;
            }
        }

        return true;
    }
}
