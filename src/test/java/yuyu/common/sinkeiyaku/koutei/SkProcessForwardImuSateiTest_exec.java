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
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SkProcessForwardImuSateiクラスのメソッド {@link SkProcessForwardImuSatei#exec(SkProcessForwardInBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessForwardImuSateiTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書_新契約工程遷移（医務査定）";

    private final static String sheetName = "テストデータ";

    @Inject
    private SkProcessForwardImuSatei skProcessForwardImuSatei;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
                bind(BzProcessForward.class).to(BzProcessForwardMockForSinkeiyaku.class);
                bind(BzOutputProcessRecord.class).to(BzOutputProcessRecordMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessForwardImuSateiTest_exec.class;
        BzProcessForwardMockForSinkeiyaku.caller = SkProcessForwardImuSateiTest_exec.class;
        BzOutputProcessRecordMockForSinkeiyaku.caller = SkProcessForwardImuSateiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN =null;
        BzProcessForwardMockForSinkeiyaku.caller = null;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN =null;
        BzOutputProcessRecordMockForSinkeiyaku.caller = null;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = null;
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
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000017");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardImuSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000017", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "5101", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000017", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "5102", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIMATI_KANI_UW.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000017", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean21 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzProcessForwardInBean21.getKouteiKanriId(), "5112", "工程管理ID");
        exStringEquals(bzProcessForwardInBean21.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exStringEquals(bzProcessForwardInBean21.getKouteiLockKey(), "10", "工程ロックキー");

        SkInputKokutiRuleBean skInputKokutiRuleBean = (SkInputKokutiRuleBean)bzProcessForwardInBean21.getIwfApiRuleBean();
        exStringEquals(skInputKokutiRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skInputKokutiRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skInputKokutiRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skInputKokutiRuleBean.getMosuketukeKbn(), C_MosUketukeKbn.MOSKIT.getContent(), "申込受付区分");
        exStringEquals(skInputKokutiRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skInputKokutiRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");

        exClassificationEquals(bzProcessForwardInBean21.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean21.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000017", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "5103", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI.getContent(), "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000017", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);

        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "5104", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.ARI.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000017", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean5 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 5, 0);

        exStringEquals(bzProcessForwardInBean5.getKouteiKanriId(), "5105", "工程管理ID");
        exStringEquals(bzProcessForwardInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean5.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiKaisyouRuleBean skHubiKaisyouRuleBean = (SkHubiKaisyouRuleBean)bzProcessForwardInBean5.getIwfApiRuleBean();
        exStringEquals(skHubiKaisyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiKaisyouRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiKaisyouRuleBean.getHubikaisyoujoutaiKbn(), C_HubikaisyoujoutaiKbn.HUBIKAISYOUZUMI.getContent(), "不備解消状態区分");

        exClassificationEquals(bzProcessForwardInBean5.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean5.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 6, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(),  ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000017", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean6 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 6, 0);

        exStringEquals(bzProcessForwardInBean6.getKouteiKanriId(), "5106", "工程管理ID");
        exStringEquals(bzProcessForwardInBean6.getJimuTetuzukiCd(),  ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean6.getKouteiLockKey(), "10", "工程ロックキー");

        SkKeiyakukakuninRuleBean skKeiyakukakuninRuleBean = (SkKeiyakukakuninRuleBean)bzProcessForwardInBean6.getIwfApiRuleBean();
        exStringEquals(skKeiyakukakuninRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKykkakjkKbn(), C_KykkakjkKbn.KETMAE_KAKUNIN.getContent(), "契約確認状況区分");

        exClassificationEquals(bzProcessForwardInBean6.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean6.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 7, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(),  ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000017", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean7 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 7, 0);

        exStringEquals(bzProcessForwardInBean7.getKouteiKanriId(), "5107", "工程管理ID");
        exStringEquals(bzProcessForwardInBean7.getJimuTetuzukiCd(),  ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI, "事務手続コード");
        exStringEquals(bzProcessForwardInBean7.getKouteiLockKey(), "10", "工程ロックキー");

        SkTorikesiRuleBean skTorikesiRuleBean = (SkTorikesiRuleBean)bzProcessForwardInBean7.getIwfApiRuleBean();
        exStringEquals(skTorikesiRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");

        exClassificationEquals(bzProcessForwardInBean7.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean7.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5101", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 =(SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardImuSatei.class, "exec", 0, 0);

        exStringEquals(skProcessForwardInBean1.getMosNo(), "860000017", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "工程", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
        exClassificationEquals(skProcessForwardInBean1.getImusateikekkaKbn(),C_SyorikekkaKbn.TENSOU_IMU_KANIUW , "医務査定結果区分");
        exClassificationEquals(skProcessForwardInBean1.getHubihassintnsKbn(), C_HubihassintnsKbn.ARI, "不備発信転送区分");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000025");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardImuSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000025", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "5101", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000025", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "5102", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIMATI_KANI_UW.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000025", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "5103", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI.getContent(), "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000025", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);

        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "5104", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000025", "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5101", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_B1() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000033");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.IRAI_TENKEN_1);
        skProcessForwardInBean.setMostenkentnsketsyaCd("102");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardImuSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000033", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "5101", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000033", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "5102", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIMATI_KANI_UW.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzProcessForwardInBean bzProcessForwardInBean21 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzProcessForwardInBean21.getKouteiKanriId(), "5108", "工程管理ID");
        exStringEquals(bzProcessForwardInBean21.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean21.getKouteiLockKey(), "10", "工程ロックキー");

        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean21.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");

        exClassificationEquals(bzProcessForwardInBean21.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_TENKEN_1, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean21.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000033", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "5103", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI.getContent(), "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000033", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);

        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "5104", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.ARI.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5101", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_B2() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000041");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.IRAI_TENKEN_2);
        skProcessForwardInBean.setMostenkentnsketsyaCd("102");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardImuSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000041", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "5101", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000041", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "5102", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIMATI_KANI_UW.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzProcessForwardInBean bzProcessForwardInBean21 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzProcessForwardInBean21.getKouteiKanriId(), "5108", "工程管理ID");
        exStringEquals(bzProcessForwardInBean21.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean21.getKouteiLockKey(), "10", "工程ロックキー");

        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean21.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");

        exClassificationEquals(bzProcessForwardInBean21.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_TENKEN_2, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean21.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000041", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "5103", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI.getContent(), "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000041", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);

        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "5104", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5101", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 =(SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardImuSatei.class, "exec", 0, 0);

        exStringEquals(skProcessForwardInBean1.getMosNo(), "860000041", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "工程", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
        exClassificationEquals(skProcessForwardInBean1.getMostenkenkekkaKbn(),C_SyorikekkaKbn.IRAI_TENKEN_2 , "申込点検結果区分");
        exStringEquals(skProcessForwardInBean1.getMostenkentnsketsyaCd(), "102", "申込点検転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getImusateikekkaKbn(),C_SyorikekkaKbn.TENSOU_IMU_KANIUW , "医務査定結果区分");
        exClassificationEquals(skProcessForwardInBean1.getHubihassintnsKbn(), C_HubihassintnsKbn.ARI, "不備発信転送区分");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_B3() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000058");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.IRAI_TENKEN_HUBI);
        skProcessForwardInBean.setMostenkentnsketsyaCd("102");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardImuSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "5101", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "5102", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIMATI_KANI_UW.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzProcessForwardInBean bzProcessForwardInBean21 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzProcessForwardInBean21.getKouteiKanriId(), "5108", "工程管理ID");
        exStringEquals(bzProcessForwardInBean21.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean21.getKouteiLockKey(), "10", "工程ロックキー");

        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean21.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");

        exClassificationEquals(bzProcessForwardInBean21.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_TENKEN_HUBI, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean21.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "5103", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI.getContent(), "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);

        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "5104", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5101", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 =(SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardImuSatei.class, "exec", 0, 0);

        exStringEquals(skProcessForwardInBean1.getMosNo(), "860000058", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "工程", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
        exClassificationEquals(skProcessForwardInBean1.getMostenkenkekkaKbn(),C_SyorikekkaKbn.IRAI_TENKEN_HUBI , "申込点検結果区分");
        exStringEquals(skProcessForwardInBean1.getMostenkentnsketsyaCd(), "102", "申込点検転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getImusateikekkaKbn(),C_SyorikekkaKbn.TENSOU_IMU_KANIUW , "医務査定結果区分");
        exClassificationEquals(skProcessForwardInBean1.getHubihassintnsKbn(), C_HubihassintnsKbn.ARI, "不備発信転送区分");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_B4() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000058");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.IRAI_KANKYOU_1);
        skProcessForwardInBean.setKnktnsketsyaCd("271");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardImuSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "5101", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "5102", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIMATI_KANI_UW.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "5103", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI.getContent(), "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_KANKYOU_1, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "5104", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5101", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 =(SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardImuSatei.class, "exec", 0, 0);

        exStringEquals(skProcessForwardInBean1.getMosNo(), "860000058", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "工程", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
        exClassificationEquals(skProcessForwardInBean1.getKnksateikekkaKbn(), C_SyorikekkaKbn.IRAI_KANKYOU_1 , "環境査定結果区分");
        exStringEquals(skProcessForwardInBean1.getKnktnsketsyaCd(), "271", "環境査定転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getImusateikekkaKbn(),C_SyorikekkaKbn.TENSOU_IMU_KANIUW , "医務査定結果区分");
        exClassificationEquals(skProcessForwardInBean1.getHubihassintnsKbn(), C_HubihassintnsKbn.ARI, "不備発信転送区分");

    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_B5() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000058");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.IRAI_KANKYOU_2A);
        skProcessForwardInBean.setKnktnsketsyaCd("271");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardImuSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "5101", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "5102", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIMATI_KANI_UW.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean3 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "5103", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI.getContent(), "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_KANKYOU_2A, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "5104", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5101", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 =(SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardImuSatei.class, "exec", 0, 0);

        exStringEquals(skProcessForwardInBean1.getMosNo(), "860000058", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "工程", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
        exClassificationEquals(skProcessForwardInBean1.getKnksateikekkaKbn(), C_SyorikekkaKbn.IRAI_KANKYOU_2A , "環境査定結果区分");
        exStringEquals(skProcessForwardInBean1.getKnktnsketsyaCd(), "271", "環境査定転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getImusateikekkaKbn(),C_SyorikekkaKbn.TENSOU_IMU_KANIUW , "医務査定結果区分");
        exClassificationEquals(skProcessForwardInBean1.getHubihassintnsKbn(), C_HubihassintnsKbn.ARI, "不備発信転送区分");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_B6() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000058");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.IRAI_KANKYOU_2B);
        skProcessForwardInBean.setKnktnsketsyaCd("271");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardImuSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "5101", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "5102", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIMATI_KANI_UW.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "5103", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI.getContent(), "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_KANKYOU_2B, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "5104", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5101", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 =(SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardImuSatei.class, "exec", 0, 0);

        exStringEquals(skProcessForwardInBean1.getMosNo(), "860000058", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "工程", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
        exClassificationEquals(skProcessForwardInBean1.getKnksateikekkaKbn(), C_SyorikekkaKbn.IRAI_KANKYOU_2B , "環境査定結果区分");
        exStringEquals(skProcessForwardInBean1.getKnktnsketsyaCd(), "271", "環境査定転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getImusateikekkaKbn(),C_SyorikekkaKbn.TENSOU_IMU_KANIUW , "医務査定結果区分");
        exClassificationEquals(skProcessForwardInBean1.getHubihassintnsKbn(), C_HubihassintnsKbn.ARI, "不備発信転送区分");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_B7() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000058");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardImuSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "5101", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.HJY.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "5102", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIMATI_KANI_UW.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "5104", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5101", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 =(SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardImuSatei.class, "exec", 0, 0);

        exStringEquals(skProcessForwardInBean1.getMosNo(), "860000058", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "工程", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
        exClassificationEquals(skProcessForwardInBean1.getImusateikekkaKbn(),C_SyorikekkaKbn.TENSOU_IMU_KANIUW , "医務査定結果区分");
        exClassificationEquals(skProcessForwardInBean1.getHubihassintnsKbn(), C_HubihassintnsKbn.ARI, "不備発信転送区分");

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_C1() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000066");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.IRAI_KANKYOU_1);
        skProcessForwardInBean.setKnktnsketsyaCd("180");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setImutnsketsyaCd("541");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardImuSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000066", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean2 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "5102", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIMATI_KANI_UW.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000066", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean3 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "5103", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI.getContent(), "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_KANKYOU_1, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000066", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "5104", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5101", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 =(SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardImuSatei.class, "exec", 0, 0);

        exStringEquals(skProcessForwardInBean1.getMosNo(), "860000066", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "工程", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
        exClassificationEquals(skProcessForwardInBean1.getKnksateikekkaKbn(), C_SyorikekkaKbn.IRAI_KANKYOU_1 , "環境査定結果区分");
        exStringEquals(skProcessForwardInBean1.getKnktnsketsyaCd(), "180", "環境査定転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getImusateikekkaKbn(),C_SyorikekkaKbn.TENSOU_IMU_KANIUW , "医務査定結果区分");
        exStringEquals(skProcessForwardInBean1.getImutnsketsyaCd(),"541", "医務査定転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getHubihassintnsKbn(), C_HubihassintnsKbn.ARI, "不備発信転送区分");

    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_C2() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000066");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.IRAI_KANKYOU_2A);
        skProcessForwardInBean.setKnktnsketsyaCd("180");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setImutnsketsyaCd("KYOUYOU");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardImuSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000066", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean2 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "5102", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIMATI_KANI_UW.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000066", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean3 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "5103", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI.getContent(), "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_KANKYOU_2A, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000066", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "5104", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5101", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 =(SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardImuSatei.class, "exec", 0, 0);

        exStringEquals(skProcessForwardInBean1.getMosNo(), "860000066", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "工程", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
        exClassificationEquals(skProcessForwardInBean1.getKnksateikekkaKbn(), C_SyorikekkaKbn.IRAI_KANKYOU_2A , "環境査定結果区分");
        exStringEquals(skProcessForwardInBean1.getKnktnsketsyaCd(), "180", "環境査定転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getImusateikekkaKbn(),C_SyorikekkaKbn.TENSOU_IMU_KANIUW , "医務査定結果区分");
        exStringEquals(skProcessForwardInBean1.getImutnsketsyaCd(),"KYOUYOU", "医務査定転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getHubihassintnsKbn(), C_HubihassintnsKbn.ARI, "不備発信転送区分");

    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_C3() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000066");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIMD);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.IRAI_KANKYOU_2B);
        skProcessForwardInBean.setKnktnsketsyaCd("180");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setImutnsketsyaCd("541");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardImuSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000066", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean2 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "5102", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIMATI_KANI_UW.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000066", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean3 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "5103", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_1.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI.getContent(), "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_KANKYOU_2B, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000066", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "5104", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5101", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.TENSOU_IMU_KANIMD, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 =(SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardImuSatei.class, "exec", 0, 0);

        exStringEquals(skProcessForwardInBean1.getMosNo(), "860000066", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "工程", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIMD, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
        exClassificationEquals(skProcessForwardInBean1.getKnksateikekkaKbn(), C_SyorikekkaKbn.IRAI_KANKYOU_2B , "環境査定結果区分");
        exStringEquals(skProcessForwardInBean1.getKnktnsketsyaCd(), "180", "環境査定転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getImusateikekkaKbn(),C_SyorikekkaKbn.TENSOU_IMU_KANIUW , "医務査定結果区分");
        exStringEquals(skProcessForwardInBean1.getImutnsketsyaCd(),"541", "医務査定転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getHubihassintnsKbn(), C_HubihassintnsKbn.ARI, "不備発信転送区分");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_C4() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000066");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setImutnsketsyaCd("541");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardImuSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000066", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean2 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "5102", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIMATI_KANI_UW.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exStringEquals(bzProcessForwardInBean2.getSaiwariateUserId(), "541", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000066", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "5104", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.SEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5101", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 =(SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardImuSatei.class, "exec", 0, 0);

        exStringEquals(skProcessForwardInBean1.getMosNo(), "860000066", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "工程", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
        exClassificationEquals(skProcessForwardInBean1.getImusateikekkaKbn(),C_SyorikekkaKbn.TENSOU_IMU_KANIUW , "医務査定結果区分");
        exStringEquals(skProcessForwardInBean1.getImutnsketsyaCd(),"541", "医務査定転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getHubihassintnsKbn(), C_HubihassintnsKbn.ARI, "不備発信転送区分");

    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_D1() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN7;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000066");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.HORYUU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardImuSatei.exec(skProcessForwardInBean);

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "5101", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.HORYUU, "処理結果区分");
    }
}
