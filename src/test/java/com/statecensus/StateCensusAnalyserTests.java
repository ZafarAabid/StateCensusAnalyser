package com.statecensus;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class StateCensusAnalyserTests {
    StateCensusAnalyser stateCensusAnalyser =new StateCensusAnalyser();
    @Test
    public void WhenReadFile_CountRecords_ifCorrect_ShouldReturnTrue() throws IOException, CustomException {
        System.out.println("WhenReadFile_CountRecords_ifCorrect_ShouldReturnTrue");

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        List list =stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode.csv",CSVState.class);
        Assert.assertEquals(37,list.size());    }

    @Test
    public void WhenReadFile_ifFileNameIsNotCorrect_ShouldThrowException() throws IOException {
        System.out.println("WhenReadFile_ifFileNameIsNotCorrect_ShouldThrowException");

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List list =stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode123.csv",CSVState.class);
            Assert.assertEquals(37,list.size());
        }
        catch (CustomException e)
        {
            System.out.println("NO_SUCH_FILE");
            Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }

    @Test
    public void WhenReadFile_ifFileNameIsCorrect_ButExtensionIsNot_ShouldThrowException() {
        System.out.println("WhenReadFile_ifFileNameIsCorrect_ButExtensionIsNot_ShouldThrowException");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List list =stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode.txt",CSVState.class);
            Assert.assertEquals(37,list.size());
        }
        catch (CustomException e)
        {
            System.out.println("NO_SUCH_FILE issue");
                Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
        } catch (IOException e) {
            System.out.println("EXCEPTION:"+e.getMessage());
        }
    }

    @Test
    public void WhenReadFile_ifDifferentFileNameIsGiven_ShouldThrowException() {
        System.out.println("WhenReadFile_ifDifferentFileNameIsGiven_ShouldThrowException");

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List list =stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode.csv",CSVState.class);
            Assert.assertEquals(37,list.size());

    }
        catch (CustomException e)
        {
            if(e.type.toString().equals("NO_SUCH_FILE")) {
                System.out.println("NO_SUCH_FILE");
                Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
            }
            else if(e.type.toString().equals("BINDING_PROBLEM_AT_RUNTIME")) {
                System.out.println("BINDING_PROBLEM_AT_RUNTIME");
                Assert.assertEquals(CustomException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
            }
        } catch (IOException e) {
            System.out.println("EXCEPTION:"+e.getMessage());
        }
    }

    @Test
    public void WhenReadFile_ifFileNameIsGiven_WithDifferentDelimeter_ShouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List list =stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/State-Code.csv",CSVState.class);
            Assert.assertEquals(37,list.size());    }
        catch (CustomException e)
        {
            if(e.type.toString().equals("NO_SUCH_FILE")) {
                System.out.println("NO_SUCH_FILE");
                Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
            }
            else if(e.type.toString().equals("BINDING_PROBLEM_AT_RUNTIME")) {
                System.out.println("BINDING_PROBLEM_AT_RUNTIME");
                Assert.assertEquals(CustomException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
            }
        } catch (IOException e) {
            System.out.println("EXCEPTION:"+e.getMessage());
        }
    }
    @Test
    public void WhenReadFile_ifFileNameIsGiven_WithDifferentHeader_ShouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List list =stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/State-Code.csv",CSVState.class);
            Assert.assertEquals(37,list.size());
        }

        catch (CustomException e)
        {
            if(e.type.toString().equals("NO_SUCH_FILE")) {
                System.out.println("NO_SUCH_FILE");
                Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
            }
            else if(e.type.toString().equals("BINDING_PROBLEM_AT_RUNTIME")) {
                System.out.println("BINDING_PROBLEM_AT_RUNTIME");
                Assert.assertEquals(CustomException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
            }
            else{
                System.out.println("EXCEPTION:"+e.type);
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------------

    @Test
    public void WhenReadFile_CountRecordsOfCensus_ifCorrect_ShouldReturnTrue() throws IOException, CustomException {
        System.out.println("WhenReadFile_CountRecordsOfCensus_ifCorrect_ShouldReturnTrue");

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist=stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv",CensusData.class);
            Assert.assertEquals(29, censusDatalist.size());
        }catch (CustomException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void WhenReadFile_CountRecordsOfCensus_ifFileNameIsNotCorrect_ShouldThrowException() throws IOException, CustomException {
        System.out.println("WhenReadFile_CountRecordsOfCensus_ifFileNameIsNotCorrect_ShouldThrowException");

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist=stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData123.csv",CensusData.class);
            Assert.assertEquals(29, censusDatalist.size());
        }catch (CustomException e)
        {
            System.out.println("NO_SUCH_FILE");
            Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }

    @Test
    public void WhenReadFile_CountRecordsOfCensus_ifFileNameIsCorrect_butExtensionIsNotCorrecct_ShouldThrowException() throws IOException, CustomException {
        System.out.println("WhenReadFile_CountRecordsOfCensus_ifFileNameIsCorrect_butExtensionIsNotCorrecct_ShouldThrowException");

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist=stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.txt",CensusData.class);
            Assert.assertEquals(29, censusDatalist.size());
        }catch (CustomException e)
        {
            System.out.println("NO_SUCH_FILE");
            Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE,e.type);
        }

    }

    @Test
    public void WhenReadFile_CountRecordsOfCensus_ifFileNameIsCorrect_butDelimeterIsNotCorrecct_ShouldThrowException() throws IOException, CustomException {
        System.out.println("WhenReadFile_CountRecordsOfCensus_ifFileNameIsCorrect_butDelimeterIsNotCorrecct_ShouldThrowException");

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist=stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/State-Census-Data.csv",CensusData.class);
            Assert.assertEquals(29, censusDatalist.size());
        }catch (CustomException e)
        {
            if(e.type.toString().equals("NO_SUCH_FILE")) {
                System.out.println("NO_SUCH_FILE");
                Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
            }
            else if(e.type.toString().equals("BINDING_PROBLEM_AT_RUNTIME")) {
            System.out.println("BINDING_PROBLEM_AT_RUNTIME");
            Assert.assertEquals(CustomException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
        }
        }

    }

    @Test
    public void WhenReadFile_CountRecordsOfCensus_ifFileNameIsCorrect_butHeaderIsNotCorrecct_ShouldThrowException() throws IOException, CustomException {
        System.out.println("WhenReadFile_CountRecordsOfCensus_ifFileNameIsCorrect_butHeaderIsNotCorrecct_ShouldThrowException");

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist=stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/State-Census-Data.csv",CensusData.class);
            Assert.assertEquals(29, censusDatalist.size());
        }catch (CustomException e)
        {
            if(e.type.toString().equals("NO_SUCH_FILE")) {
                System.out.println("NO_SUCH_FILE");
                Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
            }
            else if(e.type.toString().equals("BINDING_PROBLEM_AT_RUNTIME")) {
                System.out.println("BINDING_PROBLEM_AT_RUNTIME");
                Assert.assertEquals(CustomException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
            }
        }

    }

    @Test
    public void WhenReadFile_CountRecordsOfCensus_SortByStateName_ReturnTrue() throws IOException {
        System.out.println("WhenReadFile_CountRecordsOfCensus_SortByStateName_ReturnTrue");

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist=stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv",CensusData.class);
            stateCensusAnalyser.sortThisListBasedOnStateName(censusDatalist);
            Iterator iterator=censusDatalist.iterator();
            while (iterator.hasNext())
            {
                CensusData censusData = (CensusData) iterator.next();
                System.out.println(censusData.getStateName());
                System.out.println(censusData.getPopulation());
            }
            Assert.assertTrue(stateCensusAnalyser.writeToGson(censusDatalist));

        }catch (CustomException e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void WhenReadFile_CountRecordsOfCensus_SortByPopulation_ReturnTrue() throws IOException {
        System.out.println("WhenReadFile_CountRecordsOfCensus_SortByPopulation_ReturnTrue");

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist=stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv",CensusData.class);
            stateCensusAnalyser.sortThisListBasedOnPopulation(censusDatalist);
            Iterator iterator=censusDatalist.iterator();
            while (iterator.hasNext())
            {
                CensusData censusData = (CensusData) iterator.next();
                System.out.println(censusData.getStateName());
                System.out.println(censusData.getPopulation());
            }

            Assert.assertTrue(stateCensusAnalyser.writeToGson(censusDatalist));

        }catch (CustomException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
