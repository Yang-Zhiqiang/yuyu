package yuyu.def.sinkeiyaku.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）一括入金為替差益レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkIktNknKwsSekLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkIktNknKwsSekLayoutFile() {
    }


    @Column(order = 1, label = "領収通貨種類")
    private String ifcRstuukasyu;


    public String getIfcRstuukasyu() {
        return ifcRstuukasyu;
    }


    public void setIfcRstuukasyu(String pIfcRstuukasyu) {
        ifcRstuukasyu = pIfcRstuukasyu;
    }


    @Column(order = 2, label = "連番")
    private String ifcRennoStr;


    public String getIfcRennoStr() {
        return ifcRennoStr;
    }


    public void setIfcRennoStr(String pIfcRennoStr) {
        ifcRennoStr = pIfcRennoStr;
    }


    @Column(order = 3, label = "明細区分")
    private String ifcMeisaikbn;


    public String getIfcMeisaikbn() {
        return ifcMeisaikbn;
    }


    public void setIfcMeisaikbn(String pIfcMeisaikbn) {
        ifcMeisaikbn = pIfcMeisaikbn;
    }


    @Column(order = 4, label = "契約通貨種類")
    private String ifcKyktuukasyu;


    public String getIfcKyktuukasyu() {
        return ifcKyktuukasyu;
    }


    public void setIfcKyktuukasyu(String pIfcKyktuukasyu) {
        ifcKyktuukasyu = pIfcKyktuukasyu;
    }


    @Column(order = 5, label = "領収日")
    private String ifcRyosyuymd;


    public String getIfcRyosyuymd() {
        return ifcRyosyuymd;
    }


    public void setIfcRyosyuymd(String pIfcRyosyuymd) {
        ifcRyosyuymd = pIfcRyosyuymd;
    }


    @Column(order = 6, label = "入金用親代理店名")
    private String ifcOyadrtennm;


    public String getIfcOyadrtennm() {
        return ifcOyadrtennm;
    }


    public void setIfcOyadrtennm(String pIfcOyadrtennm) {
        ifcOyadrtennm = pIfcOyadrtennm;
    }


    @Column(order = 7, label = "口座番号")
    private String ifcKouzano;


    public String getIfcKouzano() {
        return ifcKouzano;
    }


    public void setIfcKouzano(String pIfcKouzano) {
        ifcKouzano = pIfcKouzano;
    }


    @Column(order = 8, label = "為替レート")
    private String ifcKawaserate;


    public String getIfcKawaserate() {
        return ifcKawaserate;
    }


    public void setIfcKawaserate(String pIfcKawaserate) {
        ifcKawaserate = pIfcKawaserate;
    }


    @Column(order = 9, label = "一括入金額")
    private String ifcGrossnykngk;


    public String getIfcGrossnykngk() {
        return ifcGrossnykngk;
    }


    public void setIfcGrossnykngk(String pIfcGrossnykngk) {
        ifcGrossnykngk = pIfcGrossnykngk;
    }


    @Column(order = 10, label = "一括入金伝票金額")
    private String ifcGrossdengk;


    public String getIfcGrossdengk() {
        return ifcGrossdengk;
    }


    public void setIfcGrossdengk(String pIfcGrossdengk) {
        ifcGrossdengk = pIfcGrossdengk;
    }


    @Column(order = 11, label = "明細合計伝票金額")
    private String ifcMeisaigoukeidengk;


    public String getIfcMeisaigoukeidengk() {
        return ifcMeisaigoukeidengk;
    }


    public void setIfcMeisaigoukeidengk(String pIfcMeisaigoukeidengk) {
        ifcMeisaigoukeidengk = pIfcMeisaigoukeidengk;
    }


    @Column(order = 12, label = "為替差益")
    private String ifcKawasesaeki;


    public String getIfcKawasesaeki() {
        return ifcKawasesaeki;
    }


    public void setIfcKawasesaeki(String pIfcKawasesaeki) {
        ifcKawasesaeki = pIfcKawasesaeki;
    }


    @Column(order = 13, label = "申込番号")
    private String ifcMosno;


    public String getIfcMosno() {
        return ifcMosno;
    }


    public void setIfcMosno(String pIfcMosno) {
        ifcMosno = pIfcMosno;
    }


    @Column(order = 14, label = "領収金額")
    private String ifcRsgaku;


    public String getIfcRsgaku() {
        return ifcRsgaku;
    }


    public void setIfcRsgaku(String pIfcRsgaku) {
        ifcRsgaku = pIfcRsgaku;
    }


    @Column(order = 15, label = "伝票金額")
    private String ifcDengk;


    public String getIfcDengk() {
        return ifcDengk;
    }


    public void setIfcDengk(String pIfcDengk) {
        ifcDengk = pIfcDengk;
    }


    @Column(order = 16, label = "申込状態")
    private String ifcMosstatus;


    public String getIfcMosstatus() {
        return ifcMosstatus;
    }


    public void setIfcMosstatus(String pIfcMosstatus) {
        ifcMosstatus = pIfcMosstatus;
    }


    @Column(order = 17, label = "合計為替差益")
    private String ifcTotalkawasesaeki;


    public String getIfcTotalkawasesaeki() {
        return ifcTotalkawasesaeki;
    }


    public void setIfcTotalkawasesaeki(String pIfcTotalkawasesaeki) {
        ifcTotalkawasesaeki = pIfcTotalkawasesaeki;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
