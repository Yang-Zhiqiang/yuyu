package yuyu.common.sinkeiyaku.koutei;

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

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzOutputProcessRecordMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzProcessForward;
import yuyu.common.biz.koutei.BzProcessForwardInBean;
import yuyu.common.biz.koutei.BzProcessForwardMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 新契約工程遷移（ペーパーレス申込入力）のメソッド {@link SkProcessForwardPaperlessMousikomi#kouteiSeni(SkProcessForwardInBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessForwardPaperlessMousikomiTest_kouteiSeni {

    @Inject
    private SkProcessForwardPaperlessMousikomi skProcessForwardPaperlessMousikomi;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約工程遷移（ペーパーレス申込入力）";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkProcessForwardPaperlessMousikomiTest_kouteiSeni.class, fileName, sheetName);
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

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
                bind(BzProcessForward.class).to(BzProcessForwardMockForSinkeiyaku.class);
                bind(BzOutputProcessRecord.class).to(BzOutputProcessRecordMockForSinkeiyaku.class);
                bind(SkProcessForwardMoschkExec.class).to(SkProcessForwardMoschkExecMockForSinkeiyaku.class);

            }
        });
    }
    @BeforeClass
    public static void testInit() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessForwardPaperlessMousikomiTest_kouteiSeni.class;
        BzProcessForwardMockForSinkeiyaku.caller = SkProcessForwardPaperlessMousikomiTest_kouteiSeni.class;
        BzOutputProcessRecordMockForSinkeiyaku.caller = SkProcessForwardPaperlessMousikomiTest_kouteiSeni.class;
        SkProcessForwardMoschkExecMockForSinkeiyaku.caller = SkProcessForwardPaperlessMousikomiTest_kouteiSeni.class;
    }

    @AfterClass
    public static void testClear() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = null;
        BzProcessForwardMockForSinkeiyaku.caller = null;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = null;
        BzOutputProcessRecordMockForSinkeiyaku.caller = null;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = null;
        SkProcessForwardMoschkExecMockForSinkeiyaku.caller = null;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testKouteiSeni_A1() {

        MockObjectManager.initialize();

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("791112220");
        skProcessForwardInBean.setKouteiLockkey("testKouteiLockKey");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.HUBI);
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.HORYUU);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setSyoriComment("コメント");
        skProcessForwardPaperlessMousikomi.kouteiSeni(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112220", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSrhhbKbn(), C_UmuKbn.NONE.getContent(), "成立保留不備区分");
        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTMOS, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "791112220", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean1 = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTMOS, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
        SkInputMosRuleBean skInputMosRuleBean = (SkInputMosRuleBean) bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skInputMosRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skInputMosRuleBean.getMosuketukeKbn(), C_MosUketukeKbn.DIRECT.getContent(), "申込受付区分");
        exStringEquals(skInputMosRuleBean.getMosnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "申込書入力ベリファイ状況区分");
        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.HUBI, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), "791112220", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
        SkInputKokutiRuleBean skInputKokutiRuleBean = (SkInputKokutiRuleBean) bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skInputKokutiRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skInputKokutiRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skInputKokutiRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skInputKokutiRuleBean.getMosuketukeKbn(), C_MosUketukeKbn.DIRECT.getContent(), "申込受付区分");
        exStringEquals(skInputKokutiRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skInputKokutiRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "791112220", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean) bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), "791112220", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean4 = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean) bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAI.getContent(), "ＬＩＮＣ状況区分");
        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.HORYUU, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "791112220", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean5 = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzProcessForwardInBean5.getKouteiKanriId(), "1006", "工程管理ID");
        exStringEquals(bzProcessForwardInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean5.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
        SkImuRuleBean skImuRuleBean = (SkImuRuleBean) bzProcessForwardInBean5.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exClassificationEquals(bzProcessForwardInBean5.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean5.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 6, 0);
        exStringEquals(bzGetProcessSummaryInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean6.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean6.getMosNo(), "791112220", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean6 = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 6, 0);
        exStringEquals(bzProcessForwardInBean6.getKouteiKanriId(), "1007", "工程管理ID");
        exStringEquals(bzProcessForwardInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean6.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean) bzProcessForwardInBean6.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送区分");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.ARI.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exClassificationEquals(bzProcessForwardInBean6.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean6.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 7, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "791112220", "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.HUBI, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardMoschkExecMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), "791112220", "申込番号");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "testKouteiLockKey", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.HUBI, "処理結果区分");
        exClassificationEquals(skProcessForwardInBean1.getKnksateikekkaKbn(), C_SyorikekkaKbn.HORYUU, "環境査定結果区分");
        exClassificationEquals(skProcessForwardInBean1.getHubihassintnsKbn(), C_HubihassintnsKbn.ARI, "不備発信転送区分");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "工程", "タスク名");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "コメント", "処理コメント");

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testKouteiSeni_A2() {

        MockObjectManager.initialize();

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("791112238");
        skProcessForwardInBean.setKouteiLockkey("testKouteiLockKey1");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.HUBI);
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.HORYUU);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);
        skProcessForwardPaperlessMousikomi.kouteiSeni(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), "791112238", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean4 = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "testKouteiLockKey1", "工程ロックキー");
        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean) bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.HANEIMATI.getContent(), "ＬＩＮＣ状況区分");
        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.HORYUU, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "791112238", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean5 = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzProcessForwardInBean5.getKouteiKanriId(), "1006", "工程管理ID");
        exStringEquals(bzProcessForwardInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean5.getKouteiLockKey(), "testKouteiLockKey1", "工程ロックキー");
        SkImuRuleBean skImuRuleBean = (SkImuRuleBean) bzProcessForwardInBean5.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");
        exClassificationEquals(bzProcessForwardInBean5.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean5.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 6, 0);
        exStringEquals(bzGetProcessSummaryInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean6.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean6.getMosNo(), "791112238", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean6 = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 6, 0);
        exStringEquals(bzProcessForwardInBean6.getKouteiKanriId(), "1007", "工程管理ID");
        exStringEquals(bzProcessForwardInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean6.getKouteiLockKey(), "testKouteiLockKey1", "工程ロックキー");
        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean) bzProcessForwardInBean6.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送区分");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");
        exClassificationEquals(bzProcessForwardInBean6.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean6.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 7, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "791112238", "申込番号");

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testKouteiSeni_A3() {

        MockObjectManager.initialize();

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("791112246");
        skProcessForwardInBean.setKouteiLockkey("testKouteiLockKey2");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.HUBI);
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.HORYUU);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);
        skProcessForwardPaperlessMousikomi.kouteiSeni(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), "791112246", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean4 = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "testKouteiLockKey2", "工程ロックキー");
        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean) bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAI.getContent(), "ＬＩＮＣ状況区分");
        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.HORYUU, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "791112246", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean5 = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzProcessForwardInBean5.getKouteiKanriId(), "1006", "工程管理ID");
        exStringEquals(bzProcessForwardInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean5.getKouteiLockKey(), "testKouteiLockKey2", "工程ロックキー");
        SkImuRuleBean skImuRuleBean = (SkImuRuleBean) bzProcessForwardInBean5.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");
        exClassificationEquals(bzProcessForwardInBean5.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean5.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 6, 0);
        exStringEquals(bzGetProcessSummaryInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean6.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean6.getMosNo(), "791112246", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean6 = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 6, 0);
        exStringEquals(bzProcessForwardInBean6.getKouteiKanriId(), "1007", "工程管理ID");
        exStringEquals(bzProcessForwardInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean6.getKouteiLockKey(), "testKouteiLockKey2", "工程ロックキー");
        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean) bzProcessForwardInBean6.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送区分");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");
        exClassificationEquals(bzProcessForwardInBean6.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean6.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 7, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "791112246", "申込番号");

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testKouteiSeni_A4() {

        MockObjectManager.initialize();

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("791112253");
        skProcessForwardInBean.setKouteiLockkey("testKouteiLockKey3");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.HUBI);
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.HORYUU);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);
        skProcessForwardPaperlessMousikomi.kouteiSeni(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), "791112253", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean4 = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "testKouteiLockKey3", "工程ロックキー");
        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean) bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAI.getContent(), "ＬＩＮＣ状況区分");
        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.HORYUU, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "791112253", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean5 = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzProcessForwardInBean5.getKouteiKanriId(), "1006", "工程管理ID");
        exStringEquals(bzProcessForwardInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean5.getKouteiLockKey(), "testKouteiLockKey3", "工程ロックキー");
        SkImuRuleBean skImuRuleBean = (SkImuRuleBean) bzProcessForwardInBean5.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exClassificationEquals(bzProcessForwardInBean5.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean5.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 6, 0);
        exStringEquals(bzGetProcessSummaryInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean6.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean6.getMosNo(), "791112253", "申込番号");
        BzProcessForwardInBean bzProcessForwardInBean6 = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMockForSinkeiyaku.class, "exec", 6, 0);
        exStringEquals(bzProcessForwardInBean6.getKouteiKanriId(), "1007", "工程管理ID");
        exStringEquals(bzProcessForwardInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "入力Beanの事務手続コード");
        exStringEquals(bzProcessForwardInBean6.getKouteiLockKey(), "testKouteiLockKey3", "工程ロックキー");
        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean) bzProcessForwardInBean6.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_1.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送区分");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.ARI.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exClassificationEquals(bzProcessForwardInBean6.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean6.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 7, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), "791112253", "申込番号");

    }

}
