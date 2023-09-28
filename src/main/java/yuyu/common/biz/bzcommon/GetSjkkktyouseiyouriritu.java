package yuyu.common.biz.bzcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.dba4getsjkkktyouseiyouriritu.GetSjkkktyouseiyourirituDao;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu2;

/**
 * 業務共通 業務共通 市場価格調整用利率取得
 */
public class GetSjkkktyouseiyouriritu {

    private BizNumber sjkkktyouseiyouriritu;

    @Inject
    private static Logger logger;

    @Inject
    private GetSjkkktyouseiyourirituDao getSjkkktyouseiyourirituDao;

    public GetSjkkktyouseiyouriritu() {
        super();
    }

    public C_ErrorKbn exec(GetSjkkktyouseiyourirituBean pGetSjkkktyouseiyourirituBean) {

        logger.debug("▽ 市場価格調整用利率取得 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        sjkkktyouseiyouriritu = BizNumber.valueOf(0);

        int syohinHanteiKbn = SyouhinUtil.hantei(pGetSjkkktyouseiyourirituBean.getSyouhncd());

        String sjkkktyouseiriritutkybr1 = "";

        String sjkkktyouseiriritutkybr2 = "";

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            sjkkktyouseiriritutkybr1 = String.valueOf(pGetSjkkktyouseiyourirituBean.getHknkkn());

            sjkkktyouseiriritutkybr2 = "";
        }

        List<BM_SjkkkTyouseiyouRiritu2> sjkkkTyouseiyouRiritu2Lst =
            getSjkkktyouseiyourirituDao.getSjkkkTyouseiyouRiritus2ByPK
            (pGetSjkkktyouseiyourirituBean.getSyouhncd(), sjkkktyouseiriritutkybr1,
                sjkkktyouseiriritutkybr2, pGetSjkkktyouseiyourirituBean.getKijyunymd(),
                pGetSjkkktyouseiyourirituBean.getKijyunymd());

        if (sjkkkTyouseiyouRiritu2Lst.size() == 0) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 市場価格調整用利率取得 終了");

            return errorKbn;

        }

        sjkkktyouseiyouriritu = sjkkkTyouseiyouRiritu2Lst.get(0).getSjkkktyouseiyouriritu();

        errorKbn = C_ErrorKbn.OK;

        logger.debug("△ 市場価格調整用利率取得 終了");

        return errorKbn;
    }

    public C_ErrorKbn execMaxkjnymd(GetSjkkktyouseiyourirituBean pGetSjkkktyouseiyourirituBean) {

        logger.debug("▽ 市場価格調整用利率（最大基準日）取得 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        sjkkktyouseiyouriritu = BizNumber.valueOf(0);

        int syohinHanteiKbn = SyouhinUtil.hantei(pGetSjkkktyouseiyourirituBean.getSyouhncd());

        String sjkkktyouseiriritutkybr1 = "";

        String sjkkktyouseiriritutkybr2 = "";

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            sjkkktyouseiriritutkybr1 = String.valueOf(pGetSjkkktyouseiyourirituBean.getHknkkn());

            sjkkktyouseiriritutkybr2 = "";
        }

        List<BM_SjkkkTyouseiyouRiritu2> sjkkkTyouseiyouRiritu2Lst =
            getSjkkktyouseiyourirituDao.getSjkkkTyouseiyouRiritu2sBy3PKMaxKyktoymd
            (pGetSjkkktyouseiyourirituBean.getSyouhncd(), sjkkktyouseiriritutkybr1,
                sjkkktyouseiriritutkybr2);

        if (sjkkkTyouseiyouRiritu2Lst.size() == 0) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△市場価格調整用利率（最大基準日）取得 終了");

            return errorKbn;

        }

        sjkkktyouseiyouriritu = sjkkkTyouseiyouRiritu2Lst.get(0).getSjkkktyouseiyouriritu();

        errorKbn = C_ErrorKbn.OK;

        logger.debug("△ 市場価格調整用利率（最大基準日）取得 終了");

        return errorKbn;
    }

    public C_ErrorKbn execKykji(GetSjkkktyouseiyourirituBean pGetSjkkktyouseiyourirituBean) {

        logger.debug("▽ 契約時市場価格調整用利率取得処理 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        int syohinHanteiKbn = SyouhinUtil.hantei(pGetSjkkktyouseiyourirituBean.getSyouhncd());

        BizDate kijyunymd = null;

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            kijyunymd = pGetSjkkktyouseiyourirituBean.getSknnkaisiymd();

        } else {

            kijyunymd = pGetSjkkktyouseiyourirituBean.getKykymd();
        }

        pGetSjkkktyouseiyourirituBean.setKijyunymd(kijyunymd);

        errorKbn = exec(pGetSjkkktyouseiyourirituBean);

        logger.debug("△ 契約時市場価格調整用利率取得 終了");

        return errorKbn;
    }

    public BizNumber getSjkkktyouseiyouriritu() {

        return sjkkktyouseiyouriritu;
    }
}
