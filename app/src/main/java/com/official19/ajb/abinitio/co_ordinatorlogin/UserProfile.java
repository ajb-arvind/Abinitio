package com.official19.ajb.abinitio.co_ordinatorlogin;

class UserProfile {
    public String name;

    public String email;
    public String department;
    public String event;

    public String round1;
    public String round2;
    public String round3;

    UserProfile(){
    }

    public UserProfile(String name, String email, String department, String event, String round1, String round2, String round3) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.event = event;

        this.round1 = round1;
        this.round2 = round2;
        this.round3 = round3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getRound1() {
        return round1;
    }

    public void setRound1(String round1) {
        this.round1 = round1;
    }

    public String getRound2() {
        return round2;
    }

    public void setRound2(String round2) {
        this.round2 = round2;
    }

    public String getRound3() {
        return round3;
    }

    public void setRound3(String round3) {
        this.round3 = round3;
    }
}