package CompteBanc;

import android.provider.ContactsContract;

public class Retrait extends Operation{
    public Retrait(double montant){
        super(montant);
    }
    public String retirer(){
        return ("Numero d'operation :"+getNum()+" , le montant retirer : "+montant +" DH"+" , date d'operation :"+date);
    }

}