package com.statecensus;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class StateCensusAnalyserTests {
    StateCensusAnalyser stateCensusAnalyser =new StateCensusAnalyser();
    @Test
    public void WhenReadFile_CountRecords_ifCorrect_ShouldReturnTrue() {
        System.out.println("WhenReadFile_CountRecords_ifCorrect_ShouldReturnTrue");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        List list = null;
        try {
            list = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode.csv", CSVState.class);
        } catch (CustomException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(37,list.size());    }

    @Test
    public void WhenReadFile_ifFileNameIsNotCorrect_ShouldThrowException() {
        System.out.println("WhenReadFile_ifFileNameIsNotCorrect_ShouldThrowException");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List list =stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode123.csv",CSVState.class);
            Assert.assertEquals(37,list.size());
        }
        catch (CustomException e)
        {
            System.out.println("METHOD_INVOCATION_ISSUE");
            Assert.assertEquals(CustomException.ExceptionType.METHOD_INVOCATION_ISSUE,e.type);
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
            System.out.println("METHOD_INVOCATION_ISSUE issue");
                Assert.assertEquals(CustomException.ExceptionType.METHOD_INVOCATION_ISSUE, e.type);
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
        }
    }
    //----------------------------------------------------------------------------------------------

    @Test
    public void WhenReadFile_CountRecordsOfCensus_ifCorrect_ShouldReturnTrue() {
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
    public void WhenReadFile_CountRecordsOfCensus_ifFileNameIsNotCorrect_ShouldThrowException(){
        System.out.println("WhenReadFile_CountRecordsOfCensus_ifFileNameIsNotCorrect_ShouldThrowException");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist=stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData123.csv",CensusData.class);
            Assert.assertEquals(29, censusDatalist.size());
        }catch (CustomException e)
        {
            System.out.println("METHOD_INVOCATION_ISSUE");
            Assert.assertEquals(CustomException.ExceptionType.METHOD_INVOCATION_ISSUE,e.type);
        }
    }

    @Test
    public void WhenReadFile_CountRecordsOfCensus_ifFileNameIsCorrect_butExtensionIsNotCorrecct_ShouldThrowException(){
        System.out.println("WhenReadFile_CountRecordsOfCensus_ifFileNameIsCorrect_butExtensionIsNotCorrecct_ShouldThrowException");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist=stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.txt",CensusData.class);
            Assert.assertEquals(29, censusDatalist.size());
        }catch (CustomException e)
        {
            System.out.println("METHOD_INVOCATION_ISSUE");
            Assert.assertEquals(CustomException.ExceptionType.METHOD_INVOCATION_ISSUE,e.type);
        }
    }

    @Test
    public void WhenReadFile_CountRecordsOfCensus_ifFileNameIsCorrect_butDelimeterIsNotCorrecct_ShouldThrowException(){
        System.out.println("WhenReadFile_CountRecordsOfCensus_ifFileNameIsCorrect_butDelimeterIsNotCorrecct_ShouldThrowException");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist=stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/State-Census-Data.csv",CensusData.class);
            Assert.assertEquals(29, censusDatalist.size());
        }catch (CustomException e)
        {
            if(e.type.toString().equals("METHOD_INVOCATION_ISSUE")) {
                System.out.println("METHOD_INVOCATION_ISSUE");
                Assert.assertEquals(CustomException.ExceptionType.METHOD_INVOCATION_ISSUE, e.type);
            }
            else if(e.type.toString().equals("BINDING_PROBLEM_AT_RUNTIME")) {
                System.out.println("BINDING_PROBLEM_AT_RUNTIME");
                Assert.assertEquals(CustomException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
            }
        }
    }
    @Test
    public void WhenReadFile_CountRecordsOfCensus_ifFileNameIsCorrect_butHeaderIsNotCorrecct_ShouldThrowException(){
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
    public void WhenReadFile_CountRecordsOfCensus_SortByStateName_ReturnTrue(){
        System.out.println("WhenReadFile_CountRecordsOfCensus_SortByStateName_ReturnTrue");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist=stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv",CensusData.class);
            stateCensusAnalyser.sortThisListBasedOnStateName(censusDatalist);
            Iterator iterator=censusDatalist.iterator();
            while (iterator.hasNext())
            {
                CensusData censusData = (CensusData) iterator.next();
                System.out.println("stateName:"+censusData.getStateName());
            }
            Assert.assertTrue(stateCensusAnalyser.writeToGson(censusDatalist));

        }catch (CustomException e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void WhenReadFile_CountRecordsOfCensus_SortByPopulation_ReturnTrue(){
        System.out.println("WhenReadFile_CountRecordsOfCensus_SortByPopulation_ReturnTrue");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist=stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv",CensusData.class);
            stateCensusAnalyser.sortThisListBasedOnPopulation(censusDatalist);
            Iterator iterator=censusDatalist.iterator();
            while (iterator.hasNext())
            {
                CensusData censusData = (CensusData) iterator.next();
                System.out.println("stateName:"+censusData.getStateName());
                System.out.println("population:"+censusData.getPopulation());
            }
            Assert.assertTrue(stateCensusAnalyser.writeToGson(censusDatalist));
        }catch (CustomException e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void WhenReadFile_CountRecordsOfCensus_SortByPopulationDensity_ReturnTrue(){
        System.out.println("WhenReadFile_CountRecordsOfCensus_SortByPopulation_ReturnTrue");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist=stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv",CensusData.class);
            stateCensusAnalyser.sortThisListBasedOnPopulationdensity(censusDatalist);
            Iterator iterator=censusDatalist.iterator();
            while (iterator.hasNext())
            {
                CensusData censusData = (CensusData) iterator.next();
                System.out.println("stateName:"+censusData.getStateName());
                System.out.println("population:"+censusData.getPopulation());
            }
            Assert.assertTrue(stateCensusAnalyser.writeToGson(censusDatalist));
        }catch (CustomException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void WhenReadFile_CountRecordsOfCensus_SortByAreaDensity_ReturnTrue(){
        System.out.println("WhenReadFile_CountRecordsOfCensus_SortByParameter_ReturnTrue");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist=stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv",CensusData.class);
            stateCensusAnalyser.sortThisList(censusDatalist,"state");
            Iterator iterator=censusDatalist.iterator();
            while (iterator.hasNext())
            {
                CensusData censusData = (CensusData) iterator.next();
                System.out.println("stateName:"+censusData.getStateName());
                System.out.println("population:"+censusData.getPopulation());
                System.out.println("Area:"+censusData.getAreaInSqKm());
                System.out.println("Density:"+censusData.getDensityPerSqKm());
                System.out.println("----------------------------------------------");
            }
            Assert.assertTrue(stateCensusAnalyser.writeToGson(censusDatalist));
        }catch (CustomException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
