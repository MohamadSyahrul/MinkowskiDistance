/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author yungg
 */
public class KNN_algoritma 
{
    public static String ranking = "";
    public String knn(int nR, int uN) throws IOException{
       
        DataLatih latih = new DataLatih();
        
        int NR = nR;
        int UN = uN;
        
        double hasilED, hasilED_before;
        
        Map knn = new HashMap<>();
        System.out.println("DATA TESTING");
        System.out.println("NR  : " + NR);
        System.out.println("UN  : " + UN);
        System.out.println("");
        System.out.println("Hasil Jarak Euclidean");
        System.out.println("Nilai Rapot \t" + "Nilai UN \t" + "Kelas \t" + "\t ED");
 
        for(int a = 1; a<10; a++)
        {
            hasilED = jarakMinkowski(latih.NR[a],NR, latih.UN[a],UN,1.0/2);
            System.out.println(latih.NR[a] + "\t \t" + latih.UN[a] + "\t \t" + latih.kelas[a] + "\t \t" + hasilED);
            knn.put(hasilED, latih.kelas[a]);
        }
        
        System.out.println("Ranking Euclidean Distance");
        Map knn_hasil = new TreeMap(knn);
        printMap(knn_hasil);
        
        System.out.println("");
        System.out.println("Hasil Keputusan : " + knn_hasil.values().toArray()[0]);
        return (String) knn_hasil.values().toArray()[0];
    }

    public static void printMap(Map map) 
    {
        Set s = map.entrySet();
        Iterator it = s.iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Double key = (double) entry.getKey();
            String value = (String) entry.getValue();
            ranking = ranking + "\n " + "Apel: " + i + " nilai: " + key + " => " + value;
            System.out.println(key + " => " + value);
            i++;
        }
        System.out.println("================");
    }
    
    // Membuat rumus jarak Minkowski
    static double jarakMinkowski(int R1, int R2, int G1, int G2, double p)
    {
    double hasil = Math.sqrt(java.lang.Math.pow(R1 - R2, 1.0/p )
            + 
    java.lang.Math.pow(G1 - G2, 1.0/p ));
        return Math.pow(hasil, 1/p);
    }
}
