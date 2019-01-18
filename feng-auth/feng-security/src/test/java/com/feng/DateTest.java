package com.feng;

import com.feng.pojo.TestDate;
import com.feng.service.TestDateService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhangyinglong on 2019/1/18.
 */
public class DateTest extends FengSecurityApplicationTests{


//    @Autowired
//    private TestDateRepository testDateRepository;

    @Autowired
    private TestDateService testDateService;

    @Test
    public void testSaveDate(){
        TestDate testDate = new TestDate();
        testDate.setParam("create");
//        testDateRepository.save(testDate);
        testDateService.saveTestDate(testDate);
    }

    @Test
    public void testUpdateDateNochange() throws Exception {
        testDateService.updateTestDateNochange(1);
    }

    @Test
    public void testUpdateDate() throws Exception {
        testDateService.updateTestDate(1);
    }

}
