package org.example.model.builder;

import org.example.model.Statistic;

public class StatisticBuilder {

    private Long code;
    private Long userId;
    private Integer month;
    private Integer year;
    private Double budge;
    private Double cost;
    private Double economy;

    public StatisticBuilder setCode(Long code) {
        this.code = code;
        return this;
    }

    public StatisticBuilder setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public StatisticBuilder setMonth(Integer month) {
        this.month = month;
        return this;
    }

    public StatisticBuilder setYear(Integer year) {
        this.year = year;
        return this;
    }

    public StatisticBuilder setBudge(Double budge) {
        this.budge = budge;
        return this;
    }

    public StatisticBuilder setCost(Double cost) {
        this.cost = cost;
        return this;
    }

    public StatisticBuilder setEconomy(Double economy) {
        this.economy = economy;
        return this;
    }

    public Statistic build() {
        return new Statistic(userId, month, year, budge, cost, economy);
    }
}
