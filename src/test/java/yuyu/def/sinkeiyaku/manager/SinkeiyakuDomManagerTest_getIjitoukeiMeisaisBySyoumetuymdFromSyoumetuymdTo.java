package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getIjitoukeiMeisaisBySyoumetuymdFromSyoumetuymdTo() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getIjitoukeiMeisaisBySyoumetuymdFromSyoumetuymdTo {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        try (ExDBResults<HT_IjitoukeiMeisai> beans =
            sinkeiyakuDomManager.getIjitoukeiMeisaisBySyoumetuymdFromSyoumetuymdTo(BizDate.valueOf(20160311), BizDate.valueOf(20160312))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        HT_IjitoukeiMeisai ijitoukeiMeisai1 = new HT_IjitoukeiMeisai("11807111118", 10003500);
        ijitoukeiMeisai1.setSyoumetuymd(BizDate.valueOf(20160311));
        ijitoukeiMeisai1.setSymtgenincd("400");
        ijitoukeiMeisai1.setSiincd("");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai1);

        HT_IjitoukeiMeisai ijitoukeiMeisai2 = new HT_IjitoukeiMeisai("11807111370", 10003500);
        ijitoukeiMeisai2.setSyoumetuymd(BizDate.valueOf(20160311));
        ijitoukeiMeisai2.setSymtgenincd("400");
        ijitoukeiMeisai2.setSiincd("100");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai2);

        HT_IjitoukeiMeisai ijitoukeiMeisai3 = new HT_IjitoukeiMeisai("11807111381", 10003500);
        ijitoukeiMeisai3.setSyoumetuymd(BizDate.valueOf(20160311));
        ijitoukeiMeisai3.setSymtgenincd("300");
        ijitoukeiMeisai3.setSiincd("");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai3);

        HT_IjitoukeiMeisai ijitoukeiMeisai4 = new HT_IjitoukeiMeisai("11807111392", 10003500);
        ijitoukeiMeisai4.setSyoumetuymd(BizDate.valueOf(20160310));
        ijitoukeiMeisai4.setSymtgenincd("400");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai4);

        HT_IjitoukeiMeisai ijitoukeiMeisai5 = new HT_IjitoukeiMeisai("11807111406", 10003500);
        ijitoukeiMeisai5.setSyoumetuymd(BizDate.valueOf(20160312));
        ijitoukeiMeisai5.setSymtgenincd("400");
        ijitoukeiMeisai5.setSiincd("");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai5);

        HT_IjitoukeiMeisai ijitoukeiMeisai6 = new HT_IjitoukeiMeisai("11807111369", 10003500);
        ijitoukeiMeisai6.setSyoumetuymd(BizDate.valueOf(20160313));
        ijitoukeiMeisai6.setSymtgenincd("400");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai6);

        HT_IjitoukeiMeisai ijitoukeiMeisai7 = new HT_IjitoukeiMeisai("11807111129", 10003000);
        ijitoukeiMeisai7.setSyoumetuymd(BizDate.valueOf(20150311));
        ijitoukeiMeisai7.setIdousyoriymd(BizDate.valueOf(20150320));
        ijitoukeiMeisai7.setSymtgenincd("400");
        ijitoukeiMeisai7.setSiincd("");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai7);

        HT_IjitoukeiMeisai ijitoukeiMeisai8 = new HT_IjitoukeiMeisai("11807111129", 10003100);
        ijitoukeiMeisai8.setSyoumetuymd(BizDate.valueOf(20150311));
        ijitoukeiMeisai8.setIdousyoriymd(BizDate.valueOf(20150320));
        ijitoukeiMeisai8.setSymtgenincd("500");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai8);

        HT_IjitoukeiMeisai ijitoukeiMeisai9 = new HT_IjitoukeiMeisai("11807111129", 10003200);
        ijitoukeiMeisai9.setSyoumetuymd(BizDate.valueOf(20150311));
        ijitoukeiMeisai9.setIdousyoriymd(BizDate.valueOf(20150320));
        ijitoukeiMeisai9.setSymtgenincd("900");
        ijitoukeiMeisai9.setSiincd("");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai9);

        HT_IjitoukeiMeisai ijitoukeiMeisai10 = new HT_IjitoukeiMeisai("11807111130", 10003000);
        ijitoukeiMeisai10.setSyoumetuymd(BizDate.valueOf(20150311));
        ijitoukeiMeisai10.setIdousyoriymd(BizDate.valueOf(20150319));
        ijitoukeiMeisai10.setSymtgenincd("400");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai10);

        HT_IjitoukeiMeisai ijitoukeiMeisai11 = new HT_IjitoukeiMeisai("11807111130", 10003200);
        ijitoukeiMeisai11.setSyoumetuymd(BizDate.valueOf(20150311));
        ijitoukeiMeisai11.setIdousyoriymd(BizDate.valueOf(20150319));
        ijitoukeiMeisai11.setSymtgenincd("500");
        ijitoukeiMeisai11.setSiincd("");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai11);

        HT_IjitoukeiMeisai ijitoukeiMeisai12 = new HT_IjitoukeiMeisai("11807111130", 10003100);
        ijitoukeiMeisai12.setSyoumetuymd(BizDate.valueOf(20150311));
        ijitoukeiMeisai12.setIdousyoriymd(BizDate.valueOf(20150319));
        ijitoukeiMeisai12.setSymtgenincd("900");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai12);

        HT_IjitoukeiMeisai ijitoukeiMeisai13 = new HT_IjitoukeiMeisai("11807111141", 10003200);
        ijitoukeiMeisai13.setSyoumetuymd(BizDate.valueOf(20150311));
        ijitoukeiMeisai13.setIdousyoriymd(BizDate.valueOf(20150318));
        ijitoukeiMeisai13.setSymtgenincd("400");
        ijitoukeiMeisai13.setSiincd("");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai13);

        HT_IjitoukeiMeisai ijitoukeiMeisai14 = new HT_IjitoukeiMeisai("11807111141", 10003000);
        ijitoukeiMeisai14.setSyoumetuymd(BizDate.valueOf(20150311));
        ijitoukeiMeisai14.setIdousyoriymd(BizDate.valueOf(20150318));
        ijitoukeiMeisai14.setSymtgenincd("500");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai14);

        HT_IjitoukeiMeisai ijitoukeiMeisai15 = new HT_IjitoukeiMeisai("11807111141", 10003100);
        ijitoukeiMeisai15.setSyoumetuymd(BizDate.valueOf(20150311));
        ijitoukeiMeisai15.setIdousyoriymd(BizDate.valueOf(20150318));
        ijitoukeiMeisai15.setSymtgenincd("900");
        ijitoukeiMeisai15.setSiincd("");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai15);

        HT_IjitoukeiMeisai ijitoukeiMeisai16 = new HT_IjitoukeiMeisai("11807111152", 10003200);
        ijitoukeiMeisai16.setSyoumetuymd(BizDate.valueOf(20150310));
        ijitoukeiMeisai16.setIdousyoriymd(BizDate.valueOf(20150318));
        ijitoukeiMeisai16.setSymtgenincd("400");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai16);

        HT_IjitoukeiMeisai ijitoukeiMeisai17 = new HT_IjitoukeiMeisai("11807111152", 10003000);
        ijitoukeiMeisai17.setSyoumetuymd(BizDate.valueOf(20150310));
        ijitoukeiMeisai17.setIdousyoriymd(BizDate.valueOf(20150318));
        ijitoukeiMeisai17.setSymtgenincd("500");
        ijitoukeiMeisai17.setSiincd("");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai17);

        HT_IjitoukeiMeisai ijitoukeiMeisai18 = new HT_IjitoukeiMeisai("11807111152", 10003100);
        ijitoukeiMeisai18.setSyoumetuymd(BizDate.valueOf(20150310));
        ijitoukeiMeisai18.setIdousyoriymd(BizDate.valueOf(20150318));
        ijitoukeiMeisai18.setSymtgenincd("900");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai18);

        HT_IjitoukeiMeisai ijitoukeiMeisai19 = new HT_IjitoukeiMeisai("11807111163", 10003200);
        ijitoukeiMeisai19.setSyoumetuymd(BizDate.valueOf(20150309));
        ijitoukeiMeisai19.setIdousyoriymd(BizDate.valueOf(20150318));
        ijitoukeiMeisai19.setSymtgenincd("400");
        ijitoukeiMeisai19.setSiincd("");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai19);

        HT_IjitoukeiMeisai ijitoukeiMeisai20 = new HT_IjitoukeiMeisai("11807111163", 10003000);
        ijitoukeiMeisai20.setSyoumetuymd(BizDate.valueOf(20150309));
        ijitoukeiMeisai20.setIdousyoriymd(BizDate.valueOf(20150318));
        ijitoukeiMeisai20.setSymtgenincd("500");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai20);

        HT_IjitoukeiMeisai ijitoukeiMeisai21 = new HT_IjitoukeiMeisai("11807111163", 10003100);
        ijitoukeiMeisai21.setSyoumetuymd(BizDate.valueOf(20150309));
        ijitoukeiMeisai21.setIdousyoriymd(BizDate.valueOf(20150318));
        ijitoukeiMeisai21.setSymtgenincd("900");
        ijitoukeiMeisai21.setSiincd("");

        sinkeiyakuDomManager.insert(ijitoukeiMeisai21);


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllIjitoukeiMeisai());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        try (ExDBResults<HT_IjitoukeiMeisai> beans =
            sinkeiyakuDomManager.getIjitoukeiMeisaisBySyoumetuymdFromSyoumetuymdTo(BizDate.valueOf(20170311), BizDate.valueOf(20170312))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        try (ExDBResults<HT_IjitoukeiMeisai> beans =
            sinkeiyakuDomManager.getIjitoukeiMeisaisBySyoumetuymdFromSyoumetuymdTo(BizDate.valueOf(20160311), BizDate.valueOf(20160312))) {

            int iCount = 0;
            Iterator<HT_IjitoukeiMeisai> iter = beans.iterator();
            HT_IjitoukeiMeisai hT_IjitoukeiMeisai = null;
            while (iter.hasNext()) {

                hT_IjitoukeiMeisai = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("11807111118", hT_IjitoukeiMeisai.getSyono());
                    Assert.assertEquals(10003500, hT_IjitoukeiMeisai.getRenno8keta().intValue());

                    continue;
                }
            }
            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2(){


        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("11807111163",10003200), "1");
        datamap.put($("11807111152",10003200), "1");
        datamap.put($("11807111141",10003200), "1");
        datamap.put($("11807111130",10003200), "1");
        datamap.put($("11807111129",10003200), "1");

        try (ExDBResults<HT_IjitoukeiMeisai> beans =
            sinkeiyakuDomManager.getIjitoukeiMeisaisBySyoumetuymdFromSyoumetuymdTo(BizDate.valueOf(20150309), BizDate.valueOf(20150312))) {

            Iterator<HT_IjitoukeiMeisai> iter = beans.iterator();
            HT_IjitoukeiMeisai hT_IjitoukeiMeisai = null;
            while (iter.hasNext()) {

                hT_IjitoukeiMeisai = iter.next();

                datamap.remove($(
                    hT_IjitoukeiMeisai.getSyono(),
                    hT_IjitoukeiMeisai.getRenno8keta().intValue()));

            }
            Assert.assertTrue(datamap.isEmpty());
        }
    }
}

