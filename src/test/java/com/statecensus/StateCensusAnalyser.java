package com.statecensus;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {


//    private CsvToBean csvToBean;

    public StateCensusAnalyser() {
    }

    public int getRecordCount(String path) throws IOException, CustomException {
        int count=0;
        try
        {
            Iterator<CSVState> csvStateIterator= createBuilder(path,CSVState.class);
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

    public int getRecordCountForCensus(String path) throws IOException, CustomException, ClassNotFoundException {
        int count=0;
        try
        {
            Iterator<StateCensusData> csvStateIterator= createBuilder(path,StateCensusData.class);
            while(csvStateIterator.hasNext())
            {

                StateCensusData censusData = csvStateIterator.next();
                System.out.println(censusData.getState());
                System.out.println(censusData.getDensityPerSqKm());
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

    public <T>Iterator createBuilder(String path ,T className ) throws IOException {

        Reader reader= Files.newBufferedReader(Paths.get(path));
        CsvToBean csvToBean= new CsvToBeanBuilder(reader).withType((Class) className).withIgnoreLeadingWhiteSpace(true).build();
        Iterator  csvIterator = csvToBean.iterator();
        System.out.println(csvIterator.getClass());
        return csvIterator;
    }

}
