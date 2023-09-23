package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknKknKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金額計算（平準払終身）
 */

public class CalcHkKngkHijynbrSysn {

    @Inject
    private static Logger logger;

    private CalcHkShrKngkBean calcHkShrKngkBean;

    private BizDate calcKijyunYmd;

    public C_ErrorKbn exec(CalcHkShrKngkInputBean pCalcHkShrKngkInputBean){

        logger.debug("▽ 保険金額計算（平準払終身）開始");

        calcHkShrKngkBean = SWAKInjector.getInstance(CalcHkShrKngkBean.class);

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pCalcHkShrKngkInputBean.getKykymd() == null
            || pCalcHkShrKngkInputBean.getCalckijyunymd() == null) {

            logger.debug("△ 保険金額計算（平準払終身） 終了");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pCalcHkShrKngkInputBean.getTuukasyu());

        BizCurrency sibousGk = BizCurrency.valueOf(0, currencyType);
        BizCurrency hokenknGk = BizCurrency.valueOf(0, currencyType);
        BizCurrency kibaraipsoutouGk = BizCurrency.valueOf(0, currencyType);

        if (BizDateUtil.compareYmd(pCalcHkShrKngkInputBean.getCalckijyunymd(),
            pCalcHkShrKngkInputBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {
            calcKijyunYmd = pCalcHkShrKngkInputBean.getKykymd();
        }
        else {
            calcKijyunYmd = pCalcHkShrKngkInputBean.getCalckijyunymd();
        }

        SiCalcKihrkmpstgkBean siCalcKihrkmpstgkBean = SWAKInjector.getInstance(SiCalcKihrkmpstgkBean.class);

        siCalcKihrkmpstgkBean.setKykYmd(pCalcHkShrKngkInputBean.getKykymd());
        siCalcKihrkmpstgkBean.setSyouhnCd(pCalcHkShrKngkInputBean.getSyouhncd());
        siCalcKihrkmpstgkBean.setRyouriTusdNo(pCalcHkShrKngkInputBean.getRyouritusdno());
        siCalcKihrkmpstgkBean.setYoteiRiritu(pCalcHkShrKngkInputBean.getYoteiriritu());
        siCalcKihrkmpstgkBean.setHrkKaisuu(pCalcHkShrKngkInputBean.getHrkkaisuu());
        siCalcKihrkmpstgkBean.setHhknNen(pCalcHkShrKngkInputBean.getHhknnen());
        siCalcKihrkmpstgkBean.setHhknSei(pCalcHkShrKngkInputBean.getHhknsei());
        siCalcKihrkmpstgkBean.setHknkknSmnKbn(pCalcHkShrKngkInputBean.getHknkknsmnkbn());
        siCalcKihrkmpstgkBean.setHknKkn(pCalcHkShrKngkInputBean.getHknkkn());
        siCalcKihrkmpstgkBean.setHrkkknSmnKbn(pCalcHkShrKngkInputBean.getHrkkknsmnKbn());
        siCalcKihrkmpstgkBean.setHrkKkn(pCalcHkShrKngkInputBean.getHrkkkn());
        siCalcKihrkmpstgkBean.setSdPdKbn(pCalcHkShrKngkInputBean.getSdpdkbn());
        siCalcKihrkmpstgkBean.setHokenknGk(pCalcHkShrKngkInputBean.getKihons());
        siCalcKihrkmpstgkBean.setHokenRyou(pCalcHkShrKngkInputBean.getHokenryou());
        siCalcKihrkmpstgkBean.setKykTuukaSyu(pCalcHkShrKngkInputBean.getTuukasyu());
        siCalcKihrkmpstgkBean.setKykJyoutai(pCalcHkShrKngkInputBean.getKykJyoutai());
        siCalcKihrkmpstgkBean.setDai1HknKkn(pCalcHkShrKngkInputBean.getDai1hknkkn());
        siCalcKihrkmpstgkBean.setHrkKeiro(pCalcHkShrKngkInputBean.getHrkkeiro());
        siCalcKihrkmpstgkBean.setCalcKijyunYmd(calcKijyunYmd);

        SiCalcKihrkmpstgk siCalcKihrkmpstgk = SWAKInjector.getInstance(SiCalcKihrkmpstgk.class);
        siCalcKihrkmpstgk.exec(siCalcKihrkmpstgkBean);

        kibaraipsoutouGk = siCalcKihrkmpstgk.getKiHrkmpstGk();

        HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);
        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(pCalcHkShrKngkInputBean.getKykymd());
        hanteiHokenKikanBean.setCalcKijyunYmd(calcKijyunYmd);
        hanteiHokenKikanBean.setSyouhnZokusei(pCalcHkShrKngkInputBean.getSyouhnZokusei());
        hanteiHokenKikanBean.setDai1hknkkn(pCalcHkShrKngkInputBean.getDai1hknkkn());

        C_HknKknKbn hknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        if (C_HknKknKbn.DAI1HKNKKN.eq(hknKknKbn)) {
            sibousGk = kibaraipsoutouGk;
        }
        else if (C_HknKknKbn.DAI2HKNKKN.eq(hknKknKbn)) {
            sibousGk = pCalcHkShrKngkInputBean.getKihons();
        }

        hokenknGk = sibousGk;

        calcHkShrKngkBean.setKihons(pCalcHkShrKngkInputBean.getKihons());
        calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(0, currencyType));
        calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(0, currencyType));
        calcHkShrKngkBean.setHokenryoustGk(kibaraipsoutouGk);
        calcHkShrKngkBean.setSibousGk(sibousGk);
        calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(0, currencyType));
        calcHkShrKngkBean.setHokenknGk(hokenknGk);
        calcHkShrKngkBean.setHknKknKbn(hknKknKbn);

        logger.debug("△ 保険金額計算（平準払終身） 終了");

        return errorKbn;

    }

    public CalcHkShrKngkBean getCalcHkShrKngkBean() {
        return calcHkShrKngkBean;
    }

    public BizDate getCalcKijyunYmd() {
        return calcKijyunYmd;
    }
}
