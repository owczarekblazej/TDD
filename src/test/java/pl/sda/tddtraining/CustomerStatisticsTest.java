package pl.sda.tddtraining;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerStatisticsTest {

//    aby nie wywalał się błąd przy puszczeniu wszystkich testów, można też dodać słówko static do poniższej zmiennej
    private CustomerStatistics customerStatistics = new CustomerStatistics();


    @Test
    void shouldIdIncreasedByOne() {
        List<Customer> people = customerStatistics.getPeople();
        // pętla stworzona za pomocą skrótu 'iter'
        int count = 1;
        for (Customer person : people) {
            Assertions.assertEquals(count++, person.getId().intValue());
        }
    }

    @Test
    void shouldReturnProperNames() {
        List<String> peopleNames = customerStatistics.getPeoplesNames();
        List<String> peopleNamesWithStream = customerStatistics.getPeopleNamesWithStream();

        Assertions.assertEquals("Anna Nowak", peopleNames.get(0));// cos nie działa
        Assertions.assertEquals("Monika Kos", peopleNames.get(4));// cos nie działa
        Assertions.assertEquals("Marek Nowak", peopleNamesWithStream.get(2));
    }

    @Test
    void shouldPopulateCustomersMap() {
        Map<Integer, Customer> customersMap = customerStatistics.returnListOfCustomersAsMap();
        Map<Integer, Customer> customersAsMapWithStream = customerStatistics.returnListOfCustomersAsMapWithStream();

        Assertions.assertEquals("Marek Nowak", customersMap.get(3).getCustomerNameWithLastName());
        Assertions.assertEquals("Monika Kos", customersAsMapWithStream.get(5).getCustomerNameWithLastName());
    }

    @Test
    void shouldPopulateCustomersMapBySalary(){
        Map<Integer, List<Customer>> customersMapBySalary = customerStatistics.getCustomersMapBySalary();

        Assertions.assertEquals(2,customersMapBySalary.get(1200).size());
    }

    @Test
    void shouldPopulateCustomersMapBySalaryWithStream(){
        Map<Integer, List<Customer>> customersMapBySalary = customerStatistics.getCustomersMapBySalaryWithStream();

        Assertions.assertEquals(2,customersMapBySalary.get(1200).size());
    }

    @Test
    void shouldPopulateNumberOfCustomersMapBySalary(){
        Map<Integer, Integer> customersMapBySalary = customerStatistics.getNumberOfPersonsWithTheSameSalary();

        Assertions.assertEquals(2,customersMapBySalary.get(1200).intValue());
    }

    @Test
    void shouldPopulateNumberOfCustomersMapBySalaryWithStream(){
        Map<Integer, Long> customersMapBySalary = customerStatistics.getNumberOfPersonsWithTheSameSalaryWithStream();

        Assertions.assertEquals(2,customersMapBySalary.get(1200).intValue());
    }

    @Test
    void shouldPopulateMapOfMapsBySalary(){
        Map<String, Map<Integer, Integer>> customersMapOfMapsBySalary = customerStatistics.getMapOfMapsWithSalary();

        Assertions.assertEquals(2,customersMapOfMapsBySalary.get("Adam").get(3333).intValue());
    }

    @Test
    void shouldPopulateMapOfMapsBySalaryWithStream(){
        Map<String, Map<Integer, Integer>> customersMapOfMapsBySalary = customerStatistics.getMapOfMapsWithSalary();

        Assertions.assertEquals(2,customersMapOfMapsBySalary.get("Adam").get(3333).intValue());
    }


    @Test
    void shouldPopulateCustomersMapBySalarySum(){
        Map<String, Integer> customerStatisticsMapWithSalarySum = customerStatistics.getMapWithSalarySum();

        Assertions.assertEquals(7766,customerStatisticsMapWithSalarySum.get("Adam").intValue());
    }

    @Test
    void shouldPopulateCustomersMapBySalarySumWithStream(){
        Map<String, Integer> customerStatisticsMapWithSalarySum = customerStatistics.getMapWithSalarySumWithStream();

        Assertions.assertEquals(7766,customerStatisticsMapWithSalarySum.get("Adam").intValue());
    }
}