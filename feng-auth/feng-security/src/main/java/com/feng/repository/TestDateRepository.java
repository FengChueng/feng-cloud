package com.feng.repository;

import com.feng.pojo.TestDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
@Repository
public interface TestDateRepository extends JpaRepository<TestDate, Integer> {
}