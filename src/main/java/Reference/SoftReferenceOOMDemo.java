package Reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferenceOOMDemo {
    static class OOM {
        //4b*1024 * 100 => 400kb
        private int[] oom = new int[1024 * 100];
    }

    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<OOM> queue = new ReferenceQueue<>();
        List<SoftReference<OOM>> memory = new ArrayList<>();
        int i = 1000;
        while (i > 0) {
            memory.add(new SoftReference<>(new OOM(), queue));
            i--;
            Reference<? extends OOM> reference= queue.poll();
            if(null != reference){
                System.out.println(reference.get());
            }
            Thread.sleep(10);
        }

    }
}

