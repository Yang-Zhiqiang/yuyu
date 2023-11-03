package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.hozen.setuibean.PalkikeiyakuInfoDataSourceBeanCommonParam;

/**
 * 契約保全 UiBean設定 別契約（ＰＡＬ既契約）  のデータソースのデータ
 */
public class PalkikeiyakuInfoDataSourceBeanCommonParamImpl implements PalkikeiyakuInfoDataSourceBeanCommonParam {

    private String vbtkkdisppalbtkyksyono;

    @Override
    public String getVbtkkdisppalbtkyksyono() {
        return vbtkkdisppalbtkyksyono;
    }

    @Override
    public void setVbtkkdisppalbtkyksyono(String pVbtkkdisppalbtkyksyono) {
        vbtkkdisppalbtkyksyono = pVbtkkdisppalbtkyksyono;
    }


    private BizDate vbtkkdisppalbtkykkykymd;

    @Override
    public BizDate getVbtkkdisppalbtkykkykymd() {
        return vbtkkdisppalbtkykkykymd;
    }

    @Override
    public void setVbtkkdisppalbtkykkykymd(BizDate pVbtkkdisppalbtkykkykymd) {
        vbtkkdisppalbtkykkykymd = pVbtkkdisppalbtkykkykymd;
    }


    private String vbtkkdisppalbtkyksymtcd;

    @Override
    public String getVbtkkdisppalbtkyksymtcd() {
        return vbtkkdisppalbtkyksymtcd;
    }

    @Override
    public void setVbtkkdisppalbtkyksymtcd(String pVbtkkdisppalbtkyksymtcd) {
        vbtkkdisppalbtkyksymtcd = pVbtkkdisppalbtkyksymtcd;
    }


    private BizDate vbtkkdisppalbtkyksymtymd;

    @Override
    public BizDate getVbtkkdisppalbtkyksymtymd() {
        return vbtkkdisppalbtkyksymtymd;
    }

    @Override
    public void setVbtkkdisppalbtkyksymtymd(BizDate pVbtkkdisppalbtkyksymtymd) {
        vbtkkdisppalbtkyksymtymd = pVbtkkdisppalbtkyksymtymd;
    }

}
