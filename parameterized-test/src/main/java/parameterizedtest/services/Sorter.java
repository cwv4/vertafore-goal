package parameterizedtest.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {

    private List<String> stringList;

    public Sorter(List<String> input) {
        this.stringList = input;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void sortAscending() {
        Collections.sort(stringList);
    }

    public void sortDescending() {
        Collections.sort(stringList, Collections.reverseOrder());
    }

    public void sortRandom() {
        Collections.shuffle(stringList);
    }

    public void sortAlternating() {
        if (stringList.isEmpty()) {
            return;
        }

        if (stringList.size() == 1) {
            return;
        }

        if (stringList.size() == 2) {
            Collections.sort(stringList);
            return;
        }

        Collections.sort(stringList);
        List<String> firstHalf = stringList.subList(0, ((stringList.size() + 1) / 2));
        List<String> secondHalf = stringList.subList(((stringList.size() + 1) / 2), stringList.size());

        List<String> output = new ArrayList<>();

        for (int i = 0; i < firstHalf.size(); i++) {
            output.add(firstHalf.get(i));

            if (i <= secondHalf.size() - 1) {
                output.add(secondHalf.get(i));
            }
        }

        stringList = output;
    }
}
