import java.util.ArrayList;
import java.util.List;

class KindergartenGarden {

    private final String[] rows;

    KindergartenGarden(String garden) {
        this.rows = garden.split("\n");
    }

    List<Plant> getPlantsOfStudent(String student) {
        String[] students = {"Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry"};

        int studentIndex = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(student)) {
                studentIndex = i;
                break;
            }
        }

        if (studentIndex == -1) {
            throw new IllegalArgumentException("Unknown student: " + student);
        }

        int startIndex = studentIndex * 2;

        List<Plant> plants = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            char plantCode1 = rows[i].charAt(startIndex);
            char plantCode2 = rows[i].charAt(startIndex + 1);

            plants.add(Plant.getPlant(plantCode1));
            plants.add(Plant.getPlant(plantCode2));
        }

        return plants;
    }
}
