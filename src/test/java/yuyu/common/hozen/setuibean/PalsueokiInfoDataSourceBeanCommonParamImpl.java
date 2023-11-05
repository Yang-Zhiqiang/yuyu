package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;

/**
 * 契約保全 UiBean設定 別契約（ＰＡＬ保険金据置契約）  のデータソースのデータ
 */
public class PalsueokiInfoDataSourceBeanCommonParamImpl implements PalsueokiInfoDataSourceBeanCommonParam {

    private String vbtkkdisppalbtkyksosysyno;

    @Override
    public String getVbtkkdisppalbtkyksosysyno() {
        return vbtkkdisppalbtkyksosysyno;
    }

    @Override
    public void setVbtkkdisppalbtkyksosysyno(String pVbtkkdisppalbtkyksosysyno) {
        vbtkkdisppalbtkyksosysyno = pVbtkkdisppalbtkyksosysyno;
    }


    private BizDate vbtkkdisppalbtkyksosymd;

    @Override
    public BizDate getVbtkkdisppalbtkyksosymd() {
        return vbtkkdisppalbtkyksosymd;
    }

    @Override
    public void setVbtkkdisppalbtkyksosymd(BizDate pVbtkkdisppalbtkyksosymd) {
        vbtkkdisppalbtkyksosymd = pVbtkkdisppalbtkyksosymd;
    }

}
