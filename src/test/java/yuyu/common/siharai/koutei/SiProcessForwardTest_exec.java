package yuyu.common.siharai.koutei;

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
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BzGetProcessRecord;
import yuyu.common.biz.bzcommon.BzGetProcessRecordInputBean;
import yuyu.common.biz.bzcommon.BzGetProcessRecordMockForSiharai;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSiharai;
import yuyu.common.biz.koutei.BzProcessForward;
import yuyu.common.biz.koutei.BzProcessForwardInBean;
import yuyu.common.biz.koutei.BzProcessForwardMockForSiharai;
import yuyu.common.biz.koutei.CheckTaskKengen;
import yuyu.common.biz.koutei.CheckTaskKengenMockForSiharai;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.classification.C_SateiYouhiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 支払工程遷移のメソッド{@link SiProcessForward#exec(String, String, String,String,SiRuleBean,String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiProcessForwardTest_exec {

    @Inject
    private BaseUserInfo userInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_支払工程遷移";
    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSiharai.class);
                bind(BzProcessForward.class).to(BzProcessForwardMockForSiharai.class);
                bind(BzGetProcessRecord.class).to(BzGetProcessRecordMockForSiharai.class);
                bind(CheckTaskKengen.class).to(CheckTaskKengenMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        BzGetProcessSummaryMockForSiharai.caller = SiProcessForwardTest_exec.class;
        BzGetProcessSummaryMockForSiharai.SYORIPTN = null;

        BzProcessForwardMockForSiharai.caller = SiProcessForwardTest_exec.class;
        BzProcessForwardMockForSiharai.SYORIPTN = null;

        BzGetProcessRecordMockForSiharai.caller = SiProcessForwardTest_exec.class;
        BzGetProcessRecordMockForSiharai.SYORIPTN = null;

        CheckTaskKengenMockForSiharai.caller = SiProcessForwardTest_exec.class;
        CheckTaskKengenMockForSiharai.SYORIPTN = null;

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiProcessForwardTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector
            .getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getKinou("kinouId1"));
        baseDomManager.delete(baseDomManager.getUser("administrator1"));
        baseDomManager.delete(baseDomManager.getRole("administrator1"));
        baseDomManager.delete(baseDomManager.getCategory("categoryId1"));
        baseDomManager.delete(baseDomManager.getSubSystem("subSystemId1"));
    }

    @AfterClass
    public static void testClear() {
        BzGetProcessSummaryMockForSiharai.caller = SiProcessForwardTest_exec.class;
        BzGetProcessSummaryMockForSiharai.SYORIPTN = null;

        BzProcessForwardMockForSiharai.caller = SiProcessForwardTest_exec.class;
        BzProcessForwardMockForSiharai.SYORIPTN = null;

        BzGetProcessRecordMockForSiharai.caller = SiProcessForwardTest_exec.class;
        BzGetProcessRecordMockForSiharai.SYORIPTN = null;

        CheckTaskKengenMockForSiharai.caller = SiProcessForwardTest_exec.class;
        CheckTaskKengenMockForSiharai.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        changeCurrentUser(userInfo, baseDomManager.getUser("administrator1"));
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HORYUU);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "保留≠不備管理中", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "保留≠不備管理中", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "保留", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), null, "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HORYUU, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "administrator1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.TENSOU);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001","転送≠不備管理中", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "転送≠不備管理中", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "転送", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), null, "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user99", "再割当ユーザーID");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN1;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;

        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUSYOUNIN);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不承認査定２次", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不承認査定２次", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不承認", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUSYOUNIN, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "", "再割当ユーザーID");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN4;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUSYOUNIN);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不承認査定２次", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不承認査定２次", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不承認", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUSYOUNIN, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN3;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN2;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN4;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUSYOUNIN);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不承認査定３次", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不承認査定３次", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不承認", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUSYOUNIN, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "", "再割当ユーザーID");

        exStringEquals((String)MockObjectManager.getArgument(CheckTaskKengenMockForSiharai.class, "exec", 0, 0), "user0", "ユーザーID");
        exStringEquals((String)MockObjectManager.getArgument(CheckTaskKengenMockForSiharai.class, "exec", 0, 1), "sktenken", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(CheckTaskKengenMockForSiharai.class, "exec", 0, 2), "satei1", "タスクID");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN4;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN3;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUSYOUNIN);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不承認査定４次", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不承認査定４次", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不承認", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUSYOUNIN, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN5;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN4;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUSYOUNIN);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不承認手続（査定要）", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不承認手続（査定要）", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不承認", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUSYOUNIN, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }
    @Test
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN10;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN17;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUSYOUNIN);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不承認点検", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(),"不承認点検", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不承認", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUSYOUNIN, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN10;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN18;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUSYOUNIN);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不承認点検", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(),"不承認点検", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不承認", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUSYOUNIN, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN6;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN5;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUSYOUNIN);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不承認承認（査定要）", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(),"不承認承認（査定要）", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不承認", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUSYOUNIN, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN7;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN6;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUSYOUNIN);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不承認手続（査定不要）", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不承認手続（査定不要）", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不承認", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUSYOUNIN, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN8;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN6;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUSYOUNIN);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不承認承認（査定不要）", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不承認承認（査定不要）", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不承認", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUSYOUNIN, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN9;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN7;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUSYOUNIN);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不承認折衝２次", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不承認折衝２次", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不承認", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUSYOUNIN, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN12;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN19;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUSYOUNIN);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不承認不備承認", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不承認不備承認", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不承認", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUSYOUNIN, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(),"user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN12;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN18;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUSYOUNIN);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不承認不備承認", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不承認不備承認", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不承認", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUSYOUNIN, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN1;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.SASIMODOSI);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "差戻し査定２次", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "差戻し査定２次", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "差戻し", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.SASIMODOSI, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "", "再割当ユーザーID");

    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN4;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.SASIMODOSI);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001","差戻し査定２次", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "差戻し査定２次", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "差戻し", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.SASIMODOSI, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN3;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN4;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN4;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.SASIMODOSI);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "差戻し査定３次", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "差戻し査定３次", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "差戻し", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.SASIMODOSI, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "", "再割当ユーザーID");

    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN4;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN3;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.SASIMODOSI);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "差戻し査定４次", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "差戻し査定４次", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "差戻し", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.SASIMODOSI, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN5;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN2;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.SASIMODOSI);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "差戻し手続（査定要）", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "差戻し手続（査定要）", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "差戻し", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.SASIMODOSI, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user0", "再割当ユーザーID");

    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN10;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN17;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.SASIMODOSI);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "差戻し点検", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "差戻し点検", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "差戻し", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.SASIMODOSI, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }


    @Test
    @TestOrder(220)
    public void testExec_A22() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN10;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN18;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.SASIMODOSI);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "差戻し点検", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "差戻し点検", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "差戻し", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.SASIMODOSI, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }


    @Test
    @TestOrder(230)
    public void testExec_A23() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN6;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN5;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.SASIMODOSI);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "差戻し承認（査定要）", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "差戻し承認（査定要）", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "差戻し", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.SASIMODOSI, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN7;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN6;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.SASIMODOSI);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "差戻し手続（査定不要）", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "差戻し手続（査定不要）", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "差戻し", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.SASIMODOSI, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN8;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN6;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.SASIMODOSI);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "差戻し承認（査定不要）", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "差戻し承認（査定不要）", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "差戻し", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.SASIMODOSI, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN9;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN7;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.SASIMODOSI);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "差戻し折衝２次", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "差戻し折衝２次", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "差戻し", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.SASIMODOSI, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN12;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN19;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.SASIMODOSI);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "差戻し不備承認", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "差戻し不備承認", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "差戻し", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.SASIMODOSI, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN12;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN18;
        CheckTaskKengenMockForSiharai.SYORIPTN = CheckTaskKengenMockForSiharai.TESTPATTERN3;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.SASIMODOSI);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "差戻し不備承認", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "差戻し不備承認", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "差戻し", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.SASIMODOSI, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "user1", "再割当ユーザーID");

    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN11;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN1;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUBIKAISYOU);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不備解消不備管理中", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不備解消不備管理中", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不備解消", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUBIKAISYOU, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "", "再割当ユーザーID");

    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN11;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN2;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUBIKAISYOU);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不備解消不備管理中", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不備解消不備管理中", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不備解消", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUBIKAISYOU, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "", "再割当ユーザーID");

    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN11;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN16;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUBIKAISYOU);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不備解消不備管理中", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不備解消不備管理中", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不備解消", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUBIKAISYOU, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "", "再割当ユーザーID");

    }
    @Test
    @TestOrder(320)
    public void testExec_A32() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN11;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN8;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUBIKAISYOU);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不備解消不備管理中", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不備解消不備管理中", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不備解消", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "査定１次", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUBIKAISYOU, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "", "再割当ユーザーID");

    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN11;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN9;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUBIKAISYOU);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不備解消不備管理中", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不備解消不備管理中", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不備解消", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "査定１次", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUBIKAISYOU, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "", "再割当ユーザーID");

    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN11;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN10;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUBIKAISYOU);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不備解消不備管理中", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不備解消不備管理中", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不備解消", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUBIKAISYOU, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "", "再割当ユーザーID");

    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN11;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN11;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUBIKAISYOU);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不備解消不備管理中", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不備解消不備管理中", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不備解消", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUBIKAISYOU, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "", "再割当ユーザーID");

    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN11;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN12;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUBIKAISYOU);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不備解消不備管理中", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不備解消不備管理中", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不備解消", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "手続（査定要）", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUBIKAISYOU, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "", "再割当ユーザーID");

    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN11;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN13;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUBIKAISYOU);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不備解消不備管理中", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不備解消不備管理中", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不備解消", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUBIKAISYOU, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "", "再割当ユーザーID");

    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN11;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN14;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUBIKAISYOU);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不備解消不備管理中", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不備解消不備管理中", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不備解消", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "手続（査定不要）", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUBIKAISYOU, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "", "再割当ユーザーID");

    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN11;
        BzGetProcessRecordMockForSiharai.SYORIPTN = BzGetProcessRecordMockForSiharai.TESTPATTERN15;
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        siRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUBIKAISYOU);
        siRuleBean.setSateiYhKbn(C_SateiYouhiKbn.YOU);
        siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU);
        siRuleBean.setSateiSanjiKaisouUmuKbn(C_UmuKbn.ARI);

        siProcessForward.exec("10000001", "sktenken", "Lock0001", "不備解消不備管理中", siRuleBean, "user99");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean) MockObjectManager.getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exClassificationEquals(bzGetProcessSummaryInBean.getSyukouteiSiborikomiUmu(), C_UmuKbn.NONE, "主工程絞り込み有無");

        BzGetProcessRecordInputBean bzGetProcessRecordInputBean =
            (BzGetProcessRecordInputBean) MockObjectManager.getArgument(BzGetProcessRecordMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetProcessRecordInputBean.getJimuTetuzukiCd(), null, "事務手続コードD");
        exStringEquals(bzGetProcessRecordInputBean.getKouteiKanriId(), "10000002", "業務キー");
        exClassificationEquals(bzGetProcessRecordInputBean.getRirekiKbn(), C_RirekiKbn.GYOUMU, "履歴区分");

        BzProcessForwardInBean bzProcessForwardInBean =
            (BzProcessForwardInBean) MockObjectManager.getArgument(BzProcessForwardMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "10000001", "工程管理ID");
        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), "sktenken", "事務手続コード");
        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "Lock0001", "工程ロックキー");
        exStringEquals(bzProcessForwardInBean.getSyoriComment(), "不備解消不備管理中", "処理コメント");

        SiIwfApiRuleBean siIwfApiRuleBean = (SiIwfApiRuleBean) bzProcessForwardInBean.getIwfApiRuleBean();
        exStringEquals(siIwfApiRuleBean.getSyoriKekkaNaiyou(), "不備解消", "処理結果内容");
        exStringEquals(siIwfApiRuleBean.getSateiYhNaiyou(), "査定要", "査定要否内容");
        exStringEquals(siIwfApiRuleBean.getSessyouYhNaiyou(), "要", "折衝要否内容");
        exStringEquals(siIwfApiRuleBean.getSateiSanjiKaisouUmuNaiyou(), "あり", "査定３次回送有無内容");
        exStringEquals(siIwfApiRuleBean.getHubiModorijiSenisakiNodeNm(), "デフォルト", "不備戻り時遷移先ノード名");

        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUBIKAISYOU, "処理結果区分");
        exStringEquals(bzProcessForwardInBean.getSaiwariateUserId(), "", "再割当ユーザーID");

    }
}
