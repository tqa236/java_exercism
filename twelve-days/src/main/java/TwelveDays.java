class TwelveDays {
    // List of gifts corresponding to each day
    private static final String[] GIFTS = {
        "a Partridge in a Pear Tree",
        "two Turtle Doves",
        "three French Hens",
        "four Calling Birds",
        "five Gold Rings",
        "six Geese-a-Laying",
        "seven Swans-a-Swimming",
        "eight Maids-a-Milking",
        "nine Ladies Dancing",
        "ten Lords-a-Leaping",
        "eleven Pipers Piping",
        "twelve Drummers Drumming"
    };

    // Generates a verse for a specific day
    String verse(int verseNumber) {
        StringBuilder verse = new StringBuilder("On the " + getOrdinal(verseNumber) + " day of Christmas my true love gave to me: ");
        // Add gifts in reverse order
        for (int i = verseNumber - 1; i >= 0; i--) {
            // The last gift should be prefixed with "and"
            if (i == 0 && verseNumber > 1) {
                verse.append("and ");
            }
            verse.append(GIFTS[i]);
            if (i > 0) {
                verse.append(", ");
            }
        }
        verse.append(".\n");
        return verse.toString();
    }

    // Generates multiple verses from startVerse to endVerse
    String verses(int startVerse, int endVerse) {
        StringBuilder song = new StringBuilder();
        for (int i = startVerse; i <= endVerse; i++) {
            song.append(verse(i));
            if (i < endVerse) {
                song.append("\n");
            }
        }
        return song.toString();
    }

    // Sings the entire song (from day 1 to day 12)
    String sing() {
        return verses(1, 12);
    }

    // Helper method to get the ordinal representation of a number (1 -> "first", 2 -> "second", etc.)
    private String getOrdinal(int number) {
        switch (number) {
            case 1: return "first";
            case 2: return "second";
            case 3: return "third";
            case 4: return "fourth";
            case 5: return "fifth";
            case 6: return "sixth";
            case 7: return "seventh";
            case 8: return "eighth";
            case 9: return "ninth";
            case 10: return "tenth";
            case 11: return "eleventh";
            case 12: return "twelfth";
            default: return "";
        }
    }
}
