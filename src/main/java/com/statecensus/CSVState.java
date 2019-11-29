package com.statecensus;

import com.opencsv.bean.CsvBindByName;

public class CSVState {

    @CsvBindByName
    private int SrNo;
    @CsvBindByName
    private String StateName;
    @CsvBindByName
     private String TIN;
    @CsvBindByName
     private String StateCode;

    public CSVState() {}
    public CSVState(String stateName, int srNo, String TIN, String stateCode) {
        StateName = stateName;
        SrNo = srNo;
        this.TIN = TIN;
        StateCode = stateCode;
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


}
