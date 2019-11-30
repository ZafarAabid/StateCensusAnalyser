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


    private CsvToBean csvToBean;

    public StateCensusAnalyser() {
    }
    public StateCensusAnalyser(String CSV_FILE_PATH) {
        this.CSV_FILE_PATH=CSV_FILE_PATH;
    }
    private String CSV_FILE_PATH = "";

    public int getRecordCount() throws IOException, CustomException {
        int count=0;
        try
        {
            Reader reader= Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CsvToBean csvToBean= new CsvToBeanBuilder(reader).withType(StateCensusData.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<StateCensusData> csvStateIterator = csvToBean.iterator();
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
