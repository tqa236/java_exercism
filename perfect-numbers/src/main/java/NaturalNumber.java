import java.util.stream.IntStream;

class NaturalNumber {
    private int number;
    NaturalNumber(int number){
        if (number <= 0){
            throw new IllegalArgumentException("You must supply"
            + " a natural number (positive integer)");
        }
        this.number = number;
    }

    Classification getClassification(){
        IntStream stream = IntStream.rangeClosed(1, number/2);
        int aliquotSum = stream.filter(n-> number % n == 0).sum();
        return (aliquotSum == number)? Classification.PERFECT:
        ((aliquotSum > number)?Classification.ABUNDANT :
        Classification.DEFICIENT);
    }
}
