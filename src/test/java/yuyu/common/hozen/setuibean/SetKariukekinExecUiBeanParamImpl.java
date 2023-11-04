package yuyu.common.hozen.setuibean;

import java.util.List;

/**
 * 契約保全 UiBean設定 仮受金情報設定UiBeanパラメータ
 */
public class SetKariukekinExecUiBeanParamImpl implements SetKariukekinExecUiBeanParam {

    private String syono;

    private List<KariukekinInfoDataSourceBeanCommonParam> kariukekinInfo;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    @Override
    public KariukekinInfoDataSourceBeanCommonParam createKariukekinInfoDataSourceBean() {
        return new KariukekinInfoDataSourceBeanCommonParamImpl();
    }

    @Override
    public void convertKariukekinInfoForCommonParam(List<KariukekinInfoDataSourceBeanCommonParam> pKariukekinInfo) {
        kariukekinInfo = pKariukekinInfo;
    }

    public List<KariukekinInfoDataSourceBeanCommonParam> getKariukekinInfo() {
        return kariukekinInfo;
    }
}
