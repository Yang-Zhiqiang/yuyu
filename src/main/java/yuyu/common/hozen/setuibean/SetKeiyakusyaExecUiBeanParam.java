package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Tdk;

/**
 * 契約保全 UiBean設定 契約者情報設定UiBeanパラメータ
 */
public interface SetKeiyakusyaExecUiBeanParam {

    String getSyono();

    public void setVkykskyknmkn(String pVkykskyknmkn);

    public void setVkykskyknmkj(String pVkykskyknmkj);

    public void setVkykskyknmkjkhukakbn(C_KjkhukaKbn pVkykskyknmkjkhukakbn);

    public void setVkykskykseiymd(BizDate pVkykskykseiymd);

    public void setVkykskyksei(C_Kyksei pVkykskyksei);

    public void setVkykskkkyktdk(C_Tdk pVkykskkkyktdk);

    public void setVkykshjndaiykkbn(C_HjndaiykKbn pVkykshjndaiykkbn);

    public void setVkykshjndaiyknm(String pVkykshjndaiyknm);

    public void setVkykshjndainmkn(String pVkykshjndainmkn);

    public void setVkykshjndainmkj(String pVkykshjndainmkj);
}
