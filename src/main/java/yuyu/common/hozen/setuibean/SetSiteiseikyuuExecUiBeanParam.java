package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;

/**
 * 契約保全 UiBean設定 被保険者代理人情報設定UiBeanパラメータ
 */
public interface SetSiteiseikyuuExecUiBeanParam {

    String getSyono();

    void setVstsksiteidruktkbn(C_UktKbn pVstsksiteidruktkbn);

    void setVstskstdrsknmkn(String pVstskstdrsknmkn);

    void setVstskstdrsknmkj(String pVstskstdrsknmkj);

    void setVstskstdrsknmkjhukakbn(C_KjkhukaKbn pVstskstdrsknmkjhukakbn);

    void setVstskstdrskseiymd(BizDate pVstskstdrskseiymd);

}
