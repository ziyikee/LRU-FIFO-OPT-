import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class LRU {
    public int pageNum=0;
    public int page_index[] = new int[Main.smallNum];
    public int page_count[] = new int[Main.smallNum];


    public int getVal(int index) {
        index = index/Main.smallSize;
        if(Main.pageList.containsKey(index)){
            int page = Main.pageList.get(index);
            page_count[page] = 0;
            update(page);
            return 0;
        }else{
            if(pageNum<Main.smallNum){
               Main.pageList.put(index,pageNum);
               page_index[pageNum] = index;
               update(pageNum);
               page_count[pageNum] = 0;
               pageNum++;
            }else{
                int page = getMax();
                Main.pageList.remove(page_index[page]);
                Main.pageList.put(index,page);
                page_index[page] = index;
                update(page);
                page_count[page] = 0;
            }
            return 1;
        }

    }
    public int getMax(){
        int index = 0,max = -1;
        for(int i = 0;i<Main.smallNum;i++){
            if(max<page_count[i]){
                max = page_count[i];
                index = i;
            }
        }
        return index;
    }
    public void update(int page){
        for(int i =0;i<Main.smallNum;i++){
            if(i!=page){
                page_count[i]++;
            }
        }
    }

    public void show(){
        int err = 0;
        Random random = new Random();
        Main.pageList.clear();
        System.out.println("顺序访问：");
        int x= random.nextInt(2400);
        for(int i = 0;i<1000;i++){
            err += getVal((x+i)%2400);
        }
        System.out.println("缺页次数："+err+",缺页率："+(err*1.0)/10+"%");

        err = 0;
        Main.pageList.clear();
        System.out.println("跳转访问：");
        for(int i = 0;i<50;i++){
            x = random.nextInt(2400);
            for(int j = 0;j<20;j++) {
                err += getVal((x+i)%2400);
            }
        }
        System.out.println("缺页次数："+err+",缺页率："+(err*1.0)/10+"%");

        err = 0;
        Main.pageList.clear();
        System.out.println("循环访问：");
        x = random.nextInt(2400);
        for(int i = 0;i<10;i++){
            for(int j = 0;j<100;j++) {
                err += getVal((x+i)%2400);
            }
        }
        System.out.println("缺页次数："+err+",缺页率："+(err*1.0)/10+"%");

        err = 0;
        Main.pageList.clear();
        System.out.println("随机访问：");
        for(int i = 0;i<1000;i++){
            x = random.nextInt(2400);
            err += getVal((x)%2400);
        }
        System.out.println("缺页次数："+err+",缺页率："+(err*1.0)/10+"%");
    }
}
