import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class DnDCharacter {
    private static final Random random = new Random();

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hitpoints;

    public DnDCharacter() {
        this.strength = generateAbilityScore();
        this.dexterity = generateAbilityScore();
        this.constitution = generateAbilityScore();
        this.intelligence = generateAbilityScore();
        this.wisdom = generateAbilityScore();
        this.charisma = generateAbilityScore();
        this.hitpoints = 10 + modifier(constitution);
    }

    public int ability(List<Integer> diceRolls) {
        List<Integer> mutableList = new ArrayList<>(diceRolls);

        Collections.sort(mutableList, Collections.reverseOrder());

        return mutableList.stream()
                        .limit(3)
                        .mapToInt(Integer::intValue)
                        .sum();
    }



    private int generateAbilityScore() {
        List<Integer> diceRolls = rollDice();
        return ability(diceRolls);
    }

    public List<Integer> rollDice() {
        return random.ints(4, 1, 7).boxed().collect(Collectors.toList());
    }

    public int modifier(int score) {
        return (int) Math.floor((score - 10) / 2.0);
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getHitpoints() {
        return hitpoints;
    }
}
