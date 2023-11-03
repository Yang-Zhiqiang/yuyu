package yuyu.common.sinkeiyaku.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
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
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzProcessForwardForBatch;
import yuyu.common.biz.koutei.BzProcessForwardForBatchInBean;
import yuyu.common.biz.koutei.BzProcessForwardForBatchMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SkProcessForwardYuukoukikanKeikaHanteiクラスのメソッド {@link SkProcessForwardYuukoukikanKeikaHantei#exec(List<SkProcessForwardForBatchInBean>)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessForwardYuukoukikanKeikaHanteiTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書_新契約工程遷移（有効期間経過契約判定処理）";

    private final static String sheetName = "テストデータ";

    @Inject
    private SkProcessForwardYuukoukikanKeikaHantei skProcessForwardYuukoukikanKeikaHantei;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
                bind(BzProcessForwardForBatch.class).to(BzProcessForwardForBatchMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessForwardYuukoukikanKeikaHanteiTest_exec.class;
        BzProcessForwardForBatchMockForSinkeiyaku.caller = SkProcessForwardYuukoukikanKeikaHanteiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzProcessForwardForBatchMockForSinkeiyaku.caller = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkProcessForwardHenkinNyuuryokuTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardForBatchMockForSinkeiyaku.SYORIPTN = BzProcessForwardForBatchMockForSinkeiyaku.TESTPATTERN1;

        List<SkProcessForwardForBatchInBean> skProcessForwardForBatchInBeanlst = new ArrayList<>();

        skProcessForwardYuukoukikanKeikaHantei.exec(skProcessForwardForBatchInBeanlst);

        MockObjectManager.assertCalled(BzProcessForwardForBatchMockForSinkeiyaku.class, "exec");

        List<BzProcessForwardForBatchInBean>  bzProcessForwardForBatchInBeanLst = (List<BzProcessForwardForBatchInBean>)
            MockObjectManager.getArgument(BzProcessForwardForBatchMockForSinkeiyaku.class, "exec", 0);

        exNumericEquals(bzProcessForwardForBatchInBeanLst.size(), 0, "業務共通工程遷移（バッチ用）入力Beanリスト");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardForBatchMockForSinkeiyaku.SYORIPTN = BzProcessForwardForBatchMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("860000017");

        List<SkProcessForwardForBatchInBean> skProcessForwardForBatchInBeanlst = new ArrayList<>();
        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);

        skProcessForwardForBatchInBean.setHtSyoriCTL(syoriCTL1);
        skProcessForwardForBatchInBean.setTskNm("sinkeiyakuBatch11");
        skProcessForwardForBatchInBean.setSyoriComment("有効期間経過契約判定処理11");

        skProcessForwardForBatchInBeanlst.add(skProcessForwardForBatchInBean);

        skProcessForwardYuukoukikanKeikaHantei.exec(skProcessForwardForBatchInBeanlst);

        List<BzProcessForwardForBatchInBean>  bzProcessForwardForBatchInBeanLst = (List<BzProcessForwardForBatchInBean>)
            MockObjectManager.getArgument(BzProcessForwardForBatchMockForSinkeiyaku.class, "exec", 0);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000017", "申込番号");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean1 = bzProcessForwardForBatchInBeanLst.get(0);

        exStringEquals(bzProcessForwardForBatchInBean1.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBean1.getSyoriComment(), "有効期間経過契約判定処理11", "処理コメント");
        exStringEquals(bzProcessForwardForBatchInBean1.getTaskNm(), "sinkeiyakuBatch11", "タスク名");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardForBatchInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), "860000017", "申込番号");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean2 = bzProcessForwardForBatchInBeanLst.get(1);

        exStringEquals(bzProcessForwardForBatchInBean2.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");

        SkInputKokutiRuleBean skInputKokutiRuleBean = (SkInputKokutiRuleBean)bzProcessForwardForBatchInBean2.getIwfApiRuleBean();
        exStringEquals(skInputKokutiRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skInputKokutiRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skInputKokutiRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skInputKokutiRuleBean.getMosuketukeKbn(), C_MosUketukeKbn.MOSKIT.getContent(), "申込受付区分");
        exStringEquals(skInputKokutiRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skInputKokutiRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "860000017", "申込番号");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean3 = bzProcessForwardForBatchInBeanLst.get(2);

        exStringEquals(bzProcessForwardForBatchInBean3.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");

        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardForBatchInBean3.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), "860000017", "申込番号");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean4 = bzProcessForwardForBatchInBeanLst.get(3);

        exStringEquals(bzProcessForwardForBatchInBean4.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardForBatchInBean4.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIZUMI.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.HANEIMATI.getContent(), "ＬＩＮＣ状況区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);

        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "860000017", "申込番号");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean5 = bzProcessForwardForBatchInBeanLst.get(4);

        exStringEquals(bzProcessForwardForBatchInBean5.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardForBatchInBean5.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);

        exStringEquals(bzGetProcessSummaryInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean6.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean6.getMosNo(), "860000017", "申込番号");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean6 = bzProcessForwardForBatchInBeanLst.get(5);

        exStringEquals(bzProcessForwardForBatchInBean6.getKouteiKanriId(), "1006", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardForBatchInBean6.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.BLNK.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 6, 0);

        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "860000017", "申込番号");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean7 = bzProcessForwardForBatchInBeanLst.get(6);

        exStringEquals(bzProcessForwardForBatchInBean7.getKouteiKanriId(), "1007", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean7.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");

        SkHubiKaisyouRuleBean skHubiKaisyouRuleBean = (SkHubiKaisyouRuleBean)bzProcessForwardForBatchInBean7.getIwfApiRuleBean();
        exStringEquals(skHubiKaisyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiKaisyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiKaisyouRuleBean.getHubikaisyoujoutaiKbn(), C_HubikaisyoujoutaiKbn.HUBIKAITOUMATI.getContent(), "不備解消状態区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean8 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 7, 0);

        exStringEquals(bzGetProcessSummaryInBean8.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean8.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean8.getMosNo(), "860000017", "申込番号");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean8 = bzProcessForwardForBatchInBeanLst.get(7);

        exStringEquals(bzProcessForwardForBatchInBean8.getKouteiKanriId(), "1008", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean8.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN, "事務手続コード");

        SkKeiyakukakuninRuleBean skKeiyakukakuninRuleBean = (SkKeiyakukakuninRuleBean)bzProcessForwardForBatchInBean8.getIwfApiRuleBean();
        exStringEquals(skKeiyakukakuninRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKykkakjkKbn(), C_KykkakjkKbn.KETMAE_KAKUNIN.getContent(), "契約確認状況区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean9 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 8, 0);

        exStringEquals(bzGetProcessSummaryInBean9.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean9.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean9.getMosNo(), "860000017", "申込番号");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean9 = bzProcessForwardForBatchInBeanLst.get(8);

        exStringEquals(bzProcessForwardForBatchInBean9.getKouteiKanriId(), "1009", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean9.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI, "事務手続コード");

        SkTorikesiRuleBean skTorikesiRuleBean = (SkTorikesiRuleBean)bzProcessForwardForBatchInBean9.getIwfApiRuleBean();
        exStringEquals(skTorikesiRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardForBatchMockForSinkeiyaku.SYORIPTN = BzProcessForwardForBatchMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("860000025");
        HT_SyoriCTL syoriCTL2 = sinkeiyakuDomManager.getSyoriCTL("860000033");
        HT_SyoriCTL syoriCTL3 = sinkeiyakuDomManager.getSyoriCTL("860000041");
        HT_SyoriCTL syoriCTL4 = sinkeiyakuDomManager.getSyoriCTL("860000058");

        List<SkProcessForwardForBatchInBean> skProcessForwardForBatchInBeanlst = new ArrayList<>();
        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean1 = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);

        skProcessForwardForBatchInBean1.setHtSyoriCTL(syoriCTL1);
        skProcessForwardForBatchInBean1.setTskNm("sinkeiyakuBatch21");
        skProcessForwardForBatchInBean1.setSyoriComment("有効期間経過契約判定処理21");

        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean2 = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);

        skProcessForwardForBatchInBean2.setHtSyoriCTL(syoriCTL2);
        skProcessForwardForBatchInBean2.setTskNm("sinkeiyakuBatch22");
        skProcessForwardForBatchInBean2.setSyoriComment("有効期間経過契約判定処理22");

        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean3 = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);

        skProcessForwardForBatchInBean3.setHtSyoriCTL(syoriCTL3);
        skProcessForwardForBatchInBean3.setTskNm("sinkeiyakuBatch23");
        skProcessForwardForBatchInBean3.setSyoriComment("有効期間経過契約判定処理23");

        SkProcessForwardForBatchInBean skProcessForwardForBatchInBean4 = SWAKInjector
            .getInstance(SkProcessForwardForBatchInBean.class);

        skProcessForwardForBatchInBean4.setHtSyoriCTL(syoriCTL4);
        skProcessForwardForBatchInBean4.setTskNm("sinkeiyakuBatch24");
        skProcessForwardForBatchInBean4.setSyoriComment("有効期間経過契約判定処理24");

        skProcessForwardForBatchInBeanlst.add(skProcessForwardForBatchInBean1);
        skProcessForwardForBatchInBeanlst.add(skProcessForwardForBatchInBean2);
        skProcessForwardForBatchInBeanlst.add(skProcessForwardForBatchInBean3);
        skProcessForwardForBatchInBeanlst.add(skProcessForwardForBatchInBean4);

        skProcessForwardYuukoukikanKeikaHantei.exec(skProcessForwardForBatchInBeanlst);

        List<BzProcessForwardForBatchInBean>  bzProcessForwardForBatchInBeanLst = (List<BzProcessForwardForBatchInBean>)
            MockObjectManager.getArgument(BzProcessForwardForBatchMockForSinkeiyaku.class, "exec", 0);

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean1 = bzProcessForwardForBatchInBeanLst.get(0);

        exStringEquals(bzProcessForwardForBatchInBean1.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBean1.getSyoriComment(), "有効期間経過契約判定処理21", "処理コメント");
        exStringEquals(bzProcessForwardForBatchInBean1.getTaskNm(), "sinkeiyakuBatch21", "タスク名");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardForBatchInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean2 = bzProcessForwardForBatchInBeanLst.get(1);

        exStringEquals(bzProcessForwardForBatchInBean2.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");

        SkInputKokutiRuleBean skInputKokutiRuleBean = (SkInputKokutiRuleBean)bzProcessForwardForBatchInBean2.getIwfApiRuleBean();
        exStringEquals(skInputKokutiRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skInputKokutiRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skInputKokutiRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skInputKokutiRuleBean.getMosuketukeKbn(), C_MosUketukeKbn.MOSKIT.getContent(), "申込受付区分");
        exStringEquals(skInputKokutiRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skInputKokutiRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean3 = bzProcessForwardForBatchInBeanLst.get(2);

        exStringEquals(bzProcessForwardForBatchInBean3.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");

        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardForBatchInBean3.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean4 = bzProcessForwardForBatchInBeanLst.get(3);

        exStringEquals(bzProcessForwardForBatchInBean4.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardForBatchInBean4.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIZUMI.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.HANEIMATI.getContent(), "ＬＩＮＣ状況区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean5 = bzProcessForwardForBatchInBeanLst.get(4);

        exStringEquals(bzProcessForwardForBatchInBean5.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardForBatchInBean5.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean6 = bzProcessForwardForBatchInBeanLst.get(5);

        exStringEquals(bzProcessForwardForBatchInBean6.getKouteiKanriId(), "1006", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardForBatchInBean6.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.BLNK.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean7 = bzProcessForwardForBatchInBeanLst.get(6);

        exStringEquals(bzProcessForwardForBatchInBean7.getKouteiKanriId(), "1007", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean7.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");

        SkHubiKaisyouRuleBean skHubiKaisyouRuleBean = (SkHubiKaisyouRuleBean)bzProcessForwardForBatchInBean7.getIwfApiRuleBean();
        exStringEquals(skHubiKaisyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiKaisyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiKaisyouRuleBean.getHubikaisyoujoutaiKbn(), C_HubikaisyoujoutaiKbn.HUBIKAITOUMATI.getContent(), "不備解消状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean8 = bzProcessForwardForBatchInBeanLst.get(7);

        exStringEquals(bzProcessForwardForBatchInBean8.getKouteiKanriId(), "1008", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean8.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN, "事務手続コード");

        SkKeiyakukakuninRuleBean skKeiyakukakuninRuleBean = (SkKeiyakukakuninRuleBean)bzProcessForwardForBatchInBean8.getIwfApiRuleBean();
        exStringEquals(skKeiyakukakuninRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKykkakjkKbn(), C_KykkakjkKbn.KETMAE_KAKUNIN.getContent(), "契約確認状況区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean9 = bzProcessForwardForBatchInBeanLst.get(8);

        exStringEquals(bzProcessForwardForBatchInBean9.getKouteiKanriId(), "1009", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean9.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI, "事務手続コード");

        SkTorikesiRuleBean skTorikesiRuleBean = (SkTorikesiRuleBean)bzProcessForwardForBatchInBean9.getIwfApiRuleBean();
        exStringEquals(skTorikesiRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean10 = bzProcessForwardForBatchInBeanLst.get(9);

        exStringEquals(bzProcessForwardForBatchInBean10.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean10.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBean10.getSyoriComment(), "有効期間経過契約判定処理22", "処理コメント");
        exStringEquals(bzProcessForwardForBatchInBean10.getTaskNm(), "sinkeiyakuBatch22", "タスク名");

        skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardForBatchInBean10.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean11 = bzProcessForwardForBatchInBeanLst.get(10);

        exStringEquals(bzProcessForwardForBatchInBean11.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean11.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");

        skInputKokutiRuleBean = (SkInputKokutiRuleBean)bzProcessForwardForBatchInBean11.getIwfApiRuleBean();
        exStringEquals(skInputKokutiRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skInputKokutiRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skInputKokutiRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skInputKokutiRuleBean.getMosuketukeKbn(), C_MosUketukeKbn.SEIHOWEB.getContent(), "申込受付区分");
        exStringEquals(skInputKokutiRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skInputKokutiRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean12 = bzProcessForwardForBatchInBeanLst.get(11);

        exStringEquals(bzProcessForwardForBatchInBean12.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean12.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");

        skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardForBatchInBean12.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean13 = bzProcessForwardForBatchInBeanLst.get(12);

        exStringEquals(bzProcessForwardForBatchInBean13.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean13.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");

        skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardForBatchInBean13.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIZUMI.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAI.getContent(), "ＬＩＮＣ状況区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean14 = bzProcessForwardForBatchInBeanLst.get(13);

        exStringEquals(bzProcessForwardForBatchInBean14.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean14.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");

        skImuRuleBean = (SkImuRuleBean)bzProcessForwardForBatchInBean14.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean15 = bzProcessForwardForBatchInBeanLst.get(14);

        exStringEquals(bzProcessForwardForBatchInBean15.getKouteiKanriId(), "1006", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean15.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");

        skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardForBatchInBean15.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.BLNK.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean16 = bzProcessForwardForBatchInBeanLst.get(15);

        exStringEquals(bzProcessForwardForBatchInBean16.getKouteiKanriId(), "1007", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean16.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");

        skHubiKaisyouRuleBean = (SkHubiKaisyouRuleBean)bzProcessForwardForBatchInBean16.getIwfApiRuleBean();
        exStringEquals(skHubiKaisyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiKaisyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiKaisyouRuleBean.getHubikaisyoujoutaiKbn(), C_HubikaisyoujoutaiKbn.HUBIKAITOUMATI.getContent(), "不備解消状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean17 = bzProcessForwardForBatchInBeanLst.get(16);

        exStringEquals(bzProcessForwardForBatchInBean17.getKouteiKanriId(), "1008", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean17.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN, "事務手続コード");

        skKeiyakukakuninRuleBean = (SkKeiyakukakuninRuleBean)bzProcessForwardForBatchInBean17.getIwfApiRuleBean();
        exStringEquals(skKeiyakukakuninRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKykkakjkKbn(), C_KykkakjkKbn.KETMAE_KAKUNIN.getContent(), "契約確認状況区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean18 = bzProcessForwardForBatchInBeanLst.get(17);

        exStringEquals(bzProcessForwardForBatchInBean18.getKouteiKanriId(), "1009", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean18.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI, "事務手続コード");

        skTorikesiRuleBean = (SkTorikesiRuleBean)bzProcessForwardForBatchInBean18.getIwfApiRuleBean();
        exStringEquals(skTorikesiRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean19 = bzProcessForwardForBatchInBeanLst.get(18);

        exStringEquals(bzProcessForwardForBatchInBean19.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean19.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBean19.getSyoriComment(), "有効期間経過契約判定処理23", "処理コメント");
        exStringEquals(bzProcessForwardForBatchInBean19.getTaskNm(), "sinkeiyakuBatch23", "タスク名");

        skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardForBatchInBean19.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean20 = bzProcessForwardForBatchInBeanLst.get(19);

        exStringEquals(bzProcessForwardForBatchInBean20.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean20.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");

        skInputKokutiRuleBean = (SkInputKokutiRuleBean)bzProcessForwardForBatchInBean20.getIwfApiRuleBean();
        exStringEquals(skInputKokutiRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skInputKokutiRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skInputKokutiRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skInputKokutiRuleBean.getMosuketukeKbn(), C_MosUketukeKbn.PAPERLESS.getContent(), "申込受付区分");
        exStringEquals(skInputKokutiRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skInputKokutiRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean21 = bzProcessForwardForBatchInBeanLst.get(20);

        exStringEquals(bzProcessForwardForBatchInBean21.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean21.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");

        skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardForBatchInBean21.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean22 = bzProcessForwardForBatchInBeanLst.get(21);

        exStringEquals(bzProcessForwardForBatchInBean22.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean22.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");

        skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardForBatchInBean22.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIZUMI.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAI.getContent(), "ＬＩＮＣ状況区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean23 = bzProcessForwardForBatchInBeanLst.get(22);

        exStringEquals(bzProcessForwardForBatchInBean23.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean23.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");

        skImuRuleBean = (SkImuRuleBean)bzProcessForwardForBatchInBean23.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean24= bzProcessForwardForBatchInBeanLst.get(23);

        exStringEquals(bzProcessForwardForBatchInBean24.getKouteiKanriId(), "1006", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean24.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");

        skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardForBatchInBean24.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.BLNK.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean25 = bzProcessForwardForBatchInBeanLst.get(24);

        exStringEquals(bzProcessForwardForBatchInBean25.getKouteiKanriId(), "1007", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean25.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");

        skHubiKaisyouRuleBean = (SkHubiKaisyouRuleBean)bzProcessForwardForBatchInBean25.getIwfApiRuleBean();
        exStringEquals(skHubiKaisyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiKaisyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiKaisyouRuleBean.getHubikaisyoujoutaiKbn(), C_HubikaisyoujoutaiKbn.HUBIKAITOUMATI.getContent(), "不備解消状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean26 = bzProcessForwardForBatchInBeanLst.get(25);

        exStringEquals(bzProcessForwardForBatchInBean26.getKouteiKanriId(), "1008", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean26.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN, "事務手続コード");

        skKeiyakukakuninRuleBean = (SkKeiyakukakuninRuleBean)bzProcessForwardForBatchInBean26.getIwfApiRuleBean();
        exStringEquals(skKeiyakukakuninRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKykkakjkKbn(), C_KykkakjkKbn.KETMAE_KAKUNIN.getContent(), "契約確認状況区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean27 = bzProcessForwardForBatchInBeanLst.get(26);

        exStringEquals(bzProcessForwardForBatchInBean27.getKouteiKanriId(), "1009", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean27.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI, "事務手続コード");

        skTorikesiRuleBean = (SkTorikesiRuleBean)bzProcessForwardForBatchInBean27.getIwfApiRuleBean();
        exStringEquals(skTorikesiRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean28 = bzProcessForwardForBatchInBeanLst.get(27);

        exStringEquals(bzProcessForwardForBatchInBean28.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean28.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardForBatchInBean28.getSyoriComment(), "有効期間経過契約判定処理24", "処理コメント");
        exStringEquals(bzProcessForwardForBatchInBean28.getTaskNm(), "sinkeiyakuBatch24", "タスク名");

        skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardForBatchInBean28.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean29 = bzProcessForwardForBatchInBeanLst.get(28);

        exStringEquals(bzProcessForwardForBatchInBean29.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean29.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");

        skInputKokutiRuleBean = (SkInputKokutiRuleBean)bzProcessForwardForBatchInBean29.getIwfApiRuleBean();
        exStringEquals(skInputKokutiRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skInputKokutiRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skInputKokutiRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skInputKokutiRuleBean.getMosuketukeKbn(), C_MosUketukeKbn.SIRYOUSEIKYUU.getContent(), "申込受付区分");
        exStringEquals(skInputKokutiRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skInputKokutiRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean30 = bzProcessForwardForBatchInBeanLst.get(29);

        exStringEquals(bzProcessForwardForBatchInBean30.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean30.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");

        skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardForBatchInBean30.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.KKT.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean31 = bzProcessForwardForBatchInBeanLst.get(30);

        exStringEquals(bzProcessForwardForBatchInBean31.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean31.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");

        skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardForBatchInBean31.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIZUMI.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAI.getContent(), "ＬＩＮＣ状況区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean32 = bzProcessForwardForBatchInBeanLst.get(31);

        exStringEquals(bzProcessForwardForBatchInBean32.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean32.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");

        skImuRuleBean = (SkImuRuleBean)bzProcessForwardForBatchInBean32.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean33= bzProcessForwardForBatchInBeanLst.get(32);

        exStringEquals(bzProcessForwardForBatchInBean33.getKouteiKanriId(), "1006", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean33.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");

        skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardForBatchInBean33.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.BLNK.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean34 = bzProcessForwardForBatchInBeanLst.get(33);

        exStringEquals(bzProcessForwardForBatchInBean34.getKouteiKanriId(), "1007", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean34.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");

        skHubiKaisyouRuleBean = (SkHubiKaisyouRuleBean)bzProcessForwardForBatchInBean34.getIwfApiRuleBean();
        exStringEquals(skHubiKaisyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiKaisyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiKaisyouRuleBean.getHubikaisyoujoutaiKbn(), C_HubikaisyoujoutaiKbn.HUBIKAITOUMATI.getContent(), "不備解消状態区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean35 = bzProcessForwardForBatchInBeanLst.get(34);

        exStringEquals(bzProcessForwardForBatchInBean35.getKouteiKanriId(), "1008", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean35.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN, "事務手続コード");

        skKeiyakukakuninRuleBean = (SkKeiyakukakuninRuleBean)bzProcessForwardForBatchInBean35.getIwfApiRuleBean();
        exStringEquals(skKeiyakukakuninRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKykkakjkKbn(), C_KykkakjkKbn.KETMAE_KAKUNIN.getContent(), "契約確認状況区分");

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean36 = bzProcessForwardForBatchInBeanLst.get(35);

        exStringEquals(bzProcessForwardForBatchInBean36.getKouteiKanriId(), "1009", "工程管理ID");
        exStringEquals(bzProcessForwardForBatchInBean36.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI, "事務手続コード");

        skTorikesiRuleBean = (SkTorikesiRuleBean)bzProcessForwardForBatchInBean36.getIwfApiRuleBean();
        exStringEquals(skTorikesiRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");

    }
}
