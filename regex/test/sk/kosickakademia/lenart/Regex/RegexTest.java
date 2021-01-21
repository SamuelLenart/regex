package sk.kosickakademia.lenart.Regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexTest {

    @Test
    void checkValue() {
        Regex regex=new Regex();
        assertTrue(regex.checkValue("145"));
        assertTrue(regex.checkValue("0,14"));
        assertTrue(regex.checkValue("0"));
        assertTrue(regex.checkValue("1.15"));
        assertTrue(regex.checkValue("700000000000"));
        assertTrue(regex.checkValue("0.01"));
        assertTrue(regex.checkValue("20.08"));
        assertTrue(regex.checkValue("70.07"));
        assertTrue(regex.checkValue("19"));

        assertFalse(regex.checkValue(null));
        assertFalse(regex.checkValue(""));
        assertFalse(regex.checkValue("414,124"));
        assertFalse(regex.checkValue("0,00"));
        assertFalse(regex.checkValue("7,0"));
        assertFalse(regex.checkValue("009"));
        assertFalse(regex.checkValue("!2"));
        assertFalse(regex.checkValue("6, 08"));
        assertFalse(regex.checkValue("2..55"));
        assertFalse(regex.checkValue("02,45"));
        assertFalse(regex.checkValue("00"));
        assertFalse(regex.checkValue("7,00"));
        assertFalse(regex.checkValue("4,850"));
        assertFalse(regex.checkValue("2,2"));
        assertFalse(regex.checkValue("seven"));
        assertFalse(regex.checkValue("2.2.71"));
        assertFalse(regex.checkValue(","));
        assertFalse(regex.checkValue("0,0"));
        assertFalse(regex.checkValue(",45"));
        assertFalse(regex.checkValue("1   1,45"));
    }
}