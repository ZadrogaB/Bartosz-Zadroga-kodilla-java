package com.kodill.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@NamedNativeQuery(
        name = "Company.findCompanyByBeginningOfName",
        query = "SELECT * FROM COMPANIES " +
                "WHERE LEFT(COMPANY_NAME, 3) = :LETTERS",
        resultClass = Company.class
)
@Entity
@Table(name = "COMPANIES")
public class Company {

    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}