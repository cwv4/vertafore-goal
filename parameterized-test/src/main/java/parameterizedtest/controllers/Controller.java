package parameterizedtest.controllers;

import parameterizedtest.services.Sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private Controller() {
    }

    public static void querySort() {
        Scanner scanner = new Scanner(System.in);

        String sortingOption = scanner.nextLine();
        ArrayList<String> input = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));

        List<String> output = Controller.delegateSort(sortingOption, input);

        System.out.println(output);
    }

    public static List<String> delegateSort(String sortingOption, List<String> input) {
        Sorter sorter = new Sorter(input);

        switch (sortingOption.toLowerCase()) {
            case "ascending":
                sorter.sortAscending();
                break;
            case "descending":
                sorter.sortDescending();
                break;
            case "random":
                sorter.sortRandom();
                break;
            case "alternating":
                sorter.sortAlternating();
                break;
            default:
                sorter.sortAscending();
        }

        return sorter.getStringList();
    }
}
