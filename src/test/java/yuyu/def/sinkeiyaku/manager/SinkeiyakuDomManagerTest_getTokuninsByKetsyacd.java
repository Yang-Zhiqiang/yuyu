package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getTokuninsByKetsyacd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getTokuninsByKetsyacd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        List<HT_Tokunin> tokuninLst = sinkeiyakuDomManager.getTokuninsByKetsyacd("20160101");

        Assert.assertEquals(0,tokuninLst.size());

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("10000000060");
        if( null == syoriCTL1 ) {
            syoriCTL1 = new HT_SyoriCTL("10000000060");
            HT_Tokunin tokunin1 = syoriCTL1.createTokunin();
            tokunin1.setKetsyacd("20160101");

            sinkeiyakuDomManager.insert(syoriCTL1);

            HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("10000000061");
            HT_Tokunin tokunin2 = syoriCTL2.createTokunin();
            tokunin2.setKetsyacd("20160102");

            sinkeiyakuDomManager.insert(syoriCTL2);

            HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("10000000062");
            HT_Tokunin tokunin3 = syoriCTL3.createTokunin();
            tokunin3.setKetsyacd("20160103");

            sinkeiyakuDomManager.insert(syoriCTL3);

            HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("10000000063");
            HT_Tokunin tokunin4 = syoriCTL4.createTokunin();
            tokunin4.setKetsyacd("20160103");

            sinkeiyakuDomManager.insert(syoriCTL4);

            HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("10000000064");
            HT_Tokunin tokunin5 = syoriCTL5.createTokunin();
            tokunin5.setKetsyacd("20160103");

            sinkeiyakuDomManager.insert(syoriCTL5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HT_Tokunin> tokuninLst = sinkeiyakuDomManager.getTokuninsByKetsyacd("20160104");

        assertEquals(0, tokuninLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_Tokunin> tokuninLst = sinkeiyakuDomManager.getTokuninsByKetsyacd("20160101");

        assertEquals(1, tokuninLst.size());
        assertEquals("10000000060", tokuninLst.get(0).getMosno());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("10000000062"), "1");
        datamap.put($("10000000063"), "1");
        datamap.put($("10000000064"), "1");

        List<HT_Tokunin> tokuninLst = sinkeiyakuDomManager.getTokuninsByKetsyacd("20160103");

        for(HT_Tokunin tokunin : tokuninLst){
            datamap.remove($(
                tokunin.getMosno()));
        }

        assertEquals(3, tokuninLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<HT_Tokunin> tokuninLst = sinkeiyakuDomManager.getTokuninsByKetsyacd("");

        assertEquals(0, tokuninLst.size());

    }
}

