package com.statecensus;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTests {
    @Test
    public void WhenReadFile_CountRecords_ifCorrect_ShouldReturnTrue() throws IOException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        Assert.assertEquals(37,stateCensusAnalyser.getRecordCount());
    }
}
