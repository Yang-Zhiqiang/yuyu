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
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SkProcessForwardKetteiHoryuuHubiOnlineクラスのメソッド {@link SkProcessForwardKetteiHoryuuHubiOnline#exec(SkProcessForwardInBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessForwardKetteiHoryuuHubiOnlineTest_exec {

    @Inject
    private SkProcessForwardKetteiHoryuuHubiOnline skProcessForwardKetteiHoryuuHubiOnline;


    private final static String fileName = "UT-SP_単体テスト仕様書_新契約工程遷移（決定保留不備）_オンライン用";

    private final static String sheetName = "テストデータ";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
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

        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessForwardKetteiHoryuuHubiOnlineTest_exec.class;
        BzProcessForwardMockForSinkeiyaku.caller = SkProcessForwardKetteiHoryuuHubiOnlineTest_exec.class;
        BzOutputProcessRecordMockForSinkeiyaku.caller = SkProcessForwardKetteiHoryuuHubiOnlineTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzProcessForwardMockForSinkeiyaku.caller = null;
        BzOutputProcessRecordMockForSinkeiyaku.caller = null;

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = null;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = null;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {


        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkProcessForwardKetteiHoryuuHubiOnlineTest_exec.class, fileName, sheetName);
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
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKetteiHoryuuHubiOnline.exec(skProcessForwardInBean);



        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000017", "申込番号");
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
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKetteiHoryuuHubiOnline.exec(skProcessForwardInBean);



        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000025", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN3;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000033");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU );
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKetteiHoryuuHubiOnline.exec(skProcessForwardInBean);



        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000033", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000041");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.HORYUU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.HORYUU);
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKetteiHoryuuHubiOnline.exec(skProcessForwardInBean);



        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000041", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN5;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000058");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKetteiHoryuuHubiOnline.exec(skProcessForwardInBean);


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "1001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "SkMainDairiten", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "10", "工程ロックキー");

        SkMainDairitenRuleBean skMainDairitenRuleBean = (SkMainDairitenRuleBean)bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(skMainDairitenRuleBean.getSkkouteikanryouKbn(),"処理中", "新契約工程完了区分");
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


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(),"860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean2 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec",1, 0);
        exStringEquals(bzProcessForwardInBean2.getKouteiKanriId(), "1002", "工程管理ID");
        exStringEquals(bzProcessForwardInBean2.getJimuTetuzukiCd(),"SkTenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean2.getKouteiLockKey(), "10", "工程ロックキー");

        SkTenkenRuleBean skTenkenRuleBean = (SkTenkenRuleBean)bzProcessForwardInBean2.getIwfApiRuleBean();
        exStringEquals(skTenkenRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skTenkenRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skTenkenRuleBean.getMosnrkUmu(), "あり", "申込書入力有無");
        exStringEquals(skTenkenRuleBean.getSntkhouKbn(), "報状扱", "選択方法区分");
        exStringEquals(skTenkenRuleBean.getKktnrkUmu(), "あり", "告知書入力有無");
        exStringEquals(skTenkenRuleBean.getKktnrkvrfjkKbn(), "３次入力待ち", "告知書入力ベリファイ状況区分");
        exStringEquals(skTenkenRuleBean.getMostenkenjouKbn(),"点検待ち（２次）", "申込点検状態区分");

        exClassificationEquals(bzProcessForwardInBean2.getSyorikekkaKbn(), C_SyorikekkaKbn. IRAI_TENKEN_HUBI , "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean2.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), "SkKankyou", "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), "査定待ち（１次）", "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), "あり", "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), "ＬＩＮＣ照会中", "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), "SkImu", "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), "査定待ち（簡易（ＵＷ））", "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), "あり", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",4, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "860000058", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean5 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 4, 0);
        exStringEquals(bzProcessForwardInBean5.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzProcessForwardInBean5.getJimuTetuzukiCd(), "SkHubiTouroku", "事務手続コード");
        exStringEquals(bzProcessForwardInBean5.getKouteiLockKey(), "10", "工程ロックキー");

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = (SkHubiTourokuRuleBean)bzProcessForwardInBean5.getIwfApiRuleBean();
        exStringEquals(skHubiTourokuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skHubiTourokuRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenyhKbn(), "実施要", "申込点検要否区分");
        exStringEquals(skHubiTourokuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skHubiTourokuRuleBean.getMihassinhubiUmu(), "あり", "未発信不備有無");
        exStringEquals(skHubiTourokuRuleBean.getHubihassintnsUmu(), "あり", "不備発信転送有無");
        exStringEquals(skHubiTourokuRuleBean.getHubitourokuUmu(), "あり", "不備登録有無");
        exStringEquals(skHubiTourokuRuleBean.getKthhbKbn(), "あり", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean5.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean5.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");
        exStringEquals(bzProcessForwardInBean5.getSaiwariateUserId(),"JUnit", "再割当ユーザーID");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean6 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean6.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean6.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean6.getMosNo(), "860000058", "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), "SkMainDairiten", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "決定保留不備が発生したため、申込点検（点検後不備）へ自動依頼します。", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.IRAI_TENKEN_HUBI, "処理結果区分");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN5;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000066");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKetteiHoryuuHubiOnline.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000066", "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), "SkMainDairiten", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "決定保留不備が発生したため、申込点検（点検後不備）へ自動依頼します。", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.IRAI_TENKEN_HUBI, "処理結果区分");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN5;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000074");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKetteiHoryuuHubiOnline.exec(skProcessForwardInBean);


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "860000074", "申込番号");


        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), "SkMainDairiten", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "決定保留不備が発生したため、申込点検（点検後不備）へ自動依頼します。", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.IRAI_TENKEN_HUBI, "処理結果区分");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN5;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000082");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKetteiHoryuuHubiOnline.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(), "860000082", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean3 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 2, 0);
        exStringEquals(bzProcessForwardInBean3.getKouteiKanriId(), "1003", "工程管理ID");
        exStringEquals(bzProcessForwardInBean3.getJimuTetuzukiCd(), "SkKankyou", "事務手続コード");
        exStringEquals(bzProcessForwardInBean3.getKouteiLockKey(), "10", "工程ロックキー");

        SkKankyouRuleBean skKankyouRuleBean = (SkKankyouRuleBean)bzProcessForwardInBean3.getIwfApiRuleBean();
        exStringEquals(skKankyouRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skKankyouRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skKankyouRuleBean.getMostenkenyhKbn(), "実施不要", "申込点検要否区分");
        exStringEquals(skKankyouRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skKankyouRuleBean.getKnkysateijyouKbn(), "査定待ち（１次）", "環境査定状態区分");
        exStringEquals(skKankyouRuleBean.getKthhbKbn(), "あり", "決定保留不備区分");
        exStringEquals(skKankyouRuleBean.getLincjkKbn(), "ＬＩＮＣ照会中", "ＬＩＮＣ状況区分");

        exClassificationEquals(bzProcessForwardInBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean3.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec",3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean4.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean4.getMosNo(),"860000082", "申込番号");

        BzProcessForwardInBean bzProcessForwardInBean4 = (BzProcessForwardInBean) MockObjectManager.getArgument(
            BzProcessForwardMockForSinkeiyaku.class, "exec", 3, 0);
        exStringEquals(bzProcessForwardInBean4.getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(bzProcessForwardInBean4.getJimuTetuzukiCd(), "SkImu", "事務手続コード");
        exStringEquals(bzProcessForwardInBean4.getKouteiLockKey(), "10", "工程ロックキー");

        SkImuRuleBean skImuRuleBean = (SkImuRuleBean)bzProcessForwardInBean4.getIwfApiRuleBean();
        exStringEquals(skImuRuleBean.getSkkouteikanryouKbn(), "処理中", "新契約工程完了区分");
        exStringEquals(skImuRuleBean.getSeirituKbn(), "不成立", "成立区分");
        exStringEquals(skImuRuleBean.getMostenkenyhKbn(), "実施不要", "申込点検要否区分");
        exStringEquals(skImuRuleBean.getMostenkenjouKbn(), "点検待ち（２次）", "申込点検状態区分");
        exStringEquals(skImuRuleBean.getImusateijyouKbn(), "査定待ち（簡易（ＵＷ））", "医務査定状態区分");
        exStringEquals(skImuRuleBean.getKthhbKbn(), "あり", "決定保留不備区分");

        exClassificationEquals(bzProcessForwardInBean4.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        exClassificationEquals(bzProcessForwardInBean4.getProcessRecordOutYouhiKbn(), C_YouhiKbn.HUYOU, "工程履歴出力要否区分");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean5 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 5, 0);
        exStringEquals(bzGetProcessSummaryInBean5.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean5.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean5.getMosNo(), "860000082", "申込番号");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 0), "1001", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 1), "SkMainDairiten", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 2), "決定保留不備が発生したため、申込点検（点検後不備）へ自動依頼します。", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 3), "工程", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForSinkeiyaku.class, "exec", 0, 4), C_SyorikekkaKbn.IRAI_TENKEN_HUBI, "処理結果区分");

    }



    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN4;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000090");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKetteiHoryuuHubiOnline.exec(skProcessForwardInBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000090", "申込番号");
    }


    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN6;
        BzProcessForwardMockForSinkeiyaku.SYORIPTN = BzProcessForwardMockForSinkeiyaku.TESTPATTERN1;
        BzOutputProcessRecordMockForSinkeiyaku.SYORIPTN = BzOutputProcessRecordMockForSinkeiyaku.TESTPATTERN1;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo("860000108");
        skProcessForwardInBean.setTskNm("工程");
        skProcessForwardInBean.setKouteiLockkey("10");
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("処理コメント");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.ARI);

        skProcessForwardKetteiHoryuuHubiOnline.exec(skProcessForwardInBean);


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000108", "申込番号");

    }

}
