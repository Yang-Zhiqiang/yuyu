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

import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkDenpyoDatasBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkDenpyoDatasBySyono {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasBySyono("10000000001");

        Assert.assertEquals(0,skDenpyoDataLst.size());

        HT_SkDenpyoData skDenpyoData = new HT_SkDenpyoData();
        skDenpyoData.setDenrenno("10000000060");
        skDenpyoData.setEdano(11);
        skDenpyoData.setSyono("10000000001");
        sinkeiyakuDomManager.insert(skDenpyoData);

        HT_SkDenpyoData skDenpyoData2 = new HT_SkDenpyoData();
        skDenpyoData2.setDenrenno("10000000060");
        skDenpyoData2.setEdano(12);
        skDenpyoData2.setSyono("10000000002");
        sinkeiyakuDomManager.insert(skDenpyoData2);

        HT_SkDenpyoData skDenpyoData3 = new HT_SkDenpyoData();
        skDenpyoData3.setDenrenno("10000000061");
        skDenpyoData3.setEdano(13);
        skDenpyoData3.setSyono("10000000003");
        sinkeiyakuDomManager.insert(skDenpyoData3);

        HT_SkDenpyoData skDenpyoData4 = new HT_SkDenpyoData();
        skDenpyoData4.setDenrenno("10000000062");
        skDenpyoData4.setEdano(14);
        skDenpyoData4.setSyono("10000000003");
        sinkeiyakuDomManager.insert(skDenpyoData4);

        HT_SkDenpyoData skDenpyoData5 = new HT_SkDenpyoData();
        skDenpyoData5.setDenrenno("10000000063");
        skDenpyoData5.setEdano(15);
        skDenpyoData5.setSyono("10000000003");
        sinkeiyakuDomManager.insert(skDenpyoData5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkDenpyoData());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasBySyono("10000000004");

        assertEquals(0, skDenpyoDataLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasBySyono("10000000001");

        assertEquals(1, skDenpyoDataLst.size());
        assertEquals("10000000060", skDenpyoDataLst.get(0).getDenrenno());
        assertEquals("11",skDenpyoDataLst.get(0).getEdano().toString());
    }

    @Test
    @TestOrder(30)
    public void normal2(){


        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("10000000061","13"), "1");
        datamap.put($("10000000062","14"), "1");
        datamap.put($("10000000063","15"), "1");

        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasBySyono("10000000003");

        for(HT_SkDenpyoData skDenpyoData:skDenpyoDataLst){

            datamap.remove($(
                skDenpyoData.getDenrenno(),
                skDenpyoData.getEdano().toString()
                ));
        }

        assertEquals(3, skDenpyoDataLst.size());
        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasBySyono("");

        assertEquals(0, skDenpyoDataLst.size());

    }
}

