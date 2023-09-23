package yuyu.common.hozen.khview.viewkhtkshrsiharaikouza;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 契約保全 契約保全画面部品 定期支払金支払先口座情報表示 <br />
 */
public interface ViewKhTkshrSiharaiKouzaUiBeanParam extends CommonViewUiBeanParam {

    public C_KouzasyuruiKbn getVktikskzkzsyuruikbn();

    public void setVktikskzkzsyuruikbn(C_KouzasyuruiKbn pVktikskzkzsyuruikbn);

    public String getVktikskzbankcd();

    public void setVktikskzbankcd(String pVktikskzbankcd);

    public String getVktikskzbanknmkj();

    public void setVktikskzbanknmkj(String pVktikskzbanknmkj);

    public String getVktikskzsitencd();

    public void setVktikskzsitencd(String pVktikskzsitencd);

    public String getVktikskzsitennmkj();

    public void setVktikskzsitennmkj(String pVktikskzsitennmkj);

    public C_YokinKbn getVktikskzyokinkbn();

    public void setVktikskzyokinkbn(C_YokinKbn pVktikskzyokinkbn);

    public String getVktikskzkouzano();

    public void setVktikskzkouzano(String pVktikskzkouzano);

    public String getVktikskzkzmeiginmkn();

    public void setVktikskzkzmeiginmkn(String pVktikskzkzmeiginmkn);

    public C_UmuKbn getTeikishrtkykhukaumu();

    public void setTeikishrtkykhukaumu(C_UmuKbn pTeikishrtkykhukaumu);

}
