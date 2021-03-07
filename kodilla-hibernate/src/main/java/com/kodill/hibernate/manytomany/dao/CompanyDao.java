package com.kodill.hibernate.manytomany.dao;


import com.kodill.hibernate.manytomany.Company;
import com.kodill.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.*;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query(nativeQuery = true)
    List<Company> findCompanyByBeginningOfName(@Param("LETTERS") String letters);
}