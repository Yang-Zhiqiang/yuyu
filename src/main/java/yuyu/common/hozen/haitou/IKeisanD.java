package yuyu.common.hozen.haitou;

import java.util.List;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 契約保全 配当 配当金計算インターフェース
 */
public interface IKeisanD extends HaitouErrorProcess{

    public C_ErrorKbn exec(KeisanDBean pKeisanDBean) ;

    public BizCurrency getD();

    public List<KeisanDInfoBean> getKeisanDInfoBeanList();

    public BizCurrency getDSisaDrate();

    public List<KeisanDInfoBean> getKeisanDInfoBeanSisaDrateList();

    public BizCurrency getDRisaDrate();

    public List<KeisanDInfoBean> getKeisanDInfoBeanRisaDrateList();

    public BizCurrency getDHisaDrate();

    public List<KeisanDInfoBean> getKeisanDInfoBeanHisaDrateList();

    public BizCurrency getDDyouVrate();

    public List<KeisanDInfoBean> getKeisanDInfoBeanDyouVrateList();

    public BizCurrency getDKikenSrate();

    public List<KeisanDInfoBean> getKeisanDInfoBeanKikenSrateList();

    public void log();
}
