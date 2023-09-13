package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tuukasyu;

/**
 * （保全）将来解約返戻金試算表帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSyouraiwSisanhyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhSyouraiwSisanhyouBean() {
    }

    private String irUsernm;

    public String getIrUsernm() {
        return irUsernm;
    }

    public void setIrUsernm(String pIrUsernm) {
        irUsernm = pIrUsernm;
    }

    private String irSakuseiymdtime;

    public String getIrSakuseiymdtime() {
        return irSakuseiymdtime;
    }

    public void setIrSakuseiymdtime(String pIrSakuseiymdtime) {
        irSakuseiymdtime = pIrSakuseiymdtime;
    }

    private String irWarningmsg;

    public String getIrWarningmsg() {
        return irWarningmsg;
    }

    public void setIrWarningmsg(String pIrWarningmsg) {
        irWarningmsg = pIrWarningmsg;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irSisanymd;

    public String getIrSisanymd() {
        return irSisanymd;
    }

    public void setIrSisanymd(String pIrSisanymd) {
        irSisanymd = pIrSisanymd;
    }

    private String irKykymd;

    public String getIrKykymd() {
        return irKykymd;
    }

    public void setIrKykymd(String pIrKykymd) {
        irKykymd = pIrKykymd;
    }

    private Integer irKanyuujinen;

    public Integer getIrKanyuujinen() {
        return irKanyuujinen;
    }

    public void setIrKanyuujinen(Integer pIrKanyuujinen) {
        irKanyuujinen = pIrKanyuujinen;
    }

    private C_Seibetu irSeibetu;

    public C_Seibetu getIrSeibetu() {
        return irSeibetu;
    }

    public void setIrSeibetu(C_Seibetu pIrSeibetu) {
        irSeibetu = pIrSeibetu;
    }

    private String irHknsyurui;

    public String getIrHknsyurui() {
        return irHknsyurui;
    }

    public void setIrHknsyurui(String pIrHknsyurui) {
        irHknsyurui = pIrHknsyurui;
    }

    private BizCurrency irHkgkgaika;

    public BizCurrency getIrHkgkgaika() {
        return irHkgkgaika;
    }

    public void setIrHkgkgaika(BizCurrency pIrHkgkgaika) {
        irHkgkgaika = pIrHkgkgaika;
    }

    private C_Tuukasyu irKyktuukasyu;

    public C_Tuukasyu getIrKyktuukasyu() {
        return irKyktuukasyu;
    }

    public void setIrKyktuukasyu(C_Tuukasyu pIrKyktuukasyu) {
        irKyktuukasyu = pIrKyktuukasyu;
    }

    private String irYendthnkymd;

    public String getIrYendthnkymd() {
        return irYendthnkymd;
    }

    public void setIrYendthnkymd(String pIrYendthnkymd) {
        irYendthnkymd = pIrYendthnkymd;
    }

    private BizCurrency irItijibrp;

    public BizCurrency getIrItijibrp() {
        return irItijibrp;
    }

    public void setIrItijibrp(BizCurrency pIrItijibrp) {
        irItijibrp = pIrItijibrp;
    }

    private C_HknkknsmnKbn irHknkknsmnkbn;

    public C_HknkknsmnKbn getIrHknkknsmnkbn() {
        return irHknkknsmnkbn;
    }

    public void setIrHknkknsmnkbn(C_HknkknsmnKbn pIrHknkknsmnkbn) {
        irHknkknsmnkbn = pIrHknkknsmnkbn;
    }

    private BizNumber irTeiritutmttrate;

    public BizNumber getIrTeiritutmttrate() {
        return irTeiritutmttrate;
    }

    public void setIrTeiritutmttrate(BizNumber pIrTeiritutmttrate) {
        irTeiritutmttrate = pIrTeiritutmttrate;
    }

    private BizNumber irSisuurendourate;

    public BizNumber getIrSisuurendourate() {
        return irSisuurendourate;
    }

    public void setIrSisuurendourate(BizNumber pIrSisuurendourate) {
        irSisuurendourate = pIrSisuurendourate;
    }

    private Integer irSyouhnhanteikekka;

    public Integer getIrSyouhnhanteikekka() {
        return irSyouhnhanteikekka;
    }

    public void setIrSyouhnhanteikekka(Integer pIrSyouhnhanteikekka) {
        irSyouhnhanteikekka = pIrSyouhnhanteikekka;
    }

    private String irHknkkn;

    public String getIrHknkkn() {
        return irHknkkn;
    }

    public void setIrHknkkn(String pIrHknkkn) {
        irHknkkn = pIrHknkkn;
    }

    private Integer irHrkkkn;

    public Integer getIrHrkkkn() {
        return irHrkkkn;
    }

    public void setIrHrkkkn(Integer pIrHrkkkn) {
        irHrkkkn = pIrHrkkkn;
    }

    private C_HrkkknsmnKbn irHrkkknsmnkbn;

    public C_HrkkknsmnKbn getIrHrkkknsmnkbn() {
        return irHrkkknsmnkbn;
    }

    public void setIrHrkkknsmnkbn(C_HrkkknsmnKbn pIrHrkkknsmnkbn) {
        irHrkkknsmnkbn = pIrHrkkknsmnkbn;
    }

    private BizCurrency irHokenryou;

    public BizCurrency getIrHokenryou() {
        return irHokenryou;
    }

    public void setIrHokenryou(BizCurrency pIrHokenryou) {
        irHokenryou = pIrHokenryou;
    }

    private String irTmttknitenymd;

    public String getIrTmttknitenymd() {
        return irTmttknitenymd;
    }

    public void setIrTmttknitenymd(String pIrTmttknitenymd) {
        irTmttknitenymd = pIrTmttknitenymd;
    }

    private String irKijyunkingaku;

    public String getIrKijyunkingaku() {
        return irKijyunkingaku;
    }

    public void setIrKijyunkingaku(String pIrKijyunkingaku) {
        irKijyunkingaku = pIrKijyunkingaku;
    }

    private String irNkgnsgk;

    public String getIrNkgnsgk() {
        return irNkgnsgk;
    }

    public void setIrNkgnsgk(String pIrNkgnsgk) {
        irNkgnsgk = pIrNkgnsgk;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
