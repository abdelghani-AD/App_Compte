package CompteBanc;

import java.util.ArrayList;

import Exceptions.SoldeSuperieur;

public class CompteEpargne extends CompteBancaire{
    private double taux;
    public CompteEpargne(double taux){
        super();
        this.taux = taux;
    }
    public void calculInterets() {
        solde=solde*(1+this.taux/100);
    }
    public void UpdateSolde() {
        System.out.println("Solde :" +solde);
    }
    public String toString(){

        return (super.toString());
    }
}
