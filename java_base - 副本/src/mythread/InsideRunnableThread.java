package mythread;

public class InsideRunnableThread {

    public static void main(String[] args){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (;;){
                    System.out.println("Inside Runnable:" + 1);
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
        while(true){
            System.out.println("main:" + 0);
        }
    }
}
