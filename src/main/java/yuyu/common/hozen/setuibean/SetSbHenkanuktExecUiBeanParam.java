package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Tdk;

/**
 * 契約保全 UiBean設定 死亡返還金受取人情報設定UiBeanパラメータ
 */
public interface SetSbHenkanuktExecUiBeanParam {

    String getSyono();

    void setSbhenkanuktnmkn(String pSbhenkanuktnmkn);

    void setSbhenkanuktnmkj(String pSbhenkanuktnmkj);

    void setSibouhenkankinuktseiymd(BizDate pSibouhenkankinuktseiymd);

    void setSibouhenkankinukttdk(C_Tdk pSibouhenkankinukttdk);

}
