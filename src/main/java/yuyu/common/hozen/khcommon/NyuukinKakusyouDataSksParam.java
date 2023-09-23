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

/**
 * 契約保全 契約保全共通 入金確証データ作成パラメータ
 */
public class NyuukinKakusyouDataSksParam {

    private String syoNo;

    private BizDate nykSyoriYmd;

    private BizDate nyuukinKakusyounrkYmd;

    private C_Nykkeiro nykKeiro;

    private C_Hrkkaisuu hrkkaisuu;

    private C_NyknaiyouKbn nykNaiyouKbn;

    private C_UmuKbn iktNyuukinUmu;

    private BizDateYM jyutouYm;

    private Integer jyutouKaisuuY;

    private Integer jyutouKaisuuM;

    private BizCurrency ryosyuGk;

    private BizDate ryosyuYmd;

    private String denrenNo;

    private Integer edano;

    private String suitouBumonCd;

    private  String henkousikibetukey;

    private C_NykhouhouKbn nykhouhoukbn;

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    private String kzHurikaeBankCd;

    private String kzHurikaeSitenCd;

    private String tabakarikanjyono;

    private BizDate nykdenYmd;

    private String suitoSoshikiCd;

    private String creditKessaiyouNo;

    private C_Syuudaikocd syuudaikoCd;

    private C_CreditUriageSeikyuuKbn creditUriageSeikyuuKbn;

    public NyuukinKakusyouDataSksParam() {
        super();
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public BizDate getNykSyoriYmd() {
        return nykSyoriYmd;
    }

    public void setNykSyoriYmd(BizDate pNykSyoriYmd) {
        nykSyoriYmd = pNykSyoriYmd;
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

    public C_UmuKbn getIktNyuukinUmu() {
        return iktNyuukinUmu;
    }

    public void setIktNyuukinUmu(C_UmuKbn pIktNyuukinUmu) {
        iktNyuukinUmu = pIktNyuukinUmu;
    }

    public BizDateYM getJyutouYm() {
        return jyutouYm;
    }

    public void setJyutouYm(BizDateYM pJyutouYm) {
        jyutouYm = pJyutouYm;
    }

    public Integer getJyutouKaisuuY() {
        return jyutouKaisuuY;
    }

    public void setJyutouKaisuuY(Integer pJyutouKaisuuY) {
        jyutouKaisuuY = pJyutouKaisuuY;
    }

    public Integer getJyutouKaisuuM() {
        return jyutouKaisuuM;
    }

    public void setJyutouKaisuuM(Integer pJyutouKaisuuM) {
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

    public String getDenrenNo() {
        return denrenNo;
    }

    public void setDenrenNo(String pDenrenNo) {
        denrenNo = pDenrenNo;
    }

    public BizDate getNykdenYmd() {
        return nykdenYmd;
    }

    public void setNykdenYmd(BizDate pNykdenYmd) {
        nykdenYmd = pNykdenYmd;
    }

    public String getSuitouBumonCd() {
        return suitouBumonCd;
    }

    public void setSuitouBumonCd(String pSuitouBumonCd) {
        this.suitouBumonCd = pSuitouBumonCd;
    }

    public String getKzHurikaeBankCd() {
        return kzHurikaeBankCd;
    }

    public void setKzHurikaeBankCd(String pKzHurikaeBankCd) {
        this.kzHurikaeBankCd = pKzHurikaeBankCd;
    }

    public String getKzHurikaeSitenCd() {
        return kzHurikaeSitenCd;
    }

    public void setKzHurikaeSitenCd(String pKzHurikaeSitenCd) {
        this.kzHurikaeSitenCd = pKzHurikaeSitenCd;
    }

    public String getSuitoSoshikiCd() {
        return suitoSoshikiCd;
    }

    public void setSuitoSoshikiCd(String pSuitoSoshikiCd) {
        suitoSoshikiCd = pSuitoSoshikiCd;
    }

    public Integer getEdano() {
        return edano;
    }

    public void setEdano(Integer pEdano) {
        edano = pEdano;
    }

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    public C_NykhouhouKbn getNykhouhoukbn() {
        return nykhouhoukbn;
    }

    public void setNykhouhoukbn(C_NykhouhouKbn pNykhouhoukbn) {
        nykhouhoukbn = pNykhouhoukbn;
    }

    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    public String getTabakarikanjyono() {
        return tabakarikanjyono;
    }

    public void setTabakarikanjyono(String pTabakarikanjyono) {
        tabakarikanjyono = pTabakarikanjyono;
    }

    public String getCreditKessaiyouNo() {
        return creditKessaiyouNo;
    }

    public void setCreditKessaiyouNo(String pCreditKessaiyouNo) {
        creditKessaiyouNo = pCreditKessaiyouNo;
    }

    public C_Syuudaikocd getSyuudaikoCd() {
        return syuudaikoCd;
    }

    public void setSyuudaikoCd(C_Syuudaikocd pSyuudaikocd) {
        syuudaikoCd = pSyuudaikocd;
    }

    public C_CreditUriageSeikyuuKbn getCreditUriageSeikyuuKbn() {
        return creditUriageSeikyuuKbn;
    }

    public void setCreditUriageSeikyuuKbn(C_CreditUriageSeikyuuKbn pCreditUriageSeikyuuKbn) {
        creditUriageSeikyuuKbn = pCreditUriageSeikyuuKbn;
    }
}
