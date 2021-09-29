package hu.petrik;

import java.io.BufferedReader;
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
        for (int i = 0; i < mennyiseg; i++) {
            System.out.println("Adja meg a szerzőt");
            String szerzo = br.readLine();
            System.out.println("Adja meg a tartalmat");
            String tartalom = br.readLine();
            Bejegyzes b = new Bejegyzes(szerzo, tartalom);
            bejegyzesek.add(b);
        }
        br.close();
        for (Bejegyzes b:bejegyzesek
             ) {
            System.out.println(b);
        }
    }
}
