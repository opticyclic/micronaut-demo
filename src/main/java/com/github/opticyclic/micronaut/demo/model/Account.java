package com.github.opticyclic.micronaut.demo.model;

import io.micronaut.core.annotation.Introspected;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Introspected
public class Account {

    public enum AccountType {
        CURRENT, SAVINGS, PENSION;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private AccountType type;

    @NotEmpty(message = "The account must have a name")
    @Size(min = 1, max = 20)
    private String name;

    @Min(18)
    private int age;


    public Account() {
        //Default constructor for Hibernate
    }

    public Account(AccountType type, String name, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return age == account.age && Objects.equals(id, account.id) && type == account.type && Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, age);
    }
}