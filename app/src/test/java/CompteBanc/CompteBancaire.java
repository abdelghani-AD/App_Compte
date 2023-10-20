package CompteBanc;
import java.util.ArrayList;

import Exceptions.MontantNegatif;
import Exceptions.SoldeDimenuException;
import Exceptions.SoldeInssufisantEx;

public class CompteBancaire {
//declaration des variables
    protected int code;
    protected double solde;
    protected StatutCompte status;
    public static int cmpt;
    ArrayList<Operation> ListOperations = new ArrayList<>();
//constructure par défaut
    public  CompteBancaire(){
        this.code = ++cmpt;
        this.solde = 100;
        this.status = StatutCompte.created;
    }

//constructure par argument
    public CompteBancaire(double solde , StatutCompte status){
        this.code = ++cmpt;
        this.solde = solde;
        this.status = status;
    }

//getters
    public int getCode(){return this.code;}
    public double getSolde(){return this.solde;}
    public StatutCompte getStatus(){return this.status;}

//setters
    public void setCode(int c){this.code = c;}
    public void setSolde(double s){this.solde = s;}
    public void setStatus(StatutCompte status){this.status = StatutCompte.created;}

//methode verser
    public void verser(double mt)throws   Exception{
        if(mt<=0)throw new MontantNegatif("Montant negatif");
        this.solde += mt;
        //liste operations
        ListOperations.add(new Versement(mt));
    }

//methode retirer
    public void retirer(double mt)throws Exception{
        if (this.solde <= mt)throw new SoldeInssufisantEx("Solde inssufisant");
        if (mt<=0)throw new MontantNegatif("Montant negatif");
        if(mt<100)throw new SoldeDimenuException("Impossible retrer cette montant ");
        this.solde -= mt;
        //liste operations
        ListOperations.add(new Retrait(mt));
    }
//methode versement
    public static void versement(double mt, CompteBancaire c1, CompteBancaire c2)throws Exception{
        c1.verser(mt);
        c2.retirer(mt);
    }
    public double consulterSolde(){
        return this.solde;
    }
    public void updateSolde(){}
    public double totalVersements() {
        double totalVersement = 0;
        for (Operation operation : ListOperations) {
            if (operation instanceof Versement) {
                totalVersement += operation.getMontant();
            }
        }
        return totalVersement;
    }
    public double totalRetraits() {
        double totalRetrait = 0;
        for (Operation opera : ListOperations) {
            if (opera instanceof Retrait) {
                totalRetrait += opera.getMontant();
            }
        }
        return totalRetrait;
    }

    public void Afficher(){
        System.out.println("le compte de code : " + " " +this.getCode()+" , le solde : " + " " + this.getSolde()+" "+" , le statut est : "+this.getStatus());
        }



//    public ArrayList<Operation> getListOperations(){
//        return ListOperations;
//    }
//    public void afficherHistory() throws IOException {
//        try {
//            FileWriter writer = new FileWriter("file.txt");
//            ArrayList<Operation> operations = getListOperations();
//            for(Operation operation : operations){
//                writer.write(operation.toString()+"\n");
//            }
//            writer.close();
//
//        }catch (IOException e){
//            System.out.println(e.getMessage());
//        }
//    }
}
