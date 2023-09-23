package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全共通 平準払用保険料積立金計算Bean
 */
public class KeisanVHeijyunBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private String syouhncd;

    private String ryouritusdno;

    private BizDateYM calckijyunYm;

    private BizDate kykymd;

    private BizCurrency hokenryou;

    private C_Tuukasyu kyktuukasyu;

    private C_Hhknsei hhknsei;

    private Integer hhknnen;

    private Integer hknkkn;

    private C_HknkknsmnKbn hknkknsmnkbn;

    private Integer hrkkkn;

    private C_HrkkknsmnKbn hrkkknsmnkbn;

    private C_Hrkkaisuu hrkkaisuu;

    private BizDate fstpryosyu;

    private BizNumber sitihsyuriritu;

    private BizDateYM tmttkntaisyouym;

    private BizCurrency calckaisiYmjitenv;

    private BizCurrency calckaisiYmjitensump;

    private C_KhSisanSyuruiKbn sisansyuruikbn;

    private BizDate sisansyoriYmd;

    private BizNumber sisanyoteiriritu;

    private BizNumber sisankawaserate;

    public KeisanVHeijyunBean() {
        super();
    }

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }

    public BizDateYM getCalckijyunYm() {
        return calckijyunYm;
    }

    public void setCalckijyunYm(BizDateYM pCalckijyunYm) {
        calckijyunYm = pCalckijyunYm;
    }

    public BizDate getKykymd() {
        return kykymd;
    }

    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    public BizCurrency getHokenryou() {
        return hokenryou;
    }

    public void setHokenryou(BizCurrency pHokenryou) {
        hokenryou = pHokenryou;
    }

    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    public Integer getHhknnen() {
        return hhknnen;
    }

    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    public Integer getHknkkn() {
        return hknkkn;
    }

    public void setHknkkn(Integer pHknkkn) {
        hknkkn = pHknkkn;
    }

    public C_HknkknsmnKbn getHknkknsmnkbn() {
        return hknkknsmnkbn;
    }

    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn) {
        hknkknsmnkbn = pHknkknsmnkbn;
    }

    public Integer getHrkkkn() {
        return hrkkkn;
    }

    public void setHrkkkn(Integer pHrkkkn) {
        hrkkkn = pHrkkkn;
    }

    public C_HrkkknsmnKbn getHrkkknsmnkbn() {
        return hrkkknsmnkbn;
    }

    public void setHrkkknsmnkbn(C_HrkkknsmnKbn pHrkkknsmnkbn) {
        hrkkknsmnkbn = pHrkkknsmnkbn;
    }

    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    public BizDate getFstpryosyu() {
        return fstpryosyu;
    }

    public void setFstpryosyu(BizDate pFstpryosyu) {
        fstpryosyu = pFstpryosyu;
    }

    public BizNumber getSitihsyuriritu() {
        return sitihsyuriritu;
    }

    public void setSitihsyuriritu(BizNumber pSitihsyuriritu) {
        sitihsyuriritu = pSitihsyuriritu;
    }

    public BizDateYM getTmttkntaisyouym() {
        return tmttkntaisyouym;
    }

    public void setTmttkntaisyouym(BizDateYM pTmttkntaisyouym) {
        tmttkntaisyouym = pTmttkntaisyouym;
    }

    public BizCurrency getCalckaisiYmjitenv() {
        return calckaisiYmjitenv;
    }

    public void setCalckaisiYmjitenv(BizCurrency pCalckaisiYmjitenv) {
        calckaisiYmjitenv = pCalckaisiYmjitenv;
    }

    public BizCurrency getCalckaisiYmjitensump() {
        return calckaisiYmjitensump;
    }

    public void setCalckaisiYmjitensump(BizCurrency pCalckaisiYmjitensump) {
        calckaisiYmjitensump = pCalckaisiYmjitensump;
    }

    public C_KhSisanSyuruiKbn getSisansyuruikbn() {
        return sisansyuruikbn;
    }

    public void setSisansyuruikbn(C_KhSisanSyuruiKbn pSisansyuruikbn) {
        sisansyuruikbn = pSisansyuruikbn;
    }

    public BizDate getSisansyoriYmd() {
        return sisansyoriYmd;
    }

    public void setSisansyoriYmd(BizDate pSisansyoriYmd) {
        sisansyoriYmd = pSisansyoriYmd;
    }

    public BizNumber getSisanyoteiriritu() {
        return sisanyoteiriritu;
    }

    public void setSisanyoteiriritu(BizNumber pSisanyoteiriritu) {
        sisanyoteiriritu = pSisanyoteiriritu;
    }

    public BizNumber getSisankawaserate() {
        return sisankawaserate;
    }

    public void setSisankawaserate(BizNumber pSisankawaserate) {
        sisankawaserate = pSisankawaserate;
    }

}
