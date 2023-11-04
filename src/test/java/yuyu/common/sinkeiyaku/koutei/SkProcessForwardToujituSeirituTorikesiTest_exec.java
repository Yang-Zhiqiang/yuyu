package yuyu.common.sinkeiyaku.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
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
import yuyu.common.biz.koutei.BzLockProcess;
import yuyu.common.biz.koutei.BzLockProcessMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzOutputProcessRecordMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzProcessForward;
import yuyu.common.biz.koutei.BzProcessForwardInBean;
import yuyu.common.biz.koutei.BzProcessForwardMockForSinkeiyaku;
import yuyu.common.biz.koutei.BzUnlockProcess;
import yuyu.common.biz.koutei.BzUnlockProcessMockForSinkeiyaku;
import yuyu.common.biz.koutei.GetSyoruittykymd;
import yuyu.common.biz.koutei.GetSyoruittykymdMockForSinkeiyaku;
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
 * SkProcessForwardToujituSeirituTorikesiクラスのメソッド {@link SkProcessForwardToujituSeirituTorikesi#exec(SkProcessForwardInBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessForwardToujituSeirituTorikesiTest_exec {

    @Inject
    private SkProcessForwardToujituSeirituTorikesi skProcessForwardToujituSeirituTorikesi;

    private final static String mosNo1 = "860817113";

    private final static String mosNo2 = "860817121";

    private final static String mosNo3 = "860817139";

    private final static String mosNo4 = "860817147";

    private final static String fileName = "UT_SP_単体テスト仕様書_新契約工程遷移（当日成立取消）";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
                bind(BzProcessForward.class).to(BzProcessForwardMockForSinkeiyaku.class);
                bind(BzOutputProcessRecord.class).to(BzOutputProcessRecordMockForSinkeiyaku.class);
                bind(SkProcessForwardKetteiHoryuuHubiOnline.class).to(SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.class);
                bind(SkProcessForwardMoschkExec.class).to(SkProcessForwardMoschkExecMockForSinkeiyaku.class);
                bind(BzLockProcess.class).to(BzLockProcessMockForSinkeiyaku.class);
                bind(GetSyoruittykymd.class).to(GetSyoruittykymdMockForSinkeiyaku.class);
                bind(BzUnlockProcess.class).to(BzUnlockProcessMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessForwardToujituSeirituTorikesiTest_exec.class;
        BzProcessForwardMockForSinkeiyaku.caller = SkProcessForwardToujituSeirituTorikesiTest_exec.class;
        BzOutputProcessRecordMockForSinkeiyaku.caller = SkProcessForwardToujituSeirituTorikesiTest_exec.class;
        SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.caller = SkProcessForwardToujituSeirituTorikesiTest_exec.class;
        SkProcessForwardMoschkExecMockForSinkeiyaku.caller =  SkProcessForwardToujituSeirituTorikesiTest_exec.class;
        BzLockProcessMockForSinkeiyaku.caller = SkProcessForwardToujituSeirituTorikesiTest_exec.class;
        GetSyoruittykymdMockForSinkeiyaku.caller = SkProcessForwardToujituSeirituTorikesiTest_exec.class;
        BzUnlockProcessMockForSinkeiyaku.caller = SkProcessForwardToujituSeirituTorikesiTest_exec.class;
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

    @AfterClass
    public static void testClear() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzProcessForwardMockForSinkeiyaku.caller = null;
        BzOutputProcessRecordMockForSinkeiyaku.caller = null;
        SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.caller =null;
        SkProcessForwardMoschkExecMockForSinkeiyaku.caller =  null;
        BzLockProcessMockForSinkeiyaku.caller = null;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = null;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = null;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = null;
        SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.SYORIPTN =null;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN =  null;
        BzLockProcessMockForSinkeiyaku.SYORIPTN = null;
        GetSyoruittykymdMockForSinkeiyaku.caller =null;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = null;
        BzUnlockProcessMockForSinkeiyaku.caller =null;
        BzUnlockProcessMockForSinkeiyaku.SYORIPTN =null;

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.SYORIPTN = SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;
        BzLockProcessMockForSinkeiyaku.SYORIPTN = BzLockProcessMockForSinkeiyaku.TESTPATTERN1;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        BzUnlockProcessMockForSinkeiyaku.SYORIPTN = BzUnlockProcessMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo1);
        skProcessForwardInBean.setTskNm("告知書入力（新規（１次））");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント１");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);
        skProcessForwardInBean.setHnkninputTorikesiyhKbn(C_YouhiKbn.YOU);

        skProcessForwardToujituSeirituTorikesi.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817113", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.BLNK.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.ARI.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.SATEI_SUMI.getContent(), "査定状態区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817113", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean2 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkInputKokutiRuleBean skInputKokutiRuleBean = (SkInputKokutiRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skInputKokutiRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skInputKokutiRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skInputKokutiRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skInputKokutiRuleBean.getMosuketukeKbn(), C_MosUketukeKbn.MOSKIT.getContent(), "申込受付区分");
        exStringEquals(skInputKokutiRuleBean.getSntkhouKbn(), C_SntkhouKbn.BLNK.getContent(), "選択方法区分");
        exStringEquals(skInputKokutiRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817113", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean3 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.BLNK.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817113", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean4 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);

        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIZUMI.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAI.getContent(), "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817113", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean5 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);

        exStringEquals(bzProcessForwardInBean5.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean5.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean5.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean5.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean5.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817113", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean6 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 5, 0);

        exStringEquals(bzProcessForwardInBean6.getKouteiKanriId(), "1006", "工程管理ID");
        exStringEquals(bzProcessForwardInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean6.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean6.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_2.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.ARI.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.ARI.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.ARI.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean6.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean6.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 6, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817113", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean7 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 6, 0);

        exStringEquals(bzProcessForwardInBean7.getKouteiKanriId(), "1007", "工程管理ID");
        exStringEquals(bzProcessForwardInBean7.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean7.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiKaisyouRuleBean skHubiKaisyouRuleBean = (SkHubiKaisyouRuleBean)bzProcessForwardInBean7.getIwfApiRuleBean();
        exStringEquals(skHubiKaisyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiKaisyouRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skHubiKaisyouRuleBean.getHubikaisyoujoutaiKbn(), C_HubikaisyoujoutaiKbn.HUBIKAITOUMATI.getContent(), "不備解消状態区分");

        exClassificationEquals(bzProcessForwardInBean7.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean7.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 7, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(),  ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817113", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean8 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 7, 0);

        exStringEquals(bzProcessForwardInBean8.getKouteiKanriId(), "1008", "工程管理ID");
        exStringEquals(bzProcessForwardInBean8.getJimuTetuzukiCd(),  ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean8.getKouteiLockKey(), "10", "工程ロックキー");

        SkKeiyakukakuninRuleBean skKeiyakukakuninRuleBean = (SkKeiyakukakuninRuleBean)bzProcessForwardInBean8.getIwfApiRuleBean();
        exStringEquals(skKeiyakukakuninRuleBean.getSeirituKbn(), C_SeirituKbn.HUSEIRITU.getContent(), "成立区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI.getContent(), "決定状態区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKykkakjkKbn(), C_KykkakjkKbn.KETMAE_KAKUNIN.getContent(), "契約確認状況区分");

        exClassificationEquals(bzProcessForwardInBean8.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean8.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 10, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817113", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean9 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 9, 0);

        exStringEquals(bzProcessForwardInBean9.getKouteiKanriId(), "1009", "工程管理ID");
        exStringEquals(bzProcessForwardInBean9.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean9.getKouteiLockKey(), "10", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean9.getSyoriComment(), "処理コメント１", "処理コメント");

        SkHenkinRuleBean skHenkinRuleBean = (SkHenkinRuleBean)bzProcessForwardInBean9.getIwfApiRuleBean();

        exStringEquals(skHenkinRuleBean.getNyknnrkUmu(), C_UmuKbn.ARI.getContent(), "入金入力有無");
        exStringEquals(skHenkinRuleBean.getPkakinUmu(), C_UmuKbn.NONE.getContent(), "P過金有無");

        exClassificationEquals(bzProcessForwardInBean9.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean9.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 11, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817113", "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント１", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "告知書入力（新規（１次））", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardMoschkExecMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), "860817113", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "告知書入力（新規（１次））", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント１", "処理コメント");

        exClassificationEquals(skProcessForwardInBean1.getHubihassintnsKbn(),C_HubihassintnsKbn.ARI, "不備発信転送区分");
        exClassificationEquals(skProcessForwardInBean1.getHnkninputTorikesiyhKbn(),C_YouhiKbn.YOU, "返金入力取消要否区分");


    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.SYORIPTN = SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.TESTPATTERN1;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        BzUnlockProcessMockForSinkeiyaku.SYORIPTN = BzUnlockProcessMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo2);
        skProcessForwardInBean.setTskNm("告知書入力（新規（２次））");
        skProcessForwardInBean.setKouteiLockkey("20");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント２");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);
        skProcessForwardInBean.setHnkninputTorikesiyhKbn(C_YouhiKbn.YOU);

        skProcessForwardToujituSeirituTorikesi.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean  bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 6, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817121", "申込番号");


        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 7, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(),  ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817121", "申込番号");

        bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 10, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817121", "申込番号");


    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        BzLockProcessMockForSinkeiyaku.SYORIPTN = BzLockProcessMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo3);
        skProcessForwardInBean.setTskNm("告知書入力（新規（３次））");
        skProcessForwardInBean.setKouteiLockkey("30");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント３");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setHnkninputTorikesiyhKbn(C_YouhiKbn.YOU);

        skProcessForwardToujituSeirituTorikesi.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean  bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 10, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817139", "申込番号");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        BzUnlockProcessMockForSinkeiyaku.SYORIPTN = BzUnlockProcessMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo4);
        skProcessForwardInBean.setTskNm("告知書入力（訂正）");
        skProcessForwardInBean.setKouteiLockkey("40");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント４");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setHnkninputTorikesiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardToujituSeirituTorikesi.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860817147", "申込番号");


        BzProcessForwardInBean bzProcessForwardInBean6 =(BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 5, 0);

        exStringEquals(bzProcessForwardInBean6.getKouteiKanriId(), "4006", "工程管理ID");
        exStringEquals(bzProcessForwardInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean6.getKouteiLockKey(), "40", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean6.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), C_SeirituKbn.ITIPMATI.getContent(), "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.NONE.getContent(), "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), C_UmuKbn.NONE.getContent(), "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), C_HubihassintnsKbn.BLNK.getContent(), "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), C_UmuKbn.NONE.getContent(), "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean6.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean6.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");
    }


    @Test(expected = BizLogicException.class)
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.SYORIPTN = SkProcessForwardKetteiHoryuuHubiOnlineMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;
        BzLockProcessMockForSinkeiyaku.SYORIPTN = BzLockProcessMockForSinkeiyaku.TESTPATTERN2;
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        BzUnlockProcessMockForSinkeiyaku.SYORIPTN = BzUnlockProcessMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo1);
        skProcessForwardInBean.setTskNm("告知書入力（新規（１次））");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント１");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);
        skProcessForwardInBean.setHnkninputTorikesiyhKbn(C_YouhiKbn.YOU);

        try {

            skProcessForwardToujituSeirituTorikesi.exec(skProcessForwardInBean);
        } catch (BizLogicException e) {

            exStringEquals(e.getMessage(), "他ユーザが処理中のため処理できません。", "エラーメッセージ");
            throw e;
        }

    }


}
