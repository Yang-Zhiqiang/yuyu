package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Syonokanri;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 証券番号自動採番のメソッド {@link SyoukenNoUtil#getShokenNo(String, String, String)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SyoukenNoUtilTest_getShokenNo extends AbstractTest {

    private static final String SOUSASYACD = "LBUser001";

    private final static String fileName = "UT_SP_単体テスト仕様書_証券番号自動採番";

    private final static String sheetName = "テストデータ";

    @Inject
    private SyoukenNoUtil syoukenNoUtil;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SyoukenNoUtilTest_getShokenNo.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyonokanri());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    @Transactional
    public void testGetShokenNo_A1() {

        String mosNo = "123";

        String bosyuuSosikiCd = "806";

        changeSystemDate(BizDate.valueOf(20150801));

        try {

            syoukenNoUtil.getShokenNo(mosNo, bosyuuSosikiCd, SOUSASYACD);

        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw e;
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testGetShokenNo_A2() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        String mosNo = "785566118";

        String bosyuuSosikiCd = "806";

        changeSystemDate(BizDate.valueOf(20110802));

        String syoNo = syoukenNoUtil.getShokenNo(mosNo, bosyuuSosikiCd, SOUSASYACD);

        BM_Syonokanri syonoKanri = bizDomManager.getSyonokanri("11", "808", 79988);

        exStringEquals(syoNo, "11808799887", "証券番号");

        exStringEquals(syonoKanri.getSeirekinen2keta(), "11", "西暦年（２桁）");
        exStringEquals(syonoKanri.getBosyuusosikicd(), "808", "募集組織コード");
        exNumericEquals(syonoKanri.getSyonorenno(), 79988, "証券番号連番");
        exStringEquals(syonoKanri.getSyono(), "11808799887", "証券番号");
        exStringEquals(syonoKanri.getMosno(), "785566118", "申込番号");
        exDateEquals(syonoKanri.getSaibanymd(), BizDate.valueOf(20110802), "採番日");
        exStringEquals(syonoKanri.getGyoumuKousinsyaId(), SOUSASYACD, "業務用更新者ID");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testGetShokenNo_A3() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        String mosNo = null;

        String bosyuuSosikiCd = "806";

        changeSystemDate(BizDate.valueOf(20121224));

        String syoNo = syoukenNoUtil.getShokenNo(mosNo, bosyuuSosikiCd, SOUSASYACD);

        BM_Syonokanri syonoKanri = bizDomManager.getSyonokanri("12", "809", 79989);

        exStringEquals(syoNo, "12809799892", "証券番号");

        exStringEquals(syonoKanri.getSeirekinen2keta(), "12", "西暦年（２桁）");
        exStringEquals(syonoKanri.getBosyuusosikicd(), "809", "募集組織コード");
        exNumericEquals(syonoKanri.getSyonorenno(), 79989, "証券番号連番");
        exStringEquals(syonoKanri.getSyono(), "12809799892", "証券番号");
        exStringEquals(syonoKanri.getMosno(), "", "申込番号");
        exDateEquals(syonoKanri.getSaibanymd(), BizDate.valueOf(20121224), "採番日");
        exStringEquals(syonoKanri.getGyoumuKousinsyaId(), SOUSASYACD, "業務用更新者ID");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testGetShokenNo_A4() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String mosNo = "";

        String bosyuuSosikiCd = "807";

        changeSystemDate(BizDate.valueOf(20140506));

        String syoNo = syoukenNoUtil.getShokenNo(mosNo, bosyuuSosikiCd, SOUSASYACD);

        BM_Syonokanri syonoKanri = bizDomManager.getSyonokanri("14", "806", 1);

        exStringEquals(syoNo, "14806000010", "証券番号");

        exStringEquals(syonoKanri.getSeirekinen2keta(), "14", "西暦年（２桁）");
        exStringEquals(syonoKanri.getBosyuusosikicd(), "806", "募集組織コード");
        exNumericEquals(syonoKanri.getSyonorenno(), 1, "証券番号連番");
        exStringEquals(syonoKanri.getSyono(), "14806000010", "証券番号");
        exStringEquals(syonoKanri.getMosno(), "", "申込番号");
        exDateEquals(syonoKanri.getSaibanymd(), BizDate.valueOf(20140506), "採番日");
        exStringEquals(syonoKanri.getGyoumuKousinsyaId(), SOUSASYACD, "業務用更新者ID");

        bizDomManager.delete(bizDomManager.getAllSyonokanri());

        BM_Syonokanri syonokanri6 = new BM_Syonokanri("15", "810", 79989);
        syonokanri6.setSaibanymd(BizDate.valueOf(20150805));

        sinkeiyakuDomManager.insert(syonokanri6);

        BM_Syonokanri syonokanri7 = new BM_Syonokanri("16", "555", 10705);
        syonokanri7.setSaibanymd(BizDate.valueOf(20160806));

        sinkeiyakuDomManager.insert(syonokanri7);

        BM_Syonokanri syonokanri8 = new BM_Syonokanri("13", "806", 4220);
        syonokanri8.setSaibanymd(BizDate.valueOf(20130408));

        sinkeiyakuDomManager.insert(syonokanri8);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(50)
    @Transactional
    public void testGetShokenNo_A5() {

        String mosNo = null;

        String bosyuuSosikiCd = "806";

        changeSystemDate(BizDate.valueOf(20150805));

        try {

            syoukenNoUtil.getShokenNo(mosNo, bosyuuSosikiCd, SOUSASYACD);

        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(60)
    @Transactional
    public void testGetShokenNo_A6() {

        String mosNo = null;

        String bosyuuSosikiCd = "555";

        changeSystemDate(BizDate.valueOf(20160806));

        try {

            syoukenNoUtil.getShokenNo(mosNo, bosyuuSosikiCd, SOUSASYACD);

        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw e;
        }
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testGetShokenNo_A7() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String mosNo = null;

        String bosyuuSosikiCd = "807";

        changeSystemDate(BizDate.valueOf(20130408));

        String syoNo = syoukenNoUtil.getShokenNo(mosNo, bosyuuSosikiCd, SOUSASYACD);

        BM_Syonokanri syonoKanri = bizDomManager.getSyonokanri("13", "806", 4222);

        exStringEquals(syoNo, "13806042220", "証券番号");

        exStringEquals(syonoKanri.getSeirekinen2keta(), "13", "西暦年（２桁）");
        exStringEquals(syonoKanri.getBosyuusosikicd(), "806", "募集組織コード");
        exNumericEquals(syonoKanri.getSyonorenno(), 4222, "証券番号連番");
        exStringEquals(syonoKanri.getSyono(), "13806042220", "証券番号");
        exStringEquals(syonoKanri.getMosno(), "", "申込番号");
        exDateEquals(syonoKanri.getSaibanymd(), BizDate.valueOf(20130408), "採番日");
        exStringEquals(syonoKanri.getGyoumuKousinsyaId(), SOUSASYACD, "業務用更新者ID");

        bizDomManager.delete(bizDomManager.getAllSyonokanri());

        BM_Syonokanri syonokanri9 = new BM_Syonokanri("15", "806", 80520);
        syonokanri9.setSaibanymd(BizDate.valueOf(20151106));

        sinkeiyakuDomManager.insert(syonokanri9);

        BM_Syonokanri syonokanri10 = new BM_Syonokanri("16", "807", 80709);
        syonokanri10.setSaibanymd(BizDate.valueOf(20160201));

        sinkeiyakuDomManager.insert(syonokanri10);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(80)
    @Transactional
    public void testGetShokenNo_A8() {

        String mosNo = null;

        String bosyuuSosikiCd = "ab1";

        changeSystemDate(BizDate.valueOf(20151106));

        try {

            syoukenNoUtil.getShokenNo(mosNo, bosyuuSosikiCd, SOUSASYACD);

        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw e;
        }
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testGetShokenNo_A9() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String mosNo = null;

        String bosyuuSosikiCd = "807";

        changeSystemDate(BizDate.valueOf(20160201));

        String syoNo = syoukenNoUtil.getShokenNo(mosNo, bosyuuSosikiCd, SOUSASYACD);

        BM_Syonokanri syonoKanri = bizDomManager.getSyonokanri("16", "808", 1);

        exStringEquals(syoNo, "16808000018", "証券番号");

        exStringEquals(syonoKanri.getSeirekinen2keta(), "16", "西暦年（２桁）");
        exStringEquals(syonoKanri.getBosyuusosikicd(), "808", "募集組織コード");
        exNumericEquals(syonoKanri.getSyonorenno(), 1, "証券番号連番");
        exStringEquals(syonoKanri.getSyono(), "16808000018", "証券番号");
        exStringEquals(syonoKanri.getMosno(), "", "申込番号");
        exDateEquals(syonoKanri.getSaibanymd(), BizDate.valueOf(20160201), "採番日");
        exStringEquals(syonoKanri.getGyoumuKousinsyaId(), SOUSASYACD, "業務用更新者ID");

        bizDomManager.delete(bizDomManager.getAllSyonokanri());

        BM_Syonokanri syonokanri10 = new BM_Syonokanri("17", "806", 3300);
        syonokanri10.setSaibanymd(BizDate.valueOf(20171229));
        sinkeiyakuDomManager.insert(syonokanri10);
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testGetShokenNo_A10() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String mosNo = null;

        String bosyuuSosikiCd = "806";

        changeSystemDate(BizDate.valueOf(20180104));

        String syoNo = syoukenNoUtil.getShokenNo(mosNo, bosyuuSosikiCd, SOUSASYACD);

        exStringEquals(syoNo, "18806000014", "証券番号");

        bizDomManager.delete(bizDomManager.getAllSyonokanri());

        BM_Syonokanri syonokanri11 = new BM_Syonokanri("17", "807", 3300);
        syonokanri11.setSaibanymd(BizDate.valueOf(20171229));
        sinkeiyakuDomManager.insert(syonokanri11);

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testGetShokenNo_A11() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String mosNo = null;

        String bosyuuSosikiCd = "807";

        changeSystemDate(BizDate.valueOf(20180104));

        String syoNo = syoukenNoUtil.getShokenNo(mosNo, bosyuuSosikiCd, SOUSASYACD);

        exStringEquals(syoNo, "18806000014", "証券番号");

        bizDomManager.delete(bizDomManager.getAllSyonokanri());

        BM_Syonokanri syonokanri12 = new BM_Syonokanri("17", "808", 3300);
        syonokanri12.setSaibanymd(BizDate.valueOf(20171229));
        sinkeiyakuDomManager.insert(syonokanri12);

    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testGetShokenNo_A12() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String mosNo = null;

        String bosyuuSosikiCd = "808";

        changeSystemDate(BizDate.valueOf(20180104));

        String syoNo = syoukenNoUtil.getShokenNo(mosNo, bosyuuSosikiCd, SOUSASYACD);

        exStringEquals(syoNo, "18806000014", "証券番号");

        bizDomManager.delete(bizDomManager.getAllSyonokanri());

        BM_Syonokanri syonokanri13 = new BM_Syonokanri("17", "809", 3300);
        syonokanri13.setSaibanymd(BizDate.valueOf(20171229));
        sinkeiyakuDomManager.insert(syonokanri13);
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testGetShokenNo_A13() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String mosNo = null;

        String bosyuuSosikiCd = "809";

        changeSystemDate(BizDate.valueOf(20180104));

        String syoNo = syoukenNoUtil.getShokenNo(mosNo, bosyuuSosikiCd, SOUSASYACD);

        exStringEquals(syoNo, "18806000014", "証券番号");

        bizDomManager.delete(bizDomManager.getAllSyonokanri());

        BM_Syonokanri syonokanri14 = new BM_Syonokanri("17", "810", 3300);
        syonokanri14.setSaibanymd(BizDate.valueOf(20171229));
        sinkeiyakuDomManager.insert(syonokanri14);
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testGetShokenNo_A14() {

        String mosNo = null;

        String bosyuuSosikiCd = "810";

        changeSystemDate(BizDate.valueOf(20180104));

        String syoNo = syoukenNoUtil.getShokenNo(mosNo, bosyuuSosikiCd, SOUSASYACD);

        exStringEquals(syoNo, "18806000014", "証券番号");

    }
}