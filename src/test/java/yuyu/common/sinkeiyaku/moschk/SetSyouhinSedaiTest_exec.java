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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 商品世代番号設定のメソッド {@link SetSyouhinSedai#exec(MosnaiCheckParam, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetSyouhinSedaiTest_exec {

    private final static String mosNo1 = "791112220";

    private final static String mosNo2 = "791112238";

    private final static String mosNo3 = "791112246";

    private final static String mosNo4 = "791112253";

    private final static String mosNo5 = "791112261";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_商品世代番号設定";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetHubiMsg.class).to(SetHubiMsgMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){

        SetHubiMsgMockForSinkeiyaku.caller = SetSyouhinSedaiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        SetHubiMsgMockForSinkeiyaku.caller = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetSyouhinSedaiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        BizDate kykYmd = BizDate.valueOf("20160604");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        SetSyouhinSedai setSyouhinSedai = SWAKInjector.getInstance(SetSyouhinSedai.class);

        try{
            setSyouhinSedai.exec(mosnaiCheckParam, kykYmd);
        }
        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112220", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        BizDate kykYmd = BizDate.valueOf("20160606");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");

        SetSyouhinSedai setSyouhinSedai = SWAKInjector.getInstance(SetSyouhinSedai.class);
        setSyouhinSedai.exec(mosnaiCheckParam, kykYmd);

        HT_MosSyouhn mosSyouhnWk =
            syoriCTL.getMosSyouhnBySyouhncd("1001");

        exStringEquals(mosSyouhnWk.getMosno(), "791112238", "申込番号");
        exNumericEquals(mosSyouhnWk.getSyouhnsdno(), 5, "商品世代番号設定");
        exStringEquals(mosSyouhnWk.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosSyouhnWk.getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 0, "結果画面ＭＳＧの件数");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        BizDate kykYmd = BizDate.valueOf("20160606");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        SetSyouhinSedai setSyouhinSedai = SWAKInjector.getInstance(SetSyouhinSedai.class);
        try{
            setSyouhinSedai.exec(mosnaiCheckParam, kykYmd);
        }
        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。商品コード=1006", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        BizDate kykYmd = BizDate.valueOf("20160606");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");

        SetSyouhinSedai setSyouhinSedai = SWAKInjector.getInstance(SetSyouhinSedai.class);
        setSyouhinSedai.exec(mosnaiCheckParam, kykYmd);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        List<HT_MosSyouhn> mosSyouhnLst = sinkeiyakuDomManager.getSyoriCTL(mosNo4).getMosSyouhns();

        exStringEquals(mosSyouhnLst.get(0).getSyouhncd(), "1002", "商品コード");
        exNumericEquals(mosSyouhnLst.get(0).getSyouhnsdno(), 2, "商品世代番号");
        exStringEquals(mosSyouhnLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosSyouhnLst.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(mosSyouhnLst.get(1).getSyouhncd(), "1003", "商品コード");
        exNumericEquals(mosSyouhnLst.get(1).getSyouhnsdno(), 3, "商品世代番号");
        exStringEquals(mosSyouhnLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosSyouhnLst.get(1).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(mosSyouhnLst.get(2).getSyouhncd(), "1004", "商品コード");
        exNumericEquals(mosSyouhnLst.get(2).getSyouhnsdno(), 3, "商品世代番号");
        exStringEquals(mosSyouhnLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosSyouhnLst.get(2).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        String hubiMsg1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(hubiMsg1, MessageId.EHC0190 + " " + MessageUtil.getMessage(MessageId.EHC0190, "商品名２"), "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), mosNo4, "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp1.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp1.getKosTime(), "20150603111400000", "更新時間");

        C_KetsrhkosKbn ketsrhkosKbn2 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec",1, 0);
        exClassificationEquals(ketsrhkosKbn2, C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        String hubiMsg2 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1);
        exStringEquals(hubiMsg2, MessageId.EHC0190 + " " + MessageUtil.getMessage(MessageId.EHC0190, "商品名３"), "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 2);
        exStringEquals(mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), mosNo4, "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp2.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp2.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp2.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp2.getKosTime(), "20150603111400000", "更新時間");

        C_KetsrhkosKbn ketsrhkosKbn3 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 0);
        exClassificationEquals(ketsrhkosKbn3, C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        String hubiMsg3 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 1);
        exStringEquals(hubiMsg3, MessageId.EHC0190 + " " + MessageUtil.getMessage(MessageId.EHC0190, "商品名Ｃ"), "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp3 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 2);
        exStringEquals(mosnaiCheckParamtemp3.getDataSyoriControl().getMosno(), mosNo4, "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp3.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp3.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp3.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp3.getKosTime(), "20150603111400000", "更新時間");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        List<HT_MosSyouhn> mosSyouhnLst =syoriCTL.getMosSyouhns();
        BizDate kykYmd = BizDate.valueOf("20160606");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");

        SetSyouhinSedai setSyouhinSedai = SWAKInjector.getInstance(SetSyouhinSedai.class);
        setSyouhinSedai.exec(mosnaiCheckParam, kykYmd);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");

        exStringEquals(mosSyouhnLst.get(0).getSyouhncd(), "1002", "商品コード");
        exNumericEquals(mosSyouhnLst.get(0).getSyouhnsdno(), 2, "商品世代番号");
        exStringEquals(mosSyouhnLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosSyouhnLst.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");

        exStringEquals(mosSyouhnLst.get(1).getSyouhncd(), "1003", "商品コード");
        exNumericEquals(mosSyouhnLst.get(1).getSyouhnsdno(), 3, "商品世代番号");
        exStringEquals(mosSyouhnLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosSyouhnLst.get(1).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");

        exStringEquals(mosSyouhnLst.get(2).getSyouhncd(), "1004", "商品コード");
        exNumericEquals(mosSyouhnLst.get(2).getSyouhnsdno(), 3, "商品世代番号");
        exStringEquals(mosSyouhnLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosSyouhnLst.get(2).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");


        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        String hubiMsg1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(hubiMsg1, MessageId.EHC0049 + " " + MessageUtil.getMessage(MessageId.EHC0049, "商品名２"), "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), mosNo4, "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp1.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp1.getKosTime(), "20150603111400000", "更新時間");

        C_KetsrhkosKbn ketsrhkosKbn2 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec",1, 0);
        exClassificationEquals(ketsrhkosKbn2, C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        String hubiMsg2 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1);
        exStringEquals(hubiMsg2, MessageId.EHC0049 + " " + MessageUtil.getMessage(MessageId.EHC0049, "商品名３"), "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 2);
        exStringEquals(mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), mosNo4, "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp2.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp2.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp2.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp2.getKosTime(), "20150603111400000", "更新時間");

        C_KetsrhkosKbn ketsrhkosKbn3 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 0);
        exClassificationEquals(ketsrhkosKbn3, C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        String hubiMsg3 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 1);
        exStringEquals(hubiMsg3, MessageId.EHC0049 + " " + MessageUtil.getMessage(MessageId.EHC0049, "商品名Ｃ"), "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp3 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 2);
        exStringEquals(mosnaiCheckParamtemp3.getDataSyoriControl().getMosno(), mosNo4, "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp3.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp3.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp3.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp3.getKosTime(), "20150603111400000", "更新時間");


    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_C1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        BizDate kykYmd = BizDate.valueOf("20160602");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user10000100001");
        mosnaiCheckParam.setKosTime("20150603111400000");

        SetSyouhinSedai setSyouhinSedai = SWAKInjector.getInstance(SetSyouhinSedai.class);
        setSyouhinSedai.exec(mosnaiCheckParam, kykYmd);

        HT_MosSyouhn mosSyouhnWk =
            syoriCTL.getMosSyouhnBySyouhncd("1005");

        exStringEquals(mosSyouhnWk.getMosno(), "791112261", "申込番号");
        exStringEquals(mosSyouhnWk.getSyouhncd(), "1005", "商品コード");
        exNumericEquals(mosSyouhnWk.getSyouhnsdno(), 99, "商品世代番号");
        exStringEquals(mosSyouhnWk.getRyouritusdno(), "999", "料率世代番号");
        exClassificationEquals(mosSyouhnWk.getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exBizCalcbleEquals(mosSyouhnWk.getYoteiriritu(), BizNumber.valueOf(2.4567), "予定利率");
        exClassificationEquals(mosSyouhnWk.getSknenkinsyu(),C_Sknenkinsyu.KKTI10 , "新契約年金種類");
        exBizCalcbleEquals(mosSyouhnWk.getKihons(), BizCurrency.valueOf(985647456), "基本Ｓ");
        exBizCalcbleEquals(mosSyouhnWk.getSeitoukihons(), BizCurrency.valueOf(985647457), "正当基本Ｓ");
        exBizCalcbleEquals(mosSyouhnWk.getSyutkp(), BizCurrency.valueOf(985647458), "主契約・特約Ｐ");
        exBizCalcbleEquals(mosSyouhnWk.getHrktuukasyutkp(), BizCurrency.valueOf(985647459), "払込通貨主契約・特約Ｐ");
        exBizCalcbleEquals(mosSyouhnWk.getTkjyp(), BizCurrency.valueOf(985647460), "特条保険料");
        exClassificationEquals(mosSyouhnWk.getKatakbn(),C_KataKbn.HONNIN , "型区分");
        exClassificationEquals(mosSyouhnWk.getKyhkatakbn(),C_KyhgndkataKbn.TYPE60 , "給付型区分");
        exClassificationEquals(mosSyouhnWk.getSyukyhkinkatakbn(),C_SyukyhkinkataKbn.SYU1 , "手術給付金型区分");
        exClassificationEquals(mosSyouhnWk.getKhnkyhkgbairitukbn(),C_KhnkyhkgbairituKbn.ITIBAI , "基本給付金額倍率区分");
        exClassificationEquals(mosSyouhnWk.getRokudaildkbn(),C_6daiLdKbn.ARI , "６大生活習慣病追加給付型区分");
        exNumericEquals(mosSyouhnWk.getHknkkn(), 15, "保険期間");
        exNumericEquals(mosSyouhnWk.getHrkkkn(), 16, "払込期間");
        exClassificationEquals(mosSyouhnWk.getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI , "保険期間歳満期区分");
        exClassificationEquals(mosSyouhnWk.getHrkkknsmnkbn(),C_HrkkknsmnKbn.SAIMANKI , "払込期間歳満期区分");
        exStringEquals(mosSyouhnWk.getGyoumuKousinsyaId(), "user10000100001", "業務用更新者ＩＤ");
        exStringEquals(mosSyouhnWk.getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");

    }
}
