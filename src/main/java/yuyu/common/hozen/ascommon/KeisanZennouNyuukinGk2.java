package yuyu.common.hozen.ascommon;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.hozen.ascommon.dba4keisanzennounyuukingk2.KeisanZennouNyuukinGk2Dao;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ZennouGenkaRitu2;
import yuyu.def.db.entity.BM_ZennouKeikaRiritu2;

/**
 * 契約保全 案内収納共通 前納入金額計算２
 */
public class KeisanZennouNyuukinGk2 {

    private BizCurrency zennouNyuukinGk;

    private BizCurrency zennouGenka;

    private BizCurrency zennouNyuukinGkRsTk;

    private BizCurrency zennouGenkaRsTk;

    private BizCurrency zennouNyuukinGkEnka;

    private BizCurrency zennouGenkaEnka;

    public BizCurrency getZennouNyuukinGk() {
        return zennouNyuukinGk;
    }

    public BizCurrency getZennouGenka() {
        return zennouGenka;
    }

    public BizCurrency getZennouNyuukinGkRsTk() {
        return zennouNyuukinGkRsTk;
    }

    public BizCurrency getZennouGenkaRsTk() {
        return zennouGenkaRsTk;
    }

    public BizCurrency getZennouNyuukinGkEnka() {
        return zennouNyuukinGkEnka;
    }

    public BizCurrency getZennouGenkaEnka() {
        return zennouGenkaEnka;
    }

    @Inject
    private static Logger logger;

    @Inject
    private KeisanZennouNyuukinGk2Dao keisanZennouNyuukinGk2Dao;

    public KeisanZennouNyuukinGk2() {
        super();
    }

    public C_ErrorKbn execKeisanZennouNyuukinGk(
        BizDate pKykYmd,
        BizCurrency pZennouHrkp,
        BizDate pRyosyuYmd,
        BizDateYM pJyutouYm,
        Integer pJyutouNensuu,
        C_Tuukasyu pRsTuukasyu,
        BizNumber pRyosyukwsRate,
        BizNumber pYenkansanTkykwsRate) {

        logger.debug("▽ 前納入金額計算２ 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        BizDate keikaRirituKaishibi = BizDate.valueOf(pJyutouYm.addYears(-1), pKykYmd.getDay()).getRekijyou();
        if (BizDateUtil.compareYmd(keikaRirituKaishibi, pRyosyuYmd) == BizDateUtil.COMPARE_GREATER) {
            errorKbn = C_ErrorKbn.ERROR;
            logger.debug("△ 前納入金額計算２ 終了");
            return errorKbn;
        }

        BizDateSpan dateSpan = BizDateUtil.calcDifference(keikaRirituKaishibi, pRyosyuYmd);
        Integer keikatukisuu = dateSpan.getYears() * 12 + dateSpan.getMonths();
        Integer keikatuhisuu = dateSpan.getDays();

        if (keikatuhisuu > 15) {
            keikatukisuu++;
        }

        if (keikatukisuu > 11) {
            errorKbn = C_ErrorKbn.ERROR;
            logger.debug("△ 前納入金額計算２ 終了");
            return errorKbn;
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        C_Tuukasyu keisannTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(pZennouHrkp.getType());

        BM_ZennouKeikaRiritu2 zennouKeikaRiritu2 =
            keisanZennouNyuukinGk2Dao.getZennouKeikaRiritu2(keisannTuukasyu, keikatukisuu, pRyosyuYmd);

        if (zennouKeikaRiritu2 == null) {
            errorKbn = C_ErrorKbn.ERROR;
            logger.debug("△ 前納入金額計算２ 終了");
            return errorKbn;
        }

        BizNumber zennouKeikaRiritu = zennouKeikaRiritu2.getZennoukeikariritu();

        BizCurrency zennouHrkp = null;

        if (C_Tuukasyu.JPY.eq(keisannTuukasyu)) {

            zennouHrkp = pZennouHrkp;
        }
        else {

            zennouHrkp = pZennouHrkp.multiply(100);
        }

        C_ErrorKbn zennouGenkaKbn = getZennouGenka(zennouHrkp, pJyutouNensuu, pRyosyuYmd, keisannTuukasyu);

        if (C_ErrorKbn.ERROR.eq(zennouGenkaKbn)) {

            errorKbn = C_ErrorKbn.ERROR;
            logger.debug("△ 前納入金額計算２ 終了");
            return errorKbn;
        }

        BizNumber tempZennouNyuukinGk = BizNumber.valueOf(zennouGenka).multiply(zennouKeikaRiritu, 0, RoundingMode.DOWN);
        zennouNyuukinGk = BizCurrency.valueOf(new BigDecimal(tempZennouNyuukinGk.toString()), zennouGenka.getType());

        if (!C_Tuukasyu.JPY.eq(keisannTuukasyu)) {

            zennouGenka = zennouGenka.divide(100);
            zennouNyuukinGk = zennouNyuukinGk.divide(100);
        }

        C_ErrorKbn kansanTuukaKbn = kansanTuuka(keisannTuukasyu, pRsTuukasyu, pRyosyukwsRate, pYenkansanTkykwsRate);

        if (C_ErrorKbn.ERROR.eq(kansanTuukaKbn)) {

            errorKbn = C_ErrorKbn.ERROR;
            logger.debug("△ 前納入金額計算２ 終了");
            return errorKbn;
        }

        logger.debug("△ 前納入金額計算２ 終了");

        return errorKbn;
    }

    public C_ErrorKbn execKeisanSinkeiyakuDoujiZennouNyuukinGk(
        BizDate pKijyunymd,
        BizCurrency pZennouHrkp,
        Integer pZennouKikan,
        C_Tuukasyu pRsTuukasyu,
        BizNumber pRyosyukwsRate,
        BizNumber pYenkansanTkykwsRate) {

        logger.debug("▽ 前納入金額計算２ 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        C_Tuukasyu keisannTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(pZennouHrkp.getType());

        BizCurrency zennouHrkp = null;

        if (C_Tuukasyu.JPY.eq(keisannTuukasyu)) {

            zennouHrkp = pZennouHrkp;
        }
        else {

            zennouHrkp = pZennouHrkp.multiply(100);
        }

        C_ErrorKbn zennouGenkaKbn = getZennouGenka(zennouHrkp, pZennouKikan, pKijyunymd, keisannTuukasyu);

        if (C_ErrorKbn.ERROR.eq(zennouGenkaKbn)) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 前納入金額計算２ 終了");
            return errorKbn;
        }

        if (!C_Tuukasyu.JPY.eq(keisannTuukasyu)) {

            zennouGenka = zennouGenka.divide(100);
        }

        zennouNyuukinGk = zennouGenka;

        C_ErrorKbn kansanTuukaKbn = kansanTuuka(keisannTuukasyu, pRsTuukasyu, pRyosyukwsRate, pYenkansanTkykwsRate);

        if (C_ErrorKbn.ERROR.eq(kansanTuukaKbn)) {

            errorKbn = C_ErrorKbn.ERROR;
            logger.debug("△ 前納入金額計算２ 終了");
            return errorKbn;
        }

        zennouNyuukinGk = zennouNyuukinGk.add(pZennouHrkp);

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        if (pRsTuukasyu != null && !C_Tuukasyu.BLNK.eq(pRsTuukasyu) && !pRsTuukasyu.eq(keisannTuukasyu)) {

            BizCurrency kanzanGaku =
                keisanGaikakanzan.exec(pRsTuukasyu, pZennouHrkp, pRyosyukwsRate, C_HasuusyoriKbn.SUTE);
            zennouNyuukinGkRsTk = zennouNyuukinGkRsTk.add(kanzanGaku);
        }
        else {
            zennouNyuukinGkRsTk = zennouNyuukinGk;
        }

        if (!C_Tuukasyu.JPY.eq(keisannTuukasyu)) {

            if (pYenkansanTkykwsRate != null) {

                BizCurrency kanzanGaku =
                    keisanGaikakanzan.exec(C_Tuukasyu.JPY, pZennouHrkp, pRyosyukwsRate, C_HasuusyoriKbn.SUTE);
                zennouNyuukinGkEnka = zennouNyuukinGkEnka.add(kanzanGaku);
            }
            else {

                zennouNyuukinGkEnka = null;
            }
        }
        else {

            zennouNyuukinGkEnka = zennouNyuukinGk;
        }

        logger.debug("△ 前納入金額計算２ 終了");
        return errorKbn;
    }

    private C_ErrorKbn getZennouGenka(
        BizCurrency pZennouHrkp,
        Integer pJyutouNensuu,
        BizDate pZennouGenkarituKjymd,
        C_Tuukasyu pTuukasyu) {

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        BM_ZennouGenkaRitu2 zennouGenkaRitu2 = keisanZennouNyuukinGk2Dao.getZennouGenkaRitu2(
            pTuukasyu,
            pJyutouNensuu,
            pZennouGenkarituKjymd);

        if (zennouGenkaRitu2 == null) {
            errorKbn = C_ErrorKbn.ERROR;
            return errorKbn;
        }

        BizNumber zennougenkaritu = zennouGenkaRitu2.getZennougenkaritu();
        BizNumber tempZennouGenka = BizNumber.valueOf(pZennouHrkp).multiply(zennougenkaritu, 0, RoundingMode.DOWN);

        zennouGenka = BizCurrency.valueOf(new BigDecimal(tempZennouGenka.toString()), pZennouHrkp.getType());

        return errorKbn;
    }

    private C_ErrorKbn kansanTuuka(
        C_Tuukasyu pKeisannTuukasyu,
        C_Tuukasyu pRsTuukasyu,
        BizNumber pRyosyukwsRate,
        BizNumber pYenkansanTkykwsRate) {

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        if (pRsTuukasyu != null && !C_Tuukasyu.BLNK.eq(pRsTuukasyu) && !pRsTuukasyu.eq(pKeisannTuukasyu)) {

            if (pRyosyukwsRate == null) {

                errorKbn = C_ErrorKbn.ERROR;
                return errorKbn;
            }

            zennouGenkaRsTk = keisanGaikakanzan.exec(pRsTuukasyu, zennouGenka, pRyosyukwsRate, C_HasuusyoriKbn.SUTE);

            if (zennouGenka.compareTo(zennouNyuukinGk) == 0) {

                zennouNyuukinGkRsTk = zennouGenkaRsTk;
            }
            else {
                zennouNyuukinGkRsTk =
                    keisanGaikakanzan.exec(pRsTuukasyu, zennouNyuukinGk, pRyosyukwsRate, C_HasuusyoriKbn.SUTE);
            }
        }
        else {

            zennouNyuukinGkRsTk = zennouNyuukinGk;
            zennouGenkaRsTk = zennouGenka;
        }

        if (!C_Tuukasyu.JPY.eq(pKeisannTuukasyu)) {

            if (pYenkansanTkykwsRate != null) {

                zennouGenkaEnka =
                    keisanGaikakanzan.exec(C_Tuukasyu.JPY, zennouGenka, pYenkansanTkykwsRate, C_HasuusyoriKbn.SUTE);

                if (zennouGenka.compareTo(zennouNyuukinGk) == 0) {

                    zennouNyuukinGkEnka = zennouGenkaEnka;
                }
                else {

                    zennouNyuukinGkEnka =
                        keisanGaikakanzan.exec(C_Tuukasyu.JPY, zennouNyuukinGk, pYenkansanTkykwsRate, C_HasuusyoriKbn.SUTE);
                }
            }
            else {

                zennouNyuukinGkEnka = null;
                zennouGenkaEnka = null;
            }
        }
        else {

            zennouNyuukinGkEnka = zennouNyuukinGk;
            zennouGenkaEnka = zennouGenka;
        }

        return errorKbn;
    }
}