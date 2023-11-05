package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForHozen;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForHozen;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 契約保全 契約保全共通 有効状態チェッククラスのメソッド {@link CheckYuukouJyoutai#exec(KhozenCommonParam, CheckYuukouJyoutaiExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckYuukouJyoutaiTest_exec {

    private CheckYuukouJyoutai checkYuukouJyoutai;
    private KhozenCommonParam pKhCp;
    private CheckYuukouJyoutaiExecUiBeanParamImpl pUiBean;

    @Inject
    private AS_Kinou kinou;

    private final static String fileName = "UT_SP_単体テスト仕様書_有効状態チェック";
    private final static String sheetName = "テストデータ";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForHozen.class);
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForHozen.class);
            }
        });

        checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
        pKhCp = SWAKInjector.getInstance(KhozenCommonParam.class);
        pUiBean = SWAKInjector.getInstance(CheckYuukouJyoutaiExecUiBeanParamImpl.class);
    }

    @BeforeClass
    public static void testInit(){
        BzGetProcessSummaryMockForHozen.caller = CheckYuukouJyoutaiTest_exec.class;

        IwfKouteiClientMockForHozen.caller = "Test";
        IwfKouteiClientMockForHozen.mode =  "21-07";

    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.caller = null;
        BzGetProcessSummaryMockForHozen.SYORIPTN = null;

        IwfKouteiClientMockForHozen.caller = null;
        IwfKouteiClientMockForHozen.mode = null;
    }
    @BeforeClass
    @Transactional
    public static void insertTestData() {

        deleteTestData();

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckYuukouJyoutaiTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllKykjyoutaikahi());
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
        hozenDomManager.delete(hozenDomManager.getAllAnnaijyoutaikahi());
        hozenDomManager.delete(hozenDomManager.getAllSyorijtkahi());
        hozenDomManager.delete(hozenDomManager.getAllYykIdouUktksyorikahi());
        hozenDomManager.delete(hozenDomManager.getAllSyoumetukahi());
        baseDomManager.delete(baseDomManager.getAllKinous());
        baseDomManager.delete(baseDomManager.getAllCategories());
        baseDomManager.delete(baseDomManager.getAllSubSystems());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {
        pKhCp.setFunctionId("khhubikaisyou");
        pUiBean.setSyono("12806345683");

        try {
            checkYuukouJyoutai.exec(pKhCp, pUiBean);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。契約商品TBL 証券番号=12806345683", "エラーメッセージ");
            throw e;
        }

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {
        pKhCp.setFunctionId("khhubikaisyou");
        pUiBean.setSyono("12806345672");

        try {
            checkYuukouJyoutai.exec(pKhCp, pUiBean);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。契約商品TBL 証券番号=12806345672", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {
        pKhCp.setFunctionId("khhubikaisyou");

        pUiBean.setSyono("12806345694");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.KA, "有効状態チェック結果区分");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;

        pKhCp.setFunctionId("khhubikaisyoa");
        pUiBean.setSyono("12806345694");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 2 ,"ワーニングメッセージIDリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(0), "KBC0001", "1件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(1), "KBC0001", "2件目");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 2 ,"ワーニングメッセージリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(0), "払込中契約です。", "1件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(1), "脱退中契約です。", "2件目");

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;

        pKhCp.setFunctionId("khhubikaisyoa");
        pUiBean.setSyono("12806345694");

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 2 ,"ワーニングメッセージIDリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(0), "KBC0001", "1件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(1), "KBC0001", "2件目");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 2 ,"ワーニングメッセージリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(0), "払込中契約です。", "1件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(1), "脱退中契約です。", "2件目");

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        pKhCp.setFunctionId("khhubikaisyob");
        pUiBean.setSyono("12806345694");

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.KA, "有効状態チェック結果区分");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khhubikaisyoa");
        pUiBean.setSyono("12806345694");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 3 ,"ワーニングメッセージIDリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(0), "KBC0001", "1件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(1), "KBC0001", "2件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(2), "KBC0001", "3件目");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 3 ,"ワーニングメッセージリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(0), "払込中契約です。", "1件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(1), "脱退中契約です。", "2件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(2), "事務手続名　手続中契約です。", "3件目");

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;
        pKhCp.setFunctionId("accesslogsyoukai");
        pUiBean.setSyono("12806345708");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.KA, "有効状態チェック結果区分");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;

        pKhCp.setFunctionId("addressmasterhanei");
        pUiBean.setSyono("12806345708");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 1 ,"ワーニングメッセージIDリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(0), "KBC0001", "1件目");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 1 ,"ワーニングメッセージリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(0), "払込中契約です。", "1件目");

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_A10() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        pKhCp.setFunctionId("batchjikkoubikousin");
        pUiBean.setSyono("12806345708");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "予約異動受付中", "エラーメッセージ");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_A11() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;

        kinou.setKinouKbn(null);
        pKhCp.setFunctionId("khmeigihenkou");
        pUiBean.setSyono("12806345708");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 1 ,"ワーニングメッセージIDリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(0), "WBC0001", "1件目");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 1 ,"ワーニングメッセージリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(0), "予約異動受付中の契約です。（異動名：アクセスログ照会　変更内容：払込回数変更　効力発生日：2015年12月01日）<BR>予約異動の取消要否を確認してください。", "1件目");

    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_A12() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;

        pKhCp.setFunctionId("khkeiyakusyoukai");
        pUiBean.setSyono("12806345708");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 1 ,"ワーニングメッセージIDリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(0), "WBC0001", "1件目");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 1 ,"ワーニングメッセージリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(0), "予約異動受付中の契約です。（異動名：アクセスログ照会　変更内容：払込回数変更　効力発生日：2015年12月01日）", "1件目");

    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_A13() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;

        pKhCp.setFunctionId("khharaikatahenkou");
        pUiBean.setSyono("12806345708");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 1 ,"ワーニングメッセージIDリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(0), "WBC0001", "1件目");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 1 ,"ワーニングメッセージリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(0), "予約異動受付中の契約です。（異動名：アクセスログ照会　変更内容：払込回数変更　効力発生日：2015年12月01日）<BR>処理実施後、予約異動は取消されます。（口座のみ変更を除く）", "1件目");

    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_A14() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        pKhCp.setFunctionId("khharaikatahenkou");
        pUiBean.setSyono("12806345719");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.KA, "有効状態チェック結果区分");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_A15() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        pKhCp.setFunctionId("khharaikatahenkou");
        pUiBean.setSyono("12806345720");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.KA, "有効状態チェック結果区分");
    }


    @Test
    @TestOrder(160)
    @Transactional
    public void testExec_A16() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        pKhCp.setFunctionId("khharaikatahenkou");
        pUiBean.setSyono("12806345731");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.KA, "有効状態チェック結果区分");
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testExec_A17() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        MockObjectManager.initialize();
        pKhCp.setFunctionId("addressmasterhanei");

        pUiBean.setSyono("12806345694");
        checkYuukouJyoutai.getErrorMessage();
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "事務手続名　手続中", "エラーメッセージ");
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testExec_A18() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN4;

        pKhCp.setFunctionId("khhubikaisyoa");
        pUiBean.setSyono("12806345694");
        checkYuukouJyoutai.getErrorMessage();
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 4 ,"ワーニングメッセージIDリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(0), "KBC0001", "1件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(1), "KBC0001", "2件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(2), "KBC0001", "3件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(3), "KBC0001", "4件目");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 4 ,"ワーニングメッセージリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(0), "払込中契約です。", "1件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(1), "脱退中契約です。", "2件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(2), "事務手続名３　現在ノード名３契約です。", "3件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(3), "事務手続名４　現在ノード名４契約です。", "4件目");
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExec_A19() {
        pKhCp.setFunctionId("khsiharaityousyo");
        pUiBean.setSyono("12806345694");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "脱退中", "エラーメッセージ");
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testExec_A20() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN3;
        pKhCp.setFunctionId("khauthorisel");
        pUiBean.setSyono("12806345694");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.KA, "有効状態チェック結果区分");
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testExec_A21() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN3;
        pKhCp.setFunctionId("khyuukouseisel");
        pUiBean.setSyono("12806345694");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.KA, "有効状態チェック結果区分");
    }


    @Test
    @TestOrder(220)
    @Transactional
    public void testExec_A22() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN3;
        pKhCp.setFunctionId("khyuukouseisel");
        pUiBean.setSyono("12806345742");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);
        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.KA, "有効状態チェック結果区分");
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testExec_A23() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN3;
        pKhCp.setFunctionId("jshk");
        pUiBean.setSyono("12806345742");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.KA, "有効状態チェック結果区分");
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testExec_A24() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN3;
        pKhCp.setFunctionId("mghk");
        pUiBean.setSyono("12806345742");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 1, "ワーニングメッセージIDリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(0), "KBC0001", "1件目");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 1, "ワーニングメッセージリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(0), "クーリングオフ（消滅日：2015.11.11）契約です。", "1件目");
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testExec_A25() {
        pKhCp.setFunctionId("hrhk");
        pUiBean.setSyono("12806345742");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "クーリングオフ（消滅日：2015.11.11）", "エラーメッセージ");
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testExec_A26() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khhubikaisyoa");
        pUiBean.setSyono("12806345708");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 4 ,"ワーニングメッセージIDリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(0), "KBC0001", "1件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(1), "KBC0001", "2件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(2), "KBC0001", "3件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(3), "WBC0001", "4件目");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 4 ,"ワーニングメッセージリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(0), "払込中契約です。", "1件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(1), "脱退中契約です。", "2件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(2), "事務手続名　手続中契約です。", "3件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(3), "予約異動受付中の契約です。（異動名：アクセスログ照会　変更内容：払込回数変更　効力発生日：2015年12月01日）<BR>予約異動の取消要否を確認してください。", "4件目");

    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testExec_A27() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;

        pKhCp.setFunctionId("mghk");
        pUiBean.setSyono("12806345742");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);
        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 1 ,"ワーニングメッセージIDリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(0), "KBC0001", "1件目");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 1 ,"ワーニングメッセージリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(0), "クーリングオフ（消滅日：2015.11.11）契約です。", "1件目");

    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testExec_A28() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khhubikaisyob");
        pUiBean.setSyono("12806345694");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);
        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.KA, "有効状態チェック結果区分");

    }
    @Test
    @TestOrder(290)
    @Transactional
    public void testExec_A29() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khkaigomaebaraitkhenkou");
        pUiBean.setSyono("11807111118");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }
    @Test
    @TestOrder(300)
    @Transactional
    public void testExec_A30() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khmkhgkhenkou");
        pUiBean.setSyono("11807111118");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }
    @Test
    @TestOrder(310)
    @Transactional
    public void testExec_A31() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;

        pKhCp.setFunctionId("khhubikaisyos");
        pUiBean.setSyono("11807111118");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 1 ,"ワーニングメッセージIDリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(0), "KBC0001", "1件目");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 1 ,"ワーニングメッセージリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(0), "死亡仮受付中の契約です。", "1件目");
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testExec_A32() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khbatchkaiyaku");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(330)
    @Transactional
    public void testExec_A33() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("dwkaiyakuuketuke");
        pUiBean.setSyono("11807111129");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(340)
    @Transactional
    public void testExec_A34() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khhubikaisyos");
        pUiBean.setSyono("11807111130");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 0, "ワーニングメッセージIDリストサイズ");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 0, "ワーニングメッセージリストサイズ");
        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.KA, "有効状態チェック結果区分");
    }

    @Test
    @TestOrder(350)
    @Transactional
    public void testExec_A35() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khhubikaisyos1");
        pUiBean.setSyono("11807111141");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "ＤＳ解約　受付中", "エラーメッセージ");
    }

    @Test
    @TestOrder(360)
    @Transactional
    public void testExec_A36() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khhubikaisyos2");
        pUiBean.setSyono("11807111152");
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 3 ,"ワーニングメッセージIDリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(0), "KBC0001", "1件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(1), "KBC0001", "2件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(2), "KBC0001", "3件目");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 3 ,"ワーニングメッセージリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(0), "目標額到達時円建変更　受付中契約です。", "1件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(1), "電話解約　受付中契約です。", "2件目");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(2), "積立金移転　受付中契約です。", "3件目");

    }

    @Test
    @TestOrder(370)
    @Transactional
    public void testExec_A37() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khhubikaisyos3");
        pUiBean.setSyono("11807111163");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "解約　受付中", "エラーメッセージ");

    }

    @Test
    @TestOrder(380)
    @Transactional
    public void testExec_A38() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("dwtumitatekinitenuketuke");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(390)
    @Transactional
    public void testExec_A39() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khtmttkiniten");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(400)
    @Transactional
    public void testExec_A40() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khmkhgktttyendthnkuktk");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(410)
    @Transactional
    public void testExec_A41() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khmkhgktttyendthnksel");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(420)
    @Transactional
    public void testExec_A42() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khharaikatahenkou");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(430)
    @Transactional
    public void testExec_A43() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khdshr");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(440)
    @Transactional
    public void testExec_A44() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khdattai");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(450)
    @Transactional
    public void testExec_A45() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khyoyakuidoukousin");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(460)
    @Transactional
    public void testExec_A46() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khikkatuannaisaikai");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(470)
    @Transactional
    public void testExec_A47() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khkoujyosyoumeisks");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(480)
    @Transactional
    public void testExec_A48() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khsinkokuyokokutuutisks");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 1 ,"ワーニングメッセージIDリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(0), "KBC0001", "1件目");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 1 ,"ワーニングメッセージリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(0), "死亡仮受付中の契約です。", "1件目");

    }

    @Test
    @TestOrder(490)
    @Transactional
    public void testExec_A49() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khzennoujyuutoumanryou");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(500)
    @Transactional
    public void testExec_A50() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khkzhuriannaisel");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(510)
    @Transactional
    public void testExec_A51() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khkzhurikaisiannaisks");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(520)
    @Transactional
    public void testExec_A52() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khkijitutouraiannaisks");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(530)
    @Transactional
    public void testExec_A53() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khminyuu");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(540)
    @Transactional
    public void testExec_A54() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;

        pKhCp.setFunctionId("khminyuu");
        pUiBean.setSyono("39807111112");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);
        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "払込中", "エラーメッセージ");

    }

    @Test
    @TestOrder(550)
    @Transactional
    public void testExec_A55() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khsinnintouhyousks");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }
    @Test
    @TestOrder(560)
    @Transactional
    public void testExec_A56() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        SiharaiDomManager siharaiDomManager =  SWAKInjector.getInstance(SiharaiDomManager.class);

        IT_KykKihon kykKihon;
        List<IT_KykSyouhn> kykSyohnLst;
        IT_AnsyuKihon ansyuKihon;
        IT_DattaiUktk dattaiUktk;
        List<JT_SkKihon> skKihonList;

        String syono = "17806000013";

        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("NoExistedFunction");
        pUiBean.setSyono(syono);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);
        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");

        {
            kykKihon = hozenDomManager.getKykKihon(syono);
            exStringEquals(kykKihon.getSyono(), syono, "契約基本エンティティ 証券番号");
            exBooleanEquals(hozenDomManager.isManaged(kykKihon), true, "契約基本エンティティ(デタッチ前) 管理状態");

            kykSyohnLst = pKhCp.getKeiyakuSyouhin(syono, C_SyutkKbn.SYU);
            exNumericEquals(kykSyohnLst.size(), 1, "契約商品TBLエンティティリストサイズ");
            exStringEquals(kykSyohnLst.get(0).getSyono(), syono, "契約商品エンティティ 証券番号");
            exBooleanEquals(hozenDomManager.isManaged(kykSyohnLst.get(0)), true, "契約商品エンティティ(デタッチ前) 管理状態");

            ansyuKihon = hozenDomManager.getAnsyuKihon(syono);
            exStringEquals(ansyuKihon.getSyono(), syono, "案内収納基本エンティティ 証券番号");
            exBooleanEquals(hozenDomManager.isManaged(ansyuKihon), true, "案内収納基本エンティティ(デタッチ前) 管理状態");

            dattaiUktk = hozenDomManager.getAnsyuKihon(syono).getDattaiUktk();
            exStringEquals(dattaiUktk.getSyono(), syono, "脱退受付エンティティ 証券番号");
            exBooleanEquals(hozenDomManager.isManaged(dattaiUktk), true, "脱退受付エンティティ(デタッチ前) 管理状態");

            skKihonList = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(syono,C_SeikyuuSyubetu.SBKRUKTK,C_UmuKbn.NONE);
            exNumericEquals(skKihonList.size(), 1, "請求基本テーブルエンティティリストサイズ");
            exStringEquals(skKihonList.get(0).getSyono(), syono, "請求基本テーブルエンティティ 証券番号");
            exBooleanEquals(hozenDomManager.isManaged(skKihonList.get(0)), true, "請求基本エンティティ(デタッチ前) 管理状態");

        }

        checkYuukouJyoutai.detachAllEntities(syono);

        {
            exBooleanEquals(hozenDomManager.isManaged(kykKihon), false, "契約基本エンティティ(デタッチ後) 管理状態");
            exBooleanEquals(hozenDomManager.isManaged(kykSyohnLst.get(0)), false, "契約商品エンティティ(デタッチ後) 管理状態");
            exBooleanEquals(hozenDomManager.isManaged(ansyuKihon), false, "案内収納基本エンティティ(デタッチ後) 管理状態");
            exBooleanEquals(hozenDomManager.isManaged(dattaiUktk), false, "脱退受付エンティティ(デタッチ後) 管理状態");
            exBooleanEquals(hozenDomManager.isManaged(skKihonList.get(0)), false, "請求基本エンティティ(デタッチ後) 管理状態");
        }

    }

    @Test
    @TestOrder(570)
    @Transactional
    public void testExec_A57() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        SiharaiDomManager siharaiDomManager =  SWAKInjector.getInstance(SiharaiDomManager.class);

        IT_KykKihon kykKihon;
        IT_AnsyuKihon ansyuKihon;
        List<JT_SkKihon> skKihonList;

        String syono = "10000000000";

        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("NoExistedFunction");
        pUiBean.setSyono(syono);

        {
            kykKihon = hozenDomManager.getKykKihon(syono);
            if (kykKihon != null) {
                fail("【契約基本エンティティ (デタッチ前)】[期待値違反] 検証値：" + kykKihon.getSyono() + " Entity  期待値：null");
            }

            ansyuKihon = hozenDomManager.getAnsyuKihon(syono);
            if (ansyuKihon != null) {
                fail("【案内収納基本エンティティ (デタッチ前)】[期待値違反] 検証値：" + ansyuKihon.getSyono() + " Entity  期待値：null");
            }

            skKihonList = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(syono,C_SeikyuuSyubetu.SBKRUKTK,C_UmuKbn.NONE);
            if (skKihonList.size() != 0) {
                fail("【請求基本エンティティ (デタッチ前)】[期待値違反] 検証値：" + skKihonList.get(0).getSyono() + " Entity  期待値：null");
            }
        }

        checkYuukouJyoutai.detachAllEntities(syono);

        {
            kykKihon = hozenDomManager.getKykKihon(syono);
            if (kykKihon != null) {
                fail("【契約基本エンティティ (デタッチ後)】[期待値違反] 検証値：" + kykKihon.getSyono() + " Entity  期待値：null");
            }

            ansyuKihon = hozenDomManager.getAnsyuKihon(syono);
            if (ansyuKihon != null) {
                fail("【案内収納基本エンティティ (デタッチ後)】[期待値違反] 検証値：" + ansyuKihon.getSyono() + " Entity  期待値：null");
            }

            skKihonList = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(syono,C_SeikyuuSyubetu.SBKRUKTK,C_UmuKbn.NONE);
            if (skKihonList.size() != 0) {
                fail("【請求基本エンティティ (デタッチ後)】[期待値違反] 検証値：" + skKihonList.get(0).getSyono() + " Entity  期待値：null");
            }
        }

    }

    @Test
    @TestOrder(580)
    @Transactional
    public void testExec_A58() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khyendthnkuktknini");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(590)
    @Transactional
    public void testExec_A59() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khpminyuusyoumetu");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(600)
    @Transactional
    public void testExec_A60() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khsaikokutuutisks");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(610)
    @Transactional
    public void testExec_A61() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khsiteidairitokuyakuhuka");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(620)
    @Transactional
    public void testExec_A62() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khkzktrkkykdrhnk");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.TYUUITRATKIKA, "有効状態チェック結果区分");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageIDList().size(), 1 ,"ワーニングメッセージIDリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageIDList().get(0), "KBC0001", "1件目");
        exNumericEquals(checkYuukouJyoutai.getWarningMessageList().size(), 1 ,"ワーニングメッセージリストサイズ");
        exStringEquals(checkYuukouJyoutai.getWarningMessageList().get(0), "死亡仮受付中の契約です。", "1件目");
    }

    @Test
    @TestOrder(630)
    @Transactional
    public void testExec_A63() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khcreditmisyuuinfosel");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(640)
    @Transactional
    public void testExec_A64() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khuriageseikyuusel");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(650)
    @Transactional
    public void testExec_A65() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khbatchmkhgkhenkou");
        pUiBean.setSyono("11807111174");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(660)
    @Transactional
    public void testExec_A66() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("dwmkhgkhenkouuketuke");
        pUiBean.setSyono("11807111185");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(670)
    @Transactional
    public void testExec_A67() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khrinjiuriageseikyuuuketuke");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(680)
    @Transactional
    public void testExec_A68() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khkawaseratetuutidatasks");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }

    @Test
    @TestOrder(690)
    @Transactional
    public void testExec_A69() {
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        pKhCp.setFunctionId("khdirectmaildatasel");
        pUiBean.setSyono("11807111118");

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhCp, pUiBean);

        exClassificationEquals(yuukoujyotaichkKbn, C_YuukoujyotaichkKbn.HUKA, "有効状態チェック結果区分");
        exStringEquals(checkYuukouJyoutai.getErrorMessage(), "死亡仮受付中の", "エラーメッセージ");
    }


}
