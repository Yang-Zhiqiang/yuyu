package yuyu.def.biz.manager;


import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_Syonokanri;
import yuyu.testinfr.TestOrder;

/**
 * 証券番号管理マスタのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getSyonokanriMaxBosyuusosikicdBySeirekinen2ketaSaibanymd {

    @Inject
    private BizDomManager bizDomManager;

    private final static String seirekinen2keta = "1";
    private final static String seirekinen2keta2 = "2";
    private final static String seirekinen2keta3 = "3";
    private final static String blank = "";
    private final static BizDate saibanymd = BizDate.valueOf(20160104);
    private final static BizDate saibanymd1 = BizDate.valueOf(20160103);
    private final static BizDate saibanymd2 = BizDate.valueOf(20160105);
    private final static String bosyuusosikicd = "101";
    private final static String bosyuusosikicd1 = "101";
    private final static String bosyuusosikicd2 = "102";
    private final static String bosyuusosikicd3 = "103";
    private final static String bosyuusosikicd4 = "104";
    private final static String bosyuusosikicd5 = "105";
    private final static String bosyuusosikicd6 = "106";
    private final static String bosyuusosikicd7 = "107";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        String str = bizDomManager.getSyonokanriMaxBosyuusosikicdBySeirekinen2ketaSaibanymd(seirekinen2keta,
                saibanymd);

        Assert.assertEquals(null, str);

        BM_Syonokanri syonokanri = new BM_Syonokanri(seirekinen2keta, bosyuusosikicd, 1);
        syonokanri.setSaibanymd(saibanymd);
        bizDomManager.insert(syonokanri);

        BM_Syonokanri syonokanri1 = new BM_Syonokanri(seirekinen2keta3, bosyuusosikicd1, 1);
        syonokanri1.setSaibanymd(saibanymd);
        bizDomManager.insert(syonokanri1);

        BM_Syonokanri syonokanri2 = new BM_Syonokanri(seirekinen2keta3, bosyuusosikicd2, 2);
        syonokanri2.setSaibanymd(saibanymd);
        bizDomManager.insert(syonokanri2);

        BM_Syonokanri syonokanri3 = new BM_Syonokanri(seirekinen2keta3, bosyuusosikicd3, 3);
        syonokanri3.setSaibanymd(saibanymd);
        bizDomManager.insert(syonokanri3);

        BM_Syonokanri syonokanri4 = new BM_Syonokanri(seirekinen2keta3, bosyuusosikicd4, 4);
        syonokanri4.setSaibanymd(saibanymd);
        bizDomManager.insert(syonokanri4);

        BM_Syonokanri syonokanri5 = new BM_Syonokanri(seirekinen2keta3, bosyuusosikicd5, 5);
        syonokanri5.setSaibanymd(saibanymd);
        bizDomManager.insert(syonokanri5);

        BM_Syonokanri syonokanri6 = new BM_Syonokanri(seirekinen2keta3, bosyuusosikicd6, 6);
        syonokanri6.setSaibanymd(saibanymd1);
        bizDomManager.insert(syonokanri6);

        BM_Syonokanri syonokanri7 = new BM_Syonokanri(seirekinen2keta3, bosyuusosikicd7, 7);
        syonokanri7.setSaibanymd(saibanymd2);
        bizDomManager.insert(syonokanri7);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyonokanri());
    }


    @Test
    @TestOrder(30)
    public void noResult1() {

        String str = bizDomManager.getSyonokanriMaxBosyuusosikicdBySeirekinen2ketaSaibanymd(seirekinen2keta2,
                saibanymd);

        Assert.assertEquals(null, str);
    }

    @Test
    @TestOrder(40)
    public void normal1() {

        String str = bizDomManager.getSyonokanriMaxBosyuusosikicdBySeirekinen2ketaSaibanymd(seirekinen2keta,
                saibanymd);

        Assert.assertEquals("101", str);
    }

    @Test
    @TestOrder(50)
    public void normal2() {

        String str = bizDomManager.getSyonokanriMaxBosyuusosikicdBySeirekinen2ketaSaibanymd(seirekinen2keta3,
                saibanymd);

        Assert.assertEquals("105", str);
    }

    @Test
    @TestOrder(60)
    public void blankCondition1() {

        String str = bizDomManager.getSyonokanriMaxBosyuusosikicdBySeirekinen2ketaSaibanymd(blank, saibanymd);

        Assert.assertEquals(null, str);
    }
}