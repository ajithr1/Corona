package com.ajith.covid_19.countries;

class Country {

    private String name;

    private String cases;

    private String deaths;

    private String recovered;

    private String today_cases;

    private String today_deaths;

    Country(String name, String cases, String deaths, String recovered, String today_cases, String today_deaths) {
        this.name = name;
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
        this.today_cases = today_cases;
        this.today_deaths = today_deaths;
    }

    public String getName() {
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

    public String getDeaths() {
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

    public String getToday_cases() {
        return today_cases;
    }

    public void setToday_cases(String today_cases) {
        this.today_cases = today_cases;
    }

    public String getToday_deaths() {
        return today_deaths;
    }

    public void setToday_deaths(String today_deaths) {
        this.today_deaths = today_deaths;
    }
}
