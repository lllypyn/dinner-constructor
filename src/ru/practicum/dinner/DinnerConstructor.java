package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    Random random = new Random();
    HashMap<String, ArrayList<String>> menu = new HashMap<>();

    // метод добавляет новое блюдо в меню по выбранному типу
    void addDish(String type, String dish) {
        if (menu.containsKey(type)) { // проверили наличие
            menu.get(type).add(dish);  // добавили
        } else { // если нет - создаем новый список и добавляем его в хэш таблицу
            ArrayList<String> newDish = new ArrayList<>();
            newDish.add(dish);
            menu.put(type, newDish);
        }
    }

    /*
     * Метод принимает комбинацию типов, выбранных пользователем (в виде списка), и их количество.
     * Создает и выводит заданное пользователем количество (amount) случайных комбинаций
     * из блюд по соответствующим типам (в виде списков) и выводит их на экран
     */
    void generationOfCombination(ArrayList<String> list, int amount) {
        String type;
        String item;
        int number;

        for (int i = 0; i < amount; i++) {
            ArrayList<String> listDish = new ArrayList<>(); // создали список
            for (String s : list) {
                type = s;
                number = random.nextInt(menu.get(type).size()); // назначаем случайное число
                item = menu.get(type).get(number); // назначили блюдо
                listDish.add(item); // передали в список
            }
            System.out.println("комбо № " + (i + 1));
            System.out.println(listDish);
            System.out.println();
        }
    }
}