package yuyu.common.biz.kaikei;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 経理・会計 時効消滅後資金移動額計算元Beanクラス
 */
public class BzJkuSymtgoSknidougkKeisanmtBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public BzJkuSymtgoSknidougkKeisanmtBean() {
        super();
    }

    private String syono;

    private String syouhncd;

    private C_Tuukasyu kyktuukasyu;

    private BizCurrency hokenkngkgoukeiKyktuuka;

    private BizCurrency misyuupKyktuuka;

    private BizCurrency zennouseisankinKyktuuka;

    private BizCurrency mikeikapKyktuuka;

    private BizDate zennouseisankijyunymd;

    private BizDateYM mikeikapjyuutouym;

    private BizCurrency zitkazkrknstituka;

    private BizDate kykymd;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        this.syouhncd = pSyouhncd;
    }

    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        this.kyktuukasyu = pKyktuukasyu;
    }

    public BizCurrency getHokenkngkgoukeiKyktuuka() {
        return hokenkngkgoukeiKyktuuka;
    }

    public void setHokenkngkgoukeiKyktuuka(BizCurrency pHokenkngkgoukeiKyktuuka) {
        this.hokenkngkgoukeiKyktuuka = pHokenkngkgoukeiKyktuuka;
    }

    public BizCurrency getMisyuupKyktuuka() {
        return misyuupKyktuuka;
    }

    public void setMisyuupKyktuuka(BizCurrency pMisyuupKyktuuka) {
        this.misyuupKyktuuka = pMisyuupKyktuuka;
    }

    public BizCurrency getZennouseisankinKyktuuka() {
        return zennouseisankinKyktuuka;
    }

    public void setZennouseisankinKyktuuka(BizCurrency pZennouseisankinKyktuuka) {
        this.zennouseisankinKyktuuka = pZennouseisankinKyktuuka;
    }

    public BizCurrency getMikeikapKyktuuka() {
        return mikeikapKyktuuka;
    }

    public void setMikeikapKyktuuka(BizCurrency pMikeikapKyktuuka) {
        this.mikeikapKyktuuka = pMikeikapKyktuuka;
    }

    public BizDate getZennouseisankijyunymd() {
        return zennouseisankijyunymd;
    }

    public void setZennouseisankijyunymd(BizDate pZennouseisankijyunymd) {
        this.zennouseisankijyunymd = pZennouseisankijyunymd;
    }

    public BizDateYM getMikeikapjyuutouym() {
        return mikeikapjyuutouym;
    }

    public void setMikeikapjyuutouym(BizDateYM pMikeikapjyuutouym) {
        this.mikeikapjyuutouym = pMikeikapjyuutouym;
    }

    public BizCurrency getZitkazkrknstituka() {
        return zitkazkrknstituka;
    }

    public void setZitkazkrknstituka(BizCurrency pZitkazkrknstituka) {
        this.zitkazkrknstituka = pZitkazkrknstituka;
    }

    public BizDate getKykymd() {
        return kykymd;
    }

    public void setKykymd(BizDate pKykymd) {
        this.kykymd = pKykymd;
    }

}
