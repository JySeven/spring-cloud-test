public class Test {
    public static void main(String[] args) {
//        WeakReference<String> weakReference= new WeakReference<String>(new String("11"));
//        System.out.println(weakReference.get());
//        System.gc();
//        System.out.println("GC完成");
//        System.out.println(weakReference.get());
        System.loadLibrary("synchronizer");
        

    }
    static class A{
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
