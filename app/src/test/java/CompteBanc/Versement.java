package CompteBanc;

public class Versement extends Operation{
    public Versement(double montant){
        super(montant);
    }
    public String verser(){
        return ("Numero d'operation :"+getNum()+" , "+"Le montant verser :"+montant+" DH "+" , "+"Date d'operation"+date);
    }
}
