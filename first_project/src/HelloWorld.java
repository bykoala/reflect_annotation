public class HelloWorld {
    public static void main(String[] args)
    {
        System.out.println("hello,world!");

    }

    public static double calc_operater(double numa,String operater_str,double numb){
        if (operater_str.equals("+")){
            return numa + numb;
        }
        if (operater_str.equals("-")){
            return numa - numb;
        }
        return 0;
    }
}
