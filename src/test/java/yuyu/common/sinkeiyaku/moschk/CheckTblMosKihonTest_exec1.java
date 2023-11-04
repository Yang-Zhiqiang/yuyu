package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

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

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.khcommon.CheckZeiseiTkkkTkykHukaJyouken;
import yuyu.common.hozen.khcommon.CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.DrtenTkykTratkiHantei;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
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

import com.google.inject.AbstractModule;

/**
 * 申込基本TBLチェッククラスのメソッド {@link CheckTblMosKihon#exec(MosnaiCheckParam)} テストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTblMosKihonTest_exec1 extends AbstractTest{

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
                bind(CheckZeiseiTkkkTkykHukaJyouken.class).to(CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){

        CheckHokenRyouYuukouKigenMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckKirikaeTratkikknMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckLivHukaMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckSntkHouSyouhinMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckHrkKeiroMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckHrkKaisuuMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckZennouKanrenMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckMeigininNmKanaCallMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckSeiYmdMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckTelNoCallMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckKykSeiYmdKanrenMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckKykSeibetuMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckKykKanrenMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckNnknTokuyakuMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckPmentkKanrenMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        HanteiKirikaeYuukouMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckShiteiKeiyakubiMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckUktNinzuuMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        DrtenTkykTratkiHanteiMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

        CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.caller = CheckTblMosKihonTest_exec1.class;

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

        CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.caller = null;
        CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.SYORIPTN = null;

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTblMosKihonTest_exec1.class, fileName, sheetName);
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
    @TestOrder(10)
    public void testExec_A1() {

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


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112352");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180521"));

        checkTblMosKihon.exec(mosnaiCheckParam);
        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

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

        YuyuSinkeiyakuConfig.getInstance().setKktKakoKyoyou(2);
        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(101);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112311");
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

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckHokenRyouYuukouKigenMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "791112311", "申込番号");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_B1() {

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

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(1);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180516"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "TBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】申込日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_B2() {

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

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(1);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180505"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "TBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】申込日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_B3() {
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

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(1);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180426"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "KBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "（特認済）申込日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_B4() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180416"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_B5() {
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

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180409"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_B6() {
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

        YuyuSinkeiyakuConfig.getInstance().setKktKakoKyoyou(2);
        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(101);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112329");
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
    @TestOrder(80)
    public void testExec_C1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112225");
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
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "申込書受付日の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }


    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_C2() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112233");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180516"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 2, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "WHC0094", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "申込書機械作成日が申込日の後日付になっています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");

        exStringEquals(hubiMsgLst.get(1).getMessageId(), "WHC0095", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "申込日が申込書受付日の後日付になっています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
    }


    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_C3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112241");
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
    @TestOrder(110)
    public void testExec_C4() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112258");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180517"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "WHC0096", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "申込日から申込書受付日までが０日間以上になっています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
    }


    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_C5() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112266");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180518"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 2, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "申込書受付日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsgLst.get(1).getMessageId(), "WHC0096", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "申込日から申込書受付日までが０日間以上になっています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
    }


    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_C6() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112274");
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
    @TestOrder(140)
    public void testExec_D1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112282");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "WHC0081", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "商品切替の申込です。（同時解約証券番号：１１８０７１１１１１８）", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");

        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(
            HanteiKirikaeYuukouMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "861112282", "申込番号");

        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckKirikaeTratkikknMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp2.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), "861112282", "申込番号");
    }


    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_D2() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112290");
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
    @TestOrder(160)
    public void testExec_D3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112308");
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
    @TestOrder(170)
    public void testExec_E1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112316");
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

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckShiteiKeiyakubiMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "861112316", "申込番号");
    }


    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_E2() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112324");
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
    @TestOrder(190)
    public void testExec_F1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112332");
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

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckLivHukaMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "861112332", "申込番号");

        BM_SyouhnZokusei syouhnZokuseitemp = (BM_SyouhnZokusei) MockObjectManager.getArgument(
            CheckLivHukaMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(syouhnZokuseitemp.getSyouhncd(), "C401", "商品コード");
        exNumericEquals(syouhnZokuseitemp.getSyouhnsdno(), 11, "商品世代番号");
    }


    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_F2() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112340");
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
    @TestOrder(210)
    public void testExec_F3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112357");
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
    @TestOrder(220)
    public void testExec_G1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112365");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保のＳ建は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }


    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_G2() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112373");
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
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "Ｐ建にしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_G3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112381");
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
    @TestOrder(250)
    public void testExec_G4() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112399");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保のＰ建は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }


    @Test
    @Transactional
    @TestOrder(260)
    public void testExec_G5() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112407");
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
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "Ｓ建にしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testExec_G6() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112415");
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
    @TestOrder(280)
    public void testExec_G7() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002005");
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
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "Ｓ建Ｐ建を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(285)
    public void testExec_G8() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001999");
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
    @TestOrder(290)
    public void testExec_H1() {

        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN2;
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112423");
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

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckSntkHouSyouhinMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "861112423", "申込番号");

        BM_SyouhnZokusei syouhnZokusei1 = (BM_SyouhnZokusei) MockObjectManager.getArgument(
            CheckSntkHouSyouhinMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(syouhnZokusei1.getSyouhncd(), "C601", "商品コード");
        exNumericEquals(syouhnZokusei1.getSyouhnsdno(), 11, "商品世代番号");
    }

    @Test
    @Transactional
    @TestOrder(300)
    public void testExec_H2() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112415");
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
    @TestOrder(310)
    public void testExec_H3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112449");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0021", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "告知扱に報状入力があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(320)
    public void testExec_H4() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112456");
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
    @TestOrder(330)
    public void testExec_H5() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112464");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0020", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "無告知に告知書入力があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0021", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "無告知に報状入力があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @Transactional
    @TestOrder(340)
    public void testExec_H6() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112472");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0020", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "無告知に告知書入力があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @Transactional
    @TestOrder(350)
    public void testExec_H7() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112480");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0021", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "職業のみ告知に報状入力があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @Transactional
    @TestOrder(360)
    public void testExec_H8() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112498");
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
    @TestOrder(370)
    public void testExec_H9() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861112506");
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
    @TestOrder(380)
    public void testExec_I1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000015");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180521"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBA0027", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "告知日を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @Transactional
    @TestOrder(390)
    public void testExec_I2() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000023");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180520"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "TBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】告知日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @Transactional
    @TestOrder(400)
    public void testExec_I3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000031");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "KBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "（特認済）告知日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @Transactional
    @TestOrder(410)
    public void testExec_I4() {

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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000049");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180521"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }
    @Test
    @Transactional
    @TestOrder(420)
    public void testExec_I5() {
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

        YuyuSinkeiyakuConfig.getInstance().setKktKakoKyoyou(2);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000056");
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
    @TestOrder(430)
    public void testExec_I6() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000064");
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
    @TestOrder(440)
    public void testExec_I7() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000072");
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
    @TestOrder(450)
    public void testExec_J1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000114");
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
            CheckHrkKaisuuMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000114", "申込番号");

        BM_SyouhnZokusei syouhnZokusei1 = (BM_SyouhnZokusei) MockObjectManager.getArgument(
            CheckHrkKaisuuMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(syouhnZokusei1.getSyouhncd(), "D101", "商品コード");
        exNumericEquals(syouhnZokusei1.getSyouhnsdno(), 11, "商品世代番号");
    }


    @Test
    @Transactional
    @TestOrder(460)
    public void testExec_J2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN2;
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000122");
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
    @TestOrder(470)
    public void testExec_J3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000130");
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
    @TestOrder(480)
    public void testExec_K1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000148");
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
            CheckHrkKeiroMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000148", "申込番号");

        BM_SyouhnZokusei syouhnZokusei1 = (BM_SyouhnZokusei) MockObjectManager.getArgument(
            CheckHrkKeiroMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(syouhnZokusei1.getSyouhncd(), "D111", "商品コード");
        exNumericEquals(syouhnZokusei1.getSyouhnsdno(), 11, "商品世代番号");

    }


    @Test
    @Transactional
    @TestOrder(490)
    public void testExec_K2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN2;
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000155");
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
    @TestOrder(500)
    public void testExec_K3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000163");
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

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(510)
    public void testExec_L1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000171");
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
            CheckZennouKanrenMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000171", "申込番号");


    }


    @Test
    @Transactional
    @TestOrder(520)
    public void testExec_L2() {

        MockObjectManager.initialize();
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN2;
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000189");
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

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(530)
    public void testExec_L3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000197");
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

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(540)
    public void testExec_M1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000205");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180416"));

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
    @TestOrder(550)
    public void testExec_M2() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000213");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180416"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "末子生年月日は不要です。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @Transactional
    @TestOrder(560)
    public void testExec_M3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000221");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180416"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "末子生年月日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @Transactional
    @TestOrder(570)
    public void testExec_M4() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000239");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180416"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "末子生年月日の入力が必要です。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @Transactional
    @TestOrder(580)
    public void testExec_M5() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000247");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180416"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "TBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】末子生年月日の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(590)
    public void testExec_M6() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000254");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180416"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "末子生年月日の入力が必要です。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @Transactional
    @TestOrder(600)
    public void testExec_M7() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000262");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180416"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");


        exStringEquals(hubiMsgLst.get(0).getMessageId(), "KBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "（特認済）末子生年月日の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @Transactional
    @TestOrder(610)
    public void testExec_M8() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000270");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180416"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "末子生年月日の入力が必要です。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @Transactional
    @TestOrder(620)
    public void testExec_M9() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000288");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180416"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "TBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】末子生年月日の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");


    }


    @Test
    @Transactional
    @TestOrder(630)
    public void testExec_M10() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000296");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180416"));

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
    @TestOrder(640)
    public void testExec_M11() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000304");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180416"));

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
    @TestOrder(650)
    public void testExec_M12() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000312");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180416"));

        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "末子生年月日が正しくありません。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(660)
    public void testExec_N1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000320");
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
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "１Ｐ領収予定日の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(670)
    public void testExec_N2() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000338");
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
    @TestOrder(680)
    public void testExec_N3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000346");
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
    @TestOrder(690)
    public void testExec_N4() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000353");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0007", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "１Ｐ領収予定日は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }


    @Test
    @Transactional
    @TestOrder(700)
    public void testExec_N5() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000361");
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
    @TestOrder(710)
    public void testExec_O1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000379");
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
            CheckMeigininNmKanaCallMockForSinkeiyaku.class, "execHhkn", 0, 0);
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000379", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(720)
    public void testExec_O2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN2;
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000387");
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
    @TestOrder(730)
    public void testExec_O3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000395");
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
    @TestOrder(740)
    public void testExec_P1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000403");
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
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "870000403", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(750)
    public void testExec_P2() {
        MockObjectManager.initialize();
        CheckSntkHouSyouhinMockForSinkeiyaku.SYORIPTN = CheckSntkHouSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKaisuuMockForSinkeiyaku.SYORIPTN = CheckHrkKaisuuMockForSinkeiyaku.TESTPATTERN1;
        CheckHrkKeiroMockForSinkeiyaku.SYORIPTN = CheckHrkKeiroMockForSinkeiyaku.TESTPATTERN1;
        CheckZennouKanrenMockForSinkeiyaku.SYORIPTN = CheckZennouKanrenMockForSinkeiyaku.TESTPATTERN1;
        CheckMeigininNmKanaCallMockForSinkeiyaku.SYORIPTN = CheckMeigininNmKanaCallMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN2;
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000411");
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
    @TestOrder(760)
    public void testExec_P3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000429");
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
    @TestOrder(770)
    public void testExec_Q1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000437");
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
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "被保険者職業コードの入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(780)
    public void testExec_Q2() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000445");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBA0030", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "指定された被保険者職業コードは存在しません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(790)
    public void testExec_Q3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000452");
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
    @TestOrder(800)
    public void testExec_Q4() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000460");
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
    @TestOrder(810)
    public void testExec_AT1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003453");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "個人年金保険料税制適格特約の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(820)
    public void testExec_AT2() {
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
        CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.SYORIPTN = CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003461");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0014", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "個人年金保険料税制適格特約は付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(830)
    public void testExec_AT3() {
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
        CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.SYORIPTN = CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.TESTPATTERN2;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003461");
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
    public void testExec_AT4() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003479");
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
    public void testExec_AT5() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003487");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0014", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "個人年金保険料税制適格特約は付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(860)
    public void testExec_AT6() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003495");
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
    @TestOrder(870)
    public void testExec_AT7() {
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
        CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.SYORIPTN = CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003503");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0014", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "個人年金保険料税制適格特約は付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(870)
    public void testExec_AT8() {
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
        CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.SYORIPTN = CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.TESTPATTERN11;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003503");
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
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(),"","設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(),"年金税制適格基準エラー　年金受取人は被保険者にしてください","設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(890)
    public void testExec_AT9() {
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
        CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.SYORIPTN = CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.TESTPATTERN12;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003503");
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
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(),"","設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(),"年金税制適格基準エラー　被保険者は契約者または契約者の配偶者にしてください","設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(900)
    public void testExec_AT10() {
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
        CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.SYORIPTN = CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.TESTPATTERN13;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003503");
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
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(),"","設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(),"年金税制適格基準エラー　保険料払込期間は１０年以上にしてください","設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(910)
    public void testExec_AT11() {
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
        CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.SYORIPTN = CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.TESTPATTERN14;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003503");
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
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(),"","設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(),"年金税制適格基準エラー　年金支払期間は１０年以上にしてください","設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(920)
    public void testExec_AT12() {
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
        CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.SYORIPTN = CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.TESTPATTERN15;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003503");
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
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(),"","設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(),"年金税制適格基準エラー　年金開始年齢は６０歳以上にしてください","設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(930)
    public void testExec_AT13() {
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
        CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.SYORIPTN = CheckZeiseiTkkkTkykHukaJyoukenMockForSinkeiyaku.TESTPATTERN1;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003503");
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
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "不備種別区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(),"","設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(),"個人年金保険料税制適格特約は付加できません。","設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(940)
    public void testExec_AU1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003511");
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
    @TestOrder(950)
    public void testExec_AU2() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003529");
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
    @TestOrder(960)
    public void testExec_AU3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003537");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1115", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "年金支払開始年齢には、被保険者年齢未満の年齢は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(970)
    public void testExec_AU4() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003545");
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
    @TestOrder(980)
    public void testExec_AU5() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003552");
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
    @TestOrder(990)
    public void testExec_AU6() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003560");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1116", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "保険料払込満了年齢には、被保険者年齢未満の年齢は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(1000)
    public void testExec_AU7() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003578");
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
    @TestOrder(1010)
    public void testExec_AU8() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003586");
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
    @TestOrder(1020)
    public void testExec_AV1() {
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
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN9;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003594");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1083", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保には初期死亡時円換算支払額最低保証特約の付加が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        String pSyouhncd = (String) MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "initsbjiYenknsnshrgkSaiteihsytkTratkiHantei", 0, 0);

        exStringEquals(pSyouhncd, "D479", "商品コード");

        C_UmuKbn syksbyensitihsyutktekiumu = (C_UmuKbn) MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "initsbjiYenknsnshrgkSaiteihsytkTratkiHantei", 0, 1);

        exClassificationEquals(syksbyensitihsyutktekiumu, C_UmuKbn.ARI, "初期死亡時円換算最低保証特約適用有無");

        C_SkeijimuKbn skeijimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "initsbjiYenknsnshrgkSaiteihsytkTratkiHantei", 0, 2);

        exClassificationEquals(skeijimuKbn, C_SkeijimuKbn.BLNK, "新契約事務区分");

        String pOyadrtencd = (String) MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "initsbjiYenknsnshrgkSaiteihsytkTratkiHantei", 0, 3);

        exStringEquals(pOyadrtencd, "5100001", "親代理店コード ");
    }

    @Test
    @Transactional
    @TestOrder(1030)
    public void testExec_AV2() {
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
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN9;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003602");
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
    @TestOrder(1040)
    public void testExec_AV3() {
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
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN10;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003610");
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
    @TestOrder(1050)
    public void testExec_AV4() {
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
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN10;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003628");
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
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保には初期死亡時円換算支払額最低保証特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(1060)
    public void testExec_AW1() {
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
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN9;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003636");
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
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保にはご家族登録サービスを付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(1070)
    public void testExec_AW2() {
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
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN9;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003644");
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
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "ゆゆ生保にはご家族登録サービスを付加できません。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1080)
    public void testExec_AW3() {
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
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN9;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003651");
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
    @TestOrder(1090)
    public void testExec_AW4() {
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
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN9;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003669");
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
    @TestOrder(1091)
    public void testExec_AW5() {
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
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN9;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003727");
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
    @TestOrder(1100)
    public void testExec_AX1() {
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
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN9;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003677");
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
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ゆゆ生保には保険契約者代理特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(1110)
    public void testExec_AX2() {
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
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN9;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003685");
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
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "ゆゆ生保には保険契約者代理特約を付加できません。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @Transactional
    @TestOrder(1120)
    public void testExec_AX3() {
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
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN9;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003693");
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
    @TestOrder(1130)
    public void testExec_AX4() {
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
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN9;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003701");
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
    @TestOrder(1131)
    public void testExec_AX5() {
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
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN9;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(0);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(0);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980003735");
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
    @TestOrder(1200)
    public void testExec_AY1() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
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

        exStringEquals(hubiMsgLst.get(3).getMessageId(), "EHC1083", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "初期死亡保険金抑制型一時払終身保険（外貨建）には指定通貨建年金保険定期支払特約の付加が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(1210)
    public void testExec_AY2() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000157");
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

        exStringEquals(hubiMsgLst.get(3).getMessageId(), "EHC1142", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "指数連動部分割合ありの場合、指定通貨建年金保険定期支払特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(1220)
    public void testExec_AY3() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "TBC0046", "メッセージＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(1230)
    public void testExec_AY4() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000173");
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "TBC0046", "メッセージＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(1240)
    public void testExec_AY5() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000231");
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "TBC0046", "メッセージＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(1250)
    public void testExec_AY6() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "TBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "指定通貨建年金保険定期支払特約の入力が必要です。", "不備メッセージ");

    }

    @Test
    @Transactional
    @TestOrder(1260)
    public void testExec_AY7() {
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
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

        exStringEquals(hubiMsgLst.get(3).getMessageId(), "EBC0014", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "指定通貨建年金保険定期支払特約は付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(1280)
    public void testExec_AY8() {

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

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000264");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180521"));

        checkTblMosKihon.exec(mosnaiCheckParam);
        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(1290)
    public void testExec_AY9() {

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

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001007");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180521"));

        checkTblMosKihon.exec(mosnaiCheckParam);
        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(1300)
    public void testExec_AY10() {

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

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000991");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180521"));

        checkTblMosKihon.exec(mosnaiCheckParam);
        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "EBC0014", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "指定通貨建年金保険定期支払特約は付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1310)
    public void testExec_AZ1() {

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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001981");
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1166", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "初期死亡保険金抑制型一時払終身保険（外貨建）の指定通貨円　払込通貨円　全期前納なしは取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1320)
    public void testExec_AZ2() {

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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001973");
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
    @TestOrder(1330)
    public void testExec_AZ3() {

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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860223346");
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1166", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "初期死亡保険金抑制型一時払終身保険（外貨建）の指定通貨円　払込通貨円　全期前納ありは取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1340)
    public void testExec_BA1() {

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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002062");
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1169", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "円貨払込額ご案内通知の希望有無を選択してください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1350)
    public void testExec_BA2() {

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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002070");
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
    @TestOrder(1360)
    public void testExec_BA3() {

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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002088");
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
    @TestOrder(1370)
    public void testExec_BA4() {

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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002096");
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1170", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "円貨払込額ご案内通知の希望有無は選択できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1370)
    public void testExec_BA5() {

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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002104");
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
    @TestOrder(1380)
    public void testExec_BA6() {

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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002062");
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
}
