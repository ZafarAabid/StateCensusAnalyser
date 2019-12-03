package com.statecensus;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StateCensusData {

    public static void main(String[] args) {
        CSVState csvStates = new CSVState();
        CensusData censusDataa = new CensusData();
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        StateCensusDataPojo censusDataPojo=new StateCensusDataPojo();
        List<StateCensusDataPojo> stateCensusDataPojos = new ArrayList();

        try {
            Iterator<CSVState> stateIterator=stateCensusAnalyser.createBuilder("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode.csv",CSVState.class);
            Iterator<CensusData> censusDataIterator=stateCensusAnalyser.createBuilder("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv",CensusData.class);
                while (stateIterator.hasNext())
                {
                    CSVState csvState = stateIterator.next();
                    censusDataIterator=stateCensusAnalyser.createBuilder("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv",CensusData.class);
                    while (censusDataIterator.hasNext())
                        {
                            CensusData censusData = censusDataIterator.next();
                            System.out.println(csvState.getStateName()+"----"+censusData.getStateName());
                            if (csvState.getStateName().equals(censusData.getStateName()))
                             {
                                 censusDataPojo.setStateName(csvState.getStateName());
                                 censusDataPojo.setSrNo(csvState.getSrNo());
                                 censusDataPojo.setStateCode(csvState.getStateCode());
                                 censusDataPojo.setTIN(csvState.getTIN());
                                 censusDataPojo.setAreaInSqKm(censusData.getAreaInSqKm());
                                 censusDataPojo.setPopulation(censusData.getPopulation());
                                 censusDataPojo.setDensityPerSqKm(censusData.getDensityPerSqKm());

                                 System.out.println("------------------");
                                 System.out.println(censusDataPojo.getStateName()+" "+censusDataPojo.getSrNo()+" "+censusDataPojo.getStateCode()+" "+censusDataPojo.getTIN());
                                 System.out.println(censusDataPojo.getPopulation()+" "+censusDataPojo.getDensityPerSqKm()+" "+censusDataPojo.getAreaInSqKm());
                                 System.out.println("------------------");

                                 stateCensusDataPojos.add(censusDataPojo);
                                 break;
                             }
                }
            }
        }
        catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

    }

}
