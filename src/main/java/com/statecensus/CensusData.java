package com.statecensus;

import com.opencsv.bean.CsvBindByName;

public class CensusData implements Comparable<CensusData> {

    public CensusData() {
    }

    public CensusData(String stateName, double population, double areaInSqKm, double densityPerSqKm) {
        this.stateName = stateName;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
        this.densityPerSqKm = densityPerSqKm;
    }

    @CsvBindByName(column = "StateName")
    private String stateName;
    @CsvBindByName(column = "Population")
    private double population;
    @CsvBindByName(column = "AreaInSqKm")
    private double areaInSqKm;
    @CsvBindByName(column = "DensityPerSqKm")
    private double densityPerSqKm;


    public String getStateName() {
        return stateName;
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

    public void setStateName(String stateName) {
        this.stateName = stateName;
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

    @Override
    public int compareTo(CensusData object) {
        return this.getStateName().toString().compareTo(object.getStateName().toString());
    }
}
