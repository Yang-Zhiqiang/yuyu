package yuyu.common.hozen.khview.viewkouzainfo;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_YokinKbn;

/**
 * 契約保全 契約保全画面部品 口座情報表示 <br />
 */
public interface ViewKouzaInfoUiBeanParam extends CommonViewUiBeanParam {

    public C_InputShrhousiteiKbn getInputshrhousiteikbn() ;

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) ;

    public C_KouzasyuruiKbn getKzsyuruikbn();

    public void setKzsyuruikbn(C_KouzasyuruiKbn pKzsyuruikbn);

    public String getBankcd() ;

    public void setBankcd(String pBankcd) ;

    public String getBanknmkj () ;

    public void setBanknmkj (String pBanknmkj );

    public String getSitencd() ;

    public void setSitencd(String pSitencd) ;

    public String getSitennmkj() ;

    public void setSitennmkj(String pSitennmkj);

    public C_YokinKbn  getYokinkbn();

    public void setYokinkbn(C_YokinKbn  pYokinkbn) ;

    public String getKouzano() ;

    public void setKouzano(String pKouzano) ;

    public C_Kzdou getKzdoukbn();

    public void setKzdoukbn(C_Kzdou pKzdoukbn) ;

    public String getKzmeiginmkn() ;

    public void setKzmeiginmkn(String pKzmeiginmkn) ;

}
