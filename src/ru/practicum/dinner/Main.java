package ru.practicum.dinner; //

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        /* System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addDish(dishType, dishName);*/
        String vid = ("Vasya");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 20; j++) {

                if (i == 0){
                    vid = ("напиток");
                }else if (i == 1){
                    vid = ("супы");
                }else if (i == 2){
                    vid = ("гарнир");
                }else if (i == 3){
                    vid = ("горячее");
                }else if (i == 4) {
                    vid = ("салат");
                }else if (i == 5){
                    vid = ("десерт");
                }else if (i == 6) {
                    vid = ("выпечка");
                }

                String bludo = ("блюдо " + j);
                dc.addDish(vid, bludo);
            }
        }

        // добавьте новое блюдо

    }

    private static void generateDishCombo() {
        ArrayList<String> types = new ArrayList<>();
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");

        int numberOfCombos = Integer.parseInt(scanner.nextLine());
  /*      int numberOfCombos = scanner.nextInt();
        scanner.nextLine();*/

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            types.add(nextItem);
            nextItem = scanner.nextLine();

        }
        dc.generationOfCombination(types,numberOfCombos);

        // сгенерируйте комбинации блюд и выведите на экран

    }
}
