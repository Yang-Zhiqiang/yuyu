package yuyu.common.hozen.khview.viewsbhenkanukt;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_Tdk;

/**
 * 契約保全 契約保全画面部品 死亡返還金受取人情報表示 <br />
 */
public interface ViewSbHenkanuktUiBeanParam extends CommonViewUiBeanParam {

    public String getSbhenkanuktnmkn();

    public void setSbhenkanuktnmkn(String pSbhenkanuktnmkn);

    public String getSbhenkanuktnmkj();

    public void setSbhenkanuktnmkj(String pSbhenkanuktnmkj);

    public BizDate getSibouhenkankinuktseiymd();

    public void setSibouhenkankinuktseiymd(BizDate pSibouhenkankinuktseiymd);

    public C_Tdk getSibouhenkankinukttdk();

    public void setSibouhenkankinukttdk(C_Tdk pSibouhenkankinukttdk);
}
