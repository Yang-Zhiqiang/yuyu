package yuyu.common.hozen.haitou;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 配当 配当金計算（実額方式）
 */
public class KeisanDJitugaku extends BaseDCommon implements IKeisanD {

    BizCurrency haitoukin;

    private BizCurrency haitoukinShisaDrate = null;

    private BizCurrency haitoukinRisaDrate = null;

    private BizCurrency haitoukinHisaDrate = null;

    private BizCurrency haitoukinDyouVrate = null;

    private BizCurrency haitoukinKikenSrate = null;

    List<KeisanDInfoBean> keisanDInfoBeanList = new ArrayList<>();

    private List<KeisanDInfoBean> keisanDInfoBeanSisaDrateList = null;

    private List<KeisanDInfoBean> keisanDInfoBeanRisaDrateList = null;

    private List<KeisanDInfoBean> keisanDInfoBeanHisaDrateList = null;

    private List<KeisanDInfoBean> keisanDInfoBeanDyouVrateList = null;

    private List<KeisanDInfoBean> keisanDInfoBeanKikenSrateList = null;

    protected static BizCurrency ZEROYEN =BizCurrency.valueOf(0);

    @Inject
    protected static Logger logger;

    public KeisanDJitugaku() {
        super();
    }

    @Override
    public C_ErrorKbn exec(KeisanDBean pKeisanDBean) {

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            haitoukin = ZEROYEN;

            KeisanDInfoBean keisanDInfoBean = new KeisanDInfoBean();
            keisanDInfoBean.setHaitoukinYen(haitoukin);
            keisanDInfoBeanList.add(keisanDInfoBean);

            setRateDForKsn(pKeisanDBean.getKsnSiyouUmu());

            return C_ErrorKbn.OK;
        } finally {
            collectEntity(collectEntityFlg);
        }
    }

    void setRateDForKsn(C_UmuKbn pKsnSiyouUmu) {
        if(C_UmuKbn.ARI.eq(pKsnSiyouUmu)){

            haitoukinShisaDrate = ZEROYEN;
            haitoukinRisaDrate = ZEROYEN;
            haitoukinHisaDrate = ZEROYEN;
            haitoukinDyouVrate = ZEROYEN;
            haitoukinKikenSrate = ZEROYEN;

            keisanDInfoBeanSisaDrateList = new ArrayList<>();
            keisanDInfoBeanRisaDrateList = new ArrayList<>();
            keisanDInfoBeanHisaDrateList = new ArrayList<>();
            keisanDInfoBeanDyouVrateList = new ArrayList<>();
            keisanDInfoBeanKikenSrateList = new ArrayList<>();
        }
    }

    @Override
    public void log() {
        if (logger.isDebugEnabled()) {
            logger.debug("｜ ▽ 配当金計算結果");
            logger.debug("｜ ｜ 配当金                    ＝ " + haitoukin);
            logger.debug("｜ △");
        }
    }

    @Override
    public BizCurrency getD() {
        return haitoukin;
    }

    @Override
    public List<KeisanDInfoBean> getKeisanDInfoBeanList() {
        return keisanDInfoBeanList;
    }

    @Override
    public BizCurrency getDSisaDrate() {
        return haitoukinShisaDrate;
    }

    @Override
    public List<KeisanDInfoBean> getKeisanDInfoBeanSisaDrateList() {
        return keisanDInfoBeanSisaDrateList;
    }

    @Override
    public BizCurrency getDRisaDrate() {
        return haitoukinRisaDrate;
    }

    @Override
    public List<KeisanDInfoBean> getKeisanDInfoBeanRisaDrateList() {
        return keisanDInfoBeanRisaDrateList;
    }

    @Override
    public BizCurrency getDHisaDrate() {
        return haitoukinHisaDrate;
    }

    @Override
    public List<KeisanDInfoBean> getKeisanDInfoBeanHisaDrateList() {
        return keisanDInfoBeanHisaDrateList;
    }

    @Override
    public BizCurrency getDDyouVrate() {
        return haitoukinDyouVrate;
    }

    @Override
    public List<KeisanDInfoBean> getKeisanDInfoBeanDyouVrateList() {
        return keisanDInfoBeanDyouVrateList;
    }

    @Override
    public BizCurrency getDKikenSrate() {
        return haitoukinKikenSrate;
    }

    @Override
    public List<KeisanDInfoBean> getKeisanDInfoBeanKikenSrateList() {
        return keisanDInfoBeanKikenSrateList;
    }
}
