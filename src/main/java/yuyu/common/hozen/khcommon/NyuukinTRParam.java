package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_NykhouhouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 契約保全 契約保全共通 入金TRパラメータ
 */
public class NyuukinTRParam {

    private String syoNo;

    private BizDate syoriYmd;

    private BizDate nyuukinKakusyounrkYmd;

    private C_Nykkeiro nykKeiro;

    private C_Hrkkaisuu hrkkaisuu;

    private C_NyknaiyouKbn nykNaiyouKbn;

    private C_UmuKbn iktNyuukinUmu;

    private BizDateYM jyutouYm;

    private String jyutouKaisuuY;

    private String jyutouKaisuuM;

    private BizCurrency ryosyuGk;

    private BizDate ryosyuYmd;

    private String kzHurikaeBankCd;

    private String kzHurikaeSitenCd;

    private String suitoSoshikiCd;

    private C_YouhiKbn pdfOutYouhi = C_YouhiKbn.HUYOU;

    private BizDate zengetumatuDenSimeYmd;

    private C_NykhouhouKbn nykhouhouKbn;

    private BizDate denymd;

    private String tabakarikanjyono;

    private C_TkiktbrisyuruiKbn tkiktbrisyuruiKbn;

    private BizDate seisonmotoDenymd;

    private BizDate nyknkwsratekijyunymd;

    private BizDate seisantgkmkHasseidenYmd;

    private String creditkessaiyouno;

    private C_Syuudaikocd syuudaikocd;

    private C_CreditUriageSeikyuuKbn creditUriageSeikyuuKbn;

    public NyuukinTRParam() {
        super();
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public BizDate getNyuukinKakusyounrkYmd() {
        return nyuukinKakusyounrkYmd;
    }

    public void setNyuukinKakusyounrkYmd(BizDate pNyuukinKakusyounrkYmd) {
        nyuukinKakusyounrkYmd = pNyuukinKakusyounrkYmd;
    }

    public C_Nykkeiro getNykKeiro() {
        return nykKeiro;
    }

    public void setNykKeiro(C_Nykkeiro pNykKeiro) {
        nykKeiro = pNykKeiro;
    }

    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    public C_NyknaiyouKbn getNykNaiyouKbn() {
        return nykNaiyouKbn;
    }

    public void setNykNaiyouKbn(C_NyknaiyouKbn pNykNaiyouKbn) {
        nykNaiyouKbn = pNykNaiyouKbn;
    }

    public C_UmuKbn getIktnyuukinnumu() {
        return iktNyuukinUmu;
    }

    public void setIktnyuukinnumu(C_UmuKbn pIktNyuukinUmu) {
        iktNyuukinUmu = pIktNyuukinUmu;
    }

    public BizDateYM getJyutouYm() {
        return jyutouYm;
    }

    public void setJyutouYm(BizDateYM pJyutouYm) {
        jyutouYm = pJyutouYm;
    }

    public String getJyutouKaisuuY() {
        return jyutouKaisuuY;
    }

    public void setJyutouKaisuuY(String pJyutouKaisuuY) {
        jyutouKaisuuY = pJyutouKaisuuY;
    }

    public String getJyutouKaisuuM() {
        return jyutouKaisuuM;
    }

    public void setJyutouKaisuuM(String pJyutouKaisuuM) {
        jyutouKaisuuM = pJyutouKaisuuM;
    }

    public BizCurrency getRyosyuGk() {
        return ryosyuGk;
    }

    public void setRyosyuGk(BizCurrency pRyosyuGk) {
        ryosyuGk = pRyosyuGk;
    }

    public BizDate getRyosyuYmd() {
        return ryosyuYmd;
    }

    public void setRyosyuYmd(BizDate pRyosyuYmd) {
        ryosyuYmd = pRyosyuYmd;
    }

    public String getKzHurikaeBankCd() {
        return kzHurikaeBankCd;
    }

    public void setKzHurikaeBankCd(String pKzHurikaeBankCd) {
        kzHurikaeBankCd = pKzHurikaeBankCd;
    }

    public String getKzHurikaeSitenCd() {
        return kzHurikaeSitenCd;
    }

    public void setKzHurikaeSitenCd(String pKzHurikaeSitenCd) {
        kzHurikaeSitenCd = pKzHurikaeSitenCd;
    }

    public String getSuitoSoshikiCd() {
        return suitoSoshikiCd;
    }

    public void setSuitoSoshikiCd(String pSuitoSoshikiCd) {
        suitoSoshikiCd = pSuitoSoshikiCd;
    }

    public C_YouhiKbn getPdfOutYouhi() {
        return pdfOutYouhi;
    }

    public void setPdfOutYouhi(C_YouhiKbn pPdfOutYouhi) {
        pdfOutYouhi = pPdfOutYouhi;
    }

    public BizDate getZengetumatuDenSimeYmd() {
        return zengetumatuDenSimeYmd;
    }

    public void setZengetumatuDenSimeYmd(BizDate pZengetumatuDenSimeYmd) {
        zengetumatuDenSimeYmd = pZengetumatuDenSimeYmd;
    }

    public C_NykhouhouKbn getNykhouhouKbn() {
        return nykhouhouKbn;
    }

    public void setNykhouhouKbn(C_NykhouhouKbn pNykhouhouKbn) {
        nykhouhouKbn = pNykhouhouKbn;
    }

    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        this.denymd = pDenymd;
    }

    public String getTabakarikanjyono() {
        return tabakarikanjyono;
    }

    public void setTabakarikanjyono(String pTabakarikanjyono) {
        this.tabakarikanjyono = pTabakarikanjyono;
    }

    public C_TkiktbrisyuruiKbn getTkiktbrisyuruiKbn() {
        return tkiktbrisyuruiKbn;
    }

    public void setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn pTkiktbrisyuruiKbn) {
        this.tkiktbrisyuruiKbn = pTkiktbrisyuruiKbn;
    }

    public BizDate getSeisonmotoDenymd() {
        return seisonmotoDenymd;
    }

    public void setSeisonmotoDenymd(BizDate pSeisonmotoDenymd) {
        seisonmotoDenymd = pSeisonmotoDenymd;
    }

    public BizDate getNyknkwsratekijyunymd() {
        return nyknkwsratekijyunymd;
    }

    public void setNyknkwsratekijyunymd(BizDate pNyknkwsratekijyunymd) {
        nyknkwsratekijyunymd = pNyknkwsratekijyunymd;
    }

    public BizDate getSeisantgkmkHasseidenYmd() {
        return seisantgkmkHasseidenYmd;
    }

    public void setSeisantgkmkHasseidenYmd(BizDate pSeisantgkmkHasseidenYmd) {
        seisantgkmkHasseidenYmd = pSeisantgkmkHasseidenYmd;
    }

    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

    public C_Syuudaikocd getSyuudaikocd() {
        return syuudaikocd;
    }

    public void setSyuudaikocd(C_Syuudaikocd pSyuudaikocd) {
        syuudaikocd = pSyuudaikocd;
    }

    public C_CreditUriageSeikyuuKbn getCreditUriageSeikyuuKbn() {
        return creditUriageSeikyuuKbn;
    }

    public void setCreditUriageSeikyuuKbn(C_CreditUriageSeikyuuKbn pCreditUriageSeikyuuKbn) {
        creditUriageSeikyuuKbn = pCreditUriageSeikyuuKbn;
    }
}
