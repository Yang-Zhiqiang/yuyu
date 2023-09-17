package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）外貨建保険明細ＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzGaikaHokenMeisaiCsvfFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzGaikaHokenMeisaiCsvfFile() {
    }

    @Column(order = 1, label = "伝票用システム区分")
    private String ifcDensyskbn;

    public String getIfcDensyskbn() {
        return ifcDensyskbn;
    }

    public void setIfcDensyskbn(String pIfcDensyskbn) {
        ifcDensyskbn = pIfcDensyskbn;
    }

    @Column(order = 2, label = "伝票データ連番")
    private String ifcDenrenno;

    public String getIfcDenrenno() {
        return ifcDenrenno;
    }

    public void setIfcDenrenno(String pIfcDenrenno) {
        ifcDenrenno = pIfcDenrenno;
    }

    @Column(order = 3, label = "枝番号")
    private String ifcEdano;

    public String getIfcEdano() {
        return ifcEdano;
    }

    public void setIfcEdano(String pIfcEdano) {
        ifcEdano = pIfcEdano;
    }

    @Column(order = 4, label = "経理用証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 5, label = "伝票日付")
    private String ifcDenymd8keta;

    public String getIfcDenymd8keta() {
        return ifcDenymd8keta;
    }

    public void setIfcDenymd8keta(String pIfcDenymd8keta) {
        ifcDenymd8keta = pIfcDenymd8keta;
    }

    @Column(order = 6, label = "貸借区分")
    private String ifcTaisyakukbn;

    public String getIfcTaisyakukbn() {
        return ifcTaisyakukbn;
    }

    public void setIfcTaisyakukbn(String pIfcTaisyakukbn) {
        ifcTaisyakukbn = pIfcTaisyakukbn;
    }

    @Column(order = 7, label = "勘定科目コード")
    private String ifcKanjyoukmkcd;

    public String getIfcKanjyoukmkcd() {
        return ifcKanjyoukmkcd;
    }

    public void setIfcKanjyoukmkcd(String pIfcKanjyoukmkcd) {
        ifcKanjyoukmkcd = pIfcKanjyoukmkcd;
    }

    @Column(order = 8, label = "出納部門コード")
    private String ifcSuitoubumoncd;

    public String getIfcSuitoubumoncd() {
        return ifcSuitoubumoncd;
    }

    public void setIfcSuitoubumoncd(String pIfcSuitoubumoncd) {
        ifcSuitoubumoncd = pIfcSuitoubumoncd;
    }

    @Column(order = 9, label = "通貨種類")
    private String ifcTuukasyu;

    public String getIfcTuukasyu() {
        return ifcTuukasyu;
    }

    public void setIfcTuukasyu(String pIfcTuukasyu) {
        ifcTuukasyu = pIfcTuukasyu;
    }

    @Column(order = 10, label = "伝票金額（外貨）")
    private String ifcDengaikagk;

    public String getIfcDengaikagk() {
        return ifcDengaikagk;
    }

    public void setIfcDengaikagk(String pIfcDengaikagk) {
        ifcDengaikagk = pIfcDengaikagk;
    }

    @Column(order = 11, label = "伝票金額（外貨）単位")
    private String ifcDengaikagktani;

    public String getIfcDengaikagktani() {
        return ifcDengaikagktani;
    }

    public void setIfcDengaikagktani(String pIfcDengaikagktani) {
        ifcDengaikagktani = pIfcDengaikagktani;
    }

    @Column(order = 12, label = "伝票用為替レート")
    private String ifcDenkawaserate;

    public String getIfcDenkawaserate() {
        return ifcDenkawaserate;
    }

    public void setIfcDenkawaserate(String pIfcDenkawaserate) {
        ifcDenkawaserate = pIfcDenkawaserate;
    }

    @Column(order = 13, label = "伝票金額（円）")
    private String ifcDenyenkagk;

    public String getIfcDenyenkagk() {
        return ifcDenyenkagk;
    }

    public void setIfcDenyenkagk(String pIfcDenyenkagk) {
        ifcDenyenkagk = pIfcDenyenkagk;
    }

    @Column(order = 14, label = "処理年月日")
    private String ifcSyoriymd8keta;

    public String getIfcSyoriymd8keta() {
        return ifcSyoriymd8keta;
    }

    public void setIfcSyoriymd8keta(String pIfcSyoriymd8keta) {
        ifcSyoriymd8keta = pIfcSyoriymd8keta;
    }

    @Column(order = 15, label = "処理コード")
    private String ifcSyoricd;

    public String getIfcSyoricd() {
        return ifcSyoricd;
    }

    public void setIfcSyoricd(String pIfcSyoricd) {
        ifcSyoricd = pIfcSyoricd;
    }

    @Column(order = 16, label = "決算調整区分")
    private String ifcKessantyouseikbn;

    public String getIfcKessantyouseikbn() {
        return ifcKessantyouseikbn;
    }

    public void setIfcKessantyouseikbn(String pIfcKessantyouseikbn) {
        ifcKessantyouseikbn = pIfcKessantyouseikbn;
    }

    @Column(order = 17, label = "伝票処理区分")
    private String ifcDensyorikbn;

    public String getIfcDensyorikbn() {
        return ifcDensyorikbn;
    }

    public void setIfcDensyorikbn(String pIfcDensyorikbn) {
        ifcDensyorikbn = pIfcDensyorikbn;
    }

    @Column(order = 18, label = "契約日")
    private String ifcKykymdstr;

    public String getIfcKykymdstr() {
        return ifcKykymdstr;
    }

    public void setIfcKykymdstr(String pIfcKykymdstr) {
        ifcKykymdstr = pIfcKykymdstr;
    }

    @Column(order = 19, label = "商品世代番号")
    private String ifcSyouhnsdno;

    public String getIfcSyouhnsdno() {
        return ifcSyouhnsdno;
    }

    public void setIfcSyouhnsdno(String pIfcSyouhnsdno) {
        ifcSyouhnsdno = pIfcSyouhnsdno;
    }

    @Column(order = 20, label = "責任開始日")
    private String ifcSknnkaisiymdstr;

    public String getIfcSknnkaisiymdstr() {
        return ifcSknnkaisiymdstr;
    }

    public void setIfcSknnkaisiymdstr(String pIfcSknnkaisiymdstr) {
        ifcSknnkaisiymdstr = pIfcSknnkaisiymdstr;
    }

    @Column(order = 21, label = "申込日")
    private String ifcMosymd;

    public String getIfcMosymd() {
        return ifcMosymd;
    }

    public void setIfcMosymd(String pIfcMosymd) {
        ifcMosymd = pIfcMosymd;
    }

    @Column(order = 22, label = "初回Ｐ領収日")
    private String ifcFstpryosyuymd;

    public String getIfcFstpryosyuymd() {
        return ifcFstpryosyuymd;
    }

    public void setIfcFstpryosyuymd(String pIfcFstpryosyuymd) {
        ifcFstpryosyuymd = pIfcFstpryosyuymd;
    }

    @Column(order = 23, label = "契約通貨種類")
    private String ifcKyktuukasyu;

    public String getIfcKyktuukasyu() {
        return ifcKyktuukasyu;
    }

    public void setIfcKyktuukasyu(String pIfcKyktuukasyu) {
        ifcKyktuukasyu = pIfcKyktuukasyu;
    }

    @Column(order = 24, label = "契約通貨金額")
    private String ifcKeiyakutuukagk;

    public String getIfcKeiyakutuukagk() {
        return ifcKeiyakutuukagk;
    }

    public void setIfcKeiyakutuukagk(String pIfcKeiyakutuukagk) {
        ifcKeiyakutuukagk = pIfcKeiyakutuukagk;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
