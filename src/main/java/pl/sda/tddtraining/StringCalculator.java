package pl.sda.tddtraining;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {
    public static int adding(String data) {
        if (StringUtils.isBlank(data)) {
            return 0;
        }
        return tokenizeAndSum(data);
    }

    private static int tokenizeAndSum(String data) {
        if(data.startsWith("//")){
            String delimiter = "";
        }
        String[] splitted = data.split("[,\n]");
        int sum = 0;
        for (String s : splitted) {
            if (StringUtils.isNotBlank(s)) {
                sum = sum + Integer.parseInt(s.trim());
            }
        }
        return sum;
    }

//    1. Stwórz prosty kalkulator String z metodą "int adding(String text)"
//            - Metoda może przyjąć od zera do dwóch liczb i zwróci ich sumę (dla pustego ciągu zwróci 0),
//              na przykład "" lub "1" lub " 1,2 "
//            - Zacznij od najprostszego przypadku testowego pustego łańcucha i przejdź do 1 i 2 liczb
//	- Pamiętaj, aby rozwiązywać problemy tak prosto, jak to tylko możliwe, tak abyś zmusił się do napisania testów
//	- Pamiętaj, aby zrobić refaktor po każdej zmianie
//    2. Metoda adding, powinna obsłużyć dowolną ilość liczb
//    3. Metoda adding powinna obsługiwać nowe linie między liczbami (zamiast przecinków).
//            - Następujące dane wejściowe są ok: "1 \n2,3" (równa się 6)
//            - Następujące dane wejściowe NIE są OK: "1, \n" (nie trzeba tego udowadniać - wystarczy wyjaśnić)

}
