import java.util.stream.IntStream;
import java.util.Random;

class DnDCharacter {
    private int strength = ability();
    private int dexterity = ability();
    private int constitution = ability();
    private int intelligence = ability();
    private int wisdom = ability();
    private int charisma = ability();
    private int hitpoints = 10 + modifier(constitution);


    int ability() {
        Random rand = new Random();
        int[] random_ability = new int[4];
        for (int i = 0; i < 4; i = i + 1){
            random_ability[i] = 1 + rand.nextInt(6);
        }
        return IntStream.of(random_ability).sum() - IntStream.of(random_ability).min().orElse(0);
    }

    int modifier(int input) {
        return (int)Math.floor((input - 10)/2.0);
    }

    int getStrength(){
        return strength;
    }
    int getDexterity(){
        return dexterity;
    }
    int getConstitution(){
        return constitution;
    }
    int getIntelligence(){
        return intelligence;
    }
    int getWisdom(){
        return wisdom;
    }
    int getCharisma(){
        return charisma;
    }
    int getHitpoints(){
        return hitpoints;
    }
}
