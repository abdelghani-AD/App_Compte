package CompteBanc;

import java.util.ArrayList;

import Exceptions.MontantNegatif;
import Exceptions.SoldeDimenuException;
import Exceptions.SoldeInssufisantEx;

public class CompteCourant extends CompteBancaire{
    private double decouvert;
    public CompteCourant(double decouvert){
        super();
        this.decouvert=decouvert;
    }

    public void retirer(double mt)throws Exception{
        if (mt>(getSolde()+this.decouvert))throw new SoldeInssufisantEx("Solde inssufisant ");
        if ((getSolde()+this.decouvert)<=0)throw new MontantNegatif("montant negatif");
        else {
            solde -= this.decouvert;
        }
    }

    public void UpdateSolde() {
        System.out.println("Solde :" +solde);
    }

    public String toString()
    {
        return (super.toString()+" le decouvret :"+this.decouvert);
    }
}
