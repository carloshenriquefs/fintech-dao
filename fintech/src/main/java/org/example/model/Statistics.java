package org.example.model;

public class Statistics {

    private Long code;
    private Long userCode;
    private Integer month;
    private Integer year;
    private Double budge;
    private Double cost;
    private Double economy;

    public Statistics() {
    }

    public Statistics(Long userCode, Integer month, Integer year, Double budge, Double cost, Double economy) {
        this.userCode = userCode;
        this.month = month;
        this.year = year;
        this.budge = budge;
        this.cost = cost;
        this.economy = economy;
    }

    public Statistics(Integer month, Integer year, Double budge, Double cost, Double economy) {
        this.month = month;
        this.year = year;
        this.budge = budge;
        this.cost = cost;
        this.economy = economy;
    }

    public Long getCode() {
        return code;
    }

    public Long getUserCode() {
        return userCode;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getBudge() {
        return budge;
    }

    public void setBudge(Double budge) {
        this.budge = budge;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getEconomy() {
        return economy;
    }

    public void setEconomy(Double economy) {
        this.economy = economy;
    }
}
