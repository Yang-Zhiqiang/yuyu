package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_HijynbrsikinidouyouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 経理伝票データ作成共通処理クラスのメソッド {@link BzKeiriDenDataSksKyoutuu#setSkKeiriDenpyoData(HT_SkDenpyoData)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzKeiriDenDataSksKyoutuuTest_setSkKeiriDenpyoData extends AbstractTest {

    @Inject
    private BzKeiriDenDataSksKyoutuu bzKeiriDenDataSksKyoutuu;

    @Test
    @TestOrder(10)
    public void testSetSkKeiriDenpyoData_A1() {

        changeSystemDate(BizDate.valueOf("20160407"));

        HT_SkDenpyoData skDenpyoData = SWAKInjector.getInstance(HT_SkDenpyoData.class);
        skDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        skDenpyoData.setDenrenno("10000000000000000001");
        skDenpyoData.setEdano(1);
        skDenpyoData.setSyono("17806000013");
        skDenpyoData.setMosno("860000017");
        skDenpyoData.setHuridenatesakicd("001");
        skDenpyoData.setTantocd(C_TantouCdKbn.IMUSATEI);
        skDenpyoData.setDenymd(BizDate.valueOf("20160101"));
        skDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skDenpyoData.setSuitoubumoncd("1");
        skDenpyoData.setTuukasyu(C_Tuukasyu.JPY);
        skDenpyoData.setDengaikagk(BizCurrency.valueOf(1000));
        skDenpyoData.setDenkawaserate(BizNumber.valueOf(3));
        skDenpyoData.setDenyenkagk(BizCurrency.valueOf(3000));
        skDenpyoData.setSyoriYmd(BizDate.valueOf("20160119"));
        skDenpyoData.setSyoricd("0001");
        skDenpyoData.setSyorisosikicd("0000001");
        skDenpyoData.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skDenpyoData.setSeg2cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skDenpyoData.setKessantyouseikbn(C_KessantyouseiKbn.OIKOMITAISYOU);
        skDenpyoData.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skDenpyoData.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skDenpyoData.setDensyorikbn(C_DensyoriKbn.FP_HNKN);
        skDenpyoData.setAatsukaishasuitososhikicd("0000002");
        skDenpyoData.setKykymd(BizDate.valueOf("19850101"));
        skDenpyoData.setBosyuuym(BizDateYM.valueOf("198502"));
        skDenpyoData.setAatsukaishasoshikicd("0000003");
        skDenpyoData.setAatkisyadaibosyuucd("000002");
        skDenpyoData.setSyusyouhncd("0001");
        skDenpyoData.setSyouhnsdno(999);
        skDenpyoData.setSdpdkbn(C_Sdpd.GIJIPD);
        skDenpyoData.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        skDenpyoData.setHrkkeiro(C_Hrkkeiro.DANTAI);
        skDenpyoData.setSknnkaisiymd(BizDate.valueOf("20150103"));
        skDenpyoData.setMosymd(BizDate.valueOf("20150104"));
        skDenpyoData.setHnknriyuukbn(C_HenkinriyuuKbn.MOS_TORIKESI);
        skDenpyoData.setFstpryosyuymd(BizDate.valueOf("20150105"));
        skDenpyoData.setAatkisyabosyuucd("000003");
        skDenpyoData.setRyouritusdno("001");
        skDenpyoData.setKakokawaserateshiteiflg(true);
        skDenpyoData.setKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        skDenpyoData.setDengyoumucd("5650");
        skDenpyoData.setKyktuukasyu(C_Tuukasyu.JPY);
        skDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(1234567890));
        skDenpyoData.setDenkarikanjyono("12345");
        skDenpyoData.setTaisyakutyouseiflg(true);

        BizDate syoriYmd = BizDate.valueOf("20160101");
        AM_User aMUser = new AM_User();
        aMUser.setUserId("user01");
        BaseUserInfo baseUserInfo = new BaseUserInfo(aMUser);
        bzKeiriDenDataSksKyoutuu.init(syoriYmd, baseUserInfo);

        BT_DenpyoData denpyoData = bzKeiriDenDataSksKyoutuu.setSkKeiriDenpyoData(skDenpyoData);

        exClassificationEquals(denpyoData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(denpyoData.getDenrenno(), "10000000000000000001", "伝票データ連番");
        exNumericEquals(denpyoData.getEdano(), 1, "枝番号");
        exStringEquals(denpyoData.getKeirisyono(), "860000017", "経理用証券番号");
        exStringEquals(denpyoData.getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(denpyoData.getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(denpyoData.getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(denpyoData.getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(denpyoData.getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, "勘定科目コード");
        exStringEquals(denpyoData.getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(denpyoData.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(denpyoData.getDengaikagk(), BizCurrency.valueOf(1000), "伝票金額（外貨）");
        exBizCalcbleEquals(denpyoData.getDenkawaserate(), BizNumber.valueOf(3), "伝票用為替レート");
        exBizCalcbleEquals(denpyoData.getDenyenkagk(), BizCurrency.valueOf(3000), "伝票金額（円）");
        exClassificationEquals(denpyoData.getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(denpyoData.getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(denpyoData.getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(denpyoData.getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(denpyoData.getSyoricd(), "0001", "処理コード");
        exStringEquals(denpyoData.getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(denpyoData.getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(denpyoData.getSeg2cd(), C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(denpyoData.getKessantyouseikbn(), C_KessantyouseiKbn.OIKOMITAISYOU, "決算調整区分");
        exClassificationEquals(denpyoData.getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(denpyoData.getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(denpyoData.getDensyorikbn(), C_DensyoriKbn.FP_HNKN, "伝票処理区分");
        exStringEquals(denpyoData.getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(denpyoData.getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(denpyoData.getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(denpyoData.getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(denpyoData.getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(denpyoData.getSyusyouhncd(), "0001", "主契約商品コード");
        exNumericEquals(denpyoData.getSyouhnsdno(), 999, "商品世代番号");
        exClassificationEquals(denpyoData.getSdpdkbn(), C_Sdpd.GIJIPD, "Ｓ建Ｐ建区分");
        exClassificationEquals(denpyoData.getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(denpyoData.getHrkkeiro(), C_Hrkkeiro.DANTAI, "払込経路");
        exDateEquals(denpyoData.getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(denpyoData.getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(denpyoData.getHnknriyuukbn(), C_HenkinriyuuKbn.MOS_TORIKESI, "返金理由区分");
        exDateEquals(denpyoData.getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(denpyoData.getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(denpyoData.getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(denpyoData.getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(denpyoData.getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(denpyoData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(denpyoData.getKeiyakutuukagk(), BizCurrency.valueOf(1234567890), "契約通貨金額");
        exStringEquals(denpyoData.getDengyoumucd(), "5650", "伝票用業務コード");
        exClassificationEquals(denpyoData.getKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "為替適用区分");
        exStringEquals(denpyoData.getDenkarikanjyono(), "12345", "伝票用仮勘定番号");
        exBooleanEquals(denpyoData.getTaisyakutyouseiflg(), true, "貸借調整フラグ");
        exClassificationEquals(denpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.BLNK, "平準払資金移動要区分");
        exBizCalcbleEquals(denpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0), "平準払資金移動金額");
        exStringEquals(denpyoData.getGyoumuKousinsyaId(), "user01", "業務用更新者ＩＤ");
        exStringEquals(denpyoData.getGyoumuKousinTime().substring(0, 8), "20160407", "業務用更新時間");
    }

    @Test
    @TestOrder(20)
    public void testSetSkKeiriDenpyoData_A2() {

        changeSystemDate(BizDate.valueOf("20160407"));

        HT_SkDenpyoData skDenpyoData = SWAKInjector.getInstance(HT_SkDenpyoData.class);
        skDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        skDenpyoData.setDenrenno("10000000000000000001");
        skDenpyoData.setEdano(1);
        skDenpyoData.setSyono("17806000013");
        skDenpyoData.setMosno("");
        skDenpyoData.setHuridenatesakicd("001");
        skDenpyoData.setTantocd(C_TantouCdKbn.IMUSATEI);
        skDenpyoData.setDenymd(BizDate.valueOf("20160101"));
        skDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skDenpyoData.setSuitoubumoncd("1");
        skDenpyoData.setTuukasyu(C_Tuukasyu.USD);
        skDenpyoData.setDengaikagk(BizCurrency.valueOf(1000));
        skDenpyoData.setDenkawaserate(BizNumber.valueOf(3));
        skDenpyoData.setDenyenkagk(BizCurrency.valueOf(3000));
        skDenpyoData.setSyoriYmd(BizDate.valueOf("20160119"));
        skDenpyoData.setSyoricd("0001");
        skDenpyoData.setSyorisosikicd("0000001");
        skDenpyoData.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skDenpyoData.setSeg2cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skDenpyoData.setKessantyouseikbn(C_KessantyouseiKbn.OIKOMITAISYOU);
        skDenpyoData.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skDenpyoData.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skDenpyoData.setDensyorikbn(C_DensyoriKbn.FP_HNKN);
        skDenpyoData.setAatsukaishasuitososhikicd("0000002");
        skDenpyoData.setKykymd(BizDate.valueOf("19850101"));
        skDenpyoData.setBosyuuym(BizDateYM.valueOf("198502"));
        skDenpyoData.setAatsukaishasoshikicd("0000003");
        skDenpyoData.setAatkisyadaibosyuucd("000002");
        skDenpyoData.setSyusyouhncd("0001");
        skDenpyoData.setSdpdkbn(C_Sdpd.GIJIPD);
        skDenpyoData.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        skDenpyoData.setHrkkeiro(C_Hrkkeiro.DANTAI);
        skDenpyoData.setSknnkaisiymd(BizDate.valueOf("20150103"));
        skDenpyoData.setMosymd(BizDate.valueOf("20150104"));
        skDenpyoData.setHnknriyuukbn(C_HenkinriyuuKbn.MOS_TORIKESI);
        skDenpyoData.setFstpryosyuymd(BizDate.valueOf("20150105"));
        skDenpyoData.setAatkisyabosyuucd("000003");
        skDenpyoData.setRyouritusdno("001");
        skDenpyoData.setKakokawaserateshiteiflg(true);
        skDenpyoData.setKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        skDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        skDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(101));
        skDenpyoData.setDenkarikanjyono("54321");
        skDenpyoData.setTaisyakutyouseiflg(false);

        BizDate syoriYmd = BizDate.valueOf("20160101");
        AM_User aMUser = new AM_User();
        aMUser.setUserId("user01");
        BaseUserInfo baseUserInfo = new BaseUserInfo(aMUser);
        bzKeiriDenDataSksKyoutuu.init(syoriYmd, baseUserInfo);

        BT_DenpyoData denpyoData = bzKeiriDenDataSksKyoutuu.setSkKeiriDenpyoData(skDenpyoData);

        exStringEquals(denpyoData.getKeirisyono(), "17806000013", "経理用証券番号");
        exClassificationEquals(denpyoData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(denpyoData.getKeiyakutuukagk(), BizCurrency.valueOf(101), "契約通貨金額");
        exClassificationEquals(denpyoData.getKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "為替適用区分");
        exStringEquals(denpyoData.getDenkarikanjyono(), "54321", "伝票用仮勘定番号");
        exBooleanEquals(denpyoData.getTaisyakutyouseiflg(), false, "貸借調整フラグ");
        exClassificationEquals(denpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.BLNK, "平準払資金移動要区分");
        exBizCalcbleEquals(denpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0), "平準払資金移動金額");
    }
}
