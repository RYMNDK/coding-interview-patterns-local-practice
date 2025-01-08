package CodeRunner;

import java.util.List;
import Backtracking.*;

public class Backtracking {
    public static void main(String[] args) {
        List<String> words = PhoneKeypadCombinations.Solution("234");
        System.out.println(words.size());
        for (String word : words) {
            System.out.println(word);
        }
    }
}
