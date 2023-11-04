package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.DenpyouDataParam;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
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
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 経理伝票データ作成共通処理クラスのメソッド {@link BzKeiriDenDataSksKyoutuu#setKeiriDenpyoData(DenpyouDataParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzKeiriDenDataSksKyoutuuTest_setKeiriDenpyoData extends AbstractTest {

    @Inject
    private BzKeiriDenDataSksKyoutuu bzKeiriDenDataSksKyoutuu;

    @Test
    @TestOrder(10)
    public void testSetKeiriDenpyoData_A1() {

        changeSystemDate(BizDate.valueOf("20160407"));
        DenpyouDataParam denpyouDataParam = SWAKInjector.getInstance(DenpyouDataParamImpl.class);
        denpyouDataParam.setDensyskbn(C_DensysKbn.SKEI);
        denpyouDataParam.setDenrenno("20000000000000000002");
        denpyouDataParam.setEdano(2);
        denpyouDataParam.setSyono("11807111222");
        denpyouDataParam.setHuridenatesakicd("002");
        denpyouDataParam.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        denpyouDataParam.setDenymd(BizDate.valueOf("20160102"));
        denpyouDataParam.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        denpyouDataParam.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        denpyouDataParam.setSuitoubumoncd("1");
        denpyouDataParam.setTuukasyu(C_Tuukasyu.JPY);
        denpyouDataParam.setDengaikagk(BizCurrency.valueOf(1000));
        denpyouDataParam.setDenkawaserate(BizNumber.valueOf(3));
        denpyouDataParam.setDenyenkagk(BizCurrency.valueOf(3000));
        denpyouDataParam.setHuridenskskbn(C_HuridensksKbn.GYOUMUIGAI);
        denpyouDataParam.setDenhnknhoukbn(C_DenhnknhouKbn.KOUZAHURIKOMI);
        denpyouDataParam.setDenshrhoukbn(C_DenshrhouKbn.FBSOUKIN);
        denpyouDataParam.setSyoriYmd(BizDate.valueOf("20150202"));
        denpyouDataParam.setSyoricd("0002");
        denpyouDataParam.setSyorisosikicd("0000002");
        denpyouDataParam.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        denpyouDataParam.setSeg2cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        denpyouDataParam.setSyusyouhncd("0001");
        denpyouDataParam.setSyouhnsdno(999);
        denpyouDataParam.setKakokawaserateshiteiflg(true);
        denpyouDataParam.setKakokawaserateshiteiymd(BizDate.valueOf("19861203"));
        denpyouDataParam.setKyktuukasyu(C_Tuukasyu.USD);
        denpyouDataParam.setKeiyakutuukagk(BizCurrency.valueOf(987654321));
        denpyouDataParam.setDengyoumucd("5650");
        denpyouDataParam.setDenkarikanjyono("12345");
        denpyouDataParam.setTaisyakutyouseiflg(true);
        denpyouDataParam.setDensyorisyousaikbn(C_DenSyorisyousaiKbn.KZHURIKAE_SIS);

        BizDate syoriYmd = BizDate.valueOf("20160101");
        AM_User aMUser = new AM_User();
        aMUser.setUserId("user01");
        BaseUserInfo baseUserInfo = new BaseUserInfo(aMUser);
        bzKeiriDenDataSksKyoutuu.init(syoriYmd, baseUserInfo);

        BT_DenpyoData denpyoData = bzKeiriDenDataSksKyoutuu.setKeiriDenpyoData(denpyouDataParam);

        exClassificationEquals(denpyoData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(denpyoData.getDenrenno(), "20000000000000000002", "伝票データ連番");
        exNumericEquals(denpyoData.getEdano(), 2, "枝番号");
        exStringEquals(denpyoData.getKeirisyono(), "11807111222", "経理用証券番号");
        exStringEquals(denpyoData.getHuridenatesakicd(), "002", "振替伝票宛先部課コード");
        exClassificationEquals(denpyoData.getTantocd(), C_TantouCdKbn.KIKAKUIMU, "担当コード");
        exDateEquals(denpyoData.getDenymd(), BizDate.valueOf("20160102"), "伝票日付");
        exClassificationEquals(denpyoData.getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(denpyoData.getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, "勘定科目コード");
        exStringEquals(denpyoData.getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(denpyoData.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(denpyoData.getDengaikagk(), BizCurrency.valueOf(1000), "伝票金額（外貨）");
        exBizCalcbleEquals(denpyoData.getDenkawaserate(), BizNumber.valueOf(3), "伝票用為替レート");
        exBizCalcbleEquals(denpyoData.getDenyenkagk(), BizCurrency.valueOf(3000), "伝票金額（円）");
        exClassificationEquals(denpyoData.getHuridenskskbn(), C_HuridensksKbn.GYOUMUIGAI, "振替伝票作成区分");
        exClassificationEquals(denpyoData.getDenhnknhoukbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "伝票用返金方法区分");
        exClassificationEquals(denpyoData.getDenshrhoukbn(), C_DenshrhouKbn.FBSOUKIN, "伝票用支払方法区分");
        exDateEquals(denpyoData.getSyoriYmd(), BizDate.valueOf("20150202"), "処理年月日");
        exStringEquals(denpyoData.getSyoricd(), "0002", "処理コード");
        exStringEquals(denpyoData.getSyorisosikicd(), "0000002", "処理組織コード");
        exClassificationEquals(denpyoData.getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(denpyoData.getSeg2cd(), C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(denpyoData.getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(denpyoData.getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(denpyoData.getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(denpyoData.getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(denpyoData.getAatsukaishasuitososhikicd(), "", "Ａ扱者出納組織コード");
        exDateEquals(denpyoData.getKykymd(), null, "契約日");
        exDateYMEquals(denpyoData.getBosyuuym(), null, "募集年月");
        exStringEquals(denpyoData.getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(denpyoData.getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(denpyoData.getSyusyouhncd(), "0001", "主契約商品コード");
        exNumericEquals(denpyoData.getSyouhnsdno(), 999, "商品世代番号");
        exClassificationEquals(denpyoData.getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(denpyoData.getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(denpyoData.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(denpyoData.getSknnkaisiymd(), null, "責任開始日");
        exDateEquals(denpyoData.getMosymd(), null, "申込日");
        exClassificationEquals(denpyoData.getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(denpyoData.getFstpryosyuymd(), null, "初回Ｐ領収日");
        exStringEquals(denpyoData.getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(denpyoData.getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(denpyoData.getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(denpyoData.getKakokawaserateshiteiymd(), BizDate.valueOf("19861203"), "過去為替レート指定年月日");
        exClassificationEquals(denpyoData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(denpyoData.getKeiyakutuukagk(), BizCurrency.valueOf(987654321), "契約通貨金額");
        exStringEquals(denpyoData.getDengyoumucd(), "5650", "伝票用業務コード");
        exClassificationEquals(denpyoData.getKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "為替適用区分");
        exStringEquals(denpyoData.getDenkarikanjyono(), "12345", "伝票用仮勘定番号");
        exBooleanEquals(denpyoData.getTaisyakutyouseiflg(), true, "貸借調整フラグ");
        exClassificationEquals(denpyoData.getDensyorisyousaikbn(),C_DenSyorisyousaiKbn.KZHURIKAE_SIS,"伝票用処理詳細区分");
        exClassificationEquals(denpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.BLNK, "平準払資金移動要区分");
        exBizCalcbleEquals(denpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0), "平準払資金移動金額");
        exStringEquals(denpyoData.getGyoumuKousinsyaId(), "user01", "業務用更新者ＩＤ");
        exStringEquals(denpyoData.getGyoumuKousinTime().substring(0, 8), "20160407", "業務用更新時間");
    }

    @Test
    @TestOrder(20)
    public void testSetKeiriDenpyoData_A2() {

        changeSystemDate(BizDate.valueOf("20160407"));
        DenpyouDataParam denpyouDataParam = SWAKInjector.getInstance(DenpyouDataParamImpl.class);
        denpyouDataParam.setDensyskbn(C_DensysKbn.SKEI);
        denpyouDataParam.setDenrenno("20000000000000000002");
        denpyouDataParam.setEdano(2);
        denpyouDataParam.setSyono("11807111233");
        denpyouDataParam.setHuridenatesakicd("002");
        denpyouDataParam.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        denpyouDataParam.setDenymd(BizDate.valueOf("20160102"));
        denpyouDataParam.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        denpyouDataParam.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        denpyouDataParam.setSuitoubumoncd("1");
        denpyouDataParam.setTuukasyu(C_Tuukasyu.USD);
        denpyouDataParam.setDengaikagk(BizCurrency.valueOf(1000));
        denpyouDataParam.setDenkawaserate(BizNumber.valueOf(3));
        denpyouDataParam.setDenyenkagk(BizCurrency.valueOf(3000));
        denpyouDataParam.setHuridenskskbn(C_HuridensksKbn.GYOUMUIGAI);
        denpyouDataParam.setDenhnknhoukbn(C_DenhnknhouKbn.KOUZAHURIKOMI);
        denpyouDataParam.setDenshrhoukbn(C_DenshrhouKbn.FBSOUKIN);
        denpyouDataParam.setSyoriYmd(BizDate.valueOf("20150202"));
        denpyouDataParam.setSyoricd("0002");
        denpyouDataParam.setSyorisosikicd("0000002");
        denpyouDataParam.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        denpyouDataParam.setSeg2cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        denpyouDataParam.setSyusyouhncd("0001");
        denpyouDataParam.setSyouhnsdno(999);
        denpyouDataParam.setKakokawaserateshiteiflg(true);
        denpyouDataParam.setKakokawaserateshiteiymd(BizDate.valueOf("19861203"));
        denpyouDataParam.setKyktuukasyu(C_Tuukasyu.USD);
        denpyouDataParam.setKeiyakutuukagk(BizCurrency.valueOf(987654321));
        denpyouDataParam.setDengyoumucd("5650");
        denpyouDataParam.setDenkarikanjyono("54321");
        denpyouDataParam.setTaisyakutyouseiflg(false);
        denpyouDataParam.setDensyorisyousaikbn(C_DenSyorisyousaiKbn.NET_KOUHURI_CSS);
        denpyouDataParam.setKawasetekiyokbn(C_KawasetekiyoKbn.BLNK);

        BizDate syoriYmd = BizDate.valueOf("20160101");
        AM_User aMUser = new AM_User();
        aMUser.setUserId("user01");
        BaseUserInfo baseUserInfo = new BaseUserInfo(aMUser);
        bzKeiriDenDataSksKyoutuu.init(syoriYmd, baseUserInfo);

        BT_DenpyoData denpyoData = bzKeiriDenDataSksKyoutuu.setKeiriDenpyoData(denpyouDataParam);

        exStringEquals(denpyoData.getKeirisyono(), "11807111233", "経理用証券番号");
        exClassificationEquals(denpyoData.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exClassificationEquals(denpyoData.getKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "為替適用区分");
        exStringEquals(denpyoData.getDenkarikanjyono(), "54321", "伝票用仮勘定番号");
        exBooleanEquals(denpyoData.getTaisyakutyouseiflg(), false, "貸借調整フラグ");
        exClassificationEquals(denpyoData.getDensyorisyousaikbn(),C_DenSyorisyousaiKbn.NET_KOUHURI_CSS,"伝票用処理詳細区分");
        exClassificationEquals(denpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.BLNK, "平準払資金移動要区分");
        exBizCalcbleEquals(denpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0), "平準払資金移動金額");
    }

    @Test
    @TestOrder(30)
    public void testSetKeiriDenpyoData_A3() {

        changeSystemDate(BizDate.valueOf("20160407"));
        DenpyouDataParam denpyouDataParam = SWAKInjector.getInstance(DenpyouDataParamImpl.class);
        denpyouDataParam.setDensyskbn(C_DensysKbn.SKEI);
        denpyouDataParam.setDenrenno("20000000000000000002");
        denpyouDataParam.setEdano(2);
        denpyouDataParam.setSyono("11807111244");
        denpyouDataParam.setHuridenatesakicd("002");
        denpyouDataParam.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        denpyouDataParam.setDenymd(BizDate.valueOf("20160102"));
        denpyouDataParam.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        denpyouDataParam.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        denpyouDataParam.setSuitoubumoncd("1");
        denpyouDataParam.setTuukasyu(C_Tuukasyu.USD);
        denpyouDataParam.setDengaikagk(BizCurrency.valueOf(1000));
        denpyouDataParam.setDenkawaserate(BizNumber.valueOf(3));
        denpyouDataParam.setDenyenkagk(BizCurrency.valueOf(3000));
        denpyouDataParam.setHuridenskskbn(C_HuridensksKbn.GYOUMUIGAI);
        denpyouDataParam.setDenhnknhoukbn(C_DenhnknhouKbn.KOUZAHURIKOMI);
        denpyouDataParam.setDenshrhoukbn(C_DenshrhouKbn.FBSOUKIN);
        denpyouDataParam.setSyoriYmd(BizDate.valueOf("20150202"));
        denpyouDataParam.setSyoricd("0002");
        denpyouDataParam.setSyorisosikicd("0000002");
        denpyouDataParam.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        denpyouDataParam.setSeg2cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        denpyouDataParam.setSyusyouhncd("0001");
        denpyouDataParam.setSyouhnsdno(999);
        denpyouDataParam.setKakokawaserateshiteiflg(true);
        denpyouDataParam.setKakokawaserateshiteiymd(BizDate.valueOf("19861203"));
        denpyouDataParam.setKyktuukasyu(C_Tuukasyu.USD);
        denpyouDataParam.setKeiyakutuukagk(BizCurrency.valueOf(987654321));
        denpyouDataParam.setDengyoumucd("5650");
        denpyouDataParam.setDenkarikanjyono("12345");
        denpyouDataParam.setTaisyakutyouseiflg(true);
        denpyouDataParam.setDensyorisyousaikbn(C_DenSyorisyousaiKbn.CREDIT);
        denpyouDataParam.setKawasetekiyokbn(C_KawasetekiyoKbn.TTB);

        BizDate syoriYmd = BizDate.valueOf("20160101");
        AM_User aMUser = new AM_User();
        aMUser.setUserId("user01");
        BaseUserInfo baseUserInfo = new BaseUserInfo(aMUser);
        bzKeiriDenDataSksKyoutuu.init(syoriYmd, baseUserInfo);

        BT_DenpyoData denpyoData = bzKeiriDenDataSksKyoutuu.setKeiriDenpyoData(denpyouDataParam);

        exStringEquals(denpyoData.getKeirisyono(), "11807111244", "経理用証券番号");
        exClassificationEquals(denpyoData.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exClassificationEquals(denpyoData.getKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "為替適用区分");
        exStringEquals(denpyoData.getDenkarikanjyono(), "12345", "伝票用仮勘定番号");
        exBooleanEquals(denpyoData.getTaisyakutyouseiflg(), true, "貸借調整フラグ");
        exClassificationEquals(denpyoData.getDensyorisyousaikbn(),C_DenSyorisyousaiKbn.CREDIT,"伝票用処理詳細区分");
        exClassificationEquals(denpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.BLNK, "平準払資金移動要区分");
        exBizCalcbleEquals(denpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0), "平準払資金移動金額");
    }
}
