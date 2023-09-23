package yuyu.common.siharai.siview;

import java.util.List;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金支払共通UiBean設定UiBeanパラメータ(支払詳細設定（保険金）)
 */
public interface SiSetUiBeanSetHKTShrMeisaiUiBeanParam {

    HktshrMeisaisInfoDataSourceBeanCommonParam createHktshrMeisaisInfoDataSourceBean();

    void convertHktshrMeisaisInfoForCommonParam(List<HktshrMeisaisInfoDataSourceBeanCommonParam> pHktshrMeisaisInfo);

}