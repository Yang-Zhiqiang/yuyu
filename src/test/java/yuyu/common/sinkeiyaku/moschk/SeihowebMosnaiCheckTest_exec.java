package yuyu.common.sinkeiyaku.moschk;

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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 生保Ｗｅｂ申込内容チェック{@link SeihowebMosnaiCheck#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SeihowebMosnaiCheckTest_exec {

    @Inject
    private SeihowebMosnaiCheck seihowebMosnaiCheck;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_生保Ｗｅｂ申込内容チェック";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(JidouSetSyokika.class).to(JidouSetSyokikaMockForSinkeiyaku.class);
                bind(SetKisoKoumoku.class).to(SetKisoKoumokuMockForSinkeiyaku.class);
                bind(CheckYoteiKykYmd.class).to(CheckYoteiKykYmdMockForSinkeiyaku.class);
                bind(CheckTblMosDairiten.class).to(CheckTblMosDairitenMockForSinkeiyaku.class);
                bind(CheckTblMosKihon.class).to(CheckTblMosKihonMockForSinkeiyaku.class);
                bind(CheckTblMosSyouhin.class).to(CheckTblMosSyouhinMockForSinkeiyaku.class);
                bind(CheckTblUketorinin.class).to(CheckTblUketorininMockForSinkeiyaku.class);
                bind(CheckSentakujyouhou.class).to(CheckSentakujyouhouMockForSinkeiyaku.class);
                bind(SetSP.class).to(SetSPMockForSinkeiyaku.class);
                bind(CheckSP.class).to(CheckSPMockForSinkeiyaku.class);
                bind(CheckSkTuusan.class).to(CheckSkTuusanMockForSinkeiyaku.class);
            }
        });
    }


    @BeforeClass
    public static void testInit() {
        JidouSetSyokikaMockForSinkeiyaku.caller = SeihowebMosnaiCheckTest_exec.class;
        SetKisoKoumokuMockForSinkeiyaku.caller = SeihowebMosnaiCheckTest_exec.class;
        CheckYoteiKykYmdMockForSinkeiyaku.caller = SeihowebMosnaiCheckTest_exec.class;
        CheckTblMosDairitenMockForSinkeiyaku.caller = SeihowebMosnaiCheckTest_exec.class;
        CheckTblMosKihonMockForSinkeiyaku.caller = SeihowebMosnaiCheckTest_exec.class;
        CheckTblMosSyouhinMockForSinkeiyaku.caller = SeihowebMosnaiCheckTest_exec.class;
        CheckTblUketorininMockForSinkeiyaku.caller = SeihowebMosnaiCheckTest_exec.class;
        CheckSentakujyouhouMockForSinkeiyaku.caller = SeihowebMosnaiCheckTest_exec.class;
        SetSPMockForSinkeiyaku.caller = SeihowebMosnaiCheckTest_exec.class;
        CheckSPMockForSinkeiyaku.caller = SeihowebMosnaiCheckTest_exec.class;
        CheckSkTuusanMockForSinkeiyaku.caller = SeihowebMosnaiCheckTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        JidouSetSyokikaMockForSinkeiyaku.caller = null;
        SetKisoKoumokuMockForSinkeiyaku.caller = null;
        CheckYoteiKykYmdMockForSinkeiyaku.caller = null;
        CheckTblMosDairitenMockForSinkeiyaku.caller = null;
        CheckTblMosKihonMockForSinkeiyaku.caller = null;
        CheckTblMosSyouhinMockForSinkeiyaku.caller = null;
        CheckTblUketorininMockForSinkeiyaku.caller = null;
        CheckSentakujyouhouMockForSinkeiyaku.caller = null;
        SetSPMockForSinkeiyaku.caller = null;
        CheckSPMockForSinkeiyaku.caller = null;
        CheckSkTuusanMockForSinkeiyaku.caller = null;

        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = null;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = null;
        CheckYoteiKykYmdMockForSinkeiyaku.SYORIPTN = null;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = null;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = null;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = null;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = null;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = null;
        SetSPMockForSinkeiyaku.SYORIPTN = null;
        CheckSPMockForSinkeiyaku.SYORIPTN = null;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SeihowebMosnaiCheckTest_exec.class, fileName, sheetName);
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
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1_1() {

        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN1;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;

        seihowebMosnaiCheck.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A1_2() {

        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;

        seihowebMosnaiCheck.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A2() {

        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;
        CheckYoteiKykYmdMockForSinkeiyaku.SYORIPTN = CheckYoteiKykYmdMockForSinkeiyaku.TESTPATTERN1;

        seihowebMosnaiCheck.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A3() {

        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;
        CheckYoteiKykYmdMockForSinkeiyaku.SYORIPTN = CheckYoteiKykYmdMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN1;

        seihowebMosnaiCheck.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A4() {

        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;
        CheckYoteiKykYmdMockForSinkeiyaku.SYORIPTN = CheckYoteiKykYmdMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN2;

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        seihowebMosnaiCheck.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A5() {

        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;
        CheckYoteiKykYmdMockForSinkeiyaku.SYORIPTN = CheckYoteiKykYmdMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN1;

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        seihowebMosnaiCheck.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A6() {

        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;
        CheckYoteiKykYmdMockForSinkeiyaku.SYORIPTN = CheckYoteiKykYmdMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        seihowebMosnaiCheck.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A7() {

        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;
        CheckYoteiKykYmdMockForSinkeiyaku.SYORIPTN = CheckYoteiKykYmdMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN2;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN1;

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        seihowebMosnaiCheck.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A8() {

        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;
        CheckYoteiKykYmdMockForSinkeiyaku.SYORIPTN = CheckYoteiKykYmdMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN2;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN2;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN1;

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        seihowebMosnaiCheck.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A9() {

        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;
        CheckYoteiKykYmdMockForSinkeiyaku.SYORIPTN = CheckYoteiKykYmdMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN2;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN2;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN2;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        seihowebMosnaiCheck.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A10() {

        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;
        CheckYoteiKykYmdMockForSinkeiyaku.SYORIPTN = CheckYoteiKykYmdMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN2;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN2;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN2;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN2;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        seihowebMosnaiCheck.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A11() {

        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;
        CheckYoteiKykYmdMockForSinkeiyaku.SYORIPTN = CheckYoteiKykYmdMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN2;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN2;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN2;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN2;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN2;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        seihowebMosnaiCheck.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A12() {

        JidouSetSyokikaMockForSinkeiyaku.SYORIPTN = JidouSetSyokikaMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;
        CheckYoteiKykYmdMockForSinkeiyaku.SYORIPTN = CheckYoteiKykYmdMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosDairitenMockForSinkeiyaku.SYORIPTN = CheckTblMosDairitenMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosKihonMockForSinkeiyaku.SYORIPTN = CheckTblMosKihonMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN2;
        CheckTblUketorininMockForSinkeiyaku.SYORIPTN = CheckTblUketorininMockForSinkeiyaku.TESTPATTERN2;
        CheckSentakujyouhouMockForSinkeiyaku.SYORIPTN = CheckSentakujyouhouMockForSinkeiyaku.TESTPATTERN2;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN2;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN2;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN2;

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        seihowebMosnaiCheck.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }
}
