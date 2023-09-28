package yuyu.common.biz.bzcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_BunsyoSyubetuKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.db.entity.BM_BunsyonoSettei;

/**
 * 業務共通 共通 文書番号取得
 */
public class GetBunsyoNo {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    private C_Channelcd channelCd;

    private String oyadrtenCd;

    private String yakkanbunsyoNo;

    private String sioriNo;

    public GetBunsyoNo() {
        super();
    }

    public GetBunsyoNoOutBean execGetYakkanBunsyoNo(C_AisyoumeiKbn pAisyoumeiKbn, C_Channelcd pChannelcd, String pOyadrtenCd,
        BizDate pMosYmd) {

        logger.debug("▽ 文書番号取得 開始");

        if (pAisyoumeiKbn == null || C_AisyoumeiKbn.BLNK.eq(pAisyoumeiKbn) ||
            pMosYmd == null) {

            throw new CommonBizAppException("パラメーター不正");
        }
        GetBunsyoNoOutBean getBunsyoNoOutBean = new GetBunsyoNoOutBean();

        getBunsyoNoOutBean.setYakkanbunsyoNo("");

        getBunsyoNoOutBean.setSioriNo("");

        if (BizUtil.isBlank(pOyadrtenCd)) {

            return getBunsyoNoOutBean;
        }

        boolean result = getChannelcd(pChannelcd, pOyadrtenCd);

        if (!result) {

            return getBunsyoNoOutBean;
        }

        getBunsyoNo(C_BunsyoSyubetuKbn.SIORIYAKKAN, pAisyoumeiKbn, channelCd, pMosYmd);

        getBunsyoNoOutBean.setYakkanbunsyoNo(yakkanbunsyoNo);

        getBunsyoNoOutBean.setSioriNo(sioriNo);

        logger.debug("△ 文書番号取得 終了");

        return getBunsyoNoOutBean;
    }

    private boolean getChannelcd(C_Channelcd pChannelcd, String pOyadrtenCd) {

        channelCd = C_Channelcd.BLNK;
        oyadrtenCd = "";

        if (pChannelcd == null) {

            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(pOyadrtenCd);

            if (bzGetAgInfoBeanLst == null || bzGetAgInfoBeanLst.size() == 0) {

                return false;
            }

            for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {

                if (C_DiritenjyouhouKbn.SHITEIOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                    channelCd = bzGetAgInfoBean.getChannelCd();
                    oyadrtenCd = bzGetAgInfoBean.getOyadrtenCd();

                    break;
                }
            }
        }
        else {

            channelCd = pChannelcd;
            oyadrtenCd = pOyadrtenCd;
        }
        return true;
    }

    private void getBunsyoNo(C_BunsyoSyubetuKbn pBunsyoSyubetuKbn, C_AisyoumeiKbn pAisyoumeiKbn,
        C_Channelcd pChannelcd, BizDate pTekiyouYmd) {

        yakkanbunsyoNo = "";

        sioriNo = "";

        List<BM_BunsyonoSettei> bunsyonoSetteiLst = bizDomManager.getBunsyonoSetteiByBnsysybtkbnAisyoumeikbnChannelcdTkyuymd(
            pBunsyoSyubetuKbn, pAisyoumeiKbn, pChannelcd, pTekiyouYmd);

        if (bunsyonoSetteiLst == null || bunsyonoSetteiLst.size() == 0) {

        }
        else {

            for (BM_BunsyonoSettei bunsyonoSettei : bunsyonoSetteiLst) {

                if (oyadrtenCd.equals(bunsyonoSettei.getOyadrtencd())) {

                    yakkanbunsyoNo = bunsyonoSettei.getBunsyono();
                    sioriNo = bunsyonoSettei.getSiorino();
                    break;
                }

                if ("9999999".equals(bunsyonoSettei.getOyadrtencd())) {

                    yakkanbunsyoNo = bunsyonoSettei.getBunsyono();
                    sioriNo = bunsyonoSettei.getSiorino();
                }
            }
        }
    }
}
