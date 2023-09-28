package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;

/**
 * ＦＢ送金データテーブルインターフェイス
 */
public interface FBSoukinDataParam {

    public String getFbsoukindatasikibetukey();

    public void setFbsoukindatasikibetukey(String pFbsoukindatasikibetukey);

    public String getDenrenno();

    public void setDenrenno(String pDenrenno);

    public Integer getEdano();

    public void setEdano(Integer pEdano);

    public C_DensysKbn getDensyskbn();

    public void setDensyskbn(C_DensysKbn pDensyskbn);

    public C_Gyoumucd getGyoumucd();

    public void setGyoumucd(C_Gyoumucd pGyoumucd);

    public C_Tantositucd getTantositucd();

    public void setTantositucd(C_Tantositucd pTantositucd);

    public String getSyoricd();

    public void setSyoricd(String pSyoricd);

    public String getSyorisosikicd();

    public void setSyorisosikicd(String pSyorisosikicd);

    public BizDate getSyoriYmd();

    public void setSyoriYmd(BizDate pSyoriYmd);

    public BizDate getDenymd();

    public void setDenymd(BizDate pDenymd);

    public String getSyono();

    public void setSyono(String pSyono);

    public C_ShrhousiteiKbn getShrhousiteikbn();

    public void setShrhousiteikbn(C_ShrhousiteiKbn  pShrhousiteikbn);

    public String getBankcd();

    public void setBankcd(String pBankcd);

    public String getSitencd();

    public void setSitencd(String pSitencd);

    public C_YokinKbn  getYokinkbn();

    public void setYokinkbn(C_YokinKbn pYokinkbn);

    public String getKouzano();

    public void setKouzano(String pKouzano);

    public String getKzmeiginmkn();

    public void setKzmeiginmkn(String pKzmeiginmkn);

    public BizCurrency getSoukingk();

    public void setSoukingk(BizCurrency pSoukingk);

    public C_Tuukasyu getKyktuukasyu();

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu);

    public BizCurrency getGaikataikagk();

    public void setGaikataikagk(BizCurrency pGaikataikagk);

    public BizNumber getSoukinkwsrate();

    public void setSoukinkwsrate(BizNumber pSoukinkwsrate);

    public String getGyoumuKousinKinou();

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou);

    public String getGyoumuKousinsyaId();

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId);

    public String getGyoumuKousinTime();

    public void setGyoumuKousinTime(String pGyoumuKousinTime);
}
