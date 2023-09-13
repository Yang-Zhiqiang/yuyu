package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）前納精算金明細リストＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhZennouseisankinMeisaiLstCsvfFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhZennouseisankinMeisaiLstCsvfFile() {
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

    @Column(order = 6, label = "処理コード")
    private String ifcSyoricd;

    public String getIfcSyoricd() {
        return ifcSyoricd;
    }

    public void setIfcSyoricd(String pIfcSyoricd) {
        ifcSyoricd = pIfcSyoricd;
    }

    @Column(order = 7, label = "セグメントコード")
    private String ifcSegcd;

    public String getIfcSegcd() {
        return ifcSegcd;
    }

    public void setIfcSegcd(String pIfcSegcd) {
        ifcSegcd = pIfcSegcd;
    }

    @Column(order = 8, label = "保険種類レベル")
    private String ifcHknsyuruilevel;

    public String getIfcHknsyuruilevel() {
        return ifcHknsyuruilevel;
    }

    public void setIfcHknsyuruilevel(String pIfcHknsyuruilevel) {
        ifcHknsyuruilevel = pIfcHknsyuruilevel;
    }

    @Column(order = 9, label = "備金確定年月日")
    private String ifcBknkktiymdseireki;

    public String getIfcBknkktiymdseireki() {
        return ifcBknkktiymdseireki;
    }

    public void setIfcBknkktiymdseireki(String pIfcBknkktiymdseireki) {
        ifcBknkktiymdseireki = pIfcBknkktiymdseireki;
    }

    @Column(order = 10, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 11, label = "前納精算金")
    private String ifcZennouseisankin;

    public String getIfcZennouseisankin() {
        return ifcZennouseisankin;
    }

    public void setIfcZennouseisankin(String pIfcZennouseisankin) {
        ifcZennouseisankin = pIfcZennouseisankin;
    }

    @Column(order = 12, label = "ミス表示")
    private String ifcMissuhyj;

    public String getIfcMissuhyj() {
        return ifcMissuhyj;
    }

    public void setIfcMissuhyj(String pIfcMissuhyj) {
        ifcMissuhyj = pIfcMissuhyj;
    }

    @Column(order = 13, label = "備考")
    private String ifcBikou;

    public String getIfcBikou() {
        return ifcBikou;
    }

    public void setIfcBikou(String pIfcBikou) {
        ifcBikou = pIfcBikou;
    }

    @Column(order = 14, label = "円貨前納精算金")
    private BizCurrency ifcYenkazennouseisankgkbizc;

    public BizCurrency getIfcYenkazennouseisankgkbizc() {
        return ifcYenkazennouseisankgkbizc;
    }

    public void setIfcYenkazennouseisankgkbizc(BizCurrency pIfcYenkazennouseisankgkbizc) {
        ifcYenkazennouseisankgkbizc = pIfcYenkazennouseisankgkbizc;
    }

    @Column(order = 15, label = "外貨支払時為替レート基準日")
    private String ifcGaikashrkwsratekjnymd;

    public String getIfcGaikashrkwsratekjnymd() {
        return ifcGaikashrkwsratekjnymd;
    }

    public void setIfcGaikashrkwsratekjnymd(String pIfcGaikashrkwsratekjnymd) {
        ifcGaikashrkwsratekjnymd = pIfcGaikashrkwsratekjnymd;
    }

    @Column(order = 16, label = "外貨支払時為替レート")
    private BizNumber ifcGaikashrkwsrate;

    public BizNumber getIfcGaikashrkwsrate() {
        return ifcGaikashrkwsrate;
    }

    public void setIfcGaikashrkwsrate(BizNumber pIfcGaikashrkwsrate) {
        ifcGaikashrkwsrate = pIfcGaikashrkwsrate;
    }

    @Column(order = 17, label = "外貨前納精算金")
    private String ifcGaikazennouseisankin;

    public String getIfcGaikazennouseisankin() {
        return ifcGaikazennouseisankin;
    }

    public void setIfcGaikazennouseisankin(String pIfcGaikazennouseisankin) {
        ifcGaikazennouseisankin = pIfcGaikazennouseisankin;
    }

    @Column(order = 18, label = "支払時為替レート基準日")
    private String ifcShrkwsratekjnymdseireki;

    public String getIfcShrkwsratekjnymdseireki() {
        return ifcShrkwsratekjnymdseireki;
    }

    public void setIfcShrkwsratekjnymdseireki(String pIfcShrkwsratekjnymdseireki) {
        ifcShrkwsratekjnymdseireki = pIfcShrkwsratekjnymdseireki;
    }

    @Column(order = 19, label = "支払時為替レート")
    private BizNumber ifcShrkwsrate;

    public BizNumber getIfcShrkwsrate() {
        return ifcShrkwsrate;
    }

    public void setIfcShrkwsrate(BizNumber pIfcShrkwsrate) {
        ifcShrkwsrate = pIfcShrkwsrate;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
