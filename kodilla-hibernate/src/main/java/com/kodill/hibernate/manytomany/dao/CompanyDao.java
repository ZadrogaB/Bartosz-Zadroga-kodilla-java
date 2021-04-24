package com.kodill.hibernate.manytomany.dao;

import com.kodill.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Native;
import java.util.*;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query(nativeQuery = true)
    List<Company> findCompanyByBeginningOfName(@Param("LETTERS") String letters);

    List<Company> findByNameContaining(String letters);
}