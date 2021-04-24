package com.kodill.hibernate.facade;

import com.kodill.hibernate.manytomany.Company;
import com.kodill.hibernate.manytomany.Employee;
import com.kodill.hibernate.manytomany.dao.CompanyDao;
import com.kodill.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Service
public class SearchService {
    private CompanyDao companyDao;
    private EmployeeDao employeeDao;

    @Autowired
    public SearchService(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchService.class);

    public List<Employee> findEmployeeByNameContaining (String letters) {
        List<Employee> resultSurname = employeeDao.findByFirstnameContaining(letters);
        List<Employee> resultLastname = employeeDao.findByLastnameContaining(letters);
        Set<Employee> resultSet = new HashSet<>();
        resultSet.addAll(resultLastname);
        resultSet.addAll(resultSurname);
        List<Employee> resultWithoutDuplicates = new ArrayList<>();
        resultWithoutDuplicates.addAll(resultSet);
        if(resultWithoutDuplicates.size()==0){
            LOGGER.info(SearchingException.ERR_NO_SUCH_EMPLOYEE);
        }
        return resultWithoutDuplicates;
    }

    public List<Company> findCompanyByNameContaining(String letters) {
        List<Company> result = companyDao.findByNameContaining(letters);
        if(result.size()==0){
            LOGGER.info(SearchingException.ERR_NO_SUCH_COMPANY);
        }
        return result;
    }



}
