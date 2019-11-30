package com.statecensus;

import com.opencsv.bean.CsvBindByName;

public class StateCensusData {

    public StateCensusData() {
    }
    public StateCensusData(String state, int population, int areaInSqKm, int densityPerSqKm) {
        this.state = state;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
        this.densityPerSqKm = densityPerSqKm;
    }

    @CsvBindByName
    private String state;
    @CsvBindByName
    private int population;
    @CsvBindByName
    private int areaInSqKm;
    @CsvBindByName
    private int densityPerSqKm;


    public String getState() {
        return state;
    }

    public int getPopulation() {
        return population;
    }

    public int getAreaInSqKm() {
        return areaInSqKm;
    }

    public int getDensityPerSqKm() {
        return densityPerSqKm;
    }

    public void setState(String state) {
        state = state;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setAreaInSqKm(int areaInSqKm) {
        areaInSqKm = areaInSqKm;
    }

    public void setDensityPerSqKm(int densityPerSqKm) {
        densityPerSqKm = densityPerSqKm;
    }
}
