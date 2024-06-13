package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rate {
    @JsonProperty("Cur_ID")
    private int id;

    @JsonProperty("Date")
    private String date;

    @JsonProperty("Cur_Abbreviation")
    private String abbreviation;

    @JsonProperty("Cur_Scale")
    private double scale;

    @JsonProperty("Cur_Name")
    private String name;

    @JsonProperty("Cur_OfficialRate")
    private double officialRate;
    /*
     * Тип double не рекомендуется использовать для хранения денежных сумм из-за
     * того, что он хранит округлённое значение. Но для того, чтобы не усложнять
     * пример, здесь позволим себе его использовать
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOfficialRate() {
        return officialRate;
    }

    public void setOfficialRate(double officialRate) {
        this.officialRate = officialRate;
    }

    @Override
    public String toString() {
        return "Rate {" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", scale=" + scale +
                ", name='" + name + '\'' +
                ", officialRate=" + officialRate +
                '}';
    }
}