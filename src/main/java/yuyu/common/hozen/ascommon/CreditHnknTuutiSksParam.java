package yuyu.common.hozen.ascommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全 案内収納共通 クレカ返金通知作成パラメータ
 */
public class CreditHnknTuutiSksParam {

    private String denrenno;

    private Integer edano;

    private BizDate denymd;

    private BizDate tyouhyouymd;

    private String henkousikibetukey;

    private C_HassouKbn hassoukbn;

    private C_ShrriyuuKbn shrriyuukbn;

    private BizDate uriageseikyuuymd;

    private C_Kanjyoukmkcd kanjyoukmkcd;

    private BizCurrency hnkngk;

    private C_KrkriyuuKbn krkriyuukbn;

    private BizDate uriageymd;

    private BizCurrency uriagegk;

    private BizDateYM jyuutouym;

    private Integer jyutoukaisuuy;

    private Integer jyutoukaisuum;

    private String creditkessaiyouno;

    private IT_AnsyuKihon ansyuKihon;

    private IT_KykKihon kykKihon;

    public CreditHnknTuutiSksParam() {
        super();
    }

    public String getDenrenno() {
        return denrenno;
    }

    public void setDenrenno(String pDenrenno) {
        denrenno = pDenrenno;
    }

    public Integer getEdano() {
        return edano;
    }

    public void setEdano(Integer pEdano) {
        edano = pEdano;
    }

    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    public C_ShrriyuuKbn getShrriyuukbn() {
        return shrriyuukbn;
    }

    public void setShrriyuukbn(C_ShrriyuuKbn pShrriyuukbn) {
        shrriyuukbn = pShrriyuukbn;
    }

    public BizDate getUriageseikyuuymd() {
        return uriageseikyuuymd;
    }

    public void setUriageseikyuuymd(BizDate pUriageseikyuuymd) {
        uriageseikyuuymd = pUriageseikyuuymd;
    }

    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return kanjyoukmkcd;
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }

    public BizCurrency getHnkngk() {
        return hnkngk;
    }

    public void setHnkngk(BizCurrency pHnkngk) {
        hnkngk = pHnkngk;
    }

    public C_KrkriyuuKbn getKrkriyuukbn() {
        return krkriyuukbn;
    }

    public void setKrkriyuukbn(C_KrkriyuuKbn pKrkriyuukbn) {
        krkriyuukbn = pKrkriyuukbn;
    }

    public BizDate getUriageymd() {
        return uriageymd;
    }

    public void setUriageymd(BizDate pUriageymd) {
        uriageymd = pUriageymd;
    }

    public BizCurrency getUriagegk() {
        return uriagegk;
    }

    public void setUriagegk(BizCurrency pUriagegk) {
        uriagegk = pUriagegk;
    }

    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
    }

    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

    public IT_AnsyuKihon getAnsyuKihon() {
        return ansyuKihon;
    }

    public void setAnsyuKihon(IT_AnsyuKihon pAnsyuKihon) {
        ansyuKihon = pAnsyuKihon;
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;
    }


}
