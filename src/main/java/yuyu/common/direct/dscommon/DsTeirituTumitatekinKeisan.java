package yuyu.common.direct.dscommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttkn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳ定率積立金計算
 */
public class DsTeirituTumitatekinKeisan {

    private BizCurrency nkGnsGk;

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public DsTeirituTumitatekinKeisan() {
        super();
    }

    public BizCurrency getNkGnsGk() {
        return nkGnsGk;
    }

    public C_ErrorKbn keisanNkGnsGk(String pSyono, BizDate pCalckijyunYmd, IT_KykSyouhn pKykSyouhn,
        IT_KykSonotaTkyk pKykSonotaTkyk) {

        logger.debug("▽ 年金原資額計算 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        SisurendoTmttknInfoBean sisurendoTmttknInfoBean = hozenDomManager.getSisurendoTmttknInfoBean(pSyono,
            pCalckijyunYmd);

        C_Tuukasyu kyktuukasyu = pKykSyouhn.getKyktuukasyu();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType tuukaType = henkanTuuka.henkanTuukaKbnToType(kyktuukasyu);

        BizDateYM hknkknmanryouYm = pKykSyouhn.getHknkknmanryouymd().getBizDateYM();

        BizDateYM tmttknTaisyouYm = sisurendoTmttknInfoBean.getTmttknTaisyouYM().getNextYear();

        BizCurrency teirituTmttKngk = sisurendoTmttknInfoBean.getSisuuRendouTmttknGK();

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(0, tuukaType);

        BizDateYM calcKijyunYm = tmttknTaisyouYm;

        BizDateYM calcStartYm = tmttknTaisyouYm;

        if (BizDateUtil.compareYm(hknkknmanryouYm, tmttknTaisyouYm) == BizDateUtil.COMPARE_LESSER) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 年金原資額計算 終了");

            return errorKbn;
        }

        int keikamonTukikansan = BizDateUtil.calcDifferenceMonths(hknkknmanryouYm, tmttknTaisyouYm);

        int keikayear = keikamonTukikansan / 12;

        KeisanSisuuRendouNkTmttkn keisanSisuuRendouNkTmttkn = SWAKInjector.getInstance(KeisanSisuuRendouNkTmttkn.class);

        BizDate sysDate = BizDate.getSysDate();

        while (keikayear > 0) {

            calcKijyunYm = calcStartYm.getNextYear();

            errorKbn = keisanSisuuRendouNkTmttkn.exec(pKykSyouhn.getKykymd(), pKykSyouhn.getHknkkn(),
                pKykSonotaTkyk.getTeikishrtkykhukaumu(), pKykSyouhn.getKyktuukasyu(), sysDate, calcKijyunYm,
                calcStartYm, pKykSyouhn.getTumitateriritu(), teirituTmttKngk, sisuuRendouTmttKngk);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 年金原資額計算 終了");

                return errorKbn;
            }

            teirituTmttKngk = keisanSisuuRendouNkTmttkn.getTeiritutmttkngk();

            calcStartYm = calcStartYm.getNextYear();

            keikayear = keikayear - 1;
        }

        errorKbn = C_ErrorKbn.OK;

        nkGnsGk = teirituTmttKngk;

        logger.debug("△ 年金原資額計算 終了");

        return errorKbn;
    }
}
