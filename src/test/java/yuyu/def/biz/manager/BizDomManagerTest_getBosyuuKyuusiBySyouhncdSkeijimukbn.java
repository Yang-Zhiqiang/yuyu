package yuyu.def.biz.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_BoskyuusiRiyuuKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.BM_BosyuuKyuusi;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getBosyuuKyuusiBySyouhncdSkeijimukbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getBosyuuKyuusiBySyouhncdSkeijimukbn {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getBosyuuKyuusiBySyouhncdSkeijimukbn";

    private final static String sheetName = "INデータ";

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_BosyuuKyuusi> BosyuuKyuusiLst = bizDomManager.getBosyuuKyuusiBySyouhncdSkeijimukbn(C_SysKbn.ESHIEN, "ﾕｲ", "112", "212", C_SkeijimuKbn.SMBC, C_BoskyuusiRiyuuKbn.HANBAIRYOU);

        Assert.assertEquals(0, BosyuuKyuusiLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getBosyuuKyuusiBySyouhncdSkeijimukbn.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllBosyuuKyuusi());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {


        List<BM_BosyuuKyuusi> BosyuuKyuusiLst = bizDomManager.getBosyuuKyuusiBySyouhncdSkeijimukbn(C_SysKbn.SKEI, "ﾕｱ", "111", "211", C_SkeijimuKbn.TIGINSINKIN, C_BoskyuusiRiyuuKbn.RATE);

        Assert.assertEquals(0, BosyuuKyuusiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {


        List<BM_BosyuuKyuusi> BosyuuKyuusiLst = bizDomManager.getBosyuuKyuusiBySyouhncdSkeijimukbn(C_SysKbn.ESHIEN, "ﾕｲ", "112", "212", C_SkeijimuKbn.SMBC, C_BoskyuusiRiyuuKbn.HANBAIRYOU);

        Assert.assertEquals(1, BosyuuKyuusiLst.size());

        Assert.assertEquals(C_SysKbn.ESHIEN, BosyuuKyuusiLst.get(0).getSksyskbn());
        Assert.assertEquals("ﾕｲ", BosyuuKyuusiLst.get(0).getSyouhncd());
        Assert.assertEquals("112", BosyuuKyuusiLst.get(0).getYoteiriritutkybr1());
        Assert.assertEquals("212", BosyuuKyuusiLst.get(0).getYoteiriritutkybr2());
        Assert.assertEquals(C_SkeijimuKbn.SMBC, BosyuuKyuusiLst.get(0).getSkeijimukbn());
        Assert.assertEquals(1, BosyuuKyuusiLst.get(0).getHanteiyuusendo().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal2() {


        List<BM_BosyuuKyuusi> BosyuuKyuusiLst = bizDomManager.getBosyuuKyuusiBySyouhncdSkeijimukbn(C_SysKbn.SKEI, "ﾕﾍ", "001", "002", C_SkeijimuKbn.SMTB, C_BoskyuusiRiyuuKbn.BLNK);

        Assert.assertEquals(3, BosyuuKyuusiLst.size());

        Assert.assertEquals(C_SysKbn.SKEI, BosyuuKyuusiLst.get(0).getSksyskbn());
        Assert.assertEquals("ﾕﾍ", BosyuuKyuusiLst.get(0).getSyouhncd());
        Assert.assertEquals("001", BosyuuKyuusiLst.get(0).getYoteiriritutkybr1());
        Assert.assertEquals("002", BosyuuKyuusiLst.get(0).getYoteiriritutkybr2());
        Assert.assertEquals(C_SkeijimuKbn.SMTB, BosyuuKyuusiLst.get(0).getSkeijimukbn());
        Assert.assertEquals(1, BosyuuKyuusiLst.get(0).getHanteiyuusendo().intValue());

        Assert.assertEquals(C_SysKbn.SKEI, BosyuuKyuusiLst.get(1).getSksyskbn());
        Assert.assertEquals("ﾕﾍ", BosyuuKyuusiLst.get(1).getSyouhncd());
        Assert.assertEquals("001", BosyuuKyuusiLst.get(1).getYoteiriritutkybr1());
        Assert.assertEquals("002", BosyuuKyuusiLst.get(1).getYoteiriritutkybr2());
        Assert.assertEquals(C_SkeijimuKbn.SMTB, BosyuuKyuusiLst.get(1).getSkeijimukbn());
        Assert.assertEquals(2, BosyuuKyuusiLst.get(1).getHanteiyuusendo().intValue());

        Assert.assertEquals(C_SysKbn.SKEI, BosyuuKyuusiLst.get(2).getSksyskbn());
        Assert.assertEquals("ﾕﾍ", BosyuuKyuusiLst.get(2).getSyouhncd());
        Assert.assertEquals("001", BosyuuKyuusiLst.get(2).getYoteiriritutkybr1());
        Assert.assertEquals("002", BosyuuKyuusiLst.get(2).getYoteiriritutkybr2());
        Assert.assertEquals(C_SkeijimuKbn.SMTB, BosyuuKyuusiLst.get(2).getSkeijimukbn());
        Assert.assertEquals(3, BosyuuKyuusiLst.get(2).getHanteiyuusendo().intValue());

    }
}
