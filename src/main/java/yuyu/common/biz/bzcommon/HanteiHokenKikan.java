package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HknkknBunruiKbn;

/**
 * 業務共通 共通 保険期間判定クラス
 */
public class HanteiHokenKikan {

    private BizDate dai2HknkknStartYmd = null;

    private BizDate dai3HknkknStartYmd = null;

    @Inject
    private static Logger logger;

    public HanteiHokenKikan() {
        super();
    }

    public C_HknKknKbn exec(HanteiHokenKikanBean pHanteiHokenKikanBean) {

        logger.debug("▽ 保険期間判定 開始");

        C_HknKknKbn hknKknKbn = C_HknKknKbn.BLNK;


        if (pHanteiHokenKikanBean.getKykYmd() == null
            || pHanteiHokenKikanBean.getCalcKijyunYmd() == null
            || pHanteiHokenKikanBean.getSyouhnZokusei() == null) {

            logger.debug("△ 保険期間判定 終了");

            return hknKknKbn;
        }

        if (C_HknkknBunruiKbn.NONE.eq(pHanteiHokenKikanBean.getSyouhnZokusei().getHknkknbunruikbn())) {

            logger.debug("△ 保険期間判定 終了");

            return hknKknKbn;
        }

        if (BizDateUtil.compareYmd(pHanteiHokenKikanBean.getKykYmd(),
            pHanteiHokenKikanBean.getCalcKijyunYmd()) == BizDateUtil.COMPARE_GREATER) {

            logger.debug("△ 保険期間判定 終了");

            return hknKknKbn;
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(pHanteiHokenKikanBean.getSyouhnZokusei().getSyouhncd());

        BizDate dai2HknKknStartYmd = getStartYmd(pHanteiHokenKikanBean.getKykYmd(),
            pHanteiHokenKikanBean.getDai1hknkkn(),
            syohinHanteiKbn);


        BizDate dai3HknKknStartYmd = null;

        if (C_HknkknBunruiKbn.THIRD.eq(pHanteiHokenKikanBean.getSyouhnZokusei().getHknkknbunruikbn())) {

            dai3HknKknStartYmd = getStartYmd(pHanteiHokenKikanBean.getKykYmd(),
                pHanteiHokenKikanBean.getSyouhnZokusei().getMvatekikkn(),
                syohinHanteiKbn);

            if (BizDateUtil.compareYmd(pHanteiHokenKikanBean.getCalcKijyunYmd(),
                dai2HknKknStartYmd) == BizDateUtil.COMPARE_LESSER) {
                hknKknKbn = C_HknKknKbn.DAI1HKNKKN;
            }
            else {
                if (BizDateUtil.compareYmd(pHanteiHokenKikanBean.getCalcKijyunYmd(),
                    dai3HknKknStartYmd) == BizDateUtil.COMPARE_LESSER) {
                    hknKknKbn = C_HknKknKbn.DAI2HKNKKN;
                }
                else {
                    hknKknKbn = C_HknKknKbn.DAI3HKNKKN;
                }
            }
        } else if (C_HknkknBunruiKbn.SECOND.eq(pHanteiHokenKikanBean.getSyouhnZokusei().getHknkknbunruikbn())) {

            if (BizDateUtil.compareYmd(pHanteiHokenKikanBean.getCalcKijyunYmd(),
                dai2HknKknStartYmd) == BizDateUtil.COMPARE_LESSER) {
                hknKknKbn = C_HknKknKbn.DAI1HKNKKN;
            } else {
                hknKknKbn = C_HknKknKbn.DAI2HKNKKN;
            }
        }

        dai2HknkknStartYmd = dai2HknKknStartYmd;
        dai3HknkknStartYmd = dai3HknKknStartYmd;

        logger.debug("△ 保険期間判定 終了");

        return hknKknKbn;
    }

    public BizDate getDai2HknkknStartYmd() {
        return dai2HknkknStartYmd;
    }

    public BizDate getDai3HknkknStartYmd() {
        return dai3HknkknStartYmd;
    }

    private BizDate getStartYmd(BizDate pKykYmd,int pKikanY, int pSyohinHanteiKbn){

        if (pSyohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            return  BizDate.valueOf(
                pKykYmd.getBizDateY().addYears(pKikanY),
                pKykYmd.getBizDateMD())
                .getRekijyou();
        }
        return BizDateUtil.getDateAfterPeriod(pKykYmd, pKikanY, 0);

    }
}
