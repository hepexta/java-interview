package com.hepexta.interview.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class ExceptionTest {

    @Test
    public void test_finaly() {
        Assert.assertEquals(2, finallyReturnTest());
    }

    @Test
    public void test_throwsFinallyReturnTest() {
        Assert.assertEquals(2, throwsAndFinallyReturnTest());
    }

    private static int finallyReturnTest() {
        try {
            return 1;
        }
        finally {
            return 2;
        }
    }

    private static int throwsAndFinallyReturnTest() {
        try {
            throw new Exception();
        } catch(Exception ex){
            throw new Exception();
        }finally{
            return 2;
        }
    }



}
