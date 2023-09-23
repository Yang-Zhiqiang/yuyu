package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金額計算（平準払個人年金）
 */
public class CalcHkKngkHijynbrKojinNk {

    @Inject
    private static Logger logger;

    private CalcHkShrKngkBean calcHkShrKngkBean;

    private BizDate calckijyunYmd;

    public CalcHkKngkHijynbrKojinNk() {
        calcHkShrKngkBean = SWAKInjector.getInstance(CalcHkShrKngkBean.class);
    }

    public CalcHkShrKngkBean getCalcHkShrKngkBean() {
        return calcHkShrKngkBean;
    }

    public BizDate getCalcKijyunYmd() {
        return calckijyunYmd;
    }

    public C_ErrorKbn exec(CalcHkShrKngkInputBean pCalcHkShrKngkInputBean) {

        logger.debug("▽ 保険金額計算（平準払個人年金） 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pCalcHkShrKngkInputBean.getKykymd() == null
            || pCalcHkShrKngkInputBean.getCalckijyunymd() == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("【保険金額計算（平準払個人年金）】の与件が正しく設定されていません。");
            logger.debug("△ 保険金額計算（平準払個人年金） 終了");

            return errorKbn;
        }

        errorKbn = execCalcHkShrKngk(pCalcHkShrKngkInputBean);

        logger.debug("△ 保険金額計算（平準払個人年金） 終了");

        return errorKbn;
    }

    private C_ErrorKbn execCalcHkShrKngk(CalcHkShrKngkInputBean pCalcHkShrKngkInputBean){

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pCalcHkShrKngkInputBean.getTuukasyu());

        BizCurrency kaiyakuhenreiknGk = BizCurrency.valueOf(0, currencyType);
        BizCurrency tmttKnGk = BizCurrency.valueOf(0, currencyType);
        BizCurrency sibousGk = BizCurrency.valueOf(0, currencyType);
        BizCurrency hokenknGk = BizCurrency.valueOf(0, currencyType);
        BizCurrency kibaraipsoutouGk = BizCurrency.valueOf(0, currencyType);
        int hrkkknNensuu = 0;

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd(pCalcHkShrKngkInputBean.getSyouhncd());
        keisanWExtBean.setSyouhnsdno(pCalcHkShrKngkInputBean.getSyouhnsdno());
        keisanWExtBean.setRyouritusdno(pCalcHkShrKngkInputBean.getRyouritusdno());
        keisanWExtBean.setYoteiriritu(pCalcHkShrKngkInputBean.getYoteiriritu());
        keisanWExtBean.setHrkkaisuu(pCalcHkShrKngkInputBean.getHrkkaisuu());
        keisanWExtBean.setHknkknsmnkbn(pCalcHkShrKngkInputBean.getHknkknsmnkbn());
        keisanWExtBean.setHknkkn(pCalcHkShrKngkInputBean.getHknkkn());
        keisanWExtBean.setHrkkkn(pCalcHkShrKngkInputBean.getHrkkkn());
        keisanWExtBean.setHrkkknsmnkbn(pCalcHkShrKngkInputBean.getHrkkknsmnKbn());
        keisanWExtBean.setHhknnen(pCalcHkShrKngkInputBean.getHhknnen());
        keisanWExtBean.setHhknsei(pCalcHkShrKngkInputBean.getHhknsei());
        keisanWExtBean.setKihons(pCalcHkShrKngkInputBean.getKihons());
        keisanWExtBean.setKykymd(pCalcHkShrKngkInputBean.getKykymd());
        keisanWExtBean.setTuukasyu(pCalcHkShrKngkInputBean.getTuukasyu());
        keisanWExtBean.setHokenryou(pCalcHkShrKngkInputBean.getHokenryou());
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(pCalcHkShrKngkInputBean.getKaiyakusjkkktyouseiriritu());
        keisanWExtBean.setKyksjkkktyouseiriritu(pCalcHkShrKngkInputBean.getKyksjkkktyouseiriritu());
        keisanWExtBean.setJkipjytym(pCalcHkShrKngkInputBean.getJkipjytYm());
        keisanWExtBean.setPtmttkngk(pCalcHkShrKngkInputBean.getPtmttKngk());
        keisanWExtBean.setKihrkmpstgk(pCalcHkShrKngkInputBean.getKihrkmPStgk());
        keisanWExtBean.setFstpryosyuymd(pCalcHkShrKngkInputBean.getFstPryosyuYmd());
        keisanWExtBean.setYoteirrthendohosyurrt(pCalcHkShrKngkInputBean.getYoteirrthendohosyuRiritu());

        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

        if (pCalcHkShrKngkInputBean.getKykymd().compareTo(pCalcHkShrKngkInputBean.getCalckijyunymd()) > 0) {
            errorKbn = keisanW.exec(pCalcHkShrKngkInputBean.getKykymd(),
                pCalcHkShrKngkInputBean.getKykymd().getBizDateYM().getNextMonth(), keisanWExtBean);
            calckijyunYmd = pCalcHkShrKngkInputBean.getKykymd();
        } else {
            errorKbn = keisanW.exec(pCalcHkShrKngkInputBean.getCalckijyunymd(),
                pCalcHkShrKngkInputBean.getCalckijyunymd().getBizDateYM().getNextMonth(), keisanWExtBean);
            calckijyunYmd = pCalcHkShrKngkInputBean.getCalckijyunymd();
        }

        if (!C_ErrorKbn.OK.eq(errorKbn)) {
            logger.debug("【契約保全共通．解約返戻金計算】でエラーが発生しました。");

            return errorKbn;
        }

        kaiyakuhenreiknGk = keisanW.getW();
        tmttKnGk = keisanW.getV();
        kibaraipsoutouGk = keisanW.getPruikei();

        if (C_HrkkknsmnKbn.SAIMANKI.eq(pCalcHkShrKngkInputBean.getHrkkknsmnKbn())) {
            hrkkknNensuu = pCalcHkShrKngkInputBean.getHrkkkn() - pCalcHkShrKngkInputBean.getHhknnen();
        } else {
            hrkkknNensuu = pCalcHkShrKngkInputBean.getHrkkkn();
        }

        if (BizDateUtil.compareYmd(pCalcHkShrKngkInputBean.getCalckijyunymd(), pCalcHkShrKngkInputBean.getKykymd()
            .addYears(hrkkknNensuu)) == BizDateUtil.COMPARE_LESSER) {
            sibousGk = kibaraipsoutouGk;
        } else {
            if (kibaraipsoutouGk.compareTo(tmttKnGk) < 0) {
                sibousGk = tmttKnGk;
            } else {
                sibousGk = kibaraipsoutouGk;
            }
        }

        hokenknGk = sibousGk;

        calcHkShrKngkBean.setKihons(pCalcHkShrKngkInputBean.getKihons());
        calcHkShrKngkBean.setKaiyakuhenreiknGk(kaiyakuhenreiknGk);
        calcHkShrKngkBean.setTmttKnGk(tmttKnGk);
        calcHkShrKngkBean.setHokenryoustGk(kibaraipsoutouGk);
        calcHkShrKngkBean.setSibousGk(sibousGk);
        calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(0, currencyType));
        calcHkShrKngkBean.setHokenknGk(hokenknGk);
        calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.BLNK);

        return errorKbn;
    }

}
