public class BowlingGame {
    private final int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        if (pins < 0) {
            throw new IllegalStateException("Negative roll is invalid");
        }
        if (pins > 10) {
            throw new IllegalStateException("Pin count exceeds pins on the lane");
        }
        if (currentRoll > 0 && currentRoll < 18 && rolls[currentRoll - 1] + pins > 10 && currentRoll % 2 == 1 && rolls[currentRoll - 2] != 10) {
            throw new IllegalStateException("Pin count exceeds pins on the lane");
        }
        if (currentRoll >= 18 && rolls[18] != 10 && rolls[18] + rolls[19] > 10 && currentRoll == 20) {
            throw new IllegalStateException("Pin count exceeds pins on the lane");
        }
        if (currentRoll >= 20 && (rolls[18] + rolls[19] < 10 || rolls[18] != 10) && currentRoll == 21) {
            throw new IllegalStateException("Cannot roll after game is over");
        }
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        if (currentRoll < 20 || (isStrike(18) && currentRoll < 21) || (isSpare(18) && currentRoll < 21)) {
            throw new IllegalStateException("Score cannot be taken until the end of the game");
        }
        return score;
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int sumOfBallsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }
}