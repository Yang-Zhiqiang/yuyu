package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_KaiyakuKoujyoRitu;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 契約保全 契約保全共通 平準払用解約返戻金計算
 */
public class KeisanWHeijyun {

    private BizCurrency kaiyakuhr = null;

    private BizCurrency tutakngk = null;

    private BizNumber kaiyakukjritu = null;

    private BizCurrency kaiyakukjgk = null;

    private int kaiyakukjyouKeikanensuu = 0;

    private int keikanensuu = 0;

    private int keikatukisuu = 0;

    private BizCurrency kaiyakukjMaeW = null;

    private BizCurrency pruikei = null;

    private BizCurrency ptumitatekinTyoseimae = null;

    private BizDateYM ptumitatekinKeisanYM = null;

    @Inject
    private static Logger logger;

    @Inject
    BizDomManager bizDomManager;

    public KeisanWHeijyun() {
        super();
    }

    public BizCurrency getW() {
        return kaiyakuhr;
    }

    public BizCurrency getV() {
        return tutakngk;
    }

    public BizNumber getKaiyakukjritu() {
        return kaiyakukjritu;
    }

    public BizCurrency getKaiyakukjgk() {
        return kaiyakukjgk;
    }

    public int getKaiyakukjyouKeikanensuu() {
        return kaiyakukjyouKeikanensuu;
    }

    public int getKeikanensuu() {
        return keikanensuu;
    }

    public int getKeikatukisuu() {
        return keikatukisuu;
    }

    public BizCurrency getKaiyakukjMaeW() {
        return kaiyakukjMaeW;
    }

    public BizCurrency getPruikei() {
        return pruikei;
    }

    public BizCurrency getPtumitatekinTyoseimae() {
        return ptumitatekinTyoseimae;
    }

    public BizDateYM getPtumitatekinKeisanYM() {
        return ptumitatekinKeisanYM;
    }

    public C_ErrorKbn exec(BizDate pCalckijyunYmd, BizDateYM pCalckijyunYm, KeisanWExtBean pKeisanWExtBean) {

        logger.debug("▽ 平準払用解約返戻金計算 開始");

        C_ErrorKbn kekkakbn = C_ErrorKbn.OK;

        if (BizDateUtil.compareYm(pCalckijyunYm, pKeisanWExtBean.getKykymd().getBizDateYM()) == BizDateUtil.COMPARE_LESSER) {
            logger.debug("△ 平準払用解約返戻金計算 終了");
            return C_ErrorKbn.ERROR;

        }

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(pKeisanWExtBean.getSyouhncd(),
            pKeisanWExtBean.getSyouhnsdno());

        if (syouhnZokusei == null) {
            logger.debug("△ 平準払用解約返戻金計算 終了");
            return C_ErrorKbn.ERROR;

        }
        C_UmuKbn kaiyakukoujyoritutekiumu = syouhnZokusei.getKaiyakukoujyoritutekiumu();

        int wkKeikaMonTukikansan =
            BizDateUtil.calcDifferenceMonths(
                pCalckijyunYm,
                pKeisanWExtBean.getKykymd()
                .getBizDateYM());

        int keikanensuuTemp = wkKeikaMonTukikansan / 12;
        int keikatukisuuTemp = 0;
        if (keikanensuuTemp > 0) {

            keikatukisuuTemp = wkKeikaMonTukikansan % 12;
        }
        else {

            keikatukisuuTemp = wkKeikaMonTukikansan;
        }

        int hrkkknNensuu = 0;

        if (C_HrkkknsmnKbn.SAIMANKI.eq(pKeisanWExtBean.getHrkkknsmnkbn())) {
            hrkkknNensuu = pKeisanWExtBean.getHrkkkn() - pKeisanWExtBean.getHhknnen();
        }
        else {
            hrkkknNensuu = pKeisanWExtBean.getHrkkkn();
        }

        BizDate hrkmanryouymd = pKeisanWExtBean.getKykymd().addYears(hrkkknNensuu);

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pKeisanWExtBean.getTuukasyu());

        BizCurrency tutakngkTemp = BizCurrency.valueOf(0, currencyType);
        BizCurrency kaiyakuhrTemp = BizCurrency.valueOf(0, currencyType);
        BizCurrency kaiyakuhrTyouseimae = BizCurrency.valueOf(0, currencyType);
        BizNumber kaiyakukoujyoritu = BizNumber.ZERO;
        BizCurrency kaiyakukjgkTemp = BizCurrency.valueOf(0, currencyType);
        BizCurrency pruikeiTemp = BizCurrency.valueOf(0, currencyType);

        KeisanVHeijyun keisanVHeijyun = SWAKInjector.getInstance(KeisanVHeijyun.class);
        KeisanVHeijyunBean keisanVHeijyunBean = SWAKInjector.getInstance(KeisanVHeijyunBean.class);

        keisanVHeijyunBean.setSyouhncd(pKeisanWExtBean.getSyouhncd());
        keisanVHeijyunBean.setRyouritusdno(pKeisanWExtBean.getRyouritusdno());
        keisanVHeijyunBean.setCalckijyunYm(pCalckijyunYm);
        keisanVHeijyunBean.setKykymd(pKeisanWExtBean.getKykymd());
        keisanVHeijyunBean.setHokenryou(pKeisanWExtBean.getHokenryou());
        keisanVHeijyunBean.setKyktuukasyu(pKeisanWExtBean.getTuukasyu());
        keisanVHeijyunBean.setHhknsei(pKeisanWExtBean.getHhknsei());
        keisanVHeijyunBean.setHhknnen(pKeisanWExtBean.getHhknnen());
        keisanVHeijyunBean.setHknkkn(pKeisanWExtBean.getHknkkn());
        keisanVHeijyunBean.setHknkknsmnkbn(pKeisanWExtBean.getHknkknsmnkbn());
        keisanVHeijyunBean.setHrkkkn(pKeisanWExtBean.getHrkkkn());
        keisanVHeijyunBean.setHrkkknsmnkbn(pKeisanWExtBean.getHrkkknsmnkbn());
        keisanVHeijyunBean.setHrkkaisuu(pKeisanWExtBean.getHrkkaisuu());
        keisanVHeijyunBean.setFstpryosyu(pKeisanWExtBean.getFstpryosyuymd());
        keisanVHeijyunBean.setSitihsyuriritu(pKeisanWExtBean.getYoteirrthendohosyurrt());
        keisanVHeijyunBean.setTmttkntaisyouym(pKeisanWExtBean.getTmttkntaisyouym());
        keisanVHeijyunBean.setCalckaisiYmjitenv(pKeisanWExtBean.getPtmttkngk());
        keisanVHeijyunBean.setCalckaisiYmjitensump(pKeisanWExtBean.getKihrkmpstgk());
        keisanVHeijyunBean.setSisansyuruikbn(pKeisanWExtBean.getSisansyuruikbn());
        keisanVHeijyunBean.setSisansyoriYmd(pKeisanWExtBean.getSisansyoriymd());
        keisanVHeijyunBean.setSisanyoteiriritu(pKeisanWExtBean.getSisanyoteiriritu());
        keisanVHeijyunBean.setSisankawaserate(pKeisanWExtBean.getSisankawaserate());

        C_ErrorKbn errorKbn = keisanVHeijyun.exec(keisanVHeijyunBean);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            logger.debug("△ 平準払用解約返戻金計算 終了");
            return C_ErrorKbn.ERROR;
        }

        tutakngkTemp = keisanVHeijyun.getV();

        pruikeiTemp = keisanVHeijyun.getKiharaikomiP();

        if (C_UmuKbn.ARI.eq(kaiyakukoujyoritutekiumu)) {

            if (keikanensuuTemp < 10) {
                String kaiyakukjtkybr1 = "";
                String kaiyakukjtkybr2 = "";

                BM_KaiyakuKoujyoRitu kaiyakuKoujyoRitu = bizDomManager.getKaiyakuKoujyoRitu(
                    pKeisanWExtBean.getSyouhncd(),
                    pKeisanWExtBean.getRyouritusdno(),
                    kaiyakukjtkybr1,
                    kaiyakukjtkybr2,
                    keikanensuuTemp);

                if (kaiyakuKoujyoRitu == null) {

                    logger.debug("△ 平準払用解約返戻金計算 終了");
                    return C_ErrorKbn.ERROR;
                }

                kaiyakukoujyoritu = kaiyakuKoujyoRitu.getKaiyakukoujyoritu();
                kaiyakukjgkTemp = tutakngkTemp.multiply(kaiyakukoujyoritu).toValidValue(RoundingMode.DOWN);

            }
        }

        BizCurrency ptumitatekinTyoseimaeTemp = tutakngkTemp;

        BizCurrency kaiyakukjMaeWTemp = tutakngkTemp;

        kaiyakuhrTyouseimae = tutakngkTemp.subtract(kaiyakukjgkTemp);

        if (kaiyakuhrTyouseimae.compareTo(BizCurrency.valueOf(0, kaiyakuhrTyouseimae.getType())) < 0) {
            kaiyakuhrTyouseimae = BizCurrency.valueOf(0, kaiyakuhrTyouseimae.getType());
        }

        if (BizDateUtil.compareYm(pCalckijyunYm, hrkmanryouymd.getBizDateYM()) >= BizDateUtil.COMPARE_EQUAL &&
            BizDateUtil.compareYmd(pCalckijyunYmd, hrkmanryouymd) >= BizDateUtil.COMPARE_EQUAL) {

            kaiyakuhrTemp = kaiyakuhrTyouseimae;

        }
        else {
            if (kaiyakuhrTyouseimae.compareTo(pruikeiTemp) <= 0) {

                kaiyakuhrTemp = kaiyakuhrTyouseimae;

            }
            else {

                kaiyakuhrTemp = pruikeiTemp;
                kaiyakukjMaeWTemp = pruikeiTemp;
            }
        }

        kaiyakuhr = kaiyakuhrTemp;
        tutakngk = tutakngkTemp;
        kaiyakukjritu = kaiyakukoujyoritu;
        kaiyakukjgk = kaiyakukjgkTemp;
        kaiyakukjyouKeikanensuu = keikanensuuTemp;
        keikanensuu = keikanensuuTemp;
        keikatukisuu = keikatukisuuTemp;
        kaiyakukjMaeW = kaiyakukjMaeWTemp;
        pruikei = pruikeiTemp;
        ptumitatekinTyoseimae = ptumitatekinTyoseimaeTemp;
        ptumitatekinKeisanYM = keisanVHeijyun.getTumitateYM();

        logger.debug("△ 平準払用解約返戻金計算 終了");

        return kekkakbn;
    }
}
