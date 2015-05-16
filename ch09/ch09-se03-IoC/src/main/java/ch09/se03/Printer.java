package ch09.se03;

public class Printer implements Output {
    private String[] printData = new String[MAX_CACHE_LINE];

    // 用以记录当前需要打印的作业数
    private int dataNum = 0;

    @Override
    public void getData(String msg) {
        if(dataNum >= MAX_CACHE_LINE) {
            System.out.println("输出队列已满，添加失败！");
        } else {
            // 将打印数据添加到队列里，并将作业数加１
            printData[dataNum++] = msg;
        }
    }

    @Override
    public void out() {
        // 只要有作业，继续打印
        while(dataNum > 0) {
            // 打印位于列首的任务
            System.out.println("打印机打印：" + printData[0]);
            // 删除已完成的任务，并将作业数减1
            System.arraycopy(printData, 1, printData, 0, --dataNum);
        }
    }

}
