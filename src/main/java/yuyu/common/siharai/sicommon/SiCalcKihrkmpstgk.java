package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.khcommon.KeisanSP;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Sdpd;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金既払込保険料相当額計算
 */
public class SiCalcKihrkmpstgk {

    @Inject
    private static Logger logger;

    private BizCurrency kiHrkmpstGk;

    public SiCalcKihrkmpstgk() {
        super();
    }

    public C_ErrorKbn exec(SiCalcKihrkmpstgkBean pSiCalcKihrkmpstgkBean) {

        logger.debug("▽ 保険金給付金既払込保険料相当額計算 開始");

        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

        if (BizDateUtil.compareYmd(pSiCalcKihrkmpstgkBean.getKykYmd(), pSiCalcKihrkmpstgkBean.getCalcKijyunYmd())
            == BizDateUtil.COMPARE_GREATER) {

            kekkaKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 保険金給付金既払込保険料相当額計算 終了");
            return kekkaKbn;
        }

        int hrkkknNensu = 0;

        if (C_HrkkknsmnKbn.SAIMANKI.eq(pSiCalcKihrkmpstgkBean.getHrkkknSmnKbn())) {

            hrkkknNensu = pSiCalcKihrkmpstgkBean.getHrkKkn() - pSiCalcKihrkmpstgkBean.getHhknNen();
        }
        else {

            hrkkknNensu = pSiCalcKihrkmpstgkBean.getHrkKkn();
        }

        BizDate hrkkknEndYmd = pSiCalcKihrkmpstgkBean.getKykYmd().addYears(hrkkknNensu);

        Boolean dateFlg = hrkkknEndYmd.isRekijyou();
        if (!dateFlg) {

            hrkkknEndYmd = hrkkknEndYmd.getRekijyou().getNextDay();
        }

        int keikaMon = 0;
        BizDateYM keikaMonKijyunYm = null;

        if (BizDateUtil.compareYmd(pSiCalcKihrkmpstgkBean.getCalcKijyunYmd(), hrkkknEndYmd) == BizDateUtil.COMPARE_LESSER) {

            if (pSiCalcKihrkmpstgkBean.getCalcKijyunYmd().getDay() < pSiCalcKihrkmpstgkBean.getKykYmd().getDay()) {

                keikaMonKijyunYm = pSiCalcKihrkmpstgkBean.getCalcKijyunYmd().getBizDateYM();
            }
            else {

                keikaMonKijyunYm = pSiCalcKihrkmpstgkBean.getCalcKijyunYmd().getNextMonth().getBizDateYM();
            }
            keikaMon = keikaMonKijyunYm.subtractMonths(pSiCalcKihrkmpstgkBean.getKykYmd().getBizDateYM());
        }
        else {

            keikaMon = hrkkknNensu * 12;
        }

        BizCurrency tkbriKijyunHokenryou;
        KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        if (C_Hrkkaisuu.TUKI.eq(pSiCalcKihrkmpstgkBean.getHrkKaisuu()) &&
            C_Sdpd.PD.eq(pSiCalcKihrkmpstgkBean.getSdPdKbn()) &&
            (C_Hrkkeiro.KOUHURI.eq(pSiCalcKihrkmpstgkBean.getHrkKeiro()) ||
                C_Hrkkeiro.CREDIT.eq(pSiCalcKihrkmpstgkBean.getHrkKeiro()))) {

            tkbriKijyunHokenryou = pSiCalcKihrkmpstgkBean.getHokenRyou();
        }
        else {

            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pSiCalcKihrkmpstgkBean.getKykTuukaSyu());

            C_ErrorKbn spErrorKbn = keisanSP.exec(
                pSiCalcKihrkmpstgkBean.getSyouhnCd(),
                pSiCalcKihrkmpstgkBean.getRyouriTusdNo(),
                pSiCalcKihrkmpstgkBean.getYoteiRiritu(),
                C_Hrkkaisuu.TUKI,
                pSiCalcKihrkmpstgkBean.getHhknNen(),
                pSiCalcKihrkmpstgkBean.getHhknSei(),
                pSiCalcKihrkmpstgkBean.getHknkknSmnKbn(),
                pSiCalcKihrkmpstgkBean.getHknKkn(),
                pSiCalcKihrkmpstgkBean.getHrkKkn(),
                C_Sdpd.SD,
                pSiCalcKihrkmpstgkBean.getHokenknGk(),
                BizCurrency.valueOf(0, currencyType),
                pSiCalcKihrkmpstgkBean.getKykTuukaSyu(),
                pSiCalcKihrkmpstgkBean.getKykJyoutai(),
                pSiCalcKihrkmpstgkBean.getDai1HknKkn(),
                C_Hrkkeiro.KOUHURI
                );

            if (!C_ErrorKbn.OK.eq(spErrorKbn)) {

                kekkaKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 保険金給付金既払込保険料相当額計算 終了");
                return kekkaKbn;
            }

            tkbriKijyunHokenryou = keisanSP.getP();
        }

        kiHrkmpstGk = tkbriKijyunHokenryou.multiply(keikaMon);

        logger.debug("△ 保険金給付金既払込保険料相当額計算 終了");

        return kekkaKbn;
    }

    public BizCurrency getKiHrkmpstGk() {
        return kiHrkmpstGk;
    }
}
