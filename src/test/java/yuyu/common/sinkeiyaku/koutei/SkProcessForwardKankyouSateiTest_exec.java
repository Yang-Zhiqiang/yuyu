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
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SkProcessForwardKankyouSateiクラスのメソッド {@link SkProcessForwardKankyouSatei#exec(SkProcessForwardInBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessForwardKankyouSateiTest_exec {

    @Inject
    private SkProcessForwardKankyouSatei skProcessForwardKankyouSatei;

    private final static String fileName = "UT_SP_単体テスト仕様書_新契約工程遷移（環境査定）";

    private final static String sheetName = "テストデータ";


    private final static String mosNo1 = "991234014";

    private final static String mosNo2 = "991234022";

    private final static String mosNo3 = "991234030";

    private final static String mosNo4 = "991234048";

    private final static String mosNo5 = "991234055";

    private final static String mosNo6 = "991234063";

    private final static String mosNo7 = "991234071";

    private final static String mosNo8 = "991234089";

    private final static String mosNo9 = "991234097";

    private final static String mosNo10 = "991234105";

    private final static String mosNo11 = "991234113";

    private final static String mosNo12 = "991234121";

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

        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessForwardKankyouSateiTest_exec.class;
        BzProcessForwardMockForSinkeiyaku.caller = SkProcessForwardKankyouSateiTest_exec.class;
        BzOutputProcessRecordMockForSinkeiyaku.caller = SkProcessForwardKankyouSateiTest_exec.class;
        SkProcessForwardMoschkExecMockForSinkeiyaku.caller = SkProcessForwardKankyouSateiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN =null;
        BzProcessForwardMockForSinkeiyaku.caller = null;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN =null;
        BzOutputProcessRecordMockForSinkeiyaku.caller = null;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = null;
        SkProcessForwardMoschkExecMockForSinkeiyaku.caller = null ;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = null ;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkProcessForwardKankyouSateiTest_exec.class, fileName, sheetName);
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
        skProcessForwardInBean.setKouteiLockkey ("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setKnktnsketsyaCd("KYOUYOU");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);


        skProcessForwardKankyouSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), mosNo1, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "100010001", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "10", "工程ロックキー");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)), "新契約工程完了区分");
        exStringEquals(skMainDairitenRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skMainDairitenRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skMainDairitenRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skMainDairitenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skMainDairitenRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skMainDairitenRuleBean.getMostenkenjouKbn(),"点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skMainDairitenRuleBean.getKetteiKbn(), "決定済", "決定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSateijtKbn(),  "査定済", "査定状態区分");
        exStringEquals(skMainDairitenRuleBean.getSrhhbKbn(),  "なし", "成立保留不備区分");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",1, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), mosNo1, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), "100010002", "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), "査定待ち（１次）", "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), "あり", "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), "未判定", "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_KANKYOU_1, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean8 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",2, 0);
        exStringEquals(bzGetProcessSummaryInBean8.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean8.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean8.getMosNo(), mosNo1, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean8 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean8.getKouteiKanriId(), "1008", "工程管理ID");
        exStringEquals(bzProcessForwardInBean8.getJimuTetuzukiCd(), "100010008", "事務手続コード");
        exStringEquals(bzProcessForwardInBean8.getKouteiLockKey(), "10", "工程ロックキー");

        SkInputKokutiRuleBean skInputKokutiRuleBean = (SkInputKokutiRuleBean)bzProcessForwardInBean8.getIwfApiRuleBean();
        exStringEquals(skInputKokutiRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skInputKokutiRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skInputKokutiRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skInputKokutiRuleBean.getMosuketukeKbn(),"", "申込受付区分");
        exStringEquals(skInputKokutiRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skInputKokutiRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");

        exClassificationEquals(bzProcessForwardInBean8.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean8.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",3, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), mosNo1, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), "100010003", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), "査定待ち（簡易（ＵＷ））", "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), "あり", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",4, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo1, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), "100010004", "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), "あり", "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), "あり", "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), "あり", "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), "あり", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",5, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), mosNo1, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), "100010005", "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiKaisyouRuleBean skHubiKaisyouRuleBean = (SkHubiKaisyouRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skHubiKaisyouRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skHubiKaisyouRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skHubiKaisyouRuleBean.getHubikaisyoujoutaiKbn(), "不備解消済", "不備解消状態区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",6, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), mosNo1, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean5 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 6, 0);
        exStringEquals(bzProcessForwardInBean5.getKouteiKanriId(), "1006", "工程管理ID");
        exStringEquals(bzProcessForwardInBean5.getJimuTetuzukiCd(), "100010006", "事務手続コード");
        exStringEquals(bzProcessForwardInBean5.getKouteiLockKey(), "10", "工程ロックキー");

        SkKeiyakukakuninRuleBean skKeiyakukakuninRuleBean = (SkKeiyakukakuninRuleBean)bzProcessForwardInBean5.getIwfApiRuleBean();
        exStringEquals(skKeiyakukakuninRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skKeiyakukakuninRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKetteiKbn(), "決定済", "決定状態区分");
        exStringEquals(skKeiyakukakuninRuleBean.getKykkakjkKbn(), "決定前契約確認中", "契約確認状況区分");

        exClassificationEquals(bzProcessForwardInBean5.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean5.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",7, 0);
        exStringEquals(bzGetProcessSummaryInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean6.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean6.getMosNo(), mosNo1, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean6 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 7, 0);
        exStringEquals(bzProcessForwardInBean6.getKouteiKanriId(), "1007", "工程管理ID");
        exStringEquals(bzProcessForwardInBean6.getJimuTetuzukiCd(), "100010007", "事務手続コード");
        exStringEquals(bzProcessForwardInBean6.getKouteiLockKey(), "10", "工程ロックキー");

        SkTorikesiRuleBean skTorikesiRuleBean = (SkTorikesiRuleBean)bzProcessForwardInBean6.getIwfApiRuleBean();
        exStringEquals(skTorikesiRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skTorikesiRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skTorikesiRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");

        exClassificationEquals(bzProcessForwardInBean6.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean6.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",8, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), mosNo1, "申込番号");


        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), "100010001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");


        SkProcessForwardInBean skProcessForwardInBean1 = (SkProcessForwardInBean) MockObjectManager.getArgument(
            SkProcessForwardMoschkExecMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(skProcessForwardInBean1.getMosNo(), "991234014", "申込番号");
        exStringEquals(skProcessForwardInBean1.getTskNm(), "工程", "事務手続コード");
        exStringEquals(skProcessForwardInBean1.getKouteiLockkey(), "10", "工程ロックキー");
        exClassificationEquals(skProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "工程管理ID");
        exStringEquals(skProcessForwardInBean1.getSyoriComment(), "処理コメント", "事務手続コード");
        exClassificationEquals(skProcessForwardInBean1.getKnksateikekkaKbn(), C_SyorikekkaKbn.TENSOU_KANKYOU_1, "工程ロックキー");
        exStringEquals(skProcessForwardInBean1.getKnktnsketsyaCd(), "KYOUYOU", "処理結果区分");
        exClassificationEquals(skProcessForwardInBean1.getHubihassintnsKbn(), C_HubihassintnsKbn.ARI, "工程履歴出力要否区分");

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
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKankyouSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",3, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), mosNo2, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), "100010003", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), "査定待ち（簡易（ＵＷ））", "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",4, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo2, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), "100010004", "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), "あり", "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), "あり", "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), "なし", "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean7 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",8, 0);
        exStringEquals(bzGetProcessSummaryInBean7.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean7.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean7.getMosNo(), mosNo2, "申込番号");


        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), "100010001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.KANRYOU, "処理結果区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo3);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.IRAI_TENKEN_1);
        skProcessForwardInBean.setMostenkentnsketsyaCd("101");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKankyouSatei.exec(skProcessForwardInBean);


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean8 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean8.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean8.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean8.getMosNo(),mosNo3, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean8 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec",2, 0);
        exStringEquals(bzProcessForwardInBean8.getKouteiKanriId(), "1008", "工程管理ID");
        exStringEquals(bzProcessForwardInBean8.getJimuTetuzukiCd(), "100010008", "事務手続コード");
        exStringEquals(bzProcessForwardInBean8.getKouteiLockKey(), "10", "工程ロックキー");

        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean8.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(),"点検待ち（２次）", "申込点検状態区分");

        exClassificationEquals(bzProcessForwardInBean8.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_TENKEN_1, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean8.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",3, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), mosNo3, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), "100010003", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), "実施不要", "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), "査定待ち（簡易（ＵＷ））", "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",4, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo3, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), "100010004", "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), "実施不要", "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), "あり", "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), "あり", "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), "あり", "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo4);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.IRAI_TENKEN_2);
        skProcessForwardInBean.setMostenkentnsketsyaCd("111");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKankyouSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), mosNo4, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "1008", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "100010008", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "10", "工程ロックキー");

        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean.getIwfApiRuleBean();

        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(),"点検待ち（２次）", "申込点検状態区分");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_TENKEN_2, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",3, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), mosNo4, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), "100010003", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), "実施不要", "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), "査定待ち（簡易（ＵＷ））", "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN5;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo5);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.IRAI_TENKEN_HUBI);
        skProcessForwardInBean.setMostenkentnsketsyaCd("121");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKankyouSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), mosNo5, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec",2, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "1008", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "100010008", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "10", "工程ロックキー");

        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean.getIwfApiRuleBean();

        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(),"点検待ち（点検後不備）", "申込点検状態区分");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_TENKEN_HUBI, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN6;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo6);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.IRAI_IMU_KANIUW);
        skProcessForwardInBean.setImutnsketsyaCd("102");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKankyouSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",2, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), mosNo6, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), "100010003", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), "査定待ち（簡易（ＵＷ））", "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_IMU_KANIUW, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN7;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo7);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.IRAI_IMU_KANIMD);
        skProcessForwardInBean.setImutnsketsyaCd("102");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKankyouSatei.exec(skProcessForwardInBean);


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",2, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), mosNo7 , "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), "100010003", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), "査定待ち（簡易（ＵＷ））", "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_IMU_KANIMD, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN8;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo8);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKankyouSatei.exec(skProcessForwardInBean);


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo8, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), "100010004", "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), "あり", "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), "あり", "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), "あり", "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {


        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN9;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo9);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setKnktnsketsyaCd("KYOUYOU");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.IRAI_IMU_KANIUW);
        skProcessForwardInBean.setImutnsketsyaCd("102");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKankyouSatei.exec(skProcessForwardInBean);


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), mosNo9, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), "100010002", "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), "査定待ち（１次）", "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), "ＬＩＮＣ照会送信待ち", "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_KANKYOU_1, "処理結果区分");
        exStringEquals(bzProcessForwardInBean1.getSaiwariateUserId(), "", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), mosNo9, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), "100010003", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), "査定待ち（簡易（ＵＷ））", "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_IMU_KANIUW, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo9, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), "100010004", "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), "あり", "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), "あり", "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), "あり", "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {


        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN10;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo10);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_2A);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_2A);
        skProcessForwardInBean.setKnktnsketsyaCd("111");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.IRAI_IMU_KANIMD);
        skProcessForwardInBean.setImutnsketsyaCd("112");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKankyouSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), mosNo10, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), "100010002", "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), "査定待ち（１次）", "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), "ＬＩＮＣ照会中", "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_KANKYOU_2A, "処理結果区分");
        exStringEquals(bzProcessForwardInBean1.getSaiwariateUserId(), "111", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(), mosNo10, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(), "100010003", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), "査定待ち（簡易（ＵＷ））", "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.IRAI_IMU_KANIMD, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo10, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), "100010004", "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), "あり", "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), "あり", "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), "あり", "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN11;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo11);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_2B);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_2B);
        skProcessForwardInBean.setKnktnsketsyaCd("121");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKankyouSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), mosNo11, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean1 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean1.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean1.getJimuTetuzukiCd(), "100010002", "事務手続コード");
        exStringEquals(bzProcessForwardInBean1.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean1.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), "査定待ち（１次）", "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), "ＬＩＮＣ回答あり（他社加入なし）", "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU_KANKYOU_2B, "処理結果区分");
        exStringEquals(bzProcessForwardInBean1.getSaiwariateUserId(), "121", "再割当ユーザーID");
        exClassificationEquals(bzProcessForwardInBean1.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), mosNo11, "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), "100010004", "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), "成立", "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), "あり", "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), "あり", "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), "あり", "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), "なし", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");



    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN12;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;
        SkProcessForwardMoschkExecMockForSinkeiyaku.SYORIPTN = SkProcessForwardMoschkExecMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo12);
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.HORYUU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKankyouSatei.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), mosNo12, "申込番号");


        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), "100010001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.HORYUU, "処理結果区分");

    }

}
