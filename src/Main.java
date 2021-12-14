import java.awt.*;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Random;
import java.util.RandomAccess;

/**
 * @author Ke
 */
public class Main {
    //大数组长度
    public static int bigSize = 2400;
    //小数组(页)长度
    public static int smallSize = 24;
    //页表大小
    public static int smallNum = 4;
    //页表
    public static HashMap<Integer,Integer> pageList = new HashMap<>(smallNum);

    public static void main(String[] args) {
        FIFO fifo =new FIFO();
        LRU lru = new LRU();
        OPT opt = new OPT();
        System.out.println("FIFO算法模拟：");
        fifo.show();
        System.out.println("LRU算法模拟：");
        lru.show();
        System.out.println("OPT算法模拟：");
        opt.show();
    }

}

