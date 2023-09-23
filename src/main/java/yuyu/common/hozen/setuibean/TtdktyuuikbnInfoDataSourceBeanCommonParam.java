package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_TtdktyuuiKbn;

/**
 * 契約保全 UiBean設定 手続注意情報表示
 */
public interface TtdktyuuikbnInfoDataSourceBeanCommonParam {

    C_TtdktyuuiKbn getVtdktttdktyuuikbn();

    void setVtdktttdktyuuikbn(C_TtdktyuuiKbn pVtdktttdktyuuikbn);

    String getVtdktttdktyikbnhsknaiyou();

    void setVtdktttdktyikbnhsknaiyou(String pVtdktttdktyikbnhsknaiyou);

    BizDate getVtdktttdktyuuikbnsetymd();

    void setVtdktttdktyuuikbnsetymd(BizDate pVtdktttdktyuuikbnsetymd);

    String getVtdktsetsosikinm();

    void setVtdktsetsosikinm(String pVtdktsetsosikinm);

}
