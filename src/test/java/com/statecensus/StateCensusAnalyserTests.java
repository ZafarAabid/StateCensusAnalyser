package com.statecensus;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTests {
    @Test
    public void WhenReadFile_CountRecords_ifCorrect_ShouldReturnTrue() throws IOException, CustomException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        Assert.assertEquals(37, stateCensusAnalyser.getRecordCount());
    }

    @Test
    public void WhenReadFile_ifFileNameIsNotCorrect_ShouldThrowException() throws IOException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
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
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(37,stateCensusAnalyser.getRecordCount());
        }
        catch (CustomException e)
        {
                Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void WhenReadFile_ifDifferentFileNameIsGiven_ShouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(37,stateCensusAnalyser.getRecordCount());
        }
        catch (CustomException e)
        {
            if(e.type.equals("NO_SUCH_FILE")) {
                Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE, e.type);
            }
            else if(e.type.equals("BINDING_PROBLEM_AT_RUNTIME")) {
                Assert.assertEquals(CustomException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME, e.type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
