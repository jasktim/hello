package check;

import java.util.Scanner;

public class MainDemo3 {
    public static void main(String[] args) {
        IdNumberInputter inputter = new IdNumberInputter(new Scanner(System.in), new IdNumberValidator() {});
        inputter.start();
    }
}
