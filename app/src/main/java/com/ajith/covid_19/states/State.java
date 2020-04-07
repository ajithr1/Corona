package com.ajith.covid_19.states;

public class State {

    private String name;

    private String cases;

    private String deaths;

    private String recovered;

    public State(String name, String cases, String deaths, String recovered) {
        this.name = name;
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }
}
