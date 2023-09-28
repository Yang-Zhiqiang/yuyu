package yuyu.common.biz.kaikei;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 経理・会計 外貨ＦＢ送金データ編集Beanクラス
 */
public class BzGkfbSoukinDataSksBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String denRenno;

    private int edaNo;

    private C_DensysKbn  denSysKbn;

    private String syoriCd;

    private String syoriSosikiCd;

    private BizDate syoriYmd;

    private BizDate denYmd;

    private String syono;

    private C_ShrhousiteiKbn shrHouSiteiKbn;

    private String bankCd;

    private String bankNmEj;

    private String sitenCd;

    private String sitenNmEj;

    private String kouzaNo;

    private String kzMeigiNmEi;

    private C_Tuukasyu  shrTuukaSyu;

    private BizCurrency gaikaShrgk;

    private C_Tuukasyu  kykTuukaSyu;

    private BizCurrency crossRateShrgk;

    private BizNumber soukinKwsRate;

    private String kinouId;

    private String userId;

    private String dengyoumuCd;

    public BzGkfbSoukinDataSksBean() {
        super();
    }

    public String getDenRenno() {
        return denRenno;
    }

    public void setDenRenno(String pDenRenno) {
        denRenno = pDenRenno;
    }

    public int getEdaNo() {
        return edaNo;
    }

    public void setEdaNo(int pEdaNo) {
        edaNo = pEdaNo;
    }

    public C_DensysKbn  getDenSysKbn() {
        return denSysKbn;
    }

    public void setDenSysKbn(C_DensysKbn  pDenSysKbn) {
        denSysKbn = pDenSysKbn;
    }

    public String getSyoriCd() {
        return syoriCd;
    }

    public void setSyoriCd(String pSyoriCd) {
        syoriCd = pSyoriCd;
    }

    public String getSyoriSosikiCd() {
        return syoriSosikiCd;
    }

    public void setSyoriSosikiCd(String pSyoriSosikiCd) {
        syoriSosikiCd = pSyoriSosikiCd;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public BizDate getDenYmd() {
        return denYmd;
    }

    public void setDenYmd(BizDate pDenYmd) {
        denYmd = pDenYmd;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public C_ShrhousiteiKbn getShrHouSiteiKbn() {
        return shrHouSiteiKbn;
    }

    public void setShrHouSiteiKbn(C_ShrhousiteiKbn pShrHouSiteiKbn) {
        shrHouSiteiKbn = pShrHouSiteiKbn;
    }

    public String getBankCd() {
        return bankCd;
    }

    public void setBankCd(String pBankCd) {
        bankCd = pBankCd;
    }

    public String getBankNmEj() {
        return bankNmEj;
    }

    public void setBankNmEj(String pBankNmEj) {
        bankNmEj = pBankNmEj;
    }

    public String getSitenCd() {
        return sitenCd;
    }

    public void setSitenCd(String pSitenCd) {
        sitenCd = pSitenCd;
    }

    public String getSitenNmEj() {
        return sitenNmEj;
    }

    public void setSitenNmEj(String pSitenNmEj) {
        sitenNmEj = pSitenNmEj;
    }

    public String getKouzaNo() {
        return kouzaNo;
    }

    public void setKouzaNo(String pKouzaNo) {
        kouzaNo = pKouzaNo;
    }

    public String getKzMeigiNmEi() {
        return kzMeigiNmEi;
    }

    public void setKzMeigiNmEi(String pKzMeigiNmEi) {
        kzMeigiNmEi = pKzMeigiNmEi;
    }

    public C_Tuukasyu  getShrTuukaSyu() {
        return shrTuukaSyu;
    }

    public void setShrTuukaSyu(C_Tuukasyu  pShrTuukaSyu) {
        shrTuukaSyu = pShrTuukaSyu;
    }

    public BizCurrency getGaikaShrgk() {
        return gaikaShrgk;
    }

    public void setGaikaShrgk(BizCurrency pGaikaShrgk) {
        gaikaShrgk = pGaikaShrgk;
    }

    public C_Tuukasyu  getKykTuukaSyu() {
        return kykTuukaSyu;
    }

    public void setKykTuukaSyu(C_Tuukasyu  pKykTuukaSyu) {
        kykTuukaSyu = pKykTuukaSyu;
    }

    public BizCurrency getCrossRateShrgk() {
        return crossRateShrgk;
    }

    public void setCrossRateShrgk(BizCurrency pCrossRateShrgk) {
        crossRateShrgk = pCrossRateShrgk;
    }

    public BizNumber getSoukinKwsRate() {
        return soukinKwsRate;
    }

    public void setSoukinKwsRate(BizNumber pSoukinKwsRate) {
        soukinKwsRate = pSoukinKwsRate;
    }

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }

    public String getDengyoumuCd() {
        return dengyoumuCd;
    }

    public void setDengyoumuCd(String pDengyoumuCd) {
        dengyoumuCd = pDengyoumuCd;
    }
}
