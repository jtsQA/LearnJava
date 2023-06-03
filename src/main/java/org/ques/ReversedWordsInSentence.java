package org.ques;

public class ReversedWordsInSentence {

    public static void main(String[] args) {

        String str = "i love programming very much";
        String reversed = reverseWords(str);
        System.out.println("Reversed sentence: " + reversed);

    }

    private static String reverseWords(String str) {

        StringBuilder reversedSentence = new StringBuilder();
        String[] words = str.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence.append(words[i]).append(" ");
        }

        return reversedSentence.toString().trim();
    }
}
