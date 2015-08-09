package com.paypal.tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class SimpleTest
{
    private String param = "";
 
    public SimpleTest(String param) {
        this.param = param;
    }
 
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before SimpleTest class executed.");
    }
 
    @Test
    public void testMethod() {
        System.out.println("testMethod parameter value is: " + param);
        System.out.println("JJJJJ");
    }
    
    @Factory
    public Object[] factoryMethod() {
        return new Object[] {
                                new SimpleTest("one"),
                                new SimpleTest("two")
                            };
    }
}
 
