package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_UnitFundKbn;

/**
 * 契約保全 UiBean設定 特別勘定情報データソースBeanパラメータ
 */
public interface TbktInfoDataSourceBeanCommonParam {

    public String getVhsyudispfundunitkbnval();

    public void setVhsyudispfundunitkbnval(String pVhsyudispfundunitkbnval);

    public C_UnitFundKbn getVhsyudispfundunitkbn();

    public void setVhsyudispfundunitkbn(C_UnitFundKbn pVhsyudispfundunitkbn);

    public BizNumber getVhsyudispunitsuu();

    public void setVhsyudispunitsuu(BizNumber pVhsyudispunitsuu);

    public BizNumber getVhsyudispfundindex();

    public void setVhsyudispfundindex(BizNumber pVhsyudispfundindex) ;

    public BizCurrency getVhsyudisptutakngk();

    public void setVhsyudisptutakngk(BizCurrency pVhsyudisptutakngk);

    public BizNumber getVhsyudispwariai();

    public void setVhsyudispwariai(BizNumber pVhsyudispwariai);
}
