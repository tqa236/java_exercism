class QueenAttackCalculator {
    private Queen queen1;
    private Queen queen2;

    public QueenAttackCalculator(Queen queen1, Queen queen2) {
        if (queen1 == null || queen2 == null) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }
        if (queen1.getRow() == queen2.getRow() && queen1.getColumn() == queen2.getColumn()) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
        this.queen1 = queen1;
        this.queen2 = queen2;
    }

    public boolean canQueensAttackOneAnother() {
        int row1 = queen1.getRow();
        int col1 = queen1.getColumn();
        int row2 = queen2.getRow();
        int col2 = queen2.getColumn();

        // Check if they are in the same row or column
        if (row1 == row2 || col1 == col2) {
            return true;
        }

        // Check if they are in the same diagonal
        if (Math.abs(row1 - row2) == Math.abs(col1 - col2)) {
            return true;
        }

        return false;
    }
}
