package dk.dm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    static PrintWriter p;

    public static void main(String[] args) {
        try {
            p = new PrintWriter("test.csv");
            p.write("testing,3,sejt");
            p.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
