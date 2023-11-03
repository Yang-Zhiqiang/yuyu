package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 医務査定その他特約条件付テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getImuSonotaTkykJktksByRenno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        if (syoriCtl1 == null) {
            syoriCtl1 = new HT_SyoriCTL("10000000001");
            List<HT_ImuSonotaTkykJktk> imuSonotaTkykJktkList = syoriCtl1.getImuSonotaTkykJktksByRenno(1);
            Assert.assertEquals(0, imuSonotaTkykJktkList.size());

            HT_ImuSonotaTkykJktk imuSonotaTkykJktk1 = syoriCtl1.createImuSonotaTkykJktk();
            imuSonotaTkykJktk1.setRenno(1);
            imuSonotaTkykJktk1.setPmnjtkkbn(C_PmnjtkKbn.NONE);

            HT_ImuSonotaTkykJktk imuSonotaTkykJktk2 = syoriCtl1.createImuSonotaTkykJktk();
            imuSonotaTkykJktk2.setRenno(2);
            imuSonotaTkykJktk2.setPmnjtkkbn(C_PmnjtkKbn.NONE);

            HT_ImuSonotaTkykJktk imuSonotaTkykJktk3 = syoriCtl1.createImuSonotaTkykJktk();
            imuSonotaTkykJktk3.setRenno(3);
            imuSonotaTkykJktk3.setPmnjtkkbn(C_PmnjtkKbn.NONE);

            HT_ImuSonotaTkykJktk imuSonotaTkykJktk4 = syoriCtl1.createImuSonotaTkykJktk();
            imuSonotaTkykJktk4.setRenno(3);
            imuSonotaTkykJktk4.setPmnjtkkbn(C_PmnjtkKbn.SANDAISIPPMNJTOK);

            sinkeiyakuDomManager.insert(syoriCtl1);
        }

        HT_SyoriCTL syoriCtl2 = sinkeiyakuDomManager.getSyoriCTL("10000000002");
        if (syoriCtl2 == null) {
            syoriCtl2 = new HT_SyoriCTL("10000000002");


            HT_ImuSonotaTkykJktk imuSonotaTkykJktk5 = syoriCtl2.createImuSonotaTkykJktk();
            imuSonotaTkykJktk5.setRenno(1);
            imuSonotaTkykJktk5.setPmnjtkkbn(C_PmnjtkKbn.NONE);

            sinkeiyakuDomManager.insert(syoriCtl2);
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
    public void noResult1() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        List<HT_ImuSonotaTkykJktk> imuSonotaTkykJktkList = syoriCtl.getImuSonotaTkykJktksByRenno(4);

        Assert.assertEquals(0, imuSonotaTkykJktkList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        List<HT_ImuSonotaTkykJktk> imuSonotaTkykJktkList = syoriCtl.getImuSonotaTkykJktksByRenno(1);

        Assert.assertEquals(1, imuSonotaTkykJktkList.size());

        Assert.assertEquals("10000000001", imuSonotaTkykJktkList.get(0).getMosno());
        Assert.assertEquals(1, imuSonotaTkykJktkList.get(0).getRenno().intValue());
        Assert.assertEquals(C_PmnjtkKbn.NONE, imuSonotaTkykJktkList.get(0).getPmnjtkkbn());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000001");

        List<HT_ImuSonotaTkykJktk> imuSonotaTkykJktkList = syoriCtl.getImuSonotaTkykJktksByRenno(3);

        Assert.assertEquals(2, imuSonotaTkykJktkList.size());

        Assert.assertEquals("10000000001", imuSonotaTkykJktkList.get(0).getMosno());
        Assert.assertEquals(3, imuSonotaTkykJktkList.get(0).getRenno().intValue());
        Assert.assertEquals(C_PmnjtkKbn.NONE, imuSonotaTkykJktkList.get(0).getPmnjtkkbn());

        Assert.assertEquals("10000000001", imuSonotaTkykJktkList.get(1).getMosno());
        Assert.assertEquals(3, imuSonotaTkykJktkList.get(1).getRenno().intValue());
        Assert.assertEquals(C_PmnjtkKbn.SANDAISIPPMNJTOK, imuSonotaTkykJktkList.get(1).getPmnjtkkbn());

    }
}



