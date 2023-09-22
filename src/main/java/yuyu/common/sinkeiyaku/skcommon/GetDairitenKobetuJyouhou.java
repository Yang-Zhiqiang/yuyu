package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 新契約共通 代理店個別情報取得
 */
public class GetDairitenKobetuJyouhou {

    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public GetDairitenKobetuJyouhouBean exec(String pOyadrtenCd, C_MosUketukeKbn pMosUketukeKbn) {

        logger.debug("▽ 代理店個別情報取得 開始");

        GetDairitenKobetuJyouhouBean getDairitenKobetuJyouhouBean = SWAKInjector.getInstance(GetDairitenKobetuJyouhouBean.class);

        if (BizUtil.isBlank(pOyadrtenCd) || pMosUketukeKbn == null) {

            getDairitenKobetuJyouhouBean.setErrorKbn(C_ErrorKbn.ERROR);

            logger.debug("△ 代理店個別情報取得 終了");

            return getDairitenKobetuJyouhouBean;
        }

        HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou = sinkeiyakuDomManager.getSkDairitenKobetuJyouhou(pOyadrtenCd);

        if (skDairitenKobetuJyouhou != null) {
            getDairitenKobetuJyouhouBean.setErrorKbn(C_ErrorKbn.OK);
            getDairitenKobetuJyouhouBean.setCifCdCheckYouhi(skDairitenKobetuJyouhou.getCifcdcheckyouhi());

            if (BizUtil.isBlank(skDairitenKobetuJyouhou.getCifcdsiteiketasuu())) {
                getDairitenKobetuJyouhouBean.setCifCdSiteiKetasuu(null);
            }
            else {

                if (C_MosUketukeKbn.PAPERLESS.eq(pMosUketukeKbn)) {
                    if (YuyuBizConfig.getInstance().getSmtbOyadrtencd().equals(pOyadrtenCd)) {
                        getDairitenKobetuJyouhouBean.setCifCdSiteiKetasuu(14);
                    }
                    else if (YuyuSinkeiyakuConfig.getInstance().getSmbcnikkousyouken().equals(pOyadrtenCd)) {
                        getDairitenKobetuJyouhouBean.setCifCdSiteiKetasuu(15);
                    }
                    else {
                        getDairitenKobetuJyouhouBean.setCifCdSiteiKetasuu(Integer.valueOf(skDairitenKobetuJyouhou.getCifcdsiteiketasuu()));
                    }
                }
                else {
                    getDairitenKobetuJyouhouBean.setCifCdSiteiKetasuu(Integer.valueOf(skDairitenKobetuJyouhou.getCifcdsiteiketasuu()));
                }
            }

            getDairitenKobetuJyouhouBean.setCifCdMaezeroumeYouhi(skDairitenKobetuJyouhou.getCifcdmaezeroumeyouhi());
        }
        else {
            getDairitenKobetuJyouhouBean.setErrorKbn(C_ErrorKbn.ERROR);
        }

        logger.debug("△ 代理店個別情報取得 終了");

        return getDairitenKobetuJyouhouBean;
    }
}