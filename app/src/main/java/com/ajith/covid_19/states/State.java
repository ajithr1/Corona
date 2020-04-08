package com.ajith.covid_19.states;

public class State {

    private String name;

    private String cases;

    private String deaths;

    private String recovered;

    private String today;

    State(String name, String cases, String deaths, String recovered, String today) {
        this.name = name;
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
        this.today = today;
    }

    String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }
}
