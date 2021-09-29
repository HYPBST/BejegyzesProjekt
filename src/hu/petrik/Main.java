package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        Bejegyzes b1=new Bejegyzes("Schmidt Gergő","tartalom");
        Bejegyzes b2=new Bejegyzes("Schmidt András","tartalom2");
        List<Bejegyzes> bejegyzesek=new ArrayList<>();
        bejegyzesek.add(b1);
        bejegyzesek.add(b2);
        BufferedReader konzolOlvas= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Adja meg az új bejegyzések számát!");
        int mennyiseg=Integer.parseInt( konzolOlvas.readLine());
            while (mennyiseg<=0){
                System.out.println("Nem lehet nullát, vagy negatív számot beírni!, adj meg egy új számot!");
                mennyiseg=Integer.parseInt( konzolOlvas.readLine());
            }
        for (int i = 0; i < mennyiseg; i++) {
            System.out.println("Adja meg a szerzőt");
            String szerzo = konzolOlvas.readLine();
            System.out.println("Adja meg a tartalmat");
            String tartalom = konzolOlvas.readLine();
            Bejegyzes b = new Bejegyzes(szerzo, tartalom);
            bejegyzesek.add(b);
        }
        FileReader fr=new FileReader("bejegyzesek.txt");
        BufferedReader brFile=new BufferedReader(fr);
        String sor=brFile.readLine();
        while (sor!=null){
            String[] adatok= sor.strip().split(";");
            Bejegyzes b=new Bejegyzes(adatok[0],adatok[1]);
            bejegyzesek.add(b);
            sor=brFile.readLine();
        }
        brFile.close();
        fr.close();
        Random r=new Random();
        for (int i = 0; i < bejegyzesek.size()*20; i++) {
            bejegyzesek.get(r.nextInt(bejegyzesek.size())).like();
        }
        System.out.println("Módósítsa a második bejegyzés tartalmát!\nÍrja be az új tartalmat:");
        bejegyzesek.get(1).setTartalom(konzolOlvas.readLine());
        konzolOlvas.close();
        Bejegyzes legtobbLike=bejegyzesek.get(0);
        boolean harmincotFelett=false;
        for (Bejegyzes b:bejegyzesek
             ) {
            System.out.println(b);
            if (b.getLikeok()>legtobbLike.getLikeok()){
                legtobbLike=b;
            }
            if (b.getLikeok()>35){
                harmincotFelett=true;
            }
        }
        System.out.println("Legnépszerűbb bejegyzés likejainak száma: "+legtobbLike.getLikeok());
        if (harmincotFelett){
            System.out.println("Van olyan bejegyzés, amely 35 like nál többet kapott.");
        }else {
            System.out.println("Nincs olyan bejegyzés, amely 35 like nál többet kapott.");
        }

    }
}
