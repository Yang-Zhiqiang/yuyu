package yuyu.common.hozen.setuibean;

import java.util.List;

/**
 * 契約保全 UiBean設定 別契約情報設定UiBeanパラメータ
 */
public class SetBetukykExecUiBeanParamImpl implements SetBetukykExecUiBeanParam {

    private String syono;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    private List<String> warningMessageIdList;

    public List<String> getWarningMessageIdList() {
        return warningMessageIdList;
    }

    @Override
    public void setWarningMessageIdList(List<String> warningMessageIdList) {
        this.warningMessageIdList = warningMessageIdList;
    }

    private List<String> warningMessageList;

    public List<String> getWarningMessageList() {
        return warningMessageList;
    }

    @Override
    public void setWarningMessageList(List<String> warningMessageList) {
        this.warningMessageList = warningMessageList;
    }


    private List<KikeiyakuInfoDataSourceBeanCommonParam> kikeiyakuInfoDataSourceBeanList;

    @Override
    public KikeiyakuInfoDataSourceBeanCommonParam createKikeiyakuInfoDataSourceBean() {
        return new KikeiyakuInfoDataSourceBeanCommonParamImpl();
    }

    @Override
    public void convertKikeiyakuInfoForCommonParam(List<KikeiyakuInfoDataSourceBeanCommonParam> pKikeiyakuInfo) {
        kikeiyakuInfoDataSourceBeanList = pKikeiyakuInfo;
    }

    public List<KikeiyakuInfoDataSourceBeanCommonParam> getKikeiyakuInfoDataSourceBeanList(){
        return kikeiyakuInfoDataSourceBeanList;
    }

    private List<NenkinsiharaiInfoDataSourceBeanCommonParam> nenkinsiharaiInfoDataSourceBeanList;

    @Override
    public NenkinsiharaiInfoDataSourceBeanCommonParam createNenkinsiharaiInfoDataSourceBean() {
        return new NenkinsiharaiInfoDataSourceBeanCommonParamImpl();
    }

    @Override
    public void convertNenkinsiharaiInfoForCommonParam(List<NenkinsiharaiInfoDataSourceBeanCommonParam> pNenkinsiharaiInfo) {
        nenkinsiharaiInfoDataSourceBeanList = pNenkinsiharaiInfo;
    }

    public List<NenkinsiharaiInfoDataSourceBeanCommonParam> getNenkinsiharaiInfoDataSourceBeanList(){
        return nenkinsiharaiInfoDataSourceBeanList;
    }

    private List<PalkikeiyakuInfoDataSourceBeanCommonParam> palkikeiyakuInfoDataSourceBeanList;

    @Override
    public PalkikeiyakuInfoDataSourceBeanCommonParam createPalkikeiyakuInfoDataSourceBean() {
        return new PalkikeiyakuInfoDataSourceBeanCommonParamImpl();
    }

    @Override
    public void convertPalkikeiyakuInfoForCommonParam
    (List<PalkikeiyakuInfoDataSourceBeanCommonParam> pPalNenkinsiharaiInfo) {
        palkikeiyakuInfoDataSourceBeanList = pPalNenkinsiharaiInfo;
    }

    public List<PalkikeiyakuInfoDataSourceBeanCommonParam> getPalkikeiyakuInfoDataSourceBeanList(){
        return palkikeiyakuInfoDataSourceBeanList;
    }

    private List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> palNenkinsiharaiInfoDataSourceBeanList;

    @Override
    public PalNenkinsiharaiInfoDataSourceBeanCommonParam createPalNenkinsiharaiInfoDataSourceBean() {
        return new PalNenkinsiharaiInfoDataSourceBeanCommonParamImpl();
    }

    @Override
    public void convertPalNenkinsiharaiInfoForCommonParam
    (List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> pPalNenkinsiharaiInfo) {
        palNenkinsiharaiInfoDataSourceBeanList = pPalNenkinsiharaiInfo;
    }

    public List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> getPalNenkinsiharaiInfoDataSourceBeanList(){
        return palNenkinsiharaiInfoDataSourceBeanList;
    }

    private List<PalsueokiInfoDataSourceBeanCommonParam> palsueokiInfoDataSourceBeanList;

    @Override
    public PalsueokiInfoDataSourceBeanCommonParam createPalsueokiInfoDataSourceBean() {
        return new PalsueokiInfoDataSourceBeanCommonParamImpl();
    }

    @Override
    public void convertPalsueokiInfoForCommonParam(List<PalsueokiInfoDataSourceBeanCommonParam> pPalsueokiInfo) {
        palsueokiInfoDataSourceBeanList = pPalsueokiInfo;
    }

    public List<PalsueokiInfoDataSourceBeanCommonParam> getPalsueokiInfoDataSourceBeanList(){
        return palsueokiInfoDataSourceBeanList;
    }

}
