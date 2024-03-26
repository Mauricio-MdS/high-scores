import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class HighScores {

    private final List<Integer> highScores;

    public HighScores(List<Integer> highScores) {
        this.highScores = new ArrayList<>(highScores);
    }

    List<Integer> scores() {
        return new ArrayList<>(highScores);
    }

    Integer latest() {
        return highScores.get(highScores.size() - 1);
    }

    Integer personalBest() {
        return highScores.stream().max(Integer::compareTo).orElse(0);
    }

    List<Integer> personalTopThree() {
        return new ArrayList<>(highScores).stream()
                .sorted(Comparator.reverseOrder())
                .toList()
                .subList(0, Integer.min(3, highScores.size()));
    }

}
