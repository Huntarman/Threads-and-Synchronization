package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Laborants extends MyThread{

    private Random rand = new Random();
    public int laborantId = 1;
    public int[] Laboratory;
    public int[] resourceOnTile;
    public ArrayList<Laborant> LaborantList = new ArrayList<>();
    public ArrayList<Laborant> RechargingLaborantList = new ArrayList<>();
    public Laborants(int numberOfLaborants,int numberOfOrganisms) {
        super(String.valueOf(numberOfLaborants));
        for (int i = 0; i<numberOfLaborants; i++){
            LaborantList.add(new Laborant((char) (laborantId + 64), i, laborantId)); laborantId++;
        }
        this.Laboratory = new int[numberOfOrganisms];this.resourceOnTile = new int[numberOfOrganisms];
        for (int i = 0; i<numberOfOrganisms; i++){
            this.Laboratory[i] = 0;
            this.resourceOnTile[i] = 0;
        }
        for (int i = 0; i<numberOfLaborants; i++){
            this.Laboratory[i] = 1+i;
            this.resourceOnTile[i] = 50;
        }
    }

    public void run(){
        stan.getStan();
        while(!end){
            try{
                sleep(600);
            }catch (InterruptedException e){
                System.err.println("Thread interrupted!");
            }
            System.out.println("[" + resourceOnTile[0] + "," + resourceOnTile[1] + "," + resourceOnTile[2] + "," + resourceOnTile[3] + "]");

            for(Laborant laborant: LaborantList){
                resourceOnTile[laborant.getPosition()] = 0;
                if(laborant.getDirection() == false){
                    if(laborant.getPosition()+1 == Laboratory.length){
                        laborant.setDirection(true);
                    }else {
                        if (Laboratory[laborant.getPosition() + 1] == 0) {
                            Laboratory[laborant.getPosition()] = 0;
                            Laboratory[laborant.getPosition() + 1] = laborant.getNumber();
                            laborant.setPosition(laborant.getPosition() + 1);
                        } else {
                            laborant.setDirection(true);
                        }
                    }
                }else{
                    if(laborant.getPosition() == 0){
                        laborant.setDirection(false);
                    }else {
                        if (Laboratory[laborant.getPosition() - 1] == 0) {
                            Laboratory[laborant.getPosition()] = 0;
                            Laboratory[laborant.getPosition() - 1] = laborant.getNumber();
                            laborant.setPosition(laborant.getPosition() - 1);
                        } else {
                            laborant.setDirection(false);
                        }
                    }
                }
                resourceOnTile[laborant.getPosition()] = laborant.getGoods();
            }
            //System.out.println("[" + Laboratory[0] + "," + Laboratory[1] + "," + Laboratory[2] + "," + Laboratory[3] + "]");
            if(RechargingLaborantList.size() == 0) {
                for (int i = LaborantList.size(); i > 0; i--) {
                    if (LaborantList.get(i - 1).getGoods() == 0) {
                        RechargingLaborantList.add(LaborantList.get(i - 1));
                        Laboratory[LaborantList.get(i - 1).getPosition()] = 0;
                        LaborantList.remove(i - 1);
                        break;
                    }
                }
            }
            for (int i = RechargingLaborantList.size(); i>0 ; i--) {
                RechargingLaborantList.get(i-1).setRechargeTime();
                if(RechargingLaborantList.get(i-1).getRechargeTime()>10){
                    RechargingLaborantList.get(i-1).rechargeGoods();
                    RechargingLaborantList.get(i-1).setPosition(0);
                    if (Laboratory[0] == 0){
                        LaborantList.add(new Laborant(RechargingLaborantList.get(i-1).getId(),0, RechargingLaborantList.get(i-1).getNumber()));
                        RechargingLaborantList.remove(RechargingLaborantList.get(i-1));
                    }
                }
            }
            stan.getStan();
        }
    }
    public String[] getLaborants(){
      String[] list = new String[Laboratory.length];
        Arrays.fill(list, "|____|");
        for(Laborant laborant: LaborantList){
            list[laborant.getPosition()] = laborant.getName();
        }
      return list;
    }

    public void setResourceOnTile (int position, int change){
        this.resourceOnTile[position] -= change;
        this.LaborantList.get(this.Laboratory[position] - 1).setGoods(change);
    }
    public int[] getResourceOnTile() {
        return resourceOnTile;
    }
    public void addLaborant(){
        int a = -1;
        for (int i = 0; i < Laboratory.length; i++) {
            if (Laboratory[i] == 0){
                a = i;
                break;
            }
        }
        if (LaborantList.size() != Laboratory.length) {
            LaborantList.add(new Laborant((char) (laborantId + 64), a, laborantId));
            this.laborantId++;
            this.Laboratory[a] = laborantId;
        }
        else{
            System.out.println("Number of assistants would exceed number of organisms");
        }
    }
}
