package ru.practicum.dinner; //

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dinnerConstructor;
    static Scanner scanner;

    public static void main(String[] args) {
        dinnerConstructor = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command.trim()) {
                case "1" -> addNewDish();
                case "2" -> generateDishCombo();
                case "3" -> {
                    System.out.println("До скорых встреч!");
                    return;
                }
                default -> System.out.println("Такой команды нет, попробуйте снова.");
            }
        }
    }

    private static void printMenu() { // Выводим меню
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() { // обработка первой команды (подменю) - добавление блюд по видам
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dinnerConstructor.addDish(dishType.trim(), dishName.trim());
    }

    private static void generateDishCombo() {
        ArrayList<String> types = new ArrayList<>();

        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = Integer.parseInt(scanner.nextLine());
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). " + "Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine().trim();

        while (!nextItem.isEmpty()) {
            boolean chek = dinnerConstructor.menu.containsKey(nextItem);
            if (chek) {                     // пробовал заменить на witch (с булевой), но idea сообщает
                types.add(nextItem);        // что в 21 jdk это не работает (но спасибо за совет)
            } else {
                System.out.println("такого типа блюд нет, попробуйте ввести другое");
            }
            nextItem = scanner.nextLine().trim();
        }
        dinnerConstructor.generationOfCombination(types, numberOfCombos);
    }
}
