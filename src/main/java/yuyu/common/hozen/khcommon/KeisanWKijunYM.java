package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;

/**
 * 契約保全 契約保全共通 解約返戻金計算基準年月設定クラス
 */
public class KeisanWKijunYM {

    @Inject
    private static Logger logger;

    public KeisanWKijunYM() {
        super();
    }

    public BizDateYM exec(BizDate pKeiyakuYMD, BizDate pCalcKijyunYMD, BizDateYM pJikaipjutoYM,
        C_Hrkkaisuu pHrkkaisuu, C_Kykjyoutai pKykjyoutai, String pSyouhnCd, BizDate pYendthnkYmd) {

        logger.debug("▽ 解約返戻金計算基準年月設定 開始");

        int kykDay = pKeiyakuYMD.getDay();

        BizDateYM kisnKijyunYM = pCalcKijyunYMD.getBizDateYM();

        int kisnKijyunDay = pCalcKijyunYMD.getDay();

        BizDateYM kaiyakuhrKisnKijyunYM = null;

        int hannteiDay = 0;

        if (C_Kykjyoutai.ITIJIBARAI.eq(pKykjyoutai)) {

            if ((SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR  == SyouhinUtil.hantei(pSyouhnCd) ||
                SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19  == SyouhinUtil.hantei(pSyouhnCd))
                && pYendthnkYmd != null) {
                hannteiDay = pYendthnkYmd.getDay();
            }
            else {
                hannteiDay = kykDay;
            }
            if (kisnKijyunDay >= hannteiDay) {

                if ((kisnKijyunDay - hannteiDay) >= 15) {

                    kaiyakuhrKisnKijyunYM = kisnKijyunYM.getNextMonth();
                }
                else {

                    kaiyakuhrKisnKijyunYM = kisnKijyunYM;
                }
            }
            else {
                if ((hannteiDay - kisnKijyunDay) > 15) {

                    kaiyakuhrKisnKijyunYM = kisnKijyunYM.getPreviousMonth();
                }
                else {

                    kaiyakuhrKisnKijyunYM = kisnKijyunYM;
                }
            }

        }
        else {
            if (BizDateUtil.compareYm(kisnKijyunYM, pJikaipjutoYM) == BizDateUtil.COMPARE_GREATER  ||
                BizDateUtil.compareYm(kisnKijyunYM, pJikaipjutoYM) == BizDateUtil.COMPARE_EQUAL) {

                kaiyakuhrKisnKijyunYM = pJikaipjutoYM;
            }
            else {
                if (kisnKijyunDay >= kykDay) {

                    kaiyakuhrKisnKijyunYM = kisnKijyunYM.addMonths(1);
                }
                else {
                    kaiyakuhrKisnKijyunYM = kisnKijyunYM;
                }
            }
        }

        logger.debug("△ 解約返戻金計算基準年月設定 終了");

        return kaiyakuhrKisnKijyunYM;
    }
}