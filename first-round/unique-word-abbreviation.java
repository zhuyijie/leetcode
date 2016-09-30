public class ValidWordAbbr {

    Map<String, String> reversed;

    public ValidWordAbbr(String[] dictionary) {
        this.reversed = new HashMap<>();
        for (String word : dictionary) {
            String abbred = abbr(word);
            if (this.reversed.containsKey(abbred)) {
                if (!this.reversed.get(abbred).equals(word)) {
                    this.reversed.put(abbred, ""); // empty string denotes duplicate
                }
            } else {
                this.reversed.put(abbred, word);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbred = abbr(word);
        return !this.reversed.containsKey(abbred) 
            || (this.reversed.get(abbred).equals(word));
    }

    String abbr(String word) {
        if (word.length() <= 2) {
            return word;
        }
        return "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
    }

}
