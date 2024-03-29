package com.statecensus;

import com.opencsv.bean.CsvBindByName;

public class StateCensusDataPojo implements Comparable<StateCensusDataPojo>{


    @CsvBindByName(column = "StateName")
    private String StateName;
    @CsvBindByName(column = "SrNo")
    private int SrNo;
    @CsvBindByName(column = "TIN")
    private String TIN;
    @CsvBindByName(column = "StateCode")
    private String StateCode;
    private double population;
    private double areaInSqKm;
    private double densityPerSqKm;


    public StateCensusDataPojo() {}

    public StateCensusDataPojo(int srNo, String stateName, String TIN, String stateCode, double population, double areaInSqKm, double densityPerSqKm) {
        SrNo = srNo;
        StateName = stateName;
        this.TIN = TIN;
        StateCode = stateCode;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
        this.densityPerSqKm = densityPerSqKm;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public void setSrNo(int srNo) {
        SrNo = srNo;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    public void setStateCode(String stateCode) {
        StateCode = stateCode;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public void setAreaInSqKm(double areaInSqKm) {
        this.areaInSqKm = areaInSqKm;
    }

    public void setDensityPerSqKm(double densityPerSqKm) {
        this.densityPerSqKm = densityPerSqKm;
    }



    public String getStateName() {
        return StateName;
    }

    public int getSrNo() {
        return SrNo;
    }

    public String getTIN() {
        return TIN;
    }

    public String getStateCode() {
        return StateCode;
    }

    public double getPopulation() {
        return population;
    }

    public double getAreaInSqKm() {
        return areaInSqKm;
    }

    public double getDensityPerSqKm() {
        return densityPerSqKm;
    }

    @Override
    public int compareTo(StateCensusDataPojo o) {
        return this.getStateName().compareTo(o.getStateName());
    }


}
