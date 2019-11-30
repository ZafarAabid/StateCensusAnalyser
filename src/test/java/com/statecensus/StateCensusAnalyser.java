package com.statecensus;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import javax.naming.NameNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    public StateCensusAnalyser() {
    }

    private static final String CSV_FILE_PATH = "/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode.csv";

    public int getRecordCount() throws IOException, CustomException {
        int count=0;
        try
        {
            Reader reader= Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CsvToBean csvToBean= new CsvToBeanBuilder(reader).withType(CSVState.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CSVState> csvStateIterator = csvToBean.iterator();
            while(csvStateIterator.hasNext())
            {
                csvStateIterator.next();
                count++;
            }
        }

        catch (NoSuchFileException e){
            throw new CustomException(CustomException.ExceptionType.NO_SUCH_FILE,"PLease Enter Proper File Path",e);
        }
        catch (RuntimeException e)
        {
            throw new CustomException(CustomException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME,"binding of file to Object failed");
        }

        return count;
    }
}
