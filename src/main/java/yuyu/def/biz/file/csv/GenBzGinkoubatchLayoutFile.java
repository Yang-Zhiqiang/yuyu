package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）銀行情報ファイルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzGinkoubatchLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzGinkoubatchLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）金融機関コード")
    private String ifcKinyuucd;

    public String getIfcKinyuucd() {
        return ifcKinyuucd;
    }

    public void setIfcKinyuucd(String pIfcKinyuucd) {
        ifcKinyuucd = pIfcKinyuucd;
    }

    @Column(order = 2, label = "（ＩＦｃ）支店コード")
    private String ifcSitencd;

    public String getIfcSitencd() {
        return ifcSitencd;
    }

    public void setIfcSitencd(String pIfcSitencd) {
        ifcSitencd = pIfcSitencd;
    }

    @Column(order = 3, label = "（ＩＦｃ）銀行名（カナ）")
    private String ifcBanknmkn;

    public String getIfcBanknmkn() {
        return ifcBanknmkn;
    }

    public void setIfcBanknmkn(String pIfcBanknmkn) {
        ifcBanknmkn = pIfcBanknmkn;
    }

    @Column(order = 4, label = "（ＩＦｃ）銀行名（漢字）")
    private String ifcBanknmkj;

    public String getIfcBanknmkj() {
        return ifcBanknmkj;
    }

    public void setIfcBanknmkj(String pIfcBanknmkj) {
        ifcBanknmkj = pIfcBanknmkj;
    }

    @Column(order = 5, label = "（ＩＦｃ）支店名（カナ）")
    private String ifcSitennmkn;

    public String getIfcSitennmkn() {
        return ifcSitennmkn;
    }

    public void setIfcSitennmkn(String pIfcSitennmkn) {
        ifcSitennmkn = pIfcSitennmkn;
    }

    @Column(order = 6, label = "（ＩＦｃ）支店名（漢字）")
    private String ifcSitennmkj;

    public String getIfcSitennmkj() {
        return ifcSitennmkj;
    }

    public void setIfcSitennmkj(String pIfcSitennmkj) {
        ifcSitennmkj = pIfcSitennmkj;
    }

    @Column(order = 7, label = "（ＩＦｃ）郵便番号")
    private String ifcYno;

    public String getIfcYno() {
        return ifcYno;
    }

    public void setIfcYno(String pIfcYno) {
        ifcYno = pIfcYno;
    }

    @Column(order = 8, label = "（ＩＦｃ）店舗所在地(漢字)")
    private String ifcTenposyozaitikj;

    public String getIfcTenposyozaitikj() {
        return ifcTenposyozaitikj;
    }

    public void setIfcTenposyozaitikj(String pIfcTenposyozaitikj) {
        ifcTenposyozaitikj = pIfcTenposyozaitikj;
    }

    @Column(order = 9, label = "（ＩＦｃ）電話番号")
    private String ifcTelno;

    public String getIfcTelno() {
        return ifcTelno;
    }

    public void setIfcTelno(String pIfcTelno) {
        ifcTelno = pIfcTelno;
    }

    @Column(order = 10, label = "（ＩＦｃ）手形交換所番号")
    private String ifcTgtkoukanjyono;

    public String getIfcTgtkoukanjyono() {
        return ifcTgtkoukanjyono;
    }

    public void setIfcTgtkoukanjyono(String pIfcTgtkoukanjyono) {
        ifcTgtkoukanjyono = pIfcTgtkoukanjyono;
    }

    @Column(order = 11, label = "（ＩＦｃ）並びコード")
    private String ifcNarabicd;

    public String getIfcNarabicd() {
        return ifcNarabicd;
    }

    public void setIfcNarabicd(String pIfcNarabicd) {
        ifcNarabicd = pIfcNarabicd;
    }

    @Column(order = 12, label = "（ＩＦｃ）内国為替制度加盟")
    private String ifcNaikokukwsseidokamei;

    public String getIfcNaikokukwsseidokamei() {
        return ifcNaikokukwsseidokamei;
    }

    public void setIfcNaikokukwsseidokamei(String pIfcNaikokukwsseidokamei) {
        ifcNaikokukwsseidokamei = pIfcNaikokukwsseidokamei;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
