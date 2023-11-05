package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMq;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMqMockForHozen;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiYokenBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HnsychkTaisyousyaKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 反社・選択情報チェッククラスのメソッド {@link CheckHansyaSentakuInfo#exec(C_HnsychkTaisyousyaKbn,String,String,C_KjkhukaKbn,BizDate,String,C_ErrorKbn,C_UmuKbn,C_UmuKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CheckHansyaSentakuInfoTest_exec {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzSakuinTsnSyoukaiMq.class).to(BzSakuinTsnSyoukaiMqMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        BzSakuinTsnSyoukaiMqMockForHozen.caller = CheckHansyaSentakuInfoTest_exec.class;
        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = null;
    }

    @AfterClass
    public static void testClear() {

        BzSakuinTsnSyoukaiMqMockForHozen.caller = null;

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "1";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20160103);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.NONE, C_UmuKbn.NONE);

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean)MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMockForHozen.class, "exec", 0, 0);

        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.MEIGISYOUKAI, "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.BLNK, "索引通算対象者区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyounmkn(), "対象者1", "対象者氏名（カナ）");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyounmkj(), "対象者2", "対象者氏名（漢字）");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyouseiymd(), BizDate.valueOf(20160103), "対象者生年月日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyouyno(), "1234567", "対象者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHhknyno(), "", "被保険者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHhknsykgycd(), "", "被保険者職業コード");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn1(), "", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj1(), "", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn2(), "", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj2(), "", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn3(), "", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj3(), "", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn4(), "", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj4(), "", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj5(), "", "関係者氏名（漢字）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKanrisosikicd2(), "", "管理組織コード２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsintelno(), "", "通信先電話番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getBankcd(), "", "銀行番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getShitencd(), "", "支店番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKouzano(), "", "口座番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK, "索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), "", "索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.YOU, "ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.HUYOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), "", "通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), null, "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU, "契約者同一代理店通算Ｓ照会要否区分");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getDairitencd1(), "", "代理店コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getDairitencd2(), "", "代理店コード２");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU, "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ハンド決定要否照会要否区分");

        exStringEquals(checkHansyaSentakuInfo.getWarningMsgIdList().get(0), MessageId.WIA1007, "ワーニングメッセージIDリスト");
        exStringEquals(checkHansyaSentakuInfo.getWarningMsgList().get(0), "反社・選択情報チェックが実施できませんでした。索引照会で確認してください。", "ワーニングメッセージリスト");

        exBooleanEquals(result, false, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "2";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20160103);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.NONE, C_UmuKbn.NONE);

        exStringEquals(checkHansyaSentakuInfo.getWarningMsgIdList().get(0), MessageId.WIA1008, "ワーニングメッセージIDリスト");
        exStringEquals(checkHansyaSentakuInfo.getWarningMsgList().get(0), "ＰＡＬあて照会不可のため反社・選択情報が確認できません。索引照会で確認してください。", "ワーニングメッセージリスト");

        exBooleanEquals(result, false, "処理結果");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "3";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20160103);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.NONE, C_UmuKbn.NONE);

        exStringEquals(checkHansyaSentakuInfo.getWarningMsgIdList().get(0), MessageId.WIA1009, "ワーニングメッセージIDリスト");
        exStringEquals(checkHansyaSentakuInfo.getWarningMsgList().get(0), "ＰＡＬでの索引照会不可のため反社・選択情報が確認できません。索引照会で確認してください。", "ワーニングメッセージリスト");

        exBooleanEquals(result, false, "処理結果");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "4";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20160103);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.NONE, C_UmuKbn.NONE);

        exStringEquals(checkHansyaSentakuInfo.getWarningMsgIdList().get(0), MessageId.WBA0015, "ワーニングメッセージIDリスト");
        exStringEquals(checkHansyaSentakuInfo.getWarningMsgList().get(0), "契約者が名寄せ不明です。ＭＲ・シグナル情報を確認してください。　対象者1様", "ワーニングメッセージリスト");

        exBooleanEquals(result, false, "処理結果");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "8";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20160103);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.NONE, C_UmuKbn.NONE);

        exStringEquals(checkHansyaSentakuInfo.getWarningMsgIdList().get(0), MessageId.WBA0014, "ワーニングメッセージIDリスト");
        exStringEquals(checkHansyaSentakuInfo.getWarningMsgList().get(0), "契約者にシグナル情報があります。　対象者1様", "ワーニングメッセージリスト");

        exBooleanEquals(result, false, "処理結果");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "9";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20160103);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.NONE, C_UmuKbn.NONE);

        exStringEquals(checkHansyaSentakuInfo.getWarningMsgIdList().get(0), MessageId.WIA1009, "ワーニングメッセージIDリスト");
        exStringEquals(checkHansyaSentakuInfo.getWarningMsgList().get(0), "ＰＡＬでの索引照会不可のため反社・選択情報が確認できません。索引照会で確認してください。", "ワーニングメッセージリスト");

        exBooleanEquals(result, false, "処理結果");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "10";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20160103);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.NONE, C_UmuKbn.NONE);

        exStringEquals(checkHansyaSentakuInfo.getWarningMsgIdList().get(0), MessageId.WIA1009, "ワーニングメッセージIDリスト");
        exStringEquals(checkHansyaSentakuInfo.getWarningMsgIdList().get(1), MessageId.WBA0013, "ワーニングメッセージIDリスト");
        exStringEquals(checkHansyaSentakuInfo.getWarningMsgList().get(0), "ＰＡＬでの索引照会不可のため反社・選択情報が確認できません。索引照会で確認してください。", "ワーニングメッセージリスト");
        exStringEquals(checkHansyaSentakuInfo.getWarningMsgList().get(1), "契約者にＭＲ情報があります。　対象者1様", "ワーニングメッセージリスト");

        exBooleanEquals(result, false, "処理結果");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "5";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20160103);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.NONE, C_UmuKbn.NONE);

        exNumericEquals(checkHansyaSentakuInfo.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストのサイズ");
        exNumericEquals(checkHansyaSentakuInfo.getWarningMsgList().size(), 0, "ワーニングメッセージリストのサイズ");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "6";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20160103);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.NONE, C_UmuKbn.NONE);

        exStringEquals(checkHansyaSentakuInfo.getWarningMsgIdList().get(0), MessageId.WBA0013, "ワーニングメッセージIDリスト");
        exStringEquals(checkHansyaSentakuInfo.getWarningMsgList().get(0), "契約者にＭＲ情報があります。　対象者1様", "ワーニングメッセージリスト");

        exBooleanEquals(result, false, "処理結果");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "7";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20160103);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.NONE, C_UmuKbn.NONE);
        exNumericEquals(checkHansyaSentakuInfo.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストのサイズ");
        exNumericEquals(checkHansyaSentakuInfo.getWarningMsgList().size(), 0, "ワーニングメッセージリストのサイズ");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "11";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20160103);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.NONE, C_UmuKbn.NONE);

        exStringEquals(checkHansyaSentakuInfo.getWarningMsgIdList().get(0), MessageId.WIA1009, "ワーニングメッセージIDリスト");
        exStringEquals(checkHansyaSentakuInfo.getWarningMsgList().get(0), "ＰＡＬでの索引照会不可のため反社・選択情報が確認できません。索引照会で確認してください。", "ワーニングメッセージリスト");

        exBooleanEquals(result, false, "処理結果");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "12";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20160103);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.NONE, C_UmuKbn.NONE);

        exStringEquals(checkHansyaSentakuInfo.getWarningMsgIdList().get(0), MessageId.WBA1005, "ワーニングメッセージIDリスト");
        exStringEquals(checkHansyaSentakuInfo.getWarningMsgList().get(0), "契約者に新選択情報があります。　対象者2様", "ワーニングメッセージリスト");

        exBooleanEquals(result, false, "処理結果");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "13";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20160103);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.NONE, C_UmuKbn.NONE);

        exNumericEquals(checkHansyaSentakuInfo.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストのサイズ");
        exNumericEquals(checkHansyaSentakuInfo.getWarningMsgList().size(), 0, "ワーニングメッセージリストのサイズ");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "13";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20160103);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.NONE, C_UmuKbn.NONE);

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean)MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMockForHozen.class, "exec", 0, 0);

        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.MEIGISYOUKAI, "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.BLNK, "索引通算対象者区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyounmkn(), "対象者1", "対象者氏名（カナ）");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyounmkj(), "対象者2", "対象者氏名（漢字）");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyouseiymd(), BizDate.valueOf(20160103), "対象者生年月日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyouyno(), "1234567", "対象者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHhknyno(), "", "被保険者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHhknsykgycd(), "", "被保険者職業コード");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn1(), "", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj1(), "", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn2(), "", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj2(), "", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn3(), "", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj3(), "", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn4(), "", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj4(), "", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj5(), "", "関係者氏名（漢字）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKanrisosikicd2(), "", "管理組織コード２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsintelno(), "", "通信先電話番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getBankcd(), "", "銀行番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getShitencd(), "", "支店番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKouzano(), "", "口座番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK, "索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), "", "索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.YOU, "ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.HUYOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), "", "通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), null, "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU, "契約者同一代理店通算Ｓ照会要否区分");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getDairitencd1(), "", "代理店コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getDairitencd2(), "", "代理店コード２");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU, "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ハンド決定要否照会要否区分");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "13";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20160103);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.KJKHUKA, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.NONE, C_UmuKbn.NONE);

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean)MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMockForHozen.class, "exec", 0, 0);

        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.MEIGISYOUKAI, "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.BLNK, "索引通算対象者区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyounmkn(), "対象者1", "対象者氏名（カナ）");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyounmkj(), "", "対象者氏名（漢字）");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyouseiymd(), BizDate.valueOf(20160103), "対象者生年月日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyouyno(), "1234567", "対象者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHhknyno(), "", "被保険者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHhknsykgycd(), "", "被保険者職業コード");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn1(), "", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj1(), "", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn2(), "", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj2(), "", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn3(), "", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj3(), "", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn4(), "", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj4(), "", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj5(), "", "関係者氏名（漢字）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKanrisosikicd2(), "", "管理組織コード２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsintelno(), "", "通信先電話番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getBankcd(), "", "銀行番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getShitencd(), "", "支店番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKouzano(), "", "口座番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK, "索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), "", "索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.YOU, "ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.HUYOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), "", "通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), null, "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU, "契約者同一代理店通算Ｓ照会要否区分");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getDairitencd1(), "", "代理店コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getDairitencd2(), "", "代理店コード２");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU, "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ハンド決定要否照会要否区分");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "14";

        String taisyouNmKn = "ユカサナ　イチア";
        String taisyouNmKj = "ユ笠名　一あ";
        BizDate taisyouSeiYMD = BizDate.valueOf(20180404);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.OK, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exStringEquals(checkHansyaSentakuInfo.getWarningMsgIdList().get(0), MessageId.WIA1020, "ワーニングメッセージIDリスト");
        exStringEquals(checkHansyaSentakuInfo.getWarningMsgList().get(0), "契約者にＰＥＰｓ情報があります。　新名義ユカサナ　イチア様　平成30年 4月 4日生　同一人の場合は高リスク取引時確認記録書必要", "ワーニングメッセージリスト");

        exBooleanEquals(result, false, "処理結果");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "15";

        String taisyouNmKn = "対象者1";
        String taisyouNmKj = "対象者2";
        BizDate taisyouSeiYMD = BizDate.valueOf(20180404);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exNumericEquals(checkHansyaSentakuInfo.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストのサイズ");
        exNumericEquals(checkHansyaSentakuInfo.getWarningMsgList().size(), 0, "ワーニングメッセージリストのサイズ");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "14";

        String taisyouNmKn = "ユカサナ　イチア";
        String taisyouNmKj = "ユ笠名　一あ";
        BizDate taisyouSeiYMD = BizDate.valueOf(20180404);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.OK, C_UmuKbn.NONE, C_UmuKbn.ARI);

        exStringEquals(checkHansyaSentakuInfo.getWarningMsgIdList().get(0), MessageId.WIA1020, "ワーニングメッセージIDリスト");
        exStringEquals(checkHansyaSentakuInfo.getWarningMsgList().get(0), "契約者にＰＥＰｓ情報があります。　新名義ユカサナ　イチア様　平成30年 4月 4日生　同一人の場合は高リスク取引時確認記録書必要", "ワーニングメッセージリスト");

        exBooleanEquals(result, false, "処理結果");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "14";

        String taisyouNmKn = "ユカサナ　イチア";
        String taisyouNmKj = "ユ笠名　一あ";
        BizDate taisyouSeiYMD = BizDate.valueOf(20180404);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.OK, C_UmuKbn.NONE, C_UmuKbn.NONE);

        exNumericEquals(checkHansyaSentakuInfo.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストのサイズ");
        exNumericEquals(checkHansyaSentakuInfo.getWarningMsgList().size(), 0, "ワーニングメッセージリストのサイズ");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        BzSakuinTsnSyoukaiMqMockForHozen.SYORIPTN = "14";

        String taisyouNmKn = "ユカサナ　イチア";
        String taisyouNmKj = "ユ笠名　一あ";
        BizDate taisyouSeiYMD = BizDate.valueOf(20180404);
        String taisyou = "1234567";

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean result = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYK, taisyouNmKn, taisyouNmKj, C_KjkhukaKbn.BLNK, taisyouSeiYMD, taisyou, C_ErrorKbn.ERROR, C_UmuKbn.ARI, C_UmuKbn.NONE);

        exStringEquals(checkHansyaSentakuInfo.getWarningMsgIdList().get(0), MessageId.WIA1029, "ワーニングメッセージIDリスト");
        exStringEquals(checkHansyaSentakuInfo.getWarningMsgList().get(0), "貯蓄性保険表示設定を実行できませんでした。高リスク契約の可能性があるため、契約状態を確認してください。", "ワーニングメッセージリスト");

        exBooleanEquals(result, false, "処理結果");
    }
}
