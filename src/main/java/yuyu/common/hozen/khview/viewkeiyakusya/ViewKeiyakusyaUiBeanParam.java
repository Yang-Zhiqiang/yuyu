package yuyu.common.hozen.khview.viewkeiyakusya;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Tdk;

/**
 * 契約保全 契約保全画面部品 契約者情報表示 <br />
 */
public interface ViewKeiyakusyaUiBeanParam extends CommonViewUiBeanParam {

    public String getVkykskyknmkn();

    public void setVkykskyknmkn(String pVkykskyknmkn);

    public String getVkykskyknmkj();

    public void setVkykskyknmkj(String pVkykskyknmkj);

    public C_KjkhukaKbn getVkykskyknmkjkhukakbn();

    public void setVkykskyknmkjkhukakbn(C_KjkhukaKbn pVkykskyknmkjkhukakbn);

    public BizDate getVkykskykseiymd();

    public void setVkykskykseiymd(BizDate pVkykskykseiymd);

    public C_Kyksei getVkykskyksei();

    public void setVkykskyksei(C_Kyksei pVkykskyksei);

    public C_Tdk getVkykskkkyktdk();

    public void setVkykskkkyktdk(C_Tdk pVkykskkkyktdk);

    public C_HjndaiykKbn getVkykshjndaiykkbn();

    public void setVkykshjndaiykkbn(C_HjndaiykKbn pVkykshjndaiykkbn);

    public String getVkykshjndaiyknm();

    public void setVkykshjndaiyknm(String pVkykshjndaiyknm);

    public String getVkykshjndainmkn();

    public void setVkykshjndainmkn(String pVkykshjndainmkn);

    public String getVkykshjndainmkj();

    public void setVkykshjndainmkj(String pVkykshjndainmkj);
}
