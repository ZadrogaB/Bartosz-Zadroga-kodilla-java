package com.kodill.hibernate.facade;

import com.kodill.hibernate.manytomany.Company;
import com.kodill.hibernate.manytomany.Employee;
import com.kodill.hibernate.manytomany.dao.CompanyDao;
import com.kodill.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SearchServiceTestSuite {

    @Autowired
    private SearchService search;


    @Test
    void shouldReturnEmployeeNamedJohnSmith() {
        List<Employee> result = search.findEmployeeByNameContaining("hn");
        assertEquals("John", result.get(0).getFirstname());
    }

    @Test
    void shouldLogEmployeeMistake() {
        List<Employee> result = search.findEmployeeByNameContaining("mistake");
        assertEquals(0,result.size());
    }

    @Test
    void shouldReturnCompanyNamedSoftwareMachine() {
        List<Company> result = search.findCompanyByNameContaining("chi");
        assertEquals("Software Machine", result.get(0).getName());
    }

    @Test
    void shouldLogCompanyMistake() {
        List<Company> result = search.findCompanyByNameContaining("mistake");
        assertEquals(0,result.size());
    }

}