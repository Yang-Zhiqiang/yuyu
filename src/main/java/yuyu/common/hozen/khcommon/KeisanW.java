package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FiSiyouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KaiyakuKeisanHousikiKbn;

/**
 * 契約保全 契約保全共通 解約返戻金計算
 */
public class KeisanW {

    private BizCurrency kaiyakuHr = null;

    private BizCurrency tmttKngk = null;

    private BizNumber sjkkkTyouseiRitu = null;

    private BizCurrency sjkkkTyouseiGk = null;

    private BizNumber kaiyakuKjRitu = null;

    private BizCurrency kaiyakuKjgk = null;

    private int kaiyakukoujyoKeikaNensuu = 0;

    private int keikaNensuu = 0;

    private int keikaMon = 0;

    private BizCurrency hengakuTmttKngkKeiyaku = null;

    private C_FiSiyouKbn fiSiyouKbn = null;

    private BizNumber mvaTyouseikou = null;

    private int mvaYouKeikanensuu = 0;

    private BizCurrency teiriTutmttKngk = null;

    private BizCurrency sisuuRendouTmttKngk = null;

    private BizCurrency kaiyakukjMaeW = null;

    private BizCurrency pruikei = null;

    private BizCurrency ptumitatekinTyoseimae = null;

    private BizDateYM ptumitatekinKeisanYM = null;

    @Inject
    private static Logger logger;

    public KeisanW() {
        super();
    }

    public BizCurrency getW() {
        return kaiyakuHr;
    }

    public BizCurrency getV() {
        return tmttKngk;
    }

    public BizNumber getSjkkktyouseiritu() {
        return sjkkkTyouseiRitu;
    }

    public BizCurrency getSjkkktyouseigk() {
        return sjkkkTyouseiGk;
    }

    public BizNumber getKaiyakukjritu() {
        return kaiyakuKjRitu;
    }

    public BizCurrency getKaiyakukjgk() {
        return kaiyakuKjgk;
    }

    public int getKaiyakukoujyoKeikaNensuu() {
        return kaiyakukoujyoKeikaNensuu;
    }

    public int getKeikanensuu() {
        return keikaNensuu;
    }

    public int getKeikatukisuu() {
        return keikaMon;
    }

    public BizCurrency getCV() {
        return hengakuTmttKngkKeiyaku;
    }

    public C_FiSiyouKbn getFiSiyouKbn() {
        return fiSiyouKbn;
    }

    public BizNumber getMvaTyouseikou() {
        return mvaTyouseikou;
    }

    public int getMvaYouKeikanensuu() {
        return mvaYouKeikanensuu;
    }

    public BizCurrency getTeirituTmttkngk() {
        return teiriTutmttKngk;
    }

    public BizCurrency getSisuurendouTmttkngk() {
        return sisuuRendouTmttKngk;
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

    public C_ErrorKbn exec(BizDate pCalcKijyunYmd, BizDateYM pKijyunYm,
        KeisanWExtBean pKeisanWExtBean) {

        logger.debug("▽ 解約返戻金計算 開始");


        if (C_Hrkkaisuu.BLNK.eq(pKeisanWExtBean.getHrkkaisuu())) {

            logger.debug("△ 解約返戻金計算 終了");

            return C_ErrorKbn.ERROR;

        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pKeisanWExtBean.getTuukasyu());

        kaiyakuHr = BizCurrency.valueOf(0, currencyType);
        tmttKngk = BizCurrency.valueOf(0, currencyType);
        sjkkkTyouseiRitu = BizNumber.ZERO;
        sjkkkTyouseiGk = BizCurrency.valueOf(0, currencyType);
        kaiyakuKjRitu = BizNumber.ZERO;
        kaiyakuKjgk = BizCurrency.valueOf(0, currencyType);
        hengakuTmttKngkKeiyaku = BizCurrency.valueOf(0, currencyType);
        fiSiyouKbn = C_FiSiyouKbn.BLNK;
        mvaTyouseikou = BizNumber.ZERO;
        teiriTutmttKngk = BizCurrency.valueOf(0, currencyType);
        sisuuRendouTmttKngk = BizCurrency.valueOf(0, currencyType);
        kaiyakukjMaeW = BizCurrency.valueOf(0, currencyType);
        pruikei = BizCurrency.valueOf(0, currencyType);
        ptumitatekinTyoseimae = BizCurrency.valueOf(0, currencyType);

        SyouhinUtil syouhinUtil = SWAKInjector.getInstance(SyouhinUtil.class);

        C_KaiyakuKeisanHousikiKbn  kaiyakuKeisanHousikiKbn = syouhinUtil.getKaiyakuKeisanHousikiKbn(pKeisanWExtBean.getSyouhncd());

        if (C_Hrkkaisuu.ITIJI.eq(pKeisanWExtBean.getHrkkaisuu())) {
            KeisanWItiji keisanWItiji = SWAKInjector
                .getInstance(KeisanWItiji.class);

            C_ErrorKbn errorKbn = keisanWItiji.exec(pCalcKijyunYmd, pKijyunYm,
                pKeisanWExtBean);

            if (!C_ErrorKbn.OK.eq(errorKbn)) {

                logger.debug("△ 解約返戻金計算 終了");

                return C_ErrorKbn.ERROR;
            }

            kaiyakuHr = keisanWItiji.getW();
            tmttKngk = keisanWItiji.getV();
            sjkkkTyouseiRitu = keisanWItiji.getSjkkktyouseiritu();
            sjkkkTyouseiGk = keisanWItiji.getSjkkktyouseigk();
            kaiyakuKjRitu = keisanWItiji.getKaiyakukjritu();
            kaiyakuKjgk = keisanWItiji.getKaiyakukjgk();
            kaiyakukoujyoKeikaNensuu = keisanWItiji.getKaiyakukoujyokeikanensuu();
            keikaNensuu = keisanWItiji.getKeikanensuu();
            keikaMon = keisanWItiji.getKeikatukisuu();
            hengakuTmttKngkKeiyaku = keisanWItiji.getCV();
            fiSiyouKbn = keisanWItiji.getFiSiyouKbn();
            mvaTyouseikou = keisanWItiji.getMvaTyouseikou();
            mvaYouKeikanensuu = keisanWItiji.getMvaYouKeikanensuu();
            teiriTutmttKngk = keisanWItiji.getTeiriTutmttKngk();
            sisuuRendouTmttKngk = keisanWItiji.getSisuuRendouTmttKngk();
            kaiyakukjMaeW = keisanWItiji.getKaiyakukjMaeW();

        }
        else if (!C_Hrkkaisuu.ITIJI.eq(pKeisanWExtBean.getHrkkaisuu()) && C_KaiyakuKeisanHousikiKbn.RATE.eq(kaiyakuKeisanHousikiKbn)) {

            KeisanWHyojyun keisanWHyojyun = SWAKInjector.getInstance(KeisanWHyojyun.class);

            C_ErrorKbn errorKbn = keisanWHyojyun.exec(pCalcKijyunYmd, pKijyunYm, pKeisanWExtBean);

            if (!C_ErrorKbn.OK.eq(errorKbn)) {

                logger.debug("△ 解約返戻金計算 終了");

                return C_ErrorKbn.ERROR;
            }

            kaiyakuHr = keisanWHyojyun.getW();

            keikaNensuu = keisanWHyojyun.getKeikanensuu();

            keikaMon = keisanWHyojyun.getKeikatukisuu();

        }
        else {
            KeisanWHeijyun keisanWHeijyun = SWAKInjector.getInstance(KeisanWHeijyun.class);
            C_ErrorKbn errorKbn = keisanWHeijyun.exec(pCalcKijyunYmd, pKijyunYm, pKeisanWExtBean);

            if (!C_ErrorKbn.OK.eq(errorKbn)) {

                logger.debug("△ 解約返戻金計算 終了");

                return C_ErrorKbn.ERROR;
            }

            kaiyakuHr = keisanWHeijyun.getW();
            tmttKngk = keisanWHeijyun.getV();
            kaiyakuKjRitu = keisanWHeijyun.getKaiyakukjritu();
            kaiyakuKjgk = keisanWHeijyun.getKaiyakukjgk();
            kaiyakukoujyoKeikaNensuu = keisanWHeijyun.getKaiyakukjyouKeikanensuu();
            keikaNensuu = keisanWHeijyun.getKeikanensuu();
            keikaMon = keisanWHeijyun.getKeikatukisuu();
            kaiyakukjMaeW = keisanWHeijyun.getKaiyakukjMaeW();
            pruikei = keisanWHeijyun.getPruikei();
            ptumitatekinTyoseimae = keisanWHeijyun.getPtumitatekinTyoseimae();
            ptumitatekinKeisanYM = keisanWHeijyun.getPtumitatekinKeisanYM();
        }

        logger.debug("△ 解約返戻金計算 終了");

        return C_ErrorKbn.OK;
    }
}
