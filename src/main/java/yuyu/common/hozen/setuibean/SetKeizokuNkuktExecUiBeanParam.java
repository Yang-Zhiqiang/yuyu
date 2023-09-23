package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Tdk;

/**
 * 契約保全 UiBean設定 継続年金受取人情報設定UiBeanパラメータ
 */
public interface SetKeizokuNkuktExecUiBeanParam {

    String getSyono();

    void setKeizknkuktnmkn(String pKeizknkuktnmkn);

    void setKeizknkuktnmkj(String pKeizknkuktnmkj);

    void setKeizknenkiuktseiymd(BizDate pKeizknenkiuktseiymd);

    void setKeizknenkinukttdk(C_Tdk pKeizknenkinukttdk);
}
