public class Test {

    public static void main(String[] args) {

        int[] arr = {1, 3, 7, 2, 4, 9, 10, 5, 6, 8};
        Test test = new Test();
        test.maopao(arr);
        //推导大O阶方法：
        //1、用常数1取代运行时间中的所有加法常数。
        //2、在修改后的运行次数函数中，只保留最高阶项。
        //3、如果最高阶项存在且不是1，则去除与这个项目相乘的常数。得到的结果就是大O阶。
    }

    // 冒泡
    // 1。循环两次 一次外循环 一次内循环 内循环每次循环次数减一
    // 时间复杂度F(N) = N*(N-1)*(N-2)*...*(1)
    // =N(N+1)/2
    // =N^2/2+N/2
    // 去最高项数 去掉其他项数 因为最高项数是2 所以可以去掉/2不影响的敞亮
    // =>O(n^2)
    public void maopao(int[] arr) {
        int temp;
        int i = arr.length - 1;
        while (i >= 0) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换 从小到大排序
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            i--;
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
    }


}
