public class BowlingGame {
    private final int[] rolls = new int[21]; // Max rolls in a game
    private int currentRoll = 0;

    public void roll(int pins) {
        // Check if game is already over
        if (isGameOver()) {
            throw new IllegalStateException("Cannot roll after game is over");
        }

        // Validate roll
        if (pins < 0) {
            throw new IllegalStateException("Negative roll is invalid");
        }
        
        if (pins > 10) {
            throw new IllegalStateException("Pin count exceeds pins on the lane");
        }

        // Handle specific validation for the current roll
        validateRoll(pins);
        
        // Record the roll
        rolls[currentRoll++] = pins;
    }

    private void validateRoll(int pins) {
        // First 9 frames
        if (currentRoll < 18) {
            // If this is the second roll in a frame
            if (currentRoll % 2 == 1 && !isStrike(currentRoll - 1)) {
                if (rolls[currentRoll - 1] + pins > 10) {
                    throw new IllegalStateException("Pin count exceeds pins on the lane");
                }
            }
        } 
        // 10th frame
        else {
            // First roll in 10th frame - no special validation needed beyond the 0-10 check
            if (currentRoll == 18) {
                return;
            }
            // Second roll in 10th frame
            else if (currentRoll == 19) {
                // If first roll was not a strike, then first + second cannot exceed 10
                if (rolls[18] != 10 && rolls[18] + pins > 10) {
                    throw new IllegalStateException("Pin count exceeds pins on the lane");
                }
            }
            // Third roll in 10th frame
            else if (currentRoll == 20) {
                // If second roll was a strike, no extra validation needed for third roll
                if (rolls[19] == 10) {
                    return;
                }
                
                // If first roll was a strike but second roll was not a strike,
                // then second + third cannot exceed 10
                if (rolls[18] == 10 && rolls[19] < 10 && rolls[19] + pins > 10) {
                    throw new IllegalStateException("Pin count exceeds pins on the lane");
                }
            }
        }
    }

    public int score() {
        // Make sure we have a complete game
        if (!isGameComplete()) {
            throw new IllegalStateException("Score cannot be taken until the end of the game");
        }
        
        int score = 0;
        int frameIndex = 0;
        
        // Score each of the 10 frames
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++; // Move to next frame
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2; // Move to next frame (skip the two rolls in this frame)
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2; // Move to next frame (skip the two rolls in this frame)
            }
        }
        
        return score;
    }
    
    private boolean isGameOver() {
        // Not enough rolls to complete a minimum game
        if (currentRoll < 20) {
            // If we have less than 20 rolls, need to check if we have strikes that could
            // make a complete game with fewer total rolls
            int frameCount = 0;
            int rollIndex = 0;
            
            while (frameCount < 10 && rollIndex < currentRoll) {
                if (rolls[rollIndex] == 10) { // Strike
                    frameCount++;
                    rollIndex++;
                } else {
                    frameCount++;
                    rollIndex += 2;
                }
            }
            
            // If we haven't completed 10 frames, game is not over
            if (frameCount < 10) {
                return false;
            }
        }
        
        // Check 10th frame scenarios
        int frameIndex = 0;
        for (int i = 0; i < 9; i++) {
            if (rolls[frameIndex] == 10) { // Strike
                frameIndex++;
            } else { // Open frame or spare
                frameIndex += 2;
            }
        }
        
        // frameIndex now points to the first roll of 10th frame
        
        // Case 1: 10th frame was open (neither strike nor spare)
        if (rolls[frameIndex] != 10 && (rolls[frameIndex] + rolls[frameIndex + 1] < 10)) {
            return currentRoll >= frameIndex + 2; // Game ends after 2 rolls in 10th frame
        }
        
        // Case 2: 10th frame was a spare
        if (rolls[frameIndex] != 10 && (rolls[frameIndex] + rolls[frameIndex + 1] == 10)) {
            return currentRoll >= frameIndex + 3; // Game ends after 3 rolls (1 bonus)
        }
        
        // Case 3: 10th frame was a strike
        if (rolls[frameIndex] == 10) {
            return currentRoll >= frameIndex + 3; // Game ends after 3 rolls (2 bonus)
        }
        
        return false;
    }
    
    private boolean isGameComplete() {
        if (currentRoll < 20) {
            // Check if we have completed 10 frames with strikes
            int frameCount = 0;
            int rollIndex = 0;
            
            while (frameCount < 10 && rollIndex < currentRoll) {
                if (rolls[rollIndex] == 10) { // Strike
                    frameCount++;
                    rollIndex++;
                } else {
                    frameCount++;
                    rollIndex += 2;
                }
            }
            
            if (frameCount < 10) {
                return false;
            }
        }
        
        // Find the index of the 10th frame's first roll
        int frameIndex = 0;
        for (int i = 0; i < 9; i++) {
            if (rolls[frameIndex] == 10) { // Strike
                frameIndex++;
            } else { // Open frame or spare
                frameIndex += 2;
            }
        }
        
        // Check if we have enough rolls for 10th frame
        if (rolls[frameIndex] == 10) { // Strike in 10th frame
            return currentRoll >= frameIndex + 3; // Need two more rolls
        } else if (rolls[frameIndex] + rolls[frameIndex + 1] == 10) { // Spare in 10th frame
            return currentRoll >= frameIndex + 3; // Need one more roll
        } else { // Open frame in 10th frame
            return currentRoll >= frameIndex + 2;
        }
    }

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }

    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

    private int strikeBonus(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private int spareBonus(int rollIndex) {
        return rolls[rollIndex + 2];
    }

    private int sumOfBallsInFrame(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }
}