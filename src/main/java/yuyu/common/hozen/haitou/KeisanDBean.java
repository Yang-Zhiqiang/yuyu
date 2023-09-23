package yuyu.common.hozen.haitou;

import java.io.Serializable;
import java.util.List;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.hozen.haitou.SetDNnd.DRateSyutokuInfoBean;
import yuyu.common.hozen.haitou.SetDNnd.HaitouKaisuuBean;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 配当金計算Beanクラス
 */
public class KeisanDBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private DRateSyutokuInfoBean dRateSyutokuInfoBean;

    private C_Tuukasyu tuukasyu;

    private BizCurrency kihonS;

    private C_UmuKbn ksnSiyouUmu;

    private List<HaitouKaisuuBean> haitouKaisuuBeanList;

    public KeisanDBean() {
        super();
    }

    public DRateSyutokuInfoBean getDRateSyutokuInfoBean() {
        return dRateSyutokuInfoBean;
    }

    public void setDRateSyutokuInfoBean(DRateSyutokuInfoBean pDRateSyutokuInfoBean) {
        dRateSyutokuInfoBean = pDRateSyutokuInfoBean;
    }

    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    public BizCurrency getKihonS() {
        return kihonS;
    }

    public void setKihonS(BizCurrency pKihonS) {
        kihonS = pKihonS;
    }

    public C_UmuKbn getKsnSiyouUmu() {
        return ksnSiyouUmu;
    }

    public void setKsnSiyouUmu(C_UmuKbn pKsnSiyouUmu) {
        ksnSiyouUmu = pKsnSiyouUmu;
    }

    public List<HaitouKaisuuBean> getHaitouKaisuuBeanList() {
        return haitouKaisuuBeanList;
    }

    public void setHaitouKaisuuBeanList(List<HaitouKaisuuBean> pHaitouKaisuuBeanList) {
        haitouKaisuuBeanList = pHaitouKaisuuBeanList;
    }
}
