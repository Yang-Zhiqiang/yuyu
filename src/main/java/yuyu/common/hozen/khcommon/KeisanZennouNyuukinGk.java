package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.khcommon.dba4keisanzennounyuukingk.KeisanZennouNyuukinGkDao;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.BM_ZennouGenkaRitu;
import yuyu.def.db.entity.BM_ZennouKeikaRiritu;

/**
 * 契約保全 契約保全共通 前納入金額計算 
 */
public class KeisanZennouNyuukinGk {

    @Inject
    private static Logger logger;

    @Inject
    private KeisanZennouNyuukinGkDao keisanZennouNyuukinGkDao;

    private BizCurrency zennouNyuukin;

    private BizCurrency zennouGenka;

    public KeisanZennouNyuukinGk() {
        super();
    }

    public C_ErrorKbn execKeisanZennouNyuukinGk(BizDate pKykYmd, BizCurrency pZennouHrkp, BizDate pRyosyuYmd,
        BizDateYM pJyutouYm, Integer pJyutouNensuu) {

        logger.debug("▽ 前納入金額計算 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        BizDate keikaRirituKaishibi = BizDate.valueOf(pJyutouYm.addYears(-1), pKykYmd.getDay()).getRekijyou();
        if (BizDateUtil.compareYmd(keikaRirituKaishibi, pRyosyuYmd) == BizDateUtil.COMPARE_GREATER) {
            errorKbn = C_ErrorKbn.ERROR;
            logger.debug("△ 前納入金額計算 終了");
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
            logger.debug("△ 前納入金額計算 終了");
            return errorKbn;
        }

        BM_ZennouKeikaRiritu zennouKeikaRiritu = keisanZennouNyuukinGkDao
            .getZennouKeikaRiritu(keikatukisuu, pRyosyuYmd);
        if (zennouKeikaRiritu == null) {
            errorKbn = C_ErrorKbn.ERROR;
            logger.debug("△ 前納入金額計算 終了");
            return errorKbn;
        }

        BizNumber zennoukeikariritu = zennouKeikaRiritu.getZennoukeikariritu();

        errorKbn = getZennouGenka(pZennouHrkp, pJyutouNensuu, pRyosyuYmd);
        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            logger.debug("△ 前納入金額計算 終了");
            return errorKbn;
        }
        zennouNyuukin = zennouGenka.multiply(zennoukeikariritu, 0, RoundingMode.DOWN);

        logger.debug("△ 前納入金額計算 終了");
        return errorKbn;
    }

    public C_ErrorKbn execKeisanSinkeiyakuDoujiZennouNyuukinGk(BizDate pKijyunymd, BizCurrency pZennouHrkp,
        Integer pZennouKikan) {

        logger.debug("▽ 前納入金額計算 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        errorKbn = getZennouGenka(pZennouHrkp, pZennouKikan, pKijyunymd);
        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            logger.debug("△ 前納入金額計算 終了");
            return errorKbn;
        }
        zennouNyuukin = zennouGenka.add(pZennouHrkp);

        logger.debug("△ 前納入金額計算 終了");
        return errorKbn;
    }

    public BizCurrency getZennouNyuukinGk() {
        return zennouNyuukin;
    }

    public BizCurrency getZennouGenka() {
        return zennouGenka;
    }

    private C_ErrorKbn getZennouGenka(BizCurrency pZennouHrkp, Integer pJyutouNensuu, BizDate pZennouGenkarituKjymd) {

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        BM_ZennouGenkaRitu zennouGenkaRitu = keisanZennouNyuukinGkDao.getZennouGenkaRitu(pJyutouNensuu,
            pZennouGenkarituKjymd);
        if (zennouGenkaRitu == null) {
            errorKbn = C_ErrorKbn.ERROR;
            return errorKbn;
        }
        BizNumber zennougenkaritu = zennouGenkaRitu.getZennougenkaritu();
        zennouGenka = pZennouHrkp.multiply(zennougenkaritu, 0, RoundingMode.DOWN);

        return errorKbn;
    }
}
