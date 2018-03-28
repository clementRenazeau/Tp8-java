package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Exercice 02 - Map
 * @param <T>
 */
public class Lambda_02_Test{

    // tag::PersonToAccountMapper[]
    interface Mapper <T>{
        T map(Person p);
    }
    // end::PersonToAccountMapper[]

    // tag::map[]
    @SuppressWarnings("unchecked")
	private <T> List<T> map(List<Person> personList, Mapper mapper) {
        //implémenter la méthode pour transformer une liste de personnes en liste de comptes
    	List<T> listAccount = new ArrayList<>();
    	for(Person pers : personList){
    		listAccount.add((T) mapper.map(pers));
    	}
        return listAccount;
    }
    // end::map[]


    // tag::test_map_person_to_account[]
    @Test
    public <T> void test_map_person_to_account() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        //transformer la liste de personnes en liste de comptes
        //tous les objets comptes ont un solde à 100 par défaut
        List<T> result = map(personList, p -> {
        	Account a = new Account();
        	a.setOwner(p);
        	a.setBalance(100);
        	return a;
        });

        assert result.size() == personList.size();
        for (T account : result) {
            assert ((Account) account).getBalance().equals(100);
            assert ((Account) account).getOwner() != null;
        }
    }
    // end::test_map_person_to_account[]

    // tag::test_map_person_to_firstname[]
    
    @Test
    public <T> void test_map_person_to_firstname() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        //transformer la liste de personnes en liste de prénoms
        List<T> result = map(personList, p -> p.getFirstname());

        assert result.size() == personList.size();
        for (T firstname : result) {
            assert ((String) firstname).startsWith("first");
        }
    }
    // end::test_map_person_to_firstname[]
}
