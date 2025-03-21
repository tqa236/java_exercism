import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class HighScores {
    private List<Integer> scores;

    public HighScores(List<Integer> highScores) {
        this.scores = new ArrayList<>(highScores);
    }

    List<Integer> scores() {
        return new ArrayList<>(scores);
    }

    Integer latest() {
        if (scores.isEmpty()) {
            return null;
        }
        return scores.get(scores.size() - 1);
    }

    Integer personalBest() {
        if (scores.isEmpty()) {
            return null;
        }
        return Collections.max(scores);
    }

    List<Integer> personalTopThree() {
        List<Integer> sortedScores = new ArrayList<>(scores);
        sortedScores.sort(Collections.reverseOrder());

        List<Integer> topThree = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sortedScores.size()); i++) {
            topThree.add(sortedScores.get(i));
        }

        return topThree;
    }
}
