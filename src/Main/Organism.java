package Main;

import java.util.Random;

public class Organism extends MyThread{
    public int nourishment,stamina;
    public boolean isAlive;
    public Random rand = new Random();
    public Organism(String ID) {
        super(ID);
        this.nourishment = 10;
        this.stamina = 5;
        this.isAlive = true;
    }

    public void run(){
        stan.getStan();
        while(!end && isAlive){
            try{
                sleep(300);
            }catch (InterruptedException e){
                System.err.println("Thread interrupted!");
            }
            if(Math.random()*100 > 75) this.nourishment = Math.max(--this.nourishment, 0);
            if(this.nourishment < 5 && Math.random()*5 > this.nourishment) this.stamina = Math.max(--this.stamina,0);
            if(Math.random()*5 > 8 - this.nourishment)  this.stamina = Math.min(++this.stamina,5);
            if (this.stamina == 0 ) {
                this.isAlive = false;
                this.nourishment = 0;
                System.out.println("Organism died");
            }
            if (this.nourishment < 5) {
                try {
                    stan.setSomething();
                }catch (IndexOutOfBoundsException e){}
            }
            stan.getStan();
        }
    }
    public String getNourishmentString() {
        return  String.valueOf(this.nourishment);
    }

    public int getNourishment() {
        return this.nourishment;
    }

    public void setNourishment(int a){
        this.nourishment += a;
    }
    public int getStamina() {
        return stamina;
    }

}
