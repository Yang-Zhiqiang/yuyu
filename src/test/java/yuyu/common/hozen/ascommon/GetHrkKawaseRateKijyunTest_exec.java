package yuyu.common.hozen.ascommon;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 払込用為替レート基準日取得クラスのメソッド {@link GetHrkKawaseRateKijyun#exec(C_NyknaiyouKbn, C_Nykkeiro, BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class GetHrkKawaseRateKijyunTest_exec {

    @Inject
    GetHrkKawaseRateKijyun getHrkKawaseRateKijyun;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(null,
            C_Nykkeiro.KZHRK,
            BizDate.valueOf(20200828),
            null,
            null,
            null,
            null);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 1, "メンバ変数．エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorCd().get(0), KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR, "エラーコード");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), null, "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), null, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.KEIZOKUP,
            C_Nykkeiro.KZHRK,
            null,
            null,
            null,
            null,
            null);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 1, "メンバ変数．エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorCd().get(0), KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR, "エラーコード");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), null, "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), null, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.SYOKAIP,
            null,
            BizDate.valueOf(20200101),
            null,
            null,
            null,
            null);


        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 1, "メンバ変数．エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorCd().get(0), KeisanRsgakuConstants.ERRCD_NYKKEIRO_CHKERROR, "エラーコード");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), KeisanRsgakuConstants.ERRRIYUU_NYKKEIRO_CHKERROR, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), null, "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), null, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(
            C_NyknaiyouKbn.SYOKAIP,
            C_Nykkeiro.KZHRK, BizDate.valueOf(20200101),
            null,
            null,
            null,
            null);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 1, "メンバ変数．エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorCd().get(0), KeisanRsgakuConstants.ERRCD_NYKKEIRO_CHKERROR, "エラーコード");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), KeisanRsgakuConstants.ERRRIYUU_NYKKEIRO_CHKERROR, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), null, "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), null, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.SYOKAIP,
            C_Nykkeiro.SKEI,
            BizDate.valueOf(20200117),
            null,
            null,
            null,
            null);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 0, "メンバ変数．エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), null, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), BizDate.valueOf(20200116), "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_ZENEIGYOUBI, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.SYOKAIP,
            C_Nykkeiro.SKEI,
            BizDate.valueOf(20200120),
            null,
            null,
            null,
            null);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 0, "メンバ変数．エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), null, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), BizDate.valueOf(20200117), "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_ZENEIGYOUBI, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.ZENNOUP,
            null,
            BizDate.valueOf(20200117),
            null,
            null,
            null,
            null);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 0, "メンバ変数．エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), null, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), BizDate.valueOf(20200117), "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_RYOSYUYMD, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.ZENNOUP,
            null,
            BizDate.valueOf(20200119),
            null,
            null,
            null,
            null);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 0, "メンバ変数．エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), null, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), BizDate.valueOf(20200120), "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_RYOSYUYMD, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.KEIZOKUP,
            C_Nykkeiro.OTHER,
            BizDate.valueOf(20210301),
            BizDateYM.valueOf(202102),
            0,
            1,
            C_Hrkkaisuu.TUKI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 0, "メンバ変数．エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), null, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), BizDate.valueOf(20210226), "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_PREMLASTDAY, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.KEIZOKUP,
            C_Nykkeiro.OTHER,
            BizDate.valueOf(20210307),
            BizDateYM.valueOf(202102),
            0,
            3,
            C_Hrkkaisuu.TUKI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 0, "メンバ変数．エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), null, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), BizDate.valueOf(20210308), "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_RYOSYUYMD, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.KEIZOKUP,
            C_Nykkeiro.CREDIT,
            BizDate.valueOf(20210307),
            BizDateYM.valueOf(202103),
            0,
            0,
            C_Hrkkaisuu.NEN);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 0, "メンバ変数．エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), null, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), BizDate.valueOf(20210226), "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_PREMLASTDAY, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.KEIZOKUP,
            C_Nykkeiro.BANK,
            BizDate.valueOf(20210307),
            BizDateYM.valueOf(202104),
            0,
            0,
            C_Hrkkaisuu.HALFY);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 0, "メンバ変数．エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), null, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), BizDate.valueOf(20210308), "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_RYOSYUYMD, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.KEIZOKUP,
            C_Nykkeiro.OTHER,
            BizDate.valueOf(20210301),
            BizDateYM.valueOf(202102),
            0,
            2,
            C_Hrkkaisuu.TUKI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 0, "メンバ変数．エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), null, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), BizDate.valueOf(20210226), "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_PREMLASTDAY, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.KEIZOKUP,
            C_Nykkeiro.KZHRK,
            BizDate.valueOf(20210301),
            BizDateYM.valueOf(202103),
            0,
            2,
            C_Hrkkaisuu.HALFY);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 0, "エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), null, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), BizDate.valueOf(20210301), "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(),  KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_RYOSYUYMD, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.HARAIHENYOUP,
            C_Nykkeiro.KZHRK,
            BizDate.valueOf(20210301),
            BizDateYM.valueOf(202103),
            0,
            1,
            C_Hrkkaisuu.TUKI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 0, "エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), null, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), BizDate.valueOf(20210226), "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_PREMLASTDAY, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.HARAIHENYOUP,
            C_Nykkeiro.KZHRK,
            BizDate.valueOf(20210301),
            BizDateYM.valueOf(202102),
            0,
            2,
            C_Hrkkaisuu.HALFY);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 1, "エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorCd().get(0), KeisanRsgakuConstants.ERRCD_HRKKAISUU_CHKERROR, "エラーコード");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), KeisanRsgakuConstants.ERRRIYUU_HRKKAISUU_CHKERROR, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), null, "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), null, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.KEIZOKUP,
            C_Nykkeiro.BANK,
            BizDate.valueOf(20210301),
            null,
            0,
            0,
            C_Hrkkaisuu.ITIJI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 1, "エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorCd().get(0), KeisanRsgakuConstants.ERRCD_HRKKAISUU_CHKERROR, "エラーコード");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), KeisanRsgakuConstants.ERRRIYUU_HRKKAISUU_CHKERROR, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), BizDate.valueOf(20210226), "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_PREMLASTDAY, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.HUKKATUYOUP,
            C_Nykkeiro.KZHRK,
            BizDate.valueOf(20210301),
            null,
            0,
            0,
            C_Hrkkaisuu.ITIJI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 1, "エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorCd().get(0), KeisanRsgakuConstants.ERRCD_NYKNAIYOUKBN_CHKERROR, "エラーコード");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), KeisanRsgakuConstants.ERRRIYUU_NYKNAIYOUKBN_CHKERROR, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), null, "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), null, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.KEIZOKUP,
            C_Nykkeiro.CONVENI,
            BizDate.valueOf(20210301),
            BizDateYM.valueOf(202102),
            0,
            2,
            C_Hrkkaisuu.HALFY);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 1, "エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorCd().get(0), KeisanRsgakuConstants.ERRCD_NYKKEIRO_CHKERROR, "エラーコード");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), KeisanRsgakuConstants.ERRRIYUU_NYKKEIRO_CHKERROR, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), null, "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(), null, "メンバ変数．為替レート基準日判定区分");
    }


    @Test
    @TestOrder(200)
    public void testExec_A20() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.KEIZOKUP,
            C_Nykkeiro.KZHRK,
            BizDate.valueOf(20210101),
            BizDateYM.valueOf(202102),
            0,
            2,
            C_Hrkkaisuu.HALFY);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 0, "エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), null, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), BizDate.valueOf(20210104), "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(),  KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_RYOSYUYMD, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.KEIZOKUP,
            C_Nykkeiro.KZHRK,
            BizDate.valueOf(20210301),
            BizDateYM.valueOf(202102),
            0,
            2,
            C_Hrkkaisuu.HALFY);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 0, "エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), null, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), BizDate.valueOf(20210129), "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(),  KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_PREMLASTDAY, "メンバ変数．為替レート基準日判定区分");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        C_ErrorKbn kekkaKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.KEIZOKUP,
            C_Nykkeiro.KZHRK,
            BizDate.valueOf(20210301),
            BizDateYM.valueOf(202101),
            0,
            2,
            C_Hrkkaisuu.HALFY);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(getHrkKawaseRateKijyun.getErrorCd().size(), 0, "エラーコードのサイズ");
        exStringEquals(getHrkKawaseRateKijyun.getErrorRiyuu(), null, "メンバ変数．エラー理由");
        exDateEquals(getHrkKawaseRateKijyun.getKawaseRateKijyun(), BizDate.valueOf(20210129), "為替レート基準日");
        exStringEquals(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn(),  KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_PREMLASTDAY, "メンバ変数．為替レート基準日判定区分");
    }
}