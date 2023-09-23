package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金額計算（一時払個人年金）
 */
public class CalcHkShrKngkItijibrKojinNk {

    @Inject
    private static Logger logger;

    private CalcHkShrKngkBean calcHkShrKngkBean;

    public CalcHkShrKngkItijibrKojinNk() {
        calcHkShrKngkBean = SWAKInjector.getInstance(CalcHkShrKngkBean.class);
    }

    public CalcHkShrKngkBean getCalcHkShrKngkBean() {
        return calcHkShrKngkBean;
    }

    public C_ErrorKbn exec(CalcHkShrKngkInputBean pCalcHkShrKngkInputBean) {

        logger.debug("▽ 保険金額計算（一時払個人年金） 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pCalcHkShrKngkInputBean.getKykymd() == null
            || pCalcHkShrKngkInputBean.getCalckijyunymd() == null
            || (pCalcHkShrKngkInputBean.getKihons() == null || pCalcHkShrKngkInputBean.getKihons().isOptional())
            || (pCalcHkShrKngkInputBean.getHokenryou() == null || pCalcHkShrKngkInputBean.getHokenryou().isOptional())) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("【保険金額計算（一時払個人年金）】の与件が正しく設定されていません。");
            logger.debug("△ 保険金額計算（一時払個人年金） 終了");

            return errorKbn;
        }

        errorKbn = execCalcHkShrKngk(pCalcHkShrKngkInputBean);

        logger.debug("△ 保険金額計算（一時払個人年金） 終了");

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
        BizCurrency teirituTmttkngk = BizCurrency.valueOf(0, currencyType);
        BizCurrency sisuurendouTmttkngk = BizCurrency.valueOf(0, currencyType);

        if (pCalcHkShrKngkInputBean.getKykymd().compareTo(pCalcHkShrKngkInputBean.getCalckijyunymd()) > 0) {
            sibousGk = pCalcHkShrKngkInputBean.getHokenryou();
        } else {
            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
            BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(pCalcHkShrKngkInputBean.getKykymd(),
                pCalcHkShrKngkInputBean.getCalckijyunymd(), null, pCalcHkShrKngkInputBean.getHrkkaisuu(),
                pCalcHkShrKngkInputBean.getKykJyoutai(), pCalcHkShrKngkInputBean.getSyouhncd(),
                pCalcHkShrKngkInputBean.getYendthnkYmd());

            KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

            keisanWExtBean.setSyouhncd(pCalcHkShrKngkInputBean.getSyouhncd());
            keisanWExtBean.setSyouhnsdno(pCalcHkShrKngkInputBean.getSyouhnsdno());
            keisanWExtBean.setRyouritusdno(pCalcHkShrKngkInputBean.getRyouritusdno());
            keisanWExtBean.setYoteiriritu(pCalcHkShrKngkInputBean.getYoteiriritu());
            keisanWExtBean.setHrkkaisuu(pCalcHkShrKngkInputBean.getHrkkaisuu());
            keisanWExtBean.setHknkknsmnkbn(pCalcHkShrKngkInputBean.getHknkknsmnkbn());
            keisanWExtBean.setHknkkn(pCalcHkShrKngkInputBean.getHknkkn());
            keisanWExtBean.setHrkkkn(pCalcHkShrKngkInputBean.getHrkkkn());
            keisanWExtBean.setHhknnen(pCalcHkShrKngkInputBean.getHhknnen());
            keisanWExtBean.setHhknsei(pCalcHkShrKngkInputBean.getHhknsei());
            keisanWExtBean.setKihons(pCalcHkShrKngkInputBean.getKihons());
            keisanWExtBean.setHokenryou(pCalcHkShrKngkInputBean.getHokenryou());
            keisanWExtBean.setKykymd(pCalcHkShrKngkInputBean.getKykymd());
            keisanWExtBean.setTuukasyu(pCalcHkShrKngkInputBean.getTuukasyu());
            keisanWExtBean.setKaiyakusjkkktyouseiriritu(pCalcHkShrKngkInputBean.getKaiyakusjkkktyouseiriritu());
            keisanWExtBean.setKyksjkkktyouseiriritu(pCalcHkShrKngkInputBean.getKyksjkkktyouseiriritu());
            keisanWExtBean.setTmttkntaisyouym(pCalcHkShrKngkInputBean.getTmttkntaisyouym());
            keisanWExtBean.setTeiritutmttkngk(pCalcHkShrKngkInputBean.getTeiritutmttkngk());
            keisanWExtBean.setSisuurendoutmttkngk(pCalcHkShrKngkInputBean.getSisuurendoutmttkngk());
            keisanWExtBean.setTumitateriritu(pCalcHkShrKngkInputBean.getTumitateriritu());
            keisanWExtBean.setYendthnkymd(pCalcHkShrKngkInputBean.getYendthnkYmd());

            KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

            errorKbn = keisanW.exec(pCalcHkShrKngkInputBean.getCalckijyunymd(), kaiyakuhrKisnKijyunYM, keisanWExtBean);

            if (!C_ErrorKbn.OK.eq(errorKbn)) {
                logger.debug("【契約保全共通．解約返戻金計算】でエラーが発生しました。");

                return errorKbn;
            }

            kaiyakuhenreiknGk = keisanW.getW();
            tmttKnGk = keisanW.getV();
            teirituTmttkngk = keisanW.getTeirituTmttkngk();
            sisuurendouTmttkngk = keisanW.getSisuurendouTmttkngk();

            if (C_Tuukasyu.JPY.eq(pCalcHkShrKngkInputBean.getTuukasyu())) {
                sibousGk = tmttKnGk;
            } else {
                if (tmttKnGk.compareTo(kaiyakuhenreiknGk) > 0) {
                    sibousGk = tmttKnGk;
                } else {
                    sibousGk = kaiyakuhenreiknGk;
                }
            }
        }

        hokenknGk = sibousGk;

        calcHkShrKngkBean.setKihons(pCalcHkShrKngkInputBean.getKihons());
        calcHkShrKngkBean.setKaiyakuhenreiknGk(kaiyakuhenreiknGk);
        calcHkShrKngkBean.setTmttKnGk(tmttKnGk);
        calcHkShrKngkBean.setHokenryoustGk(pCalcHkShrKngkInputBean.getHokenryou());
        calcHkShrKngkBean.setSibousGk(sibousGk);
        calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(0, currencyType));
        calcHkShrKngkBean.setHokenknGk(hokenknGk);
        calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.BLNK);
        calcHkShrKngkBean.setTeirituTmttkngk(teirituTmttkngk);
        calcHkShrKngkBean.setSisuurendouTmttkngk(sisuurendouTmttkngk);

        return errorKbn;
    }

}
