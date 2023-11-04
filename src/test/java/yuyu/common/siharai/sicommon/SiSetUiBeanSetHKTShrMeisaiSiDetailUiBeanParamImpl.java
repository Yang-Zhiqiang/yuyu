package yuyu.common.siharai.sicommon;

import java.util.ArrayList;
import java.util.List;

import yuyu.common.siharai.siview.HktshrMeisaisInfoDataSourceBeanCommonParam;
import yuyu.common.siharai.siview.SiSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParam;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金支払共通UiBean設定UiBeanパラメータ(支払詳細設定（保険金）)実現クラス
 */
public class SiSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParamImpl implements SiSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParam{

    List<HktshrMeisaisInfoDataSourceBeanCommonParamImpl> hktshrMeisaisInfo;

    @Override
    public HktshrMeisaisInfoDataSourceBeanCommonParam createHktshrMeisaisInfoDataSourceBean() {
        return new HktshrMeisaisInfoDataSourceBeanCommonParamImpl();

    }

    public List<HktshrMeisaisInfoDataSourceBeanCommonParamImpl> getHktshrMeisaisInfo() {
        return hktshrMeisaisInfo;
    }

    @Override public void convertHktshrMeisaisInfoForCommonParam(List<HktshrMeisaisInfoDataSourceBeanCommonParam> phktshrMeisaisInfo) {
        List<HktshrMeisaisInfoDataSourceBeanCommonParamImpl> bSBCParamLst = new ArrayList<>();
        for (HktshrMeisaisInfoDataSourceBeanCommonParam beanCommonParam : phktshrMeisaisInfo) {
            bSBCParamLst.add((HktshrMeisaisInfoDataSourceBeanCommonParamImpl)beanCommonParam);
        }

        hktshrMeisaisInfo = bSBCParamLst;
    }
}
