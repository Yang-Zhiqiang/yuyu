package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 UiBean設定 特伸情報設定UiBeanパラメータ
 */
public interface SetTokusinExecUiBeanParam {

    String getSyono();

    public void setVtsumukbn(C_UmuKbn pVtsumukbn);

    public void setVtstokusinkbn(C_TokusinKbn pVtstokusinkbn);

    public void setVtshsgymd(BizDate pVtshsgymd);

    public void setVtstokusinendymd(BizDate pVtstokusinendymd);

}
