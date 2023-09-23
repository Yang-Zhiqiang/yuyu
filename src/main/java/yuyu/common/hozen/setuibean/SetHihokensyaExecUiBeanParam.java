package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KjkhukaKbn;

/**
 * 契約保全 UiBean設定 被保険者情報設定UiBeanパラメータ
 */
public interface SetHihokensyaExecUiBeanParam {

    String getSyono();

    void setVhhkshhknnmkn(String pVhhkshhknnmkn);

    void setVhhkshhknnmkj(String pVhhkshhknnmkj);

    void setVhhkshhknnmkjkhukakbn(C_KjkhukaKbn pVhhkshhknnmkjkhukakbn);

    void setVhhkshhknseiymd(BizDate pVhhkshhknseiymd);

    void setVhhkshhknsei(C_Hhknsei pVhhkshhknsei);
}
