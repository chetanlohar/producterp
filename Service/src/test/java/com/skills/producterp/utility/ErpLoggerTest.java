package com.skills.producterp.utility;

import org.junit.Before;
import org.junit.Test;

import com.skills.producterp.utility.ErpLogger;

import java.io.File;

/**
 * Created by chetanlo on 8/8/2016.
 */
public class ErpLoggerTest {

    public ErpLogger erpLogger;

    @Before
    public void initializer(){
        erpLogger=new ErpLogger(ErpLoggerTest.class);

    }
    @Test
    public void itShouldAbleToCheckTheFunctionalityOfBwLogger(){
        erpLogger.info("info message");
        erpLogger.warn("warn message");
        erpLogger.debug("debug message");
        try
        {
            int number=1/0;
        }
        catch(Exception e)
        {
            erpLogger.error(e);
        }
        File folder = new File("/Logs");
        File[] listOfFiles = folder.listFiles();
        for(int i=0;i<listOfFiles.length;i++)
            org.junit.Assert.assertTrue(listOfFiles[i].exists());
    }
}