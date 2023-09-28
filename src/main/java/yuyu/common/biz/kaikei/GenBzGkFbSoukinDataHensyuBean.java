package yuyu.common.biz.kaikei;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * （共通）外貨ＦＢ送金データ編集BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzGkFbSoukinDataHensyuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzGkFbSoukinDataHensyuBean() {
    }

    private String ibDenrenno;

    public String getIbDenrenno() {
        return ibDenrenno;
    }

    public void setIbDenrenno(String pIbDenrenno) {
        ibDenrenno = pIbDenrenno;
    }

    private Integer ibEdano;

    public Integer getIbEdano() {
        return ibEdano;
    }

    public void setIbEdano(Integer pIbEdano) {
        ibEdano = pIbEdano;
    }

    private C_DensysKbn ibDensyskbn;

    public C_DensysKbn getIbDensyskbn() {
        return ibDensyskbn;
    }

    public void setIbDensyskbn(C_DensysKbn pIbDensyskbn) {
        ibDensyskbn = pIbDensyskbn;
    }

    private String ibSyoricd;

    public String getIbSyoricd() {
        return ibSyoricd;
    }

    public void setIbSyoricd(String pIbSyoricd) {
        ibSyoricd = pIbSyoricd;
    }

    private String ibSyorisosikicd;

    public String getIbSyorisosikicd() {
        return ibSyorisosikicd;
    }

    public void setIbSyorisosikicd(String pIbSyorisosikicd) {
        ibSyorisosikicd = pIbSyorisosikicd;
    }

    private BizDate ibSyoriymd;

    public BizDate getIbSyoriymd() {
        return ibSyoriymd;
    }

    public void setIbSyoriymd(BizDate pIbSyoriymd) {
        ibSyoriymd = pIbSyoriymd;
    }

    private BizDate ibDenymd;

    public BizDate getIbDenymd() {
        return ibDenymd;
    }

    public void setIbDenymd(BizDate pIbDenymd) {
        ibDenymd = pIbDenymd;
    }

    private String ibSyono;

    public String getIbSyono() {
        return ibSyono;
    }

    public void setIbSyono(String pIbSyono) {
        ibSyono = pIbSyono;
    }

    private C_ShrhousiteiKbn ibShrhousiteikbn;

    public C_ShrhousiteiKbn getIbShrhousiteikbn() {
        return ibShrhousiteikbn;
    }

    public void setIbShrhousiteikbn(C_ShrhousiteiKbn pIbShrhousiteikbn) {
        ibShrhousiteikbn = pIbShrhousiteikbn;
    }

    private String ibBankcd;

    public String getIbBankcd() {
        return ibBankcd;
    }

    public void setIbBankcd(String pIbBankcd) {
        ibBankcd = pIbBankcd;
    }

    private String ibBanknmej;

    public String getIbBanknmej() {
        return ibBanknmej;
    }

    public void setIbBanknmej(String pIbBanknmej) {
        ibBanknmej = pIbBanknmej;
    }

    private String ibSitencd;

    public String getIbSitencd() {
        return ibSitencd;
    }

    public void setIbSitencd(String pIbSitencd) {
        ibSitencd = pIbSitencd;
    }

    private String ibSitennmej;

    public String getIbSitennmej() {
        return ibSitennmej;
    }

    public void setIbSitennmej(String pIbSitennmej) {
        ibSitennmej = pIbSitennmej;
    }

    private String ibKouzano;

    public String getIbKouzano() {
        return ibKouzano;
    }

    public void setIbKouzano(String pIbKouzano) {
        ibKouzano = pIbKouzano;
    }

    private String ibKzmeiginmei;

    public String getIbKzmeiginmei() {
        return ibKzmeiginmei;
    }

    public void setIbKzmeiginmei(String pIbKzmeiginmei) {
        ibKzmeiginmei = pIbKzmeiginmei;
    }

    private C_Tuukasyu ibShrtuukasyu;

    public C_Tuukasyu getIbShrtuukasyu() {
        return ibShrtuukasyu;
    }

    public void setIbShrtuukasyu(C_Tuukasyu pIbShrtuukasyu) {
        ibShrtuukasyu = pIbShrtuukasyu;
    }

    private BizCurrency ibGaikashrgk;

    public BizCurrency getIbGaikashrgk() {
        return ibGaikashrgk;
    }

    public void setIbGaikashrgk(BizCurrency pIbGaikashrgk) {
        ibGaikashrgk = pIbGaikashrgk;
    }

    private C_Tuukasyu ibKyktuukasyu;

    public C_Tuukasyu getIbKyktuukasyu() {
        return ibKyktuukasyu;
    }

    public void setIbKyktuukasyu(C_Tuukasyu pIbKyktuukasyu) {
        ibKyktuukasyu = pIbKyktuukasyu;
    }

    private BizCurrency ibCrossrateshrgk;

    public BizCurrency getIbCrossrateshrgk() {
        return ibCrossrateshrgk;
    }

    public void setIbCrossrateshrgk(BizCurrency pIbCrossrateshrgk) {
        ibCrossrateshrgk = pIbCrossrateshrgk;
    }

    private BizNumber ibSoukinkwsrate;

    public BizNumber getIbSoukinkwsrate() {
        return ibSoukinkwsrate;
    }

    public void setIbSoukinkwsrate(BizNumber pIbSoukinkwsrate) {
        ibSoukinkwsrate = pIbSoukinkwsrate;
    }

    private String ibKousinkinou;

    public String getIbKousinkinou() {
        return ibKousinkinou;
    }

    public void setIbKousinkinou(String pIbKousinkinou) {
        ibKousinkinou = pIbKousinkinou;
    }

    private String ibGyoumuKousinsyaId;

    public String getIbGyoumuKousinsyaId() {
        return ibGyoumuKousinsyaId;
    }

    public void setIbGyoumuKousinsyaId(String pIbGyoumuKousinsyaId) {
        ibGyoumuKousinsyaId = pIbGyoumuKousinsyaId;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
