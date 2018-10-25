package pl.sda.tddtraining;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


public class CustomerStatistics {

    Customer[] people = new Customer[]{
            new Customer("Anna", "Nowak   ", 33, "1200"),
            new Customer("Beata", "Kowalska", 22, "1200"),
            new Customer("Marek", " Nowak", 25, "1250"),
            new Customer("Adam", "Twardowski", 33, "1100"),
            new Customer("Monika  ", "Kos", 25, "2500"),
            new Customer("Adam ", "Rudy", 45, "3333"),
            new Customer("Marek", "Rudy", 15, 2210),
            new Customer("Adam", "Madej", 15, 3333)
    };

//    1. Napisz metodę, która zamieni tablicę people na listę people - ta metoda może być potem wykorzystywana przez Was w następnych metodach

    public List<Customer> getPeople() {
        return Arrays.asList(people);
    }

//    2. Napisz metodę, która przyjmie tablicę people i zwróci listę Stringów <imię nazwisko>
//      (elementem listy będzie np "Anna Nowak")

    public List<String> getPeoplesNames() {
        List<String> result = new ArrayList<>();
        for (Customer person : people) {
            result.add(person.getName().trim() + " " + person.getLastName().trim());
        }
        return result;
    }

    public List<String> getPeopleNamesWithStream() {
        return getPeople().stream().map(customer -> customer.getName().trim() + " " + customer.getLastName().trim()).collect(Collectors.toList());
    }

//     3. Napisz metodę, która zwróci mapę osób <id,osoba>

    public Map<Integer, Customer> returnListOfCustomersAsMap() {
        Map<Integer, Customer> result = new HashMap<>();
        for (Customer person : getPeople()) {
            result.put(person.getId(), person);
        }
        return result;
    }

    public Map<Integer, Customer> returnListOfCustomersAsMapWithStream() {
        return getPeople().stream().collect(toMap(c -> c.getId(), c -> c));
        // toMap jest metodą statyczną którą zaimportowaliśmy
    }

    //4. Napisz metodę, która zwróci mapę osób według zarobków <zarobki,osoby_z_zarobkami>

    public Map<Integer, List<Customer>> getCustomersMapBySalary() {
        // po staremu tworzenie Hashmapy
//        Map<Integer, List<Customer>> result = new HashMap<>();
        //a po nowemu tak:
        Map<Integer, List<Customer>> result = Maps.newHashMap();
        for (Customer customer : getPeople()) {
            if (result.containsKey(customer.getSalary())) {
                result.get(customer.getSalary()).add(customer);
            } else {
                result.put(customer.getSalary(), Lists.newArrayList(customer));
            }
        }
        return result;
    }

    public Map<Integer, List<Customer>> getCustomersMapBySalaryWithStream() {
        return getPeople().stream().collect(groupingBy(c -> c.getSalary()));
    }

    //5. Napisz metodę, która zwróci statystykę (mapę) ile jest osób z danymi zarobkami <zarobki,liczba_osób>
    public Map<Integer, Integer> getNumberOfPersonsWithTheSameSalary() {
        Map<Integer, Integer> result = Maps.newHashMap();
        for (Customer person : getPeople()) {
            checkIfSalaryExistAndPopulate(person, result);
        }
        return result;
    }

    public Map<Integer, Long> getNumberOfPersonsWithTheSameSalaryWithStream() {
        // counting zwraca long dlatego zmieniliśmy integer na long w deklaracji mapy
        return getPeople().stream().collect(groupingBy(c -> c.getSalary(), counting()));
    }

//6. Napisz metodę, która zwróci mapę map <imię,<zarobki,liczba_osób_z_takimi_zarobkami>>

    public Map<String, Map<Integer, Integer>> getMapOfMapsWithSalary() {
        Map<String, Map<Integer, Integer>> result = Maps.newHashMap();
        for (Customer person : getPeople()) {
            String formattedName = person.getName().trim();
            if (result.containsKey(formattedName)) {
                Map<Integer, Integer> innerMap = result.get(formattedName);
                checkIfSalaryExistAndPopulate(person, innerMap);
            } else {
                HashMap<Integer, Integer> innerMap = Maps.newHashMap();
                innerMap.put(person.getSalary(), 1);
                result.put(formattedName, innerMap);
            }
        }
        return result;
    }


    public Map<String, Map<Integer, Long>> getMapOfMapsWithSalaryWithStream() {
        return getPeople().stream().collect(
                groupingBy(c -> c.getName(),
                        groupingBy(c -> c.getSalary(), counting())));
    }


    // Ctrl+Alt+M tworzy nam metodę z zaznaczonego kodu (zamieni nawet odpowiedni fragment w innym miejscu)
    private void checkIfSalaryExistAndPopulate(Customer person, Map<Integer, Integer> innerMap) {
        if (innerMap.containsKey(person.getSalary())) {
            Integer counter = innerMap.get(person.getSalary()) + 1;
            innerMap.put(person.getSalary(), counter);
        } else {
            innerMap.put(person.getSalary(), 1);
        }
    }

//  7. Napisz metodę, która zwróci mapę <imię,<suma_zarobków_osób_o_taki_imieniu>>

    public Map<String, Integer> getMapWithSalarySum() {
        Map<String, Integer> result = Maps.newHashMap();
        for (Customer person : getPeople()) {
            String formattedName = person.getName().trim();
            if (result.containsKey(formattedName)) {
                int temp = result.get(formattedName)+ person.getSalary();
                result.put(formattedName, temp);
            } else {
                result.put(formattedName, person.getSalary());
            }
        }
        return result;
    }

    public Map<String, Integer> getMapWithSalarySumWithStream() {

        return getPeople().stream().collect(toMap(customer -> customer.getName().trim(), Customer::getSalary,(integer, integer2) -> integer+integer2));
    }


//    Napiszcie klasę Customer, która będzie reprezentować dane z tablicy + będzie dobierać kolejne id dla kolejnych tworzonych obiektów -> Anna powinna otrzymać id = 1 a Marek id = 3
//
//    Klasa Customer powinna mieć następujące wartości
//    id
//            imię
//    nazwisko
//            wiek
//    zarobki miesięczne -> <tak, w deklaracji w tablicy nie ma błędu, jest wyzwanie;)>

//7. Napisz metodę, która zwróci mapę <imię,<suma_zarobków_osób_o_taki_imieniu>>
//            -----------------------
//    Wszystkie te zadania najlepiej jest napisać z wykorzystaniem testów.
//    W wymienionych przypadkach użyjcie klasycznych pętli oraz streamów (najlepiej jako drugi sposób rozwiązania - np metoda z suffixem "withStream")
}
