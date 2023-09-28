package yuyu.common.biz.bzcommon;

import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.dba4getyoteiriritu.GetYoteirirituDao;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu3;

/**
 * 業務共通 業務共通 予定利率取得クラス
 */
public class GetYoteiriritu {

    private BizNumber yoteiriritu;

    private BizNumber tumitateriritu;

    private BizNumber tmttknzoukaritujygn;

    private BizNumber setteibairitu;

    private BizNumber loadinghnkgtumitateriritu;

    private BizNumber rendouRitu;

    @Inject
    private static Logger logger;

    @Inject
    private GetYoteirirituDao getYoteirirituDao;

    public GetYoteiriritu() {
        super();
    }

    public C_ErrorKbn exec(GetYoteirirituBean pGetYoteirirituBean) {

        logger.debug("▽ 予定利率取得 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        yoteiriritu = BizNumber.valueOf(0);
        tumitateriritu = BizNumber.valueOf(0);
        tmttknzoukaritujygn = BizNumber.valueOf(0);
        setteibairitu = BizNumber.valueOf(0);
        loadinghnkgtumitateriritu = BizNumber.valueOf(0);
        rendouRitu = BizNumber.valueOf(0);

        int syohinHanteiKbn = SyouhinUtil.hantei(pGetYoteirirituBean.getSyouhncd());

        int henkouKubetuSyohinHanteiKbn = SyouhinUtil.henkouKubetuHantei(pGetYoteirirituBean.getSyouhncd());

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
            syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 ||
            syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ) {

            errorKbn = setYoteirirituForItiji(pGetYoteirirituBean, henkouKubetuSyohinHanteiKbn);
        }
        else if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ) {

            errorKbn = setYoteirirituForHeijyun(pGetYoteirirituBean);
        }
        else {

            errorKbn = setYoteirirituForHeijyun2(pGetYoteirirituBean);
        }

        logger.debug("△ 予定利率取得 終了");

        return errorKbn;
    }

    private C_ErrorKbn setYoteirirituForItiji(GetYoteirirituBean pGetYoteirirituBean, int pHenkouKubetuSyohinHanteiKbn) {

        String yoteirirituTekBunrui1 = "";
        String yoteirirituTekBunrui2 = "";
        BizDate kijyunymd = null;
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pHenkouKubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUGO ||
            pHenkouKubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUGO) {

            kijyunymd = pGetYoteirirituBean.getSknnkaisiymd();
        }
        else if (pHenkouKubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUMAE ||
            pHenkouKubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_YENHENKOUMAE ){

            yoteirirituTekBunrui1 = String.valueOf(pGetYoteirirituBean.getHknkkn());
            kijyunymd = pGetYoteirirituBean.getSknnkaisiymd();
        }
        else {

            kijyunymd = pGetYoteirirituBean.getKykymd();
        }

        List<BM_YoteiRiritu3> yoteiRiritu3Lst =
            getYoteirirituDao.getYoteiRiritus3BySyouhncdYoteiriritutkybr1Yoteiriritutkybr2KijyunfromymdKijyuntoymd(
                pGetYoteirirituBean.getSyouhncd(), yoteirirituTekBunrui1,
                yoteirirituTekBunrui2, kijyunymd, kijyunymd);

        if (yoteiRiritu3Lst.size() == 0) {

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        yoteiriritu = yoteiRiritu3Lst.get(0).getYoteiriritu();

        tumitateriritu = yoteiRiritu3Lst.get(0).getTumitateriritu();

        tmttknzoukaritujygn = yoteiRiritu3Lst.get(0).getTmttknzoukaritujygn();

        setteibairitu = yoteiRiritu3Lst.get(0).getSetteibairitu();

        loadinghnkgtumitateriritu = yoteiRiritu3Lst.get(0).getLoadinghnkgtumitateriritu();

        rendouRitu = yoteiRiritu3Lst.get(0).getRendouritu();

        errorKbn = C_ErrorKbn.OK;

        return errorKbn;
    }

    private C_ErrorKbn setYoteirirituForHeijyun(GetYoteirirituBean pGetYoteirirituBean) {

        String yoteirirituTekBunrui1 = "";
        String yoteirirituTekBunrui2 = "";
        BizDate kijyunfromymd = null;
        BizDate calckijyunymd = null;
        BizNumber yoteirirituTemp = BizNumber.valueOf(0);
        BizNumber yoteirirituSum = BizNumber.valueOf(0);
        int calcTaisyouGetusuu = 0;
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        calckijyunymd = pGetYoteirirituBean.getKijyunymd().getBizDateYM().getFirstDay();
        kijyunfromymd = pGetYoteirirituBean.getKykymd();
        calcTaisyouGetusuu = BizDateUtil.calcDifferenceMonths(pGetYoteirirituBean.getKijyunymd().getBizDateYM(),
            pGetYoteirirituBean.getKykymd().getBizDateYM()) + 1;

        if (calcTaisyouGetusuu > 120) {

            kijyunfromymd = calckijyunymd.addMonths(-120).addMonths(1);
            calcTaisyouGetusuu = 120;
        }

        yoteirirituSum = getYoteirirituDao.getYoteiRiritu3SumSyouhncdYoteiriritutkybr1Yoteiriritutkybr2Kijyunfromymd(
            pGetYoteirirituBean.getSyouhncd(), yoteirirituTekBunrui1, yoteirirituTekBunrui2, kijyunfromymd, calckijyunymd);

        if(yoteirirituSum == null) {

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        yoteirirituTemp = yoteirirituSum.divide(calcTaisyouGetusuu, 4, RoundingMode.HALF_UP);

        if (yoteirirituTemp.compareTo(pGetYoteirirituBean.getSitihsyuriritu()) < 0) {
            yoteirirituTemp = pGetYoteirirituBean.getSitihsyuriritu();
        }

        yoteiriritu = yoteirirituTemp;

        errorKbn = C_ErrorKbn.OK;

        return errorKbn;
    }

    private C_ErrorKbn setYoteirirituForHeijyun2(GetYoteirirituBean pGetYoteirirituBean) {

        String yoteirirituTekBunrui1 = "";
        String yoteirirituTekBunrui2 = "";
        BizDate kijyunymd = null;
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        C_Tuukasyu tuukasyu = pGetYoteirirituBean.getTuukasyu();
        kijyunymd = pGetYoteirirituBean.getKykymd();

        List<BM_YoteiRiritu3> yoteiRiritu3Lst =
            getYoteirirituDao.getYoteiRiritus3BySyouhncdTuukasyuYoteiriritutkybr1Yoteiriritutkybr2KijyunfromymdKijyuntoymd(
                pGetYoteirirituBean.getSyouhncd(), tuukasyu, yoteirirituTekBunrui1, yoteirirituTekBunrui2, kijyunymd, kijyunymd);

        if (yoteiRiritu3Lst.size() == 0) {

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        yoteiriritu = yoteiRiritu3Lst.get(0).getYoteiriritu();

        tumitateriritu = yoteiRiritu3Lst.get(0).getTumitateriritu();

        tmttknzoukaritujygn = yoteiRiritu3Lst.get(0).getTmttknzoukaritujygn();

        setteibairitu = yoteiRiritu3Lst.get(0).getSetteibairitu();

        loadinghnkgtumitateriritu = yoteiRiritu3Lst.get(0).getLoadinghnkgtumitateriritu();

        rendouRitu = yoteiRiritu3Lst.get(0).getRendouritu();

        errorKbn = C_ErrorKbn.OK;

        return errorKbn;
    }

    public BizNumber getYoteiriritu() {

        return yoteiriritu;
    }

    public BizNumber getTumitateriritu() {

        return tumitateriritu;
    }

    public BizNumber getTmttknzoukaritujygn() {

        return tmttknzoukaritujygn;
    }

    public BizNumber getSetteibairitu() {

        return setteibairitu;
    }

    public BizNumber getLoadinghnkgtumitateriritu() {

        return loadinghnkgtumitateriritu;
    }

    public BizNumber getRendouritu() {

        return rendouRitu;
    }
}
