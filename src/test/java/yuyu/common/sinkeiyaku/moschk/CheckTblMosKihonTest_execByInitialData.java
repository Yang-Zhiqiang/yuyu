package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.GetAdrDataMock;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込基本TBLチェッククラスのメソッド {@link CheckTblMosKihon#exec(MosnaiCheckParam)} の初期データテスト(初期データのターゲット特約目標値チェックマスタ)用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTblMosKihonTest_execByInitialData extends AbstractTest{

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager manager;

    private final static String fileName = "UT-SP_単体テスト仕様書（機能）_申込基本TBLチェック_追加";

    private final static String sheetName = "INデータ (初期データチェック)";

    @BeforeClass
    public static void testInit(){
        GetAdrDataMock.caller = CheckTblMosKihonTest_execByInitialData.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTblMosKihonTest_execByInitialData.class, fileName, sheetName);
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
    }

    @Test
    @Transactional
    @TestOrder(5001)
    public void testExec_1_1() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000013");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5002)
    public void testExec_1_2() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000021");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5003)
    public void testExec_1_3() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000039");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5004)
    public void testExec_1_4() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000047");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5005)
    public void testExec_1_5() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000054");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5006)
    public void testExec_1_6() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000062");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5007)
    public void testExec_1_7() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000070");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5008)
    public void testExec_1_8() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000088");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5009)
    public void testExec_1_9() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000096");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5010)
    public void testExec_1_10() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000104");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(5011)
    public void testExec_1_11() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000112");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5012)
    public void testExec_1_12() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000120");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(5013)
    public void testExec_1_13() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000138");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5014)
    public void testExec_1_14() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000146");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(5015)
    public void testExec_1_15() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000153");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(5016)
    public void testExec_1_16() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000161");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5017)
    public void testExec_1_17() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000179");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(5018)
    public void testExec_1_18() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000187");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(5019)
    public void testExec_1_19() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000195");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5020)
    public void testExec_1_20() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000203");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5021)
    public void testExec_1_21() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000211");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5022)
    public void testExec_1_22() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000229");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5023)
    public void testExec_1_23() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000237");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5024)
    public void testExec_1_24() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000245");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5025)
    public void testExec_1_25() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000252");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5026)
    public void testExec_1_26() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000260");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5027)
    public void testExec_1_27() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000278");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5028)
    public void testExec_1_28() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000286");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5029)
    public void testExec_1_29() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000294");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5030)
    public void testExec_1_30() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000302");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5031)
    public void testExec_1_31() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000310");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5032)
    public void testExec_1_32() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000328");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5033)
    public void testExec_1_33() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000336");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5034)
    public void testExec_1_34() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000344");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5035)
    public void testExec_1_35() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000351");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5036)
    public void testExec_1_36() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000369");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5037)
    public void testExec_1_37() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000377");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5038)
    public void testExec_1_38() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000385");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5039)
    public void testExec_1_39() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000393");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5040)
    public void testExec_1_40() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000401");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5041)
    public void testExec_1_41() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000419");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5042)
    public void testExec_1_42() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000427");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5043)
    public void testExec_1_43() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000435");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5044)
    public void testExec_1_44() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000443");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5045)
    public void testExec_1_45() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000450");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5046)
    public void testExec_1_46() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000468");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5047)
    public void testExec_1_47() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000476");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5048)
    public void testExec_1_48() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000484");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5049)
    public void testExec_1_49() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000492");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5050)
    public void testExec_1_50() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000500");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5051)
    public void testExec_1_51() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000518");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5052)
    public void testExec_1_52() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000526");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5053)
    public void testExec_1_53() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000534");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5054)
    public void testExec_1_54() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000542");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5055)
    public void testExec_1_55() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000559");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5056)
    public void testExec_1_56() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000567");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5057)
    public void testExec_1_57() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000575");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5058)
    public void testExec_1_58() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000583");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5059)
    public void testExec_1_59() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000591");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5060)
    public void testExec_1_60() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000609");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5061)
    public void testExec_1_61() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000617");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5062)
    public void testExec_1_62() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000625");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5063)
    public void testExec_1_63() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000633");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5064)
    public void testExec_1_64() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000641");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5065)
    public void testExec_1_65() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000658");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5066)
    public void testExec_1_66() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000666");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5067)
    public void testExec_1_67() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000674");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5068)
    public void testExec_1_68() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000682");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5069)
    public void testExec_1_69() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000690");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5070)
    public void testExec_1_70() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000708");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5071)
    public void testExec_1_71() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000716");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5072)
    public void testExec_1_72() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000724");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5073)
    public void testExec_1_73() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000732");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5074)
    public void testExec_1_74() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000740");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5075)
    public void testExec_1_75() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000757");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5076)
    public void testExec_1_76() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000765");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5077)
    public void testExec_1_77() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000773");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（米ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5078)
    public void testExec_1_78() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000781");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5079)
    public void testExec_1_79() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000799");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5080)
    public void testExec_1_80() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000807");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5081)
    public void testExec_1_81() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000815");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5082)
    public void testExec_1_82() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000823");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5083)
    public void testExec_1_83() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000831");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5084)
    public void testExec_1_84() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000849");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5085)
    public void testExec_1_85() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000856");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5086)
    public void testExec_1_86() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000864");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5087)
    public void testExec_1_87() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000872");

        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(5088)
    public void testExec_1_88() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("971000880");


        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（豪ドル）にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
}