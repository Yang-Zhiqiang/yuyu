package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）円建変更契約ＣＳＶＦ データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhYendtHnkKykCsvFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhYendtHnkKykCsvFile() {
    }

    @Column(order = 1, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 2, label = "円建変更日")
    private String ifcYendthnkymd;

    public String getIfcYendthnkymd() {
        return ifcYendthnkymd;
    }

    public void setIfcYendthnkymd(String pIfcYendthnkymd) {
        ifcYendthnkymd = pIfcYendthnkymd;
    }

    @Column(order = 3, label = "受付処理区分")
    private String ifcUktksyorikbn;

    public String getIfcUktksyorikbn() {
        return ifcUktksyorikbn;
    }

    public void setIfcUktksyorikbn(String pIfcUktksyorikbn) {
        ifcUktksyorikbn = pIfcUktksyorikbn;
    }

    @Column(order = 4, label = "到達金額")
    private String ifcToutatukngk;

    public String getIfcToutatukngk() {
        return ifcToutatukngk;
    }

    public void setIfcToutatukngk(String pIfcToutatukngk) {
        ifcToutatukngk = pIfcToutatukngk;
    }

    @Column(order = 5, label = "円建変更時返戻金")
    private String ifcYendthnkhr;

    public String getIfcYendthnkhr() {
        return ifcYendthnkhr;
    }

    public void setIfcYendthnkhr(String pIfcYendthnkhr) {
        ifcYendthnkhr = pIfcYendthnkhr;
    }

    @Column(order = 6, label = "（円建）基準金額")
    private String ifcYendtkijyunkngk;

    public String getIfcYendtkijyunkngk() {
        return ifcYendtkijyunkngk;
    }

    public void setIfcYendtkijyunkngk(String pIfcYendtkijyunkngk) {
        ifcYendtkijyunkngk = pIfcYendtkijyunkngk;
    }

    @Column(order = 7, label = "基本Ｓ")
    private String ifcYendthnkkihons;

    public String getIfcYendthnkkihons() {
        return ifcYendthnkkihons;
    }

    public void setIfcYendthnkkihons(String pIfcYendthnkkihons) {
        ifcYendthnkkihons = pIfcYendthnkkihons;
    }

    @Column(order = 8, label = "商品名")
    private String ifcSyouhnnm;

    public String getIfcSyouhnnm() {
        return ifcSyouhnnm;
    }

    public void setIfcSyouhnnm(String pIfcSyouhnnm) {
        ifcSyouhnnm = pIfcSyouhnnm;
    }

    @Column(order = 9, label = "親代理店コード")
    private String ifcOyadrtencd;

    public String getIfcOyadrtencd() {
        return ifcOyadrtencd;
    }

    public void setIfcOyadrtencd(String pIfcOyadrtencd) {
        ifcOyadrtencd = pIfcOyadrtencd;
    }

    @Column(order = 10, label = "代理店コード")
    private String ifcDrtencd;

    public String getIfcDrtencd() {
        return ifcDrtencd;
    }

    public void setIfcDrtencd(String pIfcDrtencd) {
        ifcDrtencd = pIfcDrtencd;
    }

    @Column(order = 11, label = "共同扱親代理店コード")
    private String ifcKydatkioyadrtencd;

    public String getIfcKydatkioyadrtencd() {
        return ifcKydatkioyadrtencd;
    }

    public void setIfcKydatkioyadrtencd(String pIfcKydatkioyadrtencd) {
        ifcKydatkioyadrtencd = pIfcKydatkioyadrtencd;
    }

    @Column(order = 12, label = "共同扱代理店コード")
    private String ifcKydatkidrtencd;

    public String getIfcKydatkidrtencd() {
        return ifcKydatkidrtencd;
    }

    public void setIfcKydatkidrtencd(String pIfcKydatkidrtencd) {
        ifcKydatkidrtencd = pIfcKydatkidrtencd;
    }

    @Column(order = 13, label = "申込年月日")
    private String ifcMusymd;

    public String getIfcMusymd() {
        return ifcMusymd;
    }

    public void setIfcMusymd(String pIfcMusymd) {
        ifcMusymd = pIfcMusymd;
    }

    @Column(order = 14, label = "既払込保険料（ＭＦ）")
    private String ifcKihrkmpmf;

    public String getIfcKihrkmpmf() {
        return ifcKihrkmpmf;
    }

    public void setIfcKihrkmpmf(String pIfcKihrkmpmf) {
        ifcKihrkmpmf = pIfcKihrkmpmf;
    }

    @Column(order = 15, label = "指定通貨建一時払保険料")
    private String ifcSiteituukaitijibrp;

    public String getIfcSiteituukaitijibrp() {
        return ifcSiteituukaitijibrp;
    }

    public void setIfcSiteituukaitijibrp(String pIfcSiteituukaitijibrp) {
        ifcSiteituukaitijibrp = pIfcSiteituukaitijibrp;
    }

    @Column(order = 16, label = "払込通貨建一時払保険料")
    private String ifcHrktuukaitijibrp;

    public String getIfcHrktuukaitijibrp() {
        return ifcHrktuukaitijibrp;
    }

    public void setIfcHrktuukaitijibrp(String pIfcHrktuukaitijibrp) {
        ifcHrktuukaitijibrp = pIfcHrktuukaitijibrp;
    }

    @Column(order = 17, label = "主契約保険期間")
    private String ifcSyuhknkkn;

    public String getIfcSyuhknkkn() {
        return ifcSyuhknkkn;
    }

    public void setIfcSyuhknkkn(String pIfcSyuhknkkn) {
        ifcSyuhknkkn = pIfcSyuhknkkn;
    }

    @Column(order = 18, label = "漢字契約者名（顧客データ）")
    private String ifcKnjkyksyamei;

    public String getIfcKnjkyksyamei() {
        return ifcKnjkyksyamei;
    }

    public void setIfcKnjkyksyamei(String pIfcKnjkyksyamei) {
        ifcKnjkyksyamei = pIfcKnjkyksyamei;
    }

    @Column(order = 19, label = "契約状態区分")
    private String ifcKykjyutikbnyendthnkkykf;

    public String getIfcKykjyutikbnyendthnkkykf() {
        return ifcKykjyutikbnyendthnkkykf;
    }

    public void setIfcKykjyutikbnyendthnkkykf(String pIfcKykjyutikbnyendthnkkykf) {
        ifcKykjyutikbnyendthnkkykf = pIfcKykjyutikbnyendthnkkykf;
    }

    @Column(order = 20, label = "ＣＩＦコード")
    private String ifcCifcd;

    public String getIfcCifcd() {
        return ifcCifcd;
    }

    public void setIfcCifcd(String pIfcCifcd) {
        ifcCifcd = pIfcCifcd;
    }

    @Column(order = 21, label = "目標設定値")
    private String ifcTargettkmkhtstr;

    public String getIfcTargettkmkhtstr() {
        return ifcTargettkmkhtstr;
    }

    public void setIfcTargettkmkhtstr(String pIfcTargettkmkhtstr) {
        ifcTargettkmkhtstr = pIfcTargettkmkhtstr;
    }

    @Column(order = 22, label = "指定通貨コード")
    private String ifcSiteituukacd;

    public String getIfcSiteituukacd() {
        return ifcSiteituukacd;
    }

    public void setIfcSiteituukacd(String pIfcSiteituukacd) {
        ifcSiteituukacd = pIfcSiteituukacd;
    }

    @Column(order = 23, label = "払込通貨コード")
    private String ifcHrktuukacd;

    public String getIfcHrktuukacd() {
        return ifcHrktuukacd;
    }

    public void setIfcHrktuukacd(String pIfcHrktuukacd) {
        ifcHrktuukacd = pIfcHrktuukacd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
