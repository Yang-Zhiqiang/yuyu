package yuyu.common.hozen.setuibean;

import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 契約保全 UiBean設定 定期支払金支払先口座情報設定UiBeanパラメータインターフェース
 */
public interface SetKhTkshrSiharaiKouzaExecUiBeanParam {

    String getSyono();

    public void setVktikskzkzsyuruikbn(C_KouzasyuruiKbn pVktikskzkzsyuruikbn);

    public void setVktikskzbankcd(String pVktikskzbankcd);

    public void setVktikskzbanknmkj(String pVktikskzbanknmkj);

    public void setVktikskzsitencd(String pVktikskzsitencd);

    public void setVktikskzsitennmkj(String pVktikskzsitennmkj);

    public void setVktikskzyokinkbn(C_YokinKbn pVktikskzyokinkbn);

    public void setVktikskzkouzano(String pVktikskzkouzano);

    public void setVktikskzkzmeiginmkn(String pVktikskzkzmeiginmkn);

    public void setTeikishrtkykhukaumu(C_UmuKbn pTeikishrtkykhukaumu);
}
