package yuyu.def.biz.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

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
public class BizDomManagerTest_getSyonokanriMaxBosyuusosikicdBySeirekinen2keta {

    @Inject
    private BizDomManager bizDomManager;

    private final static String seirekinen2keta = "11";
    private final static String seirekinen2keta2 = "12";
    private final static String seirekinen2keta3 = "13";
    private final static String blank = "";
    private final static String bosyuusosikicd = "807";
    private final static String bosyuusosikicd1 = "807";
    private final static String bosyuusosikicd2 = "808";
    private final static String bosyuusosikicd3 = "809";
    private final static String bosyuusosikicd4 = "810";
    private final static String bosyuusosikicd5 = "811";

    @BeforeClass
    @Transactional
    public static void insertTestData() {


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        String str = bizDomManager.getSyonokanriMaxBosyuusosikicdBySeirekinen2keta(seirekinen2keta);

        Assert.assertEquals(null, str);

        BM_Syonokanri syonokanri = new BM_Syonokanri(seirekinen2keta, bosyuusosikicd, 1);
        bizDomManager.insert(syonokanri);

        BM_Syonokanri syonokanri1 = new BM_Syonokanri(seirekinen2keta3, bosyuusosikicd1, 1);
        bizDomManager.insert(syonokanri1);

        BM_Syonokanri syonokanri2 = new BM_Syonokanri(seirekinen2keta3, bosyuusosikicd2, 2);
        bizDomManager.insert(syonokanri2);

        BM_Syonokanri syonokanri3 = new BM_Syonokanri(seirekinen2keta3, bosyuusosikicd3, 3);
        bizDomManager.insert(syonokanri3);

        BM_Syonokanri syonokanri4 = new BM_Syonokanri(seirekinen2keta3, bosyuusosikicd4, 4);
        bizDomManager.insert(syonokanri4);

        BM_Syonokanri syonokanri5 = new BM_Syonokanri(seirekinen2keta3, bosyuusosikicd5, 5);
        bizDomManager.insert(syonokanri5);
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

        String str = bizDomManager.getSyonokanriMaxBosyuusosikicdBySeirekinen2keta(seirekinen2keta2);

        Assert.assertEquals(null, str);
    }

    @Test
    @TestOrder(40)
    public void normal1() {

        String str = bizDomManager.getSyonokanriMaxBosyuusosikicdBySeirekinen2keta(seirekinen2keta);

        Assert.assertEquals("807", str);
    }

    @Test
    @TestOrder(50)
    public void normal2() {

        String str = bizDomManager.getSyonokanriMaxBosyuusosikicdBySeirekinen2keta(seirekinen2keta3);

        Assert.assertEquals("811", str);
    }

    @Test
    @TestOrder(60)
    public void blankCondition1() {

        String str = bizDomManager.getSyonokanriMaxBosyuusosikicdBySeirekinen2keta(blank);

        Assert.assertEquals(null, str);
    }
}
