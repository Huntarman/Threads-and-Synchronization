package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame {
    private JLabel DistributorLabel,AssistantLabel,NourishmentLabel, Staminalabel;
    private JLabel DistributorLabel1_1,AssistantLabel2_1,NourishmentLabel3_1, Staminalabel4_1;
    private JLabel DistributorLabel1_2,AssistantLabel2_2,NourishmentLabel3_2, Staminalabel4_2;
    private JLabel DistributorLabel1_3,AssistantLabel2_3,NourishmentLabel3_3, Staminalabel4_3;
    private JLabel DistributorLabel1_4,AssistantLabel2_4,NourishmentLabel3_4, Staminalabel4_4;

    private Organism organism_1 ,organism_2 ,organism_3 ,organism_4 ;
    private Laborants laborants;
    public void Design() {
        JButton buttonT = new JButton("Start");
        buttonT.setMnemonic(KeyEvent.VK_T);
        JButton buttonL = new JButton("Stop");
        buttonL.setMnemonic(KeyEvent.VK_L);
        JButton buttonA = new JButton("Add assistant");
        buttonA.setMnemonic(KeyEvent.VK_A);

           DistributorLabel = new JLabel("Distributor");AssistantLabel   = new JLabel(" Assistant ");
           NourishmentLabel = new JLabel("Nourishment");Staminalabel     = new JLabel("  Stamina  ");

        DistributorLabel1_1 = new JLabel("           ");AssistantLabel2_1= new JLabel("           ");
        NourishmentLabel3_1 = new JLabel("           ");Staminalabel4_1  = new JLabel("           ");

        DistributorLabel1_2 = new JLabel("        |D|");AssistantLabel2_2= new JLabel("           ");
        NourishmentLabel3_2 = new JLabel("           ");Staminalabel4_2  = new JLabel("           ");

        DistributorLabel1_3 = new JLabel("           ");AssistantLabel2_3= new JLabel("           ");
        NourishmentLabel3_3 = new JLabel("           ");Staminalabel4_3  = new JLabel("           ");

        DistributorLabel1_4 = new JLabel("           ");AssistantLabel2_4= new JLabel("           ");
        NourishmentLabel3_4 = new JLabel("           ");Staminalabel4_4  = new JLabel("           ");

        JPanel Labels = new JPanel();
        Labels.setBackground(new Color(255,255,255));
        Labels.setLayout(new GridLayout(5,4,10,10));

        Labels.add(DistributorLabel);    Labels.add(AssistantLabel);    Labels.add(NourishmentLabel);    Labels.add(Staminalabel);
        Labels.add(DistributorLabel1_1); Labels.add(AssistantLabel2_1); Labels.add(NourishmentLabel3_1); Labels.add(Staminalabel4_1);
        Labels.add(DistributorLabel1_2); Labels.add(AssistantLabel2_2); Labels.add(NourishmentLabel3_2); Labels.add(Staminalabel4_2);
        Labels.add(DistributorLabel1_3); Labels.add(AssistantLabel2_3); Labels.add(NourishmentLabel3_3); Labels.add(Staminalabel4_3);
        Labels.add(DistributorLabel1_4); Labels.add(AssistantLabel2_4); Labels.add(NourishmentLabel3_4); Labels.add(Staminalabel4_4);

        ActionListener a = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(	((JButton)e.getSource()).getText().compareTo("Start")==0){
                    createThreads();
                    uruchomWatki();
                }

                if(	((JButton)e.getSource()).getText().compareTo("Stop")==0) {
                    zatrzymajWatki();
                }

                if(	((JButton)e.getSource()).getText().compareTo("Add assistant")==0) {
                    laborants.addLaborant();
                }

            }
        };
        buttonT.addActionListener(a);
        buttonL.addActionListener(a);
        buttonA.addActionListener(a);
        JPanel buttons = new JPanel();
        buttons.add(buttonT);
        buttons.add(buttonL);
        buttons.add(buttonA);
        this.getContentPane().setLayout(new GridLayout(2,1));
        this.getContentPane().add(Labels);
        this.getContentPane().add(buttons);

    }

    private void zatrzymajWatki() {
        organism_1.End();
        organism_2.End();
        organism_3.End();
        organism_4.End();
        laborants.End();
    }

    private void uruchomWatki() {
        organism_1.start();
        organism_2.start();
        organism_3.start();
        organism_4.start();
        laborants.start();
    }

    private void createThreads() {
        organism_1 = new Organism("1");
        organism_1.setStan(
                new Stan(){
                    public void getStan(){
                        String s1 = "| " + organism_1.getNourishmentString() + " |" ;
                        String s2 = "| " + organism_1.getStamina() + " |" ;
                        NourishmentLabel3_1.setText(s1);
                        Staminalabel4_1.setText(s2);
                    }
                    public void setSomething() {
                        int resourceFor1 = laborants.resourceOnTile[0];
                        if(resourceFor1!=0) {
                            int a = Math.min(10 - organism_1.getNourishment(), resourceFor1);
                            organism_1.setNourishment(a);
                            laborants.setResourceOnTile(0, a);
                        }
                    }
                }
        );

        organism_2 = new Organism("2");
        organism_2.setStan(
                new Stan(){
                    public void getStan(){
                        String s1 = "| " + organism_2.getNourishmentString() + " |" ;
                        String s2 = "| " + organism_2.getStamina() + " |" ;
                        NourishmentLabel3_2.setText(s1);
                        Staminalabel4_2.setText(s2);
                    }
                    public void setSomething() {
                        int resourceFor2 = laborants.resourceOnTile[1];
                        if(resourceFor2!=0) {
                            int a = Math.min(10 - organism_2.getNourishment(), resourceFor2);
                            organism_2.setNourishment(a);
                            laborants.setResourceOnTile(1, a);
                        }
                    }
                }
        );

        organism_3 = new Organism("3");
        organism_3.setStan(
                new Stan(){
                    public void getStan(){
                        String s1 = "| " + organism_3.getNourishmentString() + " |" ;
                        String s2 = "| " + organism_3.getStamina() + " |" ;
                        NourishmentLabel3_3.setText(s1);
                        Staminalabel4_3.setText(s2);
                    }
                    public void setSomething() {
                        int resourceFor3 = laborants.resourceOnTile[2];
                        if(resourceFor3!=0) {
                            int a = Math.min(10 - organism_3.getNourishment(), resourceFor3);
                            organism_3.setNourishment(a);
                            laborants.setResourceOnTile(2, a);
                        }
                    }
                }
        );

        organism_4 = new Organism("4");
        organism_4.setStan(
                new Stan(){
                    public void getStan(){
                        String s1 = "| " + organism_4.getNourishmentString() + " |" ;
                        String s2 = "| " + organism_4.getStamina() + " |" ;
                        NourishmentLabel3_4.setText(s1);
                        Staminalabel4_4.setText(s2);
                    }
                    public void setSomething() {
                        int resourceFor4 = laborants.resourceOnTile[3];
                        if(resourceFor4!=0) {
                            int a = Math.min(10 - organism_4.getNourishment(), resourceFor4);
                            organism_4.setNourishment(a);
                            laborants.setResourceOnTile(3, a);
                        }
                    }
                }
        );

        laborants = new Laborants(1,4);
        laborants.setStan(
                new Stan(){
                    public void getStan() {
                        String[] list = laborants.getLaborants();
                        AssistantLabel2_1.setText(list[0]);
                        AssistantLabel2_2.setText(list[1]);
                        AssistantLabel2_3.setText(list[2]);
                        AssistantLabel2_4.setText(list[3]);
                    }
                    public void setSomething() {};
                }
        );
    }

    public MyFrame(String arg){
        super(arg);
        Design();
        pack();
    }
}