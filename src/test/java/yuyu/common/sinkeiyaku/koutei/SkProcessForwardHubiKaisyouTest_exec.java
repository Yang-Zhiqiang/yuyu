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
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
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
 * SkProcessForwardHubiKaisyouクラスのメソッド {@link SkProcessForwardHubiKaisyou#exec(SkProcessForwardInBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessForwardHubiKaisyouTest_exec {

    @Inject
    private SkProcessForwardHubiKaisyou skProcessForwardHubiKaisyou;

    private final static String mosNo1 = "870000015";

    private final static String mosNo2 = "870000023";

    private final static String mosNo3 = "870000031";

    private final static String mosNo4 = "870000049";

    private final static String mosNo5 = "870000056";

    private final static String mosNo6 = "870000064";

    private final static String mosNo7 = "870000072";

    private final static String fileName = "UT-SP_単体テスト仕様書_新契約工程遷移（新契約不備解消）";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
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

        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessForwardHubiKaisyouTest_exec.class;
        BzProcessForwardMockForSinkeiyaku.caller = SkProcessForwardHubiKaisyouTest_exec.class;
        BzOutputProcessRecordMockForSinkeiyaku.caller = SkProcessForwardHubiKaisyouTest_exec.class;
        SkProcessForwardMoschkExecMockForSinkeiyaku.caller = SkProcessForwardHubiKaisyouTest_exec.class;

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

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkProcessForwardHubiKaisyouTest_exec.class, fileName, sheetName);
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
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo1);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);
        skProcessForwardInBean.setMostenkentnsketsyaCd("KYOUYOU");
        skProcessForwardInBean.setKnktnsketsyaCd("123");
        skProcessForwardInBean.setImutnsketsyaCd("456");

        skProcessForwardHubiKaisyou.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), mosNo1, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");
        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.ITIPMATI.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.SYOKUGYOU.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.NONE.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_HUBI.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.TKJYSYDK_MATI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.TKJYSYDK_MATI.getContent(), "査定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSrhhbKbn(), C_UmuKbn.ARI.getContent(), "成立保留不備区分");
        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), mosNo1, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");
        SkHubiKaisyouRuleBean skHubiKaisyouRuleBean = (SkHubiKaisyouRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skHubiKaisyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skHubiKaisyouRuleBean.getSeirituKbn(), C_SeirituKbn.ITIPMATI.getContent(), "成立区分");
        exStringEquals(skHubiKaisyouRuleBean.getHubikaisyoujoutaiKbn(), C_HubikaisyoujoutaiKbn.HUBIKAISYOUZUMI.getContent(), "不備解消状態区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo1, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.ITIPMATI.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.SYOKUGYOU.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), C_UmuKbn.NONE.getContent(), "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_HUBI.getContent(), "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_TENKEN_1, "処理結果区分");
        exStringEquals(bzProcessForwardInBean3.getSaiwariateUserId(), "", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), mosNo1, "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardMoschkExecMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), mosNo1, "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "工程", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
        exClassificationEquals(skProcessForwardInBean1.getMostenkenkekkaKbn(), C_SyorikekkaKbn.TENSOU_TENKEN_1, "申込点検結果区分");
        exStringEquals(skProcessForwardInBean1.getMostenkentnsketsyaCd(), "KYOUYOU", "申込点検転送先決定者コード");
        exStringEquals(skProcessForwardInBean1.getKnktnsketsyaCd(), "123", "環境査定転送先決定者コード");
        exStringEquals(skProcessForwardInBean1.getImutnsketsyaCd(), "456", "医務査定転送先決定者コード");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo2);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);
        skProcessForwardInBean.setMostenkentnsketsyaCd("999");
        skProcessForwardInBean.setKnktnsketsyaCd("123");
        skProcessForwardInBean.setImutnsketsyaCd("456");

        skProcessForwardHubiKaisyou.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo2, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "2005", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.ITIPMATI.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.SYOKUGYOU.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), C_UmuKbn.NONE.getContent(), "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_HUBI.getContent(), "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_TENKEN_2, "処理結果区分");
        exStringEquals(bzProcessForwardInBean2.getSaiwariateUserId(), "", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo3);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.TENSOU_TENKEN_HUBI);
        skProcessForwardInBean.setMostenkentnsketsyaCd("999");
        skProcessForwardInBean.setKnktnsketsyaCd("123");
        skProcessForwardInBean.setImutnsketsyaCd("456");

        skProcessForwardHubiKaisyou.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo3, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "2005", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");
        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), C_SeirituKbn.ITIPMATI.getContent(), "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), C_SntkhouKbn.SYOKUGYOU.getContent(), "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), C_UmuKbn.NONE.getContent(), "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_HUBI.getContent(), "申込点検状態区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_TENKEN_HUBI, "処理結果区分");
        exStringEquals(bzProcessForwardInBean2.getSaiwariateUserId(), "999", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo4);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.TENSOU);
        skProcessForwardInBean.setMostenkentnsketsyaCd("999");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setKnktnsketsyaCd("KYOUYOU");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_MOSTORIKESI);
        skProcessForwardInBean.setImutnsketsyaCd("456");

        skProcessForwardHubiKaisyou.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo4, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "2003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");
        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.ITIPMATI.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.MOSTENKEN_ZUMI.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_2B.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.SYOUKAI.getContent(), "ＬＩＮＣ状況区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_KANKYOU_1, "処理結果区分");
        exStringEquals(bzProcessForwardInBean2.getSaiwariateUserId(), "", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), mosNo4, "申込番号");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo5);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.TENSOU);
        skProcessForwardInBean.setMostenkentnsketsyaCd("999");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_2A);
        skProcessForwardInBean.setKnktnsketsyaCd("123");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        skProcessForwardInBean.setImutnsketsyaCd("KYOUYOU");

        skProcessForwardHubiKaisyou.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo5, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "2003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");
        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.ITIPMATI.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_HUBI.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_2B.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.KAITOARI_TASYANASI.getContent(), "ＬＩＮＣ状況区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_KANKYOU_2A, "処理結果区分");
        exStringEquals(bzProcessForwardInBean2.getSaiwariateUserId(), "", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), mosNo5, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "2004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");
        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.ITIPMATI.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.YOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_HUBI.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.ARI.getContent(), "決定保留不備区分");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIUW, "処理結果区分");
        exStringEquals(bzProcessForwardInBean3.getSaiwariateUserId(), "", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), mosNo5, "申込番号");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo6);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.TENSOU);
        skProcessForwardInBean.setMostenkentnsketsyaCd("999");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_2B);
        skProcessForwardInBean.setKnktnsketsyaCd("123");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIMD);
        skProcessForwardInBean.setImutnsketsyaCd("456");

        skProcessForwardHubiKaisyou.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo6, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "2003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");
        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), C_SeirituKbn.ITIPMATI.getContent(), "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.MOSTENKEN_ZUMI.getContent(), "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), C_KnkysateijyouKbn.SATEIMATI_2B.getContent(), "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), C_LincjkKbn.KAITOARI_TASYAARI.getContent(), "ＬＩＮＣ状況区分");
        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_KANKYOU_2B, "処理結果区分");
        exStringEquals(bzProcessForwardInBean2.getSaiwariateUserId(), "123", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), mosNo6, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "2004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");
        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), C_SeirituKbn.ITIPMATI.getContent(), "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), C_MostenkenyhKbn.HUYOU.getContent(), "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.MOSTENKEN_ZUMI.getContent(), "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), C_ImusateijyouKbn.SATEIZUMI.getContent(), "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), C_UmuKbn.NONE.getContent(), "決定保留不備区分");
        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIMD, "処理結果区分");
        exStringEquals(bzProcessForwardInBean3.getSaiwariateUserId(), "456", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), mosNo6, "申込番号");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo7);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.TENSOU);
        skProcessForwardInBean.setMostenkentnsketsyaCd("KYOUYOU");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.SASIMODOSI);
        skProcessForwardInBean.setKnktnsketsyaCd("KYOUYOU");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.HORYUU);
        skProcessForwardInBean.setImutnsketsyaCd("KYOUYOU");

        skProcessForwardHubiKaisyou.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), mosNo7, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "2001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");
        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU.getContent(), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), C_SeirituKbn.ITIPMATI.getContent(), "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), C_UmuKbn.ARI.getContent(), "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), C_SntkhouKbn.SYOKUGYOU.getContent(), "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), C_UmuKbn.NONE.getContent(), "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), C_VrfjkKbn.SANJINRKMATI.getContent(), "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(), C_MostenkenjyouKbn.TENKENMATI_HUBI.getContent(), "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), C_KetteiKbn.TKJYSYDK_MATI.getContent(), "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(), C_SateijtKbn.TKJYSYDK_MATI.getContent(), "査定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSrhhbKbn(), C_UmuKbn.ARI.getContent(), "成立保留不備区分");
        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), mosNo7, "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), mosNo7, "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "2001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardMoschkExecMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), mosNo7, "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "工程", "タスク名");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "処理コメント");
        exClassificationEquals(skProcessForwardInBean1.getMostenkenkekkaKbn(), C_SyorikekkaKbn.TENSOU, "申込点検結果区分");
        exStringEquals(skProcessForwardInBean1.getMostenkentnsketsyaCd(), "KYOUYOU", "申込点検転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getKnksateikekkaKbn(), C_SyorikekkaKbn.SASIMODOSI, "環境査定結果区分");
        exStringEquals(skProcessForwardInBean1.getKnktnsketsyaCd(), "KYOUYOU", "環境査定転送先決定者コード");
        exClassificationEquals(skProcessForwardInBean1.getImusateikekkaKbn(), C_SyorikekkaKbn.HORYUU, "医務査定結果区分");
        exStringEquals(skProcessForwardInBean1.getImutnsketsyaCd(), "KYOUYOU", "医務査定転送先決定者コード");

    }

}
