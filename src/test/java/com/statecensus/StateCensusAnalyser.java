package com.statecensus;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

public class StateCensusAnalyser {
    public StateCensusAnalyser() {}
    public <T>List getRecordCount(String path,T className) throws IOException, CustomException {
        List<T> censusDataList = new ArrayList();
        int count=0;
        try
        {
            Iterator<T> csvStateIterator= createBuilder(path,className);
            while(csvStateIterator.hasNext())
            {
                T censusData= (T) csvStateIterator.next();
                censusDataList.add(censusData);
                count++;
            }

            return censusDataList;
        }


        catch (NoSuchFileException e){
            throw new CustomException(CustomException.ExceptionType.NO_SUCH_FILE,"PLease Enter Proper File Path",e);
        }
        catch (RuntimeException e)
        {
            throw new CustomException(CustomException.ExceptionType.BINDING_PROBLEM_AT_RUNTIME,"binding of file to Object failed");
        }

    }

    public <T>Iterator createBuilder(String path ,T className ) throws IOException {

        Reader reader= Files.newBufferedReader(Paths.get(path));
        CsvToBean csvToBean= new CsvToBeanBuilder(reader).withType((Class) className).withIgnoreLeadingWhiteSpace(true).build();
        Iterator  csvIterator = csvToBean.iterator();
        return csvIterator;
    }



     Boolean writeToGson(List container) throws IOException {
        try {

            String SAMPLE_JSON_FILE_PATH = "/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/SortCensusData.json";
            Gson gson = new Gson();
            String json = gson.toJson(container);
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();
            return true;
        }   catch (Exception e)
        {
            return false;
        }
    }
}
