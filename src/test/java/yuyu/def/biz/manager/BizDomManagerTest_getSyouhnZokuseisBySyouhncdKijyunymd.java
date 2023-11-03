package yuyu.def.biz.manager;

import static org.junit.Assert.*;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getSyouhnZokuseisBySyouhncdKijyunymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSyouhnZokuseisBySyouhncdKijyunymd {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncdKijyunymd("1001", BizDate.valueOf(20160215));

        Assert.assertEquals(0,syouhnZokuseiLst.size());

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei("1001", 1);
        syouhnZokusei1.setKykfromymd(BizDate.valueOf(20160215));
        syouhnZokusei1.setKyktoymd(BizDate.valueOf(20160216));

        bizDomManager.insert(syouhnZokusei1);

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei("1002", 1);
        syouhnZokusei2.setKykfromymd(BizDate.valueOf(20160215));
        syouhnZokusei2.setKyktoymd(BizDate.valueOf(20160216));

        bizDomManager.insert(syouhnZokusei2);

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei("1001", 2);
        syouhnZokusei3.setKykfromymd(BizDate.valueOf(20160216));
        syouhnZokusei3.setKyktoymd(BizDate.valueOf(20160216));

        bizDomManager.insert(syouhnZokusei3);

        BM_SyouhnZokusei syouhnZokusei4 = new BM_SyouhnZokusei("1001", 3);
        syouhnZokusei4.setKykfromymd(BizDate.valueOf(20160213));
        syouhnZokusei4.setKyktoymd(BizDate.valueOf(20160214));

        bizDomManager.insert(syouhnZokusei4);

        BM_SyouhnZokusei syouhnZokusei5 = new BM_SyouhnZokusei("1003", 4);
        syouhnZokusei5.setKykfromymd(BizDate.valueOf(20160220));
        syouhnZokusei5.setKyktoymd(BizDate.valueOf(20160223));

        bizDomManager.insert(syouhnZokusei5);

        BM_SyouhnZokusei syouhnZokusei6 = new BM_SyouhnZokusei("1003", 5);
        syouhnZokusei6.setKykfromymd(BizDate.valueOf(20160222));
        syouhnZokusei6.setKyktoymd(BizDate.valueOf(20160225));

        bizDomManager.insert(syouhnZokusei6);

        BM_SyouhnZokusei syouhnZokusei7 = new BM_SyouhnZokusei("1003", 6);
        syouhnZokusei7.setKykfromymd(BizDate.valueOf(20160223));
        syouhnZokusei7.setKyktoymd(BizDate.valueOf(20160224));

        bizDomManager.insert(syouhnZokusei7);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncdKijyunymd("1001", BizDate.valueOf(20160217));

        Assert.assertEquals(0,syouhnZokuseiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncdKijyunymd("1001", BizDate.valueOf(20160215));

        assertEquals(1, syouhnZokuseiLst.size());

        assertEquals("1001", syouhnZokuseiLst.get(0).getSyouhncd());
        assertEquals(1, syouhnZokuseiLst.get(0).getSyouhnsdno().intValue());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncdKijyunymd("1003", BizDate.valueOf(20160223));

        assertEquals(3, syouhnZokuseiLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("1003",4), "1");
        map.put($("1003",5), "1");
        map.put($("1003",6), "1");

        for(BM_SyouhnZokusei syouhnZokusei : syouhnZokuseiLst){
            map.remove($(syouhnZokusei.getSyouhncd(),syouhnZokusei.getSyouhnsdno().intValue()));
        }
        assertTrue(map.isEmpty());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncdKijyunymd("", BizDate.valueOf(20160215));

        Assert.assertEquals(0,syouhnZokuseiLst.size());
    }
}

