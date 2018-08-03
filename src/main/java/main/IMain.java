package main;

public interface IMain {
    int i = 1;
    default void printGo() {
        System.out.println("go" + i);
    }
    static void printHey() {
        System.out.println("hey" + i);
    }
}
