public class Task2 {
    public static String cipher(String text, String hash, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        char[] textCharsArray = text.toCharArray();
        char[] hashCharArray = hash.toCharArray();
        for (int i = 0; i < textCharsArray.length; i++) {
            char character = textCharsArray[i];
            char hashChar = hashCharArray[i%hashCharArray.length];
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int originalHashAlphabetPosition = hashChar - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + ((encrypt ? 1 : -1) * originalHashAlphabetPosition)) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String enc = cipher("Test gotcha", "abc", true);
        System.out.println(enc);
        System.out.println(cipher(enc, "abc", false));
    }
}