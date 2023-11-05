package yuyu.common.suuri.srcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.hozen.haitou.SetDNnd;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrGetTokutejitenAnsyuKihonInfoクラスのメソッド {@link SrDRateSyutokuInfoBeanForDSyoyou#setKoumoku(TkJitenKeiyakuSyouhinKijyunBean,C_Hrkkaisuu,BizDateY)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrDRateSyutokuInfoBeanForDSyoyouTest_setKoumoku {

    @Test
    @TestOrder(10)
    public void testSetKoumoku_A1() {

        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        SrDRateSyutokuInfoBeanForDSyoyou srDRateSyutokuInfoBeanForDSyoyou =
            new SrDRateSyutokuInfoBeanForDSyoyou(setDNnd);

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = SWAKInjector
            .getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhncd("001");
        tkJitenKeiyakuSyouhinKijyunBean.setRyouritusdno("002");
        tkJitenKeiyakuSyouhinKijyunBean.setYoteiriritu(BizNumber.valueOf(1000));
        tkJitenKeiyakuSyouhinKijyunBean.setHhknsei(C_Hhknsei.MALE);
        tkJitenKeiyakuSyouhinKijyunBean.setHhknnen(49);
        tkJitenKeiyakuSyouhinKijyunBean.setHknkknsmnKbn(C_HknkknsmnKbn.SAIMANKI);
        tkJitenKeiyakuSyouhinKijyunBean.setHknkkn(12);
        tkJitenKeiyakuSyouhinKijyunBean.setHrkkkn(3);
        tkJitenKeiyakuSyouhinKijyunBean.setKyktuukasyu(C_Tuukasyu.JPY);
        tkJitenKeiyakuSyouhinKijyunBean.setDai1hknkkn(5);

        srDRateSyutokuInfoBeanForDSyoyou.setKoumoku(tkJitenKeiyakuSyouhinKijyunBean, C_Hrkkaisuu.HALFY,
            BizDateY.valueOf(2019), C_Kykjyoutai.ENTYOU);

        exStringEquals(srDRateSyutokuInfoBeanForDSyoyou.getSyouhncd(), "001", "商品コード");
        exStringEquals(srDRateSyutokuInfoBeanForDSyoyou.getRyouritusdno(), "002", "料率世代番号");
        exBizCalcbleEquals(srDRateSyutokuInfoBeanForDSyoyou.getYoteiriritu(), BizNumber.valueOf(1000), "予定利率");
        exClassificationEquals(srDRateSyutokuInfoBeanForDSyoyou.getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(srDRateSyutokuInfoBeanForDSyoyou.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(srDRateSyutokuInfoBeanForDSyoyou.getHhknnen(), 49, "被保険者年齢");
        exClassificationEquals(srDRateSyutokuInfoBeanForDSyoyou.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(srDRateSyutokuInfoBeanForDSyoyou.getHknkkn(), 12, "保険期間");
        exNumericEquals(srDRateSyutokuInfoBeanForDSyoyou.getHrkkkn(), 3, "払込期間");
        exClassificationEquals(srDRateSyutokuInfoBeanForDSyoyou.getKykjyoutai(), C_Kykjyoutai.ENTYOU, "契約状態");
        exClassificationEquals(srDRateSyutokuInfoBeanForDSyoyou.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exNumericEquals(srDRateSyutokuInfoBeanForDSyoyou.getDai1hknkkn(), 5, "第１保険期間");
        exDateYEquals(srDRateSyutokuInfoBeanForDSyoyou.getDratenendo(), BizDateY.valueOf(2019), "Ｄレート年度");
        exClassificationEquals(srDRateSyutokuInfoBeanForDSyoyou.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI,
            "内定確定区分");
    }
}