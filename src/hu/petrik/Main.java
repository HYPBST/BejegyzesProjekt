package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Bejegyzes b1=new Bejegyzes("Schmidt Gergő","tartalom");
        Bejegyzes b2=new Bejegyzes("Schmidt András","tartalom2");
        List<Bejegyzes> bejegyzesek=new ArrayList<>();
        bejegyzesek.add(b1);
        bejegyzesek.add(b2);
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Adja meg az új bejegyzések számát!");
        int mennyiseg=Integer.parseInt( br.readLine());
            while (mennyiseg<=0){
                System.out.println("Nem lehet nullát, vagy negatív számot beírni!, adj meg egy új számot!");
                mennyiseg=Integer.parseInt( br.readLine());
            }
        for (int i = 0; i < mennyiseg; i++) {
            System.out.println("Adja meg a szerzőt");
            String szerzo = br.readLine();
            System.out.println("Adja meg a tartalmat");
            String tartalom = br.readLine();
            Bejegyzes b = new Bejegyzes(szerzo, tartalom);
            bejegyzesek.add(b);
        }
        br.close();
        FileReader fr=new FileReader("bejegyzesek.txt");
        BufferedReader brFile=new BufferedReader(fr);
        String sor=brFile.readLine();
        while (sor!=null){
            String[] adatok= sor.strip().split(";");
            Bejegyzes b=new Bejegyzes(adatok[0],adatok[1]);
            bejegyzesek.add(b);
            sor=br.readLine();
        }
        brFile.close();
        fr.close();
        for (Bejegyzes b:bejegyzesek
             ) {
            System.out.println(b);
        }
    }
}
