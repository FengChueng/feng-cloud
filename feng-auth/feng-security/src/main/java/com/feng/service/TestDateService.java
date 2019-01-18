package com.feng.service;

import com.feng.pojo.TestDate;
import com.feng.repository.TestDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by zhangyinglong on 2019/1/18.
 */
@Service
public class TestDateService {
    @Autowired
    private TestDateRepository testDateRepository;

    @Transactional(rollbackFor = Exception.class)
    public void saveTestDate(TestDate testDate){
        TestDate save = testDateRepository.save(testDate);
        System.out.println(save.toString());
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateTestDateNochange(Integer id) throws Exception {
        Optional<TestDate> testDate = testDateRepository.findById(id);
        TestDate testDate2 = testDate.orElseThrow(Exception::new);
        System.out.println(testDate2.toString());
        TestDate testDate1 = testDateRepository.saveAndFlush(testDate2);
        System.out.println(testDate1.toString());
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateTestDate(Integer id) throws Exception {
        Optional<TestDate> testDate = testDateRepository.findById(id);
        TestDate testDate2 = testDate.orElseThrow(Exception::new);
        System.out.println(testDate2.toString());
        testDate2.setParam("update");
        TestDate testDate1 = testDateRepository.saveAndFlush(testDate2);
        System.out.println(testDate1.toString());
    }

}
