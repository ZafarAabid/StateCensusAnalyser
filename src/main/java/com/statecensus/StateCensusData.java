package com.statecensus;

import com.opencsv.bean.CsvBindByName;

public class StateCensusData {

    public StateCensusData() {
    }
    public StateCensusData(String state, double population, double areaInSqKm, double densityPerSqKm) {
        this.state = state;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
        this.densityPerSqKm = densityPerSqKm;
    }

    @CsvBindByName(column = "State")
    private String state;
    @CsvBindByName(column = "Population")
    private double population;
    @CsvBindByName(column = "AreaInSqKm")
    private double areaInSqKm;
    @CsvBindByName(column = "DensityPerSqKm")
    private double densityPerSqKm;


    public String getState() {
        return state;
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

    public void setState(String state) {
        this.state = state;
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
}
