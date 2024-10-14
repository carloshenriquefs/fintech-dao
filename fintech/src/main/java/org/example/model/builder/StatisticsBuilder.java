package org.example.model.builder;

import org.example.model.Statistics;

public class StatisticsBuilder {

    private Long code;
    private Long userCode;
    private Integer month;
    private Integer year;
    private Double budge;
    private Double cost;
    private Double economy;

    public StatisticsBuilder setCode(Long code) {
        this.code = code;
        return this;
    }

    public StatisticsBuilder setUserCode(Long userCode) {
        this.userCode = userCode;
        return this;
    }

    public StatisticsBuilder setMonth(Integer month) {
        this.month = month;
        return this;
    }

    public StatisticsBuilder setYear(Integer year) {
        this.year = year;
        return this;
    }

    public StatisticsBuilder setBudge(Double budge) {
        this.budge = budge;
        return this;
    }

    public StatisticsBuilder setCost(Double cost) {
        this.cost = cost;
        return this;
    }

    public StatisticsBuilder setEconomy(Double economy) {
        this.economy = economy;
        return this;
    }

    public Statistics build() {
        return new Statistics(code, userCode, month, year, budge, cost, economy);
    }
}
