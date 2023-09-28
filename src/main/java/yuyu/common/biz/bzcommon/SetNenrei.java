package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;

import org.slf4j.Logger;

/**
 * 業務共通 共通 年齢設定
 */
public class SetNenrei {

    private static final int MAX_NENREI = 999;

    @Inject
    private static Logger logger;

    public SetNenrei() {
        super();
    }

    public int exec(BizDate pKijyunYmd, BizDate pBirthday) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 年齢設定 開始");
        }

        int nenrei = 0;

        if (pBirthday == null) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 年齢設定 終了（生年月日＝null,ブランク）");
            }

            return 0;
        }

        if ((pKijyunYmd.compareTo(pBirthday) >= 0)) {

            nenrei = getNenrei(pKijyunYmd, pBirthday);
        }
        else {
            nenrei = 0;
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 年齢設定 終了");
        }

        return nenrei;
    }

    public int getNkshrStartNenrei(int pHhknnen, int pHknkkn) {

        logger.debug("▽ 年金支払開始年齢取得処理 開始");

        int nkshrStartNenrei = pHhknnen + pHknkkn;

        if (nkshrStartNenrei >= 100) {
            nkshrStartNenrei = 99;
        }
        else if (nkshrStartNenrei < 0) {
            nkshrStartNenrei = 0;
        }

        logger.debug("△ 年金支払開始年齢取得処理 終了");

        return nkshrStartNenrei;
    }

    private int getNenrei(BizDate pKijyunYmd, BizDate pBirthday) {
        int nenrei = 0;
        BizDateSpan ksKikan = null;

        ksKikan = BizDateUtil.calcDifference(pKijyunYmd, pBirthday);
        nenrei = ksKikan.getYears();

        if (nenrei > MAX_NENREI) {
            return 0;
        }

        return nenrei;
    }
}