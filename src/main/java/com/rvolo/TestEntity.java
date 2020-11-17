package com.rvolo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String testField1;

    private String testField2;

    public Long getId() {
        return id;
    }

    public TestEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTestField1() {
        return testField1;
    }

    public TestEntity setTestField1(String testField1) {
        this.testField1 = testField1;
        return this;
    }

    public String getTestField2() {
        return testField2;
    }

    public TestEntity setTestField2(String testField2) {
        this.testField2 = testField2;
        return this;
    }
}
