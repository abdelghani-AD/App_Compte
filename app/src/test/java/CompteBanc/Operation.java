package CompteBanc;
import java.util.Date;

public class Operation {
    private int num;
    protected Date date;
    protected double montant;
    public static int cmp;

    public Operation(double m){
        this.num=++cmp;
        this.date = new Date();
        this.montant =m;
    }
    // Getters and setters for numero, date, montant
    public int getNum(){return  this.num;}
    public double getMontant() {
        return montant;
    }
    public String retirer(){return null;}
    public String verser(){return null;}
}
