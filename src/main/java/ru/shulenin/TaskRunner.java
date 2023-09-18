package ru.shulenin;

import ru.shulenin.container.Container;

public class TaskRunner {
    static public void run() {
        Container<String> container1 = new Container<>();

        container1.pushFront("Hello");
        container1.pushBack("World");

        System.out.println(container1.toString());

        Container<String> container2 = new Container<>();

        container2.insert("My", 0);
        container2.insert("Container", 1);

        for (String str : container2) {
            System.out.print(str);
        }

        System.out.println();

        for (int i = 0; i < 2; ++i) {
            System.out.print(container2.at(i));
        }
    }
}
