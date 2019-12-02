package com.statecensus;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTests {
    StateCensusAnalyser stateCensusAnalyser =new StateCensusAnalyser();
    @Test
    public void WhenReadFile_CountRecords_ifCorrect_ShouldReturnTrue() throws IOException, CustomException {
        System.out.println("WhenReadFile_CountRecords_ifCorrect_ShouldReturnTrue");

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode.csv");
        Assert.assertEquals(37, stateCensusAnalyser.getRecordCount());
    }

    @Test
    public void WhenReadFile_ifFileNameIsNotCorrect_ShouldThrowException() throws IOException {
        System.out.println("WhenReadFile_ifFileNameIsNotCorrect_ShouldThrowException");

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode123.csv");
        try {
            Assert.assertEquals(37,stateCensusAnalyser.getRecordCount());
        }
        catch (CustomException e)
        {
            Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }

    @Test
    public void WhenReadFile_ifFileNameIsCorrect_ButExtensionIsNot_ShouldThrowException() {
        System.out.println("WhenReadFile_ifFileNameIsCorrect_ButExtensionIsNot_ShouldThrowException");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode.pdf");
        try {
            Assert.assertEquals(37,stateCensusAnalyser.getRecordCount());
        }
        catch (CustomException e)
        {
            System.out.println("NO_SUCH_FILE issue");
                Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void WhenReadFile_ifDifferentFileNameIsGiven_ShouldThrowException() {
        System.out.println("WhenReadFile_ifDifferentFileNameIsGiven_ShouldThrowException");

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv");
        try {
            Assert.assertEquals(37,stateCensusAnalyser.getRecordCount());
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
            e.printStackTrace();
        }
    }

    @Test
    public void WhenReadFile_ifFileNameIsGiven_WithDifferentDelimeter_ShouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/State-Code.csv");
        try {
            Assert.assertEquals(37,stateCensusAnalyser.getRecordCount());
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
            e.printStackTrace();
        }
    }
    @Test
    public void WhenReadFile_ifFileNameIsGiven_WithDifferentHeader_ShouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/State-Code.csv");
        try {
             Assert.assertEquals(37,stateCensusAnalyser.getRecordCount());
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
            Assert.assertEquals(29, stateCensusAnalyser.getRecordCountForCensus("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv"));
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
            Assert.assertEquals(29, stateCensusAnalyser.getRecordCountForCensus("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData123.csv"));
        }catch (CustomException e)
        {
            System.out.println("NO_SUCH_FILE");
            Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }
    
}
