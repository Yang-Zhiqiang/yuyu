package yuyu.common.hozen.haitou;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.hozen.haitou.SetDNnd.DRateSyutokuInfoBean;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitouKeisanHousikiKbn;

/**
 * 契約保全 契約保全共通 配当金計算クラス
 */
public class KeisanD extends BaseDCommon {

    private IKeisanD iKeisanD;

    private DRateSyutokuInfoBean dRateSyutokuInfoBean;

    @Inject
    protected static Logger logger;

    public KeisanD() {
        super();
    }

    public C_ErrorKbn exec(KeisanDBean pKeisanDBean) {

        logger.debug("▽ 配当金計算 開始");

        clear();

        iKeisanD = null;
        dRateSyutokuInfoBean = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            iKeisanD = getIKeisandBySyouhnCd(pKeisanDBean.getDRateSyutokuInfoBean().getSyouhncd());

            C_ErrorKbn errorKbn = iKeisanD.exec(pKeisanDBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                setErrorLink(iKeisanD);
                return errorKbn;
            }

            iKeisanD.log();

            dRateSyutokuInfoBean = pKeisanDBean.getDRateSyutokuInfoBean();

            logger.debug("△ 配当金計算 終了");

            return errorKbn;

        } finally {
            collectEntity(collectEntityFlg);
        }
    }

    private IKeisanD getIKeisandBySyouhnCd(String pSyouhnCd) {

        SyouhinUtil syouhinUtil = SWAKInjector.getInstance(SyouhinUtil.class);
        C_HaitouKeisanHousikiKbn haitoukeisanhousikikbn = syouhinUtil.getHaitouKeisanHousikiKbn(pSyouhnCd);

        IKeisanD wkIKeisanD = null;

        if (C_HaitouKeisanHousikiKbn.RATE.eq(haitoukeisanhousikikbn)) {
            wkIKeisanD = getInjectInstance(KeisanDRate.class);
        } else if (C_HaitouKeisanHousikiKbn.JITUGAKU.eq(haitoukeisanhousikikbn)) {
            int hantei = SyouhinUtil.hantei(pSyouhnCd);

            if (hantei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                wkIKeisanD = getInjectInstance(KeisanDJitugaku.class);
            }
            else {
                wkIKeisanD = getInjectInstance(KeisanDKeikatukisuukouryo.class);
            }
        }
        return wkIKeisanD;
    }

    public BizCurrency getD() {
        if (iKeisanD == null) {
            return null;
        }
        return iKeisanD.getD();
    }

    public List<KeisanDInfoBean> getKeisanDInfoBeanList() {
        if (iKeisanD == null) {
            return null;
        }
        return iKeisanD.getKeisanDInfoBeanList();
    }

    public BizCurrency getDSisaDrate() {
        if (iKeisanD == null) {
            return null;
        }
        return iKeisanD.getDSisaDrate();
    }

    public List<KeisanDInfoBean> getKeisanDInfoBeanSisaDrateList() {
        if (iKeisanD == null) {
            return null;
        }
        return iKeisanD.getKeisanDInfoBeanSisaDrateList();
    }

    public BizCurrency getDRisaDrate() {
        if (iKeisanD == null) {
            return null;
        }
        return iKeisanD.getDRisaDrate();
    }

    public List<KeisanDInfoBean> getKeisanDInfoBeanRisaDrateList() {
        if (iKeisanD == null) {
            return null;
        }
        return iKeisanD.getKeisanDInfoBeanRisaDrateList();
    }

    public BizCurrency getDHisaDrate() {
        if (iKeisanD == null) {
            return null;
        }
        return iKeisanD.getDHisaDrate();
    }

    public List<KeisanDInfoBean> getKeisanDInfoBeanHisaDrateList() {
        if (iKeisanD == null) {
            return null;
        }
        return iKeisanD.getKeisanDInfoBeanHisaDrateList();
    }

    public BizCurrency getDDyouVrate() {
        if (iKeisanD == null) {
            return null;
        }
        return iKeisanD.getDDyouVrate();
    }

    public List<KeisanDInfoBean> getKeisanDInfoBeanDyouVrateList() {
        if (iKeisanD == null) {
            return null;
        }
        return iKeisanD.getKeisanDInfoBeanDyouVrateList();
    }

    public BizCurrency getDKikenSrate() {
        if (iKeisanD == null) {
            return null;
        }
        return iKeisanD.getDKikenSrate();
    }

    public List<KeisanDInfoBean> getKeisanDInfoBeanKikenSrateList() {
        if (iKeisanD == null) {
            return null;
        }
        return iKeisanD.getKeisanDInfoBeanKikenSrateList();
    }

    public DRateSyutokuInfoBean getDRateSyutokuInfoBean() {
        return dRateSyutokuInfoBean;
    }

}