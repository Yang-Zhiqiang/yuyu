package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.DrtenTkykTratkiHantei;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 申込基本TBLチェッククラスのメソッド {@link CheckTblMosKihon#exec(MosnaiCheckParam)} テストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTblMosKihonTest_exec2 extends AbstractTest{

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager manager;

    private final static String fileName = "UT_SP_単体テスト仕様書_申込基本TBLチェック";

    private final static String sheetName = "INデータ_20181031";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckHokenRyouYuukouKigen.class).to(CheckHokenRyouYuukouKigenMockForSinkeiyaku.class);
                bind(CheckKirikaeTratkikkn.class).to(CheckKirikaeTratkikknMockForSinkeiyaku.class);
                bind(CheckLivHuka.class).to(CheckLivHukaMockForSinkeiyaku.class);
                bind(CheckSntkHouSyouhin.class).to(CheckSntkHouSyouhinMockForSinkeiyaku.class);
                bind(CheckHrkKeiro.class).to(CheckHrkKeiroMockForSinkeiyaku.class);
                bind(CheckHrkKaisuu.class).to(CheckHrkKaisuuMockForSinkeiyaku.class);
                bind(CheckZennouKanren.class).to(CheckZennouKanrenMockForSinkeiyaku.class);
                bind(CheckMeigininNmKanaCall.class).to(CheckMeigininNmKanaCallMockForSinkeiyaku.class);
                bind(CheckSeiYmd.class).to(CheckSeiYmdMockForSinkeiyaku.class);
                bind(CheckTelNoCall.class).to(CheckTelNoCallMockForSinkeiyaku.class);
                bind(CheckKykSeiYmdKanren.class).to(CheckKykSeiYmdKanrenMockForSinkeiyaku.class);
                bind(CheckKykSeibetu.class).to(CheckKykSeibetuMockForSinkeiyaku.class);
                bind(CheckKykKanren.class).to(CheckKykKanrenMockForSinkeiyaku.class);
                bind(CheckNnknTokuyaku.class).to(CheckNnknTokuyakuMockForSinkeiyaku.class);
                bind(CheckPmentkKanren.class).to(CheckPmentkKanrenMockForSinkeiyaku.class);
                bind(HanteiKirikaeYuukou.class).to(HanteiKirikaeYuukouMockForSinkeiyaku.class);
                bind(CheckShiteiKeiyakubi.class).to(CheckShiteiKeiyakubiMockForSinkeiyaku.class);
                bind(CheckUktNinzuu.class).to(CheckUktNinzuuMockForSinkeiyaku.class);
                bind(DrtenTkykTratkiHantei.class).to(DrtenTkykTratkiHanteiMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){

        CheckHokenRyouYuukouKigenMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckKirikaeTratkikknMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckLivHukaMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckSntkHouSyouhinMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckHrkKeiroMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckHrkKaisuuMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckZennouKanrenMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckMeigininNmKanaCallMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckSeiYmdMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckTelNoCallMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckKykSeiYmdKanrenMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckKykSeibetuMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckKykKanrenMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckNnknTokuyakuMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckPmentkKanrenMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        HanteiKirikaeYuukouMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckShiteiKeiyakubiMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        CheckUktNinzuuMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

        DrtenTkykTratkiHanteiMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec2.class;

    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        CheckHokenRyouYuukouKigenMockForSinkeiyaku.caller = null;
        CheckHokenRyouYuukouKigenMockForSinkeiyaku.SYORIPTN = null;

        CheckKirikaeTratkikknMockForSinkeiyaku.caller = null;
        CheckKirikaeTratkikknMockForSinkeiyaku.SYORIPTN = null;

        CheckLivHukaMockForSinkeiyaku.caller = null;
        CheckLivHukaMockForSinkeiyaku.SYORIPTN = null;

        CheckSntkHouSyouhinMockForSinkeiyaku.caller = null;
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = null;

        CheckHrkKeiroMockForSinkeiyaku.caller = null;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = null;

        CheckHrkKaisuuMockForSinkeiyaku.caller = null;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = null;

        CheckZennouKanrenMockForSinkeiyaku.caller = null;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = null;

        CheckMeigininNmKanaCallMockForSinkeiyaku.caller = null;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = null;

        CheckSeiYmdMockForSinkeiyaku.caller = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;

        CheckTelNoCallMockForSinkeiyaku.caller = null;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = null;

        CheckKykSeiYmdKanrenMockForSinkeiyaku.caller = null;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = null;

        CheckKykSeibetuMockForSinkeiyaku.caller = null;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = null;

        CheckKykKanrenMockForSinkeiyaku.caller = null;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = null;

        CheckNnknTokuyakuMockForSinkeiyaku.caller = null;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = null;

        CheckPmentkKanrenMockForSinkeiyaku.caller = null;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = null;

        HanteiKirikaeYuukouMockForSinkeiyaku.caller = null;
        HanteiKirikaeYuukouMockForSinkeiyaku.SYORIPTN = null;

        CheckShiteiKeiyakubiMockForSinkeiyaku.caller = null;
        CheckShiteiKeiyakubiMockForSinkeiyaku.SYORIPTN = null;

        CheckUktNinzuuMockForSinkeiyaku.caller = null;
        CheckUktNinzuuMockForSinkeiyaku.SYORIPTN = null;

        DrtenTkykTratkiHanteiMockForSinkeiyaku.caller = null;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = null;

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTblMosKihonTest_exec2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
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
        bizDomManager.delete(bizDomManager.getAllChkTargetTkMokuhyouti());
        bizDomManager.delete(bizDomManager.getAllSyokugyou());
        bizDomManager.delete(bizDomManager.getAllAddress());
        bizDomManager.delete(bizDomManager.getAllSyouhnToriatukaiTuuka());
    }

    @Test
    @Transactional
    @TestOrder(810)
    public void testExec_R1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000502");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "被保険者年収の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(820)
    public void testExec_R2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000510");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }
    @Test
    @Transactional
    @TestOrder(830)
    public void testExec_R3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        YuyuSinkeiyakuConfig.getInstance().setKktKakoKyoyou(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000528");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }
    @Test
    @Transactional
    @TestOrder(840)
    public void testExec_R4() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000536");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }


    @Test
    @Transactional
    @TestOrder(850)
    public void testExec_R5() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000544");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(870)
    public void testExec_S1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000569");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckTelNoCallMockForSinkeiyaku.class, "execHhkn", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000569", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(880)
    public void testExec_S2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000577");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }


    @Test
    @Transactional
    @TestOrder(890)
    public void testExec_T1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000585");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckMeigininNmKanaCallMockForSinkeiyaku.class, "execKyk", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000585", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(900)
    public void testExec_T2() {

        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN3;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000593");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(910)
    public void testExec_T3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000601");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }


    @Test
    @Transactional
    @TestOrder(920)
    public void testExec_U1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000619");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckKykSeiYmdKanrenMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000619", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(930)
    public void testExec_U2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN2;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000627");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(940)
    public void testExec_U3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000635");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }


    @Test
    @Transactional
    @TestOrder(950)
    public void testExec_V1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000643");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckSeiYmdMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000643", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(960)
    public void testExec_V2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN3;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000650");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(970)
    public void testExec_V3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000668");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(980)
    public void testExec_W1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000676");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckKykSeibetuMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000676", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(990)
    public void testExec_W2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN2;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000684");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1000)
    public void testExec_W3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000692");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }


    @Test
    @Transactional
    @TestOrder(1010)
    public void testExec_X1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000700");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckKykKanrenMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000700", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(1020)
    public void testExec_X2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN2;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000718");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1030)
    public void testExec_X3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000726");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }


    @Test
    @Transactional
    @TestOrder(1040)
    public void testExec_Y1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000734");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckTelNoCallMockForSinkeiyaku.class, "execTuusin", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000734", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(1050)
    public void testExec_Y2() {

        MockObjectManager.initialize();
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN2;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000742");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1060)
    public void testExec_Y3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000759");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }


    @Test
    @Transactional
    @TestOrder(1070)
    public void testExec_Z1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000767");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckTelNoCallMockForSinkeiyaku.class, "execDainiTuusin", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000767", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(1080)
    public void testExec_Z2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000775");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }


    @Test
    @Transactional
    @TestOrder(1090)
    public void testExec_AA1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000783");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckNnknTokuyakuMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000783", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(1100)
    public void testExec_AA2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN2;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000791");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1110)
    public void testExec_AA3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000809");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1120)
    public void testExec_AB1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000817");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 2, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0087", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "事業一括の払込経路が団体になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0092", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "事業一括の契約者性別が法人契約になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");


    }

    @Test
    @Transactional
    @TestOrder(1130)
    public void testExec_AB2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000825");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0088", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "団体コードが代表申込番号の団体コードと相違しています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }
    @Test
    @Transactional
    @TestOrder(1140)
    public void testExec_AB3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000833");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }
    @Test
    @Transactional
    @TestOrder(1150)
    public void testExec_AB4() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000841");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0088", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "団体コードが代表申込番号の団体コードと相違しています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1160)
    public void testExec_AB5() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000858");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(1170)
    public void testExec_AB6() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000866");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(1180)
    public void testExec_AC1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000908");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckUktNinzuuMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000908", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(1190)
    public void testExec_AC2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000916");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1200)
    public void testExec_AD1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000924");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1065", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "定率積立・指数連動配分割合の合計が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }
    @Test
    @Transactional
    @TestOrder(1210)
    public void testExec_AD2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000932");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "指数連動部分割合の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }
    @Test
    @Transactional
    @TestOrder(1220)
    public void testExec_AD3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000940");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "定率積立部分割合の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }
    @Test
    @Transactional
    @TestOrder(1230)
    public void testExec_AD4() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000957");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }
    @Test
    @Transactional
    @TestOrder(1240)
    public void testExec_AD5() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000965");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }


    @Test
    @Transactional
    @TestOrder(1250)
    public void testExec_AE1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000973");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckPmentkKanrenMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000973", "申込番号");

        BM_SyouhnZokusei syouhnZokuseitemp = (BM_SyouhnZokusei) MockObjectManager.getArgument(
            CheckPmentkKanrenMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(syouhnZokuseitemp.getSyouhncd(), "D311", "商品コード");
        exNumericEquals(syouhnZokuseitemp.getSyouhnsdno(), 11, "商品世代番号");

    }

    @Test
    @Transactional
    @TestOrder(1260)
    public void testExec_AE2() {

        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN2;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000981");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1270)
    public void testExec_AE3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000999");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1280)
    public void testExec_AF1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        exClassificationEquals((C_TargetTkHukaKanouKbn)MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "targettkTratkiHantei", 0, 0), C_TargetTkHukaKanouKbn.NONE, "ターゲット特約付加可能区分");
        exClassificationEquals((C_SkeijimuKbn)MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "targettkTratkiHantei", 0, 1), C_SkeijimuKbn.BLNK, "新契約事務区分");
        exStringEquals((String)MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "targettkTratkiHantei", 0, 2), "", "親代理店コード");
    }

    @Test
    @Transactional
    @TestOrder(1290)
    public void testExec_AF2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001013");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標値　入力対象外の保険種類です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @Transactional
    @TestOrder(1300)
    public void testExec_AF3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001021");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }


    @Test
    @Transactional
    @TestOrder(1310)
    public void testExec_AF4() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN2;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001039");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1061", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保にはターゲット特約無しの付加が必要です。目標額割合を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        exClassificationEquals((C_TargetTkHukaKanouKbn)MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "targettkTratkiHantei", 0, 0), C_TargetTkHukaKanouKbn.NONE, "ターゲット特約付加可能区分");
        exClassificationEquals((C_SkeijimuKbn)MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "targettkTratkiHantei", 0, 1), C_SkeijimuKbn.BLNK, "新契約事務区分");
        exStringEquals((String)MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "targettkTratkiHantei", 0, 2), "1234567", "親代理店コード");
    }

    @Test
    @Transactional
    @TestOrder(1320)
    public void testExec_AF5() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN2;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001047");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標値　入力対象の保険種類です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");


    }

    @Test
    @Transactional
    @TestOrder(1330)
    public void testExec_AF6() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN2;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001054");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }


    @Test
    @Transactional
    @TestOrder(1340)
    public void testExec_AF7() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN6;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001062");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保にはターゲット特約無しを付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1350)
    public void testExec_AF8() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN3;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001070");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標値　入力対象外の保険種類です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1360)
    public void testExec_AF9() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN6;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001088");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
    @Test
    @Transactional
    @TestOrder(1370)
    public void testExec_AG1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN2;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001112");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "目標額割合の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1380)
    public void testExec_AG2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN2;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001120");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標額割合の入力が必要です。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @Transactional
    @TestOrder(1390)
    public void testExec_AG3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN2;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001138");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保の目標額割合が取扱範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @Transactional
    @TestOrder(1400)
    public void testExec_AG4() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN2;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001146");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "ゆゆ生保の目標額割合が取扱範囲外です。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");


    }

    @Test
    @Transactional
    @TestOrder(1410)
    public void testExec_AG5() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN2;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001153");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }


    @Test
    @Transactional
    @TestOrder(1420)
    public void testExec_AG6() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001161");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0012", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "目標額割合の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1430)
    public void testExec_AG7() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001179");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標額割合の入力は不要です。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1440)
    public void testExec_AG8() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001187");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1450)
    public void testExec_AH1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001203");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保には被保険者代理特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1460)
    public void testExec_AH2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001211");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "ゆゆ生保には被保険者代理特約を付加できません。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1470)
    public void testExec_AH3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001229");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1480)
    public void testExec_AH4() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001237");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1480)
    public void testExec_AH5() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003719");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1490)
    public void testExec_AI1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001245");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保には円貨支払特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1500)
    public void testExec_AI2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001252");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "ゆゆ生保には円貨支払特約を付加できません。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1510)
    public void testExec_AI3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001260");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1520)
    public void testExec_AI4() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001278");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }



    @Test
    @Transactional
    @TestOrder(1530)
    public void testExec_AJ1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN3;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001286");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "ゆゆ生保には保険料円貨払込特約の付加が必要です。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @Transactional
    @TestOrder(1540)
    public void testExec_AJ2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN3;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001286");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1083", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保には保険料円貨払込特約の付加が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(1550)
    public void testExec_AJ3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN3;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001310");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1560)
    public void testExec_AJ4() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001328");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1570)
    public void testExec_AJ5() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001294");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "ゆゆ生保には保険料円貨払込特約を付加できません。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1570)
    public void testExec_AJ6() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN4;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001294");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);
        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保には保険料円貨払込特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1570)
    public void testExec_AJ7() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN7;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001294");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);
        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(1570)
    public void testExec_AJ8() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001302");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);
        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(1580)
    public void testExec_AK1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001336");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "ゆゆ生保には保険料指定外通貨払込特約を付加できません。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1590)
    public void testExec_AK2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN5;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001336");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保には保険料指定外通貨払込特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1600)
    public void testExec_AK3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN6;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001336");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSekmossakuseiOyaAgCd("2000001");

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1610)
    public void testExec_AK4() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001344");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(1630)
    public void testExec_AL1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001385");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "重度介護前払特約付加区分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }


    @Test
    @Transactional
    @TestOrder(1640)
    public void testExec_AL2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001393");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }


    @Test
    @Transactional
    @TestOrder(1650)
    public void testExec_AL3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001401");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }


    @Test
    @Transactional
    @TestOrder(1660)
    public void testExec_AL4() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001419");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1036", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保は重度介護前払特約付加対象外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }


    @Test
    @Transactional
    @TestOrder(1670)
    public void testExec_AM1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001427");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1037", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "他契約にて重度介護前払特約が付加されているため、付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }


    @Test
    @Transactional
    @TestOrder(1680)
    public void testExec_AM2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001435");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "他契約にて重度介護前払特約が付加されているため付加できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1690)
    public void testExec_AM3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001443");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }



    @Test
    @Transactional
    @TestOrder(1700)
    public void testExec_AM4() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001450");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }


    @Test
    @Transactional
    @TestOrder(1710)
    public void testExec_AM5() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001468");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1720)
    public void testExec_AN1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001500");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBA0027", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "配当金受取方法を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }


    @Test
    @Transactional
    @TestOrder(1730)
    public void testExec_AN2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001518");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "配当金受取方法を入力してください。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1740)
    public void testExec_AN3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001526");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }



    @Test
    @Transactional
    @TestOrder(1750)
    public void testExec_AN4() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001534");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }


    @Test
    @Transactional
    @TestOrder(1760)
    public void testExec_AN5() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001542");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }




    @Test
    @Transactional
    @TestOrder(1770)
    public void testExec_AO1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001559");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBA0027", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "契約者本人確認書類情報を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }


    @Test
    @Transactional
    @TestOrder(1780)
    public void testExec_AO2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001567");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(1790)
    public void testExec_AO3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001575");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }


    @Test
    @Transactional
    @TestOrder(1800)
    public void testExec_AP1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001583");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1009", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "契約者が１８歳未満の場合、ダイレクトサービスは利用できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }


    @Test
    @Transactional
    @TestOrder(1810)
    public void testExec_AP2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001591");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(1820)
    public void testExec_AP3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001609");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }



    @Test
    @Transactional
    @TestOrder(1830)
    public void testExec_AP4() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001617");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }


    @Test
    @Transactional
    @TestOrder(1840)
    public void testExec_AP5() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001625");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(1850)
    public void testExec_AQ1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001633");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "WHC1013", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "手数料不支払契約です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
    }


    @Test
    @Transactional
    @TestOrder(1860)
    public void testExec_AQ2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001641");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(1870)
    public void testExec_AQ3() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001658");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }


    @Test
    @Transactional
    @TestOrder(1880)
    public void testExec_AR1() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001666");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }


    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(1890)
    public void testExec_AR2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckTelNoCallMockForSinkeiyaku.SYORIPTN = CheckTelNoCallMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeiYmdKanrenMockForSinkeiyaku.SYORIPTN = CheckKykSeiYmdKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckKykSeibetuMockForSinkeiyaku.SYORIPTN = CheckKykSeibetuMockForSinkeiyaku.TESTPATTERN1;
        CheckKykKanrenMockForSinkeiyaku.SYORIPTN = CheckKykKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckNnknTokuyakuMockForSinkeiyaku.SYORIPTN = CheckNnknTokuyakuMockForSinkeiyaku.TESTPATTERN1;
        CheckPmentkKanrenMockForSinkeiyaku.SYORIPTN = CheckPmentkKanrenMockForSinkeiyaku.TESTPATTERN1;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870001674");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180522"));
        try {
            checkTblMosKihon.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：870001674", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(1900)
    public void testExec_AS_1() {

        MockObjectManager.initialize();
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN8;

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("989800073");
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1075", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "販売チャネルが「みずほ」の場合、ダイレクトサービスは利用できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1910)
    public void testExec_AS_2() {

        MockObjectManager.initialize();
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN8;
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("989800081");
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        System.out.println(hubiMsgLst);
        exNumericEquals(hubiMsgLst.size(), 1, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1139", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ダイレクトサービス申込区分を指定してください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1920)
    public void testExec_AS_3() {

        MockObjectManager.initialize();
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN8;
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("989800099");
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        System.out.println(hubiMsgLst);
        exNumericEquals(hubiMsgLst.size(), 1, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1009", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "契約者が１８歳未満の場合、ダイレクトサービスは利用できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1930)
    public void testExec_AS_4() {

        MockObjectManager.initialize();
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN8;
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("989800065");
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        System.out.println(hubiMsgLst);
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(1940)
    public void testExec_AS_5() {

        MockObjectManager.initialize();
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN8;
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("989800008");
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        System.out.println(hubiMsgLst);
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(1950)
    public void testExec_AS_6() {

        MockObjectManager.initialize();
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN8;
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("989800016");
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        System.out.println(hubiMsgLst);
         exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(1960)
    public void testExec_AS_7() {

        MockObjectManager.initialize();
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN8;

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000306");
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);



        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        System.out.println(hubiMsgLst);
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(1970)
    public void testExec_AS_8() {

        MockObjectManager.initialize();
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN8;
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        System.out.println(hubiMsgLst);
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

}
