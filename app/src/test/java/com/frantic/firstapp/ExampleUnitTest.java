package com.frantic.firstapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){

    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void ShouldHaveMoreThenSixSymbols(){
        assertFalse(PasswordUtil.isStrongPassword("A1"));
        assertFalse(PasswordUtil.isStrongPassword("Mal123"));
        assertTrue(PasswordUtil.isStrongPassword("Profit123"));
    }

    @Test
    public void ShouldHaveAtLeastOneDigit(){
        assertFalse(PasswordUtil.isStrongPassword("Vasys"));
        assertTrue(PasswordUtil.isStrongPassword("VasYerts1"));
        assertTrue(PasswordUtil.isStrongPassword("Vasys664"));
    }

    @Test
    public void ShouldHaveAtLeastOneCapitalLetter(){
        assertFalse(PasswordUtil.isStrongPassword("vasysykg"));
        assertFalse(PasswordUtil.isStrongPassword("dsdgsdg1234"));
        assertTrue(PasswordUtil.isStrongPassword("Vasys654"));
    }
}