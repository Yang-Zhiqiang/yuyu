package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）Ｐ未入消滅請求勧奨抽出用ＣＳＶレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhPminyuusyoumetuskcsvsakuseiLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhPminyuusyoumetuskcsvsakuseiLayoutFile() {
    }

    @Column(order = 1, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 2, label = "商品名")
    private String ifcSyouhnnm102keta;

    public String getIfcSyouhnnm102keta() {
        return ifcSyouhnnm102keta;
    }

    public void setIfcSyouhnnm102keta(String pIfcSyouhnnm102keta) {
        ifcSyouhnnm102keta = pIfcSyouhnnm102keta;
    }

    @Column(order = 3, label = "契約日")
    private BizDate ifcKykymd;

    public BizDate getIfcKykymd() {
        return ifcKykymd;
    }

    public void setIfcKykymd(BizDate pIfcKykymd) {
        ifcKykymd = pIfcKykymd;
    }

    @Column(order = 4, label = "契約者名（漢字）")
    private String ifcKnjkyksyamei;

    public String getIfcKnjkyksyamei() {
        return ifcKnjkyksyamei;
    }

    public void setIfcKnjkyksyamei(String pIfcKnjkyksyamei) {
        ifcKnjkyksyamei = pIfcKnjkyksyamei;
    }

    @Column(order = 5, label = "契約者名（カナ）")
    private String ifcKyknmkn;

    public String getIfcKyknmkn() {
        return ifcKyknmkn;
    }

    public void setIfcKyknmkn(String pIfcKyknmkn) {
        ifcKyknmkn = pIfcKyknmkn;
    }

    @Column(order = 6, label = "被保険者名（漢字）")
    private String ifcKnjhknmei;

    public String getIfcKnjhknmei() {
        return ifcKnjhknmei;
    }

    public void setIfcKnjhknmei(String pIfcKnjhknmei) {
        ifcKnjhknmei = pIfcKnjhknmei;
    }

    @Column(order = 7, label = "被保険者名（カナ）")
    private String ifcHhknsyanmkn;

    public String getIfcHhknsyanmkn() {
        return ifcHhknsyanmkn;
    }

    public void setIfcHhknsyanmkn(String pIfcHhknsyanmkn) {
        ifcHhknsyanmkn = pIfcHhknsyanmkn;
    }

    @Column(order = 8, label = "郵便番号")
    private String ifcTsinyno;

    public String getIfcTsinyno() {
        return ifcTsinyno;
    }

    public void setIfcTsinyno(String pIfcTsinyno) {
        ifcTsinyno = pIfcTsinyno;
    }

    @Column(order = 9, label = "住所")
    private String ifcTsinkaiadr;

    public String getIfcTsinkaiadr() {
        return ifcTsinkaiadr;
    }

    public void setIfcTsinkaiadr(String pIfcTsinkaiadr) {
        ifcTsinkaiadr = pIfcTsinkaiadr;
    }

    @Column(order = 10, label = "電話番号")
    private String ifcTsintelno;

    public String getIfcTsintelno() {
        return ifcTsintelno;
    }

    public void setIfcTsintelno(String pIfcTsintelno) {
        ifcTsintelno = pIfcTsintelno;
    }

    @Column(order = 11, label = "消滅日")
    private String ifcSyoumetuymd;

    public String getIfcSyoumetuymd() {
        return ifcSyoumetuymd;
    }

    public void setIfcSyoumetuymd(String pIfcSyoumetuymd) {
        ifcSyoumetuymd = pIfcSyoumetuymd;
    }

    @Column(order = 12, label = "消滅時自動送金不可理由")
    private String ifcJidousoukinhukariyuu;

    public String getIfcJidousoukinhukariyuu() {
        return ifcJidousoukinhukariyuu;
    }

    public void setIfcJidousoukinhukariyuu(String pIfcJidousoukinhukariyuu) {
        ifcJidousoukinhukariyuu = pIfcJidousoukinhukariyuu;
    }

    @Column(order = 13, label = "消滅時手続注意判定結果")
    private String ifcTtdktyuuihanteikekka;

    public String getIfcTtdktyuuihanteikekka() {
        return ifcTtdktyuuihanteikekka;
    }

    public void setIfcTtdktyuuihanteikekka(String pIfcTtdktyuuihanteikekka) {
        ifcTtdktyuuihanteikekka = pIfcTtdktyuuihanteikekka;
    }

    @Column(order = 14, label = "消滅時質権")
    private String ifcSitiken;

    public String getIfcSitiken() {
        return ifcSitiken;
    }

    public void setIfcSitiken(String pIfcSitiken) {
        ifcSitiken = pIfcSitiken;
    }

    @Column(order = 15, label = "（明細）消滅時円換算解約返戻金額合計")
    private String ifcKaiyakuhrknyen;

    public String getIfcKaiyakuhrknyen() {
        return ifcKaiyakuhrknyen;
    }

    public void setIfcKaiyakuhrknyen(String pIfcKaiyakuhrknyen) {
        ifcKaiyakuhrknyen = pIfcKaiyakuhrknyen;
    }

    @Column(order = 16, label = "（明細）消滅時その他精算金")
    private String ifcSonotaseisankin;

    public String getIfcSonotaseisankin() {
        return ifcSonotaseisankin;
    }

    public void setIfcSonotaseisankin(String pIfcSonotaseisankin) {
        ifcSonotaseisankin = pIfcSonotaseisankin;
    }

    @Column(order = 17, label = "（明細）消滅時配当金")
    private BizCurrency ifcYenkahaitoukinbizc;

    public BizCurrency getIfcYenkahaitoukinbizc() {
        return ifcYenkahaitoukinbizc;
    }

    public void setIfcYenkahaitoukinbizc(BizCurrency pIfcYenkahaitoukinbizc) {
        ifcYenkahaitoukinbizc = pIfcYenkahaitoukinbizc;
    }

    @Column(order = 18, label = "（明細）消滅時特別配当金")
    private BizCurrency ifcYenkasonotahaitoukinbizc;

    public BizCurrency getIfcYenkasonotahaitoukinbizc() {
        return ifcYenkasonotahaitoukinbizc;
    }

    public void setIfcYenkasonotahaitoukinbizc(BizCurrency pIfcYenkasonotahaitoukinbizc) {
        ifcYenkasonotahaitoukinbizc = pIfcYenkasonotahaitoukinbizc;
    }

    @Column(order = 19, label = "消滅時為替レート")
    private BizNumber ifcShrkwsrate;

    public BizNumber getIfcShrkwsrate() {
        return ifcShrkwsrate;
    }

    public void setIfcShrkwsrate(BizNumber pIfcShrkwsrate) {
        ifcShrkwsrate = pIfcShrkwsrate;
    }

    @Column(order = 20, label = "指定通貨種類")
    private String ifcSiteituuka;

    public String getIfcSiteituuka() {
        return ifcSiteituuka;
    }

    public void setIfcSiteituuka(String pIfcSiteituuka) {
        ifcSiteituuka = pIfcSiteituuka;
    }

    @Column(order = 21, label = "①（②＋③）（（明細）消滅時指定通貨解約返戻金額合計）")
    private String ifcKaiyakuhrkngkkeigaika;

    public String getIfcKaiyakuhrkngkkeigaika() {
        return ifcKaiyakuhrkngkkeigaika;
    }

    public void setIfcKaiyakuhrkngkkeigaika(String pIfcKaiyakuhrkngkkeigaika) {
        ifcKaiyakuhrkngkkeigaika = pIfcKaiyakuhrkngkkeigaika;
    }

    @Column(order = 22, label = "②（明細）消滅時指定通貨解約返戻金")
    private String ifcKaiyakuhrkngaika;

    public String getIfcKaiyakuhrkngaika() {
        return ifcKaiyakuhrkngaika;
    }

    public void setIfcKaiyakuhrkngaika(String pIfcKaiyakuhrkngaika) {
        ifcKaiyakuhrkngaika = pIfcKaiyakuhrkngaika;
    }

    @Column(order = 23, label = "③（明細）消滅時指定通貨契約変更時返戻金")
    private BizCurrency ifcZitkazkrknsiteituukabizc;

    public BizCurrency getIfcZitkazkrknsiteituukabizc() {
        return ifcZitkazkrknsiteituukabizc;
    }

    public void setIfcZitkazkrknsiteituukabizc(BizCurrency pIfcZitkazkrknsiteituukabizc) {
        ifcZitkazkrknsiteituukabizc = pIfcZitkazkrknsiteituukabizc;
    }

    @Column(order = 24, label = "作成日")
    private BizDate ifcSakuseiymd;

    public BizDate getIfcSakuseiymd() {
        return ifcSakuseiymd;
    }

    public void setIfcSakuseiymd(BizDate pIfcSakuseiymd) {
        ifcSakuseiymd = pIfcSakuseiymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
