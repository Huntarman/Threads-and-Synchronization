package Main;

public class Laborant {
    private String name;
    private int goods,number;
    private char id;
    private int rechargeTime = 0;
    private int position;
    private boolean MovingUp = true; //true - laborant will go up || false - he will go down
    public Laborant(char Id, int position, int number){
        this.goods = 50;
        this.id = Id;
        this.name = "|" + this.id + "_" + this.goods + "|";
        this.position = position;
        this.number = number;
    }

    public void setGoods(int goods_used){
        this.goods = Math.max(this.goods - goods_used,0);
        this.name = "|" + (this.id) + "_" + this.goods + "|";
    }
    public void rechargeGoods(){
        this.goods = 50;
        this.name = "|" + (this.id) + "_" + this.goods + "|";
    }

    public char getId() {
        return id;
    }

    public void setPosition(int newPosition){
        this.position = newPosition;
    }
    public void setDirection(boolean a){this.MovingUp = a;}
    public String getName(){
        return this.name;
    }

    public int getGoods(){
        return this.goods;
    }

    public int getPosition() {
        return this.position;
    }
    public void setRechargeTime(){
        this.rechargeTime++;
    }

    public int getRechargeTime() {
        return rechargeTime;
    }

    public boolean getDirection() {
        return this.MovingUp;
    }

    public int getNumber() {
        return number;
    }
}
