package com.example.cornell_club_board.user;

import jakarta.persistence.*;

@Entity
@Table(name = "login_user")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Long id;
    private String email;
    private String password;
    private String name;
    private String gradYear;
    private String college;
    private String majors;
    private String minors;
    private String phoneNumber;
    private String resumeLink;
    private String portfolio;
    private String linkedIn;
    private String github;
    private String biography;
    private String pfp;


    public User() {}

    public User(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        name = "";
        gradYear = "";
        college = "";
        majors = "";
        minors = "";
        phoneNumber = "";
        resumeLink = "";
        portfolio = "";
        linkedIn = "";
        github = "";
        biography = "";
        pfp = "";
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        name = "";
        gradYear = "";
        college = "";
        majors = "";
        minors = "";
        phoneNumber = "";
        resumeLink = "";
        portfolio = "";
        linkedIn = "";
        github = "";
        biography = "";
        pfp = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGradYear() {
        return gradYear;
    }

    public void setGradYear(String gradYear) {
        this.gradYear = gradYear;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getMinors() {
        return minors;
    }

    public void setMinors(String minors) {
        this.minors = minors;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getResumeLink() {
        return resumeLink;
    }

    public void setResumeLink(String resumeLink) {
        this.resumeLink = resumeLink;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPfp() {
        return pfp;
    }

    public void setPfp(String pfp) {
        this.pfp = pfp;
    }
}
