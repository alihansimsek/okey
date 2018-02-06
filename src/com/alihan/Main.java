package com.alihan;

public class Main {

    public static void main(String[] args) {

        int[] masa=new int[106];
        player[] players=new player[4];
        int gosterge,okey,winnerPoint;


        for(int i=0; i<players.length; i++)
            players[i] = new player(i);



        for(int i=0;i<53;i++){
            masa[i]=i;
            masa[masa.length-i-1]=i;
        }

        gosterge=gostergeSec();
        okey=okeySec(gosterge);
        shuffle(masa);
        deal(players,masa);


        for(int i=0;i<players.length;i++)
            players[i].calculatePoint(okey,gosterge);

        endGame(players);


    }

    private static void endGame(player[] p) {
        player winner=null;
        int maxPoint=0;

        for(int i=0;i<p.length;i++){
            if(p[i].getPoint()>=maxPoint){
                maxPoint=p[i].getPoint();
                winner=p[i];
            }
        }

        System.out.println("Oyuncu "+winner.getId()+", "+maxPoint+" puan ile oyunu kazandı.");
    }


    private static void deal(player[] players,int[] masa) {
        int PLAYER_HAND_LENGTH=players[0].hand.length; //15

        for(int i=0;i<players.length;i++){
            System.arraycopy(masa, 0+(i*(PLAYER_HAND_LENGTH-1)), players[i].hand, 0, PLAYER_HAND_LENGTH-1); //copies parts of the array into players' hands
            if(i==players.length-1)
                players[i].hand[PLAYER_HAND_LENGTH-1]=masa[(i*PLAYER_HAND_LENGTH-1)+1];
        }
    }


    private static int okeySec(int g){
        int ok=g+1;
        if(g%13==12)
            ok=g-12;
        return ok;

    }
    private static int gostergeSec(){
        int gos=(int)(Math.random()*106);
        if (gos==52)
            return gostergeSec();
        return gos;
    }

    private static void shuffle(int[] m){
        int index;
        int temp;
        for(int i=0;i<m.length;i++){
            index=(int)(Math.random()*m.length);
            temp=m[i];
            m[i]=m[index];
            m[index]=temp;
        }

    }
}
