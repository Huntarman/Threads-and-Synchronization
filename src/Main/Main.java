package Main;

import javax.swing.*;

public class Main {
    //
    //michal zajdel
    //java17 btw
    //cd lab05
    //compilation: javac -sourcepath src/ -d build/production/Lab05 src/Main/Main.java
    //running:java.exe -p "build/production/Lab05" -m Lab05/Main.Main
    //packing jar:jar cfv Lab05_pop.jar -C build/production/Lab05 .
    //runing jar;java -p Lab05_pop.jar -m Lab05/Main.Main
    public static void main(String[] args) {

        try {
            MyFrame frame = new MyFrame("App");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
