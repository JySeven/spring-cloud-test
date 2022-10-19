package jy;

public class Test {

    public static void main(String[] args) {
        Object obj = new Object();
        synchronized (obj) {
            System.out.println(1111);
        }
    }
}
