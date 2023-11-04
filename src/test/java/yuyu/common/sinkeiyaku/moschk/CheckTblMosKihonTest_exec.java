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
import yuyu.def.classification.C_BosyuusysctrlKbn;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
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
 * 申込基本TBLチェッククラスのメソッド {@link CheckTblMosKihon#exec(MosnaiCheckParam)} の一部テスト(ターゲット特約チェック,目標値チェック)用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTblMosKihonTest_exec extends AbstractTest{

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager manager;

    private final static String fileName = "UT-SP_単体テスト仕様書（機能）_申込基本TBLチェック";

    private final static String sheetName = "INデータ";

    private static String smbcnikkousyouken = YuyuSinkeiyakuConfig.getInstance().getSmbcnikkousyouken();

    @BeforeClass
    public static void testInit(){
        GetAdrDataMock.caller = CheckTblMosKihonTest_exec.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTblMosKihonTest_exec.class, fileName, sheetName);
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
        YuyuSinkeiyakuConfig.getInstance().setSmbcnikkousyouken(smbcnikkousyouken);
    }

    @Test
    @Transactional
    @TestOrder(1001)
    public void testExec_1_1() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230007");
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
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1002)
    public void testExec_1_2() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230015");
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
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定にはターゲット特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1003)
    public void testExec_1_3() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230023");
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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(1004)
    public void testExec_1_4() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230031");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1061", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％には目標到達時円建年金保険変更特約の付加が必要です。目標額割合を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1005)
    public void testExec_1_5() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230049");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1061", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％には目標到達時円建年金保険変更特約の付加が必要です。目標額割合を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1006)
    public void testExec_1_6() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230056");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1061", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％には目標到達時円建年金保険変更特約の付加が必要です。目標額割合を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(1007)
    public void testExec_1_7() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230064");
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
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には目標到達時円建終身保険変更特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(1008)
    public void testExec_1_8() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230072");
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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(1009)
    public void testExec_1_9() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230080");
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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(1010)
    public void testExec_1_10() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230098");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1061", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には目標到達時円建終身保険変更特約の付加が必要です。目標額割合を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(1013)
    public void testExec_1_13() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230122");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標値　入力対象外の保険種類です", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @Transactional
    @TestOrder(1014)
    public void testExec_1_14() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230130");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,"設計書申込書作成エラー出力区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @Transactional
    @TestOrder(1015)
    public void testExec_1_15() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230148");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE ,"設計書申込書作成エラー出力区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");

    }

    @Test
    @Transactional
    @TestOrder(1016)
    public void testExec_1_16() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230155");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);

        checkTblMosKihon.exec(mosnaiCheckParam);


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標値　入力対象外の保険種類です", "設計書申込書作成エラーメッセージ２");

    }

    @Test
    @Transactional
    @TestOrder(1017)
    public void testExec_1_17() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230163");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.TIGIN);

        checkTblMosKihon.exec(mosnaiCheckParam);


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN ,"設計書申込書作成エラー出力区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標値　入力対象外の保険種類です", "設計書申込書作成エラーメッセージ２");    }

    @Test
    @Transactional
    @TestOrder(1018)
    public void testExec_1_18() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230171");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);

        checkTblMosKihon.exec(mosnaiCheckParam);


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE ,"設計書申込書作成エラー出力区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @Transactional
    @TestOrder(1019)
    public void testExec_1_19() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230189");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.TIGIN);

        checkTblMosKihon.exec(mosnaiCheckParam);


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には指定代理請", "設計書申込書作成エラーメッセージ１");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "求特約を付加できません。", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @Transactional
    @TestOrder(1020)
    public void testExec_1_20() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230197");
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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(1021)
    public void testExec_1_21() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230205");
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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(1022)
    public void testExec_1_22() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230213");
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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(1023)
    public void testExec_1_23() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230221");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1061", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には目標到達時円建年金保険変更特約の付加が必要です。目標額割合を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(1024)
    public void testExec_1_24() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230239");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);

        checkTblMosKihon.exec(mosnaiCheckParam);


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％の目標額割合が", "設計書申込書作成エラーメッセージ１");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "取扱範囲外です。", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @Transactional
    @TestOrder(1025)
    public void testExec_1_25() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230247");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);

        checkTblMosKihon.exec(mosnaiCheckParam);


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標値　入力対象の保険種類です", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @Transactional
    @TestOrder(2001)
    public void testExec_2_1() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972240006");
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
        exNumericEquals(hubiMsgLst.size(), 2, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１７％には目標到達時円建終身保険変更特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "目標額割合の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(2002)
    public void testExec_2_2() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972240014");
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
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１７％には目標到達時円建終身保険変更特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(2003)
    public void testExec_2_3() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972240022");
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
        exNumericEquals(hubiMsgLst.size(), 2, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には目標到達時円建終身保険変更特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％の目標額割合が取扱範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(2004)
    public void testExec_2_4() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972240030");
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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(2005)
    public void testExec_2_5() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972240048");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0012", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "目標額割合の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(2006)
    public void testExec_2_6() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972240055");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標値　入力対象外の保険種類です", "設計書申込書作成エラーメッセージ２");

    }

    @Test
    @Transactional
    @TestOrder(2007)
    public void testExec_2_7() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972240063");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN ,"設計書申込書作成エラー出力区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標値　入力対象外の保険種類です", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @Transactional
    @TestOrder(2008)
    public void testExec_2_8() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972240071");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標値　入力対象外の保険種類です", "設計書申込書作成エラーメッセージ２");

    }

    @Test
    @Transactional
    @TestOrder(2009)
    public void testExec_2_9() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972240089");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(2010)
    public void testExec_2_10() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972240097");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標額割合の入力は不要です。", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @Transactional
    @TestOrder(2011)
    public void testExec_2_11() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972240105");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0012", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "目標額割合の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(2012)
    public void testExec_2_12() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972240113");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);

        checkTblMosKihon.exec(mosnaiCheckParam);


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標額割合の入力は不要です。", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @Transactional
    @TestOrder(3001)
    public void testExec_3_1() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972250005");
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
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には指定代理請求特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(4001)
    public void testExec_4_1() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972260004");
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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "重度介護前払特約付加区分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(4002)
    public void testExec_4_2() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972260012");
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
        YuyuSinkeiyakuConfig.getInstance().setSmbcnikkousyouken("10005");

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1036", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１５％は重度介護前払特約付加対象外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(5001)
    public void testExec_5_1() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972270003");
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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(5002)
    public void testExec_5_2() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972270011");
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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(6001)
    public void testExec_6_1() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972280002");
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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }


    @Test
    @Transactional
    @TestOrder(6002)
    public void testExec_6_2() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972280010");
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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(7001)
    public void testExec_7_1() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "WHC1013", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "手数料不支払契約です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(7002)
    public void testExec_7_2() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(7003)
    public void testExec_7_3() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("970000303");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(7004)
    public void testExec_7_4() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);


        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);

        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("970000311");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(8001)
    public void testExec_8_1() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000116");
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
        exNumericEquals(hubiMsgLst.size(), 14, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0021", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "告知扱に報状入力があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "TBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】末子生年月日の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EBA0030", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "指定された被保険者職業コードは存在しません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "被保険者年収の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(4).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(4).getHubimsg(), "契約者名（カナ）が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(4).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(5).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(5).getHubimsg(), "契約者生年月日の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(5).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(6).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(6).getHubimsg(), "契約者性別の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(6).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(7).getMessageId(), "EHC0087", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(7).getHubimsg(), "事業一括の払込経路が団体になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(7).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(8).getMessageId(), "EHC0088", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(8).getHubimsg(), "団体コードが代表申込番号の団体コードと相違しています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(8).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(9).getMessageId(), "EHC0092", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(9).getHubimsg(), "事業一括の契約者性別が法人契約になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(9).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(10).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(10).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１７％には円貨支払特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(10).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(11).getMessageId(), "EHC1036", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(11).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１７％は重度介護前払特約付加対象外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(11).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(12).getMessageId(), "EHC1037", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(12).getHubimsg(), "他契約にて重度介護前払特約が付加されているため、付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(12).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(13).getMessageId(), "EBA0027", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(13).getHubimsg(), "配当金受取方法を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(13).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(8002)
    public void testExec_8_2() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000124");
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
        exNumericEquals(hubiMsgLst.size(), 7, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0020", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "無告知に告知書入力があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0021", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "無告知に報状入力があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "KBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "（特認済）末子生年月日の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "被保険者職業コードの入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(4).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(4).getHubimsg(), "契約者名（カナ）が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(4).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(5).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(5).getHubimsg(), "契約者生年月日の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(5).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(6).getMessageId(), "EHC0092", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(6).getHubimsg(), "事業一括の契約者性別が法人契約になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(6).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(8003)
    public void testExec_8_3() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
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
        exNumericEquals(hubiMsgLst.size(), 7, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0020", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "職業のみ告知に告知書入力があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EBA0027", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "告知日を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "TBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "【特認可能】末子生年月日の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "被保険者職業コードの入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(4).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(4).getHubimsg(), "契約者名（カナ）が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(4).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(5).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(5).getHubimsg(), "契約者生年月日の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(5).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(6).getMessageId(), "EHC0092", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(6).getHubimsg(), "事業一括の契約者性別が法人契約になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(6).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(8004)
    public void testExec_8_4() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
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
        exNumericEquals(hubiMsgLst.size(), 4, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0021", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "無告知に報状入力があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EBC0007", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "末子生年月日は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "末子生年月日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "被保険者職業コードの入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(8005)
    public void testExec_8_5() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "末子生年月日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(8006)
    public void testExec_8_6() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112519");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1() + mosnaiCheckParam.getSekmossakuseiErrmsg2(), "他契約にて重度介護前払特約が付加されているため付加できません", "設計書申込書作成エラーメッセージ");

    }

    @Test
    @Transactional
    @TestOrder(9001)
    public void testExec_9_1() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000231");
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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(9002)
    public void testExec_9_2() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000249");
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
        exNumericEquals(hubiMsgLst.size(), 2, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "指数連動部分割合の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "定率積立部分割合の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(9003)
    public void testExec_9_3() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000256");
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1065", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "定率積立・指数連動配分割合の合計が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(9004)
    public void testExec_9_4() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000264");
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "指数連動部分割合の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(9005)
    public void testExec_9_5() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000272");
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
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "定率積立部分割合の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(9006)
    public void testExec_9_6() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000280");
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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(10001)
    public void testExec_10_1() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860050004");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160310"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "TBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】申込日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(10002)
    public void testExec_10_2() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860050012");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160310"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "TBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】申込日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(10003)
    public void testExec_10_3() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860050020");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160310"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "KBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "（特認済）申込日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(10004)
    public void testExec_10_4() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860050038");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160310"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(10005)
    public void testExec_10_5() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860050046");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160310"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }


    @Test
    @Transactional
    @TestOrder(10006)
    public void testExec_10_6() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860050053");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160310"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "TBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】申込日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(10007)
    public void testExec_10_7() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860050061");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160310"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "TBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】申込日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(10008)
    public void testExec_10_8() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860050079");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160310"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "KBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "（特認済）申込日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(10009)
    public void testExec_10_9() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860050087");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160310"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(10010)
    public void testExec_10_10() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860050095");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160310"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(10010)
    public void testExec_10_11() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860050103");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160310"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(10010)
    public void testExec_10_12() {
        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860050111");
        MosnaiCheckParam mosnaiCheckParam =  new MosnaiCheckParam();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160310"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosKihon.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }


    @Test
    @Transactional
    @TestOrder(11010)
    public void testExec_11_1() {
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
    @TestOrder(11020)
    public void testExec_11_2() {
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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(11030)
    public void testExec_11_3() {
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
    @TestOrder(11040)
    public void testExec_11_4() {
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
    @TestOrder(11050)
    public void testExec_11_5() {
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
    @TestOrder(11060)
    public void testExec_11_6() {
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

}
