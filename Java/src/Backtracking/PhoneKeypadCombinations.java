package Backtracking;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class PhoneKeypadCombinations {
    public static List<String> Solution(String digits) {
        Map<Character, String> keypadMap = new HashMap<>();
        keypadMap.put('2', "abc");
        keypadMap.put('3', "def");
        keypadMap.put('4', "ghi");
        keypadMap.put('5', "jkl");
        keypadMap.put('6', "mno");
        keypadMap.put('7', "pqrs");
        keypadMap.put('8', "tuv");
        keypadMap.put('9', "wxyz");
        ArrayList<String> res = new ArrayList<>();
        backtrack(0, new StringBuilder(), digits, keypadMap, res);
        return res;
    }

    private static void backtrack(int index, StringBuilder currCombination, String digits, Map<Character, String> keypadMap, List<String> res) {
        // Termination condition: if all digits have been considered, add the
        // current combination to the output list.
        if (index == digits.length()) {
            res.add(currCombination.toString());
            return;
        }
        for (Character letter: keypadMap.get(digits.charAt(index)).toCharArray()) {
            // Add the current letter.
            currCombination.append(letter);
            // Recursively explore all paths that branch from this combination.
            backtrack(index + 1, currCombination, digits, keypadMap, res);
            // Backtrack by removing the letter we just added.
            currCombination.deleteCharAt(currCombination.length() - 1);
        }
    }
}
