package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 伝票データテーブルインターフェイス
 */
public interface DenpyouDataParam {

    public String getDenrenno();

    public void setDenrenno(String pDenrenno);

    public Integer getEdano();

    public void setEdano(Integer pEdano);

    public C_DensysKbn getDensyskbn();

    public void setDensyskbn(C_DensysKbn pDensyskbn);

    public String getSyono();

    public void setSyono(String pSyono);

    public String getHuridenatesakicd();

    public void setHuridenatesakicd(String pHuridenatesakicd);

    public C_TantouCdKbn getTantocd();

    public void setTantocd(C_TantouCdKbn pTantocd);

    public BizDate getDenymd();

    public void setDenymd(BizDate pDenymd);

    public C_TaisyakuKbn getTaisyakukbn();

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn);

    public C_Kanjyoukmkcd getKanjyoukmkcd();

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd);

    public String getSuitoubumoncd();

    public void setSuitoubumoncd(String pSuitoubumoncd);

    public C_Tuukasyu getTuukasyu();

    public void setTuukasyu(C_Tuukasyu pTuukasyu);

    public BizCurrency getDengaikagk();

    public void setDengaikagk(BizCurrency pDengaikagk);

    public BizNumber getDenkawaserate();

    public void setDenkawaserate(BizNumber pDenkawaserate);

    public BizCurrency getDenyenkagk();

    public void setDenyenkagk(BizCurrency pDenyenkagk);

    public C_HuridensksKbn getHuridenskskbn();

    public void setHuridenskskbn(C_HuridensksKbn pHuridenskskbn);

    public C_DenhnknhouKbn getDenhnknhoukbn();

    public void setDenhnknhoukbn(C_DenhnknhouKbn pDenhnknhoukbn);

    public C_DenshrhouKbn getDenshrhoukbn();

    public void setDenshrhoukbn(C_DenshrhouKbn pDenshrhoukbn);

    public BizDate getSyoriYmd();

    public void setSyoriYmd(BizDate pSyoriYmd);

    public String getSyoricd();

    public void setSyoricd(String pSyoricd);

    public String getSyorisosikicd();

    public void setSyorisosikicd(String pSyorisosikicd);

    public C_Segcd getSeg1cd();

    public void setSeg1cd(C_Segcd pSeg1cd);

    public C_Segcd getSeg2cd();

    public void setSeg2cd(C_Segcd pSeg2cd);

    public Boolean getKakokawaserateshiteiflg();

    public void setKakokawaserateshiteiflg(Boolean pKakokawaserateshiteiflg);

    public BizDate getKakokawaserateshiteiymd();

    public void setKakokawaserateshiteiymd(BizDate pKakokawaserateshiteiymd);

    public C_Tuukasyu getKyktuukasyu();

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu);

    public BizCurrency getKeiyakutuukagk();

    public void setKeiyakutuukagk(BizCurrency pKeiyakutuukagk);

    public String getGyoumuKousinsyaId();

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId);

    public String getGyoumuKousinTime();

    public void setGyoumuKousinTime(String pGyoumuKousinTime);

    public String getDengyoumucd();

    public void setDengyoumucd(String pDengyoumucd);

    public String getSyusyouhncd();

    public void setSyusyouhncd(String pSyusyouhncd);

    public Integer getSyouhnsdno();

    public void setSyouhnsdno(Integer pSyouhnsdno);

    public C_KawasetekiyoKbn getKawasetekiyokbn();

    public void setKawasetekiyokbn(C_KawasetekiyoKbn pKawasetekiyokbn);

    public String getDenkarikanjyono();

    public void setDenkarikanjyono(String pDenkarikanjyono);

    public Boolean getTaisyakutyouseiflg();

    public void setTaisyakutyouseiflg(Boolean pTaisyakutyouseiflg);

    public C_DenSyorisyousaiKbn getDensyorisyousaikbn();

    public void setDensyorisyousaikbn(C_DenSyorisyousaiKbn pDensyorisyousaikbn);
}
