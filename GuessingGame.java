package ee.ttu.algoritmid.guessinggame;

import java.util.Arrays;
import java.util.Comparator;

public class GuessingGame {
    Teacher teacher;

    public GuessingGame(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * @param noteArray - All the possible notes.
     * @return the name of the note.
     */

    public String play(Note[] noteArray) {
        Arrays.sort(noteArray, Comparator.comparing(Note::getFrequency));
        int firstElement = 0;
        int lastElement = noteArray.length - 1;
        int midElement = (firstElement+ lastElement)/ 2;
        String teacherDesigion = teacher.isIt(noteArray[midElement]);
        while (!teacherDesigion.equals("exactly!")) {
            if (teacherDesigion.equals("higher")) {
                firstElement = midElement + 1;
            } else {
                lastElement = midElement - 1;
            }
            midElement = (firstElement + lastElement) / 2;

            teacherDesigion = teacher.isIt(noteArray[midElement]);
        }

        return noteArray[midElement].getName();
    }
}
