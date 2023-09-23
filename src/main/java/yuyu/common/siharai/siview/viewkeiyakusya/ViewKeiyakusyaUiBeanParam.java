package yuyu.common.siharai.siview.viewkeiyakusya;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_Kyksei;

/**
 * 保険金給付金支払 支払画面部品 契約者情報表示 <br />
 */

public interface ViewKeiyakusyaUiBeanParam extends CommonViewUiBeanParam {

    public String getKyknmkn();

    public void setKyknmkn(String pKyknmkn);

    public String getKyknmkj();

    public void setKyknmkj(String pKyknmkj);

    public BizDate getKykseiymd();

    public void setKykseiymd(BizDate pKykseiymd);

    public String getMskmjskjkyknen();

    public void setMskmjskjkyknen(String pMskmjskjkyknen);

    public C_Kyksei getKyksei();

    public void setKyksei(C_Kyksei pKyksei);

    public String getTdkdtsinyno();

    public void setTdkdtsinyno(String pTdkdtsinyno);

    public String getTdkdtsintelno();

    public void setTdkdtsintelno(String pTdkdtsintelno);

    public String getTdkdtsinadr1kj();

    public void setTdkdtsinadr1kj(String pTdkdtsinadr1kj);

    public String getTdkdtsinadr2kj();

    public void setTdkdtsinadr2kj(String pTdkdtsinadr2kj);

    public String getTdkdtsinadr3kj();

    public void setTdkdtsinadr3kj(String pTdkdtsinadr3kj);

}
