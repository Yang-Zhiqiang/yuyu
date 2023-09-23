package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.hozen.khcommon.dba4keisanikkatuwaribikip.KeisanIkkatuWaribikiPDao;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.BM_IkkatuKeisuu;

/**
 * 契約保全 契約保全共通 一括割引Ｐ計算
 */
public class KeisanIkkatuWaribikiP {

    private BizCurrency p;

    private BizCurrency iktwaribikikgk;

    @Inject
    private static Logger logger;

    @Inject
    private KeisanIkkatuWaribikiPDao keisanIkkatuWaribikiPDao;

    public KeisanIkkatuWaribikiP() {
        super();
    }

    public BizCurrency getP() {
        return p;
    }

    public BizCurrency getIktwaribikikgk() {
        return iktwaribikikgk;
    }

    public C_ErrorKbn exec(String pSyouhncd, String pRyouritusdno, BizNumber pYoteiRiritu,
        int pIktTukisuu, BizCurrency pWaribikimaep) {

        logger.debug("▽ 一括割引Ｐ計算 開始");

        iktwaribikikgk = BizCurrency.valueOf(0);

        p = BizCurrency.valueOf(0);

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhncd);
        BizNumber yoteiRiritu = BizNumber.valueOf(0);
        String ikttekiyoubr1 = "";
        String ikttekiyoubr2 = "";
        String ikttekiyoubr3 = "";

        if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            yoteiRiritu = pYoteiRiritu;
        }

        BM_IkkatuKeisuu ikkatuKeisuu = keisanIkkatuWaribikiPDao.getIkkatuKeisuu(
            pSyouhncd,
            pRyouritusdno,
            yoteiRiritu,
            ikttekiyoubr1,
            ikttekiyoubr2,
            ikttekiyoubr3,
            0,
            pIktTukisuu);

        if (ikkatuKeisuu == null) {

            logger.info("一括割引Ｐ計算エラー。一括払係数が取得できませんでした。");

            logger.debug("△ 一括割引Ｐ計算 終了");

            return C_ErrorKbn.ERROR;
        }

        iktwaribikikgk = pWaribikimaep.multiply(ikkatuKeisuu.getIktkeisuu(), 0, RoundingMode.UP);

        p = pWaribikimaep.multiply(pIktTukisuu).subtract(iktwaribikikgk);

        logger.debug("△ 一括割引Ｐ計算 終了");

        return C_ErrorKbn.OK;
    }

}
