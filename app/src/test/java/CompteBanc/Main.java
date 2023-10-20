package CompteBanc;

import android.graphics.Path;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<CompteBancaire> comptes = new ArrayList<>();
        CompteCourant c1 = new CompteCourant(100);
        CompteEpargne c2 = new CompteEpargne(400);
        CompteCourant c3 = new CompteCourant(500);
        c1.verser(600);
        c1.retirer(200);
        c1.updateSolde();

        c2.verser(300);
        c2.retirer(250);
        c2.calculInterets();
        c2.updateSolde();

        c3.verser(1000);
        c3.retirer(450);
        c3.updateSolde();

        CompteCourant courant1 = new CompteCourant(200);
        c1.verser(700);
        c1.retirer(400);
        c2.verser(1000);
        c2.retirer(1100);
        c3.verser(500);
        c3.retirer(400);
        courant1.setSolde(1000);
        comptes.add(c1);
        comptes.add(c2);
        comptes.add(c3);
        CompteBancaire.versement(300,c1,c2);

//Affichage dans un liste
        for (int i=0;i<comptes.size();i++){
            System.out.println("les donner de compte");
            for (Operation e:comptes.get(i).ListOperations){
                if (e instanceof Retrait){
                    System.out.println(e.retirer());
                }
                else {
                    System.out.println(e.verser());
                }
            }
            System.out.println("Totale de versement : " + comptes.get(i).totalVersements() + " DH ");
            System.out.println("Totale de Retairait: " + comptes.get(i).totalRetraits() + " DH  ");
            System.out.println();
        }
//Affichage dans un fichier
        PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\abdo\\AndroidStudioProjects\\Compte_Bancaire\\app\\src\\test\\java\\CompteBanc\\file"));
        for (int i = 0; i < comptes.size(); i++) {
            out.println("Information de votre Compte :");
            for (Operation e : comptes.get(i).ListOperations) {
                if (e instanceof Retrait) {

                    out.println(e.retirer());
                } else {
                    out.println(e.verser());
                }
            }
            out.println("Total de versement :" + comptes.get(i).totalVersements() + " DH ");
            out.println("Total de Retairait :" +comptes.get(i).totalRetraits() + " DH  ");
            out.println();
        }
        out.close();
    }





//        ArrayList<CompteBancaire> comptes = new ArrayList<>();
//        CompteBancaire c1 = new CompteBancaire(1,2000,StatutCompte.created);
//        CompteBancaire c2 = new CompteBancaire(2,400,StatutCompte.suspunded);
//        CompteBancaire c3 = new CompteBancaire(3,600,StatutCompte.created);
//        CompteCourant courant = new CompteCourant();
//        try {
//            c1.verser(200);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//       try{
//           c1.retirer(1000);
//       }catch (Exception e){
//           System.out.println(e.getMessage());
//       }
//        try {
//            c2.verser(600);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        try{
//            c2.retirer(500);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        try {
//            c3.verser(1000);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        try{
//            c3.retirer(900);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        courant.setSolde(1000);
//        comptes.add(c1);
//        comptes.add(c2);
//        comptes.add(c3);
//        CompteBancaire compte = new CompteBancaire();
//        try {
//            compte.versement(300,c1,c2,c3);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println("Compte 1 :");
//        c1.Afficher();
//        System.out.println("totale versement est : "+c1.totalVersements()+" "+"Dh");
//        System.out.println("totale retrait est : "+c1.totalRetraits()+" "+"Dh");
//        System.out.println("Compte 2 :");
//        c2.Afficher();
//        System.out.println("totale versement est : "+c2.totalVersements()+" "+"Dh");
//        System.out.println("totale retrait est : "+c2.totalRetraits()+" "+"Dh");
//        System.out.println("Compte 3 :");
//        c3.Afficher();
//        System.out.println("totale versement est : "+c3.totalVersements()+" "+"Dh");
//        System.out.println("totale retrait est : "+c3.totalRetraits()+" "+"Dh");
//
//


//Compte Courant
//        System.out.println("======================= Compte Courant ============================");
//        CompteBancaire c = new CompteCourant(1,10000,StatutCompte.created,400);
//        try{
//            c.retirer(6000);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        try {
//            c.verser(500);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        c.Afficher();
//        System.out.println(c.totalVersements());
//        System.out.println(c.totalRetraits());

        //Compte Epagne
//        System.out.println("======================= Compte Epargne ===============================");
//        CompteEpargne e = new CompteEpargne();
//        e.setCode(2);
//        e.setSolde(800);
//        e.setStatus(StatutCompte.created);
//        e.setTaus(10);
//        try{
//            e.retirer(0);
//        }catch (Exception a){
//            System.out.println(a.getMessage());
//        }
//        System.out.println(e.totalVersements());
//         System.out.println(e.totalRetraits());
//        e.Afficher();
}


