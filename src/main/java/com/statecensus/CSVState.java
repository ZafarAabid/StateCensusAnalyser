package com.statecensus;

import com.opencsv.bean.CsvBindByName;

public class CSVState {

    public CSVState() {}

    @CsvBindByName(column = "SrNo")
    private int SrNo;
    @CsvBindByName(column = "StateName")
    private String StateName;
    @CsvBindByName(column = "TIN")
     private String TIN;
    @CsvBindByName(column = "StateCode")
     private String StateCode;

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
