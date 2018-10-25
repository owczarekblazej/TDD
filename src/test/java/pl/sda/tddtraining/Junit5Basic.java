package pl.sda.tddtraining;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Junit5Basic {

    private static Calculator calculator;  // zmienna referencyjna statyczna

    // tworzymy tu rzeczy które będziemy wykorzysteywać we wszystkich testach
    //Ctrl+Shift+ strzałka do góry przenosi nam metody do góry lub w dół
    @BeforeAll
    public static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    public void firstTest() {
        int a = 1;
        int b = 2;
        assert 3 == calculator.add(a, b); // przycisk F2 przesuwa na do miejsca występowania błędu
    }
    // wyjątki to są obiekty określonych klas; wszystkie wyjątki dziedziczą z Throwable


    @Test
    void firstJunitTest() {
        int a = 1;
        int b = 2;
        Assertions.assertEquals(4, calculator.add(a, b)); // skrót Ctrl+P pokazuje jakie parametry możemy przekazać do metody
    }

    @Test
    void assertions() {
        List<String> legacyPeople = new ArrayList();
        legacyPeople.add ("Adam Nowak");
        legacyPeople.add("Jan Kowalski"); // Ctrl+Shif+Enter uzupełni nam braki w linijce kodu

        // tak możemy tworzyć listę - dzieki bibliotece guava
        // Ctrl+Alt+V tworzenie zmiennej na podstawie kodu
        List<String> people = Lists.newArrayList("Adam Nowak", "Jan Kowalski");
        Assertions.assertNotNull(people);
        Assertions.assertSame(people, people); // ta metoda uzywa == do porównania
        Assertions.assertNotSame(people, legacyPeople);
        Assertions.assertLinesMatch(legacyPeople, people);
        Assertions.assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3});
        // domyślna wartość dla int to 0 a dla Integer to null
    }
}
