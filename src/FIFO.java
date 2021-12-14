import java.util.Random;

public class FIFO {
    public int lastKey = 0;
    public int nextPage = 0;
    public int[] page_index = new int[Main.smallNum];

    public int getVal(int index){
        index = index/Main.smallSize;
        if(Main.pageList.containsKey(index)){
            return 0;
        }else{
             if(Main.pageList.size()<Main.smallNum){
                 Main.pageList.put(index,nextPage);
                 page_index[nextPage] = index;
                 nextPage = (nextPage+1)%Main.smallNum;
                 return 1;
             }else{

                 Main.pageList.remove(page_index[nextPage]);
                 Main.pageList.put(index,nextPage);
                 page_index[nextPage] = index;
                 nextPage = (nextPage+1)%Main.smallNum;
                 return 1;
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
