import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StateMachine fsm = new StateMachine();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Автомат готовий. Введіть рядки (або 'exit' для виходу):");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) break;

            String result = fsm.process(input);
            System.out.println("Кінцевий стан: " + result);

            if (result.equals("F")) {
                System.out.println("" + "Слово TEST знайдено!");
            }
        }
    }
}
