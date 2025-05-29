package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    Random random = new Random();
    HashMap<String, ArrayList<String>> menu = new HashMap<>();

    void addDish(String type, String dish) { // добавляем новое блюдо в меню
        if (menu.containsKey(type)){
            menu.get(type).add(dish);
        }else {
            ArrayList<String> newDish = new ArrayList<>();
            newDish.add(dish);
            menu.put(type, newDish);
        }
    }

    void generationOfCombination(ArrayList<String> list, int amount){

        String type;
        String item;

        for (int i = 0; i < amount; i++) {
            ArrayList<String> listDish = new ArrayList<>();

            for (String s : list) {
                type = s;
                boolean avail = menu.containsKey(type);
                if (avail) {
                    int number = random.nextInt(menu.get(type).size());
                    item = menu.get(type).get(number);
                    listDish.add(item);
                } else {
                    System.out.println("К сожалению категории " + type + " в нашем меню нет");
                }
            }
            System.out.println("комбо № " + (i+1));
            System.out.println(listDish);
            /*for (PositionOfCombo positionOfCombo : listDish) {
                System.out.print(positionOfCombo.type + " : " + positionOfCombo.item + " ");
            }*/

            System.out.println();


        }


    }


}