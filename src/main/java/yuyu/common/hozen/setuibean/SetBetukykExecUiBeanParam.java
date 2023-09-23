package yuyu.common.hozen.setuibean;

import java.util.List;

/**
 * 契約保全 UiBean設定 別契約情報設定UiBeanパラメータインターフェース
 */
public interface SetBetukykExecUiBeanParam {

    String getSyono();

    public void setWarningMessageIdList(List<String> pWarningMessageIdList);

    public void setWarningMessageList(List<String> pWarningMessageList);

    KikeiyakuInfoDataSourceBeanCommonParam createKikeiyakuInfoDataSourceBean();

    void convertKikeiyakuInfoForCommonParam(List<KikeiyakuInfoDataSourceBeanCommonParam> pKikeiyakuInfo);

    NenkinsiharaiInfoDataSourceBeanCommonParam createNenkinsiharaiInfoDataSourceBean();

    void convertNenkinsiharaiInfoForCommonParam(List<NenkinsiharaiInfoDataSourceBeanCommonParam> pNenkinsiharaiInfo);

    PalkikeiyakuInfoDataSourceBeanCommonParam createPalkikeiyakuInfoDataSourceBean();

    void convertPalkikeiyakuInfoForCommonParam
    (List<PalkikeiyakuInfoDataSourceBeanCommonParam> pPalNenkinsiharaiInfo);

    PalNenkinsiharaiInfoDataSourceBeanCommonParam createPalNenkinsiharaiInfoDataSourceBean();

    void convertPalNenkinsiharaiInfoForCommonParam
    (List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> pPalNenkinsiharaiInfo);

    PalsueokiInfoDataSourceBeanCommonParam createPalsueokiInfoDataSourceBean();

    void convertPalsueokiInfoForCommonParam(List<PalsueokiInfoDataSourceBeanCommonParam> pPalsueokiInfo);

}
