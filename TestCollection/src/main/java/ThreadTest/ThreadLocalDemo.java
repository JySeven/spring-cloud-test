package ThreadTest;

public class ThreadLocalDemo {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        ThreadA thread1 = new ThreadA();
        ThreadB thread2 = new ThreadB();
        new Thread(thread1).start();
//        thread2.run();
//        Thread.sleep(500);
//        thread1.threadLocalGet();
//        thread2.threadLocalGet();
        Thread.sleep(500);

        thread1.threadLocalGet();

//        thread2.threadLocalGet();

    }

    static class ThreadA implements Runnable {

        public void threadLocalGet() {
            System.out.println("gc 后threadLocal的值：" + threadLocal.get());
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            threadLocal.set("线程:" + name);
            System.out.println("threadLocal的值：" + threadLocal.get());
            System.out.println("开始GC");
            System.gc();
        }
    }

    static class ThreadB implements Runnable {

        public void threadLocalGet() {
            System.out.println(threadLocal.get());
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            threadLocal.set("线程:" + name);
            System.out.println(threadLocal.get());
        }
    }
}