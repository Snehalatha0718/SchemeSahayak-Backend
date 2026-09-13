package com.SchemeSahayak.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "entrepreneur_profiles")
public class EntrepreneurProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private String state;
    private String gender;
    private String category;
    private Double income;
    private String disability;
    private String businessType;
    private String businessStage;
    private Double funding;

    public EntrepreneurProfile() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessStage() {
        return businessStage;
    }

    public void setBusinessStage(String businessStage) {
        this.businessStage = businessStage;
    }

    public Double getFunding() {
        return funding;
    }

    public void setFunding(Double funding) {
        this.funding = funding;
    }
}