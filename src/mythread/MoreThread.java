package mythread;

public class MoreThread extends Thread{

    @Override
    public void run(){
        while (true){
            System.out.println("thread-run:1");
        }
    }
    public static void main(String[] args){
        MoreThread mt = new MoreThread();
        mt.start();

        for (;;){
            System.out.println("main:0");
        }
    }
}
