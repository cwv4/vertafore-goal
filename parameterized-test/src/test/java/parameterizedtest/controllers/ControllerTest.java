package parameterizedtest.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import parameterizedtest.models.Option;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

class ControllerTest {

    @ParameterizedTest
    @CsvSource(value = {
            "Alternating|a,b,c,d,e,f|[a, d, b, e, c, f]",
            "Descending|a,b,c,d,e,f|[f, e, d, c, b, a]",
            "Ascending|r,t,y,n,V,V,B,m,l,p,E,S,A,S,D,N,F,W|[A, B, D, E, F, N, S, S, V, V, W, l, m, n, p, r, t, y]",
            "Alternating|sldkj,,vbn,htht,jyuds,Sh,rcf,dr,jhsdvd,aghhjr,MMMMMM|[, jhsdvd, MMMMMM, jyuds, Sh, rcf, aghhjr, sldkj, dr, vbn, htht]",
            "Descending|Bug,car,Duke,man,big,bad,wolf,crib,cRib,crIb,criB,tackle,rat,bat,fat,far|[wolf, tackle, rat, man, fat, far, crib, criB, crIb, car, cRib, big, bat, bad, Duke, Bug]"
    }, delimiter = '|')
    void testQuerySort(String option, String input, String expectedOutput) {
        String testInput = option + "\n" + input + "\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(testIn);

        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        Controller.querySort();
        Assertions.assertEquals(expectedOutput + "\r\n", testOut.toString());
    }

    @ParameterizedTest
    @EnumSource(Option.class)
    void testDelegateSort_AllEnums(Option option) {
        List<String> output = Controller.delegateSort(option.toString(), Arrays.asList("test", "test", "test"));
        Assertions.assertEquals("[test, test, test]", output.toString());
    }

    @ParameterizedTest
    @EnumSource(
            value = Option.class,
            names = {"ASCENDING", "DESCENDING"}
    )
    void testDelegateSort_SomeEnums(Option option) {
        List<String> output = Controller.delegateSort(option.toString(), Arrays.asList("test", "test", "test", "test"));
        Assertions.assertEquals("[test, test, test, test]", output.toString());
    }

    @ParameterizedTest
    @EnumSource(
            value = Option.class,
            names = {"ASCENDING", "DESCENDING"},
            mode = EnumSource.Mode.EXCLUDE
    )
    void testDelegateSort_OtherEnums(Option option) {
        List<String> output = Controller.delegateSort(option.toString(), Arrays.asList("test", "test", "test", "test", "test"));
        Assertions.assertEquals("[test, test, test, test, test]", output.toString());
    }

    @ParameterizedTest
    @EnumSource(
            value = Option.class,
            names = ".+ING",
            mode = EnumSource.Mode.MATCH_ANY
    )
    void testDelegateSort_NonRandomEnums(Option option) {
        List<String> output = Controller.delegateSort(option.toString(), Arrays.asList("test", "test"));
        Assertions.assertEquals("[test, test]", output.toString());
    }
}
