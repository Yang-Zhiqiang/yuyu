package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 解約返戻金計算拡張Beanのメソッド {@link KeisanWExtBean#Getter・Setter} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanWExtBean_Test {

    @Test
    @TestOrder(10)
    public void testGetter_A1() {

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();

        exStringEquals(keisanWExtBean.getSyouhncd(), null, "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), null, "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.ZERO, "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 0, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 0, "払込期間");
        exClassificationEquals(keisanWExtBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHhknnen(), 0, "被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.BLNK, "被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exDateEquals(keisanWExtBean.getKykymd(), null, "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.ZERO, "契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExtBean.getKaiyakusjkkktyouseiriritu(), BizNumber.ZERO, "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExtBean.getTmttkntaisyouym(), null, "積立金対象年月");
        exBizCalcbleEquals(keisanWExtBean.getTeiritutmttkngk(), BizCurrency.valueOf(0), "定率積立金額");
        exBizCalcbleEquals(keisanWExtBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(0), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExtBean.getTmttknhaneisisuu(), BizNumber.ZERO, "積立金反映時指数");
        exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.ZERO, "積立利率");
        exDateYMEquals(keisanWExtBean.getJkipjytym(), null, "次回Ｐ充当年月");
        exBizCalcbleEquals(keisanWExtBean.getPtmttkngk(), BizCurrency.valueOf(0), "保険料積立金額");
        exBizCalcbleEquals(keisanWExtBean.getKihrkmpstgk(), BizCurrency.valueOf(0), "既払込保険料相当額");
        exDateEquals(keisanWExtBean.getFstpryosyuymd(), null, "初回保険料領収日");
        exBizCalcbleEquals(keisanWExtBean.getYoteirrthendohosyurrt(), BizNumber.ZERO, "予定利率変動時保証利率");
        exClassificationEquals(keisanWExtBean.getSisansyuruikbn(), C_KhSisanSyuruiKbn.JISSEKI, "（試算用）計算種類");
        exBizCalcbleEquals(keisanWExtBean.getSisanyoteiriritu(), BizNumber.ZERO, "（試算用）予定利率");
        exBizCalcbleEquals(keisanWExtBean.getSisankawaserate(), BizNumber.ZERO, "（試算用）為替レート");
        exDateEquals(keisanWExtBean.getSisansyoriymd(), null, "（試算用）処理日");
        exDateEquals(keisanWExtBean.getYendthnkymd(), null, "円建変更日");
        exClassificationEquals(keisanWExtBean.getTeikishrtkykhukaumu(), C_UmuKbn.NONE, "定期支払特約付加有無");
        exNumericEquals(keisanWExtBean.getDai1hknkkn(), 0, "第１保険期間");
        exClassificationEquals(keisanWExtBean.getKykJyoutai(), C_Kykjyoutai.BLNK, "契約状態");

    }

    @Test
    @TestOrder(20)
    public void testGetter_A2() {

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("A001");
        keisanWExtBean.setSyouhnsdno(10);
        keisanWExtBean.setRyouritusdno("A002");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(11));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(13);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHhknnen(14);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(15));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(16));
        keisanWExtBean.setKykymd(BizDate.valueOf(20170505));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(17));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(18));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201802));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(19));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(20));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(12345.1234));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(21));
        keisanWExtBean.setJkipjytym(BizDateYM.valueOf(201810));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(22));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(23));
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20180506));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(24));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.SISAN);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(25));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(26));
        keisanWExtBean.setSisansyoriymd(BizDate.valueOf(20180607));
        keisanWExtBean.setYendthnkymd(BizDate.valueOf(20200515));
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.ARI);
        keisanWExtBean.setDai1hknkkn(99);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        exStringEquals(keisanWExtBean.getSyouhncd(), "A001", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 10, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "A002", "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(11), "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 13, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 12, "払込期間");
        exClassificationEquals(keisanWExtBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHhknnen(), 14, "被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(15), "基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(16), "保険料");
        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf(20170505), "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(17), "契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExtBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(18), "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExtBean.getTmttkntaisyouym(), BizDateYM.valueOf(201802), "積立金対象年月");
        exBizCalcbleEquals(keisanWExtBean.getTeiritutmttkngk(), BizCurrency.valueOf(19), "定率積立金額");
        exBizCalcbleEquals(keisanWExtBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(20), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExtBean.getTmttknhaneisisuu(), BizNumber.valueOf(12345.1234), "積立金反映時指数");
        exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.valueOf(21), "積立利率");
        exDateYMEquals(keisanWExtBean.getJkipjytym(), BizDateYM.valueOf(201810), "次回Ｐ充当年月");
        exBizCalcbleEquals(keisanWExtBean.getPtmttkngk(), BizCurrency.valueOf(22), "保険料積立金額");
        exBizCalcbleEquals(keisanWExtBean.getKihrkmpstgk(), BizCurrency.valueOf(23), "既払込保険料相当額");
        exDateEquals(keisanWExtBean.getFstpryosyuymd(), BizDate.valueOf(20180506), "初回保険料領収日");
        exBizCalcbleEquals(keisanWExtBean.getYoteirrthendohosyurrt(), BizNumber.valueOf(24), "予定利率変動時保証利率");
        exClassificationEquals(keisanWExtBean.getSisansyuruikbn(), C_KhSisanSyuruiKbn.SISAN, "（試算用）計算種類");
        exBizCalcbleEquals(keisanWExtBean.getSisanyoteiriritu(), BizNumber.valueOf(25), "（試算用）予定利率");
        exBizCalcbleEquals(keisanWExtBean.getSisankawaserate(), BizNumber.valueOf(26), "（試算用）為替レート");
        exDateEquals(keisanWExtBean.getSisansyoriymd(), BizDate.valueOf(20180607), "（試算用）処理日");
        exDateEquals(keisanWExtBean.getYendthnkymd(), BizDate.valueOf(20200515), "円建変更日");
        exClassificationEquals(keisanWExtBean.getTeikishrtkykhukaumu(), C_UmuKbn.ARI, "定期支払特約付加有無");
        exNumericEquals(keisanWExtBean.getDai1hknkkn(), 99, "第１保険期間");
        exClassificationEquals(keisanWExtBean.getKykJyoutai(), C_Kykjyoutai.ITIJIBARAI, "契約状態");

    }

}
