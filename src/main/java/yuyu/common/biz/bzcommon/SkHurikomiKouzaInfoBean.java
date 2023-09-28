package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;

/**
 * 業務共通 共通 新契約振込入金口座情報取得Bean
 */
public class SkHurikomiKouzaInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bankCd;

    private String sitenCd;

    private C_YokinKbn yokinKbn;

    private String kouzaNo;

    private String hrkmirninCd;

    private String hrkmirninNm;

    private C_Tuukasyu tuukasyu;

    private String mosno;

    private String syouhnNo;

    private String hrkmirninNmKana;

    private String oyadrtenCd;

    private String nyuukinOyadrtenNm;

    private C_TaisyouKbn jidonyknTargetHyouji;

    private C_TaisyouKbn  oyadrtenSyoriTarget;

    private C_Tuukasyu siteiTuuka;

    private String honkouzaCd;

    private C_NyktyhyoutKbn nyktyhyoutKbn;

    public String getBankCd() {
        return bankCd;
    }

    public void setBankCd(String pBankCd) {
        bankCd = pBankCd;
    }

    public String getSitenCd() {
        return sitenCd;
    }

    public void setSitenCd(String pSitenCd) {
        sitenCd = pSitenCd;
    }

    public C_YokinKbn getYokinKbn() {
        return yokinKbn;
    }

    public void setYokinKbn(C_YokinKbn pYokinKbn) {
        yokinKbn = pYokinKbn;
    }

    public String getKouzaNo() {
        return kouzaNo;
    }

    public void setKouzaNo(String pKouzaNo) {
        kouzaNo = pKouzaNo;
    }

    public String getHrkmirninCd() {
        return hrkmirninCd;
    }

    public void setHrkmirninCd(String pHrkmirninCd) {
        hrkmirninCd = pHrkmirninCd;
    }

    public String getHrkmirninNm() {
        return hrkmirninNm;
    }

    public void setHrkmirninNm(String pHrkmirninNm) {
        hrkmirninNm = pHrkmirninNm;
    }

    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    public String getSyouhnNo() {
        return syouhnNo;
    }

    public void setSyouhnNo(String pSyouhnNo) {
        syouhnNo = pSyouhnNo;
    }

    public String getHrkmirninNmKana() {
        return hrkmirninNmKana;
    }

    public void setHrkmirninNmKana(String pHrkmirninNmKana) {
        hrkmirninNmKana = pHrkmirninNmKana;
    }

    public String getOyadrtenCd() {
        return oyadrtenCd;
    }

    public void setOyadrtenCd(String pOyadrtenCd) {
        oyadrtenCd = pOyadrtenCd;
    }

    public String getNyuukinOyadrtenNm() {
        return nyuukinOyadrtenNm;
    }

    public void setNyuukinOyadrtenNm(String pNyuukinOyadrtenNm) {
        nyuukinOyadrtenNm = pNyuukinOyadrtenNm;
    }

    public C_TaisyouKbn getJidonyknTargetHyouji() {
        return jidonyknTargetHyouji;
    }

    public void setJidonyknTargetHyouji(C_TaisyouKbn pJidonyknTargetHyouji) {
        jidonyknTargetHyouji = pJidonyknTargetHyouji;
    }

    public C_TaisyouKbn getOyadrtenSyoriTarget() {
        return oyadrtenSyoriTarget;
    }

    public void setOyadrtenSyoriTarget(C_TaisyouKbn pOyadrtenSyoriTarget) {
        oyadrtenSyoriTarget = pOyadrtenSyoriTarget;
    }

    public C_Tuukasyu getSiteiTuuka() {
        return siteiTuuka;
    }

    public void setSiteiTuuka(C_Tuukasyu pSiteiTuuka) {
        siteiTuuka = pSiteiTuuka;
    }

    public String getHonkouzaCd() {
        return honkouzaCd;
    }

    public void setHonkouzaCd(String pHonkouzaCd) {
        honkouzaCd = pHonkouzaCd;
    }

    public C_NyktyhyoutKbn getNyktyhyoutKbn() {
        return nyktyhyoutKbn;
    }

    public void setNyktyhyoutKbn(C_NyktyhyoutKbn pNyktyhyoutKbn) {
        nyktyhyoutKbn = pNyktyhyoutKbn;
    }

}
