package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_SknnkaisikitkhukaKbn;
import yuyu.def.classification.C_SntkhouKbn;

/**
 * 新契約 申込内容チェック 責任開始日設定
 */
public class SetSknnkaisiymd {

    private BizDate sknnkaisiymd = null;

    private BizDate kariSknnkaisiymd = null;

    @Inject
    private static Logger logger;

    public SetSknnkaisiymd() {
        super();
    }

    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    public BizDate getKariSknnkaisiymd() {
        return kariSknnkaisiymd;
    }

    public void setKariSknnkaisiymd(BizDate pKariSknnkaisiymd) {
        kariSknnkaisiymd = pKariSknnkaisiymd;
    }

    public void exec(C_SntkhouKbn pSntkhouKbn,
        BizDate                   pKktYmd,
        BizDate                   pMosYmd,
        BizDate                   pRsYmd,
        C_SknnkaisikitkhukaKbn    pSknnKaisikiTkHkKbn,
        BizDate                   pMosUkeYmd) {
        BizDate kktYmd   = pKktYmd;
        BizDate sknnKaisiYmd = null;

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 責任開始日設定 開始");
        }

        if (pMosYmd == null) {
            throw new CommonBizAppException("責任開始日設定 必須エラー");
        }

        if (C_SntkhouKbn.NONE.eq(pSntkhouKbn)) {
            kktYmd = pMosYmd;
        }

        if (logger.isDebugEnabled()) {
            logger.debug("｜ ＷＫ１告知日=" + kktYmd);
        }

        if (C_SknnkaisikitkhukaKbn.HUKA.eq(pSknnKaisikiTkHkKbn)) {
            if ((pMosUkeYmd == null) && (kktYmd == null)) {
                sknnKaisiYmd =  pMosYmd;
            }
            else if (kktYmd == null) {
                if (BizDateUtil.compareYmd(pMosYmd, pMosUkeYmd) == BizDateUtil.COMPARE_LESSER) {
                    sknnKaisiYmd = pMosUkeYmd;
                }
                else {
                    sknnKaisiYmd = pMosYmd;
                }
            }
            else if (pMosUkeYmd == null) {
                if (BizDateUtil.compareYmd(pMosYmd, kktYmd) == BizDateUtil.COMPARE_LESSER) {
                    sknnKaisiYmd = kktYmd;
                }
                else {
                    sknnKaisiYmd = pMosYmd;
                }
            }
            else {
                if (BizDateUtil.compareYmd(pMosYmd, pMosUkeYmd) == BizDateUtil.COMPARE_LESSER) {
                    sknnKaisiYmd = pMosUkeYmd;
                }
                else {
                    sknnKaisiYmd = pMosYmd;
                }

                if (BizDateUtil.compareYmd(sknnKaisiYmd, kktYmd) == BizDateUtil.COMPARE_LESSER) {
                    sknnKaisiYmd = kktYmd;
                }
            }

            kariSknnkaisiymd = sknnKaisiYmd;

            if (pMosUkeYmd == null || kktYmd == null) {
                sknnkaisiymd = null;
            }
            else {
                sknnkaisiymd = sknnKaisiYmd;
            }
        }
        else {
            if ((pRsYmd == null) && (kktYmd == null)) {
                sknnKaisiYmd = pMosYmd;
            }
            else if (pRsYmd == null) {
                if (BizDateUtil.compareYmd(pMosYmd, kktYmd) == BizDateUtil.COMPARE_LESSER) {
                    sknnKaisiYmd = kktYmd;
                }
                else {
                    sknnKaisiYmd = pMosYmd;
                }
            }
            else if (kktYmd == null) {
                if (BizDateUtil.compareYmd(pMosYmd, pRsYmd) == BizDateUtil.COMPARE_LESSER) {
                    sknnKaisiYmd = pRsYmd;
                }
                else {
                    sknnKaisiYmd = pMosYmd;
                }
            }
            else {
                if (BizDateUtil.compareYmd(pMosYmd, kktYmd) == BizDateUtil.COMPARE_LESSER) {
                    sknnKaisiYmd = kktYmd;
                }
                else {
                    sknnKaisiYmd = pMosYmd;
                }

                if (BizDateUtil.compareYmd(sknnKaisiYmd, pRsYmd) == BizDateUtil.COMPARE_LESSER) {
                    sknnKaisiYmd = pRsYmd;
                }
            }

            kariSknnkaisiymd = sknnKaisiYmd;

            if (kktYmd == null || pRsYmd == null) {
                sknnkaisiymd = null;
            }
            else {
                sknnkaisiymd = sknnKaisiYmd;
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("｜ 責任開始日=" + sknnkaisiymd);
            logger.debug("｜ 仮責任開始日=" + kariSknnkaisiymd);
            logger.debug(" △ 責任開始日設定 終了");
        }
    }
}
