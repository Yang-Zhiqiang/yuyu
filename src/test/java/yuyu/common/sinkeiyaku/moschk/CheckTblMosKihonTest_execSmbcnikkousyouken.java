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
 * 申込基本TBLチェッククラスのメソッド {@link CheckTblMosKihon#exec(MosnaiCheckParam)} の一部テスト(申込代理店情報の取得,ターゲット特約チェック)用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTblMosKihonTest_execSmbcnikkousyouken extends AbstractTest{

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager manager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_申込基本TBLチェック_SMBC日興証券、SMBC信託対応";

    private final static String sheetName = "INデータ";

    private static Integer mosKakoKyoyou;

    private static Integer mosKairiNissuu;

    @BeforeClass
    public static void testInit(){
        GetAdrDataMock.caller = CheckTblMosKihonTest_exec.class;

        mosKakoKyoyou = YuyuSinkeiyakuConfig.getInstance().getMosKakoKyoyou();
        mosKairiNissuu = YuyuSinkeiyakuConfig.getInstance().getMosKairiNissuu();
    }
    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        GetAdrDataMock.caller = null;
        GetAdrDataMock.SYORIPTN = null;

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(mosKakoKyoyou);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(mosKairiNissuu);
    }
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTblMosKihonTest_execSmbcnikkousyouken.class, fileName, sheetName);
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
    @TestOrder(1001)
    public void testExec_1_1() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500006");
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
    @TestOrder(1002)
    public void testExec_1_2() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500014");
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
    @TestOrder(1003)
    public void testExec_1_3() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500022");
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500030");
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
    @TestOrder(1005)
    public void testExec_1_5() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500048");
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
    @TestOrder(1006)
    public void testExec_1_6() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500055");
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
    @TestOrder(1007)
    public void testExec_1_7() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500121");
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
    @TestOrder(1008)
    public void testExec_1_8() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500139");
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500147");
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
    @TestOrder(1010)
    public void testExec_1_10() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500063");
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
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("111");

        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標値　入力対象外の保険種類です", "設計書申込書作成エラーメッセージ２");

    }

    @Test
    @Transactional
    @TestOrder(1011)
    public void testExec_1_11() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500071");
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
        mosnaiCheckParam.setSekmossakuseiOyaAgCd(YuyuSinkeiyakuConfig.getInstance().getSmbcnikkousyouken());


        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標値　入力対象外の保険種類です", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @Transactional
    @TestOrder(1012)
    public void testExec_1_12() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500089");
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
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("111");

        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN ,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標値　入力対象外の保険種類です", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @Transactional
    @TestOrder(1013)
    public void testExec_1_13() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500097");
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
        mosnaiCheckParam.setSekmossakuseiOyaAgCd(YuyuSinkeiyakuConfig.getInstance().getSmbcsintakubank());


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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500105");
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
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("111");


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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500113");
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
        mosnaiCheckParam.setSekmossakuseiOyaAgCd(YuyuSinkeiyakuConfig.getInstance().getSmbcnikkousyouken());

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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500162");
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
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("111");


        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
    }
    @Test
    @Transactional
    @TestOrder(1017)
    public void testExec_1_17() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500154");
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
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("111");


        checkTblMosKihon.exec(mosnaiCheckParam);
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標額割合の入力が必要です。", "設計書申込書作成エラーメッセージ２");

    }

    @Test
    @Transactional
    @TestOrder(1018)
    public void testExec_1_18() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("862500170");
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
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("111");


        checkTblMosKihon.exec(mosnaiCheckParam);
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "目標値　入力対象の保険種類です", "設計書申込書作成エラーメッセージ２");

    }

    @Test
    @Transactional
    @TestOrder(1019)
    public void testExec_1_19() {

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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(1020)
    public void testExec_1_20() {

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
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.TIGIN);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd(YuyuSinkeiyakuConfig.getInstance().getSmbcsintakubank());

        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE ,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @Transactional
    @TestOrder(1021)
    public void testExec_1_21() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791113814");
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
    @TestOrder(2001)
    public void testExec_2_1() {

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


        checkTblMosKihon.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には保険料円貨払込特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(2002)
    public void testExec_2_2() {

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
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には保険料円貨払込特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }


    @Test
    @Transactional
    @TestOrder(2003)
    public void testExec_2_3() {

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
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には保険料円貨払込特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(2004)
    public void testExec_2_4() {

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
    @TestOrder(2005)
    public void testExec_2_5() {

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
    @TestOrder(2006)
    public void testExec_2_6() {

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
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("111");

        checkTblMosKihon.exec(mosnaiCheckParam);


        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1() + mosnaiCheckParam.getSekmossakuseiErrmsg2(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には保険料円貨払込特約を付加できません。", "設計書申込書作成エラーメッセージ");

    }

    @Test
    @Transactional
    @TestOrder(2007)
    public void testExec_2_7() {

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
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("");

        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1() + mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ");
    }


    @Test
    @Transactional
    @TestOrder(2008)
    public void testExec_2_8() {

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
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("111");


        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1() + mosnaiCheckParam.getSekmossakuseiErrmsg2(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には保険料円貨払込特約を付加できません。", "設計書申込書作成エラーメッセージ");
    }

    @Test
    @Transactional
    @TestOrder(2009)
    public void testExec_2_9() {

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
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("111");

        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE ,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1() + mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ");
    }

    @Test
    @Transactional
    @TestOrder(2010)
    public void testExec_2_10() {

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
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("111");

        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE ,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1() + mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ");
    }


    @Test
    @Transactional
    @TestOrder(3001)
    public void testExec_3_1() {

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
        exNumericEquals(hubiMsgLst.size(), 1, "件数");

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には保険料指定外通貨払込特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(3002)
    public void testExec_3_2() {

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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には保険料指定外通貨払込特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }


    @Test
    @Transactional
    @TestOrder(3003)
    public void testExec_3_3() {

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

        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0197", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には保険料指定外通貨払込特約を付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(3004)
    public void testExec_3_4() {

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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(3005)
    public void testExec_3_5() {

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
        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(3006)
    public void testExec_3_6() {

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
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("111");


        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1() + mosnaiCheckParam.getSekmossakuseiErrmsg2(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には保険料指定外通貨払込特約を付加できません。", "設計書申込書作成エラーメッセージ");

    }

    @Test
    @Transactional
    @TestOrder(3007)
    public void testExec_3_7() {

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
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("");

        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1() + mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ");
    }


    @Test
    @Transactional
    @TestOrder(3008)
    public void testExec_3_8() {

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
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160317"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160317161400000");
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("111");


        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1() + mosnaiCheckParam.getSekmossakuseiErrmsg2(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１８％には保険料指定外通貨払込特約を付加できません。", "設計書申込書作成エラーメッセージ");
    }

    @Test
    @Transactional
    @TestOrder(3009)
    public void testExec_3_9() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230106");
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
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("111");

        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE ,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1() + mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ");
    }

    @Test
    @Transactional
    @TestOrder(3010)
    public void testExec_3_10() {

        CheckTblMosKihon checkTblMosKihon = SWAKInjector.getInstance(CheckTblMosKihon.class);

        YuyuSinkeiyakuConfig.getInstance().setMosKakoKyoyou(10);
        YuyuSinkeiyakuConfig.getInstance().setMosKairiNissuu(20);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("972230114");
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
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("111");

        checkTblMosKihon.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE ,"設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1() + mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ");
    }




}