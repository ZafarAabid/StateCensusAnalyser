package com.statecensus;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class StateCensusAnalyserTests {
    StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();

    @Test
    public void whenReadFile_IfCorrectRecordCounts_ShouldReturnTrue() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        List list = null;
        try {
            list = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode.csv", CSVState.class);
            Assert.assertEquals(37, list.size());
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void whenReadFile_IfFileNameIsNotCorrect_ShouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List list = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode123.csv", CSVState.class);
            Assert.assertEquals(37, list.size());
        } catch (CustomException e) {
            System.out.println("METHOD_INVOCATION_ISSUE");
            Assert.assertEquals(CustomException.ExceptionType.METHOD_INVOCATION_ISSUE, e.type);
        }
    }

    @Test
    public void whenReadFile_IfFileNameIsCorrectButExtensionIsNot_ShouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List list = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode.txt", CSVState.class);
            Assert.assertEquals(37, list.size());
        } catch (CustomException e) {
            System.out.println("METHOD_INVOCATION_ISSUE issue");
            Assert.assertEquals(CustomException.ExceptionType.METHOD_INVOCATION_ISSUE, e.type);
        }
    }

    @Test
    public void whenReadFile_IfDifferentFileNameIsGiven_ShouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List list = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode.csv", CSVState.class);
            Assert.assertEquals(37, list.size());
        } catch (CustomException e) {
            if (e.type.toString().equals("NO_SUCH_FILE")) {
                System.out.println("NO_SUCH_FILE");
                Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
            } else if (e.type.toString().equals("BINDING_PROBLEM_AT_RUNTIME")) {
                System.out.println("BINDING_PROBLEM_AT_RUNTIME");
                Assert.assertEquals(CustomException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
            }
        }
    }

    @Test
    public void whenReadFile_IfFileNameIsGivenWithDifferentDelimeter_ShouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List list = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/State-Code.csv", CSVState.class);
            Assert.assertEquals(37, list.size());
        } catch (CustomException e) {
            if (e.type.toString().equals("NO_SUCH_FILE")) {
                System.out.println("NO_SUCH_FILE");
                Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
            } else if (e.type.toString().equals("BINDING_PROBLEM_AT_RUNTIME")) {
                System.out.println("BINDING_PROBLEM_AT_RUNTIME");
                Assert.assertEquals(CustomException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
            }
        }
    }

    @Test
    public void whenReadFile_IfFileNameIsGivenWithDifferentHeader_ShouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List list = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/State-Code.csv", CSVState.class);
            Assert.assertEquals(37, list.size());
        } catch (CustomException e) {
            if (e.type.toString().equals("NO_SUCH_FILE")) {
                System.out.println("NO_SUCH_FILE");
                Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
            } else if (e.type.toString().equals("BINDING_PROBLEM_AT_RUNTIME")) {
                System.out.println("BINDING_PROBLEM_AT_RUNTIME");
                Assert.assertEquals(CustomException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
            } else {
                System.out.println("EXCEPTION:" + e.type);
            }
        }
    }

    @Test
    public void whenReadFile_CountRecordsOfCensus_ifCorrect_ShouldReturnTrue() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv", CensusData.class);
            Assert.assertEquals(29, censusDatalist.size());
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void whenReadFile_ifFileNameIsNotCorrect_ShouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData123.csv", CensusData.class);
            Assert.assertEquals(29, censusDatalist.size());
        } catch (CustomException e) {
            System.out.println("METHOD_INVOCATION_ISSUE");
            Assert.assertEquals(CustomException.ExceptionType.METHOD_INVOCATION_ISSUE, e.type);
        }
    }

    @Test
    public void whenReadFile_IfFileNameIsCorrectButExtensionIsNotCorrecct_ShouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.txt", CensusData.class);
            Assert.assertEquals(29, censusDatalist.size());
        } catch (CustomException e) {
            System.out.println("METHOD_INVOCATION_ISSUE");
            Assert.assertEquals(CustomException.ExceptionType.METHOD_INVOCATION_ISSUE, e.type);
        }
    }

    @Test
    public void whenReadFile_ifFileNameIsCorrectButDelimeterIsNotCorrecct_ShouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/State-Census-Data.csv", CensusData.class);
            Assert.assertEquals(29, censusDatalist.size());
        } catch (CustomException e) {
            if (e.type.toString().equals("METHOD_INVOCATION_ISSUE")) {
                System.out.println("METHOD_INVOCATION_ISSUE");
                Assert.assertEquals(CustomException.ExceptionType.METHOD_INVOCATION_ISSUE, e.type);
            } else if (e.type.toString().equals("BINDING_PROBLEM_AT_RUNTIME")) {
                System.out.println("BINDING_PROBLEM_AT_RUNTIME");
                Assert.assertEquals(CustomException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
            }
        }
    }

    @Test
    public void whenReadFile_IfFileNameIsCorrectButHeaderIsNotCorrecct_ShouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/State-Census-Data.csv", CensusData.class);
            Assert.assertEquals(29, censusDatalist.size());
        } catch (CustomException e) {
            if (e.type.toString().equals("NO_SUCH_FILE")) {
                System.out.println("NO_SUCH_FILE");
                Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
            } else if (e.type.toString().equals("BINDING_PROBLEM_AT_RUNTIME")) {
                System.out.println("BINDING_PROBLEM_AT_RUNTIME");
                Assert.assertEquals(CustomException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
            }
        }
    }

    @Test
    public void whenReadFile_RecordsOfCensusSortByStateName_ReturnTrue() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv", CensusData.class);
            stateCensusAnalyser.sortThisListBasedOnStateName(censusDatalist);
            Iterator iterator = censusDatalist.iterator();
            while (iterator.hasNext()) {
                CensusData censusData = (CensusData) iterator.next();
                System.out.println("stateName:" + censusData.getStateName());
            }
            Assert.assertTrue(stateCensusAnalyser.writeToGson(censusDatalist));

        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void whenReadFile_RecordsOfCensusSortByPopulation_ReturnTrue() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv", CensusData.class);
            stateCensusAnalyser.sortThisListBasedOnPopulation(censusDatalist);
            Iterator iterator = censusDatalist.iterator();
            while (iterator.hasNext()) {
                CensusData censusData = (CensusData) iterator.next();
                System.out.println("stateName:" + censusData.getStateName());
                System.out.println("population:" + censusData.getPopulation());
            }
            Assert.assertTrue(stateCensusAnalyser.writeToGson(censusDatalist));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void whenReadFile_RecordsOfCensusSortByPopulationDensity_ReturnTrue() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv", CensusData.class);
            stateCensusAnalyser.sortThisListBasedOnPopulationdensity(censusDatalist);
            Iterator iterator = censusDatalist.iterator();
            while (iterator.hasNext()) {
                CensusData censusData = (CensusData) iterator.next();
                System.out.println("stateName:" + censusData.getStateName());
                System.out.println("population:" + censusData.getPopulation());
            }
            Assert.assertTrue(stateCensusAnalyser.writeToGson(censusDatalist));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void whenReadFile_RecordsOfCensusSortByAreaDensity_ReturnTrue() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            List censusDatalist = stateCensusAnalyser.getRecordCount("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv", CensusData.class);
            stateCensusAnalyser.sortThisList(censusDatalist, "state");
            Assert.assertTrue(stateCensusAnalyser.writeToGson(censusDatalist));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
}
