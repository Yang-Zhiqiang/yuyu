package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;

/**
 * 契約保全 UiBean設定 別契約（ＰＡＬ年金支払契約）  のデータソースのデータ
 */
public class PalNenkinsiharaiInfoDataSourceBeanCommonParamImpl implements PalNenkinsiharaiInfoDataSourceBeanCommonParam{

    private String vbtkkdisppalbtkyknksysyno;

    @Override
    public String getVbtkkdisppalbtkyknksysyno() {
        return vbtkkdisppalbtkyknksysyno;
    }

    @Override
    public void setVbtkkdisppalbtkyknksysyno(String pVbtkkdisppalbtkyknksysyno) {
        vbtkkdisppalbtkyknksysyno = pVbtkkdisppalbtkyknksysyno;
    }


    private BizDate vbtkkdisppalbtkyknkshrymd;

    @Override
    public BizDate getVbtkkdisppalbtkyknkshrymd() {
        return vbtkkdisppalbtkyknkshrymd;
    }

    @Override
    public void setVbtkkdisppalbtkyknkshrymd(BizDate pVbtkkdisppalbtkyknkshrymd) {
        vbtkkdisppalbtkyknkshrymd = pVbtkkdisppalbtkyknkshrymd;
    }


    private String vbtkkdisppalbtkyknksymtcd;

    @Override
    public String getVbtkkdisppalbtkyknksymtcd() {
        return vbtkkdisppalbtkyknksymtcd;
    }

    @Override
    public void setVbtkkdisppalbtkyknksymtcd(String pVbtkkdisppalbtkyknksymtcd) {
        vbtkkdisppalbtkyknksymtcd = pVbtkkdisppalbtkyknksymtcd;
    }


    private BizDate vbtkkdisppalbtkyknksymtymd;

    @Override
    public BizDate getVbtkkdisppalbtkyknksymtymd() {
        return vbtkkdisppalbtkyknksymtymd;
    }

    @Override
    public void setVbtkkdisppalbtkyknksymtymd(BizDate pVbtkkdisppalbtkyknksymtymd) {
        vbtkkdisppalbtkyknksymtymd = pVbtkkdisppalbtkyknksymtymd;
    }

}
