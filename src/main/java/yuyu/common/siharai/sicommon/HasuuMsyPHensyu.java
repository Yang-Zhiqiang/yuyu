package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 保険金給付金支払 保険金給付金支払共通 端数月未収Ｐ編集
 */
public class HasuuMsyPHensyu {

    private Integer misyuupjyuutoukaisuuy;

    private Integer misyuupjyuutoukaisuum;

    private BizDateYM misyuupjyuutouym;

    private BizCurrency misyuup;

    private BizCurrency yenkamisyuup;

    private Integer mikeikapjyuutoukaisuuy;

    private Integer mikeikapjyuutoukaisuum;

    private BizDateYM mikeikapjyuutouym;

    private BizCurrency mikeikap;

    private BizCurrency yenkamikeikap;

    @Inject
    private static Logger logger;

    public C_ErrorKbn exec(HasuuMsyPHensyuBean pHasuuMsyPHensyuBean) {

        logger.debug("▽ 端数月未収Ｐ編集 開始");

        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

        if (pHasuuMsyPHensyuBean.getMisyuup() == null ||
            pHasuuMsyPHensyuBean.getMikeikap() == null ||
            pHasuuMsyPHensyuBean.getKyktuukasyu() == null) {

            logger.debug("△ 端数月未収Ｐ編集 終了");

            kekkaKbn = C_ErrorKbn.ERROR;
            return kekkaKbn;
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType tuukaType = henkanTuuka.henkanTuukaKbnToType(pHasuuMsyPHensyuBean.getKyktuukasyu());

        if (pHasuuMsyPHensyuBean.getMisyuup().compareTo(
            BizCurrency.valueOf(0, pHasuuMsyPHensyuBean.getMisyuup().getType())) > 0 &&
            pHasuuMsyPHensyuBean.getMikeikap().compareTo(
                BizCurrency.valueOf(0, pHasuuMsyPHensyuBean.getMikeikap().getType())) > 0) {

            BizCurrency misyuupWk = pHasuuMsyPHensyuBean.getMisyuup().subtract(pHasuuMsyPHensyuBean.getMikeikap()) ;

            if (C_Tuukasyu.JPY.eq(pHasuuMsyPHensyuBean.getKyktuukasyu())) {
                misyuup = misyuupWk;
                yenkamisyuup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                mikeikap = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                yenkamikeikap = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
            else {

                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                BizCurrency kanzanGaku = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY, misyuupWk, pHasuuMsyPHensyuBean.getKwsrate(), C_HasuusyoriKbn.AGE);

                misyuup = misyuupWk;
                yenkamisyuup = kanzanGaku;
                mikeikap = BizCurrency.valueOf(0, tuukaType);
                yenkamikeikap = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }

            if (pHasuuMsyPHensyuBean.getMisyuupjyuutouym() != null) {

                Integer misyuupJyuutouKaisuumWk = pHasuuMsyPHensyuBean.getMisyuupjyuutoukaisuuy() * 12
                    + pHasuuMsyPHensyuBean.getMisyuupjyuutoukaisuum()
                    - pHasuuMsyPHensyuBean.getMikeikapjyuutoukaisuum();

                misyuupjyuutoukaisuuy = 0;
                misyuupjyuutoukaisuum = misyuupJyuutouKaisuumWk;
                misyuupjyuutouym = pHasuuMsyPHensyuBean.getMisyuupjyuutouym();
                mikeikapjyuutoukaisuuy = 0;
                mikeikapjyuutoukaisuum = 0;
                mikeikapjyuutouym = null;
            }
            else {
                misyuupjyuutoukaisuuy = 0;
                misyuupjyuutoukaisuum = 0;
                misyuupjyuutouym = null;
                mikeikapjyuutoukaisuuy = 0;
                mikeikapjyuutoukaisuum = 0;
                mikeikapjyuutouym = null;
            }
        }
        else {

            misyuupjyuutoukaisuuy = pHasuuMsyPHensyuBean.getMisyuupjyuutoukaisuuy();
            misyuupjyuutoukaisuum = pHasuuMsyPHensyuBean.getMisyuupjyuutoukaisuum();
            misyuupjyuutouym =  pHasuuMsyPHensyuBean.getMisyuupjyuutouym();
            misyuup =  pHasuuMsyPHensyuBean.getMisyuup();
            yenkamisyuup = pHasuuMsyPHensyuBean.getYenkamisyuup();
            mikeikapjyuutoukaisuuy = pHasuuMsyPHensyuBean.getMikeikapjyuutoukaisuuy();
            mikeikapjyuutoukaisuum = pHasuuMsyPHensyuBean.getMikeikapjyuutoukaisuum();
            mikeikapjyuutouym = pHasuuMsyPHensyuBean.getMikeikapjyuutouym();
            mikeikap = pHasuuMsyPHensyuBean.getMikeikap();
            yenkamikeikap = pHasuuMsyPHensyuBean.getYenkamikeikap();
        }

        logger.debug("△ 端数月未収Ｐ編集 終了");

        return kekkaKbn;
    }

    public Integer getMisyuupjyuutoukaisuuy() {
        return misyuupjyuutoukaisuuy;
    }

    public Integer getMisyuupjyuutoukaisuum() {
        return misyuupjyuutoukaisuum;
    }

    public BizDateYM getMisyuupjyuutouym() {
        return misyuupjyuutouym;
    }

    public BizCurrency getMisyuup() {
        return misyuup;
    }

    public BizCurrency getYenkamisyuup() {
        return yenkamisyuup;
    }

    public Integer getMikeikapjyuutoukaisuuy() {
        return mikeikapjyuutoukaisuuy;
    }

    public Integer getMikeikapjyuutoukaisuum() {
        return mikeikapjyuutoukaisuum;
    }

    public BizDateYM getMikeikapjyuutouym() {
        return mikeikapjyuutouym;
    }

    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    public BizCurrency getYenkamikeikap() {
        return yenkamikeikap;
    }
}
