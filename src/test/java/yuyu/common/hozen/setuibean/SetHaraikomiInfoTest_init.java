package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 払込情報設定クラスのメソッド {@link SetHaraikomiInfo#init(SetHaraikomiInfoExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHaraikomiInfoTest_init {

    private SetHaraikomiInfoExecUiBeanParamImpl setHaraikomiInfoExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        setHaraikomiInfo.init(setHaraikomiInfoExecUiBeanParamImpl);

        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkifstphrkkeirokbn(), C_FstphrkkeiroKbn.BLNK, "（払込情報）初回保険料払込経路区分");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkkaisuu(), C_Hrkkaisuu.BLNK, "（払込情報）払込回数");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkkeiro(), C_Hrkkeiro.BLNK, "（払込情報）払込経路");
        exDateYMEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkijkipjytym(), null, "（払込情報）次回Ｐ充当年月");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkp(), BizCurrency.optional(), "（払込情報）払込保険料");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkikihrkp(), BizCurrency.optional(), "（払込情報）既払込保険料");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getNextkosumu(), C_UmuKbn.NONE, "次回更新有無");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkinextkosgohrkp(), BizCurrency.optional(), "（払込情報）契約管理次回更新後払込保険料");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfobankcd(), "", "（払込情報）払込情報銀行コード");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfobanknmkj(), "", "（払込情報）払込情報銀行名（漢字）");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfositencd(), "", "（払込情報）払込情報支店コード");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfositennmkj(), "", "（払込情報）払込情報支店名（漢字）");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfoyokinkbn(), C_YokinKbn.BLNK, "（払込情報）払込情報預金種目区分");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfokouzano(), "", "（払込情報）払込情報口座番号");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfokzmeiginmkn(), "", "（払込情報）払込情報口座名義人氏名（カナ）");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfosinkeizkkbn(), C_SinkeizkKbn.BLNK, "（払込情報）払込情報新規継続区分");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiyenkansannyknkingk(),  BizCurrency.optional(), "（払込情報）円換算入金額");
        exDateEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiyentkykwsrateymd(), null, "（払込情報）円換算適用為替レート基準日");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiyentkykwsrate(), null, "（払込情報）円換算適用為替レート");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiitijibrp(), BizCurrency.optional(), "（払込情報）一時払保険料");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getYennykntkhkumu(), C_UmuKbn.NONE, "円入金特約付加有無");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkitikiktbrijk(), C_TkiktbrisyuruiKbn.BLNK, "（払込情報）定期一括払状況");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkikykjyoutai(), C_Kykjyoutai.BLNK, "（払込情報）契約状態");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizenkizennouumu(), C_UmuKbn.NONE, "（払込情報）全期前納有無");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfotuutyoukigou(), "", "（払込情報）払込情報郵貯通帳記号");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkikzdoukbn(), C_KzkykdouKbn.BLNK, "（払込情報）口座名義人同一区分");
        exDateYMEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennoustartym(), null, "（払込情報）前納開始年月");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennounyuukingk(), BizCurrency.optional(), "（払込情報）前納入金額");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennoukkn(), "", "（払込情報）前納期間");
        exDateEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennounyuukinymd(), null, "（払込情報）前納入金年月日");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkicreditkessaiyouno(), "", "（払込情報）クレジットカード決済用番号");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkidispcreditkessaiyouno(), "", "（払込情報）表示用クレジットカード決済用番号");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkicredityuukoukakkekka(), C_Yuukoukakkekka.BLNK, "（払込情報）クレジットカード有効確認結果");
        exDateYMEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkicredityuukoukakym(), null, "（払込情報）クレジットカード有効確認年月");
    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        setHaraikomiInfoExecUiBeanParamImpl.setVhrkifstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkihrkkaisuu(C_Hrkkaisuu.TUKI);
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkihrkkeiro(C_Hrkkeiro.KOUHURI);
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkijkipjytym(BizDateYM.valueOf("201512"));
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkihrkp(BizCurrency.valueOf(1110000000));
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkikihrkp(BizCurrency.valueOf(1100000000));
        setHaraikomiInfoExecUiBeanParamImpl.setNextkosumu(C_UmuKbn.ARI);
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkinextkosgohrkp(BizCurrency.valueOf(1010000000));
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkihrkinfobankcd("1234");
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkihrkinfobanknmkj("銀行");
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkihrkinfositencd("123");
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkihrkinfositennmkj("支店");
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkihrkinfoyokinkbn(C_YokinKbn.HUTUU);
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkihrkinfokouzano("123456");
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkihrkinfokzmeiginmkn("カナ");
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkihrkinfosinkeizkkbn(C_SinkeizkKbn.SHINKI);
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkiyenkansannyknkingk(BizCurrency.valueOf(101100000));
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkiyentkykwsrateymd(BizDate.valueOf("20151223"));
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkiyentkykwsrate(BizNumber.valueOf(12345678));
        setHaraikomiInfoExecUiBeanParamImpl.setKyktuukasyu(C_Tuukasyu.JPY);
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkitikiktbrijk(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkikykjyoutai(C_Kykjyoutai.HRKMTYUU);
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkizenkizennouumu(C_UmuKbn.ARI);
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkihrkinfotuutyoukigou("9999");
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkikzdoukbn(C_KzkykdouKbn.DOUITU);
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkizennoustartym(BizDateYM.valueOf(201802));
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkizennounyuukingk(BizCurrency.valueOf(20000));
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkizennoukkn("10");
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkizennounyuukinymd(BizDate.valueOf(20180601));
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkicreditkessaiyouno("22345678912345678912345678");
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkidispcreditkessaiyouno("22345678912345678987654321");
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkicredityuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        setHaraikomiInfoExecUiBeanParamImpl.setVhrkicredityuukoukakym(BizDateYM.valueOf(201910));

        setHaraikomiInfo.init(setHaraikomiInfoExecUiBeanParamImpl);

        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkifstphrkkeirokbn(), C_FstphrkkeiroKbn.BLNK, "（払込情報）初回保険料払込経路区分");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkkaisuu(), C_Hrkkaisuu.BLNK, "（払込情報）払込回数");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkkeiro(), C_Hrkkeiro.BLNK, "（払込情報）払込経路");
        exDateYMEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkijkipjytym(), null, "（払込情報）次回Ｐ充当年月");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkp(), BizCurrency.optional(), "（払込情報）払込保険料");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkikihrkp(), BizCurrency.optional(), "（払込情報）既払込保険料");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getNextkosumu(), C_UmuKbn.NONE, "次回更新有無");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkinextkosgohrkp(), BizCurrency.optional(), "（払込情報）契約管理次回更新後払込保険料");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfobankcd(), "", "（払込情報）払込情報銀行コード");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfobanknmkj(), "", "（払込情報）払込情報銀行名（漢字）");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfositencd(), "", "（払込情報）払込情報支店コード");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfositennmkj(), "", "（払込情報）払込情報支店名（漢字）");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfoyokinkbn(), C_YokinKbn.BLNK, "（払込情報）払込情報預金種目区分");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfokouzano(), "", "（払込情報）払込情報口座番号");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfokzmeiginmkn(), "", "（払込情報）払込情報口座名義人氏名（カナ）");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfosinkeizkkbn(), C_SinkeizkKbn.BLNK, "（払込情報）払込情報新規継続区分");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiyenkansannyknkingk(),  BizCurrency.optional(), "（払込情報）円換算入金額");
        exDateEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiyentkykwsrateymd(), null, "（払込情報）円換算適用為替レート基準日");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiyentkykwsrate(), null, "（払込情報）円換算適用為替レート");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiitijibrp(), BizCurrency.optional(), "（払込情報）一時払保険料");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getYennykntkhkumu(), C_UmuKbn.NONE, "円入金特約付加有無");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkitikiktbrijk(), C_TkiktbrisyuruiKbn.BLNK, "（払込情報）定期一括払状況");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkikykjyoutai(), C_Kykjyoutai.BLNK, "（払込情報）契約状態");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizenkizennouumu(), C_UmuKbn.NONE, "（払込情報）全期前納有無");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfotuutyoukigou(), "", "（払込情報）払込情報郵貯通帳記号");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkikzdoukbn(), C_KzkykdouKbn.BLNK, "（払込情報）口座名義人同一区分");
        exDateYMEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennoustartym(), null, "（払込情報）前納開始年月");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennounyuukingk(), BizCurrency.optional(), "（払込情報）前納入金額");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennoukkn(), "", "（払込情報）前納期間");
        exDateEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennounyuukinymd(), null, "（払込情報）前納入金年月日");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkicreditkessaiyouno(), "", "（払込情報）クレジットカード決済用番号");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkidispcreditkessaiyouno(), "", "（払込情報）表示用クレジットカード決済用番号");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkicredityuukoukakkekka(), C_Yuukoukakkekka.BLNK, "（払込情報）クレジットカード有効確認結果");
        exDateYMEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkicredityuukoukakym(), null, "（払込情報）クレジットカード有効確認年月");

        MockObjectManager.initialize();

    }
}
