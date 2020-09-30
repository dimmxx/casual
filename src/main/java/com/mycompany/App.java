package com.mycompany;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {

        class Pair<T,U> {
            private final T key;
            private final U value;

            public Pair(T key, U value) {
                this.key = key;
                this.value = value;
            }

            public T getKey() {
                return this.key;
            }
            public U getValue() {
                return this.value;
            }

            @Override
            public String toString() {
                return "Pair{" +
                        "key=" + key +
                        ", value=" + value +
                        '}';
            }
        }

        List<Pair<LocalTime, LocalTime>> list = new ArrayList<>();
        Pair<LocalTime, LocalTime> pair1 = new Pair<>(LocalTime.of(9,0), LocalTime.of(10,30));
        Pair<LocalTime, LocalTime> pair2 = new Pair<>(LocalTime.of(7,0), LocalTime.of(8,30));

        list.add(pair1);
        list.add(pair2);

        System.out.println(list);


        list.sort((Comparator.comparing(Pair::getKey)));

        list.sort(new Comparator<Pair<LocalTime, LocalTime>>() {
            @Override
            public int compare(Pair<LocalTime, LocalTime> o1, Pair<LocalTime, LocalTime> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        System.out.println(list);







    }


}
