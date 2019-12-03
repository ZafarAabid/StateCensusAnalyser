package com.statecensus;

import java.io.IOException;
import java.util.*;

public class StateCensusData {

    public static void main(String[] args) {
        CSVState csvStates = new CSVState();
        CensusData censusDataa = new CensusData();
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        StateCensusDataPojo censusDataPojo=new StateCensusDataPojo();
        List<StateCensusDataPojo> stateCensusDataPojos = new ArrayList();
        Map<String,StateCensusDataPojo> stateCensusDataDictionary = new HashMap<>();

        try {
            Iterator<StateCensusDataPojo> stateCensusDataPojoIterator=stateCensusAnalyser.createBuilder("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCode.csv",StateCensusDataPojo.class);
            Iterator<CensusData> censusDataIterator=stateCensusAnalyser.createBuilder("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv",CensusData.class);
                while (stateCensusDataPojoIterator.hasNext())
                {
                    StateCensusDataPojo stateCensusDataPojo = stateCensusDataPojoIterator.next();

                    censusDataIterator=stateCensusAnalyser.createBuilder("/home/user/workspace/IndianStateCensusAnalyser/src/main/resources/StateCensusData.csv",CensusData.class);
                    while (censusDataIterator.hasNext())
                        {
                            CensusData censusData = censusDataIterator.next();
                            //System.out.println(stateCensusDataPojo.getStateName()+"----"+censusData.getStateName());
                            if (stateCensusDataPojo.getStateName().equals(censusData.getStateName()))
                             {
                                 stateCensusDataPojo.setAreaInSqKm(censusData.getAreaInSqKm());
                                 stateCensusDataPojo.setPopulation(censusData.getPopulation());
                                 stateCensusDataPojo.setDensityPerSqKm(censusData.getDensityPerSqKm());

                                 stateCensusDataPojos.add(stateCensusDataPojo);
                                 stateCensusDataDictionary.put(stateCensusDataPojo.getStateName(),stateCensusDataPojo);

                                 /*System.out.println("------------------");
                                 System.out.println(stateCensusDataPojo.getStateName()+" "+stateCensusDataPojo.getSrNo()+" "+stateCensusDataPojo.getStateCode()+" "+stateCensusDataPojo.getTIN());
                                 System.out.println(stateCensusDataPojo.getPopulation()+" "+stateCensusDataPojo.getDensityPerSqKm()+" "+stateCensusDataPojo.getAreaInSqKm());
                                 System.out.println("------------------");
                                 */break;
                             }

                }

            }
            for (StateCensusDataPojo person : stateCensusDataPojos) {
                for (StateCensusDataPojo person2 : stateCensusDataPojos) {
                    if (person.getStateName().compareTo(person2.getStateName()) > 0) {
                        StateCensusDataPojo temp = person;
                        person = person2;
                        person2 = temp;
                    }
                }
            }
            Iterator<StateCensusDataPojo> iterator =stateCensusDataPojos.iterator();
            while(iterator.hasNext())
            {
                StateCensusDataPojo stateCensusDataPojo = iterator.next();
                System.out.println(stateCensusDataPojo.getStateName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
