/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balkezes_okj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Soma
 */
public class Balkezes_OKJ {

    /**
     * @param args the command line arguments
     */
    static ArrayList<BalkezesAdatok> BalList=new ArrayList();
    public static void main(String[] args) 
    {
        System.out.println("\n-------------------------\n");
        Feladat2Beolvasas();
        System.out.println("\n-------------------------\n");
        Feladat3BeolvasottAdatokSzama();
        System.out.println("\n-------------------------\n");
        Feladat4MagassagCmben();
        System.out.println("\n-------------------------\n");
        Feladat5Bekeres();
    }

    private static void Feladat2Beolvasas()
    {
        System.out.println("2.Feladat:Beolvasás");
        try
        {
            System.setProperty("fajl.Encoding", "UTF8");
            FileReader fajl=new FileReader("balkezesek.txt");
            int db=0;
            try (BufferedReader br= new BufferedReader(fajl))
            {
                int i=0;
                String sor=null;
                while((sor = br.readLine())!=null)
                {
                    String[] dbok=sor.split(";");
                    String Nev=dbok[0];
                    String Elso=dbok[1];
                    String Utolso=dbok[2];
                    int SulyFont=Integer.parseInt(dbok[3]);
                    int MagassagInch=Integer.parseInt(dbok[4]);
                     BalkezesAdatok Ba=new BalkezesAdatok(Nev, Elso, Utolso, SulyFont, MagassagInch);
                     BalList.add(Ba);
                     db++;
                }
             } 
            if(db>0)
            {
                System.out.println("\tSikeres beolvasás");
            }
        }        
        catch (IOException e) 
        {
            System.out.println("Hiba"+e);
        }
    }

    private static void Feladat3BeolvasottAdatokSzama() 
    {
        System.out.println("3.Feladat: Beolvasott adatok száma");
        System.out.println("\t "+ BalList.size()+" db adat volt beolvasva");
    }

    private static void Feladat4MagassagCmben() 
    {
        System.out.println("4.Feladat: 1999 októberében kezdő játékosok magassága cm-ben");
        double MagassagCm=0;
        for (int i = 0; i < BalList.size(); i++) 
        {
          if(BalList.get(i).Utolso.contains("1999-10-"))
          {
              MagassagCm=BalList.get(i).MagassagInch*2.54;
              System.out.println(" "+BalList.get(i).Nev+" : "+MagassagCm+" cm");  
          }  
                 
        }
    }

    private static void Feladat5Bekeres()
    {
        System.out.println("5.Feladat:Bekeres");
        Scanner be=new Scanner(System.in);
        System.out.print("Kérem adjon meg egy évet 1990 és 1999 között: ");
        String EvBe=be.next();
        int Ev=Integer.parseInt(EvBe);
        if(1990<=Ev && Ev<=1999)
        {
            System.out.println("\n-------------------------\n");
            System.out.println("6.Feladat az dott évben induló játékosok átlag súlya");
            double Osszeg=0;
            double Atlag=0;
            int db=0;
            for (int i = 0; i < BalList.size(); i++)
            {
              if(BalList.get(i).Elso.contains(EvBe))
              {
                  db++;
                  Osszeg+=BalList.get(i).SulyFont;
                  Atlag=Osszeg/db;
              }                
            }
            System.out.println("Az adott évben : "+ EvBe+ " az átlag súly: "+Atlag);
        }
        else
        {
            System.out.println("Hibás adat");
        }
    
    }
    
}
