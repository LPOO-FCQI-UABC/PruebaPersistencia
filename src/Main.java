import java.io.*;

public class Main {
    public static void main(String[] args) {


        BiotopoControl biotopoControl1 = new BiotopoControl("BiotopoControl 1");
        BiotopoControl biotopoControl2 = new BiotopoControl("BiotopoControl 2");
        BiotopoControl biotopoControl3 = new BiotopoControl("BiotopoControl 3");
        biotopoControl1.start();
        biotopoControl2.start();
        biotopoControl3.start();




    }
}