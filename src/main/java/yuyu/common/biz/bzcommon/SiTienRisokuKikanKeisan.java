package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_YmdkeisikiKbn;


/**
 * 業務共通 共通 遅延利息期間計算クラス
 */
public class SiTienRisokuKikanKeisan {

    private static final int[] TUKIZUEHISUUS = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int endYmd_Nensuu;
    private int endYmd_Tukisuu;
    private int endYmd_Hisuu;
    private int startYmd_Nensuu;
    private int startYmd_Tukisuu;
    private int startYmd_Hisuu;

    @Inject
    private static Logger logger;

    public SiTienRisokuKikanKeisan() {
        super();
    }

    public void exec(SiTienRisokuKikanKeisanBean pSiTienRisokuKikanKeisanBean){

        logger.debug("▽ 遅延利息期間計算 開始");


        String endYmdtmp = pSiTienRisokuKikanKeisanBean.getEndYmd();
        String startYmdtmp = pSiTienRisokuKikanKeisanBean.getStartYmd();

        if (BizUtil.isBlank(endYmdtmp)) {

            throw new BizLogicException(MessageId.EBS1007, "遅延利息終了年月日");
        }
        if (BizUtil.isBlank(startYmdtmp)) {

            throw new BizLogicException(MessageId.EBS1007, "遅延利息開始年月日");
        }

        if (C_YmdkeisikiKbn.YYYYMMDD.eq(pSiTienRisokuKikanKeisanBean.getYmdkeisikiKbn())) {

            BizDate bdEndYmd = BizDate.valueOf(endYmdtmp);
            BizDate bdStartYmd = BizDate.valueOf(startYmdtmp);

            if (bdEndYmd.compareTo(bdStartYmd) < 0) {

                throw new BizLogicException(MessageId.EBA1029, "遅延利息開始年月日", "遅延利息終了年月日");
            }
        }

        else if (C_YmdkeisikiKbn.YYYYMM.eq(pSiTienRisokuKikanKeisanBean.getYmdkeisikiKbn())) {

            BizDateYM bdEndYm = BizDateYM.valueOf(endYmdtmp);
            BizDateYM bdStartYm = BizDateYM.valueOf(startYmdtmp);

            if (bdEndYm.compareTo(bdStartYm) < 0) {

                throw new BizLogicException(MessageId.EBA1029, "遅延利息開始年月日", "遅延利息終了年月日");
            }
        }

        else {

            throw new BizLogicException(MessageId.EBS1007, "遅延利息年月日形式区分");
        }


        int kikan_ddddd = 0;
        int kikan_ddd = 0;
        int kikan_nen = 0;

        endYmd_Nensuu = Integer.parseInt(endYmdtmp.substring(0,4));
        endYmd_Tukisuu = Integer.parseInt(endYmdtmp.substring(4,6));
        startYmd_Nensuu = Integer.parseInt(startYmdtmp.substring(0,4));
        startYmd_Tukisuu = Integer.parseInt(startYmdtmp.substring(4,6));

        if (C_YmdkeisikiKbn.YYYYMM.eq(pSiTienRisokuKikanKeisanBean.getYmdkeisikiKbn())) {

            endYmd_Hisuu = 1;
            startYmd_Hisuu = 1;

            int nensuu = endYmd_Nensuu;

            if (endYmd_Tukisuu < startYmd_Tukisuu) {

                nensuu = nensuu - 1;
            }

            kikan_nen = nensuu - startYmd_Nensuu;

            kikan_ddddd = calcKikanNissuu();

            endYmd_Nensuu = Integer.parseInt(endYmdtmp.substring(0,4));
            endYmd_Tukisuu = Integer.parseInt(endYmdtmp.substring(4,6));
            endYmd_Hisuu = 1;
            startYmd_Nensuu = Integer.parseInt(startYmdtmp.substring(0,4));
            startYmd_Tukisuu = Integer.parseInt(startYmdtmp.substring(4,6));
            startYmd_Hisuu = 1;


            startYmd_Nensuu = startYmd_Nensuu + kikan_nen;
            kikan_ddd = calcKikanNissuu();
        }
        else {

            endYmd_Hisuu = Integer.parseInt(endYmdtmp.substring(6,8));
            startYmd_Hisuu = Integer.parseInt(startYmdtmp.substring(6,8));

            int hisuu = 0;
            int kikan_tuki = 0;

            int totalEndYmdTukisuu = endYmd_Nensuu * 12 + endYmd_Tukisuu;
            int totalStartYmdTukisuu = startYmd_Nensuu * 12 + startYmd_Tukisuu;

            kikan_tuki = totalEndYmdTukisuu - totalStartYmdTukisuu;

            if (endYmd_Tukisuu == 2) {

                if (endYmd_Nensuu % 4 != 0) {

                    hisuu = 28;
                }
                else if (endYmd_Nensuu % 100 != 0) {

                    hisuu = 29;
                }
                else if (endYmd_Nensuu % 400 != 0) {

                    hisuu = 28;
                }
                else {

                    hisuu = 29;
                }
            }
            else {

                hisuu = TUKIZUEHISUUS[endYmd_Tukisuu - 1];
            }

            int maxHisuu = 0;
            if (startYmd_Hisuu > hisuu) {

                maxHisuu = hisuu;
            }
            else {
                maxHisuu = startYmd_Hisuu;
            }

            if (maxHisuu > endYmd_Hisuu) {

                kikan_tuki = kikan_tuki - 1;
            }

            kikan_nen = kikan_tuki / 12;

            kikan_ddddd = calcKikanNissuu();

            endYmd_Nensuu = Integer.parseInt(endYmdtmp.substring(0,4));
            endYmd_Tukisuu = Integer.parseInt(endYmdtmp.substring(4,6));
            endYmd_Hisuu = Integer.parseInt(endYmdtmp.substring(6,8));
            startYmd_Nensuu = Integer.parseInt(startYmdtmp.substring(0,4));
            startYmd_Tukisuu = Integer.parseInt(startYmdtmp.substring(4,6));
            startYmd_Hisuu = Integer.parseInt(startYmdtmp.substring(6,8));

            startYmd_Nensuu = startYmd_Nensuu + kikan_nen;

            if (startYmd_Tukisuu == 2) {

                if (startYmd_Nensuu % 4 != 0) {

                    hisuu = 28;
                }
                else if (startYmd_Nensuu % 100 != 0) {

                    hisuu = 29;
                }
                else if (startYmd_Nensuu % 400 != 0) {

                    hisuu = 28;
                }
                else {

                    hisuu = 29;
                }
                if (startYmd_Hisuu > hisuu) {

                    startYmd_Hisuu = hisuu;
                }
            }
            kikan_ddd = calcKikanNissuu();
        }

        pSiTienRisokuKikanKeisanBean.setKikan_ddddd(BizNumber.valueOf(kikan_ddddd));
        pSiTienRisokuKikanKeisanBean.setKikan_yy(BizNumber.valueOf(kikan_nen));
        pSiTienRisokuKikanKeisanBean.setKikan_ddd(BizNumber.valueOf(kikan_ddd));

        logger.debug("△ 遅延利息期間計算 終了");
    }

    private int calcKikanNissuu(){

        int endYmdHisuu = 0;
        int startYmdHisuu = 0;
        int kikanHisuu = 0;

        if (endYmd_Tukisuu == 1) {

            endYmd_Nensuu = endYmd_Nensuu - 1;
            endYmd_Tukisuu = 13;
        }
        else if (endYmd_Tukisuu == 2){

            endYmd_Nensuu = endYmd_Nensuu - 1;
            endYmd_Tukisuu = 14;
        }

        int endYmdFx1 = (int)(365.25 * endYmd_Nensuu);
        int endYmdFx2 = endYmd_Nensuu/400;
        int endYmdFx3 = endYmd_Nensuu/100;
        int endYmdFx4 = (int)(30.59 * (endYmd_Tukisuu - 2));

        endYmdHisuu = (int)(endYmdFx1 + endYmdFx2 -endYmdFx3 + endYmdFx4 + endYmd_Hisuu + 1721088.5);

        if (startYmd_Tukisuu == 1) {

            startYmd_Nensuu = startYmd_Nensuu - 1;
            startYmd_Tukisuu = 13;
        }
        else if (startYmd_Tukisuu == 2){

            startYmd_Nensuu = startYmd_Nensuu - 1;
            startYmd_Tukisuu = 14;
        }

        int startYmdFx1 = (int)(365.25 * startYmd_Nensuu);
        int startYmdFx2 = startYmd_Nensuu / 400;
        int startYmdFx3 = startYmd_Nensuu / 100;
        int startYmdFx4 = (int)(30.59 * (startYmd_Tukisuu - 2));

        startYmdHisuu = (int)(startYmdFx1 + startYmdFx2 -startYmdFx3 + startYmdFx4 + startYmd_Hisuu + 1721088.5);

        kikanHisuu = endYmdHisuu - startYmdHisuu;

        return kikanHisuu;
    }

}
