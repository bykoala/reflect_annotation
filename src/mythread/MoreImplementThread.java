package mythread;

public class MoreImplementThread implements Runnable{

    @Override
    public void run(){
        while(true){
            System.out.println("implements:" + 1);
        }

    }

    public static void main(String[] args){
        MoreImplementThread mit = new MoreImplementThread();
        Thread t = new Thread(mit);
        t.start();
        for (;;){
            System.out.println("main:" + 0);
        }
    }
}
