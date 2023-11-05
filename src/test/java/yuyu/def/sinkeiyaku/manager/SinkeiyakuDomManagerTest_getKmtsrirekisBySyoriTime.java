package yuyu.def.sinkeiyaku.manager;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getKmtsrirekisBySyoriTime() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getKmtsrirekisBySyoriTime {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBResults<HT_KmTsRireki> kmTsRireki =
                sinkeiyakuDomManager.getKmtsrirekisBySyoriTime("20130505", "20130505")){

            Assert.assertFalse(kmTsRireki.iterator().hasNext());
        }

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("11807111130");

        HT_KmTsRireki kmTsRireki1 = syoriCTL1.createKmTsRireki();
        kmTsRireki1.setSyoriTime("20150808");
        kmTsRireki1.setRenno3keta(111);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("11807111129");

        HT_KmTsRireki kmTsRireki2 = syoriCTL2.createKmTsRireki();
        kmTsRireki2.setSyoriTime("20150911");
        kmTsRireki2.setRenno3keta(131);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("11807111118");

        HT_KmTsRireki kmTsRireki3 = syoriCTL3.createKmTsRireki();
        kmTsRireki3.setSyoriTime("20160311");
        kmTsRireki3.setRenno3keta(141);

        HT_KmTsRireki kmTsRireki4 = syoriCTL3.createKmTsRireki();
        kmTsRireki4.setSyoriTime("20160201");
        kmTsRireki4.setRenno3keta(201);

        HT_KmTsRireki kmTsRireki5 = syoriCTL3.createKmTsRireki();
        kmTsRireki5.setSyoriTime("20150505");
        kmTsRireki5.setRenno3keta(321);

        HT_KmTsRireki kmTsRireki6 = syoriCTL3.createKmTsRireki();
        kmTsRireki6.setSyoriTime("20150505");
        kmTsRireki6.setRenno3keta(211);

        HT_KmTsRireki kmTsRireki7 = syoriCTL3.createKmTsRireki();
        kmTsRireki7.setSyoriTime("20150505");
        kmTsRireki7.setRenno3keta(101);

        HT_KmTsRireki kmTsRireki8 = syoriCTL3.createKmTsRireki();
        kmTsRireki8.setSyoriTime("20140505");
        kmTsRireki8.setRenno3keta(101);

        HT_KmTsRireki kmTsRireki9 = syoriCTL3.createKmTsRireki();
        kmTsRireki9.setSyoriTime("20170505");
        kmTsRireki9.setRenno3keta(101);

        HT_KmTsRireki kmTsRireki10 = syoriCTL3.createKmTsRireki();
        kmTsRireki10.setSyoriTime("20130505");
        kmTsRireki10.setRenno3keta(101);

        sinkeiyakuDomManager.insert(syoriCTL3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<HT_KmTsRireki> kmTsRireki =
                sinkeiyakuDomManager.getKmtsrirekisBySyoriTime("20160401", "20160404")) {

            Assert.assertFalse(kmTsRireki.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<HT_KmTsRireki> kmTsRireki =
                sinkeiyakuDomManager.getKmtsrirekisBySyoriTime("20130505", "20130505")) {

            int iCount = 0;
            Iterator<HT_KmTsRireki> iter = kmTsRireki.iterator();
            HT_KmTsRireki kmTsRireki1 = null;
            while (iter.hasNext()) {

                kmTsRireki1 = iter.next();
                iCount++;

                Assert.assertEquals("11807111118", kmTsRireki1.getMosno());
                Assert.assertEquals("20130505", kmTsRireki1.getSyoriTime());
                Assert.assertEquals(101, kmTsRireki1.getRenno3keta().intValue());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<HT_KmTsRireki> kmTsRireki =
                sinkeiyakuDomManager.getKmtsrirekisBySyoriTime("20150505", "20160311")) {

            int iCount = 0;
            Iterator<HT_KmTsRireki> iter = kmTsRireki.iterator();
            HT_KmTsRireki kmTsRireki1 = null;
            while (iter.hasNext()) {

                kmTsRireki1 = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals("11807111118", kmTsRireki1.getMosno());
                    Assert.assertEquals("20150505", kmTsRireki1.getSyoriTime());
                    Assert.assertEquals(101, kmTsRireki1.getRenno3keta().intValue());
                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("11807111118", kmTsRireki1.getMosno());
                    Assert.assertEquals("20150505", kmTsRireki1.getSyoriTime());
                    Assert.assertEquals(211, kmTsRireki1.getRenno3keta().intValue());
                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("11807111118", kmTsRireki1.getMosno());
                    Assert.assertEquals("20150505", kmTsRireki1.getSyoriTime());
                    Assert.assertEquals(321, kmTsRireki1.getRenno3keta().intValue());
                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals("11807111118", kmTsRireki1.getMosno());
                    Assert.assertEquals("20160201", kmTsRireki1.getSyoriTime());
                    Assert.assertEquals(201, kmTsRireki1.getRenno3keta().intValue());
                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals("11807111118", kmTsRireki1.getMosno());
                    Assert.assertEquals("20160311", kmTsRireki1.getSyoriTime());
                    Assert.assertEquals(141, kmTsRireki1.getRenno3keta().intValue());
                    continue;
                }

                if (6 == iCount) {

                    Assert.assertEquals("11807111129", kmTsRireki1.getMosno());
                    Assert.assertEquals("20150911", kmTsRireki1.getSyoriTime());
                    Assert.assertEquals(131, kmTsRireki1.getRenno3keta().intValue());
                    continue;
                }

                if (7 == iCount) {

                    Assert.assertEquals("11807111130", kmTsRireki1.getMosno());
                    Assert.assertEquals("20150808", kmTsRireki1.getSyoriTime());
                    Assert.assertEquals(111, kmTsRireki1.getRenno3keta().intValue());
                    continue;
                }

            }
            Assert.assertEquals(7, iCount);
        }
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        try (ExDBResults<HT_KmTsRireki> kmTsRireki =
                sinkeiyakuDomManager.getKmtsrirekisBySyoriTime("", "20110404")) {

            int iCount = 0;
            for (HT_KmTsRireki hT_KmTsRireki : kmTsRireki) {
                if(hT_KmTsRireki != null){
                    iCount++;
                }
            }
            Assert.assertEquals(0, iCount);
        }

    }

    @Test
    @TestOrder(50)
    public void blank2() {

        try (ExDBResults<HT_KmTsRireki> kmTsRireki =
                sinkeiyakuDomManager.getKmtsrirekisBySyoriTime("20180401", "")) {

            int iCount = 0;
            for (HT_KmTsRireki hT_KmTsRireki : kmTsRireki) {
                if(hT_KmTsRireki != null){
                    iCount++;
                }
            }
            Assert.assertEquals(0, iCount);
        }

    }
}

