package yuyu.common.hozen.khcommon;

import java.io.Serializable;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全共通 仕訳共通処理出力Bean
 */
public class CommonSiwakeOutBean implements Serializable  {

    private static final long serialVersionUID = 1L;

    private C_DensysKbn densysKbn;

    private String huridenatesakiCd;

    private C_TantouCdKbn tantoCd;

    private BizDate denYmd;

    private C_Tuukasyu tuukasyu;

    private C_HuridensksKbn huridensksKbn;

    private C_DenhnknhouKbn denhnknhouKbn;

    private C_DenshrhouKbn denshrhouKbn;

    private BizDate syoriYmd;

    private String syoriCd;

    private C_Tuukasyu kyktuukaSyu;

    private BizCurrency gaikataikagk;

    private C_DenSyorisyousaiKbn densyorisyousaiKbn;

    private List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst;

    public C_DensysKbn getDensysKbn() {
        return densysKbn;
    }

    public void setDensysKbn(C_DensysKbn pDensysKbn) {
        densysKbn = pDensysKbn;
    }

    public String getHuridenatesakiCd() {
        return huridenatesakiCd;
    }

    public void setHuridenatesakiCd(String pHuridenatesakiCd) {
        huridenatesakiCd = pHuridenatesakiCd;
    }

    public C_TantouCdKbn getTantoCd() {
        return tantoCd;
    }

    public void setTantoCd(C_TantouCdKbn pTantoCd) {
        tantoCd = pTantoCd;
    }

    public BizDate getDenyMd() {
        return denYmd;
    }

    public void setDenYmd(BizDate pDenYmd) {
        denYmd = pDenYmd;
    }

    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    public C_HuridensksKbn getHuridensksKbn() {
        return huridensksKbn;
    }

    public void setHuridensksKbn(C_HuridensksKbn pHuridensksKbn) {
        huridensksKbn = pHuridensksKbn;
    }

    public C_DenhnknhouKbn getDenhnknhouKbn() {
        return denhnknhouKbn;
    }

    public void setDenhnknhouKbn(C_DenhnknhouKbn pDenhnknhouKbn) {
        denhnknhouKbn = pDenhnknhouKbn;
    }

    public C_DenshrhouKbn getDenshrhouKbn() {
        return denshrhouKbn;
    }

    public void setDenshrhouKbn(C_DenshrhouKbn pDenshrhouKbn) {
        denshrhouKbn = pDenshrhouKbn;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public String getSyoriCd() {
        return syoriCd;
    }

    public void setSyoriCd(String pSyoriCd) {
        syoriCd = pSyoriCd;
    }

    public C_Tuukasyu getKyktuukaSyu() {
        return kyktuukaSyu;
    }

    public void setKyktuukaSyu(C_Tuukasyu pKyktuukaSyu) {
        kyktuukaSyu = pKyktuukaSyu;
    }

    public BizCurrency getGaikataikagk() {
        return gaikataikagk;
    }

    public void setGaikataikagk(BizCurrency pGaikataikagk) {
        gaikataikagk = pGaikataikagk;
    }

    public C_DenSyorisyousaiKbn getDensyorisyousaikbn() {
        return densyorisyousaiKbn;
    }

    public void setDensyorisyousaikbn(C_DenSyorisyousaiKbn pDensyorisyousaikbn) {
        densyorisyousaiKbn = pDensyorisyousaikbn;
    }

    public List<BzSiwakeMeisaiBean> getBzSiwakeMeisaiBeanLst() {
        return bzSiwakeMeisaiBeanLst;
    }

    public void setBzSiwakeMeisaiBeanLst(List<BzSiwakeMeisaiBean> pBzSiwakeMeisaiBeanLst) {
        bzSiwakeMeisaiBeanLst = pBzSiwakeMeisaiBeanLst;
    }

}
