package com.alihan;


import java.util.Arrays;

public class player {

    private int id;
    private int endOfHand=111;
    private int point=0;
    int[] hand=new int[15];

    player(int id){

        Arrays.fill(hand, endOfHand);
        this.id=id;

    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void calculatePoint(int okey, int gosterge){
        Arrays.sort(hand);
        int i=0,y=0;
        int j=i+1;

        while(hand[i]!=endOfHand && i<hand.length-1){

            if(hand[i]%13==0){                                     //13 numaralı taşların ardışığı aynı renkli 1 numaralı taşlar için arrayi tarama
                while(hand[y]!=endOfHand && y<hand.length-1){
                    if(hand[i]-hand[y]==12){
                        point++;
                    System.out.println("oyuncu "+getId()+" icin 13-1 dizisi bulundu. +1 puan"+"("+hand[i]+" "+hand[y]+")");
                    }
                    y++;
                }
            }

            if(hand[i+1]-hand[i]==1) {                               //ardışık her 2 taş veya okey 1 puan
                point++;
                System.out.println("oyuncu "+getId()+" icin ardisik dizi bulundu. +1 puan"+"("+hand[i]+" "+hand[i+1]+")");
            }
            if(hand[i]==okey) {
                point++;
                System.out.println("oyuncu "+getId()+" icin okey bulundu. +1 puan"+"("+hand[i]+")");
            }
            while(hand[j]!=endOfHand && j<hand.length-1){         //farkı 13 olan her 2 taş renkten dolayı 1 puan
                if(hand[j]-hand[i]==13) {
                    point++;
                    System.out.println("oyuncu "+getId()+" icin renk dizisi bulundu. +1 puan"+"("+hand[j]+" "+hand[i]+")");
                }
                j++;
            }
            i++;
            j=i+1;
        }
    }

    public int getId() {
        return id;
    }
}
