package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_BankYuuksHantKbn;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_EnkashrKahiKbn;
import yuyu.def.classification.C_GaikashrKahiKbn;
import yuyu.def.classification.C_HrkmKanouihyj;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kokunaikwskameihyj;
import yuyu.def.classification.C_KyouteiSyouinKbn;
import yuyu.def.classification.C_TapekoukanKbn;
import yuyu.def.classification.C_TrhkginkousitenKbn;
import yuyu.def.classification.C_TsrkeisanhouKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 業務共通 共通 銀行情報取得Bean
 */
public class BzGetBankDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_BankmasterUmuKbn bankmasterUmuKbn;

    private C_BankYuuksHantKbn bankYuuksHantKbn;

    private C_EnkashrKahiKbn enkashrKahiKbn;

    private C_GaikashrKahiKbn gaikashrKahiKbn;

    private String reportSitenNm;

    private C_KahiKbn yohuriKahiKbn;

    private C_KyouteiSyouinKbn yohuriKyouteiSyouinKbn;

    private BizDate yohuriKyouteiKouryokuhasseiYmd;

    private C_TrhkginkousitenKbn trhkGinkousitenKbn;

    private C_KahiKbn cssKahiKbn;

    private C_KyouteiSyouinKbn cssKyouteiSyouinKbn;

    private BizDate cssKyouteiKouryokuhasseiYmd;

    private C_KahiKbn zzkKahiKbn;

    private C_KyouteiSyouinKbn zzkKyouteiSyouinKbn;

    private BizDate zzkKyouteiKouryokuhasseiYmd;

    private String bankCd;

    private String sitenCd;

    private BizDate kousinYmd;

    private BizDate sinsetuYmd;

    private BizDate haisiYmd;

    private String bankNmKn;

    private String sitenNmKn;

    private String bankNmKj;

    private String sitenNmKj ;

    private String bankNmEj;

    private String sitenNmEj;

    private BizDate cssKyouteiKaisiYmd;

    private BizDate cssKyouteiKaijyoYmd;

    private C_Kokunaikwskameihyj kokunaikwskameihyj;

    private C_HrkmKanouihyj hrkmKanouihyj;

    private BizDate yofurikyouteikaisiYmd;

    private BizDate yofurikyouteikaijyoYmd;

    private String itakusyasitenCd;

    private String itakusyakinyuuCd;

    private C_YokinKbn itakusyayokinKbn;

    private String itakusyakouzano;

    private C_TsrkeisanhouKbn tsrkeisanhouKbn;

    private Integer kinyuutesuuryou;

    private String itakusyacd;

    private C_TapekoukanKbn tapekoukanKbn1;

    private String mdsisyaCd;

    private BizDate zzkkyouteikaisiYmd;

    private BizDate zzkkyouteikaijyoYmd;

    private BizDate huhoyofuriinfokousinYmd;

    public C_BankmasterUmuKbn getBankmasterUmuKbn() {
        return bankmasterUmuKbn;
    }

    public void setBankmasterUmuKbn(C_BankmasterUmuKbn pBankmasterUmuKbn) {
        bankmasterUmuKbn = pBankmasterUmuKbn;
    }

    public C_BankYuuksHantKbn getBankYuuksHantKbn() {
        return bankYuuksHantKbn;
    }

    public void setBankYuuksHantKbn(C_BankYuuksHantKbn pBankYuuksHantKbn) {
        bankYuuksHantKbn = pBankYuuksHantKbn;
    }

    public C_EnkashrKahiKbn getEnkashrKahiKbn() {
        return enkashrKahiKbn;
    }

    public void setEnkashrKahiKbn(C_EnkashrKahiKbn pEnkashrKahiKbn) {
        enkashrKahiKbn = pEnkashrKahiKbn;
    }

    public C_GaikashrKahiKbn getGaikashrKahiKbn() {
        return gaikashrKahiKbn;
    }

    public void setGaikashrKahiKbn(C_GaikashrKahiKbn pGaikashrKahiKbn) {
        gaikashrKahiKbn = pGaikashrKahiKbn;
    }

    public String getReportSitenNm() {
        return reportSitenNm;
    }

    public void setReportSitenNm(String pReportSitenNm) {
        reportSitenNm = pReportSitenNm;
    }

    public C_KahiKbn getYohuriKahiKbn() {
        return yohuriKahiKbn;
    }

    public void setYohuriKahiKbn(C_KahiKbn pYohuriKahiKbn) {
        yohuriKahiKbn = pYohuriKahiKbn;
    }

    public C_KyouteiSyouinKbn getYohuriKyouteiSyouinKbn() {
        return yohuriKyouteiSyouinKbn;
    }

    public void setYohuriKyouteiSyouinKbn(C_KyouteiSyouinKbn pYohuriKyouteiSyouinKbn) {
        yohuriKyouteiSyouinKbn = pYohuriKyouteiSyouinKbn;
    }

    public BizDate getYohuriKyouteiKouryokuhasseiYmd() {
        return yohuriKyouteiKouryokuhasseiYmd;
    }

    public void setYohuriKyouteiKouryokuhasseiYmd(BizDate pYohuriKyouteiKouryokuhasseiYmd) {
        yohuriKyouteiKouryokuhasseiYmd = pYohuriKyouteiKouryokuhasseiYmd;
    }

    public C_TrhkginkousitenKbn getTrhkGinkousitenKbn() {
        return trhkGinkousitenKbn;
    }

    public void setTrhkGinkousitenKbn(C_TrhkginkousitenKbn pTrhkGinkousitenKbn) {
        trhkGinkousitenKbn = pTrhkGinkousitenKbn;
    }

    public C_KahiKbn getCssKahiKbn() {
        return cssKahiKbn;
    }

    public void setCssKahiKbn(C_KahiKbn pCssKahiKbn) {
        cssKahiKbn = pCssKahiKbn;
    }

    public C_KyouteiSyouinKbn getCssKyouteiSyouinKbn() {
        return cssKyouteiSyouinKbn;
    }

    public void setCssKyouteiSyouinKbn(C_KyouteiSyouinKbn pCssKyouteiSyouinKbn) {
        cssKyouteiSyouinKbn = pCssKyouteiSyouinKbn;
    }

    public BizDate getCssKyouteiKouryokuhasseiYmd() {
        return cssKyouteiKouryokuhasseiYmd;
    }

    public void setCssKyouteiKouryokuhasseiYmd(BizDate pCssKyouteiKouryokuhasseiYmd) {
        cssKyouteiKouryokuhasseiYmd = pCssKyouteiKouryokuhasseiYmd;
    }

    public C_KahiKbn getZzkKahiKbn() {
        return zzkKahiKbn;
    }

    public void setZzkKahiKbn(C_KahiKbn pZzkKahiKbn) {
        zzkKahiKbn = pZzkKahiKbn;
    }

    public C_KyouteiSyouinKbn getZzkKyouteiSyouinKbn() {
        return zzkKyouteiSyouinKbn;
    }

    public void setZzkKyouteiSyouinKbn(C_KyouteiSyouinKbn pZzkKyouteiSyouinKbn) {
        zzkKyouteiSyouinKbn = pZzkKyouteiSyouinKbn;
    }

    public BizDate getZzkKyouteiKouryokuhasseiYmd() {
        return zzkKyouteiKouryokuhasseiYmd;
    }

    public void setZzkKyouteiKouryokuhasseiYmd(BizDate pZzkKyouteiKouryokuhasseiYmd) {
        zzkKyouteiKouryokuhasseiYmd = pZzkKyouteiKouryokuhasseiYmd;
    }

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

    public BizDate getKousinYmd() {
        return kousinYmd;
    }

    public void setKousinYmd(BizDate pKousinYmd) {
        kousinYmd = pKousinYmd;
    }

    public BizDate getSinsetuYmd() {
        return sinsetuYmd;
    }

    public void setSinsetuYmd(BizDate pSinsetuYmd) {
        sinsetuYmd = pSinsetuYmd;
    }

    public BizDate getHaisiYmd() {
        return haisiYmd;
    }

    public void setHaisiYmd(BizDate pHaisiYmd) {
        haisiYmd = pHaisiYmd;
    }

    public String getBankNmKn() {
        return bankNmKn;
    }

    public void setBankNmKn(String pBankNmKn) {
        bankNmKn = pBankNmKn;
    }

    public String getSitenNmKn() {
        return sitenNmKn;
    }

    public void setSitenNmKn(String pSitenNmKn) {
        sitenNmKn = pSitenNmKn;
    }

    public String getBankNmKj() {
        return bankNmKj;
    }

    public void setBankNmKj(String pBankNmKj) {
        bankNmKj = pBankNmKj;
    }

    public String getSitenNmKj() {
        return sitenNmKj;
    }

    public void setSitenNmKj(String pSitenNmKj) {
        sitenNmKj = pSitenNmKj;
    }

    public String getBankNmEj() {
        return bankNmEj;
    }

    public void setBankNmEj(String pBankNmEj) {
        bankNmEj = pBankNmEj;
    }

    public String getSitenNmEj() {
        return sitenNmEj;
    }

    public void setSitenNmEj(String pSitenNmEj) {
        sitenNmEj = pSitenNmEj;
    }

    public BizDate getCssKyouteiKaisiYmd() {
        return cssKyouteiKaisiYmd;
    }

    public void setCssKyouteiKaisiYmd(BizDate pCssKyouteiKaisiYmd) {
        cssKyouteiKaisiYmd = pCssKyouteiKaisiYmd;
    }

    public BizDate getCssKyouteiKaijyoYmd() {
        return cssKyouteiKaijyoYmd;
    }

    public void setCssKyouteiKaijyoYmd(BizDate pCssKyouteiKaijyoYmd) {
        cssKyouteiKaijyoYmd = pCssKyouteiKaijyoYmd;
    }

    public C_Kokunaikwskameihyj getKokunaikwskameihyj() {
        return kokunaikwskameihyj;
    }

    public void setKokunaikwskameihyj(C_Kokunaikwskameihyj pKokunaikwskameihyj) {
        kokunaikwskameihyj = pKokunaikwskameihyj;
    }

    public C_HrkmKanouihyj getHrkmKanouihyj() {
        return hrkmKanouihyj;
    }

    public void setHrkmKanouihyj(C_HrkmKanouihyj pHrkmKanouihyj) {
        hrkmKanouihyj = pHrkmKanouihyj;
    }

    public BizDate getYofurikyouteikaisiYmd() {
        return yofurikyouteikaisiYmd;
    }

    public void setYofurikyouteikaisiYmd(BizDate pYofurikyouteikaisiYmd) {
        yofurikyouteikaisiYmd = pYofurikyouteikaisiYmd;
    }


    public BizDate getYofurikyouteikaijyoYmd() {
        return yofurikyouteikaijyoYmd;
    }

    public void setYofurikyouteikaijyoYmd(BizDate pYofurikyouteikaijyoYmd) {
        yofurikyouteikaijyoYmd = pYofurikyouteikaijyoYmd;
    }

    public String getItakusyakinyuuCd() {
        return itakusyakinyuuCd;
    }

    public void setItakusyakinyuuCd(String pItakusyakinyuuCd) {
        itakusyakinyuuCd = pItakusyakinyuuCd;
    }

    public String getItakusyasitenCd() {
        return itakusyasitenCd;
    }

    public void setItakusyasitenCd(String pItakusyasitenCd) {
        itakusyasitenCd = pItakusyasitenCd;
    }

    public C_YokinKbn getItakusyayokinKbn() {
        return itakusyayokinKbn;
    }

    public void setItakusyayokinKbn(C_YokinKbn pItakusyayokinKbn) {
        itakusyayokinKbn = pItakusyayokinKbn;
    }

    public String getItakusyakouzano() {
        return itakusyakouzano;
    }

    public void setItakusyakouzano(String pItakusyakouzano) {
        itakusyakouzano = pItakusyakouzano;
    }

    public C_TsrkeisanhouKbn getTsrkeisanhouKbn() {
        return tsrkeisanhouKbn;
    }

    public void setTsrkeisanhouKbn(C_TsrkeisanhouKbn pTsrkeisanhouKbn) {
        tsrkeisanhouKbn = pTsrkeisanhouKbn;
    }

    public Integer getKinyuutesuuryou() {
        return kinyuutesuuryou;
    }

    public void setKinyuutesuuryou(Integer pKinyuutesuuryou) {
        kinyuutesuuryou = pKinyuutesuuryou;
    }

    public String getItakusyacd() {
        return itakusyacd;
    }

    public void setItakusyacd(String pItakusyacd) {
        itakusyacd = pItakusyacd;
    }

    public C_TapekoukanKbn getTapekoukanKbn1() {
        return tapekoukanKbn1;
    }

    public void setTapekoukanKbn1(C_TapekoukanKbn pTapekoukanKbn1) {
        tapekoukanKbn1 = pTapekoukanKbn1;
    }

    public String getMdsisyaCd() {
        return mdsisyaCd;
    }

    public void setMdsisyaCd(String pMdsisyaCd) {
        mdsisyaCd = pMdsisyaCd;
    }

    public BizDate getZzkkyouteikaisiYmd() {
        return zzkkyouteikaisiYmd;
    }

    public void setZzkkyouteikaisiYmd(BizDate pZzkkyouteikaisiYmd) {
        zzkkyouteikaisiYmd = pZzkkyouteikaisiYmd;
    }


    public BizDate getZzkkyouteikaijyoYmd() {
        return zzkkyouteikaijyoYmd;
    }

    public void setZzkkyouteikaijyoYmd(BizDate pZzkkyouteikaijyoYmd) {
        zzkkyouteikaijyoYmd = pZzkkyouteikaijyoYmd;
    }


    public BizDate getHuhoyofuriinfokousinYmd() {
        return huhoyofuriinfokousinYmd;
    }

    public void setHuhoyofuriinfokousinYmd(BizDate pHuhoyofuriinfokousinYmd) {
        huhoyofuriinfokousinYmd = pHuhoyofuriinfokousinYmd;
    }

}
