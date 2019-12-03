package com.statecensus;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTests {
    StateCensusAnalyser stateCensusAnalyser =new StateCensusAnalyser();
    @Test
    public void WhenReadFile_CountRecords_ifCorrect_ShouldReturnTrue() throws IOException, CustomException {
        System.out.println("WhenReadFile_CountRecords_ifCorrect_ShouldReturnTrue");

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        Assert.assertEquals(37, stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode.csv",CSVState.class));
    }

    @Test
    public void WhenReadFile_ifFileNameIsNotCorrect_ShouldThrowException() throws IOException {
        System.out.println("WhenReadFile_ifFileNameIsNotCorrect_ShouldThrowException");

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(37,stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode123.csv",CSVState.class));
        }
        catch (CustomException e)
        {
            Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }

    @Test
    public void WhenReadFile_ifFileNameIsCorrect_ButExtensionIsNot_ShouldThrowException() {
        System.out.println("WhenReadFile_ifFileNameIsCorrect_ButExtensionIsNot_ShouldThrowException");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(37,stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode.pdf",CSVState.class));
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
            Assert.assertEquals(37,stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StCensusData.csv",CSVState.class));
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
            Assert.assertEquals(37,stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/State-Code.csv",CSVState.class));
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
    public void WhenReadFile_ifFileNameIsGiven_WithDifferentHeader_ShouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
             Assert.assertEquals(37,stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/State-Code.csv",CSVState.class));
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
            Assert.assertEquals(29, stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv",CensusData.class));
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
            Assert.assertEquals(29, stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData123.csv",CensusData.class));
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
            Assert.assertEquals(29, stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.txt",CensusData.class));
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
            Assert.assertEquals(29, stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv",CensusData.class));
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
            Assert.assertEquals(29, stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/State-Census-Data.csv",CensusData.class));
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


}
