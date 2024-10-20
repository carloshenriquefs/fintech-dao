package org.example.model;

public class Statistic {

    private Long code;
    private Long userId;
    private Integer month;
    private Integer year;
    private Double budge;
    private Double cost;
    private Double economy;

    public Statistic(Long code, Long userId, Integer month, Integer year, Double budge, Double cost, Double economy) {
        this.code = code;
        this.userId = userId;
        this.month = month;
        this.year = year;
        this.budge = budge;
        this.cost = cost;
        this.economy = economy;
    }

    public Statistic(Long userId, Integer month, Integer year, Double budge, Double cost, Double economy) {
        this.userId = userId;
        this.month = month;
        this.year = year;
        this.budge = budge;
        this.cost = cost;
        this.economy = economy;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
