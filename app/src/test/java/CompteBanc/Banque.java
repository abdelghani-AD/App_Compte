package CompteBanc;

import java.util.ArrayList;
import java.util.List;

public class Banque {
    private List<CompteBancaire> listComptes;
    public Banque(){
        listComptes = new ArrayList<>();
    }
    public int indiceCompte(int code){
        for (int i=0 ;i<listComptes.size();i++){
            if (listComptes.get(i).getCode()==code){
                return i;
            }
        }
        return -1;
    }
    public void ajouter(CompteBancaire c){
        if (indiceCompte(c.getCode()) != -1) {
            try {
                throw new Exception("Le compte appartient déjà à la banque.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        listComptes.add(c);
    }
    public boolean supprimer(int code){
        for (int i=0;i<listComptes.size();i++){
            if (listComptes.get(i).getCode()==code){
                listComptes.remove(code);
                return true;
            }
        }
        return false;
    }
    public boolean supprimer(CompteBancaire c){
       if (listComptes == c){
           listComptes.remove(c);
           return true;
       }
       else return false;
    }
    public int nbrCompte(){
        int compte =0;
        for (CompteBancaire e:listComptes){
            if( e instanceof CompteCourant){
                ++compte;
            }
        }
        return compte;
    }

}
