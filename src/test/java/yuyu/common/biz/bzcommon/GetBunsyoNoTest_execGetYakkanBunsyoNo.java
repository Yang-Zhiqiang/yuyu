package yuyu.common.biz.bzcommon;

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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoMockForSinkeiyaku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 文書番号取得クラスのメソッド {@link GetBunsyoNo#execGetYakkanBunsyoNo(C_AisyoumeiKbn, C_Channelcd, String,
        BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetBunsyoNoTest_execGetYakkanBunsyoNo {

    @Inject
    private GetBunsyoNo getBunsyoNo;

    private final static String fileName = "UT_SP_単体テスト仕様書_文書番号取得";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetBunsyoNoTest_execGetYakkanBunsyoNo.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllBunsyonoSettei());
    }

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(BzGetAgInfo.class).to(BzGetAgInfoMockForSinkeiyaku.class);
            }
        });

    }

    @BeforeClass
    public static void testInit() {

        BzGetAgInfoMockForSinkeiyaku.caller = GetBunsyoNoTest_execGetYakkanBunsyoNo.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.caller = null;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = null;

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExecGetYakkanBunsyoNo_A1() {

        C_AisyoumeiKbn pAisyoumeiKbn = null;
        C_Channelcd pChannelcd = null;
        String pOyadrtenCd = "";
        BizDate pMosYmd = BizDate.valueOf(20190101);

        try {
            getBunsyoNo.execGetYakkanBunsyoNo(pAisyoumeiKbn, pChannelcd, pOyadrtenCd, pMosYmd);
        }catch(CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(20)
    public void testExecGetYakkanBunsyoNo_A2() {

        C_AisyoumeiKbn pAisyoumeiKbn = C_AisyoumeiKbn.BLNK;
        C_Channelcd pChannelcd = null;
        String pOyadrtenCd = "";
        BizDate pMosYmd = BizDate.valueOf(20190101);

        try {
            getBunsyoNo.execGetYakkanBunsyoNo(pAisyoumeiKbn, pChannelcd, pOyadrtenCd, pMosYmd);
        }catch(CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
            throw e;
        }
    }
    @Test(expected = CommonBizAppException.class)
    @TestOrder(30)
    public void testExecGetYakkanBunsyoNo_A3() {

        C_AisyoumeiKbn pAisyoumeiKbn = C_AisyoumeiKbn.GAIKAINDEXNK_MDHN;
        C_Channelcd pChannelcd = null;
        String pOyadrtenCd = "";
        BizDate pMosYmd = null;

        try {
            getBunsyoNo.execGetYakkanBunsyoNo(pAisyoumeiKbn, pChannelcd, pOyadrtenCd, pMosYmd);
        }catch(CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメーター不正", "エラーメッセージ");
            throw e;
        }
    }
    @Test
    @TestOrder(40)
    public void testExecGetYakkanBunsyoNo_A4() {

        C_AisyoumeiKbn pAisyoumeiKbn = C_AisyoumeiKbn.GAIKAINDEXNK_MDHN;
        C_Channelcd pChannelcd = null;
        String pOyadrtenCd = "";
        BizDate pMosYmd = BizDate.valueOf(20190101);

        GetBunsyoNoOutBean getBunsyoNoOutBean = getBunsyoNo.execGetYakkanBunsyoNo(
            pAisyoumeiKbn, pChannelcd, pOyadrtenCd, pMosYmd);

        exStringEquals(getBunsyoNoOutBean.getYakkanbunsyoNo(), "", "約款文書番号");

        exStringEquals(getBunsyoNoOutBean.getSioriNo(), "", "しおり番号");
    }
    @Test
    @TestOrder(50)
    public void testExecGetYakkanBunsyoNo_A5() {

        C_AisyoumeiKbn pAisyoumeiKbn = C_AisyoumeiKbn.GAIKAINDEXNK_MDHN;
        C_Channelcd pChannelcd = null;
        String pOyadrtenCd = "123";
        BizDate pMosYmd = BizDate.valueOf(20190101);

        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;

        GetBunsyoNoOutBean getBunsyoNoOutBean = getBunsyoNo.execGetYakkanBunsyoNo(
            pAisyoumeiKbn, pChannelcd, pOyadrtenCd, pMosYmd);

        exStringEquals(getBunsyoNoOutBean.getYakkanbunsyoNo(), "", "約款文書番号");

        exStringEquals(getBunsyoNoOutBean.getSioriNo(), "", "しおり番号");
    }

    @Test
    @TestOrder(60)
    public void testExecGetYakkanBunsyoNo_A6() {

        C_AisyoumeiKbn pAisyoumeiKbn = C_AisyoumeiKbn.GAIKAINDEXNK_MDHN;
        C_Channelcd pChannelcd = null;
        String pOyadrtenCd = "123";
        BizDate pMosYmd = BizDate.valueOf(20190101);

        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;

        GetBunsyoNoOutBean getBunsyoNoOutBean = getBunsyoNo.execGetYakkanBunsyoNo(
            pAisyoumeiKbn, pChannelcd, pOyadrtenCd, pMosYmd);

        exStringEquals(getBunsyoNoOutBean.getYakkanbunsyoNo(), "", "約款文書番号");

        exStringEquals(getBunsyoNoOutBean.getSioriNo(), "", "しおり番号");
    }

    @Test
    @TestOrder(70)
    public void testExecGetYakkanBunsyoNo_A7() {

        C_AisyoumeiKbn pAisyoumeiKbn = C_AisyoumeiKbn.GAIKAINDEXNK_TR_MDHN;
        C_Channelcd pChannelcd = null;
        String pOyadrtenCd = "123";
        BizDate pMosYmd = BizDate.valueOf(20190301);

        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN2;

        GetBunsyoNoOutBean getBunsyoNoOutBean = getBunsyoNo.execGetYakkanBunsyoNo(
            pAisyoumeiKbn, pChannelcd, pOyadrtenCd, pMosYmd);

        exStringEquals(getBunsyoNoOutBean.getYakkanbunsyoNo(), "", "約款文書番号");

        exStringEquals(getBunsyoNoOutBean.getSioriNo(), "", "しおり番号");
    }

    @Test
    @TestOrder(80)
    public void testExecGetYakkanBunsyoNo_A8() {

        C_AisyoumeiKbn pAisyoumeiKbn = C_AisyoumeiKbn.GAIKAINDEXNK_MDHN;
        C_Channelcd pChannelcd = null;
        String pOyadrtenCd = "123";
        BizDate pMosYmd = BizDate.valueOf(20190101);

        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN2;

        GetBunsyoNoOutBean getBunsyoNoOutBean = getBunsyoNo.execGetYakkanBunsyoNo(
            pAisyoumeiKbn, pChannelcd, pOyadrtenCd, pMosYmd);

        exStringEquals(getBunsyoNoOutBean.getYakkanbunsyoNo(), "1234561", "約款文書番号");

        exStringEquals(getBunsyoNoOutBean.getSioriNo(), "001", "しおり番号");
    }

    @Test
    @TestOrder(90)
    public void testExecGetYakkanBunsyoNo_A9() {

        C_AisyoumeiKbn pAisyoumeiKbn = C_AisyoumeiKbn.GAIKAINDEXNK_SMBC;
        C_Channelcd pChannelcd = null;
        String pOyadrtenCd = "123";
        BizDate pMosYmd = BizDate.valueOf(20190501);

        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;

        GetBunsyoNoOutBean getBunsyoNoOutBean = getBunsyoNo.execGetYakkanBunsyoNo(
            pAisyoumeiKbn, pChannelcd, pOyadrtenCd, pMosYmd);

        exStringEquals(getBunsyoNoOutBean.getYakkanbunsyoNo(), "1234563", "約款文書番号");

        exStringEquals(getBunsyoNoOutBean.getSioriNo(), "003", "しおり番号");
    }

    @Test
    @TestOrder(100)
    public void testExecGetYakkanBunsyoNo_A10() {

        C_AisyoumeiKbn pAisyoumeiKbn = C_AisyoumeiKbn.GAIKAINDEXNK_SINKIN;
        C_Channelcd pChannelcd = C_Channelcd.BLNK;
        String pOyadrtenCd = "001";
        BizDate pMosYmd = BizDate.valueOf(20190401);

        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN2;

        GetBunsyoNoOutBean getBunsyoNoOutBean = getBunsyoNo.execGetYakkanBunsyoNo(
            pAisyoumeiKbn, pChannelcd, pOyadrtenCd, pMosYmd);

        exStringEquals(getBunsyoNoOutBean.getYakkanbunsyoNo(), "", "約款文書番号");

        exStringEquals(getBunsyoNoOutBean.getSioriNo(), "", "しおり番号");
    }
}
