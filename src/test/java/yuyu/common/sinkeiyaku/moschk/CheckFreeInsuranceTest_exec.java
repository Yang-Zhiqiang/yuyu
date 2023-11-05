package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * フリーインシュアランスチェッククラスのメソッド {@link CheckFreeInsurance#exec(MosnaiCheckParam, C_Seibetu, String, C_TknKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckFreeInsuranceTest_exec {

    private final static String fileName = "UT_SP_単体テスト仕様書_フリーインシュアランスチェック";

    private final static String sheetName = "テストデータ";

    @Inject
    private CheckFreeInsurance checkFreeInsurance;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckFreeInsuranceTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A1() {
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("871111118");

        mosnaiCheckParam.setKosID("testuser");
        mosnaiCheckParam.setKosTime("20150624134000001");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        checkFreeInsurance.exec(mosnaiCheckParam, C_Seibetu.MALE, "T110", C_TknKbn.NONE);
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A2() {
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("871111126");

        mosnaiCheckParam.setKosID("testuser");
        mosnaiCheckParam.setKosTime("20150624134000001");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        checkFreeInsurance.exec(mosnaiCheckParam, C_Seibetu.MALE, "T110", C_TknKbn.NONE);
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A3() {
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("871111134");

        mosnaiCheckParam.setKosID("testuser");
        mosnaiCheckParam.setKosTime("20150624134000001");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        checkFreeInsurance.exec(mosnaiCheckParam, C_Seibetu.MALE, "T110", C_TknKbn.NONE);
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_B1() {
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("872222229");

        mosnaiCheckParam.setKosID("testuser");
        mosnaiCheckParam.setKosTime("20150624134000001");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        checkFreeInsurance.exec(mosnaiCheckParam, C_Seibetu.MALE, "", C_TknKbn.NONE);
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(220)
    public void testExec_B2() {
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("872222237");

        mosnaiCheckParam.setKosID("testuser");
        mosnaiCheckParam.setKosTime("20150624134000001");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        try {
            checkFreeInsurance.exec(mosnaiCheckParam, C_Seibetu.MALE, "", C_TknKbn.NONE);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号：872222237", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_B3() {
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("872222245");

        mosnaiCheckParam.setKosID("testuser");
        mosnaiCheckParam.setKosTime("20150624134000001");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        checkFreeInsurance.exec(mosnaiCheckParam, C_Seibetu.MALE, "T110", C_TknKbn.NONE);
    }

    @Test
    @Transactional
    @TestOrder(310)
    public void testExec_C1() {
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("873333330");

        mosnaiCheckParam.setKosID("testuser");
        mosnaiCheckParam.setKosTime("20150624134000001");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        checkFreeInsurance.exec(mosnaiCheckParam, C_Seibetu.BLNK, "T110", C_TknKbn.NONE);
    }

    @Test
    @Transactional
    @TestOrder(320)
    public void testExec_C2() {
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("873333348");

        mosnaiCheckParam.setKosID("testuser");
        mosnaiCheckParam.setKosTime("20150624134000001");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        checkFreeInsurance.exec(mosnaiCheckParam, C_Seibetu.BLNK, "T110", C_TknKbn.NONE);
    }

    @Test
    @Transactional
    @TestOrder(410)
    public void testExec_D1() {
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("874444441");

        mosnaiCheckParam.setKosID("testuser");
        mosnaiCheckParam.setKosTime("20150624134000001");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        checkFreeInsurance.exec(mosnaiCheckParam, C_Seibetu.BLNK, "T110", C_TknKbn.NONE);
    }

    @Test
    @Transactional
    @TestOrder(420)
    public void testExec_D2() {
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("874444458");

        mosnaiCheckParam.setKosID("testuser");
        mosnaiCheckParam.setKosTime("20150624134000001");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        checkFreeInsurance.exec(mosnaiCheckParam, C_Seibetu.BLNK, "T110", C_TknKbn.NONE);
    }

    @Test
    @Transactional
    @TestOrder(430)
    public void testExec_D3() {
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("874444466");

        mosnaiCheckParam.setKosID("testuser");
        mosnaiCheckParam.setKosTime("20150624134000001");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        checkFreeInsurance.exec(mosnaiCheckParam, C_Seibetu.BLNK, "T110", C_TknKbn.NONE);
    }

    @Test
    @Transactional
    @TestOrder(440)
    public void testExec_D4() {
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("874444474");

        mosnaiCheckParam.setKosID("testuser");
        mosnaiCheckParam.setKosTime("20150624134000001");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKinouID("TESTKINOU");

        checkFreeInsurance.exec(mosnaiCheckParam, C_Seibetu.BLNK, "T110", C_TknKbn.NONE);
    }
}