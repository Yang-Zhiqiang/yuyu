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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzcommon.SetNenreiMockForSinkeiyaku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BosyuusysctrlKbn;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_YoteikykymdKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 基礎項目設定クラスのメソッド {@link SetKisoKoumoku#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKisoKoumokuTest_exec{

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_基礎項目設定";

    private final static String sheetName = "INデータ_20191008";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetSknnkaisiymd.class).to(SetSknnkaisiymdMockForSinkeiyaku.class);
                bind(SetSyouhinSedai.class).to(SetSyouhinSedaiMockForSinkeiyaku.class);
                bind(SetHubiMsg.class).to(SetHubiMsgMockForSinkeiyaku.class);
                bind(SetNenrei.class).to(SetNenreiMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetKisoKoumokuTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllYoteiRiritu());
        bizDomManager.delete(bizDomManager.getAllSimekiribi());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
        bizDomManager.delete(bizDomManager.getAllBosyuuKyuusi());

    }

    @BeforeClass
    public static void testInit() {
        SetSknnkaisiymdMockForSinkeiyaku.caller = SetKisoKoumokuTest_exec.class;
        SetSyouhinSedaiMockForSinkeiyaku.caller = SetKisoKoumokuTest_exec.class;
        SetHubiMsgMockForSinkeiyaku.caller = SetKisoKoumokuTest_exec.class;
        SetNenreiMockForSinkeiyaku.caller = SetKisoKoumokuTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        SetSknnkaisiymdMockForSinkeiyaku.caller = null;
        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = null;
        SetSyouhinSedaiMockForSinkeiyaku.caller = null;
        SetSyouhinSedaiMockForSinkeiyaku.SYORIPTN = null;
        SetHubiMsgMockForSinkeiyaku.caller = null;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;
        SetNenreiMockForSinkeiyaku.caller = null;
        SetNenreiMockForSinkeiyaku.SYORIPTN = null;
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        try {
            MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
            HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112220");
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setSysDate(BizDate.valueOf("20160413"));

            setKisoKoumoku.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：791112220", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();
        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN4;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160213"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160414"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.valueOf(0), "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201604"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20170425"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20170425"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20170425"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201601"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), BizDateYM.valueOf("201601"), "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201704"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 93, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");
        exClassificationEquals(mosKihon.getSisuukbn(),C_Sisuukbn.BLCON2, "指数区分");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0375), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exBizCalcbleEquals(mosSyouhn.getRendouritu(), BizNumber.valueOf(0.0219), "連動率");
        exNumericEquals(mosSyouhn.getHrkkkn(), 98, "払込期間");
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112238", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHF0011", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "締切日情報該当データ無し　募集年月＝Ｈ２８．０１", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624142000000", "業務用更新時間");


        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, C_KetsrhkosKbn.KETHORYU_HUBI);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, C_SpKeisanKahiKbn.SPKEISANKA);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, C_HubisyubetusyousaiKbn.NONE);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 3,MessageId.EHF0011 + " " + MessageUtil.getMessage(MessageId.EHF0011,
            DateFormatUtil.viewYM("201601")));
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "791112238", "申込番号");
        exClassificationEquals( mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exDateEquals(mosnaiCheckParam.getSysDate(),BizDate.valueOf("20160213"),"システム処理日");
        exStringEquals( mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals( mosnaiCheckParamtemp1.getKosTime(), "20150624142000000", "更新時間");
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 5, C_TknKbn.NONE);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 6, C_MsgKbn.ERROR);

        BizDate kijyunYmd1 = (BizDate) MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0);
        exDateEquals(kijyunYmd1,BizDate.valueOf("20170425"),"基準日");
        BizDate birthday1 = (BizDate) MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1);
        exDateEquals(birthday1,BizDate.valueOf("20101010"),"生年月日");
        BizDate kijyunYmd2 = (BizDate) MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 1, 0);
        exDateEquals(kijyunYmd2,BizDate.valueOf("20170425"),"基準日");
        BizDate birthday2 = (BizDate) MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 1, 1);
        exDateEquals(birthday2,BizDate.valueOf("20111111"),"生年月日");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN2;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN5;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), BizDate.valueOf("20170418"), "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160317"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), BizDate.valueOf("20160317"), "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.valueOf(1.25), "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201604"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20170426"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20160419"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), null, "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), BizDateYM.valueOf("201604"), "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201604"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 94, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 5, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getRendouritu(), BizNumber.valueOf(0), "連動率");
        exNumericEquals(mosSyouhn.getHrkkkn(), 99, "払込期間");

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1048", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％の予定利率が取得できません。契約日　20170426", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624142000000", "業務用更新時間");

        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, C_KetsrhkosKbn.KETHORYU_HUBI);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 1,MessageId.EHC1048 + " " + MessageUtil.getMessage(MessageId.EHC1048,
            "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％", "20170426"));
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "791112246", "申込番号");
        exClassificationEquals( mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals( mosnaiCheckParamtemp1.getYoteiKykymdKbn(), C_YoteikykymdKbn.SITEI, "予定契約日区分");
        exDateEquals(mosnaiCheckParam.getSysDate(),BizDate.valueOf("20160418"),"システム処理日");
        exStringEquals( mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals( mosnaiCheckParamtemp1.getKosTime(), "20150624142000000", "更新時間");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN3;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN6;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setNyuuryokuKawaseRate(null);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160619"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), BizDate.valueOf("20160421"), "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160517"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), BizDate.valueOf("20160516"), "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.valueOf(0.0125), "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201604"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20170417"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20170417"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20170417"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201607"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), BizDateYM.valueOf("201607"), "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201606"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 95, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0375), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exNumericEquals(mosSyouhn.getHrkkkn(), 99, "払込期間");

        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN3;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.ZERO);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160319"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), BizDate.valueOf("20160420"), "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160417"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), BizDate.valueOf("20160415"), "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.valueOf(1.308), "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201604"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20170417"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20170417"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20170417"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201603"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), BizDateYM.valueOf("201603"), "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201604"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 6, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 5, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0375), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exNumericEquals(mosSyouhn.getHrkkkn(), 10, "払込期間");

        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(60)
    public void testExec_A6() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        try {
            SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN4;
            MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");
            List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
            mosnaiCheckParam.setListHubiMsg(hubiMsg);
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
            mosnaiCheckParam.setNyuuryokuKawaseRate(null);
            mosnaiCheckParam.setSysDate(BizDate.valueOf("20160519"));
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("20150624142000000");

            setKisoKoumoku.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号 = 791112279", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN4;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160719"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), null, "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201607"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20170602"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20170602"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20170602"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201607"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), BizDateYM.valueOf("201607"), "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201607"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 5, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0315), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");

        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN4;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112295");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160819"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160301"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201609"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20170602"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20170602"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20170602"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201609"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201608"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 5, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0315), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN5;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112303");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160919"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160301"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201604"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20170902"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20170902"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20170902"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201609"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201609"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 5, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0305), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN3;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112311");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20161019"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160302"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201609"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20171002"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20171002"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20171002"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201610"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201610"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 6, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0305), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112329");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20161019"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160303"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201608"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20171002"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20171002"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20171002"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201610"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201610"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 5, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0305), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112337");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20161019"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), null, "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201604"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20171002"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20171002"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20171002"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201610"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201610"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 5, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0305), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(130)
    public void testExec_A13() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        try {
            SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
            MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112345");
            List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
            mosnaiCheckParam.setListHubiMsg(hubiMsg);
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
            mosnaiCheckParam.setSysDate(BizDate.valueOf("20161019"));
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("20150624142000000");

            setKisoKoumoku.exec(mosnaiCheckParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112345", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(140)
    public void testExec_A14() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        try {
            SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
            MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112352");
            List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
            mosnaiCheckParam.setListHubiMsg(hubiMsg);
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
            mosnaiCheckParam.setSysDate(BizDate.valueOf("20161019"));
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("20150624142000000");

            setKisoKoumoku.exec(mosnaiCheckParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112352", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(150)
    public void testExec_A15() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        try {
            SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
            SetSyouhinSedaiMockForSinkeiyaku.SYORIPTN = SetSyouhinSedaiMockForSinkeiyaku.TESTPATTERN1;
            MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112360");
            List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
            mosnaiCheckParam.setListHubiMsg(hubiMsg);
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
            mosnaiCheckParam.setSysDate(BizDate.valueOf("20161019"));
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("20150624142000000");

            setKisoKoumoku.exec(mosnaiCheckParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：791112360", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();
        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setYoteiKykymdKbn(C_YoteikykymdKbn.SITEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20161019"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160815"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), null, "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20160415"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20171002"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), null, "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), null, "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), null, "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 5, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "予定利率が取得できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, "");
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 1,MessageUtil.getMessage(MessageId.EGA1025));

        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 2,C_SekmossakuseiErroutKbn.GAMEN);

        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "791112378", "申込番号");
        exClassificationEquals( mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals( mosnaiCheckParamtemp1.getYoteiKykymdKbn(), C_YoteikykymdKbn.SITEI, "予定契約日区分");
        exDateEquals(mosnaiCheckParam.getSysDate(),BizDate.valueOf("20161019"),"システム処理日");
        exStringEquals( mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals( mosnaiCheckParamtemp1.getKosTime(), "20150624142000000", "更新時間");

    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN3;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setYoteiKykymdKbn(C_YoteikykymdKbn.SITEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20161019"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.TIGIN);

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160102"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), null, "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20171002"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20171002"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20171002"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), null, "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), null, "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 6, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0305), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exNumericEquals(hubiMsg.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN3;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112394");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setYoteiKykymdKbn(C_YoteikykymdKbn.AUTO);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.ZERO);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20161019"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160814"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), BizDate.valueOf("20160812"), "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.valueOf(2.0134), "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), null, "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20171002"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20171002"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20171002"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), null, "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(),null, "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 6, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0335), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exNumericEquals(hubiMsg.size(), 0, "件数");

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112402");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20170427));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf(20170426), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201703"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20171002"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20171002"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20171002"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201704"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201704"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 5, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0305), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");

        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112410");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20170525));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf(20170427), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201705"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20171002"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20171002"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20171002"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201705"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201705"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 5, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0305), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112428");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20170619));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf(20170428), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201707"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20171002"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20171002"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20171002"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201707"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201706"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 5, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0305), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");

        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112436");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20170621));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf(20170427), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201610"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20171002"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20171002"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20171002"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201707"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201706"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 5, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0305), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");

        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();
        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN21;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), BizDate.valueOf("20170418"), "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160317"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), BizDate.valueOf("20160317"), "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.valueOf(1.25), "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201604"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20160419"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20160419"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), null, "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), BizDateYM.valueOf("201604"), "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201604"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 6, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 5, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000017", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1048", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の予定利率が取得できません。契約日　20160419",
            "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624142000000", "業務用更新時間");

        BM_SyouhnZokusei syouhnZokusei = mosnaiCheckParam.getSyuSyouhnZokusei();
        exStringEquals(syouhnZokusei.getSyouhncd(), "ｱ1", "商品コード");
        exNumericEquals(syouhnZokusei.getSyouhnsdno(), 1, "商品世代番号");

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = mosnaiCheckParam.getListTkSyouhnZokusei();
        exNumericEquals(listTkSyouhnZokusei.size(), 0, "件数");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();
        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setYoteiKykymdKbn(C_YoteikykymdKbn.SITEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20161019"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160815"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), null, "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20160415"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20171002"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), null, "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), null, "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), null, "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 5, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "予定利率が取得できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        BM_SyouhnZokusei syouhnZokusei = mosnaiCheckParam.getSyuSyouhnZokusei();
        exStringEquals(syouhnZokusei.getSyouhncd(), "ｱ1", "商品コード");
        exNumericEquals(syouhnZokusei.getSyouhnsdno(), 1, "商品世代番号");

        List<BM_SyouhnZokusei> listsyouhnZokusei = mosnaiCheckParam.getListTkSyouhnZokusei();
        exStringEquals(listsyouhnZokusei.get(0).getSyouhncd(), "ｱ2", "商品コード");
        exNumericEquals(listsyouhnZokusei.get(0).getSyouhnsdno(), 1, "商品世代番号");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();
        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20170619"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf(20170428), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201707"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20171002"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20171002"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), BizDate.valueOf("20171002"), "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201707"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201706"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 5, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0.0305), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exNumericEquals(hubiMsg.size(), 0, "件数");

        BM_SyouhnZokusei syouhnZokusei = mosnaiCheckParam.getSyuSyouhnZokusei();
        exStringEquals(syouhnZokusei.getSyouhncd(), "ﾕｲ", "商品コード");
        exNumericEquals(syouhnZokusei.getSyouhnsdno(), 1, "商品世代番号");

        List<BM_SyouhnZokusei> listsyouhnZokusei = mosnaiCheckParam.getListTkSyouhnZokusei();
        exStringEquals(listsyouhnZokusei.get(0).getSyouhncd(), "ｱ2", "商品コード");
        exNumericEquals(listsyouhnZokusei.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(listsyouhnZokusei.get(1).getSyouhncd(), "ｲ1", "商品コード");
        exNumericEquals(listsyouhnZokusei.get(1).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(listsyouhnZokusei.get(2).getSyouhncd(), "ｲ2", "商品コード");
        exNumericEquals(listsyouhnZokusei.get(2).getSyouhnsdno(), 1, "商品世代番号");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(260)
    public void testExec_A26() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        try {
            SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
            SetSyouhinSedaiMockForSinkeiyaku.SYORIPTN = SetSyouhinSedaiMockForSinkeiyaku.TESTPATTERN1;
            MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
            List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
            mosnaiCheckParam.setListHubiMsg(hubiMsg);
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
            mosnaiCheckParam.setSysDate(BizDate.valueOf("20161019"));
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("20150624142000000");

            setKisoKoumoku.exec(mosnaiCheckParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：860000041", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN3;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000306");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), BizDate.valueOf("20170418"), "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160317"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), BizDate.valueOf("20160317"), "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.valueOf(1.25), "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201604"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20160516"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20160419"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), null, "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), BizDateYM.valueOf("201604"), "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201604"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 6, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 5, "契約者年齢");
        exNumericEquals(mosKihon.getZnnkai(), 0, "前納回数");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000306", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1120", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建個人年金保険（一時払い）・据置期間０歳は予定利率低下の影響のため募集休止中です。申込撤回のお手続きを実施ください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624142000000", "業務用更新時間");

        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, C_KetsrhkosKbn.KETHORYU_HUBI);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 1,MessageId.EHC1120 + " " + MessageUtil.getMessage(MessageId.EHC1120,
            "５年ごと利差配当付指定通貨建個人年金保険（一時払い）・据置期間０歳"));
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2);

        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000306", "申込番号");
        exClassificationEquals( mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals( mosnaiCheckParamtemp1.getYoteiKykymdKbn(), C_YoteikykymdKbn.SITEI, "予定契約日区分");
        exDateEquals(mosnaiCheckParam.getSysDate(),BizDate.valueOf("20160418"),"システム処理日");
        exStringEquals( mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals( mosnaiCheckParamtemp1.getKosTime(), "20150624142000000", "更新時間");

    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN4;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000298");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), BizDate.valueOf("20170418"), "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160317"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), BizDate.valueOf("20160317"), "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.valueOf(1.25), "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201604"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20160516"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20160419"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), null, "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), BizDateYM.valueOf("201604"), "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201604"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 6, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 5, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000298", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1048", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建個人年金保険（一時払い）　年金原資最低保証１００％の予定利率が取得できません。契約日　２０１６０５１６", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624142000000", "業務用更新時間");

    }
    @Test
    @TestOrder(290)
    public void testExec_A29() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN6;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000280");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), BizDate.valueOf("20170418"), "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160317"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), BizDate.valueOf("20160317"), "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.valueOf(1.25), "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201604"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20160516"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20160419"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), null, "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), BizDateYM.valueOf("201604"), "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201604"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 6, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 5, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000280", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1048", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建個人年金保険（一時払い）の予定利率が取得できません。契約日　２０１６０５１６", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624142000000", "業務用更新時間");
    }
    @Test
    @TestOrder(300)
    public void testExec_A30() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN5;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000256");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), BizDate.valueOf("20170418"), "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160317"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), BizDate.valueOf("20160317"), "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.valueOf(1.25), "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf("201604"), "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20170426"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20160419"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), null, "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), BizDateYM.valueOf("201604"), "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), BizDateYM.valueOf("201604"), "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 6, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 5, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000256", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1120", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％は予定利率低下の影響のため募集休止中です。申込撤回のお手続きを実施ください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624142000000", "業務用更新時間");

    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();
        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN6;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000207");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setYoteiKykymdKbn(C_YoteikykymdKbn.SITEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20161019"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160815"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), null, "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20160415"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20171002"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), null, "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), null, "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), null, "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 5, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "指定通貨円・据置期間７０歳のお取扱いは現在休止しています", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, "");
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 1,"指定通貨円・据置期間７０歳"+ MessageUtil.getMessage(MessageId.EGA1054));

        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 2,C_SekmossakuseiErroutKbn.GAMEN);

        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000207", "申込番号");
        exClassificationEquals( mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals( mosnaiCheckParamtemp1.getYoteiKykymdKbn(), C_YoteikykymdKbn.SITEI, "予定契約日区分");
        exDateEquals(mosnaiCheckParam.getSysDate(),BizDate.valueOf("20161019"),"システム処理日");
        exStringEquals( mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals( mosnaiCheckParamtemp1.getKosTime(), "20150624142000000", "更新時間");

    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();
        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN6;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN7;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000215");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setYoteiKykymdKbn(C_YoteikykymdKbn.SITEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20161019"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);

        setKisoKoumoku.exec(mosnaiCheckParam);

        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), BizDate.valueOf("20160104"), "領収日");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.ZERO, "入金用為替レート");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), null, "申込月度");
        exDateEquals(mosKihon.getKykymd(), BizDate.valueOf("20160415"), "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), BizDate.valueOf("20171002"), "責任開始日");
        exDateEquals(mosKihon.getSkykymd(), null, "指定契約日");
        exDateYMEquals(mosKihon.getBosyuuym(), null, "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), null, "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 5, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 4, "契約者年齢");

        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "指定通貨円のお取扱いは現在休止しています", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, "");
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 1,"指定通貨円"+ MessageUtil.getMessage(MessageId.EGA1054));

        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 2,C_SekmossakuseiErroutKbn.GAMEN);

        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000215", "申込番号");
        exClassificationEquals( mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals( mosnaiCheckParamtemp1.getYoteiKykymdKbn(), C_YoteikykymdKbn.SITEI, "予定契約日区分");
        exDateEquals(mosnaiCheckParam.getSysDate(),BizDate.valueOf("20161019"),"システム処理日");
        exStringEquals( mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals( mosnaiCheckParamtemp1.getKosTime(), "20150624142000000", "更新時間");

    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN3;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000140");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exNumericEquals(mosKihon.getZnnkai(), 1, "前納回数");

    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN3;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000157");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exNumericEquals(mosKihon.getZnnkai(), 3, "前納回数");

    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN3;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000165");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exNumericEquals(mosKihon.getZnnkai(), 3, "前納回数");

    }
    @Test
    @TestOrder(360)
    public void testExec_A36() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN3;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000173");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exNumericEquals(mosKihon.getZnnkai(), 3, "前納回数");

    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {
        MockObjectManager.initialize();
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000504");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "指定通貨円・据置期間０歳（定期支払）のお取扱いは現在休止しています", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {
        MockObjectManager.initialize();
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000496");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "指定通貨円・据置期間０歳のお取扱いは現在休止しています", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {
        MockObjectManager.initialize();
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;
        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000488");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000488", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1120", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建個人年金保険（一時払い）・据置期間０歳は予定利率低下の影響のため募集休止中です。申込撤回のお手続きを実施ください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624142000000", "業務用更新時間");

    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {
        MockObjectManager.initialize();
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000470");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "指定通貨円・据置期間０歳のお取扱いは現在休止しています", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(410)
    public void testExec_A41() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();
        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN21;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860009992");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860009992", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "THC1171", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "【特認可能】不備メッセージ", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KIHON_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624142000000", "業務用更新時間");
    }

    @Test
    @TestOrder(420)
    public void testExec_A42() {
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        MockObjectManager.initialize();
        SetSknnkaisiymdMockForSinkeiyaku.SYORIPTN = SetSknnkaisiymdMockForSinkeiyaku.TESTPATTERN2;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN21;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860010008");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(1.25));
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160418"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");

        setKisoKoumoku.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "生保Ｗｅｂメッセージ１４１", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "生保Ｗｅｂメッセージ２４１", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
}
