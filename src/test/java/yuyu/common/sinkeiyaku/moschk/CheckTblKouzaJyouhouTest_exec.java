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
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.khcommon.CheckKzhuriKouza;
import yuyu.common.hozen.khcommon.CheckKzhuriKouzaMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.CheckShiharaikinSiteiKouza;
import yuyu.common.sinkeiyaku.skcommon.CheckShiharaikinSiteiKouzaMockForSinkeiyaku;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 口座情報TBLチェックのメソッド {@link CheckTblKouzaJyouhou#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTblKouzaJyouhouTest_exec {

    private final static String mosNo1 = "981112220";

    private final static String mosNo2 = "981112238";

    private final static String mosNo3 = "981112246";

    private final static String mosNo4 = "981112253";

    private final static String mosNo5 = "981112261";

    private final static String mosNo6 = "981112279";

    private final static String mosNo7 = "981112287";

    private final static String mosNo8 = "980000095";

    private final static String mosNo9 = "980000103";

    private final static String mosNo10 = "980000111";

    private final static String mosNo11 = "980000129";

    private final static String mosNo12 = "860000033";

    private final static String mosNo13 = "860000041";

    private final static String mosNo14 = "860000058";

    private final static String mosNo15 = "860000066";

    private final static String mosNo16 = "860000074";

    private final static String mosNo17 = "860000082";

    private final static String mosNo18 = "860000090";

    private final static String mosNo19 = "860000108";

    private final static String mosNo20 = "860000116";

    private final static String mosNo21 = "860000124";

    private final static String mosNo22 = "860000132";

    private final static String mosNo23 = "860000140";

    private final static String mosNo24 = "860000157";

    private final static String mosNo25 = "860000165";

    private final static String mosNo26 = "860000173";

    private final static String mosNo27 = "860000181";

    private final static String mosNo28 = "860000199";

    private final static String mosNo29 = "860000207";

    private final static String mosNo30 = "860000215";

    private final static String mosNo31 = "860000223";

    private final static String mosNo32 = "860000231";

    private final static String mosNo33 = "860000249";

    private final static String mosNo34 = "860000256";

    private final static String mosNo35 = "860000264";

    private final static String mosNo36 = "860000272";

    private final static String mosNo37 = "860000280";

    private final static String mosNo38 = "860000298";

    private final static String mosNo39 = "860000306";

    private final static String mosNo40 = "860000314";

    private final static String mosNo41 = "860000322";

    private final static String mosNo42 = "860000330";

    private final static String mosNo43 = "860000348";

    private final static String mosNo44 = "860000355";

    private final static String mosNo45 = "860000363";

    private final static String mosNo46 = "860000371";

    private final static String mosNo47 = "860000389";

    private final static String mosNo48 = "860000611";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_口座情報TBLチェック";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetHubiMsg.class).to(SetHubiMsgMockForSinkeiyaku.class);
                bind(CheckKzhuriKouza.class).to(CheckKzhuriKouzaMockForSinkeiyaku.class);
                bind(CheckShiharaikinSiteiKouza.class).to(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){

        SetHubiMsgMockForSinkeiyaku.caller = CheckTblKouzaJyouhouTest_exec.class;
        CheckKzhuriKouzaMockForSinkeiyaku.caller = CheckTblKouzaJyouhouTest_exec.class;
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.caller = CheckTblKouzaJyouhouTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        SetHubiMsgMockForSinkeiyaku.caller = null;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;

        CheckKzhuriKouzaMockForSinkeiyaku.caller = null;
        CheckKzhuriKouzaMockForSinkeiyaku.SYORIPTN = null;

        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.caller = null;
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = null;

        MockObjectManager.initialize();

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTblKouzaJyouhouTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllGinkou());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);

        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        MockObjectManager.assertNotCalled(SetHubiMsg.class, "exec");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");

        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1101 口振口座情報は不要です。", "メッセージ文言");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);

        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "981112238", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");

        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1102 口振口座情報の入力が必要です。", "メッセージ文言");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);

        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "981112246", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        MockObjectManager.assertNotCalled(SetHubiMsg.class, "exec");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        CheckKzhuriKouzaMockForSinkeiyaku.SYORIPTN = CheckKzhuriKouzaMockForSinkeiyaku.TESTPATTERN1;
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180101"));

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        String bankcd = (String) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bankcd, "9900", "銀行コード");
        String sitencd = (String) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(sitencd, "012", "支店コード");
        C_YokinKbn bfryokin = (C_YokinKbn) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 2);
        exClassificationEquals(bfryokin, C_YokinKbn.HUTUU, "預金種目区分");
        C_KzkykdouKbn kzkykdoukbn = (C_KzkykdouKbn) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 3);
        exClassificationEquals(kzkykdoukbn, C_KzkykdouKbn.DOUITU, "口座名義契約者同一人区分");
        String kyknmkn = (String) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 4);
        exStringEquals(kyknmkn, "ラリ", "契約者名（カナ）");
        String kzmeiginmkn = (String) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 5);
        exStringEquals(kzmeiginmkn, "カナ", "口座名義人氏名（カナ）");
        String kouzano = (String) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 6);
        exStringEquals(kouzano, "001", "口座番号");
        BizDate syoriymd = (BizDate) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 7);
        exDateEquals(syoriymd, BizDate.valueOf(20180101), "処理日");

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1092 口振口座情報エラー　ＣＳＳ確認依頼区分の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "981112261", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        CheckKzhuriKouzaMockForSinkeiyaku.SYORIPTN = CheckKzhuriKouzaMockForSinkeiyaku.TESTPATTERN2;
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180102"));

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        String bankcd = (String) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bankcd, "9900", "銀行コード");
        String sitencd = (String) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(sitencd, "013", "支店コード");
        C_YokinKbn bfryokin = (C_YokinKbn) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 2);
        exClassificationEquals(bfryokin, C_YokinKbn.HUTUUYUTYO, "預金種目区分");
        C_KzkykdouKbn kzkykdoukbn = (C_KzkykdouKbn) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 3);
        exClassificationEquals(kzkykdoukbn, C_KzkykdouKbn.SITEI, "口座名義契約者同一人区分");
        String kyknmkn = (String) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 4);
        exStringEquals(kyknmkn, "", "契約者名（カナ）");
        String kzmeiginmkn = (String) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 5);
        exStringEquals(kzmeiginmkn, "契約者名（カナ）", "口座名義人氏名（カナ）");
        String kouzano = (String) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 6);
        exStringEquals(kouzano, "002", "口座番号");
        BizDate syoriymd = (BizDate) MockObjectManager.getArgument(CheckKzhuriKouzaMockForSinkeiyaku.class, "exec", 0, 7);
        exDateEquals(syoriymd, BizDate.valueOf(20180102), "処理日");

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, "EHC1107 口振口座情報エラー　ＣＳＳ確認依頼不可　ゆうちょ銀行はＣＳＳ確認対象外です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "981112279", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        CheckKzhuriKouzaMockForSinkeiyaku.SYORIPTN = CheckKzhuriKouzaMockForSinkeiyaku.TESTPATTERN3;
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, "EHC1092 口振口座情報エラー　銀行コードの入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "981112287", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn2 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0);
        exClassificationEquals(ketsrhkosKbn2, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret2 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1);
        exStringEquals(ret2, "EHC1092 口振口座情報エラー　支店コードの入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 1, 2);
        exStringEquals(mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), "981112287", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn3 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 0);
        exClassificationEquals(ketsrhkosKbn3, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret3 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 1);
        exStringEquals(ret3, "EHC1092 口振口座情報エラー　預金種目の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp3 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 2, 2);
        exStringEquals(mosnaiCheckParamtemp3.getDataSyoriControl().getMosno(), "981112287", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn4 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 0);
        exClassificationEquals(ketsrhkosKbn4, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret4 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 1);
        exStringEquals(ret4, "EHC1092 口振口座情報エラー　口座番号の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp4 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 3, 2);
        exStringEquals(mosnaiCheckParamtemp4.getDataSyoriControl().getMosno(), "981112287", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn5 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 4, 0);
        exClassificationEquals(ketsrhkosKbn5, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret5 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 4, 1);
        exStringEquals(ret5, "EHC1092 口振口座情報エラー　口座名義人同一区分の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp5 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 4, 2);
        exStringEquals(mosnaiCheckParamtemp5.getDataSyoriControl().getMosno(), "981112287", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn6 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 5, 0);
        exClassificationEquals(ketsrhkosKbn6, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret6 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 5, 1);
        exStringEquals(ret6, "EHC1092 口振口座情報エラー　口座名義人の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp6 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 5, 2);
        exStringEquals(mosnaiCheckParamtemp6.getDataSyoriControl().getMosno(), "981112287", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn7 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 6, 0);
        exClassificationEquals(ketsrhkosKbn7, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret7 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 6, 1);
        exStringEquals(ret7, "EHC1093 口振口座情報エラー　口座名義人は不要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp7 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 6, 2);
        exStringEquals(mosnaiCheckParamtemp7.getDataSyoriControl().getMosno(), "981112287", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn8 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 7, 0);
        exClassificationEquals(ketsrhkosKbn8, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret8 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 7, 1);
        exStringEquals(ret8, "EHC1094 口振口座情報エラー　入力された銀行コードまたは支店コードは存在しません。銀行コード 9901、支店コード 014", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp8 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 7, 2);
        exStringEquals(mosnaiCheckParamtemp8.getDataSyoriControl().getMosno(), "981112287", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn9 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 8, 0);
        exClassificationEquals(ketsrhkosKbn9, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret9 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 8, 1);
        exStringEquals(ret9, "EHC1077 口振口座情報エラー　入力された銀行または支店コードが有効ではありません。銀行コード 9901、支店コード 014", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp9 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 8, 2);
        exStringEquals(mosnaiCheckParamtemp9.getDataSyoriControl().getMosno(), "981112287", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn10 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 9, 0);
        exClassificationEquals(ketsrhkosKbn10, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret10 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 9, 1);
        exStringEquals(ret10, "EHC1078 口振口座情報エラー　預振協定なし。銀行コード 9901、支店コード 014", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp10 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 9, 2);
        exStringEquals(mosnaiCheckParamtemp10.getDataSyoriControl().getMosno(), "981112287", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn11 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 10, 0);
        exClassificationEquals(ketsrhkosKbn11, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret11 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 10, 1);
        exStringEquals(ret11, "EHC1096 口振口座情報エラー　口座番号が正しくありません。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp11 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 10, 2);
        exStringEquals(mosnaiCheckParamtemp11.getDataSyoriControl().getMosno(), "981112287", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn12 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 11, 0);
        exClassificationEquals(ketsrhkosKbn12, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret12 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 11, 1);
        exStringEquals(ret12, "EHC1097 口振口座情報エラー　口座番号の入力桁数が超過しています。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp12 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 11, 2);
        exStringEquals(mosnaiCheckParamtemp12.getDataSyoriControl().getMosno(), "981112287", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn13 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 12, 0);
        exClassificationEquals(ketsrhkosKbn13, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret13 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 12, 1);
        exStringEquals(ret13, "EHC1096 口振口座情報エラー　口座名義人が正しくありません。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp13 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 12, 2);
        exStringEquals(mosnaiCheckParamtemp13.getDataSyoriControl().getMosno(), "981112287", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn14 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 13, 0);
        exClassificationEquals(ketsrhkosKbn14, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret14 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 13, 1);
        exStringEquals(ret14, "EHC1097 口振口座情報エラー　口座名義人の入力桁数が超過しています。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp14 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 13, 2);
        exStringEquals(mosnaiCheckParamtemp14.getDataSyoriControl().getMosno(), "981112287", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn15 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 14, 0);
        exClassificationEquals(ketsrhkosKbn15, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn15 = (C_HubisyubetusyousaiKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 14, 1);
        exClassificationEquals(hubisyubetusyousaiKbn15, C_HubisyubetusyousaiKbn.KOUHURIKZMEIGIKYKBETUHUBI, "不備種別詳細区分");
        String ret15 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 14, 2);
        exStringEquals(ret15, "EHC1081 口振口座情報エラー　口座名義人が契約者と異なります。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp15 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 14, 3);
        exStringEquals(mosnaiCheckParamtemp15.getDataSyoriControl().getMosno(), "981112287", "申込番号");
        C_TknKbn tknKbn15 = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 14, 4);
        exClassificationEquals(tknKbn15, C_TknKbn.SUMI, "特認区分");
        C_MsgKbn msgKbn15 = (C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 14, 5);
        exClassificationEquals(msgKbn15, C_MsgKbn.ERROR, "メッセージ区分");

        C_KetsrhkosKbn ketsrhkosKbn16 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 15, 0);
        exClassificationEquals(ketsrhkosKbn16, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret16 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 15, 1);
        exStringEquals(ret16, "EHC1098 口振口座情報エラー　預金種目には、「普通」を指定してください。銀行コード 9901", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp16 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 15, 2);
        exStringEquals(mosnaiCheckParamtemp16.getDataSyoriControl().getMosno(), "981112287", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        CheckKzhuriKouzaMockForSinkeiyaku.SYORIPTN = CheckKzhuriKouzaMockForSinkeiyaku.TESTPATTERN4;
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        MockObjectManager.assertNotCalled(SetHubiMsg.class, "exec");

    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        CheckKzhuriKouzaMockForSinkeiyaku.SYORIPTN = CheckKzhuriKouzaMockForSinkeiyaku.TESTPATTERN5;
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, "EHC1079 口振口座情報エラー　口座名義人同一区分に「同一」は指定できません。契約者名（カナ）に口座名義人に使用できない文字が含まれています。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "980000103", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn2 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0);
        exClassificationEquals(ketsrhkosKbn2, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret2 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1);
        exStringEquals(ret2, "EHC1080 口振口座情報エラー　口座名義人同一区分に「同一」は指定できません。契約者名（カナ）が口座名義人の桁数を超過しています。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 1, 2);
        exStringEquals(mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), "980000103", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();

        CheckKzhuriKouzaMockForSinkeiyaku.SYORIPTN = CheckKzhuriKouzaMockForSinkeiyaku.TESTPATTERN6;
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo10);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        MockObjectManager.assertNotCalled(SetHubiMsg.class, "exec");

    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        CheckKzhuriKouzaMockForSinkeiyaku.SYORIPTN = CheckKzhuriKouzaMockForSinkeiyaku.TESTPATTERN7;
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo11);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, "EHC1079 口振口座情報エラー　口座名義人同一区分に「同一」は指定できません。被保険者名（カナ）に口座名義人に使用できない文字が含まれています。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "980000129", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn2 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0);
        exClassificationEquals(ketsrhkosKbn2, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret2 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1);
        exStringEquals(ret2, "EHC1080 口振口座情報エラー　口座名義人同一区分に「同一」は指定できません。被保険者名（カナ）が口座名義人の桁数を超過しています。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 1, 2);
        exStringEquals(mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), "980000129", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        CheckKzhuriKouzaMockForSinkeiyaku.SYORIPTN = CheckKzhuriKouzaMockForSinkeiyaku.TESTPATTERN7;
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo12);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, "EHC1134 口振口座情報エラー　ＣＳＳ確認依頼不可　口座振替登録方法が「ＱＲコード方式での登録」の場合はＣＳＳ確認対象外です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000033", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn2 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0);
        exClassificationEquals(ketsrhkosKbn2, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret2 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1);
        exStringEquals(ret2, "EBC0012 口座振替登録方法の入力は不要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 1, 2);
        exStringEquals(mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), "860000033", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn3 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0);
        exClassificationEquals(ketsrhkosKbn3, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret3 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 1);
        exStringEquals(ret3, "EHC1136 収納代行社の設定が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp3 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 2, 2);
        exStringEquals(mosnaiCheckParamtemp3.getDataSyoriControl().getMosno(), "860000033", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn4 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0);
        exClassificationEquals(ketsrhkosKbn4, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret4 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 1);
        exStringEquals(ret4, "EHC1137 収納代行社がは取扱えません。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp4 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 3, 2);
        exStringEquals(mosnaiCheckParamtemp4.getDataSyoriControl().getMosno(), "860000033", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {

        MockObjectManager.initialize();
        CheckKzhuriKouzaMockForSinkeiyaku.SYORIPTN = CheckKzhuriKouzaMockForSinkeiyaku.TESTPATTERN7;
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo13);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, null, "");

        MockObjectManager.assertNotCalled(SetHubiMsg.class, "exec");

    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {

        MockObjectManager.initialize();
        CheckKzhuriKouzaMockForSinkeiyaku.SYORIPTN = CheckKzhuriKouzaMockForSinkeiyaku.TESTPATTERN7;
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo14);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, "EHC1136 収納代行社の設定が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000058", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {

        MockObjectManager.initialize();
        CheckKzhuriKouzaMockForSinkeiyaku.SYORIPTN = CheckKzhuriKouzaMockForSinkeiyaku.TESTPATTERN7;
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo15);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, null, "");

        MockObjectManager.assertNotCalled(SetHubiMsg.class, "exec");

    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A16() {

        MockObjectManager.initialize();
        CheckKzhuriKouzaMockForSinkeiyaku.SYORIPTN = CheckKzhuriKouzaMockForSinkeiyaku.TESTPATTERN7;
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo16);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, "EHC1135 口座振替登録方法がＱＲコード方式での登録は取扱えません。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000074", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A17() {

        MockObjectManager.initialize();

        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo17);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20120305"));

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_Tkhukaumu teikisiharaitkykhkkbn = (C_Tkhukaumu) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(teikisiharaitkykhkkbn, C_Tkhukaumu.HUKA, "定期支払特約付加区分");
        C_KouzasyuruiKbn teikisiharaikinukthou = (C_KouzasyuruiKbn) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 1);
        exClassificationEquals(teikisiharaikinukthou, C_KouzasyuruiKbn.BLNK, "定期支払金支払通貨");
        String bankcd = (String) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals(bankcd, "", "銀行コード");
        String sitencd = (String) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 3);
        exStringEquals(sitencd, "", "支店コード");
        C_YokinKbn yokinkbn = (C_YokinKbn) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 4);
        exClassificationEquals(yokinkbn, C_YokinKbn.BLNK, "預金種目区分");
        String kouzano = (String) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 5);
        exStringEquals(kouzano, "", "口座番号");
        C_KzkykdouKbn kzkykdoukbn = (C_KzkykdouKbn) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 6);
        exClassificationEquals(kzkykdoukbn, C_KzkykdouKbn.BLNK, "口座名義契約者同一人区分");
        String kyknmkn = (String) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 7);
        exStringEquals(kyknmkn, "", "契約者名（カナ）");
        String kzmeiginmkn = (String) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 8);
        exStringEquals(kzmeiginmkn, "", "口座名義人氏名（カナ）");
        BizDate syoriymd = (BizDate) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 9);
        exDateEquals(syoriymd, BizDate.valueOf(20120305), "処理日");

    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A18() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo18);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20120316"));

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, null, "");

        MockObjectManager.assertNotCalled(SetHubiMsg.class, "exec");

        C_Tkhukaumu teikisiharaitkykhkkbn = (C_Tkhukaumu) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(teikisiharaitkykhkkbn, C_Tkhukaumu.NONE, "定期支払特約付加区分");
        C_KouzasyuruiKbn teikisiharaikinukthou = (C_KouzasyuruiKbn) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 1);
        exClassificationEquals(teikisiharaikinukthou, C_KouzasyuruiKbn.YENKOUZA, "定期支払金支払通貨");
        String bankcd = (String) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals(bankcd, "9902", "銀行コード");
        String sitencd = (String) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 3);
        exStringEquals(sitencd, "002", "支店コード");
        C_YokinKbn yokinkbn = (C_YokinKbn) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 4);
        exClassificationEquals(yokinkbn, C_YokinKbn.TYOTIKU, "預金種目区分");
        String kouzano = (String) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 5);
        exStringEquals(kouzano, "056", "口座番号");
        C_KzkykdouKbn kzkykdoukbn = (C_KzkykdouKbn) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 6);
        exClassificationEquals(kzkykdoukbn, C_KzkykdouKbn.SITEI, "口座名義契約者同一人区分");
        String kyknmkn = (String) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 7);
        exStringEquals(kyknmkn, "被保険者名", "契約者名（カナ）");
        String kzmeiginmkn = (String) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 8);
        exStringEquals(kzmeiginmkn, "口座名義人氏名", "口座名義人氏名（カナ）");
        BizDate syoriymd = (BizDate) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 9);
        exDateEquals(syoriymd, BizDate.valueOf(20120316), "処理日");

    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A19() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo19);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        String kyknmkn = (String) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 7);
        exStringEquals(kyknmkn, "契約者名", "契約者名（カナ）");

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, "EHC1156 支払金指定口座情報は不要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000108", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn2 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0);
        exClassificationEquals(ketsrhkosKbn2, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret2 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1);
        exStringEquals(ret2, "EHC1157 支払金指定口座情報の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 1, 2);
        exStringEquals(mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), "860000108", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn3 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 0);
        exClassificationEquals(ketsrhkosKbn3, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret3 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 1);
        exStringEquals(ret3, "EHC1143 支払金指定口座情報エラー　定期支払金支払通貨の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp3 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 2, 2);
        exStringEquals(mosnaiCheckParamtemp3.getDataSyoriControl().getMosno(), "860000108", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn4 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 0);
        exClassificationEquals(ketsrhkosKbn4, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret4 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 1);
        exStringEquals(ret4, "EHC1143 支払金指定口座情報エラー　銀行コードの入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp4 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 3, 2);
        exStringEquals(mosnaiCheckParamtemp4.getDataSyoriControl().getMosno(), "860000108", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn5 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 4, 0);
        exClassificationEquals(ketsrhkosKbn5, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret5 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 4, 1);
        exStringEquals(ret5, "EHC1143 支払金指定口座情報エラー　支店コードの入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp5 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 4, 2);
        exStringEquals(mosnaiCheckParamtemp5.getDataSyoriControl().getMosno(), "860000108", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn6 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 5, 0);
        exClassificationEquals(ketsrhkosKbn6, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret6 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 5, 1);
        exStringEquals(ret6, "EHC1143 支払金指定口座情報エラー　預金種目の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp6 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 5, 2);
        exStringEquals(mosnaiCheckParamtemp6.getDataSyoriControl().getMosno(), "860000108", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn7 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 6, 0);
        exClassificationEquals(ketsrhkosKbn7, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret7 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 6, 1);
        exStringEquals(ret7, "EHC1158 支払金指定口座情報エラー　預金種目の入力は不要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp7 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 6, 2);
        exStringEquals(mosnaiCheckParamtemp7.getDataSyoriControl().getMosno(), "860000108", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn8 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 7, 0);
        exClassificationEquals(ketsrhkosKbn8, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret8 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 7, 1);
        exStringEquals(ret8, "EHC1143 支払金指定口座情報エラー　口座番号の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp8 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 7, 2);
        exStringEquals(mosnaiCheckParamtemp8.getDataSyoriControl().getMosno(), "860000108", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn9 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 8, 0);
        exClassificationEquals(ketsrhkosKbn9, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret9 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 8, 1);
        exStringEquals(ret9, "EHC1143 支払金指定口座情報エラー　口座名義人同一区分の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp9 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 8, 2);
        exStringEquals(mosnaiCheckParamtemp9.getDataSyoriControl().getMosno(), "860000108", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn10 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 9, 0);
        exClassificationEquals(ketsrhkosKbn10, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret10 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 9, 1);
        exStringEquals(ret10, "EHC1159 支払金指定口座情報エラー　口座名義人同一区分に「同一」は指定できません。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp10 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 9, 2);
        exStringEquals(mosnaiCheckParamtemp10.getDataSyoriControl().getMosno(), "860000108", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn11 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 10, 0);
        exClassificationEquals(ketsrhkosKbn11, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret11 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 10, 1);
        exStringEquals(ret11, "EHC1158 支払金指定口座情報エラー　口座名義人の入力は不要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp11 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 10, 2);
        exStringEquals(mosnaiCheckParamtemp11.getDataSyoriControl().getMosno(), "860000108", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn12 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 11, 0);
        exClassificationEquals(ketsrhkosKbn12, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret12 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 11, 1);
        exStringEquals(ret12, "EHC1143 支払金指定口座情報エラー　口座名義人の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp12 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 11, 2);
        exStringEquals(mosnaiCheckParamtemp12.getDataSyoriControl().getMosno(), "860000108", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_A20() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo20);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        String kyknmkn = (String) MockObjectManager.getArgument(CheckShiharaikinSiteiKouzaMockForSinkeiyaku.class, "exec", 0, 7);
        exStringEquals(kyknmkn, "被保険者名", "契約者名（カナ）");

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, "EHC1162 支払金指定口座情報エラー　口座名義人同一区分に「同一」は指定できません。被保険者名（カナ）が口座名義人の桁数を超過しています。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000116", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn2 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0);
        exClassificationEquals(ketsrhkosKbn2, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn2 = (C_HubisyubetusyousaiKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1);
        exClassificationEquals(hubisyubetusyousaiKbn2, C_HubisyubetusyousaiKbn.KOUHURIKZMEIGIKYKBETUHUBI, "不備種別詳細区分");
        String ret2 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 2);
        exStringEquals(ret2, "EHC1163 支払金指定口座情報エラー　口座名義人が契約者と異なります。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 1, 3);
        exStringEquals(mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), "860000116", "申込番号");
        C_TknKbn tknKbn2 = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 4);
        exClassificationEquals(tknKbn2, C_TknKbn.SUMI, "特認区分");
        C_MsgKbn msgKbn2 = (C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 5);
        exClassificationEquals(msgKbn2, C_MsgKbn.ERROR, "メッセージ区分");

        C_KetsrhkosKbn ketsrhkosKbn3 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 0);
        exClassificationEquals(ketsrhkosKbn3, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret3 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 1);
        exStringEquals(ret3, "EHC1149 支払金指定口座情報エラー　預金種目には、「普通」を指定してください。銀行コード 9902", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp3 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 2, 2);
        exStringEquals(mosnaiCheckParamtemp3.getDataSyoriControl().getMosno(), "860000116", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_A21() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN5;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo21);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, "EHC1161 支払金指定口座情報エラー　口座名義人同一区分に「同一」は指定できません。契約者名（カナ）に口座名義人に使用できない文字が含まれています。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000124", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_A22() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo22);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, "EHC1160 支払金指定口座情報エラー　口座名義人の入力桁数が超過しています。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000132", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn2 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0);
        exClassificationEquals(ketsrhkosKbn2, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn2 = (C_HubisyubetusyousaiKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1);
        exClassificationEquals(hubisyubetusyousaiKbn2, C_HubisyubetusyousaiKbn.KOUHURIKZMEIGIKYKBETUHUBI, "不備種別詳細区分");
        String ret2 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 2);
        exStringEquals(ret2, "EHC1163 支払金指定口座情報エラー　口座名義人が契約者と異なります。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 1, 3);
        exStringEquals(mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), "860000132", "申込番号");
        C_TknKbn tknKbn2 = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 4);
        exClassificationEquals(tknKbn2, C_TknKbn.KANOU, "特認区分");
        C_MsgKbn msgKbn2 = (C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 5);
        exClassificationEquals(msgKbn2, C_MsgKbn.ERROR, "メッセージ区分");

        C_KetsrhkosKbn ketsrhkosKbn3 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 0);
        exClassificationEquals(ketsrhkosKbn3, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret3 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 1);
        exStringEquals(ret3, "EHC1149 支払金指定口座情報エラー　預金種目には、「普通」を指定してください。銀行コード 9902", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp3 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 2, 2);
        exStringEquals(mosnaiCheckParamtemp3.getDataSyoriControl().getMosno(), "860000132", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_A23() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN5;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo23);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, "EHC1161 支払金指定口座情報エラー　口座名義人同一区分に「同一」は指定できません。に口座名義人に使用できない文字が含まれています。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000140", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_A24() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo24);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, " {}", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000157", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn2 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0);
        exClassificationEquals(ketsrhkosKbn2, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn2 = (C_HubisyubetusyousaiKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1);
        exClassificationEquals(hubisyubetusyousaiKbn2, C_HubisyubetusyousaiKbn.KOUHURIKZMEIGIKYKBETUHUBI, "不備種別詳細区分");
        String ret2 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 2);
        exStringEquals(ret2, "EHC1163 支払金指定口座情報エラー　口座名義人が契約者と異なります。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 1, 3);
        exStringEquals(mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), "860000157", "申込番号");
        C_TknKbn tknKbn2 = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 4);
        exClassificationEquals(tknKbn2, C_TknKbn.KANOU, "特認区分");
        C_MsgKbn msgKbn2 = (C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 5);
        exClassificationEquals(msgKbn2, C_MsgKbn.ERROR, "メッセージ区分");

        C_KetsrhkosKbn ketsrhkosKbn3 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 0);
        exClassificationEquals(ketsrhkosKbn3, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret3 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 1);
        exStringEquals(ret3, "EHC1149 支払金指定口座情報エラー　預金種目には、「普通」を指定してください。銀行コード 9902", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp3 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 2, 2);
        exStringEquals(mosnaiCheckParamtemp3.getDataSyoriControl().getMosno(), "860000157", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testExec_A25() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN5;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo25);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, "EHC1150 支払金指定口座情報エラー　口座名義人が正しくありません。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000165", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testExec_A26() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN6;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo26);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1156 支払金指定口座情報は不要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000173", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testExec_A27() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN7;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo27);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1157 支払金指定口座情報の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000181", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(280)
    public void testExec_A28() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN8;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo28);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1143 支払金指定口座情報エラー　定期支払金支払通貨の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000199", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(290)
    public void testExec_A29() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN9;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo29);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1143 支払金指定口座情報エラー　銀行コードの入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000207", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(300)
    public void testExec_A30() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN10;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo30);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1143 支払金指定口座情報エラー　支店コードの入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000215", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(310)
    public void testExec_A31() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN11;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo31);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1143 支払金指定口座情報エラー　預金種目の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000223", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(320)
    public void testExec_A32() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN12;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo32);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1158 支払金指定口座情報エラー　預金種目の入力は不要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000231", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(330)
    public void testExec_A33() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN13;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo33);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1143 支払金指定口座情報エラー　口座番号の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000249", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(340)
    public void testExec_A34() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN14;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo34);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1143 支払金指定口座情報エラー　口座名義人同一区分の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000256", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(350)
    public void testExec_A35() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN15;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo35);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1159 支払金指定口座情報エラー　口座名義人同一区分に「同一」は指定できません。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000264", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(360)
    public void testExec_A36() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN16;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo36);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1158 支払金指定口座情報エラー　口座名義人の入力は不要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000272", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(370)
    public void testExec_A37() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN17;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo37);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1143 支払金指定口座情報エラー　口座名義人の入力が必要です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000280", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(380)
    public void testExec_A38() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN18;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo38);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1144 支払金指定口座情報エラー　入力された銀行コードまたは支店コードは存在しません。銀行コード 9902、支店コード 002", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000298", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(390)
    public void testExec_A39() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN19;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo39);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1145 支払金指定口座情報エラー　入力された銀行または支店コードが有効ではありません。銀行コード 9902、支店コード 002", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000306", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(400)
    public void testExec_A40() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN20;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo40);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1147 支払金指定口座情報エラー　送金の取扱いがない支店です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000314", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(410)
    public void testExec_A41() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN21;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo41);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1148 支払金指定口座情報エラー　外貨送金の取扱いがない銀行または支店です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000322", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(420)
    public void testExec_A42() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN22;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo42);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1150 支払金指定口座情報エラー　口座番号が正しくありません。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000330", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(430)
    public void testExec_A43() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN23;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo43);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1160 支払金指定口座情報エラー　口座番号の入力桁数が超過しています。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000348", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(440)
    public void testExec_A44() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN24;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo44);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1161 支払金指定口座情報エラー　口座名義人同一区分に「同一」は指定できません。被保険者名（カナ）に口座名義人に使用できない文字が含まれています。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000355", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(450)
    public void testExec_A45() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN25;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo45);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1162 支払金指定口座情報エラー　口座名義人同一区分に「同一」は指定できません。契約者名（カナ）が口座名義人の桁数を超過しています。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000363", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(460)
    public void testExec_A46() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN26;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo46);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = (C_HubisyubetusyousaiKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exClassificationEquals(hubisyubetusyousaiKbn, C_HubisyubetusyousaiKbn.KOUHURIKZMEIGIKYKBETUHUBI, "不備種別詳細区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals(ret, "EHC1163 支払金指定口座情報エラー　口座名義人が契約者と異なります。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 3);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000371", "申込番号");
        C_TknKbn tknKbn = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4);
        exClassificationEquals(tknKbn, C_TknKbn.SUMI, "特認区分");
        C_MsgKbn msgKbn = (C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5);
        exClassificationEquals(msgKbn, C_MsgKbn.ERROR, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(470)
    public void testExec_A47() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN27;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo47);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret, "EHC1149 支払金指定口座情報エラー　預金種目には、「普通」を指定してください。銀行コード 9902", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "860000389", "申込番号");

    }

    @Test
    @Transactional
    @TestOrder(480)
    public void testExec_A48() {

        MockObjectManager.initialize();
        CheckShiharaikinSiteiKouzaMockForSinkeiyaku.SYORIPTN = CheckShiharaikinSiteiKouzaMockForSinkeiyaku.TESTPATTERN28;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo48);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        CheckTblKouzaJyouhou checkTblKouzaJyouhou = SWAKInjector.getInstance(CheckTblKouzaJyouhou.class);
        checkTblKouzaJyouhou.exec(mosnaiCheckParam);

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(ret1, "EHC1144 支払金指定口座情報エラー　入力された銀行コードまたは支店コードは存在しません。銀行コード 9902、支店コード 002", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 0, 2);
        exStringEquals(mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000611", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn2 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0);
        exClassificationEquals(ketsrhkosKbn2, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret2 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1);
        exStringEquals(ret2, "EHC1145 支払金指定口座情報エラー　入力された銀行または支店コードが有効ではありません。銀行コード 9902、支店コード 002", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 1, 2);
        exStringEquals(mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), "860000611", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn3 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 0);
        exClassificationEquals(ketsrhkosKbn3, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret3 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 1);
        exStringEquals(ret3, "EHC1147 支払金指定口座情報エラー　送金の取扱いがない支店です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp3 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 2, 2);
        exStringEquals(mosnaiCheckParamtemp3.getDataSyoriControl().getMosno(), "860000611", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn4 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 0);
        exClassificationEquals(ketsrhkosKbn4, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret4 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 1);
        exStringEquals(ret4, "EHC1148 支払金指定口座情報エラー　外貨送金の取扱いがない銀行または支店です。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp4 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 3, 2);
        exStringEquals(mosnaiCheckParamtemp4.getDataSyoriControl().getMosno(), "860000611", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn5 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 4, 0);
        exClassificationEquals(ketsrhkosKbn5, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret5 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 4, 1);
        exStringEquals(ret5, "EHC1150 支払金指定口座情報エラー　口座番号が正しくありません。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp5 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 4, 2);
        exStringEquals(mosnaiCheckParamtemp5.getDataSyoriControl().getMosno(), "860000611", "申込番号");

        C_KetsrhkosKbn ketsrhkosKbn6 = (C_KetsrhkosKbn) MockObjectManager
            .getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 5, 0);
        exClassificationEquals(ketsrhkosKbn6, C_KetsrhkosKbn.SRHORYU_HUBI, "決定成立保留更新区分");
        String ret6 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 5, 1);
        exStringEquals(ret6, "EHC1160 支払金指定口座情報エラー　口座番号の入力桁数が超過しています。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp6 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class,
            "exec", 5, 2);
        exStringEquals(mosnaiCheckParamtemp6.getDataSyoriControl().getMosno(), "860000611", "申込番号");

    }

}
