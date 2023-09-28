package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 外貨ＦＢ送金データテーブルインターフェイス
 */
public interface GkFBSoukinDataParam {

    public String getFbsoukindatasikibetukey();

    public void setFbsoukindatasikibetukey(String pFbsoukindatasikibetukey);

    public String getDenrenno();

    public void setDenrenno(String pDenrenno);

    public Integer getEdano();

    public void setEdano(Integer pEdano);

    public C_DensysKbn getDensyskbn();

    public void setDensyskbn(C_DensysKbn pDensyskbn);

    public C_Gkgyoumucd getGkgyoumucd();

    public void setGkgyoumucd(C_Gkgyoumucd pGkgyoumucd);

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

    public String getBanknmej();

    public void setBanknmej(String pBanknmej);

    public String getSitencd();

    public void setSitencd(String pSitencd);

    public String getSitennmej();

    public void setSitennmej(String pSitennmej);

    public String getKouzano();

    public void setKouzano(String pKouzano);

    public String getKzmeiginmei();

    public void setKzmeiginmei(String pKzmeiginmei);

    public C_Tuukasyu getShrtuukasyu();

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu);

    public BizCurrency getGaikashrgk();

    public void setGaikashrgk(BizCurrency pGaikashrgk);

    public C_Tuukasyu getKyktuukasyu();

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu);

    public BizCurrency getCrossrateshrgk();

    public void setCrossrateshrgk(BizCurrency pCrossrateshrgk);

    public BizNumber getSoukinkwsrate();

    public void setSoukinkwsrate(BizNumber pSoukinkwsrate);

    public String getIrninnmei();

    public void setIrninnmei(String pIrninnmei);

    public String getGyoumuKousinKinou();

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou);

    public String getGyoumuKousinsyaId();

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId);

    public String getGyoumuKousinTime();

    public void setGyoumuKousinTime(String pGyoumuKousinTime);
}
