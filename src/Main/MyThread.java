package Main;

abstract public class MyThread extends Thread{
    static boolean end = false;
    static String number;
    protected Stan stan;
    public MyThread(String ID){
        end = false;
    }
    public void setStan(Stan state){
        this.stan = state;
    }
    public void End(){
        this.end = true;
    }
}
