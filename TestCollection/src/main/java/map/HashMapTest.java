package map;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jiangyi
 * @date 2022/10/11 21:00
 */
public class HashMapTest {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%s").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor
                (12, 24, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<>(6000),threadFactory,
                        new ThreadPoolExecutor.CallerRunsPolicy());
        HashMap<Integer, Integer> map = new HashMap<>(60000000, 1);
        AtomicInteger integer =new AtomicInteger(60000);
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 60000; i++) {
                    map.put(i, i);
                }
            }
        });

    }
}
