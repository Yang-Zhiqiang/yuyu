package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）時効伝票明細リストレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiJikouDenMeisaiListLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiJikouDenMeisaiListLayoutFile() {
    }


    @Column(order = 1, label = "リスト名")
    private String ifcListnm;


    public String getIfcListnm() {
        return ifcListnm;
    }


    public void setIfcListnm(String pIfcListnm) {
        ifcListnm = pIfcListnm;
    }


    @Column(order = 2, label = "宛先")
    private String ifcAtesaki;


    public String getIfcAtesaki() {
        return ifcAtesaki;
    }


    public void setIfcAtesaki(String pIfcAtesaki) {
        ifcAtesaki = pIfcAtesaki;
    }


    @Column(order = 3, label = "作成年月日")
    private String ifcSakuseiymdseireki;


    public String getIfcSakuseiymdseireki() {
        return ifcSakuseiymdseireki;
    }


    public void setIfcSakuseiymdseireki(String pIfcSakuseiymdseireki) {
        ifcSakuseiymdseireki = pIfcSakuseiymdseireki;
    }


    @Column(order = 4, label = "ページ番号")
    private String ifcPageno;


    public String getIfcPageno() {
        return ifcPageno;
    }


    public void setIfcPageno(String pIfcPageno) {
        ifcPageno = pIfcPageno;
    }


    @Column(order = 5, label = "決算年度")
    private String ifcKessannnd;


    public String getIfcKessannnd() {
        return ifcKessannnd;
    }


    public void setIfcKessannnd(String pIfcKessannnd) {
        ifcKessannnd = pIfcKessannnd;
    }


    @Column(order = 6, label = "セグメントコード")
    private String ifcKbnkeirisegcd;


    public String getIfcKbnkeirisegcd() {
        return ifcKbnkeirisegcd;
    }


    public void setIfcKbnkeirisegcd(String pIfcKbnkeirisegcd) {
        ifcKbnkeirisegcd = pIfcKbnkeirisegcd;
    }


    @Column(order = 7, label = "保険種類レベル")
    private String ifcHknsyruilevelcd;


    public String getIfcHknsyruilevelcd() {
        return ifcHknsyruilevelcd;
    }


    public void setIfcHknsyruilevelcd(String pIfcHknsyruilevelcd) {
        ifcHknsyruilevelcd = pIfcHknsyruilevelcd;
    }


    @Column(order = 8, label = "備金コード")
    private String ifcSyoricd;


    public String getIfcSyoricd() {
        return ifcSyoricd;
    }


    public void setIfcSyoricd(String pIfcSyoricd) {
        ifcSyoricd = pIfcSyoricd;
    }


    @Column(order = 9, label = "証券番号")
    private String ifcSyono;


    public String getIfcSyono() {
        return ifcSyono;
    }


    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }


    @Column(order = 10, label = "備金確定年月日")
    private String ifcBknkktiymdseireki;


    public String getIfcBknkktiymdseireki() {
        return ifcBknkktiymdseireki;
    }


    public void setIfcBknkktiymdseireki(String pIfcBknkktiymdseireki) {
        ifcBknkktiymdseireki = pIfcBknkktiymdseireki;
    }


    @Column(order = 11, label = "貸付金額")
    private String ifcKasitukekgk;


    public String getIfcKasitukekgk() {
        return ifcKasitukekgk;
    }


    public void setIfcKasitukekgk(String pIfcKasitukekgk) {
        ifcKasitukekgk = pIfcKasitukekgk;
    }


    @Column(order = 12, label = "立替金額")
    private String ifcTatekaekgk;


    public String getIfcTatekaekgk() {
        return ifcTatekaekgk;
    }


    public void setIfcTatekaekgk(String pIfcTatekaekgk) {
        ifcTatekaekgk = pIfcTatekaekgk;
    }


    @Column(order = 13, label = "仮受金額")
    private String ifcKrkgk;


    public String getIfcKrkgk() {
        return ifcKrkgk;
    }


    public void setIfcKrkgk(String pIfcKrkgk) {
        ifcKrkgk = pIfcKrkgk;
    }


    @Column(order = 14, label = "仮払金額")
    private String ifcKaribaraikgk;


    public String getIfcKaribaraikgk() {
        return ifcKaribaraikgk;
    }


    public void setIfcKaribaraikgk(String pIfcKaribaraikgk) {
        ifcKaribaraikgk = pIfcKaribaraikgk;
    }


    @Column(order = 15, label = "雑収入金額")
    private String ifcZatusyunyukgk;


    public String getIfcZatusyunyukgk() {
        return ifcZatusyunyukgk;
    }


    public void setIfcZatusyunyukgk(String pIfcZatusyunyukgk) {
        ifcZatusyunyukgk = pIfcZatusyunyukgk;
    }


    @Column(order = 16, label = "保険金・返戻金")
    private String ifcHkgk;


    public String getIfcHkgk() {
        return ifcHkgk;
    }


    public void setIfcHkgk(String pIfcHkgk) {
        ifcHkgk = pIfcHkgk;
    }


    @Column(order = 17, label = "備考")
    private String ifcBikou1;


    public String getIfcBikou1() {
        return ifcBikou1;
    }


    public void setIfcBikou1(String pIfcBikou1) {
        ifcBikou1 = pIfcBikou1;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
