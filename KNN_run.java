/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas;

import java.io.IOException;

/**
 *
 * @author yungg
 */
public class KNN_run 
{
    public static void main(String[] args) throws IOException
    {


        int nr = 8;
        int un = 10;

        KNN_algoritma deteksi = new KNN_algoritma();

        String hasil = null;

        hasil = deteksi.knn(nr, un);
    }
}
