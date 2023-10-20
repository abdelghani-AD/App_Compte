package CompteBanc;

import Exceptions.MontantNegatif;
public interface iCompte{
    int getCode();
    double getSolde();
    StatutCompte getStatus();

    void verser(double mt) throws Exception;
    void versement(double mt, CompteBancaire c1, CompteBancaire c2,CompteBancaire c3)throws Exception;
    void updateSolde(double mt);
    double totalVersements();
    double totalRetraits();
    void Afficher();
}
